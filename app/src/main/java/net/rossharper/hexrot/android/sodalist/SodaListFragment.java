package net.rossharper.hexrot.android.sodalist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import net.rossharper.collectionview.ItemViewModel;
import net.rossharper.collectionview.android.ClickListener;
import net.rossharper.collectionview.android.CollectionModel;
import net.rossharper.collectionview.android.ItemModel;
import net.rossharper.collectionview.android.ItemViewBinder;
import net.rossharper.collectionview.android.ItemViewFactory;
import net.rossharper.collectionview.android.ListViewCollectionView;
import net.rossharper.hexrot.R;
import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.android.app.AppConfig;
import net.rossharper.hexrot.android.app.ServiceLocator;
import net.rossharper.hexrot.android.network.OkHttpNetworkingFactory;
import net.rossharper.hexrot.android.screenmanager.ScreenManager;
import net.rossharper.hexrot.android.sodadetails.SodaDetailsScreenDisplayCommand;
import net.rossharper.hexrot.android.sodadetails.SodaDetailsScreenDisplayCommandFactory;
import net.rossharper.hexrot.android.sodalist.collectionview.SodaItemViewBinder;
import net.rossharper.hexrot.android.sodalist.collectionview.SodaItemViewFactory;
import net.rossharper.hexrot.android.sodalist.collectionview.SodaListItemViewModel;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.sodalist.SodaList;
import net.rossharper.hexrot.sodalist.SodaListController;
import net.rossharper.hexrot.sodalist.SodaListView;
import net.rossharper.hexrot.sodaprovider.SodaListProviderConfig;
import net.rossharper.hexrot.sodaprovider.SodaListProviderFactory;

import java.util.ArrayList;

public class SodaListFragment extends Fragment implements SodaListView {
    private SodaListController mController;

    private ListView mListView;
    private SodaListAdapter mListAdapter;
    private ListViewCollectionView mCollectionView;
    private SodaDetailsScreenDisplayCommandFactory mSodaDetailsScreenDisplayCommandFactory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soda_list_fragment, container, false);

        // TODO: create some sort of streamview that is abstracted from Android somewhat
        // uses recyclerview under the hood (Android Implementation)
        // data adapter from model to view model
        // view binders: view model bound onto views (cells)
        setupListView(view);

        return view;
    }

    private void setupListView(View view) {
        mListView = (ListView)view.findViewById(R.id.listView);
        mListAdapter = new SodaListAdapter(getActivity());
        mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mController.onItemClick(position);
            }
        });

        mCollectionView = (ListViewCollectionView)view.findViewById(R.id.collectionView);
    }

    @Override
    public void onStart() {
        super.onStart();

        SodaListProviderConfig config = new SodaListProviderConfig() {
            @Override
            public String getSodaListUrl() {
                return AppConfig.SODA_LIST_URL;
            }
        };

        final SodaListProviderFactory sodaListProviderFactory = new SodaListProviderFactory();

        mSodaDetailsScreenDisplayCommandFactory = new SodaDetailsScreenDisplayCommandFactory((ScreenManager) ServiceLocator.getService(ServiceLocator.SCREEN_MANAGER));
        mController = new SodaListController(
                this,
                sodaListProviderFactory.createSodaListProvider(new OkHttpNetworkingFactory(getActivity()), config),
                mSodaDetailsScreenDisplayCommandFactory);

        mController.onReady();
    }

    @Override
    public void displaySodaList(SodaList sodaList) {
        mListAdapter.setSodaList(sodaList);
        mCollectionView.setCollectionModel(createCollectionModel(sodaList));
    }

    private CollectionModel createCollectionModel(SodaList sodaList) {

        // TODO: factoryise this stuff. abstract types around data adapters for model conversion.

        ArrayList<ItemModel> itemModels = new ArrayList<ItemModel>();

        ItemViewFactory itemViewFactory = new SodaItemViewFactory(getActivity());
        for(final Soda soda : sodaList.getAsList()) {

            final ScreenDisplayCommand screenDisplayCommand = mSodaDetailsScreenDisplayCommandFactory.createWithData(soda);
            ItemViewBinder itemViewBinder = new SodaItemViewBinder(new ClickListener() {
                @Override
                public void onClick() {
                    screenDisplayCommand.displayScreen();
                }
            });
            ItemViewModel itemViewModel = new SodaListItemViewModel(soda.getName());
            itemModels.add(new ItemModel(itemViewFactory, itemViewBinder, itemViewModel));
        }

        return new CollectionModel(itemModels);
    }

    @Override
    public void displaySodaListFetchError() {
        Toast.makeText(getActivity(), R.string.soda_list_fetch_error, Toast.LENGTH_LONG).show();
    }
}
