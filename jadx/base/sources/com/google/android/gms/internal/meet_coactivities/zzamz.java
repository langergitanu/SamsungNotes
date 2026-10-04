package com.google.android.gms.internal.meet_coactivities;

import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzamz extends zzwq {

    @GuardedBy("lock")
    long zzb;
    final /* synthetic */ zzanr zzc;
    private final zzanp zzd;

    public zzamz(zzanr zzanrVar, zzanp zzanpVar) {
        this.zzc = zzanrVar;
        this.zzd = zzanpVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzabg
    public final void zza(long j) {
        if (this.zzc.zzs.zzf != null) {
            return;
        }
        synchronized (this.zzc.zzm) {
            try {
                if (this.zzc.zzs.zzf == null) {
                    zzanp zzanpVar = this.zzd;
                    if (!zzanpVar.zzb) {
                        long j2 = this.zzb + j;
                        this.zzb = j2;
                        zzanr zzanrVar = this.zzc;
                        if (j2 <= zzanrVar.zzx) {
                            return;
                        }
                        if (j2 > zzanrVar.zzo) {
                            zzanpVar.zzc = true;
                        } else {
                            long jZza = zzanrVar.zzn.zza(j2 - zzanrVar.zzx);
                            this.zzc.zzx = this.zzb;
                            if (jZza > this.zzc.zzp) {
                                this.zzd.zzc = true;
                            }
                        }
                        zzanp zzanpVar2 = this.zzd;
                        Runnable runnableZzaf = zzanpVar2.zzc ? this.zzc.zzaf(zzanpVar2) : null;
                        if (runnableZzaf != null) {
                            runnableZzaf.run();
                        }
                    }
                }
            } finally {
            }
        }
    }
}
