package net.rossharper.hexrot;

import java.util.HashMap;
import java.util.Map;

// :(

// TODO: perhaps use a role interface based explicitly named services approach rather than this generic
// key based service locator which is probably harder to debug
public class ServiceLocator {

    // TODO: Is there a better location for Service IDs? So that service locator doesn't need to know about them?
    // TODO: look further into service locator/service implenentations
    // perhaps have a screenmanagerservice class that wraps the logic of getting
    // a screenmananger from the central service locator
    public static final String SCREEN_MANAGER = "ScreenManager";

    private Map<String, Object> mServices;

    public ServiceLocator() {
        mServices = new HashMap<String, Object>();
    }

    public void loadService(String serviceName, Object service) {
        mServices.put(serviceName, service);
    }

    public Object getService(String serviceName) {
        return mServices.get(serviceName);
    }
}
