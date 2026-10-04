package com.google.android.gms.internal.meet_coactivities;

import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.Executor;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzada extends zzadc {
    private final zzaoh zzc;

    public zzada(IBinder iBinder, Executor executor) {
        super(iBinder);
        this.zzc = new zzaoh(executor);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzadc
    public final void zza(final int i, zzadg zzadgVar) {
        final Parcel parcelZza = zzadgVar.zza();
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzacz
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (this.zza.zzd(i, parcelZza)) {
                        return;
                    }
                    zzadc.zzc.logp(Level.FINEST, "io.grpc.binder.internal.OneWayBinderProxy$InProcessImpl", "lambda$transact$0", "A oneway transaction was not understood - ignoring");
                } catch (Exception e) {
                    zzadc.zzc.logp(Level.FINEST, "io.grpc.binder.internal.OneWayBinderProxy$InProcessImpl", "lambda$transact$0", "A oneway transaction threw - ignoring", (Throwable) e);
                }
            }
        });
        zzadgVar.zzb();
    }
}
