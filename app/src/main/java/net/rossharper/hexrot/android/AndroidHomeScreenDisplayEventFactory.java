package net.rossharper.hexrot.android;

import net.rossharper.hexrot.HomeScreenDisplayEventFactory;
import net.rossharper.otto.Bus;

public class AndroidHomeScreenDisplayEventFactory implements HomeScreenDisplayEventFactory {
    private Bus mNavigationBus;

    public AndroidHomeScreenDisplayEventFactory(Bus navigationBus) {
        mNavigationBus = navigationBus;
    }

    @Override
    public void emitEvent() {
        mNavigationBus.post(new ScreenDisplayEvent(new SodaListScreenFactory()));
    }
}
