package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class Rescheduler {
    private boolean enabled;
    private long runAtNanos;
    private final Runnable runnable;
    private final ScheduledExecutorService scheduler;
    private final Executor serializingExecutor;
    private final Stopwatch stopwatch;
    private ScheduledFuture<?> wakeUp;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class ChannelFutureRunnable implements Runnable {
        private ChannelFutureRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!Rescheduler.this.enabled) {
                Rescheduler.this.wakeUp = null;
                return;
            }
            long jNanoTime = Rescheduler.this.nanoTime();
            if (Rescheduler.this.runAtNanos - jNanoTime > 0) {
                Rescheduler rescheduler = Rescheduler.this;
                rescheduler.wakeUp = rescheduler.scheduler.schedule(new FutureRunnable(), Rescheduler.this.runAtNanos - jNanoTime, TimeUnit.NANOSECONDS);
            } else {
                Rescheduler.this.enabled = false;
                Rescheduler.this.wakeUp = null;
                Rescheduler.this.runnable.run();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class FutureRunnable implements Runnable {
        private FutureRunnable() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isEnabled() {
            return Rescheduler.this.enabled;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rescheduler.this.serializingExecutor.execute(new ChannelFutureRunnable());
        }
    }

    public Rescheduler(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, Stopwatch stopwatch) {
        this.runnable = runnable;
        this.serializingExecutor = executor;
        this.scheduler = scheduledExecutorService;
        this.stopwatch = stopwatch;
        stopwatch.start();
    }

    @VisibleForTesting
    public static boolean isEnabled(Runnable runnable) {
        return ((FutureRunnable) runnable).isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long nanoTime() {
        return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }

    public void cancel(boolean z) {
        ScheduledFuture<?> scheduledFuture;
        this.enabled = false;
        if (!z || (scheduledFuture = this.wakeUp) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.wakeUp = null;
    }

    public void reschedule(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        long jNanoTime = nanoTime() + nanos;
        this.enabled = true;
        if (jNanoTime - this.runAtNanos < 0 || this.wakeUp == null) {
            ScheduledFuture<?> scheduledFuture = this.wakeUp;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.wakeUp = this.scheduler.schedule(new FutureRunnable(), nanos, TimeUnit.NANOSECONDS);
        }
        this.runAtNanos = jNanoTime;
    }
}
