package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwo {
    private zzwd zza = zzwd.zza;
    private int zzb;
    private boolean zzc;

    public final zzwo zza(zzwd zzwdVar) {
        this.zza = (zzwd) Preconditions.checkNotNull(zzwdVar, "callOptions cannot be null");
        return this;
    }

    public final zzwo zzb(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzwo zzc(int i) {
        this.zzb = i;
        return this;
    }

    public final zzwp zzd() {
        return new zzwp(this.zza, this.zzb, this.zzc);
    }
}
