package net.rossharper.hexrot.android.sodaprovider;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.sodalist.SodaList;
import net.rossharper.hexrot.sodaprovider.GithubJsonSodaListFetcher;
import net.rossharper.hexrot.sodaprovider.SodaJsonParser;
import net.rossharper.hexrot.sodaprovider.SodaListProvider;
import net.rossharper.hexrot.sodaprovider.SodaListProviderListener;

// TODO: can this be moved into core?
public class RemoteSodaListProvider implements SodaListProvider {

    private NetworkingFactory networkingFactory;

    public RemoteSodaListProvider(NetworkingFactory networkingFactory) {
        this.networkingFactory = networkingFactory;
    }

    @Override
    public void getSodas(final SodaListProviderListener sodaListProviderListener) {
        new GithubJsonSodaListFetcher(networkingFactory).getSodas(new GithubJsonSodaListFetcher.Listener() {
            @Override
            public void sodasReceived(String jsonSodaList) {
                try {
                    // TODO: parse on a background thread
                    final SodaList sodaList = new SodaJsonParser().parse(jsonSodaList);
                    sodaListProviderListener.sodaListReceived(sodaList);
                } catch (SodaJsonParser.SodaJsonParserException e) {
                    sodaListProviderListener.sodaListFetchError();
                }
            }

            @Override
            public void sodaFetchError() {
                sodaListProviderListener.sodaListFetchError();
            }
        });
    }
}
