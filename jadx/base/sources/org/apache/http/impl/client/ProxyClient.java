package org.apache.http.impl.client;

import com.google.api.client.http.HttpMethods;
import java.io.IOException;
import java.net.Socket;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.auth.Credentials;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.params.HttpClientParamConfig;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.entity.BufferedHttpEntityHC4;
import org.apache.http.impl.DefaultConnectionReuseStrategyHC4;
import org.apache.http.impl.auth.BasicSchemeFactoryHC4;
import org.apache.http.impl.auth.DigestSchemeFactoryHC4;
import org.apache.http.impl.auth.HttpAuthenticator;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContextHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestTargetHostHC4;
import org.apache.http.protocol.RequestUserAgentHC4;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtilsHC4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ProxyClient {
    private final AuthSchemeRegistry authSchemeRegistry;
    private final HttpAuthenticator authenticator;
    private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
    private final ConnectionConfig connectionConfig;
    private final HttpProcessor httpProcessor;
    private final AuthStateHC4 proxyAuthState;
    private final ProxyAuthenticationStrategy proxyAuthStrategy;
    private final RequestConfig requestConfig;
    private final HttpRequestExecutor requestExec;
    private final ConnectionReuseStrategy reuseStrategy;

    public ProxyClient(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, ConnectionConfig connectionConfig, RequestConfig requestConfig) {
        this.connFactory = httpConnectionFactory == null ? ManagedHttpClientConnectionFactory.INSTANCE : httpConnectionFactory;
        this.connectionConfig = connectionConfig == null ? ConnectionConfig.DEFAULT : connectionConfig;
        this.requestConfig = requestConfig == null ? RequestConfig.DEFAULT : requestConfig;
        this.httpProcessor = new ImmutableHttpProcessor(new RequestTargetHostHC4(), new RequestClientConnControl(), new RequestUserAgentHC4());
        this.requestExec = new HttpRequestExecutor();
        this.proxyAuthStrategy = new ProxyAuthenticationStrategy();
        this.authenticator = new HttpAuthenticator();
        this.proxyAuthState = new AuthStateHC4();
        AuthSchemeRegistry authSchemeRegistry = new AuthSchemeRegistry();
        this.authSchemeRegistry = authSchemeRegistry;
        authSchemeRegistry.register("Basic", new BasicSchemeFactoryHC4());
        authSchemeRegistry.register("Digest", new DigestSchemeFactoryHC4());
        authSchemeRegistry.register("NTLM", new NTLMSchemeFactory());
        this.reuseStrategy = new DefaultConnectionReuseStrategyHC4();
    }

    @Deprecated
    public AuthSchemeRegistry getAuthSchemeRegistry() {
        return this.authSchemeRegistry;
    }

    @Deprecated
    public HttpParams getParams() {
        return new BasicHttpParams();
    }

    public Socket tunnel(HttpHost httpHost, HttpHost httpHost2, Credentials credentials) throws HttpException, IOException {
        HttpResponse httpResponseExecute;
        Args.notNull(httpHost, "Proxy host");
        Args.notNull(httpHost2, "Target host");
        Args.notNull(credentials, "Credentials");
        HttpHost httpHost3 = httpHost2.getPort() <= 0 ? new HttpHost(httpHost2.getHostName(), 80, httpHost2.getSchemeName()) : httpHost2;
        HttpRoute httpRoute = new HttpRoute(httpHost3, this.requestConfig.getLocalAddress(), httpHost, false, RouteInfo.TunnelType.TUNNELLED, RouteInfo.LayerType.PLAIN);
        ManagedHttpClientConnection managedHttpClientConnection = (ManagedHttpClientConnection) this.connFactory.create(httpRoute, this.connectionConfig);
        HttpContext basicHttpContextHC4 = new BasicHttpContextHC4();
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest(HttpMethods.CONNECT, httpHost3.toHostString(), HttpVersion.HTTP_1_1);
        BasicCredentialsProviderHC4 basicCredentialsProviderHC4 = new BasicCredentialsProviderHC4();
        basicCredentialsProviderHC4.setCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()), credentials);
        basicHttpContextHC4.setAttribute("http.target_host", httpHost2);
        basicHttpContextHC4.setAttribute("http.connection", managedHttpClientConnection);
        basicHttpContextHC4.setAttribute("http.request", basicHttpRequest);
        basicHttpContextHC4.setAttribute("http.route", httpRoute);
        basicHttpContextHC4.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
        basicHttpContextHC4.setAttribute("http.auth.credentials-provider", basicCredentialsProviderHC4);
        basicHttpContextHC4.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
        basicHttpContextHC4.setAttribute("http.request-config", this.requestConfig);
        this.requestExec.preProcess(basicHttpRequest, this.httpProcessor, basicHttpContextHC4);
        while (true) {
            if (!managedHttpClientConnection.isOpen()) {
                managedHttpClientConnection.bind(new Socket(httpHost.getHostName(), httpHost.getPort()));
            }
            this.authenticator.generateAuthResponse(basicHttpRequest, this.proxyAuthState, basicHttpContextHC4);
            httpResponseExecute = this.requestExec.execute(basicHttpRequest, managedHttpClientConnection, basicHttpContextHC4);
            if (httpResponseExecute.getStatusLine().getStatusCode() < 200) {
                throw new HttpException("Unexpected response to CONNECT request: " + httpResponseExecute.getStatusLine());
            }
            if (!this.authenticator.isAuthenticationRequested(httpHost, httpResponseExecute, this.proxyAuthStrategy, this.proxyAuthState, basicHttpContextHC4) || !this.authenticator.handleAuthChallenge(httpHost, httpResponseExecute, this.proxyAuthStrategy, this.proxyAuthState, basicHttpContextHC4)) {
                break;
            }
            if (this.reuseStrategy.keepAlive(httpResponseExecute, basicHttpContextHC4)) {
                EntityUtilsHC4.consume(httpResponseExecute.getEntity());
            } else {
                managedHttpClientConnection.close();
            }
            basicHttpRequest.removeHeaders("Proxy-Authorization");
        }
        if (httpResponseExecute.getStatusLine().getStatusCode() <= 299) {
            return managedHttpClientConnection.getSocket();
        }
        HttpEntity entity = httpResponseExecute.getEntity();
        if (entity != null) {
            httpResponseExecute.setEntity(new BufferedHttpEntityHC4(entity));
        }
        managedHttpClientConnection.close();
        throw new org.apache.http.impl.execchain.TunnelRefusedException("CONNECT refused by proxy: " + httpResponseExecute.getStatusLine(), httpResponseExecute);
    }

    @Deprecated
    public ProxyClient(HttpParams httpParams) {
        this(null, HttpParamConfig.getConnectionConfig(httpParams), HttpClientParamConfig.getRequestConfig(httpParams));
    }

    public ProxyClient(RequestConfig requestConfig) {
        this(null, null, requestConfig);
    }

    public ProxyClient() {
        this(null, null, null);
    }
}
