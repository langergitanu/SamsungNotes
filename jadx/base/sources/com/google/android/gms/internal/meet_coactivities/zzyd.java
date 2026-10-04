package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyd {
    private final zzabd zza;
    private final Object zzb;

    public /* synthetic */ zzyd(zzabd zzabdVar, Object obj, zzwj zzwjVar, zzyc zzycVar) {
        this.zza = (zzabd) Preconditions.checkNotNull(zzabdVar, "status");
        this.zzb = obj;
    }

    public static zzyb zza() {
        return new zzyb(null);
    }

    public final zzabd zzb() {
        return this.zza;
    }

    public final Object zzc() {
        return this.zzb;
    }
}
