package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.play.core.assetpacks.model.AssetPackStorageMethod;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bg */
/* JADX INFO: loaded from: classes5.dex */
final class C5050bg extends AssetPackLocation {

    /* JADX INFO: renamed from: a */
    private final int f2614a;

    /* JADX INFO: renamed from: b */
    private final String f2615b;

    /* JADX INFO: renamed from: c */
    private final String f2616c;

    public C5050bg(int i, @Nullable String str, @Nullable String str2) {
        this.f2614a = i;
        this.f2615b = str;
        this.f2616c = str2;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackLocation
    @Nullable
    public final String assetsPath() {
        return this.f2616c;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackLocation) {
            AssetPackLocation assetPackLocation = (AssetPackLocation) obj;
            if (this.f2614a == assetPackLocation.packStorageMethod() && ((str = this.f2615b) != null ? str.equals(assetPackLocation.path()) : assetPackLocation.path() == null)) {
                String str2 = this.f2616c;
                String strAssetsPath = assetPackLocation.assetsPath();
                if (str2 != null ? str2.equals(strAssetsPath) : strAssetsPath == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.f2614a ^ 1000003) * 1000003;
        String str = this.f2615b;
        int iHashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f2616c;
        return iHashCode ^ (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackLocation
    @AssetPackStorageMethod
    public final int packStorageMethod() {
        return this.f2614a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackLocation
    @Nullable
    public final String path() {
        return this.f2615b;
    }

    public final String toString() {
        int i = this.f2614a;
        String str = this.f2615b;
        String str2 = this.f2616c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i);
        sb.append(", path=");
        sb.append(str);
        return AbstractC2322a.m1626p(sb, ", assetsPath=", str2, "}");
    }
}
