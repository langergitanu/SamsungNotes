package cz.msebera.android.httpclient.impl.client.cache;

import com.microsoft.identity.client.internal.MsalUtils;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpStatus;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
class ResponseCachingPolicy {
    private static final String[] AUTH_CACHEABLE_PARAMS = {HttpHeaders.Values.S_MAXAGE, "must-revalidate", "public"};
    private static final Set<Integer> cacheableStatuses = new HashSet(Arrays.asList(200, 203, 300, 301, Integer.valueOf(HttpStatus.SC_GONE)));
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final long maxObjectSizeBytes;
    private final boolean neverCache1_0ResponsesWithQueryString;
    private final boolean sharedCache;
    private final Set<Integer> uncacheableStatuses;

    public ResponseCachingPolicy(long j, boolean z, boolean z2, boolean z3) {
        this.maxObjectSizeBytes = j;
        this.sharedCache = z;
        this.neverCache1_0ResponsesWithQueryString = z2;
        if (z3) {
            this.uncacheableStatuses = new HashSet(Arrays.asList(206));
        } else {
            this.uncacheableStatuses = new HashSet(Arrays.asList(206, 303));
        }
    }

    private boolean expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(HttpResponse httpResponse) {
        if (httpResponse.getFirstHeader("Cache-Control") != null) {
            return false;
        }
        Header firstHeader = httpResponse.getFirstHeader("Expires");
        Header firstHeader2 = httpResponse.getFirstHeader("Date");
        if (firstHeader != null && firstHeader2 != null) {
            Date date = DateUtils.parseDate(firstHeader.getValue());
            Date date2 = DateUtils.parseDate(firstHeader2.getValue());
            if (date != null && date2 != null) {
                return date.equals(date2) || date.before(date2);
            }
        }
        return false;
    }

    private boolean from1_0Origin(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Via");
        if (firstHeader != null) {
            HeaderElement[] elements = firstHeader.getElements();
            if (elements.length > 0) {
                String str = elements[0].toString().split("\\s")[0];
                return str.contains("/") ? str.equals("HTTP/1.0") : str.equals("1.0");
            }
        }
        return HttpVersion.HTTP_1_0.equals(httpResponse.getProtocolVersion());
    }

    private boolean requestProtocolGreaterThanAccepted(HttpRequest httpRequest) {
        return httpRequest.getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) > 0;
    }

    private boolean unknownStatusCode(int i) {
        if (i >= 100 && i <= 101) {
            return false;
        }
        if (i >= 200 && i <= 206) {
            return false;
        }
        if (i >= 300 && i <= 307) {
            return false;
        }
        if (i < 400 || i > 417) {
            return i < 500 || i > 505;
        }
        return false;
    }

    public boolean hasCacheControlParameterFrom(HttpMessage httpMessage, String[] strArr) {
        for (Header header : httpMessage.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                for (String str : strArr) {
                    if (str.equalsIgnoreCase(headerElement.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isExplicitlyCacheable(HttpResponse httpResponse) {
        if (httpResponse.getFirstHeader("Expires") != null) {
            return true;
        }
        return hasCacheControlParameterFrom(httpResponse, new String[]{"max-age", HttpHeaders.Values.S_MAXAGE, "must-revalidate", "proxy-revalidate", "public"});
    }

    public boolean isExplicitlyNonCacheable(HttpResponse httpResponse) {
        for (Header header : httpResponse.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if ("no-store".equals(headerElement.getName()) || "no-cache".equals(headerElement.getName())) {
                    return true;
                }
                if (this.sharedCache && "private".equals(headerElement.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isResponseCacheable(String str, HttpResponse httpResponse) {
        boolean z;
        if (!"GET".equals(str) && !"HEAD".equals(str)) {
            this.log.debug("Response was not cacheable.");
            return false;
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (cacheableStatuses.contains(Integer.valueOf(statusCode))) {
            z = true;
        } else {
            if (this.uncacheableStatuses.contains(Integer.valueOf(statusCode)) || unknownStatusCode(statusCode)) {
                return false;
            }
            z = false;
        }
        Header firstHeader = httpResponse.getFirstHeader("Content-Length");
        if ((firstHeader != null && Long.parseLong(firstHeader.getValue()) > this.maxObjectSizeBytes) || httpResponse.getHeaders("Age").length > 1 || httpResponse.getHeaders("Expires").length > 1) {
            return false;
        }
        Header[] headers = httpResponse.getHeaders("Date");
        if (headers.length != 1 || DateUtils.parseDate(headers[0].getValue()) == null) {
            return false;
        }
        for (Header header : httpResponse.getHeaders("Vary")) {
            for (HeaderElement headerElement : header.getElements()) {
                if ("*".equals(headerElement.getName())) {
                    return false;
                }
            }
        }
        if (isExplicitlyNonCacheable(httpResponse)) {
            return false;
        }
        return z || isExplicitlyCacheable(httpResponse);
    }

    public boolean isResponseCacheable(HttpRequest httpRequest, HttpResponse httpResponse) {
        Header[] headers;
        if (requestProtocolGreaterThanAccepted(httpRequest)) {
            this.log.debug("Response was not cacheable.");
            return false;
        }
        if (hasCacheControlParameterFrom(httpRequest, new String[]{"no-store"})) {
            return false;
        }
        if (httpRequest.getRequestLine().getUri().contains(MsalUtils.QUERY_STRING_SYMBOL)) {
            if (this.neverCache1_0ResponsesWithQueryString && from1_0Origin(httpResponse)) {
                this.log.debug("Response was not cacheable as it had a query string.");
                return false;
            }
            if (!isExplicitlyCacheable(httpResponse)) {
                this.log.debug("Response was not cacheable as it is missing explicit caching headers.");
                return false;
            }
        }
        if (expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(httpResponse)) {
            return false;
        }
        if (!this.sharedCache || (headers = httpRequest.getHeaders("Authorization")) == null || headers.length <= 0 || hasCacheControlParameterFrom(httpResponse, AUTH_CACHEABLE_PARAMS)) {
            return isResponseCacheable(httpRequest.getRequestLine().getMethod(), httpResponse);
        }
        return false;
    }
}
