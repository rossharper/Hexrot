package net.rossharper.hexrot.android;

import android.app.Activity;
import android.os.Bundle;

import net.rossharper.hexrot.ApplicationController;

import net.rossharper.hexrot.R;

public class MainActivity extends Activity {

    private ApplicationController mApplicationController;
    private AndroidScreenManager mScreenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScreenManager = new AndroidScreenManager(getFragmentManager(), R.id.main_container);

        // Create the application controller and tell it we are ready
        mApplicationController = new ApplicationController(mScreenManager, new AndroidHomeScreenFactory());
        mApplicationController.onReady();
    }
}
