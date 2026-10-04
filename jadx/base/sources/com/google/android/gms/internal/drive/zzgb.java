package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes5.dex */
public final class zzgb implements Parcelable.Creator<zzga> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzga createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzgo zzgoVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) != 2) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                zzgoVar = (zzgo) SafeParcelReader.createParcelable(parcel, header, zzgo.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzga(zzgoVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzga[] newArray(int i) {
        return new zzga[i];
    }
}
