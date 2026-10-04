package com.google.android.gms.internal.meet_coactivities;

import androidx.collection.AbstractC0622a;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaly extends zzyw {
    private final zzwd zza;
    private final zzzv zzb;
    private final zzaab zzc;
    private final zzyu zzd;

    public zzaly(zzaab zzaabVar, zzzv zzzvVar, zzwd zzwdVar, zzyu zzyuVar) {
        this.zzc = (zzaab) Preconditions.checkNotNull(zzaabVar, "method");
        this.zzb = (zzzv) Preconditions.checkNotNull(zzzvVar, Contract.HEADERS);
        this.zza = (zzwd) Preconditions.checkNotNull(zzwdVar, "callOptions");
        this.zzd = (zzyu) Preconditions.checkNotNull(zzyuVar, "pickDetailsConsumer");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaly.class == obj.getClass()) {
            zzaly zzalyVar = (zzaly) obj;
            if (Objects.equal(this.zza, zzalyVar.zza) && Objects.equal(this.zzb, zzalyVar.zzb) && Objects.equal(this.zzc, zzalyVar.zzc) && Objects.equal(this.zzd, zzalyVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public final String toString() {
        zzwd zzwdVar = this.zza;
        zzzv zzzvVar = this.zzb;
        return AbstractC0622a.m1170p(String.valueOf(zzwdVar), "]", AbstractC0000a.m16m("[method=", String.valueOf(this.zzc), " headers=", String.valueOf(zzzvVar), " callOptions="));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyw
    public final zzwd zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyw
    public final zzzv zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyw
    public final zzaab zzc() {
        return this.zzc;
    }
}
