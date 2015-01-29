package net.rossharper.hexrot.android;

public class RootScreenDisplayEvent implements ScreenDisplayEvent {
    private final ScreenFactory mScreenFactory;

    public RootScreenDisplayEvent(ScreenFactory screenFactory) {
        this.mScreenFactory = screenFactory;
    }

    @Override
    public ScreenFactory getScreenFactory() {
        return mScreenFactory;
    }
}
