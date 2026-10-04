package com.google.android.gms.internal.meet_coactivities;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzadc {
    protected final IBinder zza;
    private static final Logger zzc = Logger.getLogger(zzadc.class.getName());
    public static final zzacy zzb = new Object() { // from class: com.google.android.gms.internal.meet_coactivities.zzacy
    };

    public zzadc(IBinder iBinder) {
        this.zza = iBinder;
    }

    public static zzadc zzb(IBinder iBinder, Executor executor) {
        return iBinder instanceof Binder ? new zzada(iBinder, executor) : new zzadb(iBinder);
    }

    public abstract void zza(int i, zzadg zzadgVar);

    public final boolean zzd(int i, Parcel parcel) {
        try {
            return this.zza.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
