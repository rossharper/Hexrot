package net.rossharper.hexrot.android.network;

import android.content.Context;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.StringFetcher;

/**
 * Created by harper05 on 09/12/15.
 */
public class OkHttpNetworkingFactory implements NetworkingFactory {
    private MainThreadInvoker mainThreadInvoker;

    public OkHttpNetworkingFactory(Context context) {
        mainThreadInvoker = new MainThreadInvoker(context);
    }

    @Override
    public StringFetcher createStringFetcher() {
        return new OkHttpStringFetcher(mainThreadInvoker);
    }
}
