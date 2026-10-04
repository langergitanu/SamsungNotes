package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzamx implements Runnable {
    final /* synthetic */ zzabd zza;
    final /* synthetic */ zzaet zzb;
    final /* synthetic */ zzzv zzc;
    final /* synthetic */ zzanr zzd;

    public zzamx(zzanr zzanrVar, zzabd zzabdVar, zzaet zzaetVar, zzzv zzzvVar) {
        this.zza = zzabdVar;
        this.zzb = zzaetVar;
        this.zzc = zzzvVar;
        this.zzd = zzanrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zzD = true;
        this.zzd.zzy.zzd(this.zza, this.zzb, this.zzc);
    }
}
