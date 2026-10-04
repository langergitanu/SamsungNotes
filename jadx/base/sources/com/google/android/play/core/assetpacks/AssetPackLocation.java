package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import com.google.android.play.core.assetpacks.model.AssetPackStorageMethod;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AssetPackLocation {

    /* JADX INFO: renamed from: a */
    private static final AssetPackLocation f2505a = new C5050bg(1, null, null);

    /* JADX INFO: renamed from: a */
    public static AssetPackLocation m3621a() {
        return f2505a;
    }

    @Nullable
    public abstract String assetsPath();

    @AssetPackStorageMethod
    public abstract int packStorageMethod();

    @Nullable
    public abstract String path();

    /* JADX INFO: renamed from: a */
    public static AssetPackLocation m3622a(String str, String str2) {
        return new C5050bg(0, str, str2);
    }
}
