package net.rossharper.hexrot.android;

import net.rossharper.hexrot.HomeScreenDisplayEventFactory;
import net.rossharper.hexrot.android.screenmanager.NavigationBus;
import net.rossharper.hexrot.android.screenmanager.RootScreenDisplayEvent;
import net.rossharper.hexrot.android.sodalist.SodaListScreenFactory;

public class AndroidHomeScreenDisplayEventFactory implements HomeScreenDisplayEventFactory {
    @Override
    public void emitDisplayScreenEvent() {
        NavigationBus.getEventBus().post(new RootScreenDisplayEvent(new SodaListScreenFactory()));
    }
}
