package net.rossharper.hexrot;

import net.rossharper.hexrot.networking.NetworkingFactory;

public class Application {
    private final AppConfig appConfig;
    private final ScreenManager screenManager;
    private final NetworkingFactory networkingFactory;

    private ScreenDisplayCommand homeScreenDisplayCommand;

    public Application(AppConfig appConfig, ScreenManager screenManager, NetworkingFactory networkingFactory, ScreenDisplayCommand homeScreenDisplayCommand) {
        this.appConfig = appConfig;
        this.screenManager = screenManager;
        this.networkingFactory = networkingFactory;
        this.homeScreenDisplayCommand = homeScreenDisplayCommand;
    }

    public void start() {
        homeScreenDisplayCommand.displayScreen();
    }

    public AppConfig getAppConfig() {
        return appConfig;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public NetworkingFactory getNetworkingFactory() {
        return networkingFactory;
    }
}
