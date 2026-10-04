package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzanc implements Runnable {
    final /* synthetic */ zzanp zza;
    final /* synthetic */ zzand zzb;

    public zzanc(zzand zzandVar, zzanp zzanpVar) {
        this.zza = zzanpVar;
        this.zzb = zzandVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:4:0x0009, B:19:0x0072, B:7:0x0014, B:9:0x0032, B:11:0x003c, B:16:0x0049, B:18:0x005b), top: B:29:0x0009 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        zzanb zzanbVar;
        boolean z;
        synchronized (this.zzb.zzb.zzm) {
            try {
                zzand zzandVar = this.zzb;
                zzanbVar = null;
                if (zzandVar.zza.zzc) {
                    z = true;
                } else {
                    zzanr zzanrVar = zzandVar.zzb;
                    zzanrVar.zzs = zzanrVar.zzs.zza(this.zza);
                    zzanr zzanrVar2 = this.zzb.zzb;
                    if (zzanrVar2.zzak(zzanrVar2.zzs)) {
                        zzanr zzanrVar3 = this.zzb.zzb;
                        if (zzanrVar3.zzq == null || zzanrVar3.zzq.zza()) {
                            zzanr zzanrVar4 = this.zzb.zzb;
                            zzanbVar = new zzanb(zzanrVar4.zzm);
                            zzanrVar4.zzA = zzanbVar;
                        } else {
                            zzanr zzanrVar5 = this.zzb.zzb;
                            zzanrVar5.zzs = zzanrVar5.zzs.zzb();
                            this.zzb.zzb.zzA = null;
                        }
                        z = false;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            zzanp zzanpVar = this.zza;
            zzanpVar.zza.zzl(new zzano(this.zzb.zzb, zzanpVar));
            this.zza.zza.zzb(zzabd.zzb.zze("Unneeded hedging"));
            return;
        }
        if (zzanbVar != null) {
            zzanr zzanrVar6 = this.zzb.zzb;
            zzanbVar.zzb(zzanrVar6.zzh.schedule(new zzand(zzanrVar6, zzanbVar), zzanrVar6.zzk.zzb, TimeUnit.NANOSECONDS));
        }
        this.zzb.zzb.zzah(this.zza);
    }
}
