package net.rossharper.hexrot.statistics.measurednetworking;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.StringRequest;
import net.rossharper.hexrot.statistics.RequestStatisticUrlBuilder;
import net.rossharper.hexrot.statistics.RequestStatisticsReporter;
import net.rossharper.hexrot.time.SystemTimeProvider;

public class MeasuredNetworkingFactory implements NetworkingFactory {
    private NetworkingFactory unmeasuredNetworkingFactory;

    public MeasuredNetworkingFactory(NetworkingFactory networkingFactory) {
        this.unmeasuredNetworkingFactory = networkingFactory;
    }

    @Override
    public StringRequest createStringRequest() {
        return new MeasuredStringRequest(unmeasuredNetworkingFactory.createStringRequest(),
                new RequestStatisticsReporter(unmeasuredNetworkingFactory, new RequestStatisticUrlBuilder()), new SystemTimeProvider());
    }
}
