package cz.msebera.android.httpclient.impl.execchain;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.api.client.http.HttpMethods;
import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.BasicRouteDirector;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRouteDirector;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.auth.HttpAuthenticator;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class MainClientExec implements ClientExecChain {
    private final HttpAuthenticator authenticator;
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector;
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpProcessor httpProcessor, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        Args.notNull(httpProcessor, "Proxy HTTP processor");
        Args.notNull(authenticationStrategy, "Target authentication strategy");
        Args.notNull(authenticationStrategy2, "Proxy authentication strategy");
        Args.notNull(userTokenHandler, "User token handler");
        this.authenticator = new HttpAuthenticator();
        this.routeDirector = new BasicRouteDirector();
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        this.proxyHttpProcessor = httpProcessor;
        this.targetAuthStrategy = authenticationStrategy;
        this.proxyAuthStrategy = authenticationStrategy2;
        this.userTokenHandler = userTokenHandler;
    }

    private boolean createTunnelToProxy(HttpRoute httpRoute, int i, HttpClientContext httpClientContext) throws HttpException {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean createTunnelToTarget(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        AuthState authState2;
        HttpClientContext httpClientContext2;
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        int connectTimeout = requestConfig.getConnectTimeout();
        HttpHost targetHost = httpRoute.getTargetHost();
        HttpHost proxyHost = httpRoute.getProxyHost();
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest(HttpMethods.CONNECT, targetHost.toHostString(), httpRequest.getProtocolVersion());
        this.requestExecutor.preProcess(basicHttpRequest, this.proxyHttpProcessor, httpClientContext);
        HttpResponse httpResponse = null;
        while (true) {
            if (httpResponse != null) {
                if (httpResponse.getStatusLine().getStatusCode() <= 299) {
                    return false;
                }
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    httpResponse.setEntity(new BufferedHttpEntity(entity));
                }
                httpClientConnection.close();
                throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse.getStatusLine(), httpResponse);
            }
            if (!httpClientConnection.isOpen()) {
                this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
            }
            basicHttpRequest.removeHeaders("Proxy-Authorization");
            this.authenticator.generateAuthResponse(basicHttpRequest, authState, httpClientContext);
            HttpResponse httpResponseExecute = this.requestExecutor.execute(basicHttpRequest, httpClientConnection, httpClientContext);
            this.requestExecutor.postProcess(httpResponseExecute, this.proxyHttpProcessor, httpClientContext);
            if (httpResponseExecute.getStatusLine().getStatusCode() < 200) {
                throw new HttpException("Unexpected response to CONNECT request: " + httpResponseExecute.getStatusLine());
            }
            if (requestConfig.isAuthenticationEnabled()) {
                authState2 = authState;
                httpClientContext2 = httpClientContext;
                if (this.authenticator.isAuthenticationRequested(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authState2, httpClientContext2) && this.authenticator.handleAuthChallenge(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authState2, httpClientContext2)) {
                    if (this.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext2)) {
                        this.log.debug("Connection kept alive");
                        EntityUtils.consume(httpResponseExecute.getEntity());
                    } else {
                        httpClientConnection.close();
                    }
                    httpResponse = null;
                }
                authState = authState2;
                httpClientContext = httpClientContext2;
            } else {
                authState2 = authState;
                httpClientContext2 = httpClientContext;
            }
            httpResponse = httpResponseExecute;
            authState = authState2;
            httpClientContext = httpClientContext2;
        }
    }

    private boolean needAuthentication(AuthState authState, AuthState authState2, HttpRoute httpRoute, HttpResponse httpResponse, HttpClientContext httpClientContext) {
        if (!httpClientContext.getRequestConfig().isAuthenticationEnabled()) {
            return false;
        }
        HttpHost targetHost = httpClientContext.getTargetHost();
        if (targetHost == null) {
            targetHost = httpRoute.getTargetHost();
        }
        HttpHost httpHost = targetHost.getPort() < 0 ? new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName()) : targetHost;
        boolean zIsAuthenticationRequested = this.authenticator.isAuthenticationRequested(httpHost, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        HttpHost httpHost2 = httpHost;
        HttpHost proxyHost = httpRoute.getProxyHost();
        if (proxyHost == null) {
            proxyHost = httpRoute.getTargetHost();
        }
        HttpHost httpHost3 = proxyHost;
        boolean zIsAuthenticationRequested2 = this.authenticator.isAuthenticationRequested(httpHost3, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        if (zIsAuthenticationRequested) {
            return this.authenticator.handleAuthChallenge(httpHost2, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        }
        if (zIsAuthenticationRequested2) {
            return this.authenticator.handleAuthChallenge(httpHost3, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6 A[LOOP:0: B:3:0x000d->B:29:0x00b6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void establishRoute(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        HttpClientContext httpClientContext2;
        HttpRequest httpRequest2;
        HttpRoute httpRoute2;
        HttpClientConnection httpClientConnection2;
        AuthState authState2;
        int connectTimeout = httpClientContext.getRequestConfig().getConnectTimeout();
        RouteTracker routeTracker = new RouteTracker(httpRoute);
        while (true) {
            HttpRoute route = routeTracker.toRoute();
            int iNextStep = this.routeDirector.nextStep(httpRoute, route);
            switch (iNextStep) {
                case -1:
                    throw new HttpException("Unable to establish route: planned = " + httpRoute + "; current = " + route);
                case 0:
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    this.connManager.routeComplete(httpClientConnection2, httpRoute2, httpClientContext2);
                    if (iNextStep > 0) {
                        return;
                    }
                    authState = authState2;
                    httpClientConnection = httpClientConnection2;
                    httpRoute = httpRoute2;
                    httpRequest = httpRequest2;
                    httpClientContext = httpClientContext2;
                    break;
                case 1:
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    this.connManager.connect(httpClientConnection2, httpRoute2, connectTimeout > 0 ? connectTimeout : 0, httpClientContext2);
                    routeTracker.connectTarget(httpRoute2.isSecure());
                    if (iNextStep > 0) {
                    }
                    break;
                case 2:
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    this.connManager.connect(httpClientConnection2, httpRoute2, connectTimeout > 0 ? connectTimeout : 0, httpClientContext2);
                    routeTracker.connectProxy(httpRoute2.getProxyHost(), httpRoute2.isSecure() && !httpRoute2.isTunnelled());
                    if (iNextStep > 0) {
                    }
                    break;
                case 3:
                    boolean zCreateTunnelToTarget = createTunnelToTarget(authState, httpClientConnection, httpRoute, httpRequest, httpClientContext);
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    this.log.debug("Tunnel to target created.");
                    routeTracker.tunnelTarget(zCreateTunnelToTarget);
                    if (iNextStep > 0) {
                    }
                    break;
                case 4:
                    int hopCount = route.getHopCount() - 1;
                    boolean zCreateTunnelToProxy = createTunnelToProxy(httpRoute, hopCount, httpClientContext);
                    this.log.debug("Tunnel to proxy created.");
                    routeTracker.tunnelProxy(httpRoute.getHopTarget(hopCount), zCreateTunnelToProxy);
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    if (iNextStep > 0) {
                    }
                    break;
                case 5:
                    this.connManager.upgrade(httpClientConnection, httpRoute, httpClientContext);
                    routeTracker.layerProtocol(httpRoute.isSecure());
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    if (iNextStep > 0) {
                    }
                    break;
                default:
                    throw new IllegalStateException(AbstractC0541b.m767i(iNextStep, "Unknown step indicator ", " from RouteDirector."));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:188:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x035e  */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [cz.msebera.android.httpclient.HttpRequest, cz.msebera.android.httpclient.client.methods.HttpRequestWrapper, cz.msebera.android.httpclient.message.AbstractHttpMessage, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r1v20, types: [cz.msebera.android.httpclient.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v3, types: [cz.msebera.android.httpclient.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r1v4, types: [cz.msebera.android.httpclient.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r26v0, types: [cz.msebera.android.httpclient.client.methods.HttpExecutionAware] */
    /* JADX WARN: Type inference failed for: r4v16, types: [cz.msebera.android.httpclient.protocol.HttpRequestExecutor] */
    /* JADX WARN: Type inference failed for: r4v17, types: [cz.msebera.android.httpclient.ConnectionReuseStrategy] */
    /* JADX WARN: Type inference failed for: r4v19, types: [cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy] */
    /* JADX WARN: Type inference failed for: r4v41, types: [cz.msebera.android.httpclient.impl.auth.HttpAuthenticator] */
    /* JADX WARN: Type inference failed for: r4v45, types: [cz.msebera.android.httpclient.impl.auth.HttpAuthenticator] */
    /* JADX WARN: Type inference failed for: r4v8, types: [cz.msebera.android.httpclient.client.UserTokenHandler] */
    /* JADX WARN: Type inference failed for: r5v1, types: [cz.msebera.android.httpclient.HttpRequest] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r6v1, types: [cz.msebera.android.httpclient.client.protocol.HttpClientContext, cz.msebera.android.httpclient.protocol.HttpContext, cz.msebera.android.httpclient.protocol.HttpCoreContext] */
    /* JADX WARN: Type inference failed for: r6v2, types: [cz.msebera.android.httpclient.protocol.HttpContext, cz.msebera.android.httpclient.protocol.HttpCoreContext] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        MainClientExec mainClientExec;
        AuthState authState;
        AuthState authState2;
        ?? r14;
        Object obj;
        ?? r6;
        ?? r12;
        HttpResponse response;
        Object userToken;
        ?? r13;
        AuthState authState3;
        HttpClientConnection httpClientConnection;
        HttpResponse httpResponse;
        String string;
        MainClientExec mainClientExec2 = this;
        HttpRoute httpRoute2 = httpRoute;
        Object obj2 = httpRequestWrapper;
        HttpClientContext httpClientContext2 = httpClientContext;
        Args.notNull(httpRoute2, "HTTP route");
        Args.notNull(obj2, "HTTP request");
        Args.notNull(httpClientContext2, "HTTP context");
        AuthState targetAuthState = httpClientContext2.getTargetAuthState();
        if (targetAuthState == null) {
            targetAuthState = new AuthState();
            httpClientContext2.setAttribute("http.auth.target-scope", targetAuthState);
        }
        AuthState authState4 = targetAuthState;
        AuthState proxyAuthState = httpClientContext2.getProxyAuthState();
        if (proxyAuthState == null) {
            proxyAuthState = new AuthState();
            httpClientContext2.setAttribute("http.auth.proxy-scope", proxyAuthState);
        }
        if (obj2 instanceof HttpEntityEnclosingRequest) {
            RequestEntityProxy.enhance((HttpEntityEnclosingRequest) obj2);
        }
        Object userToken2 = httpClientContext2.getUserToken();
        ConnectionRequest connectionRequestRequestConnection = mainClientExec2.connManager.requestConnection(httpRoute2, userToken2);
        if (httpExecutionAware != 0) {
            if (httpExecutionAware.isAborted()) {
                connectionRequestRequestConnection.cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpExecutionAware.setCancellable(connectionRequestRequestConnection);
        }
        RequestConfig requestConfig = httpClientContext2.getRequestConfig();
        try {
            int connectionRequestTimeout = requestConfig.getConnectionRequestTimeout();
            HttpClientConnection httpClientConnection2 = connectionRequestRequestConnection.get(connectionRequestTimeout > 0 ? connectionRequestTimeout : 0L, TimeUnit.MILLISECONDS);
            httpClientContext2.setAttribute("http.connection", httpClientConnection2);
            if (requestConfig.isStaleConnectionCheckEnabled() && httpClientConnection2.isOpen()) {
                mainClientExec2.log.debug("Stale connection check");
                if (httpClientConnection2.isStale()) {
                    mainClientExec2.log.debug("Stale connection detected");
                    httpClientConnection2.close();
                }
            }
            ConnectionHolder connectionHolder = new ConnectionHolder(mainClientExec2.log, mainClientExec2.connManager, httpClientConnection2);
            if (httpExecutionAware != 0) {
                try {
                    try {
                        httpExecutionAware.setCancellable(connectionHolder);
                    } catch (HttpException e) {
                        e = e;
                        connectionHolder.abortConnection();
                        throw e;
                    } catch (ConnectionShutdownException e2) {
                        e = e2;
                        InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                        interruptedIOException.initCause(e);
                        throw interruptedIOException;
                    } catch (Error e3) {
                        e = e3;
                        mainClientExec = mainClientExec2;
                        mainClientExec.connManager.shutdown();
                        throw e;
                    }
                } catch (IOException e5) {
                    e = e5;
                    authState = proxyAuthState;
                    authState2 = authState4;
                    connectionHolder.abortConnection();
                    if (authState.isConnectionBased()) {
                    }
                    if (authState2.isConnectionBased()) {
                    }
                    throw e;
                } catch (RuntimeException e6) {
                    e = e6;
                    authState = proxyAuthState;
                    authState2 = authState4;
                    connectionHolder.abortConnection();
                    if (authState.isConnectionBased()) {
                    }
                    if (authState2.isConnectionBased()) {
                    }
                    throw e;
                }
            }
            int i = 1;
            int i2 = 1;
            MainClientExec mainClientExec3 = mainClientExec2;
            ?? r5 = obj2;
            ?? r62 = httpClientContext2;
            while (true) {
                if (i2 > i && !RequestEntityProxy.isRepeatable(r5)) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
                }
                if (httpExecutionAware != 0 && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (httpClientConnection2.isOpen()) {
                    r14 = r5;
                    r13 = mainClientExec3;
                } else {
                    HttpClientAndroidLog httpClientAndroidLog = mainClientExec3.log;
                    try {
                        try {
                            StringBuilder sb = new StringBuilder();
                            AuthState authState5 = proxyAuthState;
                            try {
                                sb.append("Opening connection ");
                                sb.append(httpRoute2);
                                httpClientAndroidLog.debug(sb.toString());
                                ?? r15 = this;
                                proxyAuthState = authState5;
                                try {
                                    r15.establishRoute(proxyAuthState, httpClientConnection2, httpRoute2, r5, r62);
                                    r14 = r5;
                                    r13 = r15;
                                } catch (TunnelRefusedException e7) {
                                    if (r15.log.isDebugEnabled()) {
                                        r15.log.debug(e7.getMessage());
                                    }
                                    response = e7.getResponse();
                                    obj = userToken2;
                                    r12 = r15;
                                    r6 = r62;
                                    if (obj == null) {
                                        userToken = r12.userTokenHandler.getUserToken(r6);
                                        r6.setAttribute("http.user-token", userToken);
                                    } else {
                                        userToken = obj;
                                    }
                                    if (userToken != null) {
                                        connectionHolder.setState(userToken);
                                    }
                                    HttpEntity entity = response.getEntity();
                                    if (entity != null && entity.isStreaming()) {
                                        return new HttpResponseProxy(response, connectionHolder);
                                    }
                                    connectionHolder.releaseConnection();
                                    return new HttpResponseProxy(response, null);
                                }
                            } catch (IOException e8) {
                                e = e8;
                                proxyAuthState = authState5;
                                authState = proxyAuthState;
                                authState2 = authState4;
                                connectionHolder.abortConnection();
                                if (authState.isConnectionBased()) {
                                    authState.reset();
                                }
                                if (authState2.isConnectionBased()) {
                                    authState2.reset();
                                }
                                throw e;
                            } catch (RuntimeException e9) {
                                e = e9;
                                proxyAuthState = authState5;
                                authState = proxyAuthState;
                                authState2 = authState4;
                                connectionHolder.abortConnection();
                                if (authState.isConnectionBased()) {
                                    authState.reset();
                                }
                                if (authState2.isConnectionBased()) {
                                    authState2.reset();
                                }
                                throw e;
                            }
                        } catch (IOException e10) {
                            e = e10;
                        } catch (RuntimeException e11) {
                            e = e11;
                        }
                    } catch (HttpException e12) {
                        e = e12;
                        connectionHolder.abortConnection();
                        throw e;
                    } catch (ConnectionShutdownException e13) {
                        e = e13;
                        InterruptedIOException interruptedIOException2 = new InterruptedIOException("Connection has been shut down");
                        interruptedIOException2.initCause(e);
                        throw interruptedIOException2;
                    } catch (Error e14) {
                        e = e14;
                        mainClientExec = this;
                        mainClientExec.connManager.shutdown();
                        throw e;
                    }
                }
                int socketTimeout = requestConfig.getSocketTimeout();
                if (socketTimeout >= 0) {
                    httpClientConnection2.setSocketTimeout(socketTimeout);
                }
                if (httpExecutionAware != 0 && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (r13.log.isDebugEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog2 = r13.log;
                    StringBuilder sb2 = new StringBuilder();
                    obj = userToken2;
                    sb2.append("Executing request ");
                    sb2.append(r14.getRequestLine());
                    httpClientAndroidLog2.debug(sb2.toString());
                } else {
                    obj = userToken2;
                }
                if (!r14.containsHeader("Authorization")) {
                    if (r13.log.isDebugEnabled()) {
                        r13.log.debug("Target auth state: " + authState4.getState());
                    }
                    r13.authenticator.generateAuthResponse(r14, authState4, r62);
                }
                if (!r14.containsHeader("Proxy-Authorization") && !httpRoute.isTunnelled()) {
                    if (r13.log.isDebugEnabled()) {
                        r13.log.debug("Proxy auth state: " + proxyAuthState.getState());
                    }
                    r13.authenticator.generateAuthResponse(r14, proxyAuthState, r62);
                }
                r62.setAttribute("http.request", r14);
                HttpResponse httpResponseExecute = r13.requestExecutor.execute(r14, httpClientConnection2, r62);
                if (r13.reuseStrategy.keepAlive(httpResponseExecute, r62)) {
                    try {
                        authState3 = proxyAuthState;
                        httpClientConnection = httpClientConnection2;
                        try {
                            long keepAliveDuration = r13.keepAliveStrategy.getKeepAliveDuration(httpResponseExecute, r62);
                            if (r13.log.isDebugEnabled()) {
                                if (keepAliveDuration > 0) {
                                    try {
                                        StringBuilder sb3 = new StringBuilder();
                                        httpResponse = httpResponseExecute;
                                        sb3.append("for ");
                                        sb3.append(keepAliveDuration);
                                        sb3.append(" ");
                                        sb3.append(TimeUnit.MILLISECONDS);
                                        string = sb3.toString();
                                    } catch (IOException e15) {
                                        e = e15;
                                        authState2 = authState4;
                                        authState = authState3;
                                        connectionHolder.abortConnection();
                                        if (authState.isConnectionBased()) {
                                        }
                                        if (authState2.isConnectionBased()) {
                                        }
                                        throw e;
                                    } catch (RuntimeException e16) {
                                        e = e16;
                                        authState2 = authState4;
                                        authState = authState3;
                                        connectionHolder.abortConnection();
                                        if (authState.isConnectionBased()) {
                                        }
                                        if (authState2.isConnectionBased()) {
                                        }
                                        throw e;
                                    }
                                } else {
                                    httpResponse = httpResponseExecute;
                                    string = "indefinitely";
                                }
                                r13.log.debug("Connection can be kept alive " + string);
                            } else {
                                httpResponse = httpResponseExecute;
                            }
                            connectionHolder.setValidFor(keepAliveDuration, TimeUnit.MILLISECONDS);
                            connectionHolder.markReusable();
                        } catch (IOException e17) {
                            e = e17;
                            authState2 = authState4;
                            authState = authState3;
                            connectionHolder.abortConnection();
                            if (authState.isConnectionBased()) {
                            }
                            if (authState2.isConnectionBased()) {
                            }
                            throw e;
                        } catch (RuntimeException e18) {
                            e = e18;
                            authState2 = authState4;
                            authState = authState3;
                            connectionHolder.abortConnection();
                            if (authState.isConnectionBased()) {
                            }
                            if (authState2.isConnectionBased()) {
                            }
                            throw e;
                        }
                    } catch (IOException e19) {
                        e = e19;
                        authState3 = proxyAuthState;
                    } catch (RuntimeException e20) {
                        e = e20;
                        authState3 = proxyAuthState;
                    }
                } else {
                    authState3 = proxyAuthState;
                    httpClientConnection = httpClientConnection2;
                    httpResponse = httpResponseExecute;
                    connectionHolder.markNonReusable();
                }
                MainClientExec mainClientExec4 = this;
                HttpClientContext httpClientContext3 = httpClientContext;
                authState2 = authState4;
                authState = authState3;
                HttpResponse httpResponse2 = httpResponse;
                try {
                    if (!mainClientExec4.needAuthentication(authState2, authState, httpRoute, httpResponse2, httpClientContext3)) {
                        response = httpResponse2;
                        r12 = mainClientExec4;
                        r6 = httpClientContext3;
                        break;
                    }
                    HttpEntity entity2 = httpResponse2.getEntity();
                    if (connectionHolder.isReusable()) {
                        EntityUtils.consume(entity2);
                    } else {
                        httpClientConnection.close();
                        AuthProtocolState state = authState.getState();
                        AuthProtocolState authProtocolState = AuthProtocolState.SUCCESS;
                        if (state == authProtocolState && authState.isConnectionBased()) {
                            mainClientExec4.log.debug("Resetting proxy auth state");
                            authState.reset();
                        }
                        if (authState2.getState() == authProtocolState && authState2.isConnectionBased()) {
                            mainClientExec4.log.debug("Resetting target auth state");
                            authState2.reset();
                        }
                    }
                    HttpRequest original = r14.getOriginal();
                    if (!original.containsHeader("Authorization")) {
                        r14.removeHeaders("Authorization");
                    }
                    if (!original.containsHeader("Proxy-Authorization")) {
                        r14.removeHeaders("Proxy-Authorization");
                    }
                    i2++;
                    httpRoute2 = httpRoute;
                    authState4 = authState2;
                    proxyAuthState = authState;
                    httpClientConnection2 = httpClientConnection;
                    r5 = r14;
                    userToken2 = obj;
                    i = 1;
                    mainClientExec3 = mainClientExec4;
                    r62 = httpClientContext3;
                } catch (IOException e21) {
                    e = e21;
                    connectionHolder.abortConnection();
                    if (authState.isConnectionBased()) {
                    }
                    if (authState2.isConnectionBased()) {
                    }
                    throw e;
                } catch (RuntimeException e22) {
                    e = e22;
                    connectionHolder.abortConnection();
                    if (authState.isConnectionBased()) {
                    }
                    if (authState2.isConnectionBased()) {
                    }
                    throw e;
                }
            }
        } catch (InterruptedException e23) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", e23);
        } catch (ExecutionException e24) {
            e = e24;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            throw new RequestAbortedException("Request execution failed", e);
        }
    }

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this(httpRequestExecutor, httpClientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, new ImmutableHttpProcessor(new RequestTargetHost()), authenticationStrategy, authenticationStrategy2, userTokenHandler);
    }
}
