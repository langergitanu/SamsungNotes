package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdn {
    public static zzdj zza(zzdj zzdjVar) {
        return ((zzdjVar instanceof zzdl) || (zzdjVar instanceof zzdk)) ? zzdjVar : zzdjVar instanceof Serializable ? new zzdk(zzdjVar) : new zzdl(zzdjVar);
    }

    public static zzdj zzb(Object obj) {
        return new zzdm(obj);
    }
}
