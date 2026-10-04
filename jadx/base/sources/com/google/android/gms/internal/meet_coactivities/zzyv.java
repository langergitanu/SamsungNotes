package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class zzyv {
    private static final zzyv zza = new zzyv(null, null, zzabd.zza, false);

    @Nullable
    private final zzza zzb;

    @Nullable
    private final zzwn zzc = null;
    private final zzabd zzd;
    private final boolean zze;

    private zzyv(@Nullable zzza zzzaVar, @Nullable zzwn zzwnVar, zzabd zzabdVar, boolean z) {
        this.zzb = zzzaVar;
        this.zzd = (zzabd) Preconditions.checkNotNull(zzabdVar, "status");
        this.zze = z;
    }

    public static zzyv zza(zzabd zzabdVar) {
        Preconditions.checkArgument(!zzabdVar.zzj(), "drop status shouldn't be OK");
        return new zzyv(null, null, zzabdVar, true);
    }

    public static zzyv zzb(zzabd zzabdVar) {
        Preconditions.checkArgument(!zzabdVar.zzj(), "error status shouldn't be OK");
        return new zzyv(null, null, zzabdVar, false);
    }

    public static zzyv zzc() {
        return zza;
    }

    public static zzyv zzd(zzza zzzaVar, @Nullable zzwn zzwnVar) {
        return new zzyv((zzza) Preconditions.checkNotNull(zzzaVar, "subchannel"), null, zzabd.zza, false);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzyv)) {
            return false;
        }
        zzyv zzyvVar = (zzyv) obj;
        return Objects.equal(this.zzb, zzyvVar.zzb) && Objects.equal(this.zzd, zzyvVar.zzd) && Objects.equal(null, null) && this.zze == zzyvVar.zze;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zzd, null, Boolean.valueOf(this.zze));
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("subchannel", this.zzb).add("streamTracerFactory", (Object) null).add("status", this.zzd).add("drop", this.zze).toString();
    }

    @Nullable
    public final zzza zze() {
        return this.zzb;
    }

    public final zzabd zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zze;
    }
}
