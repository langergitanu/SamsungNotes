package com.google.android.play.core.assetpacks;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AssetLocation {
    /* JADX INFO: renamed from: a */
    public static AssetLocation m3617a(String str, long j, long j2) {
        return new C5049bf(str, j, j2);
    }

    public abstract long offset();

    public abstract String path();

    public abstract long size();
}
