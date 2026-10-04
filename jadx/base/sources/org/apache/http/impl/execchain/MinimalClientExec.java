package org.apache.http.impl.execchain;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.client.utils.URIUtilsHC4;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestContentHC4;
import org.apache.http.protocol.RequestTargetHostHC4;
import org.apache.http.protocol.RequestUserAgentHC4;
import org.apache.http.util.Args;
import org.apache.http.util.VersionInfoHC4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class MinimalClientExec implements ClientExecChain {
    private final HttpClientConnectionManager connManager;
    private final HttpProcessor httpProcessor;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;

    public MinimalClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        this.httpProcessor = new ImmutableHttpProcessor(new RequestContentHC4(), new RequestTargetHostHC4(), new RequestClientConnControl(), new RequestUserAgentHC4(VersionInfoHC4.getUserAgent("Apache-HttpClient", "org.apache.http.client", getClass())));
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
    }

    public static void rewriteRequestURI(HttpRequestWrapper httpRequestWrapper, HttpRoute httpRoute) throws ProtocolException {
        try {
            URI uri = httpRequestWrapper.getURI();
            if (uri != null) {
                httpRequestWrapper.setURI(uri.isAbsolute() ? URIUtilsHC4.rewriteURI(uri, null, true) : URIUtilsHC4.rewriteURI(uri));
            }
        } catch (URISyntaxException e) {
            throw new ProtocolException("Invalid URI: " + httpRequestWrapper.getRequestLine().getUri(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    @Override // org.apache.http.impl.execchain.ClientExecChain
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws HttpException, IOException {
        Object httpHost;
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        rewriteRequestURI(httpRequestWrapper, httpRoute);
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
            if (connectionRequestTimeout <= 0) {
                connectionRequestTimeout = 0;
            }
            long j = connectionRequestTimeout;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            HttpClientConnection httpClientConnection = connectionRequestRequestConnection.get(j, timeUnit);
            ConnectionHolder connectionHolder = new ConnectionHolder(this.connManager, httpClientConnection);
            if (httpExecutionAware != null) {
                try {
                    if (httpExecutionAware.isAborted()) {
                        connectionHolder.close();
                        throw new RequestAbortedException("Request aborted");
                    }
                    httpExecutionAware.setCancellable(connectionHolder);
                } catch (IOException e) {
                    connectionHolder.abortConnection();
                    throw e;
                } catch (RuntimeException e2) {
                    connectionHolder.abortConnection();
                    throw e2;
                } catch (HttpException e3) {
                    connectionHolder.abortConnection();
                    throw e3;
                } catch (ConnectionShutdownException e5) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                    interruptedIOException.initCause(e5);
                    throw interruptedIOException;
                }
            }
            if (!httpClientConnection.isOpen()) {
                int connectTimeout = requestConfig.getConnectTimeout();
                this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
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
        } catch (InterruptedException e6) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", e6);
        } catch (ExecutionException e7) {
            e = e7;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            throw new RequestAbortedException("Request execution failed", e);
        }
    }
}
