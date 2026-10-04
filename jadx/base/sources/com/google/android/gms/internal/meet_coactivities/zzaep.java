package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaep extends zzafb {
    final /* synthetic */ zzaeq zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaep(zzaeq zzaeqVar, zzapy zzapyVar) {
        super(zzaeqVar.zza.zzg);
        this.zza = zzaeqVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzafb
    public final void zza() {
        int i = zzapz.zza;
        zzaeq zzaeqVar = this.zza;
        if (zzaeqVar.zzc != null) {
            return;
        }
        try {
            zzaeqVar.zzb.zzd();
        } catch (Throwable th) {
            zzaeq.zzc(this.zza, zzabd.zzb.zzd(th).zze("Failed to call onReady."));
        }
    }
}
