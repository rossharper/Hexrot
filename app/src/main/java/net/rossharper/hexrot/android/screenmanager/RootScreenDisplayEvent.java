package net.rossharper.hexrot.android.screenmanager;

import net.rossharper.hexrot.android.screenmanager.ScreenDisplayEvent;
import net.rossharper.hexrot.android.screenmanager.ScreenFactory;

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
