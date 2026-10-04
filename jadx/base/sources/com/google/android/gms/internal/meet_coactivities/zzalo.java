package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzalo extends zzzb {
    final /* synthetic */ zzalq zza;
    private final zzalq zzb;
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    public zzalo(zzalq zzalqVar, zzalq zzalqVar2) {
        this.zza = zzalqVar;
        this.zzb = (zzalq) Preconditions.checkNotNull(zzalqVar2, "pickFirstLeafLoadBalancer");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzb
    public final zzyv zza(zzyw zzywVar) {
        if (this.zzc.compareAndSet(false, true)) {
            zzabl zzablVarZzb = this.zza.zzf.zzb();
            final zzalq zzalqVar = this.zzb;
            Objects.requireNonNull(zzalqVar);
            zzablVarZzb.zzc(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzaln
                @Override // java.lang.Runnable
                public final void run() {
                    zzalqVar.zzd();
                }
            });
            zzablVarZzb.zzb();
        }
        return zzyv.zzc();
    }
}
