package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyo {
    private final String zza = "internal:health-check-consumer-listener";

    private zzyo(String str, Object obj) {
    }

    public static zzyo zza(String str) {
        Preconditions.checkNotNull("internal:health-check-consumer-listener", "debugString");
        return new zzyo("internal:health-check-consumer-listener", null);
    }

    public final String toString() {
        return this.zza;
    }
}
