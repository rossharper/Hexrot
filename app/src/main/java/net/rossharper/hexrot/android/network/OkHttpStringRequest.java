package net.rossharper.hexrot.android.network;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import net.rossharper.hexrot.networking.StringRequest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

class OkHttpStringRequest implements StringRequest {

    @Override
    public void get(final String url, final ResponseListener<String> responseListener) {
        OkHttpClient httpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        // TODO: temporary while I'm hacking on a train
        httpClient.setConnectTimeout(5, TimeUnit.SECONDS);

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Request request, IOException e) {
                responseListener.onError();
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                final String stringResponse = response.body().string();
                responseListener.onResponse(stringResponse);
            }
        });
    }
}
