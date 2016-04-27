package net.rossharper.hexrot;

public class ApplicationController {
    private ServiceLocator serviceLocator;

    public ApplicationController(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public void start(ScreenDisplayCommand homeScreenDisplayCommand) {
        homeScreenDisplayCommand.displayScreen();
    }

    public ServiceLocator getServiceLocator() {
        return serviceLocator;
    }
}
