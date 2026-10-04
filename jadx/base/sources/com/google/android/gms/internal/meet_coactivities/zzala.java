package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzala {

    @Nullable
    private final zzakx zza;
    private final Map zzb;
    private final Map zzc;

    @Nullable
    private final zzanq zzd;

    @Nullable
    private final Object zze;

    @Nullable
    private final Map zzf;

    public zzala(@Nullable zzakx zzakxVar, Map map, Map map2, @Nullable zzanq zzanqVar, @Nullable Object obj, @Nullable Map map3) {
        this.zza = zzakxVar;
        this.zzb = Collections.unmodifiableMap(new HashMap(map));
        this.zzc = Collections.unmodifiableMap(new HashMap(map2));
        this.zzd = zzanqVar;
        this.zze = obj;
        this.zzf = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzala.class == obj.getClass()) {
            zzala zzalaVar = (zzala) obj;
            if (Objects.equal(this.zza, zzalaVar.zza) && Objects.equal(this.zzb, zzalaVar.zzb) && Objects.equal(this.zzc, zzalaVar.zzc) && Objects.equal(this.zzd, zzalaVar.zzd) && Objects.equal(this.zze, zzalaVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("defaultMethodConfig", this.zza).add("serviceMethodMap", this.zzb).add("serviceMap", this.zzc).add("retryThrottling", this.zzd).add("loadBalancingConfig", this.zze).toString();
    }

    @Nullable
    public final zzye zza() {
        if (this.zzc.isEmpty() && this.zzb.isEmpty() && this.zza == null) {
            return null;
        }
        return new zzakz(this, null);
    }

    @Nullable
    public final zzakx zzb(zzaab zzaabVar) {
        zzakx zzakxVar = (zzakx) this.zzb.get(zzaabVar.zzf());
        if (zzakxVar == null) {
            zzakxVar = (zzakx) this.zzc.get(zzaabVar.zzg());
        }
        return zzakxVar == null ? this.zza : zzakxVar;
    }

    @Nullable
    public final zzanq zzc() {
        return this.zzd;
    }

    @VisibleForTesting
    @Nullable
    public final Object zzd() {
        return this.zze;
    }

    @Nullable
    public final Map zze() {
        return this.zzf;
    }
}
