package net.rossharper.hexrot.android.app;

import android.app.FragmentManager;
import android.content.Context;

import net.rossharper.hexrot.ApplicationController;
import net.rossharper.hexrot.R;
import net.rossharper.hexrot.android.network.OkHttpNetworkingFactory;
import net.rossharper.hexrot.android.screenmanager.FragmentScreenDisplayCommand;
import net.rossharper.hexrot.android.screenmanager.FragmentScreenManager;
import net.rossharper.hexrot.android.sodalist.SodaListScreenFactory;
import net.rossharper.hexrot.statistics.measurednetworking.MeasuredNetworkingFactory;

public class ApplicationControllerFactory {
    public static ApplicationController create(Context context, FragmentManager fragmentManager) {
        FragmentScreenManager screenManager = new FragmentScreenManager(fragmentManager, R.id.main_container);

        return new ApplicationController(
                screenManager,
                new MeasuredNetworkingFactory(new OkHttpNetworkingFactory(context.getApplicationContext())),
                new FragmentScreenDisplayCommand(
                        screenManager,
                        new SodaListScreenFactory()));
    }
}
