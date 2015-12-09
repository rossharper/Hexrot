package net.rossharper.hexrot.android.network;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class StringFetcher implements net.rossharper.hexrot.networking.StringFetcher {

    @Override
    public void get(String url, final ResponseListener responseListener) {
        OkHttpClient httpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                responseListener.onError();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                responseListener.onResponse(response.body().string());
            }
        });
    }
}
