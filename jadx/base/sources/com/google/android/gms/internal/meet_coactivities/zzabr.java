package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabr {
    public static final zzabr zza;
    private final int zzb;

    static {
        zzabp zzabpVar = new zzabp(0, null);
        zzabpVar.zzb(true);
        zza = zzabpVar.zzc();
    }

    public /* synthetic */ zzabr(int i, zzabq zzabqVar) {
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzabr.class == obj.getClass() && this.zzb == ((zzabr) obj).zzb;
    }

    public final int hashCode() {
        return this.zzb;
    }

    public final String toString() {
        return AbstractC0541b.m773o("BindServiceFlags{", Integer.toHexString(this.zzb), "}");
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzabp zzb() {
        return new zzabp(this.zzb, null);
    }
}
