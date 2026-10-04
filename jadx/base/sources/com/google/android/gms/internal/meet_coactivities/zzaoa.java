package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoa implements Executor {
    private static final Logger zza = Logger.getLogger(zzaoa.class.getName());
    private boolean zzb;
    private ArrayDeque zzc;

    private final void zza() {
        while (true) {
            Runnable runnable = (Runnable) this.zzc.poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th) {
                zza.logp(Level.SEVERE, "io.grpc.internal.SerializeReentrantCallsDirectExecutor", "completeQueuedTasks", "Exception while executing runnable ".concat(runnable.toString()), th);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Preconditions.checkNotNull(runnable, "'task' must not be null.");
        if (this.zzb) {
            if (this.zzc == null) {
                this.zzc = new ArrayDeque(4);
            }
            this.zzc.add(runnable);
            return;
        }
        this.zzb = true;
        try {
            runnable.run();
            if (this.zzc != null) {
                zza();
            }
            this.zzb = false;
        } catch (Throwable th) {
            try {
                zza.logp(Level.SEVERE, "io.grpc.internal.SerializeReentrantCallsDirectExecutor", "execute", "Exception while executing runnable ".concat(String.valueOf(runnable)), th);
                if (this.zzc != null) {
                    zza();
                }
                this.zzb = false;
            } catch (Throwable th2) {
                if (this.zzc != null) {
                    zza();
                }
                this.zzb = false;
                throw th2;
            }
        }
    }
}
