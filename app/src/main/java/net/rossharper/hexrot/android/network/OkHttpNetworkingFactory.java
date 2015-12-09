package net.rossharper.hexrot.android.network;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.StringFetcher;

/**
 * Created by harper05 on 09/12/15.
 */
public class OkHttpNetworkingFactory implements NetworkingFactory {
    @Override
    public StringFetcher createStringFetcher() {
        return new OkHttpStringFetcher();
    }
}
