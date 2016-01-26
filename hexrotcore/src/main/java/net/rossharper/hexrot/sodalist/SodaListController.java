package net.rossharper.hexrot.sodalist;

import net.rossharper.hexrot.sodaprovider.SodaListProvider;
import net.rossharper.hexrot.sodaprovider.SodaListProviderListener;

public class SodaListController {
    private final SodaListView mSodaListView;
    private final SodaListProvider mSodaListProvider;

    public SodaListController(SodaListView sodaListView,
                              SodaListProvider sodaListProvider) {

        mSodaListView = sodaListView;
        mSodaListProvider = sodaListProvider;
    }

    public void onReady() {
        mSodaListProvider.getSodas(new SodaListProviderListener() {
            @Override
            public void sodaListReceived(SodaList sodaList) {
                mSodaListView.displaySodaList(sodaList);
            }

            @Override
            public void sodaListFetchError() {
                mSodaListView.displaySodaListFetchError();
            }
        });
    }
}
