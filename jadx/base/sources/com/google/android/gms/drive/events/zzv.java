package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "TransferStateEventCreator")
@SafeParcelable.Reserved({1, 2})
public final class zzv extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();

    @SafeParcelable.Field(m3227id = 3)
    private final List<com.google.android.gms.internal.drive.zzh> zzcu;

    @SafeParcelable.Constructor
    public zzv(@SafeParcelable.Param(m3228id = 3) List<com.google.android.gms.internal.drive.zzh> list) {
        this.zzcu = list;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != zzv.class) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Objects.equal(this.zzcu, ((zzv) obj).zzcu);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 7;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzcu);
    }

    public final String toString() {
        return AbstractC0541b.m773o("TransferStateEvent[", TextUtils.join("','", this.zzcu), "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzcu, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
