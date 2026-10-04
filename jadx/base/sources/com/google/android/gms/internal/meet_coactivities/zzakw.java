package com.google.android.gms.internal.meet_coactivities;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzakw extends zzahl {
    private static final ReferenceQueue zza = new ReferenceQueue();
    private static final ConcurrentMap zzb = new ConcurrentHashMap();
    private static final Logger zzc = Logger.getLogger(zzakw.class.getName());

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzakw(zzzi zzziVar) {
        super(zzziVar);
        ReferenceQueue referenceQueue = zza;
        ConcurrentMap concurrentMap = zzb;
        new zzakv(this, zzziVar, referenceQueue, concurrentMap);
    }
}
