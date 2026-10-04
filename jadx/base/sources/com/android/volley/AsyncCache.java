package com.android.volley;

import androidx.annotation.Nullable;
import com.android.volley.Cache;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AsyncCache {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnGetCompleteCallback {
        void onGetComplete(@Nullable Cache.Entry entry);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnWriteCompleteCallback {
        void onWriteComplete();
    }

    public abstract void clear(OnWriteCompleteCallback onWriteCompleteCallback);

    public abstract void get(String str, OnGetCompleteCallback onGetCompleteCallback);

    public abstract void initialize(OnWriteCompleteCallback onWriteCompleteCallback);

    public abstract void invalidate(String str, boolean z, OnWriteCompleteCallback onWriteCompleteCallback);

    public abstract void put(String str, Cache.Entry entry, OnWriteCompleteCallback onWriteCompleteCallback);

    public abstract void remove(String str, OnWriteCompleteCallback onWriteCompleteCallback);
}
