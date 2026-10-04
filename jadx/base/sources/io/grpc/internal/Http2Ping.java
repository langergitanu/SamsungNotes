package io.grpc.internal;

import com.google.common.base.Stopwatch;
import io.grpc.internal.ClientTransport;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Http2Ping {
    private static final Logger log = Logger.getLogger(Http2Ping.class.getName());

    @GuardedBy("this")
    private Map<ClientTransport.PingCallback, Executor> callbacks = new LinkedHashMap();

    @GuardedBy("this")
    private boolean completed;
    private final long data;

    @GuardedBy("this")
    private Throwable failureCause;

    @GuardedBy("this")
    private long roundTripTimeNanos;
    private final Stopwatch stopwatch;

    public Http2Ping(long j, Stopwatch stopwatch) {
        this.data = j;
        this.stopwatch = stopwatch;
    }

    private static Runnable asRunnable(final ClientTransport.PingCallback pingCallback, final long j) {
        return new Runnable() { // from class: io.grpc.internal.Http2Ping.1
            @Override // java.lang.Runnable
            public void run() {
                pingCallback.onSuccess(j);
            }
        };
    }

    private static void doExecute(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            log.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void notifyFailed(ClientTransport.PingCallback pingCallback, Executor executor, Throwable th) {
        doExecute(executor, asRunnable(pingCallback, th));
    }

    public void addCallback(ClientTransport.PingCallback pingCallback, Executor executor) {
        synchronized (this) {
            try {
                if (!this.completed) {
                    this.callbacks.put(pingCallback, executor);
                } else {
                    Throwable th = this.failureCause;
                    doExecute(executor, th != null ? asRunnable(pingCallback, th) : asRunnable(pingCallback, this.roundTripTimeNanos));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean complete() {
        synchronized (this) {
            try {
                if (this.completed) {
                    return false;
                }
                this.completed = true;
                long jElapsed = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
                this.roundTripTimeNanos = jElapsed;
                Map<ClientTransport.PingCallback, Executor> map = this.callbacks;
                this.callbacks = null;
                for (Map.Entry<ClientTransport.PingCallback, Executor> entry : map.entrySet()) {
                    doExecute(entry.getValue(), asRunnable(entry.getKey(), jElapsed));
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void failed(Throwable th) {
        synchronized (this) {
            try {
                if (this.completed) {
                    return;
                }
                this.completed = true;
                this.failureCause = th;
                Map<ClientTransport.PingCallback, Executor> map = this.callbacks;
                this.callbacks = null;
                for (Map.Entry<ClientTransport.PingCallback, Executor> entry : map.entrySet()) {
                    notifyFailed(entry.getKey(), entry.getValue(), th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public long payload() {
        return this.data;
    }

    private static Runnable asRunnable(final ClientTransport.PingCallback pingCallback, final Throwable th) {
        return new Runnable() { // from class: io.grpc.internal.Http2Ping.2
            @Override // java.lang.Runnable
            public void run() {
                pingCallback.onFailure(th);
            }
        };
    }
}
