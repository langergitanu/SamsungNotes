package com.microsoft.identity.common.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class ParcelableUtil {
    private ParcelableUtil() {
    }

    public static byte[] marshall(@NonNull Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static Parcel unmarshall(@NonNull byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        return parcelObtain;
    }

    public static <T> T unmarshall(@NonNull byte[] bArr, @NonNull Parcelable.Creator<T> creator) {
        Parcel parcelUnmarshall = unmarshall(bArr);
        T tCreateFromParcel = creator.createFromParcel(parcelUnmarshall);
        parcelUnmarshall.recycle();
        return tCreateFromParcel;
    }
}
