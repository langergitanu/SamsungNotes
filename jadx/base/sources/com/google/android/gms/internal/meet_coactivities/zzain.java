package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzain implements Runnable {
    final /* synthetic */ zzaiq zza;

    public zzain(zzaiq zzaiqVar) {
        this.zza = zzaiqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzc.zzw = null;
        zzaiq zzaiqVar = this.zza;
        zzais zzaisVar = zzaiqVar.zzc;
        if (zzaisVar.zzv != null) {
            Preconditions.checkState(zzaisVar.zzt == null, "Unexpected non-null activeTransport");
            zzaiq zzaiqVar2 = this.zza;
            zzaiqVar2.zza.zzm(zzaiqVar2.zzc.zzv);
        } else {
            zzaey zzaeyVar = zzaiqVar.zza;
            if (zzaisVar.zzs == zzaeyVar) {
                zzaisVar.zzt = zzaeyVar;
                this.zza.zzc.zzs = null;
                zzais.zzA(this.zza.zzc, zzwz.READY);
            }
        }
    }
}
