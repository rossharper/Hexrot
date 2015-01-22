package net.rossharper.hexrot;

public class ApplicationController {
    private ScreenFactory mHomeScreenFactory;
    private ScreenManager mScreenManager;

    public ApplicationController(ScreenManager mScreenManager, ScreenFactory mHomeScreenFactory) {
        this.mScreenManager = mScreenManager;
        this.mHomeScreenFactory = mHomeScreenFactory;
    }

    public void onReady() {
        // Display the first screen

        mScreenManager.displayScreen(mHomeScreenFactory);
    }
}
