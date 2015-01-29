package net.rossharper.hexrot.android.sodadetails;

import android.app.Fragment;
import android.os.Bundle;

import net.rossharper.hexrot.android.screenmanager.ScreenFactory;
import net.rossharper.hexrot.model.Soda;

public class SodaDetailsScreenFactory implements ScreenFactory {
    private Soda mSoda;

    public SodaDetailsScreenFactory(Soda soda) {
        mSoda = soda;
    }

    @Override
    public Fragment getScreen() {
        SodaDetailsFragment sodaDetailsFragment = new SodaDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(SodaDetailsFragment.SODA_ARG, new SodaParcel(mSoda));
        sodaDetailsFragment.setArguments(args);
        return sodaDetailsFragment;
    }
}
