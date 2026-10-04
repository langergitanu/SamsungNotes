package com.google.android.gms.internal.meet_coactivities;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzadb extends zzadc {
    public zzadb(IBinder iBinder) {
        super(iBinder);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzadc
    public final void zza(int i, zzadg zzadgVar) throws RemoteException {
        if (!zzd(i, zzadgVar.zzb())) {
            throw new RemoteException(AbstractC0541b.m767i(i, "BinderProxy#transact(", ", FLAG_ONEWAY) returned false"));
        }
    }
}
