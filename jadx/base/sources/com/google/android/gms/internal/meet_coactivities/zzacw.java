package com.google.android.gms.internal.meet_coactivities;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzacw {
    public static zzzv zza(Parcel parcel, zzvy zzvyVar) {
        int i = parcel.readInt();
        if (i == 0) {
            return new zzzv();
        }
        Object[] objArr = new Object[i + i];
        int i2 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = parcel.readInt();
            int i6 = i2 + 4;
            byte[] bArrZzb = zzb(parcel, i5, i6);
            int i7 = i6 + i5;
            int i8 = i4 + i4;
            objArr[i8] = bArrZzb;
            int i9 = parcel.readInt();
            if (i9 == -1) {
                throw new zzabe(zzabd.zze.zze("Parcelable metadata values not allowed"), null);
            }
            if (i9 < 0) {
                throw new zzabe(zzabd.zzj.zze("Unrecognized metadata sentinel"), null);
            }
            int i10 = i7 + 4;
            byte[] bArrZzb2 = zzb(parcel, i9, i10);
            i2 = i10 + i9;
            objArr[i8 + 1] = bArrZzb2;
        }
        return zzyk.zzc(i, objArr);
    }

    private static byte[] zzb(Parcel parcel, int i, int i2) throws zzabe {
        if (i2 + i > 8192) {
            throw new zzabe(zzabd.zzg.zze("Metadata too large"), null);
        }
        byte[] bArr = new byte[i];
        if (i > 0) {
            parcel.readByteArray(bArr);
        }
        return bArr;
    }
}
