package net.rossharper.hexrot.android.sodadetails;

import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.android.screenmanager.ScreenManager;
import net.rossharper.hexrot.android.sodalist.SodaListScreenDisplayCommand;
import net.rossharper.hexrot.model.Soda;

/**
 * Created by harper05 on 12/01/16.
 */
public class SodaDetailsScreenDisplayCommandFactory implements net.rossharper.hexrot.sodadetails.SodaDetailsScreenDisplayCommandFactory {
    private ScreenManager screenManager;

    public SodaDetailsScreenDisplayCommandFactory(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    @Override
    public ScreenDisplayCommand createWithData(Soda soda) {
        return new SodaListScreenDisplayCommand(screenManager, new SodaDetailsScreenFactory(soda));
    }
}
