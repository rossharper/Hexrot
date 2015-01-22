package net.rossharper.hexrot.android;

import android.app.Fragment;
import android.app.FragmentManager;

import net.rossharper.otto.Bus;
import net.rossharper.otto.Subscribe;

/**
 * Created by harper05 on 22/01/2015.
 */
public class AndroidScreenManager implements ScreenManager {
    private int mRootContainerId;
    private Bus mNavigationBus;
    private FragmentManager mFragmentManager;

    public AndroidScreenManager(Bus navigationBus, FragmentManager fragmentManager, int rootContainerId) {
        mNavigationBus = navigationBus;
        mFragmentManager = fragmentManager;
        mRootContainerId = rootContainerId;
    }

    @Subscribe
    public void handleScreenDisplayEvent(ScreenDisplayEvent screenDisplayEvent) {
        displayScreen(screenDisplayEvent.getScreenFactory());
    }

    @Override
    public void displayScreen(ScreenFactory screenFactory) {
        mFragmentManager.beginTransaction().replace(mRootContainerId, (Fragment) screenFactory.getScreen()).addToBackStack(null).commit();
    }

    public void onStart() {
        mNavigationBus.register(this);
    }

    public void onStop() {
        mNavigationBus.unregister(this);
    }
}
