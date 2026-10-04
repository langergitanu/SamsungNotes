package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzvg extends zzve {
    @Override // com.google.android.gms.internal.meet_coactivities.zzve
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzsy zzsyVar = (zzsy) obj;
        zzvf zzvfVar = zzsyVar.zzc;
        if (zzvfVar != zzvf.zzc()) {
            return zzvfVar;
        }
        zzvf zzvfVarZzf = zzvf.zzf();
        zzsyVar.zzc = zzvfVarZzf;
        return zzvfVarZzf;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzve
    public final /* synthetic */ Object zzb() {
        return zzvf.zzf();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzve
    public final /* synthetic */ Object zzc(Object obj) {
        ((zzvf) obj).zzh();
        return obj;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzve
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, int i2) {
        ((zzvf) obj).zzj((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzve
    public final /* bridge */ /* synthetic */ void zze(Object obj, int i, long j) {
        ((zzvf) obj).zzj((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzve
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzvf) obj).zzj((i << 3) | 3, obj2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzve
    public final /* bridge */ /* synthetic */ void zzg(Object obj, int i, zzrq zzrqVar) {
        ((zzvf) obj).zzj((i << 3) | 2, zzrqVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzve
    public final /* bridge */ /* synthetic */ void zzh(Object obj, int i, long j) {
        ((zzvf) obj).zzj(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzve
    public final void zzi(Object obj) {
        ((zzsy) obj).zzc.zzh();
    }
}
