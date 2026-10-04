package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE)
class CPoolEntry extends PoolEntry<HttpRoute, ManagedHttpClientConnection> {
    private final HttpClientAndroidLog log;
    private volatile boolean routeComplete;

    public CPoolEntry(HttpClientAndroidLog httpClientAndroidLog, String str, HttpRoute httpRoute, ManagedHttpClientConnection managedHttpClientConnection, long j, TimeUnit timeUnit) {
        super(str, httpRoute, managedHttpClientConnection, j, timeUnit);
        this.log = httpClientAndroidLog;
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public void close() {
        try {
            closeConnection();
        } catch (IOException e) {
            this.log.debug("I/O error closing connection", e);
        }
    }

    public void closeConnection() {
        getConnection().close();
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public boolean isClosed() {
        return !getConnection().isOpen();
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public boolean isExpired(long j) {
        boolean zIsExpired = super.isExpired(j);
        if (zIsExpired && this.log.isDebugEnabled()) {
            this.log.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
        }
        return zIsExpired;
    }

    public boolean isRouteComplete() {
        return this.routeComplete;
    }

    public void markRouteComplete() {
        this.routeComplete = true;
    }

    public void shutdownConnection() {
        getConnection().shutdown();
    }
}
