package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class zzxy {
    public final String zza;
    public final zzxw zzb;
    public final long zzc;

    @Nullable
    public final zzym zzd = null;

    @Nullable
    public final zzym zze;

    public /* synthetic */ zzxy(String str, zzxw zzxwVar, long j, zzym zzymVar, zzym zzymVar2, zzxx zzxxVar) {
        this.zza = str;
        this.zzb = (zzxw) Preconditions.checkNotNull(zzxwVar, "severity");
        this.zzc = j;
        this.zze = zzymVar2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzxy) {
            zzxy zzxyVar = (zzxy) obj;
            if (Objects.equal(this.zza, zzxyVar.zza) && Objects.equal(this.zzb, zzxyVar.zzb) && this.zzc == zzxyVar.zzc && Objects.equal(null, null) && Objects.equal(this.zze, zzxyVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Long.valueOf(this.zzc), null, this.zze);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("description", this.zza).add("severity", this.zzb).add("timestampNanos", this.zzc).add("channelRef", (Object) null).add("subchannelRef", this.zze).toString();
    }
}
