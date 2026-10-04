package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
public final class zzli<K, V> {
    public static <K, V> void zza(zzjr zzjrVar, zzlj<K, V> zzljVar, K k, V v) {
        zzkb.zza(zzjrVar, zzljVar.zztu, 1, k);
        zzkb.zza(zzjrVar, zzljVar.zztw, 2, v);
    }

    public static <K, V> int zza(zzlj<K, V> zzljVar, K k, V v) {
        return zzkb.zza(zzljVar.zztu, 1, k) + zzkb.zza(zzljVar.zztw, 2, v);
    }
}
