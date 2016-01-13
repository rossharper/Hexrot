package net.rossharper.hexrot.android.app;

import java.util.HashMap;
import java.util.Map;

// :(

// TODO: TEMPORARY pattern while I figure out a better way of sharing app services / singletons across fragment boundaries?
// Look into a better method of accessing things like this from a fragment/view that can just 'pop' into existence
// TODO: perhaps use a role interface based explicitly named services approach rather than this generic
// key based service locator which is probably harder to debug
public class ServiceLocator {

    // TODO: Is there a better location for Service IDs? So that service locator doesn't need to know about them?
    // TODO: look further into service locator/service implenentations
    // perhaps have a screenmanagerservice class that wraps the logic of getting
    // a screenmananger from the central service locator
    public static final String SCREEN_MANAGER = "ScreenManager";

    private Map<String, Object> mServices;

    private ServiceLocator() {
        mServices = new HashMap<String, Object>();
    }

    private static ServiceLocator mInstance;

    public static synchronized ServiceLocator getInstance() {
        if(mInstance == null) {
            mInstance = new ServiceLocator();
        }
        return mInstance;
    }

    public static void loadService(String serviceName, Object service) {
        ServiceLocator serviceLocator = getInstance();
        serviceLocator.mServices.put(serviceName, service);
    }

    public static Object getService(String serviceName) {
        ServiceLocator serviceLocator = getInstance();
        return serviceLocator.mServices.get(serviceName);
    }
}
