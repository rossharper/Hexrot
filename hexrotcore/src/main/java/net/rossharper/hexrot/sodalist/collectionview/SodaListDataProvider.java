package net.rossharper.hexrot.sodalist.collectionview;

import net.rossharper.collectionview.DataProvider;
import net.rossharper.collectionview.DataProviderListener;
import net.rossharper.hexrot.sodalist.SodaList;
import net.rossharper.hexrot.sodaprovider.SodaListProvider;
import net.rossharper.hexrot.sodaprovider.SodaListProviderListener;

public class SodaListDataProvider implements DataProvider {
    private SodaListProvider sodaListProvider;

    public SodaListDataProvider(SodaListProvider sodaListProvider) {
        this.sodaListProvider = sodaListProvider;
    }

    @Override
    public void loadData(final DataProviderListener listener) {
        sodaListProvider.getSodas(new SodaListProviderListener() {
            @Override
            public void sodaListReceived(final SodaList sodaList) {
                listener.onLoad(sodaList.getAsList());
            }

            @Override
            public void sodaListFetchError() {
                listener.onError();
            }
        });
    }
}
