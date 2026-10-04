package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapp extends zzapo {
    final /* synthetic */ zzapq zza;

    public zzapp(zzapq zzapqVar) {
        this.zza = zzapqVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzapo, com.google.android.gms.internal.meet_coactivities.zzyt
    public final void zze(zzwz zzwzVar, zzzb zzzbVar) {
        zzapq zzapqVar = this.zza;
        if (zzapqVar.zza.zzi.containsKey(zzapqVar.zzb)) {
            this.zza.zzd = zzwzVar;
            this.zza.zze = zzzbVar;
            zzapq zzapqVar2 = this.zza;
            if (zzapqVar2.zza.zze) {
                return;
            }
            if (zzwzVar == zzwz.IDLE) {
                zzapqVar2.zzc.zzd();
            }
            this.zza.zza.zzk();
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzapo
    public final zzyt zzf() {
        return this.zza.zza.zzj;
    }
}
