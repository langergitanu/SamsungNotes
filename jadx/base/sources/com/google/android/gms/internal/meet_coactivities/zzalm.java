package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzalm extends zzzb {
    private final zzyv zza;

    public zzalm(zzyv zzyvVar) {
        this.zza = (zzyv) Preconditions.checkNotNull(zzyvVar, "result");
    }

    public final String toString() {
        return MoreObjects.toStringHelper((Class<?>) zzalm.class).add("result", this.zza).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzb
    public final zzyv zza(zzyw zzywVar) {
        return this.zza;
    }
}
