package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: com.google.android.play.core.internal.r */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinderC5234r extends BinderC5226j implements InterfaceC5235s {
    /* JADX INFO: renamed from: a */
    public static InterfaceC5235s m4027a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC5235s ? (InterfaceC5235s) iInterfaceQueryLocalInterface : new C5233q(iBinder);
    }
}
