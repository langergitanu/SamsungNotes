package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.NoConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.conn.PoolingClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.ProxySelectorRoutePlanner;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import java.net.ProxySelector;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
public class SystemDefaultHttpClient extends DefaultHttpClient {
    public SystemDefaultHttpClient(HttpParams httpParams) {
        super(null, httpParams);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractHttpClient
    public ClientConnectionManager createClientConnectionManager() {
        PoolingClientConnectionManager poolingClientConnectionManager = new PoolingClientConnectionManager(SchemeRegistryFactory.createSystemDefault());
        if ("true".equalsIgnoreCase(System.getProperty(SystemProperties.HTTP_KEEP_ALIVE, "true"))) {
            int i = Integer.parseInt(System.getProperty(SystemProperties.HTTP_MAX_CONNECTIONS, "5"));
            poolingClientConnectionManager.setDefaultMaxPerRoute(i);
            poolingClientConnectionManager.setMaxTotal(i * 2);
        }
        return poolingClientConnectionManager;
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractHttpClient
    public ConnectionReuseStrategy createConnectionReuseStrategy() {
        return "true".equalsIgnoreCase(System.getProperty(SystemProperties.HTTP_KEEP_ALIVE, "true")) ? new DefaultConnectionReuseStrategy() : new NoConnectionReuseStrategy();
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractHttpClient
    public HttpRoutePlanner createHttpRoutePlanner() {
        return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), ProxySelector.getDefault());
    }

    public SystemDefaultHttpClient() {
        super(null, null);
    }
}
