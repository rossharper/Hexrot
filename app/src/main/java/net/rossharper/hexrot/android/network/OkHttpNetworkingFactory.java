package net.rossharper.hexrot.android.network;

import android.content.Context;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.StringRequest;

public class OkHttpNetworkingFactory implements NetworkingFactory {
    private MainThreadInvoker mainThreadInvoker;

    public OkHttpNetworkingFactory(Context context) {
        mainThreadInvoker = new MainThreadInvoker(context);
    }

    @Override
    public StringRequest createStringRequest() {
        return new OkHttpStringRequest(mainThreadInvoker);
    }
}
