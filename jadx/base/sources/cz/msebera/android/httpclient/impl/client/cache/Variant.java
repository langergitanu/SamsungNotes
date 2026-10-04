package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class Variant {
    private final String cacheKey;
    private final HttpCacheEntry entry;
    private final String variantKey;

    public Variant(String str, String str2, HttpCacheEntry httpCacheEntry) {
        this.variantKey = str;
        this.cacheKey = str2;
        this.entry = httpCacheEntry;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public HttpCacheEntry getEntry() {
        return this.entry;
    }

    public String getVariantKey() {
        return this.variantKey;
    }
}
