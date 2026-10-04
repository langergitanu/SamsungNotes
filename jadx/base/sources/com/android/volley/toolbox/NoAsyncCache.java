package com.android.volley.toolbox;

import com.android.volley.AsyncCache;
import com.android.volley.Cache;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class NoAsyncCache extends AsyncCache {
    @Override // com.android.volley.AsyncCache
    public void clear(AsyncCache.OnWriteCompleteCallback onWriteCompleteCallback) {
        onWriteCompleteCallback.onWriteComplete();
    }

    @Override // com.android.volley.AsyncCache
    public void get(String str, AsyncCache.OnGetCompleteCallback onGetCompleteCallback) {
        onGetCompleteCallback.onGetComplete(null);
    }

    @Override // com.android.volley.AsyncCache
    public void initialize(AsyncCache.OnWriteCompleteCallback onWriteCompleteCallback) {
        onWriteCompleteCallback.onWriteComplete();
    }

    @Override // com.android.volley.AsyncCache
    public void invalidate(String str, boolean z, AsyncCache.OnWriteCompleteCallback onWriteCompleteCallback) {
        onWriteCompleteCallback.onWriteComplete();
    }

    @Override // com.android.volley.AsyncCache
    public void put(String str, Cache.Entry entry, AsyncCache.OnWriteCompleteCallback onWriteCompleteCallback) {
        onWriteCompleteCallback.onWriteComplete();
    }

    @Override // com.android.volley.AsyncCache
    public void remove(String str, AsyncCache.OnWriteCompleteCallback onWriteCompleteCallback) {
        onWriteCompleteCallback.onWriteComplete();
    }
}
