package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaag {
    private final zzabd zza;
    private final Object zzb;

    private zzaag(zzabd zzabdVar) {
        this.zzb = null;
        this.zza = (zzabd) Preconditions.checkNotNull(zzabdVar, "status");
        Preconditions.checkArgument(!zzabdVar.zzj(), "cannot use OK status: %s", zzabdVar);
    }

    public static zzaag zza(Object obj) {
        return new zzaag(obj);
    }

    public static zzaag zzb(zzabd zzabdVar) {
        return new zzaag(zzabdVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaag.class == obj.getClass()) {
            zzaag zzaagVar = (zzaag) obj;
            if (Objects.equal(this.zza, zzaagVar.zza) && Objects.equal(this.zzb, zzaagVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final String toString() {
        return this.zzb != null ? MoreObjects.toStringHelper(this).add(ExternalDataConstants.EmbeddingConfig.KEY, this.zzb).toString() : MoreObjects.toStringHelper(this).add("error", this.zza).toString();
    }

    @Nullable
    public final zzabd zzc() {
        return this.zza;
    }

    @Nullable
    public final Object zzd() {
        return this.zzb;
    }

    private zzaag(Object obj) {
        this.zzb = Preconditions.checkNotNull(obj, ExternalDataConstants.EmbeddingConfig.KEY);
        this.zza = null;
    }
}
