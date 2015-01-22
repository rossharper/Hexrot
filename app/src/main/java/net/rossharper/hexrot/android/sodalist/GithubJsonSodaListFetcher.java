package net.rossharper.hexrot.android.sodalist;

import net.rossharper.hexrot.android.network.StringFetcher;

public class GithubJsonSodaListFetcher {
    private static final String SODA_LIST_URL = "https://raw.githubusercontent.com/rossharper/Hexrot/master/servicedata/sodalist.json";

    public static interface Listener {
        void sodasReceived(String jsonSodaList);
    }

    public void getSodas(final Listener listener) {
        new StringFetcher().get(SODA_LIST_URL, new StringFetcher.ResponseListener() {
            @Override
            public void onResponse(String response) {
                listener.sodasReceived(response);
            }
        });
    }
}
