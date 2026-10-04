package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "OnDownloadProgressResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfl extends AbstractSafeParcelable {

    @SafeParcelable.Field(m3227id = 4)
    private final int status;

    @SafeParcelable.Field(m3227id = 2)
    final long zzhy;

    @SafeParcelable.Field(m3227id = 3)
    final long zzhz;

    @Nullable
    @SafeParcelable.Field(m3227id = 5)
    private final List<com.google.android.gms.drive.zzh> zzia;
    private static final List<com.google.android.gms.drive.zzh> zzhx = Collections.EMPTY_LIST;
    public static final Parcelable.Creator<zzfl> CREATOR = new zzfm();

    @SafeParcelable.Constructor
    public zzfl(@SafeParcelable.Param(m3228id = 2) long j, @SafeParcelable.Param(m3228id = 3) long j2, @SafeParcelable.Param(m3228id = 4) int i, @SafeParcelable.Param(m3228id = 5) List<com.google.android.gms.drive.zzh> list) {
        this.zzhy = j;
        this.zzhz = j2;
        this.status = i;
        this.zzia = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.zzhy);
        SafeParcelWriter.writeLong(parcel, 3, this.zzhz);
        SafeParcelWriter.writeInt(parcel, 4, this.status);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zzia, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
