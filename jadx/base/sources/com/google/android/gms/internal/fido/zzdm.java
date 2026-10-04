package com.google.android.gms.internal.fido;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdm extends zzdr {
    private final long zza;

    public zzdm(long j) {
        this.zza = j;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzdr zzdrVar = (zzdr) obj;
        if (zza() != zzdrVar.zza()) {
            return zza() - zzdrVar.zza();
        }
        long jAbs = Math.abs(this.zza);
        long jAbs2 = Math.abs(((zzdm) zzdrVar).zza);
        if (jAbs < jAbs2) {
            return -1;
        }
        return jAbs > jAbs2 ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzdm.class == obj.getClass() && this.zza == ((zzdm) obj).zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zza()), Long.valueOf(this.zza)});
    }

    public final String toString() {
        return Long.toString(this.zza);
    }

    @Override // com.google.android.gms.internal.fido.zzdr
    public final int zza() {
        return zzdr.zzd(this.zza >= 0 ? (byte) 0 : (byte) 32);
    }

    public final long zzc() {
        return this.zza;
    }
}
