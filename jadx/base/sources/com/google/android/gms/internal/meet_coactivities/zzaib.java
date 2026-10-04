package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaib implements Runnable {
    final /* synthetic */ zzais zza;

    public zzaib(zzais zzaisVar) {
        this.zza = zzaisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza.zzu.zza() == zzwz.IDLE) {
            this.zza.zzh.zza(2, "CONNECTING as requested");
            zzais.zzA(this.zza, zzwz.CONNECTING);
            zzais.zzE(this.zza);
        }
    }
}
