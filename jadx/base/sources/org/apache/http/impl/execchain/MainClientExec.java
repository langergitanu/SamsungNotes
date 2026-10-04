package org.apache.http.impl.execchain;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.api.client.http.HttpMethods;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.entity.BufferedHttpEntityHC4;
import org.apache.http.impl.auth.HttpAuthenticator;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestTargetHostHC4;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtilsHC4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class MainClientExec implements ClientExecChain {
    private static final String TAG = "HttpClient";
    private final HttpAuthenticator authenticator;
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector;
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        Args.notNull(authenticationStrategy, "Target authentication strategy");
        Args.notNull(authenticationStrategy2, "Proxy authentication strategy");
        Args.notNull(userTokenHandler, "User token handler");
        this.authenticator = new HttpAuthenticator();
        this.proxyHttpProcessor = new ImmutableHttpProcessor(new RequestTargetHostHC4(), new RequestClientConnControl());
        this.routeDirector = new BasicRouteDirector();
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        this.targetAuthStrategy = authenticationStrategy;
        this.proxyAuthStrategy = authenticationStrategy2;
        this.userTokenHandler = userTokenHandler;
    }

    private boolean createTunnelToProxy(HttpRoute httpRoute, int i, HttpClientContext httpClientContext) throws HttpException {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean createTunnelToTarget(AuthStateHC4 authStateHC4, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        AuthStateHC4 authStateHC42;
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
                    httpResponse.setEntity(new BufferedHttpEntityHC4(entity));
                }
                httpClientConnection.close();
                throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse.getStatusLine(), httpResponse);
            }
            if (!httpClientConnection.isOpen()) {
                this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
            }
            basicHttpRequest.removeHeaders("Proxy-Authorization");
            this.authenticator.generateAuthResponse(basicHttpRequest, authStateHC4, httpClientContext);
            HttpResponse httpResponseExecute = this.requestExecutor.execute(basicHttpRequest, httpClientConnection, httpClientContext);
            if (httpResponseExecute.getStatusLine().getStatusCode() < 200) {
                throw new HttpException("Unexpected response to CONNECT request: " + httpResponseExecute.getStatusLine());
            }
            if (requestConfig.isAuthenticationEnabled()) {
                authStateHC42 = authStateHC4;
                httpClientContext2 = httpClientContext;
                if (this.authenticator.isAuthenticationRequested(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authStateHC42, httpClientContext2) && this.authenticator.handleAuthChallenge(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authStateHC42, httpClientContext2)) {
                    if (this.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext2)) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Connection kept alive");
                        }
                        EntityUtilsHC4.consume(httpResponseExecute.getEntity());
                    } else {
                        httpClientConnection.close();
                    }
                    httpResponse = null;
                }
                authStateHC4 = authStateHC42;
                httpClientContext = httpClientContext2;
            } else {
                authStateHC42 = authStateHC4;
                httpClientContext2 = httpClientContext;
            }
            httpResponse = httpResponseExecute;
            authStateHC4 = authStateHC42;
            httpClientContext = httpClientContext2;
        }
    }

    private boolean needAuthentication(AuthStateHC4 authStateHC4, AuthStateHC4 authStateHC42, HttpRoute httpRoute, HttpResponse httpResponse, HttpClientContext httpClientContext) {
        if (!httpClientContext.getRequestConfig().isAuthenticationEnabled()) {
            return false;
        }
        HttpHost targetHost = httpClientContext.getTargetHost();
        if (targetHost == null) {
            targetHost = httpRoute.getTargetHost();
        }
        HttpHost httpHost = targetHost.getPort() < 0 ? new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName()) : targetHost;
        boolean zIsAuthenticationRequested = this.authenticator.isAuthenticationRequested(httpHost, httpResponse, this.targetAuthStrategy, authStateHC4, httpClientContext);
        HttpHost httpHost2 = httpHost;
        HttpHost proxyHost = httpRoute.getProxyHost();
        if (proxyHost == null) {
            proxyHost = httpRoute.getTargetHost();
        }
        HttpHost httpHost3 = proxyHost;
        boolean zIsAuthenticationRequested2 = this.authenticator.isAuthenticationRequested(httpHost3, httpResponse, this.proxyAuthStrategy, authStateHC42, httpClientContext);
        if (zIsAuthenticationRequested) {
            return this.authenticator.handleAuthChallenge(httpHost2, httpResponse, this.targetAuthStrategy, authStateHC4, httpClientContext);
        }
        if (zIsAuthenticationRequested2) {
            return this.authenticator.handleAuthChallenge(httpHost3, httpResponse, this.proxyAuthStrategy, authStateHC42, httpClientContext);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2 A[LOOP:0: B:3:0x000d->B:29:0x00b2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void establishRoute(AuthStateHC4 authStateHC4, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        HttpClientContext httpClientContext2;
        HttpRequest httpRequest2;
        HttpRoute httpRoute2;
        HttpClientConnection httpClientConnection2;
        AuthStateHC4 authStateHC42;
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
                    authStateHC42 = authStateHC4;
                    this.connManager.routeComplete(httpClientConnection2, httpRoute2, httpClientContext2);
                    if (iNextStep > 0) {
                        return;
                    }
                    authStateHC4 = authStateHC42;
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
                    authStateHC42 = authStateHC4;
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
                    authStateHC42 = authStateHC4;
                    this.connManager.connect(httpClientConnection2, httpRoute2, connectTimeout > 0 ? connectTimeout : 0, httpClientContext2);
                    routeTracker.connectProxy(httpRoute2.getProxyHost(), false);
                    if (iNextStep > 0) {
                    }
                    break;
                case 3:
                    boolean zCreateTunnelToTarget = createTunnelToTarget(authStateHC4, httpClientConnection, httpRoute, httpRequest, httpClientContext);
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authStateHC42 = authStateHC4;
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Tunnel to target created.");
                    }
                    routeTracker.tunnelTarget(zCreateTunnelToTarget);
                    if (iNextStep > 0) {
                    }
                    break;
                case 4:
                    int hopCount = route.getHopCount() - 1;
                    boolean zCreateTunnelToProxy = createTunnelToProxy(httpRoute, hopCount, httpClientContext);
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Tunnel to proxy created.");
                    }
                    routeTracker.tunnelProxy(httpRoute.getHopTarget(hopCount), zCreateTunnelToProxy);
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authStateHC42 = authStateHC4;
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
                    authStateHC42 = authStateHC4;
                    if (iNextStep > 0) {
                    }
                    break;
                default:
                    throw new IllegalStateException(AbstractC0541b.m767i(iNextStep, "Unknown step indicator ", " from RouteDirector."));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02a8 A[Catch: RuntimeException -> 0x00bc, IOException -> 0x00bf, HttpException -> 0x00c2, ConnectionShutdownException -> 0x00c5, TryCatch #5 {IOException -> 0x00bf, RuntimeException -> 0x00bc, HttpException -> 0x00c2, ConnectionShutdownException -> 0x00c5, blocks: (B:39:0x00b8, B:50:0x00ce, B:53:0x00d5, B:54:0x00dc, B:56:0x00df, B:59:0x00e6, B:60:0x00eb, B:61:0x00ec, B:63:0x00f2, B:75:0x0121, B:84:0x013c, B:86:0x0142, B:88:0x0147, B:91:0x014f, B:92:0x0154, B:93:0x0155, B:95:0x015b, B:96:0x0170, B:98:0x0176, B:100:0x017d, B:101:0x0192, B:102:0x0197, B:104:0x019d, B:106:0x01a3, B:108:0x01aa, B:109:0x01bf, B:110:0x01c4, B:124:0x023a, B:126:0x0240, B:128:0x024a, B:150:0x029e, B:152:0x02a8, B:153:0x02ab, B:155:0x02b1, B:156:0x02b4, B:130:0x024f, B:132:0x025a, B:134:0x0260, B:136:0x026a, B:138:0x0271, B:139:0x0276, B:140:0x0279, B:142:0x027f, B:144:0x0285, B:146:0x028f, B:148:0x0296, B:149:0x029b, B:159:0x02c3, B:162:0x02d3, B:163:0x02d6, B:165:0x02dc, B:168:0x02e3, B:170:0x02e9, B:79:0x0128, B:81:0x012e, B:82:0x0135), top: B:198:0x00b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02b1 A[Catch: RuntimeException -> 0x00bc, IOException -> 0x00bf, HttpException -> 0x00c2, ConnectionShutdownException -> 0x00c5, TryCatch #5 {IOException -> 0x00bf, RuntimeException -> 0x00bc, HttpException -> 0x00c2, ConnectionShutdownException -> 0x00c5, blocks: (B:39:0x00b8, B:50:0x00ce, B:53:0x00d5, B:54:0x00dc, B:56:0x00df, B:59:0x00e6, B:60:0x00eb, B:61:0x00ec, B:63:0x00f2, B:75:0x0121, B:84:0x013c, B:86:0x0142, B:88:0x0147, B:91:0x014f, B:92:0x0154, B:93:0x0155, B:95:0x015b, B:96:0x0170, B:98:0x0176, B:100:0x017d, B:101:0x0192, B:102:0x0197, B:104:0x019d, B:106:0x01a3, B:108:0x01aa, B:109:0x01bf, B:110:0x01c4, B:124:0x023a, B:126:0x0240, B:128:0x024a, B:150:0x029e, B:152:0x02a8, B:153:0x02ab, B:155:0x02b1, B:156:0x02b4, B:130:0x024f, B:132:0x025a, B:134:0x0260, B:136:0x026a, B:138:0x0271, B:139:0x0276, B:140:0x0279, B:142:0x027f, B:144:0x0285, B:146:0x028f, B:148:0x0296, B:149:0x029b, B:159:0x02c3, B:162:0x02d3, B:163:0x02d6, B:165:0x02dc, B:168:0x02e3, B:170:0x02e9, B:79:0x0128, B:81:0x012e, B:82:0x0135), top: B:198:0x00b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02b4 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [org.apache.http.HttpRequest, org.apache.http.client.methods.HttpRequestWrapper, org.apache.http.message.AbstractHttpMessage] */
    /* JADX WARN: Type inference failed for: r1v12, types: [org.apache.http.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [org.apache.http.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r1v3, types: [org.apache.http.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r24v0, types: [java.lang.Object, org.apache.http.client.protocol.HttpClientContext, org.apache.http.protocol.HttpContext, org.apache.http.protocol.HttpCoreContext] */
    /* JADX WARN: Type inference failed for: r25v0, types: [org.apache.http.client.methods.HttpExecutionAware] */
    /* JADX WARN: Type inference failed for: r4v31, types: [org.apache.http.impl.auth.HttpAuthenticator] */
    /* JADX WARN: Type inference failed for: r4v35, types: [org.apache.http.impl.auth.HttpAuthenticator] */
    /* JADX WARN: Type inference failed for: r4v6, types: [org.apache.http.protocol.HttpRequestExecutor] */
    /* JADX WARN: Type inference failed for: r5v1, types: [org.apache.http.HttpRequest] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v21 */
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
    @Override // org.apache.http.impl.execchain.ClientExecChain
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws HttpException, IOException {
        ?? r14;
        ?? r12;
        HttpResponse response;
        Object userToken;
        ?? r13;
        AuthStateHC4 authStateHC4;
        HttpClientConnection httpClientConnection;
        HttpResponse httpResponse;
        HttpRequest original;
        String str;
        MainClientExec mainClientExec = this;
        HttpRoute httpRoute2 = httpRoute;
        Object obj = httpRequestWrapper;
        Args.notNull(httpRoute2, "HTTP route");
        Args.notNull(obj, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        AuthStateHC4 targetAuthState = httpClientContext.getTargetAuthState();
        if (targetAuthState == null) {
            targetAuthState = new AuthStateHC4();
            httpClientContext.setAttribute("http.auth.target-scope", targetAuthState);
        }
        AuthStateHC4 authStateHC42 = targetAuthState;
        AuthStateHC4 proxyAuthState = httpClientContext.getProxyAuthState();
        if (proxyAuthState == null) {
            proxyAuthState = new AuthStateHC4();
            httpClientContext.setAttribute("http.auth.proxy-scope", proxyAuthState);
        }
        if (obj instanceof HttpEntityEnclosingRequest) {
            RequestEntityProxy.enhance((HttpEntityEnclosingRequest) obj);
        }
        Object userToken2 = httpClientContext.getUserToken();
        ConnectionRequest connectionRequestRequestConnection = mainClientExec.connManager.requestConnection(httpRoute2, userToken2);
        if (httpExecutionAware != 0) {
            if (httpExecutionAware.isAborted()) {
                connectionRequestRequestConnection.cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpExecutionAware.setCancellable(connectionRequestRequestConnection);
        }
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        try {
            int connectionRequestTimeout = requestConfig.getConnectionRequestTimeout();
            if (connectionRequestTimeout <= 0) {
                connectionRequestTimeout = 0;
            }
            HttpClientConnection httpClientConnection2 = connectionRequestRequestConnection.get(connectionRequestTimeout, TimeUnit.MILLISECONDS);
            httpClientContext.setAttribute("http.connection", httpClientConnection2);
            if (requestConfig.isStaleConnectionCheckEnabled() && httpClientConnection2.isOpen()) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Stale connection check");
                }
                if (httpClientConnection2.isStale()) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Stale connection detected");
                    }
                    httpClientConnection2.close();
                }
            }
            ConnectionHolder connectionHolder = new ConnectionHolder(mainClientExec.connManager, httpClientConnection2);
            if (httpExecutionAware != 0) {
                try {
                    httpExecutionAware.setCancellable(connectionHolder);
                } catch (IOException e) {
                    e = e;
                    connectionHolder.abortConnection();
                    throw e;
                } catch (RuntimeException e2) {
                    e = e2;
                    connectionHolder.abortConnection();
                    throw e;
                } catch (HttpException e3) {
                    e = e3;
                    connectionHolder.abortConnection();
                    throw e;
                } catch (ConnectionShutdownException e5) {
                    e = e5;
                    InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                    interruptedIOException.initCause(e);
                    throw interruptedIOException;
                }
            }
            int i = 1;
            int i2 = 1;
            MainClientExec mainClientExec2 = mainClientExec;
            ?? r5 = obj;
            while (true) {
                if (i2 > i && !RequestEntityProxy.isRepeatable(r5)) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
                }
                if (httpExecutionAware != 0 && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (httpClientConnection2.isOpen()) {
                    r14 = r5;
                    r13 = mainClientExec2;
                } else {
                    if (Log.isLoggable(TAG, 3)) {
                        try {
                            Log.d(TAG, "Opening connection " + httpRoute2);
                        } catch (IOException e6) {
                            e = e6;
                            connectionHolder.abortConnection();
                            throw e;
                        } catch (HttpException e7) {
                            e = e7;
                            connectionHolder.abortConnection();
                            throw e;
                        } catch (ConnectionShutdownException e8) {
                            e = e8;
                            InterruptedIOException interruptedIOException2 = new InterruptedIOException("Connection has been shut down");
                            interruptedIOException2.initCause(e);
                            throw interruptedIOException2;
                        } catch (RuntimeException e9) {
                            e = e9;
                            connectionHolder.abortConnection();
                            throw e;
                        }
                    }
                    ?? r15 = this;
                    try {
                        r15.establishRoute(proxyAuthState, httpClientConnection2, httpRoute2, r5, httpClientContext);
                        r14 = r5;
                        r13 = r15;
                    } catch (TunnelRefusedException e10) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, e10.getMessage());
                        }
                        response = e10.getResponse();
                        r12 = r15;
                    }
                }
                int socketTimeout = requestConfig.getSocketTimeout();
                if (socketTimeout >= 0) {
                    httpClientConnection2.setSocketTimeout(socketTimeout);
                }
                if (httpExecutionAware != 0 && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Executing request " + r14.getRequestLine());
                }
                if (!r14.containsHeader("Authorization")) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Target auth state: " + authStateHC42.getState());
                    }
                    r13.authenticator.generateAuthResponse(r14, authStateHC42, httpClientContext);
                }
                if (!r14.containsHeader("Proxy-Authorization") && !httpRoute.isTunnelled()) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Proxy auth state: " + proxyAuthState.getState());
                    }
                    r13.authenticator.generateAuthResponse(r14, proxyAuthState, httpClientContext);
                }
                HttpResponse httpResponseExecute = r13.requestExecutor.execute(r14, httpClientConnection2, httpClientContext);
                if (r13.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext)) {
                    authStateHC4 = proxyAuthState;
                    long keepAliveDuration = r13.keepAliveStrategy.getKeepAliveDuration(httpResponseExecute, httpClientContext);
                    if (Log.isLoggable(TAG, 3)) {
                        if (keepAliveDuration > 0) {
                            httpClientConnection = httpClientConnection2;
                            str = "for " + keepAliveDuration + " " + TimeUnit.MILLISECONDS;
                        } else {
                            httpClientConnection = httpClientConnection2;
                            str = "indefinitely";
                        }
                        httpResponse = httpResponseExecute;
                        Log.d(TAG, "Connection can be kept alive " + str);
                    } else {
                        httpClientConnection = httpClientConnection2;
                        httpResponse = httpResponseExecute;
                    }
                    connectionHolder.setValidFor(keepAliveDuration, TimeUnit.MILLISECONDS);
                    connectionHolder.markReusable();
                } else {
                    authStateHC4 = proxyAuthState;
                    httpClientConnection = httpClientConnection2;
                    httpResponse = httpResponseExecute;
                    connectionHolder.markNonReusable();
                }
                MainClientExec mainClientExec3 = this;
                AuthStateHC4 authStateHC43 = authStateHC42;
                AuthStateHC4 authStateHC44 = authStateHC4;
                HttpResponse httpResponse2 = httpResponse;
                if (!mainClientExec3.needAuthentication(authStateHC43, authStateHC44, httpRoute, httpResponse2, httpClientContext)) {
                    response = httpResponse2;
                    r12 = mainClientExec3;
                    break;
                }
                HttpEntity entity = httpResponse2.getEntity();
                if (connectionHolder.isReusable()) {
                    EntityUtilsHC4.consume(entity);
                } else {
                    httpClientConnection.close();
                    AuthProtocolState state = authStateHC44.getState();
                    AuthProtocolState authProtocolState = AuthProtocolState.SUCCESS;
                    if (state == authProtocolState && authStateHC44.getAuthScheme() != null && authStateHC44.getAuthScheme().isConnectionBased()) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Resetting proxy auth state");
                        }
                        authStateHC44.reset();
                    }
                    if (authStateHC43.getState() == authProtocolState && authStateHC43.getAuthScheme() != null && authStateHC43.getAuthScheme().isConnectionBased()) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Resetting target auth state");
                        }
                        authStateHC43.reset();
                    }
                    original = r14.getOriginal();
                    if (!original.containsHeader("Authorization")) {
                        r14.removeHeaders("Authorization");
                    }
                    if (original.containsHeader("Proxy-Authorization")) {
                        r14.removeHeaders("Proxy-Authorization");
                    }
                    i2++;
                    httpRoute2 = httpRoute;
                    authStateHC42 = authStateHC43;
                    proxyAuthState = authStateHC44;
                    r5 = r14;
                    httpClientConnection2 = httpClientConnection;
                    i = 1;
                    mainClientExec2 = mainClientExec3;
                }
                original = r14.getOriginal();
                if (!original.containsHeader("Authorization")) {
                }
                if (original.containsHeader("Proxy-Authorization")) {
                }
                i2++;
                httpRoute2 = httpRoute;
                authStateHC42 = authStateHC43;
                proxyAuthState = authStateHC44;
                r5 = r14;
                httpClientConnection2 = httpClientConnection;
                i = 1;
                mainClientExec2 = mainClientExec3;
            }
            if (userToken2 == null) {
                userToken = r12.userTokenHandler.getUserToken(httpClientContext);
                httpClientContext.setAttribute("http.user-token", userToken);
            } else {
                userToken = userToken2;
            }
            if (userToken != null) {
                connectionHolder.setState(userToken);
            }
            HttpEntity entity2 = response.getEntity();
            if (entity2 != null && entity2.isStreaming()) {
                return new HttpResponseProxy(response, connectionHolder);
            }
            connectionHolder.releaseConnection();
            return new HttpResponseProxy(response, null);
        } catch (InterruptedException e11) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", e11);
        } catch (ExecutionException e12) {
            e = e12;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            throw new RequestAbortedException("Request execution failed", e);
        }
    }
}
