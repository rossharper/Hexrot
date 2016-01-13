package net.rossharper.hexrot;

public class ApplicationController {
    private ScreenDisplayCommand homeScreenDisplayCommand;

    public ApplicationController(ScreenDisplayCommand homeScreenDisplayCommand) {
        this.homeScreenDisplayCommand = homeScreenDisplayCommand;
    }

    public void onReady() {
        homeScreenDisplayCommand.displayScreen();
    }
}
