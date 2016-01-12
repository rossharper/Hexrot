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

    public void displayRootScreen(ScreenFactory screenFactory) {
        createFragmentTransactionForScreen(screenFactory).commit();
    }

    public void displayStackedScreen(ScreenFactory screenFactory) {
        createFragmentTransactionForScreen(screenFactory).addToBackStack(null).commit();
    }

    private FragmentTransaction createFragmentTransactionForScreen(ScreenFactory screenFactory) {
        return mFragmentManager.beginTransaction().replace(mRootContainerId, screenFactory.getScreen());
    }
}
