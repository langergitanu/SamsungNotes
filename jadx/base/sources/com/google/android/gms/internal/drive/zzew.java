package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public final class zzew extends zza implements zzeu {
    public zzew(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.drive.internal.IEventReleaseCallback");
    }

    @Override // com.google.android.gms.internal.drive.zzeu
    public final void zza(boolean z) {
        Parcel parcelZza = zza();
        zzc.writeBoolean(parcelZza, z);
        zzc(1, parcelZza);
    }
}
