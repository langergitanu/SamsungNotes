package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzafo implements Runnable {
    final /* synthetic */ zzabd zza;
    final /* synthetic */ zzzv zzb;
    final /* synthetic */ zzafq zzc;

    public zzafo(zzafq zzafqVar, zzabd zzabdVar, zzzv zzzvVar) {
        this.zza = zzabdVar;
        this.zzb = zzzvVar;
        this.zzc = zzafqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
