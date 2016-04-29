package net.rossharper.hexrot.android.sodalist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.rossharper.collectionview.CollectionView;
import net.rossharper.collectionview.CollectionViewPresenter;
import net.rossharper.hexrot.Application;
import net.rossharper.hexrot.R;
import net.rossharper.hexrot.android.app.SingleActivityApplication;
import net.rossharper.hexrot.android.sodalist.collectionview.SodaListCollectionViewPresenterFactory;

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

        final Application application = ((SingleActivityApplication)getActivity()).getApplicationController();

        mCollectionViewPresenter = new SodaListCollectionViewPresenterFactory().create(
                application,
                mCollectionView);

        mCollectionViewPresenter.onReady();
    }

}
