package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzwl extends zzwe {
    private final zzwe zza;
    private final zzwj zzb;

    public /* synthetic */ zzwl(zzwe zzweVar, zzwj zzwjVar, zzwk zzwkVar) {
        this.zza = zzweVar;
        this.zzb = (zzwj) Preconditions.checkNotNull(zzwjVar, "interceptor");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwe
    public final zzwi zza(zzaab zzaabVar, zzwd zzwdVar) {
        return this.zzb.zza(zzaabVar, zzwdVar, this.zza);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwe
    public final String zzb() {
        return this.zza.zzb();
    }
}
