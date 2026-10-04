package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaeo extends zzafb {
    final /* synthetic */ zzabd zza;
    final /* synthetic */ zzzv zzb;
    final /* synthetic */ zzaeq zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaeo(zzaeq zzaeqVar, zzapy zzapyVar, zzabd zzabdVar, zzzv zzzvVar) {
        super(zzaeqVar.zza.zzg);
        this.zza = zzabdVar;
        this.zzb = zzzvVar;
        this.zzc = zzaeqVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzafb
    public final void zza() {
        int i = zzapz.zza;
        this.zzc.zza.zzh.zzd();
        zzabd zzabdVar = this.zza;
        zzzv zzzvVar = this.zzb;
        zzaeq zzaeqVar = this.zzc;
        if (zzaeqVar.zzc != null) {
            zzabdVar = zzaeqVar.zzc;
            zzzvVar = new zzzv();
        }
        try {
            this.zzc.zzb.zza(zzabdVar, zzzvVar);
        } finally {
            this.zzc.zza.zzf.zza(zzabdVar.zzj());
        }
    }
}
