package com.google.android.gms.internal.meet_coactivities;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmv {
    private static final zzmz zza = new zzms();
    private static final zzmy zzb = new zzmt();
    private final zzmz zze;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzmy zzf = null;

    public final zzmv zza(zzmy zzmyVar) {
        this.zzf = zzmyVar;
        return this;
    }

    public final zzna zzc() {
        return new zzmx(this, null);
    }

    public final void zzf(zzlt zzltVar) {
        zzpi.zza(zzltVar, "key");
        if (!zzltVar.zzi()) {
            zzmz zzmzVar = zza;
            zzpi.zza(zzltVar, "key");
            this.zzd.remove(zzltVar);
            this.zzc.put(zzltVar, zzmzVar);
            return;
        }
        zzmy zzmyVar = zzb;
        zzpi.zza(zzltVar, "key");
        zzpi.zzc(zzltVar.zzi(), "key must be repeating");
        this.zzc.remove(zzltVar);
        this.zzd.put(zzltVar, zzmyVar);
    }
}
