package net.rossharper.hexrot.android.network;

import android.util.Log;

import net.rossharper.hexrot.networking.StringRequest;

import java.util.Date;

public class MeasuredStringRequest implements StringRequest {
    private StringRequest request;

    public MeasuredStringRequest(StringRequest request) {
        this.request = request;
    }

    @Override
    public void get(final String url, final ResponseListener<String> responseListener) {
        final long requestStartedTimestampMs = getTimestampMs();
        request.get(url, new ResponseListener<String>() {
            @Override
            public void onResponse(String response) {
                onRequestEnded();
                responseListener.onResponse(response);
            }

            @Override
            public void onError() {
                onRequestEnded();
                responseListener.onError();
            }

            private void onRequestEnded() {
                long requestEndedTimestampMs = getTimestampMs();
                long requestTimeMs = requestEndedTimestampMs - requestStartedTimestampMs;
                Log.i("MeasuredStringRequest", "Request took " + requestTimeMs + "ms for " + url);
            }
        });
    }

    private long getTimestampMs() {
        return new Date().getTime();
    }
}
