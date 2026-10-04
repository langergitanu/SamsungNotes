package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.play.core.internal.i */
/* JADX INFO: loaded from: classes5.dex */
public class C5225i implements IInterface {

    /* JADX INFO: renamed from: a */
    private final IBinder f2993a;

    /* JADX INFO: renamed from: b */
    private final String f2994b;

    public C5225i(IBinder iBinder, String str) {
        this.f2993a = iBinder;
        this.f2994b = str;
    }

    /* JADX INFO: renamed from: a */
    public final Parcel m4009a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f2994b);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2993a;
    }

    /* JADX INFO: renamed from: a */
    public final void m4010a(int i, Parcel parcel) {
        try {
            this.f2993a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
