package com.google.android.gms.internal.meet_coactivities;

import java.util.Collection;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzamk implements Runnable {
    final /* synthetic */ Collection zza;
    final /* synthetic */ zzanp zzb;
    final /* synthetic */ Future zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ Future zze;
    final /* synthetic */ zzanr zzf;

    public zzamk(zzanr zzanrVar, Collection collection, zzanp zzanpVar, Future future, boolean z, Future future2) {
        this.zza = collection;
        this.zzb = zzanpVar;
        this.zzc = future;
        this.zzd = z;
        this.zze = future2;
        this.zzf = zzanrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (zzanp zzanpVar : this.zza) {
            if (zzanpVar != this.zzb) {
                zzanpVar.zza.zzb(zzanr.zza);
            }
        }
        Future future = this.zzc;
        if (future != null) {
            future.cancel(false);
            if (!this.zzd && this.zzf.zzv.decrementAndGet() == Integer.MIN_VALUE) {
                zzabl zzablVar = (zzabl) this.zzf.zzg;
                zzablVar.zzc(new zzamj(this));
                zzablVar.zzb();
            }
        }
        Future future2 = this.zze;
        if (future2 != null) {
            future2.cancel(false);
        }
        this.zzf.zzq();
    }
}
