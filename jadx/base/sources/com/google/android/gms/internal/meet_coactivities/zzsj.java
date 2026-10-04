package com.google.android.gms.internal.meet_coactivities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsj {
    static final zzsj zza = new zzsj(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    public zzsj() {
        this.zzd = new HashMap();
    }

    public static zzsj zza() {
        int i = zzum.zza;
        return zza;
    }

    public final zzsw zzb(zzue zzueVar, int i) {
        return (zzsw) this.zzd.get(new zzsi(zzueVar, i));
    }

    public zzsj(boolean z) {
        this.zzd = Collections.EMPTY_MAP;
    }
}
