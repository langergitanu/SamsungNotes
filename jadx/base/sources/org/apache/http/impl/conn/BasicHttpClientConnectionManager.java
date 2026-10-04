package org.apache.http.impl.conn;

import android.util.Log;
import com.microsoft.identity.common.java.AuthenticationConstants;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpClientConnection;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.LangUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@ThreadSafe
public class BasicHttpClientConnectionManager implements HttpClientConnectionManager, Closeable {
    private static final String TAG = "HttpClient";

    @GuardedBy("this")
    private ManagedHttpClientConnection conn;

    @GuardedBy("this")
    private ConnectionConfig connConfig;
    private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
    private final HttpClientConnectionOperator connectionOperator;

    @GuardedBy("this")
    private long expiry;
    private final AtomicBoolean isShutdown;

    @GuardedBy("this")
    private boolean leased;

    @GuardedBy("this")
    private HttpRoute route;

    @GuardedBy("this")
    private SocketConfig socketConfig;

    @GuardedBy("this")
    private Object state;

    @GuardedBy("this")
    private long updated;

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        this.connectionOperator = new HttpClientConnectionOperator(lookup, schemePortResolver, dnsResolver);
        this.connFactory = httpConnectionFactory == null ? ManagedHttpClientConnectionFactory.INSTANCE : httpConnectionFactory;
        this.expiry = Long.MAX_VALUE;
        this.socketConfig = SocketConfig.DEFAULT;
        this.connConfig = ConnectionConfig.DEFAULT;
        this.isShutdown = new AtomicBoolean(false);
    }

    private void checkExpiry() {
        if (this.conn == null || System.currentTimeMillis() < this.expiry) {
            return;
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Connection expired @ " + new Date(this.expiry));
        }
        closeConnection();
    }

    private void closeConnection() {
        if (this.conn != null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Closing connection");
            }
            try {
                this.conn.close();
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "I/O exception closing connection", e);
                }
            }
            this.conn = null;
        }
    }

    private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register(AuthenticationConstants.HTTPS_PROTOCOL_STRING, SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    private void shutdownConnection() {
        if (this.conn != null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Shutting down connection");
            }
            try {
                this.conn.shutdown();
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "I/O exception shutting down connection", e);
                }
            }
            this.conn = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown();
    }

    @Override // org.apache.http.conn.HttpClientConnectionManager
    public synchronized void closeExpiredConnections() {
        if (this.isShutdown.get()) {
            return;
        }
        if (!this.leased) {
            checkExpiry();
        }
    }

    @Override // org.apache.http.conn.HttpClientConnectionManager
    public synchronized void closeIdleConnections(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        if (this.isShutdown.get()) {
            return;
        }
        if (!this.leased) {
            long millis = timeUnit.toMillis(j);
            if (millis < 0) {
                millis = 0;
            }
            if (this.updated <= System.currentTimeMillis() - millis) {
                closeConnection();
            }
        }
    }

    @Override // org.apache.http.conn.HttpClientConnectionManager
    public void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i, HttpContext httpContext) throws SocketException, ConnectTimeoutException, UnsupportedSchemeException {
        Args.notNull(httpClientConnection, "Connection");
        Args.notNull(httpRoute, "HTTP route");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        this.connectionOperator.connect(this.conn, httpRoute.getProxyHost() != null ? httpRoute.getProxyHost() : httpRoute.getTargetHost(), httpRoute.getLocalAddress() != null ? new InetSocketAddress(httpRoute.getLocalAddress(), 0) : null, i, this.socketConfig, httpContext);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public synchronized HttpClientConnection getConnection(HttpRoute httpRoute, Object obj) {
        try {
            Asserts.check(!this.isShutdown.get(), "Connection manager has been shut down");
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Get connection for route " + httpRoute);
            }
            Asserts.check(!this.leased, "Connection is still allocated");
            if (!LangUtils.equals(this.route, httpRoute) || !LangUtils.equals(this.state, obj)) {
                closeConnection();
            }
            this.route = httpRoute;
            this.state = obj;
            checkExpiry();
            if (this.conn == null) {
                this.conn = (ManagedHttpClientConnection) this.connFactory.create(httpRoute, this.connConfig);
            }
            this.leased = true;
        } catch (Throwable th) {
            throw th;
        }
        return this.conn;
    }

    public synchronized ConnectionConfig getConnectionConfig() {
        return this.connConfig;
    }

    public HttpRoute getRoute() {
        return this.route;
    }

    public synchronized SocketConfig getSocketConfig() {
        return this.socketConfig;
    }

    public Object getState() {
        return this.state;
    }

    @Override // org.apache.http.conn.HttpClientConnectionManager
    public synchronized void releaseConnection(HttpClientConnection httpClientConnection, Object obj, long j, TimeUnit timeUnit) {
        String str;
        try {
            Args.notNull(httpClientConnection, "Connection");
            Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Releasing connection " + httpClientConnection);
            }
            if (this.isShutdown.get()) {
                return;
            }
            try {
                this.updated = System.currentTimeMillis();
                if (this.conn.isOpen()) {
                    this.state = obj;
                    if (Log.isLoggable(TAG, 3)) {
                        if (j > 0) {
                            str = "for " + j + " " + timeUnit;
                        } else {
                            str = "indefinitely";
                        }
                        Log.d(TAG, "Connection can be kept alive " + str);
                    }
                    if (j > 0) {
                        this.expiry = this.updated + timeUnit.toMillis(j);
                    } else {
                        this.expiry = Long.MAX_VALUE;
                    }
                } else {
                    this.route = null;
                    this.conn = null;
                    this.expiry = Long.MAX_VALUE;
                }
                this.leased = false;
            } catch (Throwable th) {
                this.leased = false;
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // org.apache.http.conn.HttpClientConnectionManager
    public final ConnectionRequest requestConnection(final HttpRoute httpRoute, final Object obj) {
        Args.notNull(httpRoute, "Route");
        return new ConnectionRequest() { // from class: org.apache.http.impl.conn.BasicHttpClientConnectionManager.1
            @Override // org.apache.http.concurrent.Cancellable
            public boolean cancel() {
                return false;
            }

            @Override // org.apache.http.conn.ConnectionRequest
            public HttpClientConnection get(long j, TimeUnit timeUnit) {
                return BasicHttpClientConnectionManager.this.getConnection(httpRoute, obj);
            }
        };
    }

    public synchronized void setConnectionConfig(ConnectionConfig connectionConfig) {
        if (connectionConfig != null) {
            this.connConfig = connectionConfig;
        } else {
            connectionConfig = ConnectionConfig.DEFAULT;
            this.connConfig = connectionConfig;
        }
    }

    public synchronized void setSocketConfig(SocketConfig socketConfig) {
        if (socketConfig != null) {
            this.socketConfig = socketConfig;
        } else {
            socketConfig = SocketConfig.DEFAULT;
            this.socketConfig = socketConfig;
        }
    }

    @Override // org.apache.http.conn.HttpClientConnectionManager
    public synchronized void shutdown() {
        if (this.isShutdown.compareAndSet(false, true)) {
            shutdownConnection();
        }
    }

    @Override // org.apache.http.conn.HttpClientConnectionManager
    public void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws UnsupportedSchemeException {
        Args.notNull(httpClientConnection, "Connection");
        Args.notNull(httpRoute, "HTTP route");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        this.connectionOperator.upgrade(this.conn, httpRoute.getTargetHost(), httpContext);
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this(lookup, httpConnectionFactory, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup) {
        this(lookup, null, null, null);
    }

    public BasicHttpClientConnectionManager() {
        this(getDefaultRegistry(), null, null, null);
    }

    @Override // org.apache.http.conn.HttpClientConnectionManager
    public void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) {
    }
}
