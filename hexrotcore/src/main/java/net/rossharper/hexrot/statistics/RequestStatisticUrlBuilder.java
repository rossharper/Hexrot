package net.rossharper.hexrot.statistics;

public class RequestStatisticUrlBuilder {
    public String reportUrl(long requestTimeMs) {
        return "https://raw.githubusercontent.com/fmtvp/recruit-test-data/master/stats?event=load&data=" + requestTimeMs;
    }
}
