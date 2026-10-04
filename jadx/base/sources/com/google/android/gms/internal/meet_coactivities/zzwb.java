package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwb {
    private final String zza;
    private final Object zzb = null;

    private zzwb(String str, Object obj) {
        this.zza = str;
    }

    public static zzwb zza(String str) {
        Preconditions.checkNotNull(str, "debugString");
        return new zzwb(str, null);
    }

    public static /* bridge */ /* synthetic */ Object zzb(zzwb zzwbVar) {
        Object obj = zzwbVar.zzb;
        return null;
    }

    public final String toString() {
        return this.zza;
    }
}
