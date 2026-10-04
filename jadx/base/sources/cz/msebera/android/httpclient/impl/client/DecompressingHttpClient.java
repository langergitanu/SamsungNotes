package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class DecompressingHttpClient implements HttpClient {
    private final HttpRequestInterceptor acceptEncodingInterceptor;
    private final HttpClient backend;
    private final HttpResponseInterceptor contentEncodingInterceptor;

    public DecompressingHttpClient() {
        this(new DefaultHttpClient());
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest) {
        return execute(getHttpHost(httpUriRequest), httpUriRequest, (HttpContext) null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    public HttpClient getHttpClient() {
        return this.backend;
    }

    public HttpHost getHttpHost(HttpUriRequest httpUriRequest) {
        return URIUtils.extractHost(httpUriRequest.getURI());
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpParams getParams() {
        return this.backend.getParams();
    }

    public DecompressingHttpClient(HttpClient httpClient) {
        this(httpClient, new RequestAcceptEncoding(), new ResponseContentEncoding());
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        return execute(getHttpHost(httpUriRequest), httpUriRequest, httpContext);
    }

    public DecompressingHttpClient(HttpClient httpClient, HttpRequestInterceptor httpRequestInterceptor, HttpResponseInterceptor httpResponseInterceptor) {
        this.backend = httpClient;
        this.acceptEncodingInterceptor = httpRequestInterceptor;
        this.contentEncodingInterceptor = httpResponseInterceptor;
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        HttpRequest requestWrapper;
        if (httpContext == null) {
            try {
                httpContext = new BasicHttpContext();
            } catch (HttpException e) {
                throw new ClientProtocolException(e);
            }
        }
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            requestWrapper = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest);
        } else {
            requestWrapper = new RequestWrapper(httpRequest);
        }
        this.acceptEncodingInterceptor.process(requestWrapper, httpContext);
        HttpResponse httpResponseExecute = this.backend.execute(httpHost, requestWrapper, httpContext);
        try {
            try {
                this.contentEncodingInterceptor.process(httpResponseExecute, httpContext);
                if (!Boolean.TRUE.equals(httpContext.getAttribute("http.client.response.uncompressed"))) {
                    return httpResponseExecute;
                }
                httpResponseExecute.removeHeaders("Content-Length");
                httpResponseExecute.removeHeaders("Content-Encoding");
                httpResponseExecute.removeHeaders("Content-MD5");
                return httpResponseExecute;
            } catch (IOException e2) {
                EntityUtils.consume(httpResponseExecute.getEntity());
                throw e2;
            }
        } catch (HttpException e3) {
            EntityUtils.consume(httpResponseExecute.getEntity());
            throw e3;
        } catch (RuntimeException e5) {
            EntityUtils.consume(httpResponseExecute.getEntity());
            throw e5;
        }
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) execute(getHttpHost(httpUriRequest), httpUriRequest, responseHandler);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return (T) execute(getHttpHost(httpUriRequest), httpUriRequest, responseHandler, httpContext);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) execute(httpHost, httpRequest, responseHandler, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        HttpResponse httpResponseExecute = execute(httpHost, httpRequest, httpContext);
        try {
            return responseHandler.handleResponse(httpResponseExecute);
        } finally {
            HttpEntity entity = httpResponseExecute.getEntity();
            if (entity != null) {
                EntityUtils.consume(entity);
            }
        }
    }
}
