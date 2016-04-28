package net.rossharper.hexrot.android.network;

import net.rossharper.hexrot.networking.StringRequest;

public class MeasuredStringRequest implements StringRequest {
    private StringRequest request;
    private RequestStatisticsReporter requestStatisticsReporter;
    private TimeProvider timeProvider;

    public MeasuredStringRequest(StringRequest request, RequestStatisticsReporter requestStatisticsReporter, TimeProvider timeProvider) {
        this.request = request;
        this.requestStatisticsReporter = requestStatisticsReporter;
        this.timeProvider = timeProvider;
    }

    @Override
    public void get(final String url, final ResponseListener<String> responseListener) {
        final long requestStartedTimestampMs = timeProvider.getCurrentTimeInMillis();
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
                long requestEndedTimestampMs = timeProvider.getCurrentTimeInMillis();
                long requestTimeMs = requestEndedTimestampMs - requestStartedTimestampMs;
                requestStatisticsReporter.reportRequestStatistic(requestTimeMs);
            }
        });
    }

}
