package org.apache.http.client.params;

import cz.msebera.android.httpclient.conn.params.ConnRoutePNames;
import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import cz.msebera.android.httpclient.params.CoreProtocolPNames;
import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.params.HttpParams;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public final class HttpClientParamConfig {
    private HttpClientParamConfig() {
    }

    public static RequestConfig getRequestConfig(HttpParams httpParams) {
        return RequestConfig.custom().setSocketTimeout(httpParams.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0)).setStaleConnectionCheckEnabled(httpParams.getBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true)).setConnectTimeout(httpParams.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0)).setExpectContinueEnabled(httpParams.getBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false)).setProxy((HttpHost) httpParams.getParameter(ConnRoutePNames.DEFAULT_PROXY)).setLocalAddress((InetAddress) httpParams.getParameter(ConnRoutePNames.LOCAL_ADDRESS)).setAuthenticationEnabled(httpParams.getBooleanParameter(cz.msebera.android.httpclient.client.params.ClientPNames.HANDLE_AUTHENTICATION, true)).setCircularRedirectsAllowed(httpParams.getBooleanParameter(cz.msebera.android.httpclient.client.params.ClientPNames.ALLOW_CIRCULAR_REDIRECTS, false)).setCookieSpec((String) httpParams.getParameter(cz.msebera.android.httpclient.client.params.ClientPNames.COOKIE_POLICY)).setMaxRedirects(httpParams.getIntParameter(cz.msebera.android.httpclient.client.params.ClientPNames.MAX_REDIRECTS, 50)).setRedirectsEnabled(httpParams.getBooleanParameter(cz.msebera.android.httpclient.client.params.ClientPNames.HANDLE_REDIRECTS, true)).setRelativeRedirectsAllowed(!httpParams.getBooleanParameter(cz.msebera.android.httpclient.client.params.ClientPNames.REJECT_RELATIVE_REDIRECT, false)).build();
    }
}
