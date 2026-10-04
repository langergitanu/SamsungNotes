package com.google.android.gms.internal.meet_coactivities;

import com.google.android.gms.common.data.AbstractC4539a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zztx {
    private final zztw zza;

    private zztx(zzvp zzvpVar, Object obj, zzvp zzvpVar2, Object obj2) {
        this.zza = new zztw(zzvpVar, obj, zzvpVar2, obj2);
    }

    public static int zzb(zztw zztwVar, Object obj, Object obj2) {
        return zzso.zza(zztwVar.zza, 1, obj) + zzso.zza(zztwVar.zzc, 2, obj2);
    }

    public static zztx zzd(zzvp zzvpVar, Object obj, zzvp zzvpVar2, Object obj2) {
        return new zztx(zzvpVar, obj, zzvpVar2, obj2);
    }

    public static void zze(zzsb zzsbVar, zztw zztwVar, Object obj, Object obj2) {
        zzso.zzi(zzsbVar, zztwVar.zza, 1, obj);
        zzso.zzi(zzsbVar, zztwVar.zzc, 2, obj2);
    }

    public final int zza(int i, Object obj, Object obj2) {
        zztw zztwVar = this.zza;
        int iZzz = zzsb.zzz(i << 3);
        int iZzb = zzb(zztwVar, obj, obj2);
        return AbstractC4539a.m3191a(iZzb, iZzb, iZzz);
    }

    public final zztw zzc() {
        return this.zza;
    }
}
