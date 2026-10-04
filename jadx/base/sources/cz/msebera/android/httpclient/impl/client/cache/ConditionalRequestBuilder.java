package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
class ConditionalRequestBuilder {
    public HttpRequestWrapper buildConditionalRequest(HttpRequestWrapper httpRequestWrapper, HttpCacheEntry httpCacheEntry) {
        HttpRequestWrapper httpRequestWrapperWrap = HttpRequestWrapper.wrap(httpRequestWrapper.getOriginal());
        httpRequestWrapperWrap.setHeaders(httpRequestWrapper.getAllHeaders());
        Header firstHeader = httpCacheEntry.getFirstHeader("ETag");
        if (firstHeader != null) {
            httpRequestWrapperWrap.setHeader("If-None-Match", firstHeader.getValue());
        }
        Header firstHeader2 = httpCacheEntry.getFirstHeader("Last-Modified");
        if (firstHeader2 != null) {
            httpRequestWrapperWrap.setHeader("If-Modified-Since", firstHeader2.getValue());
        }
        boolean z = false;
        for (Header header : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if ("must-revalidate".equalsIgnoreCase(headerElement.getName()) || "proxy-revalidate".equalsIgnoreCase(headerElement.getName())) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            httpRequestWrapperWrap.addHeader("Cache-Control", "max-age=0");
        }
        return httpRequestWrapperWrap;
    }

    public HttpRequestWrapper buildConditionalRequestFromVariants(HttpRequestWrapper httpRequestWrapper, Map<String, Variant> map) {
        HttpRequestWrapper httpRequestWrapperWrap = HttpRequestWrapper.wrap(httpRequestWrapper.getOriginal());
        httpRequestWrapperWrap.setHeaders(httpRequestWrapper.getAllHeaders());
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : map.keySet()) {
            if (!z) {
                sb.append(",");
            }
            sb.append(str);
            z = false;
        }
        httpRequestWrapperWrap.setHeader("If-None-Match", sb.toString());
        return httpRequestWrapperWrap;
    }

    public HttpRequestWrapper buildUnconditionalRequest(HttpRequestWrapper httpRequestWrapper, HttpCacheEntry httpCacheEntry) {
        HttpRequestWrapper httpRequestWrapperWrap = HttpRequestWrapper.wrap(httpRequestWrapper.getOriginal());
        httpRequestWrapperWrap.setHeaders(httpRequestWrapper.getAllHeaders());
        httpRequestWrapperWrap.addHeader("Cache-Control", "no-cache");
        httpRequestWrapperWrap.addHeader("Pragma", "no-cache");
        httpRequestWrapperWrap.removeHeaders("If-Range");
        httpRequestWrapperWrap.removeHeaders("If-Match");
        httpRequestWrapperWrap.removeHeaders("If-None-Match");
        httpRequestWrapperWrap.removeHeaders("If-Unmodified-Since");
        httpRequestWrapperWrap.removeHeaders("If-Modified-Since");
        return httpRequestWrapperWrap;
    }
}
