package net.rossharper.hexrot.time;

import java.util.Date;

public class SystemTimeProvider implements TimeProvider {
    public long getCurrentTimeInMillis() {
        return new Date().getTime();
    }
}
