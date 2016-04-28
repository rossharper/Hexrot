package net.rossharper.hexrot.android.app;

import android.app.Activity;
import android.os.Bundle;

import net.rossharper.hexrot.ApplicationController;
import net.rossharper.hexrot.R;

public class SingleActivityApplication extends Activity {

    private ApplicationController mApplicationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        createSingleActivityApplication();
    }

    private void createSingleActivityApplication() {
        mApplicationController = ApplicationControllerFactory.create(this, getFragmentManager());
    }

    @Override
    protected void onStart() {
        super.onStart();

        mApplicationController.start();
    }

    public ApplicationController getApplicationController() {
        return mApplicationController;
    }
}
