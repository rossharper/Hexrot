package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.sodalist.SodaList;

class RemoteSodaListProvider implements SodaListProvider {

    private NetworkingFactory networkingFactory;

    public RemoteSodaListProvider(NetworkingFactory networkingFactory) {
        this.networkingFactory = networkingFactory;
    }

    @Override
    public void getSodas(final SodaListProviderListener sodaListProviderListener) {
        // TODO: should this be injected? or the whole lot assembled by a factory?
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
