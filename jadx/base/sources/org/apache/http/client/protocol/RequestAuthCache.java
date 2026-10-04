package org.apache.http.client.protocol;

import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.auth.Credentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class RequestAuthCache implements HttpRequestInterceptor {
    private static final String TAG = "HttpClient";

    private void doPreemptiveAuth(HttpHost httpHost, AuthScheme authScheme, AuthStateHC4 authStateHC4, CredentialsProvider credentialsProvider) {
        String schemeName = authScheme.getSchemeName();
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Re-using cached '" + schemeName + "' auth scheme for " + httpHost);
        }
        Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort(), AuthScope.ANY_REALM, schemeName));
        if (credentials == null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "No credentials for preemptive authentication");
            }
        } else {
            if ("BASIC".equalsIgnoreCase(authScheme.getSchemeName())) {
                authStateHC4.setState(AuthProtocolState.CHALLENGED);
            } else {
                authStateHC4.setState(AuthProtocolState.SUCCESS);
            }
            authStateHC4.update(authScheme, credentials);
        }
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        AuthScheme authScheme;
        AuthScheme authScheme2;
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext httpClientContextAdapt = HttpClientContext.adapt(httpContext);
        AuthCache authCache = httpClientContextAdapt.getAuthCache();
        if (authCache == null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Auth cache not set in the context");
                return;
            }
            return;
        }
        CredentialsProvider credentialsProvider = httpClientContextAdapt.getCredentialsProvider();
        if (credentialsProvider == null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Credentials provider not set in the context");
                return;
            }
            return;
        }
        RouteInfo httpRoute = httpClientContextAdapt.getHttpRoute();
        if (httpRoute == null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Route info not set in the context");
                return;
            }
            return;
        }
        HttpHost targetHost = httpClientContextAdapt.getTargetHost();
        if (targetHost == null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Target host not set in the context");
                return;
            }
            return;
        }
        if (targetHost.getPort() < 0) {
            targetHost = new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName());
        }
        AuthStateHC4 targetAuthState = httpClientContextAdapt.getTargetAuthState();
        if (targetAuthState != null && targetAuthState.getState() == AuthProtocolState.UNCHALLENGED && (authScheme2 = authCache.get(targetHost)) != null) {
            doPreemptiveAuth(targetHost, authScheme2, targetAuthState, credentialsProvider);
        }
        HttpHost proxyHost = httpRoute.getProxyHost();
        AuthStateHC4 proxyAuthState = httpClientContextAdapt.getProxyAuthState();
        if (proxyHost == null || proxyAuthState == null || proxyAuthState.getState() != AuthProtocolState.UNCHALLENGED || (authScheme = authCache.get(proxyHost)) == null) {
            return;
        }
        doPreemptiveAuth(proxyHost, authScheme, proxyAuthState, credentialsProvider);
    }
}
