package com.google.android.gms.internal.meet_coactivities;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzvi extends zzvk {
    public zzvi(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final void zzc(Object obj, long j, boolean z) {
        if (zzvl.zzb) {
            zzvl.zzD(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            zzvl.zzE(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final void zzd(Object obj, long j, byte b) {
        if (zzvl.zzb) {
            zzvl.zzD(obj, j, b);
        } else {
            zzvl.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvk
    public final boolean zzg(Object obj, long j) {
        return zzvl.zzb ? zzvl.zzt(obj, j) : zzvl.zzu(obj, j);
    }
}
