package net.rossharper.hexrot;

public interface ScreenManager<T> {
    void displayRootScreen(ScreenFactory<T> screenFactory);
    void displayStackedScreen(ScreenFactory<T> screenFactory);
}
