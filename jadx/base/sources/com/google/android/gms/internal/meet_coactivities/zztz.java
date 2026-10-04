package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zztz {
    public static final boolean zza(Object obj) {
        return !((zzty) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzty zztyVarZzb = (zzty) obj;
        zzty zztyVar = (zzty) obj2;
        if (!zztyVar.isEmpty()) {
            if (!zztyVarZzb.zze()) {
                zztyVarZzb = zztyVarZzb.zzb();
            }
            zztyVarZzb.zzd(zztyVar);
        }
        return zztyVarZzb;
    }
}
