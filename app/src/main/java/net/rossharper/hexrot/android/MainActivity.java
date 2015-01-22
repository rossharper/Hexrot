package net.rossharper.hexrot.android;

import android.app.Activity;
import android.os.Bundle;

import net.rossharper.hexrot.ApplicationController;

import net.rossharper.hexrot.R;
import net.rossharper.hexrot.android.eventbus.MainThreadEnforcer;
import net.rossharper.otto.Bus;

public class MainActivity extends Activity {

    private ApplicationController mApplicationController;
    private ScreenManager mScreenManager;
    private Bus mNavigationEventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        createSingleActivityApplication();
    }

    private void createSingleActivityApplication() {
        mNavigationEventBus = new Bus(new MainThreadEnforcer());
        mScreenManager = new ScreenManager(mNavigationEventBus, getFragmentManager(), R.id.main_container);
        mApplicationController = new ApplicationController(new AndroidHomeScreenDisplayEventFactory(mNavigationEventBus));
    }

    @Override
    protected void onStart() {
        super.onStart();

        mScreenManager.onStart();
        mApplicationController.onReady();
    }

    @Override
    protected void onStop() {
        super.onStop();

        mScreenManager.onStop();
    }

}
