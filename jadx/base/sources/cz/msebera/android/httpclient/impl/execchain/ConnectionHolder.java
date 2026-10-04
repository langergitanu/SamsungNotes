package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.concurrent.Cancellable;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE)
class ConnectionHolder implements ConnectionReleaseTrigger, Cancellable, Closeable {
    private final HttpClientAndroidLog log;
    private final HttpClientConnection managedConn;
    private final HttpClientConnectionManager manager;
    private final AtomicBoolean released = new AtomicBoolean(false);
    private volatile boolean reusable;
    private volatile Object state;
    private volatile TimeUnit timeUnit;
    private volatile long validDuration;

    public ConnectionHolder(HttpClientAndroidLog httpClientAndroidLog, HttpClientConnectionManager httpClientConnectionManager, HttpClientConnection httpClientConnection) {
        this.log = httpClientAndroidLog;
        this.manager = httpClientConnectionManager;
        this.managedConn = httpClientConnection;
    }

    private void releaseConnection(boolean z) {
        HttpClientConnectionManager httpClientConnectionManager;
        HttpClientConnection httpClientConnection;
        if (this.released.compareAndSet(false, true)) {
            synchronized (this.managedConn) {
                try {
                    if (z) {
                        this.manager.releaseConnection(this.managedConn, this.state, this.validDuration, this.timeUnit);
                    } else {
                        try {
                            this.managedConn.close();
                            this.log.debug("Connection discarded");
                            httpClientConnectionManager = this.manager;
                            httpClientConnection = this.managedConn;
                        } catch (IOException e) {
                            if (this.log.isDebugEnabled()) {
                                this.log.debug(e.getMessage(), e);
                            }
                            httpClientConnectionManager = this.manager;
                            httpClientConnection = this.managedConn;
                        }
                        httpClientConnectionManager.releaseConnection(httpClientConnection, null, 0L, TimeUnit.MILLISECONDS);
                    }
                } catch (Throwable th) {
                    this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
                    throw th;
                }
            }
        }
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        if (this.released.compareAndSet(false, true)) {
            synchronized (this.managedConn) {
                try {
                    try {
                        this.managedConn.shutdown();
                        this.log.debug("Connection discarded");
                        this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
                    } catch (IOException e) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug(e.getMessage(), e);
                        }
                    }
                } finally {
                    this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    @Override // cz.msebera.android.httpclient.concurrent.Cancellable
    public boolean cancel() {
        boolean z = this.released.get();
        this.log.debug("Cancelling request execution");
        abortConnection();
        return !z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        releaseConnection(false);
    }

    public boolean isReleased() {
        return this.released.get();
    }

    public boolean isReusable() {
        return this.reusable;
    }

    public void markNonReusable() {
        this.reusable = false;
    }

    public void markReusable() {
        this.reusable = true;
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public void setValidFor(long j, TimeUnit timeUnit) {
        synchronized (this.managedConn) {
            this.validDuration = j;
            this.timeUnit = timeUnit;
        }
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        releaseConnection(this.reusable);
    }
}
