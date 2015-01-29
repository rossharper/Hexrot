package net.rossharper.hexrot.android;

import com.squareup.otto.Bus;

import net.rossharper.hexrot.HomeScreenDisplayEventFactory;
import net.rossharper.hexrot.android.sodalist.SodaListScreenFactory;

public class AndroidHomeScreenDisplayEventFactory implements HomeScreenDisplayEventFactory {
    private Bus mNavigationBus;

    public AndroidHomeScreenDisplayEventFactory(Bus navigationBus) {
        mNavigationBus = navigationBus;
    }

    @Override
    public void emitDisplayScreenEvent() {
        mNavigationBus.post(new ScreenDisplayEvent(new SodaListScreenFactory()));
    }
}
