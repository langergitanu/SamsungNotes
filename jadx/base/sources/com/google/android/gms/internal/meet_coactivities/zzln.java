package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzln {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();

    public abstract Object zza();

    public final Object zzb(zzll zzllVar, zzmr zzmrVar) {
        Object obj = this.zza.get(zzllVar);
        if (obj != null) {
            return obj;
        }
        Object objZza = zza();
        Object objPutIfAbsent = this.zza.putIfAbsent(zzllVar, objZza);
        if (objPutIfAbsent != null) {
            return objPutIfAbsent;
        }
        int iZza = zzmrVar.zza();
        zzlm zzlmVar = null;
        for (int i = 0; i < iZza; i++) {
            if (zzle.zzf.equals(zzmrVar.zzb(i))) {
                Object objZzd = zzmrVar.zzd(i);
                if (objZzd instanceof zzlr) {
                    if (zzlmVar == null) {
                        zzlmVar = new zzlm(this, zzllVar);
                    }
                    ((zzlr) objZzd).zza();
                }
            }
        }
        return objZza;
    }
}
