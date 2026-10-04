package org.apache.http.protocol;

import cz.msebera.android.httpclient.params.CoreProtocolPNames;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class RequestUserAgentHC4 implements HttpRequestInterceptor {
    private final String userAgent;

    public RequestUserAgentHC4(String str) {
        this.userAgent = str;
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest.containsHeader("User-Agent")) {
            return;
        }
        HttpParams params = httpRequest.getParams();
        String str = params != null ? (String) params.getParameter(CoreProtocolPNames.USER_AGENT) : null;
        if (str == null) {
            str = this.userAgent;
        }
        if (str != null) {
            httpRequest.addHeader("User-Agent", str);
        }
    }

    public RequestUserAgentHC4() {
        this(null);
    }
}
