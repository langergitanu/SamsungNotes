package com.google.android.gms.internal.meet_coactivities;

import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzwy {
    private static zzwy zza;

    @GuardedBy("this")
    private final List zzb = Collections.EMPTY_LIST;

    public static synchronized zzwy zza() {
        try {
            if (zza == null) {
                zza = new zzwy();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }

    public final synchronized List zzb() {
        return this.zzb;
    }

    public final synchronized boolean zzc() {
        return false;
    }
}
