package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class MaxConnectionIdleManager {
    private static final Ticker systemTicker = new Ticker() { // from class: io.grpc.internal.MaxConnectionIdleManager.1
        @Override // io.grpc.internal.MaxConnectionIdleManager.Ticker
        public long nanoTime() {
            return System.nanoTime();
        }
    };
    private boolean isActive;
    private final long maxConnectionIdleInNanos;
    private long nextIdleMonitorTime;
    private ScheduledExecutorService scheduler;
    private boolean shutdownDelayed;

    @CheckForNull
    private ScheduledFuture<?> shutdownFuture;
    private Runnable shutdownTask;
    private final Ticker ticker;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public interface Ticker {
        long nanoTime();
    }

    public MaxConnectionIdleManager(long j) {
        this(j, systemTicker);
    }

    public void onTransportActive() {
        this.isActive = true;
        this.shutdownDelayed = true;
    }

    public void onTransportIdle() {
        this.isActive = false;
        ScheduledFuture<?> scheduledFuture = this.shutdownFuture;
        if (scheduledFuture == null) {
            return;
        }
        if (!scheduledFuture.isDone()) {
            this.nextIdleMonitorTime = this.ticker.nanoTime() + this.maxConnectionIdleInNanos;
        } else {
            this.shutdownDelayed = false;
            this.shutdownFuture = this.scheduler.schedule(this.shutdownTask, this.maxConnectionIdleInNanos, TimeUnit.NANOSECONDS);
        }
    }

    public void onTransportTermination() {
        ScheduledFuture<?> scheduledFuture = this.shutdownFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.shutdownFuture = null;
        }
    }

    public void start(final Runnable runnable, final ScheduledExecutorService scheduledExecutorService) {
        this.scheduler = scheduledExecutorService;
        this.nextIdleMonitorTime = this.ticker.nanoTime() + this.maxConnectionIdleInNanos;
        LogExceptionRunnable logExceptionRunnable = new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.MaxConnectionIdleManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (!MaxConnectionIdleManager.this.shutdownDelayed) {
                    runnable.run();
                    MaxConnectionIdleManager.this.shutdownFuture = null;
                } else {
                    if (MaxConnectionIdleManager.this.isActive) {
                        return;
                    }
                    MaxConnectionIdleManager maxConnectionIdleManager = MaxConnectionIdleManager.this;
                    maxConnectionIdleManager.shutdownFuture = scheduledExecutorService.schedule(maxConnectionIdleManager.shutdownTask, MaxConnectionIdleManager.this.nextIdleMonitorTime - MaxConnectionIdleManager.this.ticker.nanoTime(), TimeUnit.NANOSECONDS);
                    MaxConnectionIdleManager.this.shutdownDelayed = false;
                }
            }
        });
        this.shutdownTask = logExceptionRunnable;
        this.shutdownFuture = scheduledExecutorService.schedule(logExceptionRunnable, this.maxConnectionIdleInNanos, TimeUnit.NANOSECONDS);
    }

    @VisibleForTesting
    public MaxConnectionIdleManager(long j, Ticker ticker) {
        this.maxConnectionIdleInNanos = j;
        this.ticker = ticker;
    }
}
