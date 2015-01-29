package net.rossharper.hexrot.android.sodalist;

import android.app.Fragment;

import net.rossharper.hexrot.android.screenmanager.ScreenFactory;

/**
 * Created by harper05 on 22/01/2015.
 */
public class SodaListScreenFactory implements ScreenFactory {
    @Override
    public Fragment getScreen() {
        return new SodaListFragment();
    }
}
