package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes5.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "DriveFileRangeCreator")
@SafeParcelable.Reserved({1})
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    @SafeParcelable.Field(m3227id = 2)
    private final long zzab;

    @SafeParcelable.Field(m3227id = 3)
    private final long zzac;

    @SafeParcelable.Constructor
    public zzh(@SafeParcelable.Param(m3228id = 2) long j, @SafeParcelable.Param(m3228id = 3) long j2) {
        this.zzab = j;
        this.zzac = j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.zzab);
        SafeParcelWriter.writeLong(parcel, 3, this.zzac);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
