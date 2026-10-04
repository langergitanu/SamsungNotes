package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "CloseContentsAndUpdateMetadataRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();

    @SafeParcelable.Field(m3227id = 6)
    private final String zzan;

    @SafeParcelable.Field(m3227id = 5)
    private final boolean zzao;

    @SafeParcelable.Field(defaultValue = "true", m3227id = 10)
    private final boolean zzat;

    @SafeParcelable.Field(m3227id = 2)
    private final DriveId zzdd;

    @SafeParcelable.Field(m3227id = 3)
    private final MetadataBundle zzde;

    @Nullable
    @SafeParcelable.Field(m3227id = 4)
    private final Contents zzdf;

    @SafeParcelable.Field(m3227id = 7)
    private final int zzdg;

    @SafeParcelable.Field(m3227id = 8)
    private final int zzdh;

    @SafeParcelable.Field(m3227id = 9)
    private final boolean zzdi;

    @SafeParcelable.Constructor
    public zzm(@SafeParcelable.Param(m3228id = 2) DriveId driveId, @SafeParcelable.Param(m3228id = 3) MetadataBundle metadataBundle, @SafeParcelable.Param(m3228id = 4) Contents contents, @SafeParcelable.Param(m3228id = 5) boolean z, @SafeParcelable.Param(m3228id = 6) String str, @SafeParcelable.Param(m3228id = 7) int i, @SafeParcelable.Param(m3228id = 8) int i2, @SafeParcelable.Param(m3228id = 9) boolean z2, @SafeParcelable.Param(m3228id = 10) boolean z3) {
        this.zzdd = driveId;
        this.zzde = metadataBundle;
        this.zzdf = contents;
        this.zzao = z;
        this.zzan = str;
        this.zzdg = i;
        this.zzdh = i2;
        this.zzdi = z2;
        this.zzat = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzde, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzao);
        SafeParcelWriter.writeString(parcel, 6, this.zzan, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzdg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzdh);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzdi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzat);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @VisibleForTesting
    public zzm(DriveId driveId, MetadataBundle metadataBundle, int i, boolean z, com.google.android.gms.drive.zzn zznVar) {
        this(driveId, metadataBundle, null, zznVar.zzm(), zznVar.zzl(), zznVar.zzn(), i, z, zznVar.zzp());
    }
}
