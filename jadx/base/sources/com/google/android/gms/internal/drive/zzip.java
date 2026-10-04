package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes5.dex */
public final class zzip extends zzb implements zzio {
    public static zzio zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        return iInterfaceQueryLocalInterface instanceof zzio ? (zzio) iInterfaceQueryLocalInterface : new zziq(iBinder);
    }
}
