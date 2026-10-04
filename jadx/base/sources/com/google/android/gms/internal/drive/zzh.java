package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "TransferProgressDataCreator")
@SafeParcelable.Reserved({1})
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    @SafeParcelable.Field(m3227id = 4)
    final int status;

    @SafeParcelable.Field(m3227id = 2)
    final int zzct;

    @SafeParcelable.Field(m3227id = 5)
    final long zzcw;

    @SafeParcelable.Field(m3227id = 6)
    final long zzcx;

    @SafeParcelable.Field(m3227id = 3)
    final DriveId zzk;

    @SafeParcelable.Constructor
    public zzh(@SafeParcelable.Param(m3228id = 2) int i, @SafeParcelable.Param(m3228id = 3) DriveId driveId, @SafeParcelable.Param(m3228id = 4) int i2, @SafeParcelable.Param(m3228id = 5) long j, @SafeParcelable.Param(m3228id = 6) long j2) {
        this.zzct = i;
        this.zzk = driveId;
        this.status = i2;
        this.zzcw = j;
        this.zzcx = j2;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzh.class) {
            if (obj == this) {
                return true;
            }
            zzh zzhVar = (zzh) obj;
            if (this.zzct == zzhVar.zzct && Objects.equal(this.zzk, zzhVar.zzk) && this.status == zzhVar.status && this.zzcw == zzhVar.zzcw && this.zzcx == zzhVar.zzcx) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzct), this.zzk, Integer.valueOf(this.status), Long.valueOf(this.zzcw), Long.valueOf(this.zzcx));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzct);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.status);
        SafeParcelWriter.writeLong(parcel, 5, this.zzcw);
        SafeParcelWriter.writeLong(parcel, 6, this.zzcx);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
