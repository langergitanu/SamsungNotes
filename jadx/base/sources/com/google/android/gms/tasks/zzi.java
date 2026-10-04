package com.google.android.gms.tasks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzi implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzj zzb;

    public zzi(zzj zzjVar, Task task) {
        this.zzb = zzjVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zzb) {
            try {
                zzj zzjVar = this.zzb;
                if (zzjVar.zzc != null) {
                    zzjVar.zzc.onComplete(this.zza);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
