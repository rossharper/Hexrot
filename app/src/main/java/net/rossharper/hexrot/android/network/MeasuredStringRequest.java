package net.rossharper.hexrot.android.network;

import android.util.Log;

import net.rossharper.hexrot.networking.StringRequest;

import java.util.Date;

public class MeasuredStringRequest implements StringRequest {
    private StringRequest request;
    private RequestStatisticsReporter requestStatisticsReporter;

    public MeasuredStringRequest(StringRequest request, RequestStatisticsReporter requestStatisticsReporter) {
        this.request = request;
        this.requestStatisticsReporter = requestStatisticsReporter;
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
                requestStatisticsReporter.reportRequestStatistic(requestTimeMs);
            }
        });
    }

    private long getTimestampMs() {
        return new Date().getTime();
    }
}
