package org.apache.http.client.protocol;

import io.netty.handler.codec.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class RequestAcceptEncoding implements HttpRequestInterceptor {
    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (httpRequest.containsHeader("Accept-Encoding")) {
            return;
        }
        httpRequest.addHeader("Accept-Encoding", HttpHeaders.Values.GZIP_DEFLATE);
    }
}
