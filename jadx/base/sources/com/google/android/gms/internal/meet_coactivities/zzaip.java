package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaip implements Runnable {
    final /* synthetic */ zzaiq zza;

    public zzaip(zzaiq zzaiqVar) {
        this.zza = zzaiqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaiq zzaiqVar = this.zza;
        zzaiqVar.zzc.zzq.remove(zzaiqVar.zza);
        if (this.zza.zzc.zzu.zza() == zzwz.SHUTDOWN && this.zza.zzc.zzq.isEmpty()) {
            zzais.zzB(this.zza.zzc);
        }
    }
}
