package com.google.android.gms.internal.meet_coactivities;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyk {
    static {
        Charset.forName("US-ASCII");
        zzzo zzzoVar = zzzv.zza;
    }

    public static int zza(zzzv zzzvVar) {
        return zzzvVar.zza();
    }

    public static zzzq zzb(String str, zzyj zzyjVar) {
        boolean z = false;
        if (!str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        return new zzzt(str, z, zzyjVar, null);
    }

    public static zzzv zzc(int i, Object[] objArr) {
        return new zzzv(i, objArr);
    }

    public static Object[] zzd(zzzv zzzvVar) {
        return zzzvVar.zzg();
    }
}
