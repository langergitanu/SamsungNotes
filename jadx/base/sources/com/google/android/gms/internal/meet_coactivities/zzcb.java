package com.google.android.gms.internal.meet_coactivities;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
abstract class zzcb {
    static final zzcb zza;

    static {
        zzbs zzbsVar = new zzbs();
        zzbsVar.zzc(zzca.DISCONNECTED);
        zzbsVar.zza(null);
        zzbsVar.zzb(null);
        zza = zzbsVar.zzd();
    }

    public static zzcb zzd(zzc zzcVar) {
        zzbs zzbsVar = new zzbs();
        zzbsVar.zzc(zzca.CONNECTING);
        zzbsVar.zzb(null);
        zzbsVar.zza(zzcVar);
        return zzbsVar.zzd();
    }

    public abstract zzc zza();

    public abstract zzl zzb();

    public abstract zzca zzc();
}
