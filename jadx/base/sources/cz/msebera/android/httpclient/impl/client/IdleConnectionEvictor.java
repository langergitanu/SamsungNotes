package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class IdleConnectionEvictor {
    private final HttpClientConnectionManager connectionManager;
    private volatile Exception exception;
    private final long maxIdleTimeMs;
    private final long sleepTimeMs;
    private final Thread thread;
    private final ThreadFactory threadFactory;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DefaultThreadFactory implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Connection evictor");
            thread.setDaemon(true);
            return thread;
        }
    }

    public IdleConnectionEvictor(final HttpClientConnectionManager httpClientConnectionManager, ThreadFactory threadFactory, long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        this.connectionManager = (HttpClientConnectionManager) Args.notNull(httpClientConnectionManager, "Connection manager");
        threadFactory = threadFactory == null ? new DefaultThreadFactory() : threadFactory;
        this.threadFactory = threadFactory;
        this.sleepTimeMs = timeUnit != null ? timeUnit.toMillis(j) : j;
        this.maxIdleTimeMs = timeUnit2 != null ? timeUnit2.toMillis(j2) : j2;
        this.thread = threadFactory.newThread(new Runnable() { // from class: cz.msebera.android.httpclient.impl.client.IdleConnectionEvictor.1
            @Override // java.lang.Runnable
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(IdleConnectionEvictor.this.sleepTimeMs);
                        httpClientConnectionManager.closeExpiredConnections();
                        if (IdleConnectionEvictor.this.maxIdleTimeMs > 0) {
                            httpClientConnectionManager.closeIdleConnections(IdleConnectionEvictor.this.maxIdleTimeMs, TimeUnit.MILLISECONDS);
                        }
                    } catch (Exception e) {
                        IdleConnectionEvictor.this.exception = e;
                        return;
                    }
                }
            }
        });
    }

    public void awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        Thread thread = this.thread;
        if (timeUnit == null) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        thread.join(timeUnit.toMillis(j));
    }

    public boolean isRunning() {
        return this.thread.isAlive();
    }

    public void shutdown() {
        this.thread.interrupt();
    }

    public void start() {
        this.thread.start();
    }

    public IdleConnectionEvictor(HttpClientConnectionManager httpClientConnectionManager, long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        this(httpClientConnectionManager, null, j, timeUnit, j2, timeUnit2);
    }

    public IdleConnectionEvictor(HttpClientConnectionManager httpClientConnectionManager, long j, TimeUnit timeUnit) {
        this(httpClientConnectionManager, null, j > 0 ? j : 5L, timeUnit != null ? timeUnit : TimeUnit.SECONDS, j, timeUnit);
    }
}
