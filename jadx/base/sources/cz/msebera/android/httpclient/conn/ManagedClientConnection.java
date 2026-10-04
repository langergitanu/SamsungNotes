package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public interface ManagedClientConnection extends HttpRoutedConnection, ManagedHttpClientConnection, ConnectionReleaseTrigger {
    @Override // cz.msebera.android.httpclient.conn.HttpRoutedConnection
    HttpRoute getRoute();

    @Override // cz.msebera.android.httpclient.conn.HttpRoutedConnection, cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    SSLSession getSSLSession();

    Object getState();

    boolean isMarkedReusable();

    @Override // cz.msebera.android.httpclient.conn.HttpRoutedConnection
    boolean isSecure();

    void layerProtocol(HttpContext httpContext, HttpParams httpParams);

    void markReusable();

    void open(HttpRoute httpRoute, HttpContext httpContext, HttpParams httpParams);

    void setIdleDuration(long j, TimeUnit timeUnit);

    void setState(Object obj);

    void tunnelProxy(HttpHost httpHost, boolean z, HttpParams httpParams);

    void tunnelTarget(boolean z, HttpParams httpParams);

    void unmarkReusable();
}
