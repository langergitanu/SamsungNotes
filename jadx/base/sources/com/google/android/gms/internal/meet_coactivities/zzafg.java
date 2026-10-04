package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzafg implements Runnable {
    final /* synthetic */ zzabd zza;
    final /* synthetic */ zzafr zzb;

    public zzafg(zzafr zzafrVar, zzabd zzabdVar) {
        this.zza = zzabdVar;
        this.zzb = zzafrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzabd zzabdVar = this.zza;
        this.zzb.zzg.zza(zzabdVar.zzg(), zzabdVar.zzh());
    }
}
