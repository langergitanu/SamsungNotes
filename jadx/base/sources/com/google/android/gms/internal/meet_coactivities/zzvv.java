package com.google.android.gms.internal.meet_coactivities;

import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzvv {
    private zzvy zza;
    private IdentityHashMap zzb;

    public /* synthetic */ zzvv(zzvy zzvyVar, zzvu zzvuVar) {
        this.zza = zzvyVar;
    }

    public final zzvv zza(zzvw zzvwVar) {
        if (this.zza.zzc.containsKey(zzvwVar)) {
            IdentityHashMap identityHashMap = new IdentityHashMap(this.zza.zzc);
            identityHashMap.remove(zzvwVar);
            this.zza = new zzvy(identityHashMap, null);
        }
        IdentityHashMap identityHashMap2 = this.zzb;
        if (identityHashMap2 != null) {
            identityHashMap2.remove(zzvwVar);
        }
        return this;
    }

    public final zzvv zzb(zzvw zzvwVar, Object obj) {
        if (this.zzb == null) {
            this.zzb = new IdentityHashMap(1);
        }
        this.zzb.put(zzvwVar, obj);
        return this;
    }

    public final zzvy zzc() {
        if (this.zzb != null) {
            for (Map.Entry entry : this.zza.zzc.entrySet()) {
                if (!this.zzb.containsKey(entry.getKey())) {
                    this.zzb.put((zzvw) entry.getKey(), entry.getValue());
                }
            }
            this.zza = new zzvy(this.zzb, null);
            this.zzb = null;
        }
        return this.zza;
    }
}
