package net.rossharper.hexrot.android;

public class ScreenDisplayEvent {
    private SodaListScreenFactory mScreenFactory;

    public ScreenDisplayEvent(SodaListScreenFactory screenFactory) {
        this.mScreenFactory = screenFactory;
    }

    public SodaListScreenFactory getScreenFactory() {
        return mScreenFactory;
    }
}
