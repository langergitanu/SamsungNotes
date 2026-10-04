package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface HttpClient {
    HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest);

    HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext);

    HttpResponse execute(HttpUriRequest httpUriRequest);

    HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext);

    <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler);

    <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext);

    <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler);

    <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext);

    @Deprecated
    ClientConnectionManager getConnectionManager();

    @Deprecated
    HttpParams getParams();
}
