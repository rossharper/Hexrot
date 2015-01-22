package net.rossharper.hexrot.android.sodalist;

import net.rossharper.hexrot.android.network.StringFetcher;

public class GithubSodaListFetcher {
    private static final String SODA_LIST_URL = "";

    public void getSodas() {
        new StringFetcher().get(SODA_LIST_URL);
    }
}
