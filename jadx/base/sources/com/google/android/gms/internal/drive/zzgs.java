package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "RemoveEventListenerRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzgs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgs> CREATOR = new zzgt();

    @SafeParcelable.Field(m3227id = 3)
    private final int zzda;

    @Nullable
    @SafeParcelable.Field(m3227id = 4)
    private final com.google.android.gms.drive.events.zzt zzdc;

    @SafeParcelable.Field(m3227id = 2)
    private final DriveId zzk;

    @SafeParcelable.Constructor
    public zzgs(@SafeParcelable.Param(m3228id = 2) DriveId driveId, @SafeParcelable.Param(m3228id = 3) int i, @SafeParcelable.Param(m3228id = 4) com.google.android.gms.drive.events.zzt zztVar) {
        this.zzk = driveId;
        this.zzda = i;
        this.zzdc = zztVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzda);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @VisibleForTesting
    public zzgs(@Nullable DriveId driveId, int i) {
        this(driveId, i, null);
    }
}
