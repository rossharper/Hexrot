package net.rossharper.hexrot.sodalist;

import net.rossharper.hexrot.HomeScreenDisplayEventFactory;
import net.rossharper.hexrot.sodadetails.SodaDetailsScreenDisplayEventFactory;

public class SodaListController {
    private SodaListView mSodaListView;
    private SodaListProvider mSodaListProvider;
    private SodaList mSodaList;
    private SodaDetailsScreenDisplayEventFactory mSodaDetailsScreenDisplayEventFactory;

    public SodaListController(SodaListView sodaListView, SodaListProvider sodaListProvider, SodaDetailsScreenDisplayEventFactory sodaDetailsScreenDisplayEventFactory) {
        mSodaListView = sodaListView;
        mSodaListProvider = sodaListProvider;
        mSodaDetailsScreenDisplayEventFactory = sodaDetailsScreenDisplayEventFactory;
    }

    public void onReady() {
        mSodaListProvider.getSodas(new SodaListProviderListener() {
            @Override
            public void sodaListReceived(SodaList sodaList) {
                mSodaList = sodaList;
                mSodaListView.displaySodaList(sodaList);
            }
        });
    }

    public void onItemClick(int position) {
        mSodaDetailsScreenDisplayEventFactory.emitDisplayScreenEvent(mSodaList.get(position));
    }
}
