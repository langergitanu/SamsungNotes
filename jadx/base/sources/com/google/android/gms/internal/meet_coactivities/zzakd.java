package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzakd extends zzafr {
    final zzxe zza;
    final zzaab zzb;
    final zzwd zzc;
    final /* synthetic */ zzakf zzd;
    private final long zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzakd(zzakf zzakfVar, zzxe zzxeVar, zzaab zzaabVar, zzwd zzwdVar) {
        super(zzakn.zzI(zzakfVar.zza, zzwdVar), zzakfVar.zza.zzq, zzwdVar.zzi());
        this.zzd = zzakfVar;
        this.zza = zzxeVar;
        this.zzb = zzaabVar;
        this.zzc = zzwdVar;
        this.zze = System.nanoTime();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzafr
    public final void zzk() {
        zzakc zzakcVar = new zzakc(this);
        zzabl zzablVar = this.zzd.zza.zzd;
        zzablVar.zzc(zzakcVar);
        zzablVar.zzb();
    }

    public final void zzl() {
        zzxe zzxeVarZza = this.zza.zza();
        try {
            zzwi zzwiVarZzh = this.zzd.zzh(this.zzb, this.zzc.zze(zzwq.zza, Long.valueOf(System.nanoTime() - this.zze)));
            this.zza.zze(zzxeVarZza);
            Runnable runnableZzh = zzh(zzwiVarZzh);
            if (runnableZzh != null) {
                zzakf zzakfVar = this.zzd;
                zzakn.zzI(zzakfVar.zza, this.zzc).execute(new zzakb(this, runnableZzh));
            } else {
                zzakf zzakfVar2 = this.zzd;
                zzakc zzakcVar = new zzakc(this);
                zzabl zzablVar = zzakfVar2.zza.zzd;
                zzablVar.zzc(zzakcVar);
                zzablVar.zzb();
            }
        } catch (Throwable th) {
            this.zza.zze(zzxeVarZza);
            throw th;
        }
    }
}
