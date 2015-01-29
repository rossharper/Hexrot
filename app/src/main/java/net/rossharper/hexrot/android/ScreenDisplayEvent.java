package net.rossharper.hexrot.android;

public class ScreenDisplayEvent {
    private ScreenFactory mScreenFactory;

    public ScreenDisplayEvent(ScreenFactory screenFactory) {
        this.mScreenFactory = screenFactory;
    }

    public ScreenFactory getScreenFactory() {
        return mScreenFactory;
    }
}
