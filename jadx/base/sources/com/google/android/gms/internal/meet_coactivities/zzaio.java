package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaio implements Runnable {
    final /* synthetic */ zzabd zza;
    final /* synthetic */ zzaiq zzb;

    public zzaio(zzaiq zzaiqVar, zzabd zzabdVar) {
        this.zza = zzabdVar;
        this.zzb = zzaiqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb.zzc.zzu.zza() == zzwz.SHUTDOWN) {
            return;
        }
        zzaiq zzaiqVar = this.zzb;
        if (zzaiqVar.zzc.zzt == zzaiqVar.zza) {
            this.zzb.zzc.zzt = null;
            this.zzb.zzc.zzk.zzd();
            zzais.zzA(this.zzb.zzc, zzwz.IDLE);
            return;
        }
        zzaiq zzaiqVar2 = this.zzb;
        zzais zzaisVar = zzaiqVar2.zzc;
        if (zzaisVar.zzs == zzaiqVar2.zza) {
            Preconditions.checkState(zzaisVar.zzu.zza() == zzwz.CONNECTING, "Expected state is CONNECTING, actual state is %s", this.zzb.zzc.zzu.zza());
            this.zzb.zzc.zzk.zzc();
            if (this.zzb.zzc.zzk.zzg()) {
                zzais.zzE(this.zzb.zzc);
                return;
            }
            this.zzb.zzc.zzs = null;
            this.zzb.zzc.zzk.zzd();
            zzais.zzD(this.zzb.zzc, this.zza);
        }
    }
}
