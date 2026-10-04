package com.google.android.play.core.assetpacks;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bi */
/* JADX INFO: loaded from: classes5.dex */
final class C5052bi extends AssetPackStates {

    /* JADX INFO: renamed from: a */
    private final long f2623a;

    /* JADX INFO: renamed from: b */
    private final Map<String, AssetPackState> f2624b;

    public C5052bi(long j, Map<String, AssetPackState> map) {
        this.f2623a = j;
        this.f2624b = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackStates) {
            AssetPackStates assetPackStates = (AssetPackStates) obj;
            if (this.f2623a == assetPackStates.totalBytes() && this.f2624b.equals(assetPackStates.packStates())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f2623a;
        return ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f2624b.hashCode();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackStates
    public final Map<String, AssetPackState> packStates() {
        return this.f2624b;
    }

    public final String toString() {
        long j = this.f2623a;
        String strValueOf = String.valueOf(this.f2624b);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 61);
        AbstractC1038a.m1223x(sb, "AssetPackStates{totalBytes=", j, ", packStates=");
        return AbstractC0622a.m1170p(strValueOf, "}", sb);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackStates
    public final long totalBytes() {
        return this.f2623a;
    }
}
