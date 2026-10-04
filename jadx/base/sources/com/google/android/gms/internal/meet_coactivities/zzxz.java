package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxz {
    private static final zzxz zza;
    private final ConcurrentNavigableMap zzb;
    private final ConcurrentMap zzc;
    private final ConcurrentMap zzd;

    static {
        Logger.getLogger(zzxz.class.getName());
        zza = new zzxz();
    }

    @VisibleForTesting
    public zzxz() {
        new ConcurrentSkipListMap();
        this.zzb = new ConcurrentSkipListMap();
        this.zzc = new ConcurrentHashMap();
        this.zzd = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public static zzxz zza() {
        return zza;
    }

    private static void zzh(Map map, zzyh zzyhVar) {
    }

    private static void zzi(Map map, zzyh zzyhVar) {
    }

    public final void zzb(zzyh zzyhVar) {
        zzh(this.zzd, zzyhVar);
    }

    public final void zzc(zzyh zzyhVar) {
        zzh(this.zzb, zzyhVar);
    }

    public final void zzd(zzyh zzyhVar) {
        zzh(this.zzc, zzyhVar);
    }

    public final void zze(zzyh zzyhVar) {
        zzi(this.zzd, zzyhVar);
    }

    public final void zzf(zzyh zzyhVar) {
        zzi(this.zzb, zzyhVar);
    }

    public final void zzg(zzyh zzyhVar) {
        zzi(this.zzc, zzyhVar);
    }
}
