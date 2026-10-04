package com.google.android.gms.internal.meet_coactivities;

import androidx.glance.AbstractC2821a;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxa {
    private final zzwz zza;
    private final zzabd zzb;

    private zzxa(zzwz zzwzVar, zzabd zzabdVar) {
        this.zza = (zzwz) Preconditions.checkNotNull(zzwzVar, "state is null");
        this.zzb = (zzabd) Preconditions.checkNotNull(zzabdVar, "status is null");
    }

    public static zzxa zzb(zzwz zzwzVar) {
        Preconditions.checkArgument(zzwzVar != zzwz.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new zzxa(zzwzVar, zzabd.zza);
    }

    public static zzxa zzc(zzabd zzabdVar) {
        Preconditions.checkArgument(!zzabdVar.zzj(), "The error status must not be OK");
        return new zzxa(zzwz.TRANSIENT_FAILURE, zzabdVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzxa)) {
            return false;
        }
        zzxa zzxaVar = (zzxa) obj;
        return this.zza.equals(zzxaVar.zza) && this.zzb.equals(zzxaVar.zzb);
    }

    public final int hashCode() {
        zzabd zzabdVar = this.zzb;
        return zzabdVar.hashCode() ^ this.zza.hashCode();
    }

    public final String toString() {
        if (this.zzb.zzj()) {
            return this.zza.toString();
        }
        return AbstractC2821a.m2221l(String.valueOf(this.zza), "(", String.valueOf(this.zzb), ")");
    }

    public final zzwz zza() {
        return this.zza;
    }

    public final zzabd zzd() {
        return this.zzb;
    }
}
