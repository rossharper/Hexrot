package net.rossharper.hexrot.android.network;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.StringRequest;

public class OkHttpNetworkingFactory implements NetworkingFactory {
    @Override
    public StringRequest createStringRequest() {
        return new OkHttpStringRequest();
    }
}
