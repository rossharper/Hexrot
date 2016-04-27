package net.rossharper.hexrot.android.screenmanager;

import android.app.Fragment;

import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.ScreenFactory;
import net.rossharper.hexrot.ScreenManager;

public class FragmentScreenDisplayCommand implements ScreenDisplayCommand {
    private ScreenManager<Fragment> screenManager;
    private ScreenFactory<Fragment> sodaListScreenFactory;

    public FragmentScreenDisplayCommand(ScreenManager<Fragment> screenManager, ScreenFactory<Fragment> sodaListScreenFactory) {
        this.screenManager = screenManager;
        this.sodaListScreenFactory = sodaListScreenFactory;
    }

    @Override
    public void displayScreen() {
        this.screenManager.displayRootScreen(sodaListScreenFactory);
    }
}
