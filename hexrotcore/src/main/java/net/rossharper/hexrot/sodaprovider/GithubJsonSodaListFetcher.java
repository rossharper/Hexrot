package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.StringFetcher;

public class GithubJsonSodaListFetcher {
    // TODO: tackle the concept of configuration and provide this from there
    private static final String SODA_LIST_URL = "https://raw.githubusercontent.com/rossharper/Hexrot/master/servicedata/sodalist.json";

    private NetworkingFactory networkingFactory;

    public GithubJsonSodaListFetcher(NetworkingFactory networkingFactory) {
        this.networkingFactory = networkingFactory;
    }

    public interface Listener {
        void sodasReceived(String jsonSodaList);
        void sodaFetchError();
    }

    public void getSodas(final Listener listener) {
        networkingFactory.createStringFetcher().get(SODA_LIST_URL, new StringFetcher.ResponseListener() {
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