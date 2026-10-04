package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zznu {
    private final zzpe zza;
    private final String zzb;

    public zznu(zzpe zzpeVar, String str) {
        zzpi.zza(zzpeVar, "parser");
        this.zza = zzpeVar;
        zzpi.zza(str, "message");
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zznu) {
            zznu zznuVar = (zznu) obj;
            if (this.zza.equals(zznuVar.zza) && this.zzb.equals(zznuVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return str.hashCode() ^ this.zza.hashCode();
    }

    public final zzpe zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
