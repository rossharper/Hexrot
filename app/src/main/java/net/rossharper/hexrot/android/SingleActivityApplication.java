package net.rossharper.hexrot.android;

import android.app.Activity;
import android.os.Bundle;

import net.rossharper.hexrot.ApplicationController;

import net.rossharper.hexrot.R;
import net.rossharper.hexrot.android.network.MeasuredNetworkingFactory;
import net.rossharper.hexrot.android.network.OkHttpNetworkingFactory;
import net.rossharper.hexrot.android.screenmanager.FragmentScreenManager;
import net.rossharper.hexrot.android.screenmanager.FragmentScreenDisplayCommand;
import net.rossharper.hexrot.android.sodalist.SodaListScreenFactory;

public class SingleActivityApplication extends Activity {

    private ApplicationController mApplicationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        createSingleActivityApplication();
    }

    private void createSingleActivityApplication() {

        FragmentScreenManager screenManager = new FragmentScreenManager(getFragmentManager(), R.id.main_container);

        mApplicationController = new ApplicationController(
                screenManager,
                new MeasuredNetworkingFactory(new OkHttpNetworkingFactory(this)),
                new FragmentScreenDisplayCommand(
                    screenManager,
                    new SodaListScreenFactory()));
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
