package com.google.android.gms.internal.meet_coactivities;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzado {
    public static zzabd zza(int i, Parcel parcel) {
        int i2 = i >> 16;
        int i4 = i & 32;
        zzabd zzabdVarZzb = zzabd.zzb(i2 & 255);
        return i4 != 0 ? zzabdVarZzb.zze(parcel.readString()) : zzabdVarZzb;
    }

    public static void zzb(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(0);
        parcel.writeInt(i);
        parcel.setDataPosition(iDataPosition);
    }

    public static boolean zzc(int i, int i2) {
        return (i & i2) != 0;
    }
}
