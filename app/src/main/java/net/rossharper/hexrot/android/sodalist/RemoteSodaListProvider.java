package net.rossharper.hexrot.android.sodalist;

import net.rossharper.hexrot.sodalist.SodaListProvider;
import net.rossharper.hexrot.sodalist.SodaListProviderListener;

public class RemoteSodaListProvider implements SodaListProvider {
    @Override
    public void getSodas(final SodaListProviderListener sodaListProviderListener) {
        new GithubJsonSodaListFetcher().getSodas(new GithubJsonSodaListFetcher.Listener() {
            @Override
            public void sodasReceived(String jsonSodaList) {
                sodaListProviderListener.sodaListReceived(new SodaJsonParser().parse(jsonSodaList));
            }
        });
    }
}
