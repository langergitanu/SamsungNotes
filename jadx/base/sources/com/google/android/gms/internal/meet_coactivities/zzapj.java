package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzapj extends zzapi {
    private final zzapn zza;
    private final zzapg zzb;
    private boolean zzc;

    public zzapj(zzapn zzapnVar, zzapg zzapgVar) {
        super(null);
        this.zza = zzapnVar;
        this.zzb = zzapgVar;
        if (zzapnVar instanceof zzapm) {
            ((zzapm) zzapnVar).zzd();
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwh
    public final void zza(zzabd zzabdVar, zzzv zzzvVar) {
        if (zzabdVar.zzj()) {
            this.zza.zza();
        } else {
            this.zza.zzb(new zzabf(zzabdVar, zzzvVar));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwh
    public final void zzc(Object obj) {
        if (this.zzc && !this.zzb.zzb) {
            throw new zzabf(zzabd.zzj.zze("More than one responses received for unary or client-streaming call"), null);
        }
        this.zzc = true;
        this.zza.zzc(obj);
        zzapg zzapgVar = this.zzb;
        if (zzapgVar.zzb) {
            zzapgVar.zzd(1);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzapi
    public final void zze() {
        this.zzb.zzd(1);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwh
    public final void zzd() {
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwh
    public final void zzb(zzzv zzzvVar) {
    }
}
