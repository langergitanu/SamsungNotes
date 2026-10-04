package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public final class zzww {
    public static final /* synthetic */ int zza = 0;
    private static final zzww zzb = new zzww(new zzws(), zzwt.zza);
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    @VisibleForTesting
    public zzww(zzwv... zzwvVarArr) {
        for (int i = 0; i < 2; i++) {
            zzwv zzwvVar = zzwvVarArr[i];
            this.zzc.put(zzwvVar.zza(), zzwvVar);
        }
    }

    public static zzww zza() {
        return zzb;
    }
}
