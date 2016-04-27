package net.rossharper.hexrot.android.screenmanager;

public interface ScreenManager<T> {
    void displayRootScreen(ScreenFactory<T> screenFactory);
    void displayStackedScreen(ScreenFactory<T> screenFactory);
}
