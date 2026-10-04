package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: com.google.android.play.core.internal.m */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinderC5229m extends BinderC5226j implements InterfaceC5230n {
    /* JADX INFO: renamed from: a */
    public static InterfaceC5230n m4016a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC5230n ? (InterfaceC5230n) iInterfaceQueryLocalInterface : new C5228l(iBinder);
    }
}
