package net.rossharper.hexrot.android.screenmanager;

import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.ScreenFactory;
import net.rossharper.hexrot.ScreenManager;

public class RootScreenDisplayCommand implements ScreenDisplayCommand {
    private ScreenManager screenManager;
    private ScreenFactory sodaListScreenFactory;

    public RootScreenDisplayCommand(ScreenManager screenManager, ScreenFactory sodaListScreenFactory) {
        this.screenManager = screenManager;
        this.sodaListScreenFactory = sodaListScreenFactory;
    }

    @Override
    public void displayScreen() {
        this.screenManager.displayRootScreen(sodaListScreenFactory);
    }
}
