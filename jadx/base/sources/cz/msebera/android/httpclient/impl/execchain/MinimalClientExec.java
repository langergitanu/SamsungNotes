package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestContent;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.VersionInfo;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class MinimalClientExec implements ClientExecChain {
    private final HttpClientConnectionManager connManager;
    private final HttpProcessor httpProcessor;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;

    public MinimalClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        this.httpProcessor = new ImmutableHttpProcessor(new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(VersionInfo.getUserAgent("Apache-HttpClient", "cz.msebera.android.httpclient.client", getClass())));
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
    }

    public static void rewriteRequestURI(HttpRequestWrapper httpRequestWrapper, HttpRoute httpRoute, boolean z) throws ProtocolException {
        URI uriRewriteURI;
        try {
            URI uri = httpRequestWrapper.getURI();
            if (uri != null) {
                if (uri.isAbsolute()) {
                    uriRewriteURI = URIUtils.rewriteURI(uri, (HttpHost) null, z ? URIUtils.DROP_FRAGMENT_AND_NORMALIZE : URIUtils.DROP_FRAGMENT);
                } else {
                    uriRewriteURI = URIUtils.rewriteURI(uri);
                }
                httpRequestWrapper.setURI(uriRewriteURI);
            }
        } catch (URISyntaxException e) {
            throw new ProtocolException("Invalid URI: " + httpRequestWrapper.getRequestLine().getUri(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0  */
    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws HttpException, IOException {
        Object httpHost;
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        rewriteRequestURI(httpRequestWrapper, httpRoute, httpClientContext.getRequestConfig().isNormalizeUri());
        ConnectionRequest connectionRequestRequestConnection = this.connManager.requestConnection(httpRoute, null);
        if (httpExecutionAware != null) {
            if (httpExecutionAware.isAborted()) {
                connectionRequestRequestConnection.cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpExecutionAware.setCancellable(connectionRequestRequestConnection);
        }
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        try {
            int connectionRequestTimeout = requestConfig.getConnectionRequestTimeout();
            long j = connectionRequestTimeout > 0 ? connectionRequestTimeout : 0L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            HttpClientConnection httpClientConnection = connectionRequestRequestConnection.get(j, timeUnit);
            ConnectionHolder connectionHolder = new ConnectionHolder(this.log, this.connManager, httpClientConnection);
            if (httpExecutionAware != null) {
                try {
                    if (httpExecutionAware.isAborted()) {
                        connectionHolder.close();
                        throw new RequestAbortedException("Request aborted");
                    }
                    httpExecutionAware.setCancellable(connectionHolder);
                } catch (HttpException e) {
                    connectionHolder.abortConnection();
                    throw e;
                } catch (ConnectionShutdownException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                    interruptedIOException.initCause(e2);
                    throw interruptedIOException;
                } catch (IOException e3) {
                    connectionHolder.abortConnection();
                    throw e3;
                } catch (Error e5) {
                    this.connManager.shutdown();
                    throw e5;
                } catch (RuntimeException e6) {
                    connectionHolder.abortConnection();
                    throw e6;
                }
            }
            if (!httpClientConnection.isOpen()) {
                int connectTimeout = requestConfig.getConnectTimeout();
                HttpClientConnectionManager httpClientConnectionManager = this.connManager;
                if (connectTimeout <= 0) {
                    connectTimeout = 0;
                }
                httpClientConnectionManager.connect(httpClientConnection, httpRoute, connectTimeout, httpClientContext);
                this.connManager.routeComplete(httpClientConnection, httpRoute, httpClientContext);
            }
            int socketTimeout = requestConfig.getSocketTimeout();
            if (socketTimeout >= 0) {
                httpClientConnection.setSocketTimeout(socketTimeout);
            }
            HttpRequest original = httpRequestWrapper.getOriginal();
            if (original instanceof HttpUriRequest) {
                URI uri = ((HttpUriRequest) original).getURI();
                httpHost = uri.isAbsolute() ? new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()) : null;
            }
            if (httpHost == null) {
                httpHost = httpRoute.getTargetHost();
            }
            httpClientContext.setAttribute("http.target_host", httpHost);
            httpClientContext.setAttribute("http.request", httpRequestWrapper);
            httpClientContext.setAttribute("http.connection", httpClientConnection);
            httpClientContext.setAttribute("http.route", httpRoute);
            this.httpProcessor.process(httpRequestWrapper, httpClientContext);
            HttpResponse httpResponseExecute = this.requestExecutor.execute(httpRequestWrapper, httpClientConnection, httpClientContext);
            this.httpProcessor.process(httpResponseExecute, httpClientContext);
            if (this.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext)) {
                connectionHolder.setValidFor(this.keepAliveStrategy.getKeepAliveDuration(httpResponseExecute, httpClientContext), timeUnit);
                connectionHolder.markReusable();
            } else {
                connectionHolder.markNonReusable();
            }
            HttpEntity entity = httpResponseExecute.getEntity();
            if (entity != null && entity.isStreaming()) {
                return new HttpResponseProxy(httpResponseExecute, connectionHolder);
            }
            connectionHolder.releaseConnection();
            return new HttpResponseProxy(httpResponseExecute, null);
        } catch (InterruptedException e7) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", e7);
        } catch (ExecutionException e8) {
            e = e8;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            throw new RequestAbortedException("Request execution failed", e);
        }
    }
}
