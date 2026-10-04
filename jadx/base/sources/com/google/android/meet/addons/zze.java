package com.google.android.meet.addons;

import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zze extends AddonExceptionMetadata {
    private final String zza;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AddonExceptionMetadata) {
            return this.zza.equals(((AddonExceptionMetadata) obj).packageName());
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    @Override // com.google.android.meet.addons.AddonExceptionMetadata
    public final String packageName() {
        return this.zza;
    }

    public final String toString() {
        return AbstractC0622a.m1170p(this.zza, "}", new StringBuilder("AddonExceptionMetadata{packageName="));
    }
}
