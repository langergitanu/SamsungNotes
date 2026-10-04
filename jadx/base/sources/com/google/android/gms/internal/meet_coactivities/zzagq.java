package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzagq implements Runnable {
    final /* synthetic */ zzabd zza;
    final /* synthetic */ zzaet zzb;
    final /* synthetic */ zzzv zzc;
    final /* synthetic */ zzagr zzd;

    public zzagq(zzagr zzagrVar, zzabd zzabdVar, zzaet zzaetVar, zzzv zzzvVar) {
        this.zza = zzabdVar;
        this.zzb = zzaetVar;
        this.zzc = zzzvVar;
        this.zzd = zzagrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zzd(this.zza, this.zzb, this.zzc);
    }
}
