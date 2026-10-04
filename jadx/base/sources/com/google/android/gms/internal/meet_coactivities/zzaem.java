package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaem extends zzafb {
    final /* synthetic */ zzzv zza;
    final /* synthetic */ zzaeq zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaem(zzaeq zzaeqVar, zzapy zzapyVar, zzzv zzzvVar) {
        super(zzaeqVar.zza.zzg);
        this.zza = zzzvVar;
        this.zzb = zzaeqVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzafb
    public final void zza() {
        int i = zzapz.zza;
        zzaeq zzaeqVar = this.zzb;
        if (zzaeqVar.zzc != null) {
            return;
        }
        try {
            zzaeqVar.zzb.zzb(this.zza);
        } catch (Throwable th) {
            zzaeq.zzc(this.zzb, zzabd.zzb.zzd(th).zze("Failed to read headers"));
        }
    }
}
