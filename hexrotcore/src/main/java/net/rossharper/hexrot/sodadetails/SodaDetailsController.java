package net.rossharper.hexrot.sodadetails;

import net.rossharper.hexrot.model.Soda;

public class SodaDetailsController {
    private SodaDetailsView mSodaDetailsView;
    private Soda mSoda;

    public SodaDetailsController(SodaDetailsView sodaDetailsView, Soda soda) {
        mSodaDetailsView = sodaDetailsView;
        mSoda = soda;
    }

    public void onReady() {
        mSodaDetailsView.setSodaName(mSoda.getName());
    }
}
