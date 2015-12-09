package net.rossharper.hexrot.android.network;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

class OkHttpStringFetcher implements net.rossharper.hexrot.networking.StringFetcher {

    // TODO: just calling back to main thread for now
    // needs a better threading model
    private final MainThreadInvoker mainThreadInvoker;

    public OkHttpStringFetcher(final MainThreadInvoker mainThreadInvoker) {
        this.mainThreadInvoker = mainThreadInvoker;
    }

    @Override
    public void get(final String url, final ResponseListener responseListener) {
        OkHttpClient httpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        // TODO: temporary while I'm hacking on a train
        httpClient.setConnectTimeout(5, TimeUnit.SECONDS);

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Request request, IOException e) {
                mainThreadInvoker.invokeOnMainThread(new MainThreadInvoker.Command() {
                    @Override
                    public void invoke() {
                        responseListener.onError();
                    }
                });
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                final String stringResponse = response.body().string();
                mainThreadInvoker.invokeOnMainThread(new MainThreadInvoker.Command() {
                    @Override
                    public void invoke() {
                        responseListener.onResponse(stringResponse);
                    }
                });
            }
        });
    }
}
