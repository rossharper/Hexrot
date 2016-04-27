package net.rossharper.hexrot.android.sodalist;

import android.app.Fragment;

import net.rossharper.hexrot.ScreenFactory;

public class SodaListScreenFactory implements ScreenFactory<Fragment> {
    @Override
    public Fragment getScreen() {
        return new SodaListFragment();
    }
}
