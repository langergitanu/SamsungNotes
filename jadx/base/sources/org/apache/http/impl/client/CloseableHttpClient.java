package org.apache.http.impl.client;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtilsHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtilsHC4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@ThreadSafe
public abstract class CloseableHttpClient implements HttpClient, Closeable {
    private static final String TAG = "HttpClient";

    private static HttpHost determineTarget(HttpUriRequest httpUriRequest) throws ClientProtocolException {
        URI uri = httpUriRequest.getURI();
        if (!uri.isAbsolute()) {
            return null;
        }
        HttpHost httpHostExtractHost = URIUtilsHC4.extractHost(uri);
        if (httpHostExtractHost != null) {
            return httpHostExtractHost;
        }
        throw new ClientProtocolException("URI does not specify a valid host name: " + uri);
    }

    public abstract CloseableHttpResponse doExecute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext);

    @Override // org.apache.http.client.HttpClient
    public CloseableHttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return doExecute(httpHost, httpRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public CloseableHttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        Args.notNull(httpUriRequest, "HTTP request");
        return doExecute(determineTarget(httpUriRequest), httpUriRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public CloseableHttpResponse execute(HttpUriRequest httpUriRequest) {
        return execute(httpUriRequest, (HttpContext) null);
    }

    @Override // org.apache.http.client.HttpClient
    public CloseableHttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) {
        return doExecute(httpHost, httpRequest, null);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) execute(httpUriRequest, responseHandler, (HttpContext) null);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return (T) execute(determineTarget(httpUriRequest), httpUriRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) execute(httpHost, httpRequest, responseHandler, null);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        Args.notNull(responseHandler, "Response handler");
        CloseableHttpResponse closeableHttpResponseExecute = execute(httpHost, httpRequest, httpContext);
        try {
            T tHandleResponse = responseHandler.handleResponse(closeableHttpResponseExecute);
            EntityUtilsHC4.consume(closeableHttpResponseExecute.getEntity());
            return tHandleResponse;
        } catch (Exception e) {
            try {
                EntityUtilsHC4.consume(closeableHttpResponseExecute.getEntity());
            } catch (Exception e2) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Error consuming content after an exception.", e2);
                }
            }
            if (!(e instanceof RuntimeException)) {
                if (e instanceof IOException) {
                    throw ((IOException) e);
                }
                throw new UndeclaredThrowableException(e);
            }
            throw ((RuntimeException) e);
        }
    }
}
