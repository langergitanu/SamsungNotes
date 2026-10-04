package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Status;
import io.grpc.internal.ClientTransport;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class KeepAliveManager {
    private final boolean keepAliveDuringTransportIdle;
    private final KeepAlivePinger keepAlivePinger;
    private final long keepAliveTimeInNanos;
    private final long keepAliveTimeoutInNanos;

    @GuardedBy("this")
    private ScheduledFuture<?> pingFuture;
    private final ScheduledExecutorService scheduler;
    private final Runnable sendPing;
    private final Runnable shutdown;

    @GuardedBy("this")
    private ScheduledFuture<?> shutdownFuture;

    @GuardedBy("this")
    private State state;

    @GuardedBy("this")
    private final Stopwatch stopwatch;
    private static final long MIN_KEEPALIVE_TIME_NANOS = TimeUnit.SECONDS.toNanos(10);
    private static final long MIN_KEEPALIVE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(10);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ClientKeepAlivePinger implements KeepAlivePinger {
        private final ConnectionClientTransport transport;

        public ClientKeepAlivePinger(ConnectionClientTransport connectionClientTransport) {
            this.transport = connectionClientTransport;
        }

        @Override // io.grpc.internal.KeepAliveManager.KeepAlivePinger
        public void onPingTimeout() {
            this.transport.shutdownNow(Status.UNAVAILABLE.withDescription("Keepalive failed. The connection is likely gone"));
        }

        @Override // io.grpc.internal.KeepAliveManager.KeepAlivePinger
        public void ping() {
            this.transport.ping(new ClientTransport.PingCallback() { // from class: io.grpc.internal.KeepAliveManager.ClientKeepAlivePinger.1
                @Override // io.grpc.internal.ClientTransport.PingCallback
                public void onFailure(Throwable th) {
                    ClientKeepAlivePinger.this.transport.shutdownNow(Status.UNAVAILABLE.withDescription("Keepalive failed. The connection is likely gone"));
                }

                @Override // io.grpc.internal.ClientTransport.PingCallback
                public void onSuccess(long j) {
                }
            }, MoreExecutors.directExecutor());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface KeepAlivePinger {
        void onPingTimeout();

        void ping();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public KeepAliveManager(KeepAlivePinger keepAlivePinger, ScheduledExecutorService scheduledExecutorService, long j, long j2, boolean z) {
        this(keepAlivePinger, scheduledExecutorService, Stopwatch.createUnstarted(), j, j2, z);
    }

    public static long clampKeepAliveTimeInNanos(long j) {
        return Math.max(j, MIN_KEEPALIVE_TIME_NANOS);
    }

    public static long clampKeepAliveTimeoutInNanos(long j) {
        return Math.max(j, MIN_KEEPALIVE_TIMEOUT_NANOS);
    }

    public synchronized void onDataReceived() {
        try {
            this.stopwatch.reset().start();
            State state = this.state;
            State state2 = State.PING_SCHEDULED;
            if (state == state2) {
                this.state = State.PING_DELAYED;
            } else if (state == State.PING_SENT || state == State.IDLE_AND_PING_SENT) {
                ScheduledFuture<?> scheduledFuture = this.shutdownFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                if (this.state == State.IDLE_AND_PING_SENT) {
                    this.state = State.IDLE;
                } else {
                    this.state = state2;
                    Preconditions.checkState(this.pingFuture == null, "There should be no outstanding pingFuture");
                    this.pingFuture = this.scheduler.schedule(this.sendPing, this.keepAliveTimeInNanos, TimeUnit.NANOSECONDS);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void onTransportActive() {
        try {
            State state = this.state;
            if (state == State.IDLE) {
                this.state = State.PING_SCHEDULED;
                if (this.pingFuture == null) {
                    ScheduledExecutorService scheduledExecutorService = this.scheduler;
                    Runnable runnable = this.sendPing;
                    long j = this.keepAliveTimeInNanos;
                    Stopwatch stopwatch = this.stopwatch;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    this.pingFuture = scheduledExecutorService.schedule(runnable, j - stopwatch.elapsed(timeUnit), timeUnit);
                }
            } else if (state == State.IDLE_AND_PING_SENT) {
                this.state = State.PING_SENT;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void onTransportIdle() {
        try {
            if (this.keepAliveDuringTransportIdle) {
                return;
            }
            State state = this.state;
            if (state == State.PING_SCHEDULED || state == State.PING_DELAYED) {
                this.state = State.IDLE;
            }
            if (this.state == State.PING_SENT) {
                this.state = State.IDLE_AND_PING_SENT;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void onTransportStarted() {
        if (this.keepAliveDuringTransportIdle) {
            onTransportActive();
        }
    }

    public synchronized void onTransportTermination() {
        try {
            State state = this.state;
            State state2 = State.DISCONNECTED;
            if (state != state2) {
                this.state = state2;
                ScheduledFuture<?> scheduledFuture = this.shutdownFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledFuture<?> scheduledFuture2 = this.pingFuture;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                    this.pingFuture = null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @VisibleForTesting
    public KeepAliveManager(KeepAlivePinger keepAlivePinger, ScheduledExecutorService scheduledExecutorService, Stopwatch stopwatch, long j, long j2, boolean z) {
        this.state = State.IDLE;
        this.shutdown = new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.KeepAliveManager.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z2;
                synchronized (KeepAliveManager.this) {
                    try {
                        State state = KeepAliveManager.this.state;
                        State state2 = State.DISCONNECTED;
                        if (state != state2) {
                            KeepAliveManager.this.state = state2;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z2) {
                    KeepAliveManager.this.keepAlivePinger.onPingTimeout();
                }
            }
        });
        this.sendPing = new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.KeepAliveManager.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z2;
                synchronized (KeepAliveManager.this) {
                    try {
                        KeepAliveManager.this.pingFuture = null;
                        State state = KeepAliveManager.this.state;
                        State state2 = State.PING_SCHEDULED;
                        if (state == state2) {
                            KeepAliveManager.this.state = State.PING_SENT;
                            KeepAliveManager keepAliveManager = KeepAliveManager.this;
                            keepAliveManager.shutdownFuture = keepAliveManager.scheduler.schedule(KeepAliveManager.this.shutdown, KeepAliveManager.this.keepAliveTimeoutInNanos, TimeUnit.NANOSECONDS);
                            z2 = true;
                        } else {
                            if (KeepAliveManager.this.state == State.PING_DELAYED) {
                                KeepAliveManager keepAliveManager2 = KeepAliveManager.this;
                                ScheduledExecutorService scheduledExecutorService2 = keepAliveManager2.scheduler;
                                Runnable runnable = KeepAliveManager.this.sendPing;
                                long j3 = KeepAliveManager.this.keepAliveTimeInNanos;
                                Stopwatch stopwatch2 = KeepAliveManager.this.stopwatch;
                                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                                keepAliveManager2.pingFuture = scheduledExecutorService2.schedule(runnable, j3 - stopwatch2.elapsed(timeUnit), timeUnit);
                                KeepAliveManager.this.state = state2;
                            }
                            z2 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z2) {
                    KeepAliveManager.this.keepAlivePinger.ping();
                }
            }
        });
        this.keepAlivePinger = (KeepAlivePinger) Preconditions.checkNotNull(keepAlivePinger, "keepAlivePinger");
        this.scheduler = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "scheduler");
        this.stopwatch = (Stopwatch) Preconditions.checkNotNull(stopwatch, NotificationCompat.CATEGORY_STOPWATCH);
        this.keepAliveTimeInNanos = j;
        this.keepAliveTimeoutInNanos = j2;
        this.keepAliveDuringTransportIdle = z;
        stopwatch.reset().start();
    }
}
