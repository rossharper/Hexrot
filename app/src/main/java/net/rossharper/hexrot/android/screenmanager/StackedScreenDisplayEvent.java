package net.rossharper.hexrot.android.screenmanager;

public class StackedScreenDisplayEvent implements ScreenDisplayEvent {
    private ScreenFactory mScreenFactory;

    public StackedScreenDisplayEvent(ScreenFactory screenFactory) {
        this.mScreenFactory = screenFactory;
    }

    @Override
    public ScreenFactory getScreenFactory() {
        return mScreenFactory;
    }
}