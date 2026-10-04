package com.google.android.gms.internal.meet_coactivities;

import android.os.Binder;
import android.os.Parcel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzacv extends Binder {
    private static final Logger zza = Logger.getLogger(zzacv.class.getName());

    @Nullable
    private zzacu zzb;

    public zzacv(zzacu zzacuVar) {
        this.zzb = zzacuVar;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzacu zzacuVar = this.zzb;
        if (zzacuVar != null) {
            try {
                if ((i2 & 1) != 0) {
                    return zzacuVar.zzu(i, parcel);
                }
                zza.logp(Level.WARNING, "io.grpc.binder.internal.LeakSafeOneWayBinder", "onTransact", "ignoring non-oneway transaction. flags=" + i2);
                return false;
            } catch (RuntimeException e) {
                zza.logp(Level.WARNING, "io.grpc.binder.internal.LeakSafeOneWayBinder", "onTransact", AbstractC0000a.m11h(i, "failure sending transaction "), (Throwable) e);
            }
        }
        return false;
    }

    @Override // android.os.Binder, android.os.IBinder
    public final boolean pingBinder() {
        return this.zzb != null;
    }

    public final void zza() {
        this.zzb = null;
    }
}
