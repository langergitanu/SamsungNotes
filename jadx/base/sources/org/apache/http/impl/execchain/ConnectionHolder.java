package org.apache.http.impl.execchain;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpClientConnection;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.conn.HttpClientConnectionManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@ThreadSafe
class ConnectionHolder implements ConnectionReleaseTrigger, Cancellable, Closeable {
    private static final String TAG = "HttpClient";
    private final HttpClientConnection managedConn;
    private final HttpClientConnectionManager manager;
    private volatile boolean released;
    private volatile boolean reusable;
    private volatile Object state;
    private volatile TimeUnit tunit;
    private volatile long validDuration;

    public ConnectionHolder(HttpClientConnectionManager httpClientConnectionManager, HttpClientConnection httpClientConnection) {
        this.manager = httpClientConnectionManager;
        this.managedConn = httpClientConnection;
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        synchronized (this.managedConn) {
            try {
                if (this.released) {
                    return;
                }
                this.released = true;
                try {
                    this.managedConn.shutdown();
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Connection discarded");
                    }
                } catch (IOException e) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, e.getMessage(), e);
                    }
                } finally {
                    this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.http.concurrent.Cancellable
    public boolean cancel() {
        boolean z = this.released;
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Cancelling request execution");
        }
        abortConnection();
        return !z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        abortConnection();
    }

    public boolean isReleased() {
        return this.released;
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

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        synchronized (this.managedConn) {
            try {
                if (this.released) {
                    return;
                }
                this.released = true;
                if (this.reusable) {
                    this.manager.releaseConnection(this.managedConn, this.state, this.validDuration, this.tunit);
                } else {
                    try {
                        this.managedConn.close();
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Connection discarded");
                        }
                    } catch (IOException e) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, e.getMessage(), e);
                        }
                    } finally {
                        this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public void setValidFor(long j, TimeUnit timeUnit) {
        synchronized (this.managedConn) {
            this.validDuration = j;
            this.tunit = timeUnit;
        }
    }
}
