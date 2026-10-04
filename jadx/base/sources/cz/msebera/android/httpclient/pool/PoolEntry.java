package cz.msebera.android.httpclient.pool;

import androidx.compose.runtime.AbstractC1974b;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
public abstract class PoolEntry<T, C> {
    private final C conn;
    private final long created;
    private long expiry;

    /* JADX INFO: renamed from: id */
    private final String f8512id;
    private final T route;
    private volatile Object state;
    private long updated;
    private final long validityDeadline;

    public PoolEntry(String str, T t, C c, long j, TimeUnit timeUnit) {
        Args.notNull(t, "Route");
        Args.notNull(c, "Connection");
        Args.notNull(timeUnit, "Time unit");
        this.f8512id = str;
        this.route = t;
        this.conn = c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.created = jCurrentTimeMillis;
        this.updated = jCurrentTimeMillis;
        if (j > 0) {
            long millis = timeUnit.toMillis(j) + jCurrentTimeMillis;
            this.validityDeadline = millis > 0 ? millis : Long.MAX_VALUE;
        } else {
            this.validityDeadline = Long.MAX_VALUE;
        }
        this.expiry = this.validityDeadline;
    }

    public abstract void close();

    public C getConnection() {
        return this.conn;
    }

    public long getCreated() {
        return this.created;
    }

    public synchronized long getExpiry() {
        return this.expiry;
    }

    public String getId() {
        return this.f8512id;
    }

    public T getRoute() {
        return this.route;
    }

    public Object getState() {
        return this.state;
    }

    public synchronized long getUpdated() {
        return this.updated;
    }

    @Deprecated
    public long getValidUnit() {
        return this.validityDeadline;
    }

    public long getValidityDeadline() {
        return this.validityDeadline;
    }

    public abstract boolean isClosed();

    public synchronized boolean isExpired(long j) {
        return j >= this.expiry;
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[id:");
        sb.append(this.f8512id);
        sb.append("][route:");
        sb.append(this.route);
        sb.append("][state:");
        return AbstractC1974b.m1320m(sb, this.state, "]");
    }

    public synchronized void updateExpiry(long j, TimeUnit timeUnit) {
        try {
            Args.notNull(timeUnit, "Time unit");
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.updated = jCurrentTimeMillis;
            this.expiry = Math.min(j > 0 ? jCurrentTimeMillis + timeUnit.toMillis(j) : Long.MAX_VALUE, this.validityDeadline);
        } catch (Throwable th) {
            throw th;
        }
    }

    public PoolEntry(String str, T t, C c) {
        this(str, t, c, 0L, TimeUnit.MILLISECONDS);
    }
}
