package com.google.android.play.core.assetpacks;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.google.android.play.core.assetpacks.model.AssetPackErrorCode;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bh */
/* JADX INFO: loaded from: classes5.dex */
final class C5051bh extends AssetPackState {

    /* JADX INFO: renamed from: a */
    private final String f2617a;

    /* JADX INFO: renamed from: b */
    private final int f2618b;

    /* JADX INFO: renamed from: c */
    private final int f2619c;

    /* JADX INFO: renamed from: d */
    private final long f2620d;

    /* JADX INFO: renamed from: e */
    private final long f2621e;

    /* JADX INFO: renamed from: f */
    private final int f2622f;

    public C5051bh(String str, int i, int i2, long j, long j2, int i4) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.f2617a = str;
        this.f2618b = i;
        this.f2619c = i2;
        this.f2620d = j;
        this.f2621e = j2;
        this.f2622f = i4;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long bytesDownloaded() {
        return this.f2620d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            if (this.f2617a.equals(assetPackState.name()) && this.f2618b == assetPackState.status() && this.f2619c == assetPackState.errorCode() && this.f2620d == assetPackState.bytesDownloaded() && this.f2621e == assetPackState.totalBytesToDownload() && this.f2622f == assetPackState.transferProgressPercentage()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    @AssetPackErrorCode
    public final int errorCode() {
        return this.f2619c;
    }

    public final int hashCode() {
        int iHashCode = this.f2617a.hashCode();
        int i = this.f2618b;
        int i2 = this.f2619c;
        long j = this.f2620d;
        long j2 = this.f2621e;
        return ((((((((((iHashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f2622f;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String name() {
        return this.f2617a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    @AssetPackStatus
    public final int status() {
        return this.f2618b;
    }

    public final String toString() {
        String str = this.f2617a;
        int i = this.f2618b;
        int i2 = this.f2619c;
        long j = this.f2620d;
        long j2 = this.f2621e;
        int i4 = this.f2622f;
        StringBuilder sb = new StringBuilder(str.length() + 185);
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i);
        AbstractC1974b.m1330w(i2, ", errorCode=", ", bytesDownloaded=", sb);
        sb.append(j);
        AbstractC1038a.m1223x(sb, ", totalBytesToDownload=", j2, ", transferProgressPercentage=");
        return AbstractC2821a.m2223n(sb, "}", i4);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long totalBytesToDownload() {
        return this.f2621e;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int transferProgressPercentage() {
        return this.f2622f;
    }
}
