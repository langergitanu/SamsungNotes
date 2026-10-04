package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaom implements Runnable {
    final /* synthetic */ zzaon zza;
    final /* synthetic */ zzaoo zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ zzaop zzd;

    public zzaom(zzaop zzaopVar, zzaon zzaonVar, zzaoo zzaooVar, Object obj) {
        this.zza = zzaonVar;
        this.zzb = zzaooVar;
        this.zzc = obj;
        this.zzd = zzaopVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzd) {
            try {
                if (this.zza.zzb == 0) {
                    try {
                        this.zzb.zzb(this.zzc);
                        this.zzd.zzb.remove(this.zzb);
                        if (this.zzd.zzb.isEmpty()) {
                            this.zzd.zzc.shutdown();
                            this.zzd.zzc = null;
                        }
                    } catch (Throwable th) {
                        this.zzd.zzb.remove(this.zzb);
                        if (this.zzd.zzb.isEmpty()) {
                            this.zzd.zzc.shutdown();
                            this.zzd.zzc = null;
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
