package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.Request;

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
        networkingFactory.createStringRequest().get(config.getSodaListUrl(), new Request.ResponseListener<String>() {
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
