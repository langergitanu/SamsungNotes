package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import java.util.Date;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
interface HttpCache {
    HttpResponse cacheAndReturnResponse(HttpHost httpHost, HttpRequest httpRequest, HttpResponse httpResponse, Date date, Date date2);

    CloseableHttpResponse cacheAndReturnResponse(HttpHost httpHost, HttpRequest httpRequest, CloseableHttpResponse closeableHttpResponse, Date date, Date date2);

    void flushCacheEntriesFor(HttpHost httpHost, HttpRequest httpRequest);

    void flushInvalidatedCacheEntriesFor(HttpHost httpHost, HttpRequest httpRequest);

    void flushInvalidatedCacheEntriesFor(HttpHost httpHost, HttpRequest httpRequest, HttpResponse httpResponse);

    HttpCacheEntry getCacheEntry(HttpHost httpHost, HttpRequest httpRequest);

    Map<String, Variant> getVariantCacheEntriesWithEtags(HttpHost httpHost, HttpRequest httpRequest);

    void reuseVariantEntryFor(HttpHost httpHost, HttpRequest httpRequest, Variant variant);

    HttpCacheEntry updateCacheEntry(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, HttpResponse httpResponse, Date date, Date date2);

    HttpCacheEntry updateVariantCacheEntry(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, HttpResponse httpResponse, Date date, Date date2, String str);
}
