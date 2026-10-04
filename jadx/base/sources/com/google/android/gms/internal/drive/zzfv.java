package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "OnListParentsResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfv extends com.google.android.gms.drive.zzu {
    public static final Parcelable.Creator<zzfv> CREATOR = new zzfw();

    @SafeParcelable.Field(m3227id = 2)
    final DataHolder zzij;

    @SafeParcelable.Constructor
    public zzfv(@SafeParcelable.Param(m3228id = 2) DataHolder dataHolder) {
        this.zzij = dataHolder;
    }

    @Override // com.google.android.gms.drive.zzu
    public final void zza(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzij, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final DataHolder zzav() {
        return this.zzij;
    }
}
