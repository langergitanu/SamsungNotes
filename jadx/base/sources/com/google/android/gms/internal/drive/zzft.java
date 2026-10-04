package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "OnListEntriesResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzft extends com.google.android.gms.drive.zzu {
    public static final Parcelable.Creator<zzft> CREATOR = new zzfu();

    @SafeParcelable.Field(m3227id = 3)
    final boolean zzea;

    @SafeParcelable.Field(m3227id = 2)
    final DataHolder zzii;

    @SafeParcelable.Constructor
    public zzft(@SafeParcelable.Param(m3228id = 2) DataHolder dataHolder, @SafeParcelable.Param(m3228id = 3) boolean z) {
        this.zzii = dataHolder;
        this.zzea = z;
    }

    @Override // com.google.android.gms.drive.zzu
    public final void zza(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzii, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzea);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final DataHolder zzau() {
        return this.zzii;
    }
}
