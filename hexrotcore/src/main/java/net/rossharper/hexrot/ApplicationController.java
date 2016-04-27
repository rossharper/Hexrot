package net.rossharper.hexrot;

import net.rossharper.hexrot.networking.NetworkingFactory;

public class ApplicationController {
    private final ScreenManager screenManager;
    private final NetworkingFactory networkingFactory;

    private ScreenDisplayCommand homeScreenDisplayCommand;

    public ApplicationController(ScreenManager screenManager, NetworkingFactory networkingFactory, ScreenDisplayCommand homeScreenDisplayCommand) {
        this.screenManager = screenManager;
        this.networkingFactory = networkingFactory;
        this.homeScreenDisplayCommand = homeScreenDisplayCommand;
    }

    public void start() {
        homeScreenDisplayCommand.displayScreen();
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public NetworkingFactory getNetworkingFactory() {
        return networkingFactory;
    }
}
