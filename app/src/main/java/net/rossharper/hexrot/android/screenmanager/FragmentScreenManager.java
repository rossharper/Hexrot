package net.rossharper.hexrot.android.screenmanager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import net.rossharper.hexrot.ScreenFactory;
import net.rossharper.hexrot.ScreenManager;

public class FragmentScreenManager implements ScreenManager<Fragment> {
    private int mRootContainerId;
    private FragmentManager mFragmentManager;

    public FragmentScreenManager(FragmentManager fragmentManager, int rootContainerId) {
        mFragmentManager = fragmentManager;
        mRootContainerId = rootContainerId;
    }

    public void displayRootScreen(ScreenFactory<Fragment> screenFactory) {
        createFragmentTransactionForScreen(screenFactory).commit();
    }

    public void displayStackedScreen(ScreenFactory<Fragment> screenFactory) {
        createFragmentTransactionForScreen(screenFactory).addToBackStack(null).commit();
    }

    private FragmentTransaction createFragmentTransactionForScreen(ScreenFactory<Fragment> screenFactory) {
        return mFragmentManager.beginTransaction().replace(mRootContainerId, screenFactory.getScreen());
    }
}
