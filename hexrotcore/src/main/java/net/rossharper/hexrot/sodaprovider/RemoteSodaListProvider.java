package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.sodalist.SodaList;

class RemoteSodaListProvider implements SodaListProvider {

    private SodaListFetcher sodaListFetcher;
    private SodaJsonParser sodaJsonParser;

    public RemoteSodaListProvider(SodaListFetcher sodaListFetcher, SodaJsonParser sodaJsonParser) {
        this.sodaListFetcher = sodaListFetcher;
        this.sodaJsonParser = sodaJsonParser;
    }

    @Override
    public void getSodas(final SodaListProviderListener sodaListProviderListener) {
        sodaListFetcher.fetchSodaList(new SodaListFetcher.Listener() {
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
