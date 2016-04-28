package net.rossharper.hexrot.statistics;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.Request;

public class RequestStatisticsReporter {

    private NetworkingFactory networkingFactory;
    private RequestStatisticUrlBuilder requestStatisticReportUrlBuilder;

    public RequestStatisticsReporter(NetworkingFactory networkingFactory, RequestStatisticUrlBuilder requestStatisticReportUrlBuilder) {
        this.networkingFactory = networkingFactory;
        this.requestStatisticReportUrlBuilder = requestStatisticReportUrlBuilder;
    }

    public void reportRequestStatistic(long requestTimeMs) {
        networkingFactory.createStringRequest().get(requestStatisticReportUrlBuilder.reportUrl(requestTimeMs), new Request.ResponseListener<String>() {
            @Override
            public void onResponse(String response) {
            }

            @Override
            public void onError() {
            }
        });
    }
}
