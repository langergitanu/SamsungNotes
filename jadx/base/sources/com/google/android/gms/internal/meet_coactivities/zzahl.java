package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class zzahl extends zzzi {
    private final zzzi zza;

    public zzahl(zzzi zzziVar) {
        this.zza = zzziVar;
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.zza).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwe
    public final zzwi zza(zzaab zzaabVar, zzwd zzwdVar) {
        return this.zza.zza(zzaabVar, zzwdVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwe
    public final String zzb() {
        return this.zza.zzb();
    }
}
