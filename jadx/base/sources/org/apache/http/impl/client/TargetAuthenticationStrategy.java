package org.apache.http.impl.client;

import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class TargetAuthenticationStrategy extends AuthenticationStrategyImpl {
    public static final TargetAuthenticationStrategy INSTANCE = new TargetAuthenticationStrategy();

    public TargetAuthenticationStrategy() {
        super(401, "WWW-Authenticate");
    }

    @Override // org.apache.http.impl.client.AuthenticationStrategyImpl, org.apache.http.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ void authFailed(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        super.authFailed(httpHost, authScheme, httpContext);
    }

    @Override // org.apache.http.impl.client.AuthenticationStrategyImpl, org.apache.http.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ void authSucceeded(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        super.authSucceeded(httpHost, authScheme, httpContext);
    }

    @Override // org.apache.http.impl.client.AuthenticationStrategyImpl, org.apache.http.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ Map getChallenges(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        return super.getChallenges(httpHost, httpResponse, httpContext);
    }

    @Override // org.apache.http.impl.client.AuthenticationStrategyImpl
    public Collection<String> getPreferredAuthSchemes(RequestConfig requestConfig) {
        return requestConfig.getTargetPreferredAuthSchemes();
    }

    @Override // org.apache.http.impl.client.AuthenticationStrategyImpl, org.apache.http.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        return super.isAuthenticationRequested(httpHost, httpResponse, httpContext);
    }

    @Override // org.apache.http.impl.client.AuthenticationStrategyImpl, org.apache.http.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ Queue select(Map map, HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        return super.select(map, httpHost, httpResponse, httpContext);
    }
}
