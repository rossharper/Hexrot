package net.rossharper.hexrot.android.eventbus;

import android.os.Looper;

import net.rossharper.otto.Bus;
import net.rossharper.otto.ThreadEnforcer;

public class MainThreadEnforcer implements ThreadEnforcer {
    @Override
    public void enforce(Bus bus) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Event bus " + bus + " accessed from non-main thread " + Looper.myLooper());
        }
    }
}
