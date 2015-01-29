package net.rossharper.hexrot.android;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class NavigationBus {
    private static Bus mInstance;

    public static synchronized Bus getEventBus() {
        if(mInstance == null) {
            mInstance = new Bus(ThreadEnforcer.MAIN, "NavigationEventBus");
        }
        return mInstance;
    }
}
