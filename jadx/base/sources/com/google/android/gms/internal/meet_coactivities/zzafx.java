package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzafx extends zzags {
    final /* synthetic */ zzaga zza;
    private final zzyw zzb;
    private final zzxe zzc = zzxe.zzb();
    private final zzwq[] zzd;

    public /* synthetic */ zzafx(zzaga zzagaVar, zzyw zzywVar, zzwq[] zzwqVarArr, zzafw zzafwVar) {
        this.zza = zzagaVar;
        this.zzb = zzywVar;
        this.zzd = zzwqVarArr;
    }

    public static /* bridge */ /* synthetic */ Runnable zzp(zzafx zzafxVar, zzaev zzaevVar) {
        zzxe zzxeVarZza = zzafxVar.zzc.zza();
        try {
            zzyw zzywVar = zzafxVar.zzb;
            zzaes zzaesVarZzd = zzaevVar.zzd(zzywVar.zzc(), zzywVar.zzb(), zzywVar.zza(), zzafxVar.zzd);
            zzafxVar.zzc.zze(zzxeVarZza);
            return zzafxVar.zzs(zzaesVarZzd);
        } catch (Throwable th) {
            zzafxVar.zzc.zze(zzxeVarZza);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzags, com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zza(zzahy zzahyVar) {
        if (this.zzb.zza().zzo()) {
            zzahyVar.zza("wait_for_ready");
        }
        super.zza(zzahyVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzags, com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzb(zzabd zzabdVar) {
        super.zzb(zzabdVar);
        synchronized (this.zza.zzb) {
            try {
                zzaga zzagaVar = this.zza;
                if (zzagaVar.zzg != null) {
                    boolean zRemove = zzagaVar.zzi.remove(this);
                    if (!this.zza.zzn() && zRemove) {
                        zzaga zzagaVar2 = this.zza;
                        zzagaVar2.zzd.zzc(zzagaVar2.zzf);
                        if (this.zza.zzj.zzb != null) {
                            zzaga zzagaVar3 = this.zza;
                            zzagaVar3.zzd.zzc(zzagaVar3.zzg);
                            this.zza.zzg = null;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.zza.zzd.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzags
    public final void zzq(zzabd zzabdVar) {
        int i = 0;
        while (true) {
            zzwq[] zzwqVarArr = this.zzd;
            if (i >= zzwqVarArr.length) {
                return;
            }
            zzwq zzwqVar = zzwqVarArr[i];
            i++;
        }
    }
}
