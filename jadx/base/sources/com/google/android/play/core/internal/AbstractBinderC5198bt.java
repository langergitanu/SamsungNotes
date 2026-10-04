package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: com.google.android.play.core.internal.bt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinderC5198bt extends BinderC5226j implements InterfaceC5199bu {
    /* JADX INFO: renamed from: a */
    public static InterfaceC5199bu m3958a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC5199bu ? (InterfaceC5199bu) iInterfaceQueryLocalInterface : new C5197bs(iBinder);
    }
}
