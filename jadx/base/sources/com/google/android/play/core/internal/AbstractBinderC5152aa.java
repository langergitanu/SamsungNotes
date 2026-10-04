package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: com.google.android.play.core.internal.aa */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinderC5152aa extends BinderC5226j implements InterfaceC5153ab {
    /* JADX INFO: renamed from: a */
    public static InterfaceC5153ab m3866a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC5153ab ? (InterfaceC5153ab) iInterfaceQueryLocalInterface : new C5242z(iBinder);
    }
}
