package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
class CacheableRequestPolicy {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    public boolean isServableFromCache(HttpRequest httpRequest) {
        String method = httpRequest.getRequestLine().getMethod();
        if (HttpVersion.HTTP_1_1.compareToVersion(httpRequest.getRequestLine().getProtocolVersion()) != 0) {
            this.log.trace("non-HTTP/1.1 request was not serveable from cache");
            return false;
        }
        if (!method.equals("GET") && !method.equals("HEAD")) {
            this.log.trace("non-GET or non-HEAD request was not serveable from cache");
            return false;
        }
        if (httpRequest.getHeaders("Pragma").length > 0) {
            this.log.trace("request with Pragma header was not serveable from cache");
            return false;
        }
        for (Header header : httpRequest.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if ("no-store".equalsIgnoreCase(headerElement.getName())) {
                    this.log.trace("Request with no-store was not serveable from cache");
                    return false;
                }
                if ("no-cache".equalsIgnoreCase(headerElement.getName())) {
                    this.log.trace("Request with no-cache was not serveable from cache");
                    return false;
                }
            }
        }
        this.log.trace("Request was serveable from cache");
        return true;
    }
}
