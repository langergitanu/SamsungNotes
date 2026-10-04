package org.apache.http.client.protocol;

import com.google.api.client.http.HttpMethods;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import java.util.Collection;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class RequestDefaultHeadersHC4 implements HttpRequestInterceptor {
    private final Collection<? extends Header> defaultHeaders;

    public RequestDefaultHeadersHC4(Collection<? extends Header> collection) {
        this.defaultHeaders = collection;
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase(HttpMethods.CONNECT)) {
            return;
        }
        Collection<? extends Header> collection = (Collection) httpRequest.getParams().getParameter(ClientPNames.DEFAULT_HEADERS);
        if (collection == null) {
            collection = this.defaultHeaders;
        }
        if (collection != null) {
            Iterator<? extends Header> it = collection.iterator();
            while (it.hasNext()) {
                httpRequest.addHeader(it.next());
            }
        }
    }

    public RequestDefaultHeadersHC4() {
        this(null);
    }
}
