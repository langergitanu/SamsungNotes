package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzzf extends zzyr {
    static {
        zzaag.zza(new zzze());
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("policy", zzd()).add("priority", 5).add("available", true).toString();
    }

    public abstract int zzb();

    public zzaag zzc(Map map) {
        throw null;
    }

    public abstract String zzd();

    public abstract boolean zze();
}
