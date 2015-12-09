package net.rossharper.hexrot.networking;

/**
 * Created by harper05 on 09/12/15.
 */
public interface Fetcher {
    void get(String url, ResponseListener responseListener);

    public static interface ResponseListener {
        void onResponse(String response);
        void onError();
    }
}
