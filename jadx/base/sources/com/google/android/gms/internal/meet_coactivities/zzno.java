package com.google.android.gms.internal.meet_coactivities;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzno {
    private static final zzno zza = new zzne();

    public /* synthetic */ zzno(zznn zznnVar) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzno zzh(zzmr zzmrVar, zzmr zzmrVar2) {
        int iZza = zzmrVar2.zza();
        if (iZza == 0) {
            return zza;
        }
        return iZza <= 28 ? new zznk(zzmrVar, zzmrVar2, null) : new zznm(zzmrVar, zzmrVar2, 0 == true ? 1 : 0);
    }

    public abstract int zza();

    public abstract Set zzb();

    public abstract void zzc(zzna zznaVar, Object obj);
}
