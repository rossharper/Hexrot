package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.StringFetcher;

// TODO: probably not named properly anymore
class GithubJsonSodaListFetcher implements SodaListFetcher {

    private final SodaListProviderConfig config;
    private final NetworkingFactory networkingFactory;

    public GithubJsonSodaListFetcher(NetworkingFactory networkingFactory, SodaListProviderConfig config) {
        this.networkingFactory = networkingFactory;
        this.config = config;
    }

    @Override
    public void fetchSodaList(final Listener listener) {
        networkingFactory.createStringFetcher().get(config.getSodaListUrl(), new StringFetcher.ResponseListener() {
            @Override
            public void onResponse(String response) {
                listener.sodasReceived(response);
            }

            @Override
            public void onError() {
                listener.sodaFetchError();
            }
        });
    }
}
