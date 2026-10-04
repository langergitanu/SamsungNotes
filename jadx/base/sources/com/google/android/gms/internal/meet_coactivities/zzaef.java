package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaef extends zzahk {
    private final zzaey zza;
    private final AtomicInteger zzb = new AtomicInteger(-2147483647);
    private volatile zzabd zzc;

    public zzaef(zzaeg zzaegVar, zzaey zzaeyVar, String str) {
        this.zza = (zzaey) Preconditions.checkNotNull(zzaeyVar, "delegate");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzahk
    public final zzaey zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzahk, com.google.android.gms.internal.meet_coactivities.zzaev
    public final zzaes zzd(zzaab zzaabVar, zzzv zzzvVar, zzwd zzwdVar, zzwq[] zzwqVarArr) {
        return this.zzb.get() >= 0 ? new zzahf(this.zzc, zzaet.PROCESSED, zzwqVarArr) : this.zza.zzd(zzaabVar, zzzvVar, zzwdVar, zzwqVarArr);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzahk, com.google.android.gms.internal.meet_coactivities.zzalc
    public final void zzm(zzabd zzabdVar) {
        Preconditions.checkNotNull(zzabdVar, "status");
        synchronized (this) {
            try {
                if (this.zzb.get() < 0) {
                    this.zzc = zzabdVar;
                    this.zzb.addAndGet(Integer.MAX_VALUE);
                    if (this.zzb.get() != 0) {
                        return;
                    }
                    super.zzm(zzabdVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
