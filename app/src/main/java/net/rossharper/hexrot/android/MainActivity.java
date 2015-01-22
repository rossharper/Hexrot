package net.rossharper.hexrot.android;

import android.app.Activity;
import android.os.Bundle;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import net.rossharper.hexrot.ApplicationController;

import net.rossharper.hexrot.R;
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
        mNavigationEventBus = new Bus(ThreadEnforcer.MAIN, "NavigationEventBus");
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
