package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzly {
    private static final zzln zza = new zzlw();
    private final AtomicBoolean zzb = new AtomicBoolean();
    private final AtomicInteger zzc = new AtomicInteger();

    private zzly() {
    }

    public static int zza(zzlz zzlzVar, zzll zzllVar, zzmr zzmrVar) {
        zzly zzlyVar = (zzly) zza.zzb(zzllVar, zzmrVar);
        int iIncrementAndGet = zzlyVar.zzc.incrementAndGet();
        if (zzlzVar == zzlz.zzc || !zzlyVar.zzb.compareAndSet(false, true)) {
            return -1;
        }
        try {
            zzlzVar.zzb();
            zzlyVar.zzb.set(false);
            zzlyVar.zzc.addAndGet(-iIncrementAndGet);
            return iIncrementAndGet - 1;
        } catch (Throwable th) {
            zzlyVar.zzb.set(false);
            throw th;
        }
    }

    public /* synthetic */ zzly(zzlx zzlxVar) {
    }
}
