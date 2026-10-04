package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.collect.ImmutableMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzjf extends zzjp {
    private final ImmutableMap zza;

    public zzjf(ImmutableMap immutableMap) {
        if (immutableMap == null) {
            throw new NullPointerException("Null intentCounterMap");
        }
        this.zza = immutableMap;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzjp) {
            return this.zza.equals(((zzjp) obj).zza());
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public final String toString() {
        return AbstractC0541b.m773o("WatchingStateMetadata{intentCounterMap=", this.zza.toString(), "}");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzjp
    public final ImmutableMap zza() {
        return this.zza;
    }
}
