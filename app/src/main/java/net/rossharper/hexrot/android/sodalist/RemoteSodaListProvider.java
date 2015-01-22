package net.rossharper.hexrot.android.sodalist;

import net.rossharper.hexrot.sodalist.SodaList;
import net.rossharper.hexrot.sodalist.SodaListProvider;
import net.rossharper.hexrot.sodalist.SodaListProviderListener;

import org.json.JSONException;

public class RemoteSodaListProvider implements SodaListProvider {
    @Override
    public void getSodas(final SodaListProviderListener sodaListProviderListener) {
        new GithubJsonSodaListFetcher().getSodas(new GithubJsonSodaListFetcher.Listener() {
            @Override
            public void sodasReceived(String jsonSodaList) {
                SodaList sodaList = null;
                try {
                    sodaList = new SodaJsonParser().parse(jsonSodaList);
                    sodaListProviderListener.sodaListReceived(sodaList);
                } catch (JSONException e) {
                    // TODO: error handling
                }
            }
        });
    }
}
