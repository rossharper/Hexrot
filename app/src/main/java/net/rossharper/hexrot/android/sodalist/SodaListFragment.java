package net.rossharper.hexrot.android.sodalist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.rossharper.collectionview.CollectionModelDataAdapter;
import net.rossharper.collectionview.CollectionView;
import net.rossharper.collectionview.CollectionViewPresenter;
import net.rossharper.collectionview.DataProvider;
import net.rossharper.collectionview.DataProviderListener;
import net.rossharper.hexrot.ApplicationController;
import net.rossharper.hexrot.R;
import net.rossharper.hexrot.android.app.SingleActivityApplication;
import net.rossharper.hexrot.android.app.AppConfig;
import net.rossharper.hexrot.android.sodalist.collectionview.SodaListCollectionModelDataAdapterFactory;
import net.rossharper.hexrot.sodalist.SodaList;
import net.rossharper.hexrot.sodaprovider.SodaListProvider;
import net.rossharper.hexrot.sodaprovider.SodaListProviderConfig;
import net.rossharper.hexrot.sodaprovider.SodaListProviderFactory;
import net.rossharper.hexrot.sodaprovider.SodaListProviderListener;

public class SodaListFragment extends Fragment {

    private CollectionView mCollectionView;
    private CollectionViewPresenter mCollectionViewPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soda_list_fragment, container, false);

        mCollectionView = (CollectionView) view.findViewById(R.id.collectionView);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        final ApplicationController applicationController = ((SingleActivityApplication)getActivity()).getApplicationController();

        final SodaListProviderConfig config = new SodaListProviderConfig() {
            @Override
            public String getSodaListUrl() {
                return AppConfig.SODA_LIST_URL;
            }
        };

        final SodaListProviderFactory sodaListProviderFactory = new SodaListProviderFactory();

        DataProvider dataProvider = new DataProvider() {
            SodaListProvider mSodaListProvider =
                    sodaListProviderFactory.createSodaListProvider(
                            applicationController.getNetworkingFactory(),
                            config);

            @Override
            public void loadData(final DataProviderListener listener) {
                mSodaListProvider.getSodas(new SodaListProviderListener() {
                    @Override
                    public void sodaListReceived(SodaList sodaList) {
                        listener.onLoad(sodaList.getAsList());
                    }

                    @Override
                    public void sodaListFetchError() {
                        listener.onError();
                    }
                });
            }
        };

        CollectionModelDataAdapter collectionModelDataAdapter
                = SodaListCollectionModelDataAdapterFactory.createCollectionModelDataAdapter(
                applicationController.getScreenManager());

        mCollectionViewPresenter = new CollectionViewPresenter(mCollectionView, dataProvider, collectionModelDataAdapter);
        mCollectionViewPresenter.onReady();
    }
}
