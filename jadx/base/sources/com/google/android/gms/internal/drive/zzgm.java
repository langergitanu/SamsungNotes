package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "OpenFileIntentSenderRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzgm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgm> CREATOR = new zzgn();

    @SafeParcelable.Field(m3227id = 2)
    private final String zzba;

    @SafeParcelable.Field(m3227id = 3)
    private final String[] zzbb;

    @SafeParcelable.Field(m3227id = 4)
    private final DriveId zzbd;

    @SafeParcelable.Field(m3227id = 5)
    private final FilterHolder zzbe;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzgm(@SafeParcelable.Param(m3228id = 2) String str, @SafeParcelable.Param(m3228id = 3) String[] strArr, @SafeParcelable.Param(m3228id = 4) DriveId driveId, @SafeParcelable.Param(m3228id = 5) FilterHolder filterHolder) {
        this.zzba = str;
        this.zzbb = strArr;
        this.zzbd = driveId;
        this.zzbe = filterHolder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzba, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzbb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzbe, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
