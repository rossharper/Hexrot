package net.rossharper.hexrot.android;

import net.rossharper.hexrot.HomeScreenDisplayEventFactory;
import net.rossharper.hexrot.android.sodalist.SodaListScreenFactory;

public class AndroidHomeScreenDisplayEventFactory implements HomeScreenDisplayEventFactory {
    @Override
    public void emitDisplayScreenEvent() {
        NavigationBus.getInstance().post(new RootScreenDisplayEvent(new SodaListScreenFactory()));
    }
}
