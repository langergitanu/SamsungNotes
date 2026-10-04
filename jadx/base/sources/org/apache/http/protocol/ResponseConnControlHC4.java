package org.apache.http.protocol;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class ResponseConnControlHC4 implements HttpResponseInterceptor {
    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        HttpCoreContext httpCoreContextAdapt = HttpCoreContext.adapt(httpContext);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 400 || statusCode == 408 || statusCode == 411 || statusCode == 413 || statusCode == 414 || statusCode == 503 || statusCode == 501) {
            httpResponse.setHeader("Connection", cz.msebera.android.httpclient.protocol.HTTP.CONN_CLOSE);
            return;
        }
        Header firstHeader = httpResponse.getFirstHeader("Connection");
        if (firstHeader == null || !cz.msebera.android.httpclient.protocol.HTTP.CONN_CLOSE.equalsIgnoreCase(firstHeader.getValue())) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
                if (entity.getContentLength() < 0 && (!entity.isChunked() || protocolVersion.lessEquals(HttpVersion.HTTP_1_0))) {
                    httpResponse.setHeader("Connection", cz.msebera.android.httpclient.protocol.HTTP.CONN_CLOSE);
                    return;
                }
            }
            HttpRequest request = httpCoreContextAdapt.getRequest();
            if (request != null) {
                Header firstHeader2 = request.getFirstHeader("Connection");
                if (firstHeader2 != null) {
                    httpResponse.setHeader("Connection", firstHeader2.getValue());
                } else if (request.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                    httpResponse.setHeader("Connection", cz.msebera.android.httpclient.protocol.HTTP.CONN_CLOSE);
                }
            }
        }
    }
}
