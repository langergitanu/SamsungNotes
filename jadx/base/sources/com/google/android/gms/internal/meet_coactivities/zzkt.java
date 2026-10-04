package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzkt extends zzlz {
    private static final zzln zza = new zzkr();
    private final AtomicLong zzb = new AtomicLong(-1);

    public static zzlz zza(zzmr zzmrVar, zzll zzllVar, long j) {
        if (((zzks) zzmrVar.zzc(zzle.zzd)) == null) {
            return null;
        }
        zzkt zzktVar = (zzkt) zza.zzb(zzllVar, zzmrVar);
        zzpi.zzc(j >= 0, "timestamp cannot be negative");
        long j2 = zzktVar.zzb.get();
        if (j2 >= 0) {
            throw null;
        }
        zzktVar.zzb.compareAndSet(j2, -j);
        return zzktVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlz
    public final void zzb() {
        this.zzb.set(Math.max(-this.zzb.get(), 0L));
    }
}
