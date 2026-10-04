package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzagx implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzagy zzb;

    public zzagx(zzagy zzagyVar, boolean z) {
        this.zza = z;
        this.zzb = zzagyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza) {
            zzahb zzahbVar = this.zzb.zza;
            zzahbVar.zzf = true;
            if (zzahbVar.zzt > 0) {
                zzahbVar.zzv.reset().start();
            }
        }
        this.zzb.zza.zzA = false;
    }
}
