package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class FastThreadLocalThread extends Thread {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) FastThreadLocalThread.class);
    private final boolean cleanupFastThreadLocals;
    private InternalThreadLocalMap threadLocalMap;

    public FastThreadLocalThread() {
        this.cleanupFastThreadLocals = false;
    }

    public boolean permitBlockingCalls() {
        return false;
    }

    public final void setThreadLocalMap(InternalThreadLocalMap internalThreadLocalMap) {
        if (this != Thread.currentThread()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn(new RuntimeException("It's not thread-safe to set 'threadLocalMap' which doesn't belong to the caller thread"));
            }
        }
        this.threadLocalMap = internalThreadLocalMap;
    }

    public final InternalThreadLocalMap threadLocalMap() {
        if (this != Thread.currentThread()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn(new RuntimeException("It's not thread-safe to get 'threadLocalMap' which doesn't belong to the caller thread"));
            }
        }
        return this.threadLocalMap;
    }

    public boolean willCleanupFastThreadLocals() {
        return this.cleanupFastThreadLocals;
    }

    public static boolean willCleanupFastThreadLocals(Thread thread) {
        return (thread instanceof FastThreadLocalThread) && ((FastThreadLocalThread) thread).willCleanupFastThreadLocals();
    }

    public FastThreadLocalThread(Runnable runnable) {
        super(FastThreadLocalRunnable.wrap(runnable));
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable));
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(String str) {
        super(str);
        this.cleanupFastThreadLocals = false;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
        this.cleanupFastThreadLocals = false;
    }

    public FastThreadLocalThread(Runnable runnable, String str) {
        super(FastThreadLocalRunnable.wrap(runnable), str);
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable), str);
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable), str, j);
        this.cleanupFastThreadLocals = true;
    }
}
