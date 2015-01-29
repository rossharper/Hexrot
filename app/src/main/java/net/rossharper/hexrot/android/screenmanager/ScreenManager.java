package net.rossharper.hexrot.android.screenmanager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.squareup.otto.Subscribe;

public class ScreenManager {
    private int mRootContainerId;
    private FragmentManager mFragmentManager;

    public ScreenManager(FragmentManager fragmentManager, int rootContainerId) {
        mFragmentManager = fragmentManager;
        mRootContainerId = rootContainerId;
    }

    @Subscribe
    public void handleRootScreenDisplayEvent(RootScreenDisplayEvent screenDisplayEvent) {
        displayRootScreen(screenDisplayEvent.getScreenFactory());
    }

    @Subscribe
    public void handleStackedScreenDisplayEvent(StackedScreenDisplayEvent screenDisplayEvent) {
        displayStackedScreen(screenDisplayEvent.getScreenFactory());
    }

    private void displayRootScreen(ScreenFactory screenFactory) {
        createFragmentTransactionForScreen(screenFactory).commit();
    }

    private void displayStackedScreen(ScreenFactory screenFactory) {
        createFragmentTransactionForScreen(screenFactory).addToBackStack(null).commit();
    }

    private FragmentTransaction createFragmentTransactionForScreen(ScreenFactory screenFactory) {
        return mFragmentManager.beginTransaction().replace(mRootContainerId, screenFactory.getScreen());
    }

    public void onStart() {
        NavigationBus.getEventBus().register(this);
    }

    public void onStop() {
        NavigationBus.getEventBus().unregister(this);
    }
}
