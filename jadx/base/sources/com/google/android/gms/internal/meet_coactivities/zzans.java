package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Immutable
final class zzans {
    final int zza;
    final long zzb;
    final long zzc;
    final double zzd;

    @Nullable
    final Long zze;
    final Set zzf;

    public zzans(int i, long j, long j2, double d, @Nullable Long l, @Nonnull Set set) {
        this.zza = i;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = d;
        this.zze = l;
        this.zzf = ImmutableSet.copyOf((Collection) set);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzans)) {
            return false;
        }
        zzans zzansVar = (zzans) obj;
        return this.zza == zzansVar.zza && this.zzb == zzansVar.zzb && this.zzc == zzansVar.zzc && Double.compare(this.zzd, zzansVar.zzd) == 0 && Objects.equal(this.zze, zzansVar.zze) && Objects.equal(this.zzf, zzansVar.zzf);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), Double.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("maxAttempts", this.zza).add("initialBackoffNanos", this.zzb).add("maxBackoffNanos", this.zzc).add("backoffMultiplier", this.zzd).add("perAttemptRecvTimeoutNanos", this.zze).add("retryableStatusCodes", this.zzf).toString();
    }
}
