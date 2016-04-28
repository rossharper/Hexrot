package net.rossharper.hexrot.android.network;

import java.util.Date;

public class SystemTimeProvider implements TimeProvider {
    public long getCurrentTimeInMillis() {
        return new Date().getTime();
    }
}
