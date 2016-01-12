package net.rossharper.hexrot.android.screenmanager;

import com.squareup.otto.Subscribe;

/**
 * Created by harper05 on 12/01/16.
 */
public class ScreenDisplayEventHandler {

    private ScreenManager screenManager;

    public ScreenDisplayEventHandler(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    @Subscribe
    public void handleRootScreenDisplayEvent(RootScreenDisplayEvent screenDisplayEvent) {
        screenManager.displayRootScreen(screenDisplayEvent.getScreenFactory());
    }

    @Subscribe
    public void handleStackedScreenDisplayEvent(StackedScreenDisplayEvent screenDisplayEvent) {
        screenManager.displayStackedScreen(screenDisplayEvent.getScreenFactory());
    }

    public void onStart() {
        NavigationBus.getEventBus().register(this);
    }

    public void onStop() {
        NavigationBus.getEventBus().unregister(this);
    }
}
