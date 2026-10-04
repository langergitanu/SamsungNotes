package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.HashSet;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ArrayList arrayList = null;
        zzs zzsVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                int i4 = SafeParcelReader.readInt(parcel, header);
                hashSet.add(1);
                i2 = i4;
            } else if (fieldId == 2) {
                ArrayList arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zzu.CREATOR);
                hashSet.add(2);
                arrayList = arrayListCreateTypedList;
            } else if (fieldId == 3) {
                int i5 = SafeParcelReader.readInt(parcel, header);
                hashSet.add(3);
                i = i5;
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                zzs zzsVar2 = (zzs) SafeParcelReader.createParcelable(parcel, header, zzs.CREATOR);
                hashSet.add(4);
                zzsVar = zzsVar2;
            }
        }
        if (parcel.dataPosition() == iValidateObjectHeader) {
            return new zzo(hashSet, i2, arrayList, i, zzsVar);
        }
        throw new SafeParcelReader.ParseException(AbstractC0000a.m11h(iValidateObjectHeader, "Overread allowed size end="), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
