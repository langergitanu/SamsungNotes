package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "CreateFileRequestCreator")
@SafeParcelable.Reserved({1, 10})
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzx();

    @SafeParcelable.Field(m3227id = 7)
    private final String zzan;

    @SafeParcelable.Field(m3227id = 4)
    private final Contents zzdf;

    @SafeParcelable.Field(m3227id = 3)
    private final MetadataBundle zzdn;

    @SafeParcelable.Field(m3227id = 5)
    private final Integer zzdo;

    @SafeParcelable.Field(m3227id = 2)
    private final DriveId zzdp;

    @SafeParcelable.Field(m3227id = 6)
    private final boolean zzdq;

    @SafeParcelable.Field(m3227id = 8)
    private final int zzdr;

    @SafeParcelable.Field(m3227id = 9)
    private final int zzds;

    @SafeParcelable.Constructor
    public zzw(@SafeParcelable.Param(m3228id = 2) DriveId driveId, @SafeParcelable.Param(m3228id = 3) MetadataBundle metadataBundle, @SafeParcelable.Param(m3228id = 4) Contents contents, @SafeParcelable.Param(m3228id = 5) int i, @SafeParcelable.Param(m3228id = 6) boolean z, @SafeParcelable.Param(m3228id = 7) String str, @SafeParcelable.Param(m3228id = 8) int i2, @SafeParcelable.Param(m3228id = 9) int i4) {
        if (contents != null && i4 != 0) {
            Preconditions.checkArgument(contents.getRequestId() == i4, "inconsistent contents reference");
        }
        if (i == 0 && contents == null && i4 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.zzdp = (DriveId) Preconditions.checkNotNull(driveId);
        this.zzdn = (MetadataBundle) Preconditions.checkNotNull(metadataBundle);
        this.zzdf = contents;
        this.zzdo = Integer.valueOf(i);
        this.zzan = str;
        this.zzdr = i2;
        this.zzdq = z;
        this.zzds = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdp, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdf, i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, this.zzdo, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzdq);
        SafeParcelWriter.writeString(parcel, 7, this.zzan, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zzdr);
        SafeParcelWriter.writeInt(parcel, 9, this.zzds);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @VisibleForTesting
    public zzw(DriveId driveId, MetadataBundle metadataBundle, int i, int i2, ExecutionOptions executionOptions) {
        this(driveId, metadataBundle, null, i2, executionOptions.zzm(), executionOptions.zzl(), executionOptions.zzn(), i);
    }
}
