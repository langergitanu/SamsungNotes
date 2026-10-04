package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwp {
    private final zzwd zza;
    private final int zzb;
    private final boolean zzc;

    public zzwp(zzwd zzwdVar, int i, boolean z) {
        this.zza = (zzwd) Preconditions.checkNotNull(zzwdVar, "callOptions");
        this.zzb = i;
        this.zzc = z;
    }

    public static zzwo zza() {
        return new zzwo();
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("callOptions", this.zza).add("previousAttempts", this.zzb).add("isTransparentRetry", this.zzc).toString();
    }
}
