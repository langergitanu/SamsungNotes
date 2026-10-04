package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.play.core.internal.bv */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinderC5200bv extends BinderC5226j implements InterfaceC5201bw {
    public AbstractBinderC5200bv() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    @Override // com.google.android.play.core.internal.BinderC5226j
    /* JADX INFO: renamed from: a */
    public final boolean mo3868a(int i, Parcel parcel) {
        switch (i) {
            case 2:
                mo3967c(parcel.readInt(), (Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int i2 = parcel.readInt();
                mo3960a(i2);
                return true;
            case 4:
                mo3961a(parcel.readInt(), (Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                mo3965b(parcel.readInt(), (Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
                return true;
            case 6:
                mo3970e((Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                mo3963a(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                mo3969d((Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                mo3962a((Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                mo3964b();
                return true;
            case 11:
                mo3959a();
                return true;
            case 12:
                mo3966b((Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                mo3968c((Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
