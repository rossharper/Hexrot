package net.rossharper.hexrot.android.sodalist;

import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.android.screenmanager.ScreenFactory;
import net.rossharper.hexrot.android.screenmanager.ScreenManager;

public class SodaListScreenDisplayCommand implements ScreenDisplayCommand {
    private ScreenManager screenManager;
    private ScreenFactory sodaListScreenFactory;

    public SodaListScreenDisplayCommand(ScreenManager screenManager, ScreenFactory sodaListScreenFactory) {
        this.screenManager = screenManager;
        this.sodaListScreenFactory = sodaListScreenFactory;
    }

    @Override
    public void displayScreen() {
        this.screenManager.displayRootScreen(sodaListScreenFactory);
    }
}
