package com.google.android.play.core.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.play.core.internal.j */
/* JADX INFO: loaded from: classes5.dex */
public class BinderC5226j extends Binder implements IInterface {
    public BinderC5226j(String str) {
        attachInterface(this, str);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3868a(int i, Parcel parcel) {
        throw null;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return mo3868a(i, parcel);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
