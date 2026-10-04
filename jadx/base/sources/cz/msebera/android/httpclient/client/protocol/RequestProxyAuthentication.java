package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.conn.HttpRoutedConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
public class RequestProxyAuthentication extends RequestAuthenticationBase {
    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        if (httpRequest.containsHeader("Proxy-Authorization")) {
            return;
        }
        HttpRoutedConnection httpRoutedConnection = (HttpRoutedConnection) httpContext.getAttribute("http.connection");
        if (httpRoutedConnection == null) {
            this.log.debug("HTTP connection not set in the context");
            return;
        }
        if (httpRoutedConnection.getRoute().isTunnelled()) {
            return;
        }
        AuthState authState = (AuthState) httpContext.getAttribute("http.auth.proxy-scope");
        if (authState == null) {
            this.log.debug("Proxy auth state not set in the context");
            return;
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("Proxy auth state: " + authState.getState());
        }
        process(authState, httpRequest, httpContext);
    }
}
