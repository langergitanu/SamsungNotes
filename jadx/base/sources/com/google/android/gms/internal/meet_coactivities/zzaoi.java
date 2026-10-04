package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaoi {
    private final String zza;
    private final Map zzb;

    public zzaoi(String str, Map map) {
        this.zza = (String) Preconditions.checkNotNull(str, "policyName");
        this.zzb = (Map) Preconditions.checkNotNull(map, "rawConfigValue");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaoi) {
            zzaoi zzaoiVar = (zzaoi) obj;
            if (this.zza.equals(zzaoiVar.zza) && this.zzb.equals(zzaoiVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("policyName", this.zza).add("rawConfigValue", this.zzb).toString();
    }

    public final String zza() {
        return this.zza;
    }

    public final Map zzb() {
        return this.zzb;
    }
}
