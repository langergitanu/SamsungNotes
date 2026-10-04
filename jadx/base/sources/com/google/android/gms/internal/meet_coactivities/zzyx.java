package com.google.android.gms.internal.meet_coactivities;

import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyx {
    private List zza;
    private zzvy zzb = zzvy.zza;

    @Nullable
    private Object zzc;

    public final zzyx zza(List list) {
        this.zza = list;
        return this;
    }

    public final zzyx zzb(zzvy zzvyVar) {
        this.zzb = zzvyVar;
        return this;
    }

    public final zzyx zzc(@Nullable Object obj) {
        this.zzc = obj;
        return this;
    }

    public final zzyz zzd() {
        return new zzyz(this.zza, this.zzb, this.zzc, null);
    }
}
