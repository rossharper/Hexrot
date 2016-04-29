package net.rossharper.hexrot.android.sodalist.collectionview;

import net.rossharper.collectionview.CollectionModelDataAdapter;
import net.rossharper.collectionview.CollectionView;
import net.rossharper.collectionview.CollectionViewPresenter;
import net.rossharper.collectionview.DataProvider;
import net.rossharper.hexrot.Application;
import net.rossharper.hexrot.android.sodadetails.SodaDetailsScreenDisplayCommandFactory;
import net.rossharper.hexrot.sodalist.collectionview.SodaListCollectionModelDataAdapterFactory;
import net.rossharper.hexrot.sodalist.collectionview.SodaListDataProvider;
import net.rossharper.hexrot.sodaprovider.SodaListProviderConfig;
import net.rossharper.hexrot.sodaprovider.SodaListProviderFactory;

public class SodaListCollectionViewPresenterFactory {
    public CollectionViewPresenter create(
            final Application application,
            CollectionView collectionView) {
        final SodaListProviderConfig config = new SodaListProviderConfig() {
            @Override
            public String getSodaListUrl() {
                return application.getAppConfig().getConfigString("SODA_LIST_URL");
            }
        };

        DataProvider dataProvider = new SodaListDataProvider(
                new SodaListProviderFactory().createSodaListProvider(
                        application.getNetworkingFactory(),
                        config));

        SodaDetailsScreenDisplayCommandFactory detailsScreenDisplayCommandFactory =
                new SodaDetailsScreenDisplayCommandFactory(application.getScreenManager());

        CollectionModelDataAdapter collectionModelDataAdapter
                = SodaListCollectionModelDataAdapterFactory.createCollectionModelDataAdapter(
                detailsScreenDisplayCommandFactory,
                new SodaItemViewFactory());

        return new CollectionViewPresenter(collectionView, dataProvider, collectionModelDataAdapter);
    }
}
