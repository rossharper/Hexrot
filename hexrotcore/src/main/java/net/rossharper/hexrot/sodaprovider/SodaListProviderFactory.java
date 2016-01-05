package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.networking.NetworkingFactory;

public class SodaListProviderFactory {
    public SodaListProvider createSodaListProvider(NetworkingFactory networkingFactory, SodaListProviderConfig config) {
        return new RemoteSodaListProvider(new GithubJsonSodaListFetcher(networkingFactory, config), new SodaJsonParser());
    }
}
