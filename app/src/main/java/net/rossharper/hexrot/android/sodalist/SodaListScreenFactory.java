package net.rossharper.hexrot.android.sodalist;

import android.app.Fragment;

import net.rossharper.hexrot.android.screenmanager.ScreenFactory;

public class SodaListScreenFactory implements ScreenFactory {
    @Override
    public Fragment getScreen() {
        return new SodaListFragment();
    }
}
