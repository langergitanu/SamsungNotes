package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
class CacheValidityPolicy {
    public static final long MAX_AGE = 2147483648L;

    public boolean contentLengthHeaderMatchesActualLength(HttpCacheEntry httpCacheEntry) {
        if (hasContentLengthHeader(httpCacheEntry)) {
            return httpCacheEntry.getResource() != null && getContentLengthValue(httpCacheEntry) == httpCacheEntry.getResource().length();
        }
        return true;
    }

    public long getAgeValue(HttpCacheEntry httpCacheEntry) {
        long j = 0;
        for (Header header : httpCacheEntry.getHeaders("Age")) {
            long j2 = MAX_AGE;
            try {
                long j3 = Long.parseLong(header.getValue());
                if (j3 >= 0) {
                    j2 = j3;
                }
            } catch (NumberFormatException unused) {
            }
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    public long getApparentAgeSecs(HttpCacheEntry httpCacheEntry) {
        Date date = httpCacheEntry.getDate();
        if (date == null) {
            return MAX_AGE;
        }
        long time = httpCacheEntry.getResponseDate().getTime() - date.getTime();
        if (time < 0) {
            return 0L;
        }
        return time / 1000;
    }

    public long getContentLengthValue(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Content-Length");
        if (firstHeader == null) {
            return -1L;
        }
        try {
            return Long.parseLong(firstHeader.getValue());
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public long getCorrectedInitialAgeSecs(HttpCacheEntry httpCacheEntry) {
        return getCorrectedReceivedAgeSecs(httpCacheEntry) + getResponseDelaySecs(httpCacheEntry);
    }

    public long getCorrectedReceivedAgeSecs(HttpCacheEntry httpCacheEntry) {
        long apparentAgeSecs = getApparentAgeSecs(httpCacheEntry);
        long ageValue = getAgeValue(httpCacheEntry);
        return apparentAgeSecs > ageValue ? apparentAgeSecs : ageValue;
    }

    public long getCurrentAgeSecs(HttpCacheEntry httpCacheEntry, Date date) {
        return getCorrectedInitialAgeSecs(httpCacheEntry) + getResidentTimeSecs(httpCacheEntry, date);
    }

    @Deprecated
    public Date getDateValue(HttpCacheEntry httpCacheEntry) {
        return httpCacheEntry.getDate();
    }

    public Date getExpirationDate(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Expires");
        if (firstHeader == null) {
            return null;
        }
        return DateUtils.parseDate(firstHeader.getValue());
    }

    public long getFreshnessLifetimeSecs(HttpCacheEntry httpCacheEntry) {
        Date expirationDate;
        long maxAge = getMaxAge(httpCacheEntry);
        if (maxAge > -1) {
            return maxAge;
        }
        Date date = httpCacheEntry.getDate();
        if (date == null || (expirationDate = getExpirationDate(httpCacheEntry)) == null) {
            return 0L;
        }
        return (expirationDate.getTime() - date.getTime()) / 1000;
    }

    public long getHeuristicFreshnessLifetimeSecs(HttpCacheEntry httpCacheEntry, float f, long j) {
        Date date = httpCacheEntry.getDate();
        Date lastModifiedValue = getLastModifiedValue(httpCacheEntry);
        if (date == null || lastModifiedValue == null) {
            return j;
        }
        if (date.getTime() - lastModifiedValue.getTime() < 0) {
            return 0L;
        }
        return (long) (f * (r5 / 1000));
    }

    public Date getLastModifiedValue(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Last-Modified");
        if (firstHeader == null) {
            return null;
        }
        return DateUtils.parseDate(firstHeader.getValue());
    }

    public long getMaxAge(HttpCacheEntry httpCacheEntry) {
        long j = -1;
        for (Header header : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if ("max-age".equals(headerElement.getName()) || HttpHeaders.Values.S_MAXAGE.equals(headerElement.getName())) {
                    try {
                        long j2 = Long.parseLong(headerElement.getValue());
                        if (j == -1 || j2 < j) {
                            j = j2;
                        }
                    } catch (NumberFormatException unused) {
                        j = 0;
                    }
                }
            }
        }
        return j;
    }

    public long getResidentTimeSecs(HttpCacheEntry httpCacheEntry, Date date) {
        return (date.getTime() - httpCacheEntry.getResponseDate().getTime()) / 1000;
    }

    public long getResponseDelaySecs(HttpCacheEntry httpCacheEntry) {
        return (httpCacheEntry.getResponseDate().getTime() - httpCacheEntry.getRequestDate().getTime()) / 1000;
    }

    public long getStalenessSecs(HttpCacheEntry httpCacheEntry, Date date) {
        long currentAgeSecs = getCurrentAgeSecs(httpCacheEntry, date);
        long freshnessLifetimeSecs = getFreshnessLifetimeSecs(httpCacheEntry);
        if (currentAgeSecs <= freshnessLifetimeSecs) {
            return 0L;
        }
        return currentAgeSecs - freshnessLifetimeSecs;
    }

    public boolean hasCacheControlDirective(HttpCacheEntry httpCacheEntry, String str) {
        for (Header header : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if (str.equalsIgnoreCase(headerElement.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasContentLengthHeader(HttpCacheEntry httpCacheEntry) {
        return httpCacheEntry.getFirstHeader("Content-Length") != null;
    }

    public boolean isResponseFresh(HttpCacheEntry httpCacheEntry, Date date) {
        return getCurrentAgeSecs(httpCacheEntry, date) < getFreshnessLifetimeSecs(httpCacheEntry);
    }

    public boolean isResponseHeuristicallyFresh(HttpCacheEntry httpCacheEntry, Date date, float f, long j) {
        return getCurrentAgeSecs(httpCacheEntry, date) < getHeuristicFreshnessLifetimeSecs(httpCacheEntry, f, j);
    }

    public boolean isRevalidatable(HttpCacheEntry httpCacheEntry) {
        return (httpCacheEntry.getFirstHeader("ETag") == null && httpCacheEntry.getFirstHeader("Last-Modified") == null) ? false : true;
    }

    public boolean mayReturnStaleIfError(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        long stalenessSecs = getStalenessSecs(httpCacheEntry, date);
        return mayReturnStaleIfError(httpRequest.getHeaders("Cache-Control"), stalenessSecs) || mayReturnStaleIfError(httpCacheEntry.getHeaders("Cache-Control"), stalenessSecs);
    }

    public boolean mayReturnStaleWhileRevalidating(HttpCacheEntry httpCacheEntry, Date date) {
        for (Header header : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if (HeaderConstants.STALE_WHILE_REVALIDATE.equalsIgnoreCase(headerElement.getName())) {
                    try {
                        if (getStalenessSecs(httpCacheEntry, date) <= Integer.parseInt(r7.getValue())) {
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public boolean mustRevalidate(HttpCacheEntry httpCacheEntry) {
        return hasCacheControlDirective(httpCacheEntry, "must-revalidate");
    }

    public boolean proxyRevalidate(HttpCacheEntry httpCacheEntry) {
        return hasCacheControlDirective(httpCacheEntry, "proxy-revalidate");
    }

    private boolean mayReturnStaleIfError(Header[] headerArr, long j) {
        boolean z = false;
        for (Header header : headerArr) {
            HeaderElement[] elements = header.getElements();
            int length = elements.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (HeaderConstants.STALE_IF_ERROR.equals(elements[i].getName())) {
                        try {
                            if (j <= Integer.parseInt(r7.getValue())) {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException unused) {
                            continue;
                        }
                    }
                    i++;
                }
            }
        }
        return z;
    }
}
