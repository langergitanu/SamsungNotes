package com.google.android.gms.internal.meet_coactivities;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zztq {
    public static final List zza(Object obj, long j) {
        zztf zztfVar = (zztf) zzvl.zzf(obj, j);
        if (zztfVar.zzc()) {
            return zztfVar;
        }
        int size = zztfVar.size();
        zztf zztfVarZzd = zztfVar.zzd(size == 0 ? 10 : size + size);
        zzvl.zzs(obj, j, zztfVarZzd);
        return zztfVarZzd;
    }
}
