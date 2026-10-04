package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.play.core.internal.t */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinderC5236t extends BinderC5226j implements InterfaceC5237u {
    public AbstractBinderC5236t() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    @Override // com.google.android.play.core.internal.BinderC5226j
    /* JADX INFO: renamed from: a */
    public final boolean mo3868a(int i, Parcel parcel) {
        switch (i) {
            case 2:
                mo3634a(parcel.readInt(), (Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int i2 = parcel.readInt();
                mo3633a(i2);
                return true;
            case 4:
                int i4 = parcel.readInt();
                mo3639b(i4);
                return true;
            case 5:
                mo3637a(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 6:
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundle = (Bundle) C5227k.m4011a(parcel, creator);
                mo3640b(bundle);
                return true;
            case 7:
                mo3635a((Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
                return true;
            case 8:
                Parcelable.Creator creator2 = Bundle.CREATOR;
                Bundle bundle2 = (Bundle) C5227k.m4011a(parcel, creator2);
                mo3642c(bundle2);
                return true;
            case 9:
            default:
                return false;
            case 10:
                Parcelable.Creator creator3 = Bundle.CREATOR;
                Bundle bundle3 = (Bundle) C5227k.m4011a(parcel, creator3);
                mo3644d(bundle3);
                return true;
            case 11:
                Parcelable.Creator creator4 = Bundle.CREATOR;
                mo3636a((Bundle) C5227k.m4011a(parcel, creator4), (Bundle) C5227k.m4011a(parcel, creator4));
                return true;
            case 12:
                Parcelable.Creator creator5 = Bundle.CREATOR;
                mo3641b((Bundle) C5227k.m4011a(parcel, creator5), (Bundle) C5227k.m4011a(parcel, creator5));
                return true;
            case 13:
                Parcelable.Creator creator6 = Bundle.CREATOR;
                mo3643c((Bundle) C5227k.m4011a(parcel, creator6), (Bundle) C5227k.m4011a(parcel, creator6));
                return true;
            case 14:
                Parcelable.Creator creator7 = Bundle.CREATOR;
                mo3638b();
                return true;
            case 15:
                mo3632a();
                return true;
        }
    }
}
