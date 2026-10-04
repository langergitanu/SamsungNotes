package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import cz.msebera.android.httpclient.message.BasicStatusLine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
class RequestProtocolCompliance {
    private static final List<String> disallowedWithNoCache = Arrays.asList("min-fresh", "max-stale", "max-age");
    private final boolean weakETagOnPutDeleteAllowed;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.impl.client.cache.RequestProtocolCompliance$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C119492 {

        /* JADX INFO: renamed from: $SwitchMap$cz$msebera$android$httpclient$impl$client$cache$RequestProtocolError */
        static final /* synthetic */ int[] f8499x3102a434;

        static {
            int[] iArr = new int[RequestProtocolError.values().length];
            f8499x3102a434 = iArr;
            try {
                iArr[RequestProtocolError.BODY_BUT_NO_LENGTH_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8499x3102a434[RequestProtocolError.WEAK_ETAG_AND_RANGE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8499x3102a434[RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8499x3102a434[RequestProtocolError.NO_CACHE_DIRECTIVE_WITH_FIELD_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public RequestProtocolCompliance() {
        this.weakETagOnPutDeleteAllowed = false;
    }

    private void add100ContinueHeaderIfMissing(HttpRequest httpRequest) {
        boolean z = false;
        for (Header header : httpRequest.getHeaders("Expect")) {
            for (HeaderElement headerElement : header.getElements()) {
                if ("100-continue".equalsIgnoreCase(headerElement.getName())) {
                    z = true;
                }
            }
        }
        if (z) {
            return;
        }
        httpRequest.addHeader("Expect", "100-continue");
    }

    private void addContentTypeHeaderIfMissing(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        if (entity == null || entity.getContentType() != null) {
            return;
        }
        httpEntityEnclosingRequest.setEntity(new HttpEntityWrapper(entity) { // from class: cz.msebera.android.httpclient.impl.client.cache.RequestProtocolCompliance.1
            @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
            public Header getContentType() {
                return new BasicHeader("Content-Type", ContentType.APPLICATION_OCTET_STREAM.getMimeType());
            }
        });
    }

    private String buildHeaderFromElements(List<HeaderElement> list) {
        StringBuilder sb = new StringBuilder("");
        boolean z = true;
        for (HeaderElement headerElement : list) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append(headerElement.toString());
        }
        return sb.toString();
    }

    private void decrementOPTIONSMaxForwardsIfGreaterThen0(HttpRequest httpRequest) {
        Header firstHeader;
        if ("OPTIONS".equals(httpRequest.getRequestLine().getMethod()) && (firstHeader = httpRequest.getFirstHeader("Max-Forwards")) != null) {
            httpRequest.removeHeaders("Max-Forwards");
            httpRequest.setHeader("Max-Forwards", Integer.toString(Integer.parseInt(firstHeader.getValue()) - 1));
        }
    }

    private void remove100ContinueHeaderIfExists(HttpRequest httpRequest) {
        Header[] headers = httpRequest.getHeaders("Expect");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (Header header : headers) {
            for (HeaderElement headerElement : header.getElements()) {
                if ("100-continue".equalsIgnoreCase(headerElement.getName())) {
                    z = true;
                } else {
                    arrayList.add(headerElement);
                }
            }
            if (z) {
                httpRequest.removeHeader(header);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    httpRequest.addHeader(new BasicHeader("Expect", ((HeaderElement) it.next()).getName()));
                }
                return;
            }
            arrayList = new ArrayList();
        }
    }

    private RequestProtocolError requestContainsNoCacheDirectiveWithFieldName(HttpRequest httpRequest) {
        for (Header header : httpRequest.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if ("no-cache".equalsIgnoreCase(headerElement.getName()) && headerElement.getValue() != null) {
                    return RequestProtocolError.NO_CACHE_DIRECTIVE_WITH_FIELD_NAME;
                }
            }
        }
        return null;
    }

    private RequestProtocolError requestHasWeakETagAndRange(HttpRequest httpRequest) {
        Header firstHeader;
        if ("GET".equals(httpRequest.getRequestLine().getMethod()) && httpRequest.getFirstHeader("Range") != null && (firstHeader = httpRequest.getFirstHeader("If-Range")) != null && firstHeader.getValue().startsWith("W/")) {
            return RequestProtocolError.WEAK_ETAG_AND_RANGE_ERROR;
        }
        return null;
    }

    private RequestProtocolError requestHasWeekETagForPUTOrDELETEIfMatch(HttpRequest httpRequest) {
        String method = httpRequest.getRequestLine().getMethod();
        if (!"PUT".equals(method) && !"DELETE".equals(method)) {
            return null;
        }
        Header firstHeader = httpRequest.getFirstHeader("If-Match");
        if (firstHeader == null) {
            Header firstHeader2 = httpRequest.getFirstHeader("If-None-Match");
            if (firstHeader2 != null && firstHeader2.getValue().startsWith("W/")) {
                return RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR;
            }
        } else if (firstHeader.getValue().startsWith("W/")) {
            return RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR;
        }
        return null;
    }

    private boolean requestMustNotHaveEntity(HttpRequest httpRequest) {
        return "TRACE".equals(httpRequest.getRequestLine().getMethod()) && (httpRequest instanceof HttpEntityEnclosingRequest);
    }

    private void stripOtherFreshnessDirectivesWithNoCache(HttpRequest httpRequest) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (Header header : httpRequest.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if (!disallowedWithNoCache.contains(headerElement.getName())) {
                    arrayList.add(headerElement);
                }
                if ("no-cache".equals(headerElement.getName())) {
                    z = true;
                }
            }
        }
        if (z) {
            httpRequest.removeHeaders("Cache-Control");
            httpRequest.setHeader("Cache-Control", buildHeaderFromElements(arrayList));
        }
    }

    private void verifyOPTIONSRequestWithBodyHasContentType(HttpRequest httpRequest) {
        if ("OPTIONS".equals(httpRequest.getRequestLine().getMethod()) && (httpRequest instanceof HttpEntityEnclosingRequest)) {
            addContentTypeHeaderIfMissing((HttpEntityEnclosingRequest) httpRequest);
        }
    }

    private void verifyRequestWithExpectContinueFlagHas100continueHeader(HttpRequest httpRequest) {
        if (!(httpRequest instanceof HttpEntityEnclosingRequest)) {
            remove100ContinueHeaderIfExists(httpRequest);
            return;
        }
        HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
        if (!httpEntityEnclosingRequest.expectContinue() || httpEntityEnclosingRequest.getEntity() == null) {
            remove100ContinueHeaderIfExists(httpRequest);
        } else {
            add100ContinueHeaderIfMissing(httpRequest);
        }
    }

    public HttpResponse getErrorForRequest(RequestProtocolError requestProtocolError) {
        int i = C119492.f8499x3102a434[requestProtocolError.ordinal()];
        if (i == 1) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 411, ""));
        }
        if (i == 2) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "Weak eTag not compatible with byte range"));
        }
        if (i == 3) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "Weak eTag not compatible with PUT or DELETE requests"));
        }
        if (i == 4) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "No-Cache directive MUST NOT include a field name"));
        }
        throw new IllegalStateException("The request was compliant, therefore no error can be generated for it.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void makeRequestCompliant(HttpRequestWrapper httpRequestWrapper) {
        if (requestMustNotHaveEntity(httpRequestWrapper)) {
            ((HttpEntityEnclosingRequest) httpRequestWrapper).setEntity(null);
        }
        verifyRequestWithExpectContinueFlagHas100continueHeader(httpRequestWrapper);
        verifyOPTIONSRequestWithBodyHasContentType(httpRequestWrapper);
        decrementOPTIONSMaxForwardsIfGreaterThen0(httpRequestWrapper);
        stripOtherFreshnessDirectivesWithNoCache(httpRequestWrapper);
        if (requestVersionIsTooLow(httpRequestWrapper) || requestMinorVersionIsTooHighMajorVersionsMatch(httpRequestWrapper)) {
            httpRequestWrapper.setProtocolVersion(HttpVersion.HTTP_1_1);
        }
    }

    public List<RequestProtocolError> requestIsFatallyNonCompliant(HttpRequest httpRequest) {
        RequestProtocolError requestProtocolErrorRequestHasWeekETagForPUTOrDELETEIfMatch;
        ArrayList arrayList = new ArrayList();
        RequestProtocolError requestProtocolErrorRequestHasWeakETagAndRange = requestHasWeakETagAndRange(httpRequest);
        if (requestProtocolErrorRequestHasWeakETagAndRange != null) {
            arrayList.add(requestProtocolErrorRequestHasWeakETagAndRange);
        }
        if (!this.weakETagOnPutDeleteAllowed && (requestProtocolErrorRequestHasWeekETagForPUTOrDELETEIfMatch = requestHasWeekETagForPUTOrDELETEIfMatch(httpRequest)) != null) {
            arrayList.add(requestProtocolErrorRequestHasWeekETagForPUTOrDELETEIfMatch);
        }
        RequestProtocolError requestProtocolErrorRequestContainsNoCacheDirectiveWithFieldName = requestContainsNoCacheDirectiveWithFieldName(httpRequest);
        if (requestProtocolErrorRequestContainsNoCacheDirectiveWithFieldName != null) {
            arrayList.add(requestProtocolErrorRequestContainsNoCacheDirectiveWithFieldName);
        }
        return arrayList;
    }

    public boolean requestMinorVersionIsTooHighMajorVersionsMatch(HttpRequest httpRequest) {
        ProtocolVersion protocolVersion = httpRequest.getProtocolVersion();
        int major = protocolVersion.getMajor();
        HttpVersion httpVersion = HttpVersion.HTTP_1_1;
        return major == httpVersion.getMajor() && protocolVersion.getMinor() > httpVersion.getMinor();
    }

    public boolean requestVersionIsTooLow(HttpRequest httpRequest) {
        return httpRequest.getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) < 0;
    }

    public RequestProtocolCompliance(boolean z) {
        this.weakETagOnPutDeleteAllowed = z;
    }
}
