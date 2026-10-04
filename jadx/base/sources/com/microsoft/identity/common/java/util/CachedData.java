package com.microsoft.identity.common.java.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class CachedData<T> {
    private T mData;

    public void clear() {
        this.mData = null;
    }

    public T getData() {
        return this.mData;
    }

    public void setData(T t) {
        this.mData = t;
    }
}
