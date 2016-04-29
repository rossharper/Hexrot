package net.rossharper.hexrot.android.sodadetails;

import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.ScreenManager;
import net.rossharper.hexrot.android.screenmanager.StackedScreenDisplayCommand;
import net.rossharper.hexrot.model.Soda;

public class SodaDetailsScreenDisplayCommandFactory implements net.rossharper.hexrot.sodadetails.SodaDetailsScreenDisplayCommandFactory {
    private ScreenManager screenManager;

    public SodaDetailsScreenDisplayCommandFactory(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    @Override
    public ScreenDisplayCommand createWithData(Soda soda) {
        return new StackedScreenDisplayCommand(screenManager, new SodaDetailsScreenFactory(soda));
    }
}
