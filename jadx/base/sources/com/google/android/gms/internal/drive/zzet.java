package com.google.android.gms.internal.drive;

import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zzet extends zzb implements zzes {
    public zzet() {
        super("com.google.android.gms.drive.internal.IEventCallback");
    }

    @Override // com.google.android.gms.internal.drive.zzb
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zzc((zzfp) zzc.zza(parcel, zzfp.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
