package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "OnSyncMoreResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzgh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgh> CREATOR = new zzgi();

    @SafeParcelable.Field(m3227id = 2)
    private final boolean zzea;

    @SafeParcelable.Constructor
    public zzgh(@SafeParcelable.Param(m3228id = 2) boolean z) {
        this.zzea = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzea);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
