package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public final class zzabl implements Executor {
    private final Thread.UncaughtExceptionHandler zza;
    private final Queue zzb = new ConcurrentLinkedQueue();
    private final AtomicReference zzc = new AtomicReference();

    public zzabl(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zza = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        zzc(runnable);
        zzb();
    }

    public final zzabk zza(Runnable runnable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzabi zzabiVar = new zzabi(runnable);
        return new zzabk(zzabiVar, scheduledExecutorService.schedule(new zzabh(this, zzabiVar, runnable), j, timeUnit), null);
    }

    public final void zzb() {
        do {
            AtomicReference atomicReference = this.zzc;
            Thread threadCurrentThread = Thread.currentThread();
            while (!atomicReference.compareAndSet(null, threadCurrentThread)) {
                if (atomicReference.get() != null && atomicReference.get() != null) {
                    return;
                }
            }
            while (true) {
                try {
                    Runnable runnable = (Runnable) this.zzb.poll();
                    if (runnable == null) {
                        break;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        this.zza.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.zzc.set(null);
                    throw th2;
                }
            }
            this.zzc.set(null);
        } while (!this.zzb.isEmpty());
    }

    public final void zzc(Runnable runnable) {
        this.zzb.add((Runnable) Preconditions.checkNotNull(runnable, "runnable is null"));
    }

    public final void zzd() {
        Preconditions.checkState(Thread.currentThread() == this.zzc.get(), "Not called from the SynchronizationContext");
    }
}
