package com.google.android.play.core.assetpacks;

import androidx.compose.runtime.AbstractC1974b;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bf */
/* JADX INFO: loaded from: classes5.dex */
final class C5049bf extends AssetLocation {

    /* JADX INFO: renamed from: a */
    private final String f2611a;

    /* JADX INFO: renamed from: b */
    private final long f2612b;

    /* JADX INFO: renamed from: c */
    private final long f2613c;

    public C5049bf(String str, long j, long j2) {
        if (str == null) {
            throw new NullPointerException("Null path");
        }
        this.f2611a = str;
        this.f2612b = j;
        this.f2613c = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetLocation) {
            AssetLocation assetLocation = (AssetLocation) obj;
            if (this.f2611a.equals(assetLocation.path()) && this.f2612b == assetLocation.offset() && this.f2613c == assetLocation.size()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f2611a.hashCode();
        long j = this.f2612b;
        long j2 = this.f2613c;
        return ((((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2));
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final long offset() {
        return this.f2612b;
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final String path() {
        return this.f2611a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final long size() {
        return this.f2613c;
    }

    public final String toString() {
        String str = this.f2611a;
        long j = this.f2612b;
        long j2 = this.f2613c;
        StringBuilder sb = new StringBuilder(str.length() + 76);
        AbstractC1974b.m1332y(sb, "AssetLocation{path=", str, ", offset=");
        sb.append(j);
        sb.append(", size=");
        sb.append(j2);
        sb.append("}");
        return sb.toString();
    }
}
