package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzum {
    public static final /* synthetic */ int zza = 0;
    private static final zzum zzb = new zzum();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzur zzc = new zztv();

    private zzum() {
    }

    public static zzum zza() {
        return zzb;
    }

    public final zzuq zzb(Class cls) {
        zztg.zzc(cls, "messageType");
        zzuq zzuqVar = (zzuq) this.zzd.get(cls);
        if (zzuqVar != null) {
            return zzuqVar;
        }
        zzuq zzuqVarZza = this.zzc.zza(cls);
        zztg.zzc(cls, "messageType");
        zzuq zzuqVar2 = (zzuq) this.zzd.putIfAbsent(cls, zzuqVarZza);
        return zzuqVar2 == null ? zzuqVarZza : zzuqVar2;
    }
}
