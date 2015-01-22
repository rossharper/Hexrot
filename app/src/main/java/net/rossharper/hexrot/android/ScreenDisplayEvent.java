package net.rossharper.hexrot.android;

import net.rossharper.hexrot.android.sodalist.SodaListScreenFactory;

public class ScreenDisplayEvent {
    private SodaListScreenFactory mScreenFactory;

    public ScreenDisplayEvent(SodaListScreenFactory screenFactory) {
        this.mScreenFactory = screenFactory;
    }

    public SodaListScreenFactory getScreenFactory() {
        return mScreenFactory;
    }
}
