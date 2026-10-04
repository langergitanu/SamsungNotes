package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.query.Query;

/* JADX INFO: loaded from: classes5.dex */
public final class zzgr implements Parcelable.Creator<zzgq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgq createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Query query = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) != 2) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                query = (Query) SafeParcelReader.createParcelable(parcel, header, Query.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzgq(query);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgq[] newArray(int i) {
        return new zzgq[i];
    }
}
