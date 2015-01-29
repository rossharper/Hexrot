package net.rossharper.hexrot;

public class ApplicationController {
    private HomeScreenDisplayEventFactory mHomeScreenDisplayEventFactory;

    public ApplicationController(HomeScreenDisplayEventFactory homeScreenDisplayEventFactory) {
        mHomeScreenDisplayEventFactory = homeScreenDisplayEventFactory;
    }

    public void onReady() {
        mHomeScreenDisplayEventFactory.emitDisplayScreenEvent();
    }
}
