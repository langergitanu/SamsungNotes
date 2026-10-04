package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzafu implements Runnable {
    final /* synthetic */ zzalb zza;

    public zzafu(zzaga zzagaVar, zzalb zzalbVar) {
        this.zza = zzalbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zze();
    }
}
