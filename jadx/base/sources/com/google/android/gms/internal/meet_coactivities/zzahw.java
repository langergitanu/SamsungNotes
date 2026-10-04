package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Set;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Immutable
final class zzahw {
    final int zza;
    final long zzb;
    final Set zzc;

    public zzahw(int i, long j, Set set) {
        this.zza = i;
        this.zzb = j;
        this.zzc = ImmutableSet.copyOf((Collection) set);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahw.class == obj.getClass()) {
            zzahw zzahwVar = (zzahw) obj;
            if (this.zza == zzahwVar.zza && this.zzb == zzahwVar.zzb && Objects.equal(this.zzc, zzahwVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("maxAttempts", this.zza).add("hedgingDelayNanos", this.zzb).add("nonFatalStatusCodes", this.zzc).toString();
    }
}
