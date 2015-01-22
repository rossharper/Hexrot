package net.rossharper.hexrot.android;

import android.app.Fragment;

import net.rossharper.hexrot.android.sodalist.SodaListFragment;

/**
 * Created by harper05 on 22/01/2015.
 */
public class SodaListScreenFactory implements ScreenFactory<Fragment> {
    @Override
    public Fragment getScreen() {
        return new SodaListFragment();
    }
}
