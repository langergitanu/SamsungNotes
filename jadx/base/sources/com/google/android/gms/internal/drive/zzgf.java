package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "OnStartStreamSessionCreator")
@SafeParcelable.Reserved({1})
public final class zzgf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgf> CREATOR = new zzgg();

    @SafeParcelable.Field(m3227id = 2)
    private final ParcelFileDescriptor zzin;

    @SafeParcelable.Field(m3227id = 3)
    private final IBinder zzio;

    @SafeParcelable.Field(m3227id = 4)
    private final String zzm;

    @SafeParcelable.Constructor
    public zzgf(@SafeParcelable.Param(m3228id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(m3228id = 3) IBinder iBinder, @SafeParcelable.Param(m3228id = 4) String str) {
        this.zzin = parcelFileDescriptor;
        this.zzio = iBinder;
        this.zzm = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzin, i | 1, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzio, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
