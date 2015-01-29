package net.rossharper.hexrot.android;

public class RootScreenDisplayEvent {
    private ScreenFactory mScreenFactory;

    public RootScreenDisplayEvent(ScreenFactory screenFactory) {
        this.mScreenFactory = screenFactory;
    }

    public ScreenFactory getScreenFactory() {
        return mScreenFactory;
    }
}
