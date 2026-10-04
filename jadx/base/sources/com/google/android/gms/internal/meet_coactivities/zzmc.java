package com.google.android.gms.internal.meet_coactivities;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzmc extends zzlz {
    private static final zzln zzb = new zzma();
    private static final ThreadLocal zze = new zzmb();
    final AtomicInteger zza = new AtomicInteger();

    public static zzlz zza(zzmr zzmrVar, zzll zzllVar) {
        Integer num = (Integer) zzmrVar.zzc(zzle.zzc);
        if (num == null || num.intValue() <= 0) {
            return null;
        }
        zzmc zzmcVar = (zzmc) zzb.zzb(zzllVar, zzmrVar);
        return (((Random) zze.get()).nextInt(num.intValue()) == 0 ? zzmcVar.zza.incrementAndGet() : zzmcVar.zza.get()) > 0 ? zzmcVar : zzlz.zzc;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlz
    public final void zzb() {
        this.zza.decrementAndGet();
    }
}
