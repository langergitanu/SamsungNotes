package org.apache.http.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.HttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface HttpClientConnectionManager {
    void closeExpiredConnections();

    void closeIdleConnections(long j, TimeUnit timeUnit);

    void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i, HttpContext httpContext);

    void releaseConnection(HttpClientConnection httpClientConnection, Object obj, long j, TimeUnit timeUnit);

    ConnectionRequest requestConnection(HttpRoute httpRoute, Object obj);

    void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext);

    void shutdown();

    void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext);
}
