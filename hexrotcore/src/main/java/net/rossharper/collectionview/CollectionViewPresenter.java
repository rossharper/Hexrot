package net.rossharper.collectionview;

import java.util.List;

public class CollectionViewPresenter {
    private final CollectionView mView;
    private final DataProvider mDataProvider;
    private CollectionModelDataAdapter mDataAdapter;

    public CollectionViewPresenter(CollectionView view, DataProvider dataProvider, CollectionModelDataAdapter dataAdapter) {
        mView = view;
        mDataProvider = dataProvider;
        mDataAdapter = dataAdapter;
    }

    public void onReady() {
        mDataProvider.loadData(new DataProviderListener() {
            @Override
            public void onLoad(List<?> data) {
                mView.setCollectionModel(mDataAdapter.createCollectionModel(data));
            }

            @Override
            public void onError() {
                // TODO: how should errors be presented?
                // A view provided to here? A presenter provided to here?
                // what if I want a toast instead of a view?
            }
        });
    }
}
