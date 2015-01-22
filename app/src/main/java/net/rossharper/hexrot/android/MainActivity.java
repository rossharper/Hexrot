package net.rossharper.hexrot.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;

import net.rossharper.hexrot.ApplicationController;

import net.rossharper.hexrot.R;
import net.rossharper.otto.Bus;
import net.rossharper.otto.ThreadEnforcer;

public class MainActivity extends Activity {

    private ApplicationController mApplicationController;
    private AndroidScreenManager mScreenManager;
    private Bus mNavigationEventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        createSingleActivityApplication();
    }

    private void createSingleActivityApplication() {

        mNavigationEventBus = new Bus(new ThreadEnforcer() {
            @Override
            public void enforce(Bus bus) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    throw new IllegalStateException("Event bus " + bus + " accessed from non-main thread " + Looper.myLooper());
                }
            }
        });

        mScreenManager = new AndroidScreenManager(mNavigationEventBus, getFragmentManager(), R.id.main_container);
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
