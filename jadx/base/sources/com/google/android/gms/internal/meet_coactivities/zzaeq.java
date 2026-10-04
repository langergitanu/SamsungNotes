package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaeq implements zzaeu {
    final /* synthetic */ zzaer zza;
    private final zzwh zzb;
    private zzabd zzc;

    public zzaeq(zzaer zzaerVar, zzwh zzwhVar) {
        this.zza = zzaerVar;
        this.zzb = (zzwh) Preconditions.checkNotNull(zzwhVar, "observer");
    }

    public static /* bridge */ /* synthetic */ void zzc(zzaeq zzaeqVar, zzabd zzabdVar) {
        zzaeqVar.zzc = zzabdVar;
        zzaeqVar.zza.zzk.zzb(zzabdVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaeu
    public final void zzd(zzabd zzabdVar, zzaet zzaetVar, zzzv zzzvVar) {
        int i = zzapz.zza;
        zzxi zzxiVarZzq = this.zza.zzq();
        if (zzabdVar.zza() == zzaay.CANCELLED && zzxiVarZzq != null && zzxiVarZzq.zzd()) {
            zzabdVar = this.zza.zzh.zzb();
            zzzvVar = new zzzv();
        }
        this.zza.zzd.execute(new zzaeo(this, zzapz.zza(), zzabdVar, zzzvVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaeu
    public final void zze(zzzv zzzvVar) {
        this.zza.zzd.execute(new zzaem(this, zzapz.zza(), zzzvVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaou
    public final void zzf(zzaot zzaotVar) {
        this.zza.zzd.execute(new zzaen(this, zzapz.zza(), zzaotVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaou
    public final void zzg() {
        if (this.zza.zzc.zzb().zza()) {
            return;
        }
        this.zza.zzd.execute(new zzaep(this, zzapz.zza()));
    }
}
