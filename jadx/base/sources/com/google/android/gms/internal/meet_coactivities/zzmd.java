package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzmd implements zzll {
    private final zzll zza;
    private final Object zzb;

    private zzmd(zzll zzllVar, Object obj) {
        zzpi.zza(zzllVar, "log site key");
        this.zza = zzllVar;
        zzpi.zza(obj, "log site qualifier");
        this.zzb = obj;
    }

    public static zzll zza(zzll zzllVar, Object obj) {
        return new zzmd(zzllVar, obj);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzmd)) {
            return false;
        }
        zzmd zzmdVar = (zzmd) obj;
        return this.zza.equals(zzmdVar.zza) && this.zzb.equals(zzmdVar.zzb);
    }

    public final int hashCode() {
        Object obj = this.zzb;
        return obj.hashCode() ^ this.zza.hashCode();
    }

    public final String toString() {
        return AbstractC0541b.m775q("SpecializedLogSiteKey{ delegate='", this.zza.toString(), "', qualifier='", this.zzb.toString(), "' }");
    }
}
