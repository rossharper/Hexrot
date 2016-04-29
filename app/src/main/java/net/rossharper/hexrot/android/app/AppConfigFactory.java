package net.rossharper.hexrot.android.app;

import net.rossharper.hexrot.AppConfig;

import java.util.HashMap;
import java.util.Map;

// TODO: something better than static constants
// How about async AppConfigFactory loading? hides remote config loading, just cache it.
public class AppConfigFactory {
    public static final String SODA_LIST_URL = "https://raw.githubusercontent.com/rossharper/Hexrot/master/servicedata/sodalist.json";

    public static AppConfig create() {
        final Map<String, String> configStrings = new HashMap<>();
        configStrings.put("SODA_LIST_URL", SODA_LIST_URL);
        return new AppConfig() {
            @Override
            public String getConfigString(String key) {
                return configStrings.get(key);
            }
        };
    }
}
