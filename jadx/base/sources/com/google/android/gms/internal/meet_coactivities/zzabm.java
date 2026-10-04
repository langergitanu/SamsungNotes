package com.google.android.gms.internal.meet_coactivities;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzabm extends zzxd {
    private static final Logger zzb = Logger.getLogger(zzabm.class.getName());
    static final ThreadLocal zza = new ThreadLocal();

    @Override // com.google.android.gms.internal.meet_coactivities.zzxd
    public final zzxe zza() {
        zzxe zzxeVar = (zzxe) zza.get();
        return zzxeVar == null ? zzxe.zzb : zzxeVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzxd
    public final zzxe zzb(zzxe zzxeVar) {
        zzxe zzxeVarZza = zza();
        zza.set(zzxeVar);
        return zzxeVarZza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzxd
    public final void zzc(zzxe zzxeVar, zzxe zzxeVar2) {
        if (zza() != zzxeVar) {
            zzb.logp(Level.SEVERE, "io.grpc.ThreadLocalContextStorage", "detach", "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (zzxeVar2 != zzxe.zzb) {
            zza.set(zzxeVar2);
        } else {
            zza.set(null);
        }
    }
}
