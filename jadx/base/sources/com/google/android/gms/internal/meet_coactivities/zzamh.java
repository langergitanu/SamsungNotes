package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Stopwatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzamh {
    private final ScheduledExecutorService zza;
    private final Executor zzb;
    private final Runnable zzc;
    private final Stopwatch zzd;
    private long zze;
    private boolean zzf;
    private ScheduledFuture zzg;

    public zzamh(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, Stopwatch stopwatch) {
        this.zzc = runnable;
        this.zzb = executor;
        this.zza = scheduledExecutorService;
        this.zzd = stopwatch;
        stopwatch.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzk() {
        return this.zzd.elapsed(TimeUnit.NANOSECONDS);
    }

    public final void zzh(boolean z) {
        ScheduledFuture scheduledFuture;
        this.zzf = false;
        if (!z || (scheduledFuture = this.zzg) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.zzg = null;
    }

    public final void zzi(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        long jZzk = zzk() + nanos;
        this.zzf = true;
        if (jZzk - this.zze < 0 || this.zzg == null) {
            ScheduledFuture scheduledFuture = this.zzg;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.zzg = this.zza.schedule(new zzamg(this, null), nanos, TimeUnit.NANOSECONDS);
        }
        this.zze = jZzk;
    }
}
