package org.apache.http.pool;

import androidx.compose.runtime.AbstractC1974b;
import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@ThreadSafe
public abstract class PoolEntry<T, C> {
    private final C conn;
    private final long created;

    @GuardedBy("this")
    private long expiry;

    /* JADX INFO: renamed from: id */
    private final String f10030id;
    private final T route;
    private volatile Object state;

    @GuardedBy("this")
    private long updated;
    private final long validUnit;

    public PoolEntry(String str, T t, C c, long j, TimeUnit timeUnit) {
        Args.notNull(t, "Route");
        Args.notNull(c, "Connection");
        Args.notNull(timeUnit, "Time unit");
        this.f10030id = str;
        this.route = t;
        this.conn = c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.created = jCurrentTimeMillis;
        if (j > 0) {
            this.validUnit = timeUnit.toMillis(j) + jCurrentTimeMillis;
        } else {
            this.validUnit = Long.MAX_VALUE;
        }
        this.expiry = this.validUnit;
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
        return this.f10030id;
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

    public long getValidUnit() {
        return this.validUnit;
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
        sb.append(this.f10030id);
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
            this.expiry = Math.min(j > 0 ? jCurrentTimeMillis + timeUnit.toMillis(j) : Long.MAX_VALUE, this.validUnit);
        } catch (Throwable th) {
            throw th;
        }
    }

    public PoolEntry(String str, T t, C c) {
        this(str, t, c, 0L, TimeUnit.MILLISECONDS);
    }
}
