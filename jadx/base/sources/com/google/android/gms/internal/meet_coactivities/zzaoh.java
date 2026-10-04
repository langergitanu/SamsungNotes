package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaoh implements Executor, Runnable {
    private static final Logger zza = Logger.getLogger(zzaoh.class.getName());
    private static final zzaoc zzb;
    private final Executor zzc;
    private final Queue zzd = new ConcurrentLinkedQueue();
    private volatile int zze = 0;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        zzaoc zzaogVar;
        Object[] objArr = 0;
        try {
            zzaogVar = new zzaoe(AtomicIntegerFieldUpdater.newUpdater(zzaoh.class, "zze"), null);
        } catch (Throwable th) {
            zza.logp(Level.SEVERE, "io.grpc.internal.SerializingExecutor", "getAtomicHelper", "FieldUpdaterAtomicHelper failed", th);
            zzaogVar = new zzaog(objArr == true ? 1 : 0);
        }
        zzb = zzaogVar;
    }

    public zzaoh(Executor executor) {
        Preconditions.checkNotNull(executor, "'executor' must not be null.");
        this.zzc = executor;
    }

    private final void zzc(@Nullable Runnable runnable) {
        if (zzb.zzb(this, 0, -1)) {
            try {
                this.zzc.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.zzd.remove(runnable);
                }
                zzb.zza(this, 0);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zzd.add((Runnable) Preconditions.checkNotNull(runnable, "'r' must not be null."));
        zzc(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        try {
            Executor executor = this.zzc;
            while (executor == this.zzc && (runnable = (Runnable) this.zzd.poll()) != null) {
                try {
                    runnable.run();
                } catch (RuntimeException e) {
                    zza.logp(Level.SEVERE, "io.grpc.internal.SerializingExecutor", "run", "Exception while executing runnable " + runnable.toString(), (Throwable) e);
                }
            }
            zzb.zza(this, 0);
            if (this.zzd.isEmpty()) {
                return;
            }
            zzc(null);
        } catch (Throwable th) {
            zzb.zza(this, 0);
            throw th;
        }
    }
}
