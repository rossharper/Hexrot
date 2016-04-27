package net.rossharper.hexrot.networking;

public interface Request<T> {
    void get(final T url, final ResponseListener<T> responseListener);

    interface ResponseListener<T> {
        void onResponse(final T response);
        void onError();
    }
}
