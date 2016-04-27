package net.rossharper.hexrot.android.sodadetails;

import android.app.Fragment;

import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.android.screenmanager.FragmentScreenDisplayCommand;
import net.rossharper.hexrot.ScreenManager;
import net.rossharper.hexrot.model.Soda;

public class SodaDetailsScreenDisplayCommandFactory implements net.rossharper.hexrot.sodadetails.SodaDetailsScreenDisplayCommandFactory {
    private ScreenManager<Fragment> screenManager;

    public SodaDetailsScreenDisplayCommandFactory(ScreenManager<Fragment> screenManager) {
        this.screenManager = screenManager;
    }

    @Override
    public ScreenDisplayCommand createWithData(Soda soda) {
        return new FragmentScreenDisplayCommand(screenManager, new SodaDetailsScreenFactory(soda));
    }
}
