package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzkq extends zzlz {
    private static final zzln zza = new zzkp();
    private final AtomicLong zzb = new AtomicLong(2147483647L);

    public static zzlz zza(zzmr zzmrVar, zzll zzllVar) {
        Integer num = (Integer) zzmrVar.zzc(zzle.zzb);
        if (num == null) {
            return null;
        }
        zzkq zzkqVar = (zzkq) zza.zzb(zzllVar, zzmrVar);
        return zzkqVar.zzb.incrementAndGet() >= ((long) num.intValue()) ? zzkqVar : zzlz.zzc;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlz
    public final void zzb() {
        this.zzb.set(0L);
    }
}
