package net.rossharper.hexrot.android.sodadetails;

import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.android.screenmanager.ScreenManager;

public class SodaDetailsScreenDisplayCommand implements ScreenDisplayCommand {

    private final ScreenManager screenManager;
    private final SodaDetailsScreenFactory screenFactory;

    public SodaDetailsScreenDisplayCommand(ScreenManager screenManager, SodaDetailsScreenFactory screenFactory) {
        this.screenManager = screenManager;
        this.screenFactory = screenFactory;
    }

    @Override
    public void displayScreen() {
        screenManager.displayStackedScreen(screenFactory);
    }
}
