package net.rossharper.hexrot.android;

import android.app.Fragment;
import android.app.FragmentManager;

import net.rossharper.hexrot.ScreenFactory;
import net.rossharper.hexrot.ScreenManager;

/**
 * Created by harper05 on 22/01/2015.
 */
public class AndroidScreenManager implements ScreenManager {
    private int mRootContainerId;
    private FragmentManager mFragmentManager;

    public AndroidScreenManager(FragmentManager mFragmentManager, int mRootContainerId) {
        this.mFragmentManager = mFragmentManager;
        this.mRootContainerId = mRootContainerId;
    }

    @Override
    public void displayScreen(ScreenFactory screenFactory) {
        mFragmentManager.beginTransaction().replace(mRootContainerId, (Fragment) screenFactory.getScreen()).addToBackStack(null).commit();
    }
}
