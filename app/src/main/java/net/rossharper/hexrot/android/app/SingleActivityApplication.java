package net.rossharper.hexrot.android.app;

import android.app.Activity;
import android.os.Bundle;

import net.rossharper.hexrot.Application;
import net.rossharper.hexrot.R;

public class SingleActivityApplication extends Activity {

    private Application mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mApplication = ApplicationControllerFactory.create(this, getFragmentManager());
        if(savedInstanceState == null) {
            mApplication.start();
        }
    }

    public Application getApplicationController() {
        return mApplication;
    }
}
