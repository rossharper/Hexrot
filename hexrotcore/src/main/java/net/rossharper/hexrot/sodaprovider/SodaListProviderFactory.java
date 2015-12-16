package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.networking.NetworkingFactory;

public class SodaListProviderFactory {
    public SodaListProvider createSodaListProvider(NetworkingFactory networkingFactory) {
        return new RemoteSodaListProvider(new GithubJsonSodaListFetcher(networkingFactory), new SodaJsonParser());
    }
}
