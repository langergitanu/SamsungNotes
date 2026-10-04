package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaac {
    private static zzaac zza;

    @VisibleForTesting
    public zzaac() {
        new HashSet();
    }

    public static synchronized zzaac zza() {
        try {
            if (zza == null) {
                zza = new zzaac();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }
}
