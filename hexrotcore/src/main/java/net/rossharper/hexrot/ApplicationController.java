package net.rossharper.hexrot;

public class ApplicationController {
    private final ScreenManager screenManager;
    private ScreenDisplayCommand homeScreenDisplayCommand;

    public ApplicationController(ScreenManager screenManager, ScreenDisplayCommand homeScreenDisplayCommand) {
        this.screenManager = screenManager;
        this.homeScreenDisplayCommand = homeScreenDisplayCommand;
    }

    public void start() {
        homeScreenDisplayCommand.displayScreen();
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }
}
