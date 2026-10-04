package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaew {
    private String zza = "unknown-authority";
    private zzvy zzb = zzvy.zza;

    @Nullable
    private String zzc;

    @Nullable
    private zzxu zzd;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaew)) {
            return false;
        }
        zzaew zzaewVar = (zzaew) obj;
        return this.zza.equals(zzaewVar.zza) && this.zzb.equals(zzaewVar.zzb) && Objects.equal(null, null) && Objects.equal(this.zzd, zzaewVar.zzd);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, this.zzd);
    }

    public final zzvy zza() {
        return this.zzb;
    }

    public final zzaew zzb(String str) {
        this.zza = (String) Preconditions.checkNotNull(str, "authority");
        return this;
    }

    public final zzaew zzc(zzvy zzvyVar) {
        Preconditions.checkNotNull(zzvyVar, "eagAttributes");
        this.zzb = zzvyVar;
        return this;
    }

    public final zzaew zzd(@Nullable zzxu zzxuVar) {
        this.zzd = zzxuVar;
        return this;
    }

    public final zzaew zze(@Nullable String str) {
        this.zzc = null;
        return this;
    }

    public final String zzf() {
        return this.zza;
    }
}
