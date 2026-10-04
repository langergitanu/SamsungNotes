package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzxn extends zzzk {
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", zzb()).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzk
    public final zzzi zza() {
        return zzb().zza();
    }

    public abstract zzzk zzb();
}
