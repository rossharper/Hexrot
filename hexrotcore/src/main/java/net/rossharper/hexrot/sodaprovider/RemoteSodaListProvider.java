package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.sodalist.SodaList;

class RemoteSodaListProvider implements SodaListProvider {

    private GithubJsonSodaListFetcher githubJsonSodaListFetcher;
    private SodaJsonParser sodaJsonParser;

    public RemoteSodaListProvider(NetworkingFactory networkingFactory, SodaJsonParser sodaJsonParser) {
        // TODO: genereceise the fetcher interface and inject from factory
        githubJsonSodaListFetcher = new GithubJsonSodaListFetcher(networkingFactory);
        this.sodaJsonParser = sodaJsonParser;
    }

    @Override
    public void getSodas(final SodaListProviderListener sodaListProviderListener) {
        // TODO: should this be injected? or the whole lot assembled by a factory?
        githubJsonSodaListFetcher.getSodas(new GithubJsonSodaListFetcher.Listener() {
            @Override
            public void sodasReceived(String jsonSodaList) {
                try {
                    // TODO: parse on a background thread
                    final SodaList sodaList = sodaJsonParser.parse(jsonSodaList);
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
