package com.android.volley.toolbox;

import com.android.volley.Cache;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class NoCache implements Cache {
    @Override // com.android.volley.Cache
    public Cache.Entry get(String str) {
        return null;
    }

    @Override // com.android.volley.Cache
    public void clear() {
    }

    @Override // com.android.volley.Cache
    public void initialize() {
    }

    @Override // com.android.volley.Cache
    public void remove(String str) {
    }

    @Override // com.android.volley.Cache
    public void invalidate(String str, boolean z) {
    }

    @Override // com.android.volley.Cache
    public void put(String str, Cache.Entry entry) {
    }
}
