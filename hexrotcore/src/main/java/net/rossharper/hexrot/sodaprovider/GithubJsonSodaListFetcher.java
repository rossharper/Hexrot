package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.StringFetcher;

class GithubJsonSodaListFetcher implements SodaListFetcher {

    private static final SodaListProviderConfig config = new SodaListProviderConfig() {
        private static final String SODA_LIST_URL = "https://raw.githubusercontent.com/rossharper/Hexrot/master/servicedata/sodalist.json";

        @Override
        public String getSodaListUrl() {
            return SODA_LIST_URL;
        }
    };

    private NetworkingFactory networkingFactory;

    public GithubJsonSodaListFetcher(NetworkingFactory networkingFactory) {
        this.networkingFactory = networkingFactory;
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
