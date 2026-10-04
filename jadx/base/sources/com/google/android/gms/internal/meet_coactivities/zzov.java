package com.google.android.gms.internal.meet_coactivities;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzov {
    private static final Comparator zza = new zzoo();
    private static final zzov zzb = new zzov(new zzot(Collections.EMPTY_LIST));
    private final zzot zzc;

    private zzov(zzot zzotVar) {
        this.zzc = zzotVar;
    }

    public static zzov zza() {
        return zzb;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzov) && ((zzov) obj).zzc.equals(this.zzc);
    }

    public final int hashCode() {
        return ~this.zzc.hashCode();
    }

    public final String toString() {
        return this.zzc.toString();
    }

    public final zzov zzb(zzov zzovVar) {
        return !zzovVar.zzc.isEmpty() ? this.zzc.isEmpty() ? zzovVar : new zzov(new zzot(this.zzc, zzovVar.zzc)) : this;
    }

    public final Map zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zzc.isEmpty();
    }
}
