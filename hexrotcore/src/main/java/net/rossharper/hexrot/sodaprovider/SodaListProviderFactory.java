package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.networking.NetworkingFactory;

/**
 * Created by harper05 on 16/12/15.
 */
public class SodaListProviderFactory {
    public SodaListProvider createSodaListProvider(NetworkingFactory networkingFactory) {
        return new RemoteSodaListProvider(networkingFactory);
    }
}
