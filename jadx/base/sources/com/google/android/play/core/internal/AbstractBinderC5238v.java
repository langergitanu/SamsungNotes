package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.play.core.internal.v */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinderC5238v extends BinderC5226j implements InterfaceC5239w {
    public AbstractBinderC5238v() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionService");
    }

    @Override // com.google.android.play.core.internal.BinderC5226j
    /* JADX INFO: renamed from: a */
    public final boolean mo3868a(int i, Parcel parcel) {
        InterfaceC5241y c5240x = null;
        if (i == 2) {
            Bundle bundle = (Bundle) C5227k.m4011a(parcel, Bundle.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                c5240x = iInterfaceQueryLocalInterface instanceof InterfaceC5241y ? (InterfaceC5241y) iInterfaceQueryLocalInterface : new C5240x(strongBinder);
            }
            mo3678a(bundle, c5240x);
            return true;
        }
        if (i != 3) {
            return false;
        }
        IBinder strongBinder2 = parcel.readStrongBinder();
        if (strongBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
            c5240x = iInterfaceQueryLocalInterface2 instanceof InterfaceC5241y ? (InterfaceC5241y) iInterfaceQueryLocalInterface2 : new C5240x(strongBinder2);
        }
        mo3679a(c5240x);
        return true;
    }
}
