package net.rossharper.hexrot.sodalist;

import net.rossharper.hexrot.sodadetails.SodaDetailsScreenDisplayCommandFactory;
import net.rossharper.hexrot.sodaprovider.SodaListProvider;
import net.rossharper.hexrot.sodaprovider.SodaListProviderListener;

public class SodaListController {
    private final SodaListView mSodaListView;
    private final SodaListProvider mSodaListProvider;
    private final SodaDetailsScreenDisplayCommandFactory mSodaDetailsScreenDisplayCommandFactory;

    private SodaList mSodaList; // TODO: can we (re)move this state?

    public SodaListController(SodaListView sodaListView,
                              SodaListProvider sodaListProvider,
                              SodaDetailsScreenDisplayCommandFactory sodaDetailsScreenDisplayCommandFactory) {

        mSodaListView = sodaListView;
        mSodaListProvider = sodaListProvider;
        mSodaDetailsScreenDisplayCommandFactory = sodaDetailsScreenDisplayCommandFactory;
    }

    public void onReady() {
        mSodaListProvider.getSodas(new SodaListProviderListener() {
            @Override
            public void sodaListReceived(SodaList sodaList) {
                mSodaList = sodaList;
                mSodaListView.displaySodaList(sodaList);
            }

            @Override
            public void sodaListFetchError() {
                mSodaListView.displaySodaListFetchError();
            }
        });
    }

    public void onItemClick(int position) {
        mSodaDetailsScreenDisplayCommandFactory.createWithData(mSodaList.get(position)).displayScreen();
    }
}
