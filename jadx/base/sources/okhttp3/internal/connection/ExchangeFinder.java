package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class ExchangeFinder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Address address;
    private final Call call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private boolean hasStreamFailure;
    private Route nextRouteToTry;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;
    private final Transmitter transmitter;

    public ExchangeFinder(Transmitter transmitter, RealConnectionPool realConnectionPool, Address address, Call call, EventListener eventListener) {
        this.transmitter = transmitter;
        this.connectionPool = realConnectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(address, realConnectionPool.routeDatabase, call, eventListener);
    }

    private RealConnection findConnection(int i, int i2, int i4, int i5, boolean z) throws Throwable {
        RealConnection realConnection;
        Socket socket;
        Socket socketReleaseConnectionNoEvents;
        RealConnection realConnection2;
        boolean z2;
        Route next;
        boolean z3;
        List<Route> all;
        RealConnection realConnection3;
        RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            try {
                if (this.transmitter.isCanceled()) {
                    throw new IOException("Canceled");
                }
                this.hasStreamFailure = false;
                Transmitter transmitter = this.transmitter;
                realConnection = transmitter.connection;
                socket = null;
                socketReleaseConnectionNoEvents = (realConnection == null || !realConnection.noNewExchanges) ? null : transmitter.releaseConnectionNoEvents();
                Transmitter transmitter2 = this.transmitter;
                realConnection2 = transmitter2.connection;
                if (realConnection2 != null) {
                    realConnection = null;
                } else {
                    realConnection2 = null;
                }
                if (realConnection2 != null) {
                    z2 = false;
                    next = null;
                } else if (this.connectionPool.transmitterAcquirePooledConnection(this.address, transmitter2, null, false)) {
                    realConnection2 = this.transmitter.connection;
                    next = null;
                    z2 = true;
                } else {
                    next = this.nextRouteToTry;
                    if (next != null) {
                        this.nextRouteToTry = null;
                    } else {
                        if (retryCurrentRoute()) {
                            next = this.transmitter.connection.route();
                        }
                        z2 = false;
                        next = null;
                    }
                    z2 = false;
                }
            } finally {
            }
        }
        Util.closeQuietly(socketReleaseConnectionNoEvents);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (next != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z3 = true;
        }
        synchronized (this.connectionPool) {
            try {
                if (this.transmitter.isCanceled()) {
                    throw new IOException("Canceled");
                }
                if (z3) {
                    all = this.routeSelection.getAll();
                    if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, all, false)) {
                        realConnection2 = this.transmitter.connection;
                        z2 = true;
                    }
                } else {
                    all = null;
                }
                if (!z2) {
                    if (next == null) {
                        next = this.routeSelection.next();
                    }
                    realConnection2 = new RealConnection(this.connectionPool, next);
                    this.connectingConnection = realConnection2;
                }
                realConnection3 = realConnection2;
            } finally {
            }
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection3);
            return realConnection3;
        }
        realConnection3.connect(i, i2, i4, i5, z, this.call, this.eventListener);
        this.connectionPool.routeDatabase.connected(realConnection3.route());
        synchronized (this.connectionPool) {
            try {
                this.connectingConnection = null;
                if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, all, true)) {
                    realConnection3.noNewExchanges = true;
                    socket = realConnection3.socket();
                    realConnection3 = this.transmitter.connection;
                    this.nextRouteToTry = next;
                } else {
                    this.connectionPool.put(realConnection3);
                    this.transmitter.acquireConnectionNoEvents(realConnection3);
                }
            } finally {
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection3);
        return realConnection3;
    }

    private RealConnection findHealthyConnection(int i, int i2, int i4, int i5, boolean z, boolean z2) throws Throwable {
        while (true) {
            RealConnection realConnectionFindConnection = findConnection(i, i2, i4, i5, z);
            boolean z3 = z;
            int i6 = i5;
            int i7 = i4;
            int i8 = i2;
            int i9 = i;
            synchronized (this.connectionPool) {
                try {
                    if (realConnectionFindConnection.successCount == 0 && !realConnectionFindConnection.isMultiplexed()) {
                        return realConnectionFindConnection;
                    }
                    if (realConnectionFindConnection.isHealthy(z2)) {
                        return realConnectionFindConnection;
                    }
                    realConnectionFindConnection.noNewExchanges();
                    i = i9;
                    i2 = i8;
                    i4 = i7;
                    i5 = i6;
                    z = z3;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private boolean retryCurrentRoute() {
        RealConnection realConnection = this.transmitter.connection;
        return realConnection != null && realConnection.routeFailureCount == 0 && Util.sameConnection(realConnection.route().address().url(), this.address.url());
    }

    public RealConnection connectingConnection() {
        return this.connectingConnection;
    }

    public ExchangeCodec find(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            return findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain);
        } catch (IOException e) {
            trackFailure();
            throw new RouteException(e);
        } catch (RouteException e2) {
            trackFailure();
            throw e2;
        }
    }

    public boolean hasRouteToTry() {
        synchronized (this.connectionPool) {
            try {
                boolean z = true;
                if (this.nextRouteToTry != null) {
                    return true;
                }
                if (retryCurrentRoute()) {
                    this.nextRouteToTry = this.transmitter.connection.route();
                    return true;
                }
                RouteSelector.Selection selection = this.routeSelection;
                if ((selection == null || !selection.hasNext()) && !this.routeSelector.hasNext()) {
                    z = false;
                }
                return z;
            } finally {
            }
        }
    }

    public boolean hasStreamFailure() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.hasStreamFailure;
        }
        return z;
    }

    public void trackFailure() {
        synchronized (this.connectionPool) {
            this.hasStreamFailure = true;
        }
    }
}
