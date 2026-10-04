package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzanj implements Runnable {
    final /* synthetic */ zzanb zza;
    final /* synthetic */ zzanp zzb;
    final /* synthetic */ zzano zzc;

    public zzanj(zzano zzanoVar, zzanb zzanbVar, zzanp zzanpVar) {
        this.zza = zzanbVar;
        this.zzb = zzanpVar;
        this.zzc = zzanoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zza) {
            zzanb zzanbVar = this.zza;
            if (zzanbVar.zzc) {
                return;
            }
            zzanbVar.zza();
            this.zzc.zzb.zzd.execute(new zzani(this));
        }
    }
}
