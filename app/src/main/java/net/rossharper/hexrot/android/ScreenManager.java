package net.rossharper.hexrot.android;

import android.app.FragmentManager;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class ScreenManager {
    private int mRootContainerId;
    private Bus mNavigationBus;
    private FragmentManager mFragmentManager;

    public ScreenManager(Bus navigationBus, FragmentManager fragmentManager, int rootContainerId) {
        mNavigationBus = navigationBus;
        mFragmentManager = fragmentManager;
        mRootContainerId = rootContainerId;
    }

    @Subscribe
    public void handleScreenDisplayEvent(ScreenDisplayEvent screenDisplayEvent) {
        displayScreen(screenDisplayEvent.getScreenFactory());
    }

    private void displayScreen(ScreenFactory screenFactory) {
        mFragmentManager.beginTransaction().replace(mRootContainerId, screenFactory.getScreen()).commit();
    }

    public void onStart() {
        mNavigationBus.register(this);
    }

    public void onStop() {
        mNavigationBus.unregister(this);
    }
}
