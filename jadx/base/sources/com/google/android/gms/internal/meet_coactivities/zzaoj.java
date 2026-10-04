package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaoj {
    final zzzf zza;

    @Nullable
    final Object zzb;

    public zzaoj(zzzf zzzfVar, @Nullable Object obj) {
        this.zza = (zzzf) Preconditions.checkNotNull(zzzfVar, "provider");
        this.zzb = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaoj.class == obj.getClass()) {
            zzaoj zzaojVar = (zzaoj) obj;
            if (Objects.equal(this.zza, zzaojVar.zza) && Objects.equal(this.zzb, zzaojVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("provider", this.zza).add(ExternalDataConstants.EmbeddingConfig.KEY, this.zzb).toString();
    }
}
