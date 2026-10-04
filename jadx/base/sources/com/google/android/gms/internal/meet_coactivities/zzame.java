package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzame implements Runnable {
    final /* synthetic */ zzamh zza;

    public /* synthetic */ zzame(zzamh zzamhVar, zzamd zzamdVar) {
        this.zza = zzamhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzamh zzamhVar = this.zza;
        zzamf zzamfVar = null;
        if (!zzamhVar.zzf) {
            zzamhVar.zzg = null;
            return;
        }
        long jZzk = zzamhVar.zzk();
        if (zzamhVar.zze - jZzk > 0) {
            zzamh zzamhVar2 = this.zza;
            zzamhVar2.zzg = zzamhVar2.zza.schedule(new zzamg(zzamhVar2, zzamfVar), zzamhVar2.zze - jZzk, TimeUnit.NANOSECONDS);
        } else {
            this.zza.zzf = false;
            this.zza.zzg = null;
            this.zza.zzc.run();
        }
    }
}
