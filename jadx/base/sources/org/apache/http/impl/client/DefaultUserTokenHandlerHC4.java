package org.apache.http.impl.client;

import java.security.Principal;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpConnection;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.auth.Credentials;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class DefaultUserTokenHandlerHC4 implements UserTokenHandler {
    public static final DefaultUserTokenHandlerHC4 INSTANCE = new DefaultUserTokenHandlerHC4();

    private static Principal getAuthPrincipal(AuthStateHC4 authStateHC4) {
        Credentials credentials;
        AuthScheme authScheme = authStateHC4.getAuthScheme();
        if (authScheme == null || !authScheme.isComplete() || !authScheme.isConnectionBased() || (credentials = authStateHC4.getCredentials()) == null) {
            return null;
        }
        return credentials.getUserPrincipal();
    }

    @Override // org.apache.http.client.UserTokenHandler
    public Object getUserToken(HttpContext httpContext) {
        Principal authPrincipal;
        SSLSession sSLSession;
        HttpClientContext httpClientContextAdapt = HttpClientContext.adapt(httpContext);
        AuthStateHC4 targetAuthState = httpClientContextAdapt.getTargetAuthState();
        if (targetAuthState != null) {
            authPrincipal = getAuthPrincipal(targetAuthState);
            if (authPrincipal == null) {
                authPrincipal = getAuthPrincipal(httpClientContextAdapt.getProxyAuthState());
            }
        } else {
            authPrincipal = null;
        }
        if (authPrincipal == null) {
            HttpConnection connection = httpClientContextAdapt.getConnection();
            if (connection.isOpen() && (connection instanceof ManagedHttpClientConnection) && (sSLSession = ((ManagedHttpClientConnection) connection).getSSLSession()) != null) {
                return sSLSession.getLocalPrincipal();
            }
        }
        return authPrincipal;
    }
}
