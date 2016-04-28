package net.rossharper.hexrot.android.network;

import net.rossharper.hexrot.networking.NetworkingFactory;
import net.rossharper.hexrot.networking.StringRequest;

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
