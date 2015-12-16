package net.rossharper.hexrot.sodaprovider;

public interface SodaListFetcher {
    void fetchSodaList(Listener listener);

    interface Listener {
        void sodasReceived(String jsonSodaList);
        void sodaFetchError();
    }
}
