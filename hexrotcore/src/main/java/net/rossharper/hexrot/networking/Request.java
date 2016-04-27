package net.rossharper.hexrot.networking;

public interface Request<T> {
    void get(T url, ResponseListener<T> responseListener);

    interface ResponseListener<T> {
        void onResponse(T response);
        void onError();
    }
}
