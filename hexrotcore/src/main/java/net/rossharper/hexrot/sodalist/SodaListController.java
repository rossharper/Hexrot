package net.rossharper.hexrot.sodalist;

public class SodaListController {
    private SodaListView mSodaListView;
    private SodaListProvider mSodaListProvider;

    public SodaListController(SodaListView sodaListView, SodaListProvider sodaListProvider) {
        mSodaListView = sodaListView;
        mSodaListProvider = sodaListProvider;
    }

    public void onReady() {
        mSodaListProvider.getSodas(new SodaListProviderListener() {
            @Override
            public void sodaListReceived(SodaList sodaList) {

            }
        });
    }
}
