package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class IdleConnectionHandler {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final Map<HttpConnection, TimeValues> connectionToTimes = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TimeValues {
        private final long timeAdded;
        private final long timeExpires;

        public TimeValues(long j, long j2, TimeUnit timeUnit) {
            this.timeAdded = j;
            if (j2 > 0) {
                this.timeExpires = timeUnit.toMillis(j2) + j;
            } else {
                this.timeExpires = Long.MAX_VALUE;
            }
        }
    }

    public void add(HttpConnection httpConnection, long j, TimeUnit timeUnit) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Adding connection at: " + jCurrentTimeMillis);
        }
        this.connectionToTimes.put(httpConnection, new TimeValues(jCurrentTimeMillis, j, timeUnit));
    }

    public void closeExpiredConnections() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Checking for expired connections, now: " + jCurrentTimeMillis);
        }
        for (Map.Entry<HttpConnection, TimeValues> entry : this.connectionToTimes.entrySet()) {
            HttpConnection key = entry.getKey();
            TimeValues value = entry.getValue();
            if (value.timeExpires <= jCurrentTimeMillis) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Closing connection, expired @: " + value.timeExpires);
                }
                try {
                    key.close();
                } catch (IOException e) {
                    this.log.debug("I/O error closing connection", e);
                }
            }
        }
    }

    public void closeIdleConnections(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (this.log.isDebugEnabled()) {
            this.log.debug("Checking for connections, idle timeout: " + jCurrentTimeMillis);
        }
        for (Map.Entry<HttpConnection, TimeValues> entry : this.connectionToTimes.entrySet()) {
            HttpConnection key = entry.getKey();
            long j2 = entry.getValue().timeAdded;
            if (j2 <= jCurrentTimeMillis) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Closing idle connection, connection time: " + j2);
                }
                try {
                    key.close();
                } catch (IOException e) {
                    this.log.debug("I/O error closing connection", e);
                }
            }
        }
    }

    public boolean remove(HttpConnection httpConnection) {
        TimeValues timeValuesRemove = this.connectionToTimes.remove(httpConnection);
        if (timeValuesRemove != null) {
            return System.currentTimeMillis() <= timeValuesRemove.timeExpires;
        }
        this.log.warn("Removing a connection that never existed!");
        return true;
    }

    public void removeAll() {
        this.connectionToTimes.clear();
    }
}
