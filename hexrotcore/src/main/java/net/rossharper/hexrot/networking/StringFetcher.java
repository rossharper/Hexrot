package net.rossharper.hexrot.networking;

/**
 * Created by harper05 on 09/12/15.
 */
public interface StringFetcher {
    void get(String url, ResponseListener responseListener);

    interface ResponseListener {
        void onResponse(String response);
        void onError();
    }
}
