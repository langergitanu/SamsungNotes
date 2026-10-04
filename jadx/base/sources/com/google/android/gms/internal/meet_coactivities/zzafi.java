package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzafi implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzafr zzb;

    public zzafi(zzafr zzafrVar, int i) {
        this.zza = i;
        this.zzb = zzafrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzg.zzc(this.zza);
    }
}
