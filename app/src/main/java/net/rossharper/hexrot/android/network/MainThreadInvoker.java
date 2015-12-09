package net.rossharper.hexrot.android.network;

import android.content.Context;
import android.os.Handler;

/**
 * Created by harper05 on 09/12/15.
 */
public class MainThreadInvoker {
    private final Handler mMainThreadHandler;

    public MainThreadInvoker(Context context) {
        mMainThreadHandler = new Handler(context.getMainLooper());
    }

    interface Command {
        void invoke();
    }

    public void invokeOnMainThread(final Command command) {
        mMainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                command.invoke();
            }
        });
    }
}
