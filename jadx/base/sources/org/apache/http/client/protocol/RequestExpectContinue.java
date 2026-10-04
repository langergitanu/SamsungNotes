package org.apache.http.client.protocol;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class RequestExpectContinue implements HttpRequestInterceptor {
    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest.containsHeader("Expect") || !(httpRequest instanceof HttpEntityEnclosingRequest)) {
            return;
        }
        ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
        HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
        if (entity == null || entity.getContentLength() == 0 || protocolVersion.lessEquals(HttpVersion.HTTP_1_0) || !HttpClientContext.adapt(httpContext).getRequestConfig().isExpectContinueEnabled()) {
            return;
        }
        httpRequest.addHeader("Expect", "100-continue");
    }
}
