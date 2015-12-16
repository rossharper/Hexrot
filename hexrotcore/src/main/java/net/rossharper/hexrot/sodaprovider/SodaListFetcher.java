package net.rossharper.hexrot.sodaprovider;

/**
 * Created by harper05 on 16/12/15.
 */
public interface SodaListFetcher {
    void fetchSodaList(Listener listener);

    public interface Listener {
        void sodasReceived(String jsonSodaList);
        void sodaFetchError();
    }
}
