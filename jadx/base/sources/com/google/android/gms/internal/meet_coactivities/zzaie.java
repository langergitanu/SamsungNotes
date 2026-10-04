package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaie implements Runnable {
    final /* synthetic */ zzabd zza;
    final /* synthetic */ zzais zzb;

    public zzaie(zzais zzaisVar, zzabd zzabdVar) {
        this.zza = zzabdVar;
        this.zzb = zzaisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzwz zzwzVarZza = this.zzb.zzu.zza();
        zzwz zzwzVar = zzwz.SHUTDOWN;
        if (zzwzVarZza == zzwzVar) {
            return;
        }
        this.zzb.zzv = this.zza;
        zzais zzaisVar = this.zzb;
        zzalc zzalcVar = zzaisVar.zzt;
        zzaey zzaeyVar = zzaisVar.zzs;
        zzaisVar.zzt = null;
        this.zzb.zzs = null;
        zzais.zzA(this.zzb, zzwzVar);
        this.zzb.zzk.zzd();
        if (this.zzb.zzq.isEmpty()) {
            zzais.zzB(this.zzb);
        }
        zzais.zzz(this.zzb);
        zzais zzaisVar2 = this.zzb;
        if (zzaisVar2.zzo != null) {
            zzaisVar2.zzo.zza();
            zzais zzaisVar3 = this.zzb;
            zzaisVar3.zzp.zzm(this.zza);
            this.zzb.zzo = null;
            this.zzb.zzp = null;
        }
        if (zzalcVar != null) {
            zzalcVar.zzm(this.zza);
        }
        if (zzaeyVar != null) {
            zzaeyVar.zzm(this.zza);
        }
    }
}
