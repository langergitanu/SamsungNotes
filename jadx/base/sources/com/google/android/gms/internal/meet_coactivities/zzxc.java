package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzxc {
    static final zzxd zza;

    static {
        zzxd zzabmVar;
        AtomicReference atomicReference = new AtomicReference();
        try {
            zzabmVar = (zzxd) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(zzxd.class).getConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            atomicReference.set(e);
            zzabmVar = new zzabm();
        } catch (Exception e2) {
            throw new RuntimeException("Storage override failed to initialize", e2);
        }
        zza = zzabmVar;
        Throwable th = (Throwable) atomicReference.get();
        if (th != null) {
            zzxe.zza.logp(Level.FINE, "io.grpc.Context$LazyStorage", "<clinit>", "Storage override doesn't exist. Using default", th);
        }
    }
}
