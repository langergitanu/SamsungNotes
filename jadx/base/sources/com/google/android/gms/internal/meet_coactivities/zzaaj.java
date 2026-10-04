package com.google.android.gms.internal.meet_coactivities;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaaj {
    private List zza = Collections.EMPTY_LIST;
    private zzvy zzb = zzvy.zza;

    @Nullable
    private zzaag zzc;

    public final zzaaj zza(List list) {
        this.zza = list;
        return this;
    }

    public final zzaaj zzb(zzvy zzvyVar) {
        this.zzb = zzvyVar;
        return this;
    }

    public final zzaaj zzc(@Nullable zzaag zzaagVar) {
        this.zzc = zzaagVar;
        return this;
    }

    public final zzaak zzd() {
        return new zzaak(this.zza, this.zzb, this.zzc);
    }
}
