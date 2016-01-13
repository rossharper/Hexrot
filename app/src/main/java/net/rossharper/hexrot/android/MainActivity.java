package net.rossharper.hexrot.android;

import android.app.Activity;
import android.os.Bundle;

import net.rossharper.hexrot.ApplicationController;

import net.rossharper.hexrot.R;
import net.rossharper.hexrot.android.app.ServiceLocator;
import net.rossharper.hexrot.android.screenmanager.ScreenManager;
import net.rossharper.hexrot.android.sodalist.SodaListScreenDisplayCommand;
import net.rossharper.hexrot.android.sodalist.SodaListScreenFactory;

public class MainActivity extends Activity {

    private ApplicationController mApplicationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        createSingleActivityApplication();
    }

    private void createSingleActivityApplication() {
        ScreenManager screenManager = new ScreenManager(getFragmentManager(), R.id.main_container);
        ServiceLocator.loadService(ServiceLocator.SCREEN_MANAGER, screenManager);
        mApplicationController = new ApplicationController(
                new SodaListScreenDisplayCommand(
                        screenManager,
                        new SodaListScreenFactory()));
    }

    @Override
    protected void onStart() {
        super.onStart();

        mApplicationController.onReady();
    }
}
