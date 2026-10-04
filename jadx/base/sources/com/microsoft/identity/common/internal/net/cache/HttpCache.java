package com.microsoft.identity.common.internal.net.cache;

import android.content.Context;
import android.net.http.HttpResponseCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.HttpCache;
import com.microsoft.identity.common.logging.Logger;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HttpCache {
    public static final long DEFAULT_HTTP_CACHE_CAPACITY_BYTES = 10485760;
    public static final String DEFAULT_HTTP_CACHE_NAME = "com.microsoft.identity.http-cache";
    private static final String TAG = "HttpCache";

    public static void flush() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":flush", new StringBuilder());
        HttpResponseCache installed = getInstalled();
        if (installed != null) {
            installed.flush();
        } else {
            Logger.warn(strM1170p, "Unable to flush cache because none is installed.");
        }
    }

    @Nullable
    public static HttpResponseCache getInstalled() {
        return HttpResponseCache.getInstalled();
    }

    public static synchronized boolean initialize(@NonNull File file, @NonNull String str, long j) {
        String str2 = TAG + ":initialize";
        boolean z = true;
        if (HttpResponseCache.getInstalled() != null) {
            return true;
        }
        try {
            HttpResponseCache.install(new File(file, str), j);
        } catch (IOException e) {
            Logger.error(str2, "HTTP Response cache installation failed.", e);
            z = false;
        }
        com.microsoft.identity.common.java.cache.HttpCache.setHttpCache(new HttpCache.IHttpCacheCallback() { // from class: com.microsoft.identity.common.internal.net.cache.HttpCache.1
            @Override // com.microsoft.identity.common.java.cache.HttpCache.IHttpCacheCallback
            public void flush() {
                HttpCache.flush();
            }
        });
        return z;
    }

    public static synchronized boolean initialize(@NonNull Context context) {
        String str = TAG + ":initialize";
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return initialize(cacheDir);
        }
        Logger.warn(str, "Http caching is not enabled because the cache dir is null");
        return false;
    }

    public static synchronized boolean initialize(@NonNull File file) {
        return initialize(file, DEFAULT_HTTP_CACHE_NAME, 10485760L);
    }
}
