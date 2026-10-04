package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes5.dex */
public final class zzgv implements Parcelable.Creator<zzgu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgu createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzei zzeiVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) != 2) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                zzeiVar = (zzei) SafeParcelReader.createParcelable(parcel, header, zzei.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzgu(zzeiVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgu[] newArray(int i) {
        return new zzgu[i];
    }
}
