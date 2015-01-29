package net.rossharper.hexrot.android;

import android.app.Activity;
import android.os.Bundle;

import net.rossharper.hexrot.ApplicationController;

import net.rossharper.hexrot.R;

public class MainActivity extends Activity {

    private ApplicationController mApplicationController;
    private ScreenManager mScreenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        createSingleActivityApplication();
    }

    private void createSingleActivityApplication() {
        mScreenManager = new ScreenManager(getFragmentManager(), R.id.main_container);
        mApplicationController = new ApplicationController(new AndroidHomeScreenDisplayEventFactory());
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
