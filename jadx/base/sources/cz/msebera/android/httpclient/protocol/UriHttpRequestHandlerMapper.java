package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE)
public class UriHttpRequestHandlerMapper implements HttpRequestHandlerMapper {
    private final UriPatternMatcher<HttpRequestHandler> matcher;

    public UriHttpRequestHandlerMapper(UriPatternMatcher<HttpRequestHandler> uriPatternMatcher) {
        this.matcher = (UriPatternMatcher) Args.notNull(uriPatternMatcher, "Pattern matcher");
    }

    public String getRequestPath(HttpRequest httpRequest) {
        String uri = httpRequest.getRequestLine().getUri();
        int iIndexOf = uri.indexOf(63);
        if (iIndexOf != -1) {
            return uri.substring(0, iIndexOf);
        }
        int iIndexOf2 = uri.indexOf(35);
        return iIndexOf2 != -1 ? uri.substring(0, iIndexOf2) : uri;
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestHandlerMapper
    public HttpRequestHandler lookup(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        return this.matcher.lookup(getRequestPath(httpRequest));
    }

    public void register(String str, HttpRequestHandler httpRequestHandler) {
        Args.notNull(str, "Pattern");
        Args.notNull(httpRequestHandler, "Handler");
        this.matcher.register(str, httpRequestHandler);
    }

    public void unregister(String str) {
        this.matcher.unregister(str);
    }

    public UriHttpRequestHandlerMapper() {
        this(new UriPatternMatcher());
    }
}
