package net.rossharper.hexrot.android;

import android.app.FragmentManager;

import com.squareup.otto.Subscribe;

public class ScreenManager {
    private int mRootContainerId;
    private FragmentManager mFragmentManager;

    public ScreenManager(FragmentManager fragmentManager, int rootContainerId) {
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
        NavigationBus.getInstance().register(this);
    }

    public void onStop() {
        NavigationBus.getInstance().unregister(this);
    }
}
