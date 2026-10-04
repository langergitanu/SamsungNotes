package org.apache.http.impl.execchain;

import android.util.Log;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.NoHttpResponseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class RetryExec implements ClientExecChain {
    private static final String TAG = "HttpClient";
    private final ClientExecChain requestExecutor;
    private final HttpRequestRetryHandler retryHandler;

    public RetryExec(ClientExecChain clientExecChain, HttpRequestRetryHandler httpRequestRetryHandler) {
        Args.notNull(clientExecChain, "HTTP request executor");
        Args.notNull(httpRequestRetryHandler, "HTTP request retry handler");
        this.requestExecutor = clientExecChain;
        this.retryHandler = httpRequestRetryHandler;
    }

    @Override // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException {
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        Header[] allHeaders = httpRequestWrapper.getAllHeaders();
        int i = 1;
        while (true) {
            try {
                return this.requestExecutor.execute(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
            } catch (IOException e) {
                if (httpExecutionAware != null && httpExecutionAware.isAborted()) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Request has been aborted");
                    }
                    throw e;
                }
                if (!this.retryHandler.retryRequest(e, i, httpClientContext)) {
                    if (!(e instanceof NoHttpResponseException)) {
                        throw e;
                    }
                    NoHttpResponseException noHttpResponseException = new NoHttpResponseException(String.valueOf(httpRoute.getTargetHost().toHostString()).concat(" failed to respond"));
                    noHttpResponseException.setStackTrace(e.getStackTrace());
                    throw noHttpResponseException;
                }
                if (Log.isLoggable(TAG, 4)) {
                    Log.i(TAG, "I/O exception (" + e.getClass().getName() + ") caught when processing request to " + httpRoute + ": " + e.getMessage());
                }
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, e.getMessage(), e);
                }
                if (!RequestEntityProxy.isRepeatable(httpRequestWrapper)) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Cannot retry non-repeatable request");
                    }
                    new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity").initCause(e);
                }
                httpRequestWrapper.setHeaders(allHeaders);
                if (Log.isLoggable(TAG, 4)) {
                    Log.i(TAG, "Retrying request to " + httpRoute);
                }
                i++;
            }
        }
    }
}
