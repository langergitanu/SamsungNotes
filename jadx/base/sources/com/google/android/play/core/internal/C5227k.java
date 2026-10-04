package com.google.android.play.core.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.play.core.internal.k */
/* JADX INFO: loaded from: classes5.dex */
public final class C5227k {
    static {
        C5227k.class.getClassLoader();
    }

    private C5227k() {
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Parcelable> T m4011a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m4012a(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface);
    }

    /* JADX INFO: renamed from: a */
    public static void m4013a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }
}
