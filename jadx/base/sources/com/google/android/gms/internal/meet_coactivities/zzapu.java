package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
final class zzapu extends zzzb {
    private final List zza;
    private final AtomicInteger zzb;
    private final int zzc;

    public zzapu(List list, AtomicInteger atomicInteger) {
        Preconditions.checkArgument(!list.isEmpty(), "empty list");
        this.zza = list;
        this.zzb = (AtomicInteger) Preconditions.checkNotNull(atomicInteger, "index");
        Iterator it = list.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((zzzb) it.next()).hashCode();
        }
        this.zzc = iHashCode;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzapu)) {
            return false;
        }
        zzapu zzapuVar = (zzapu) obj;
        if (zzapuVar == this) {
            return true;
        }
        return this.zzc == zzapuVar.zzc && this.zzb == zzapuVar.zzb && this.zza.size() == zzapuVar.zza.size() && new HashSet(this.zza).containsAll(zzapuVar.zza);
    }

    public final int hashCode() {
        return this.zzc;
    }

    public final String toString() {
        return MoreObjects.toStringHelper((Class<?>) zzapu.class).add("subchannelPickers", this.zza).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzb
    public final zzyv zza(zzyw zzywVar) {
        return ((zzzb) this.zza.get((this.zzb.getAndIncrement() & Integer.MAX_VALUE) % this.zza.size())).zza(zzywVar);
    }
}
