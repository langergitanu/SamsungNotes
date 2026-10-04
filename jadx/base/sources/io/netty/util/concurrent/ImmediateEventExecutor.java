package io.netty.util.concurrent;

import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ImmediateEventExecutor extends AbstractEventExecutor {
    private final Future<?> terminationFuture = new FailedFuture(GlobalEventExecutor.INSTANCE, new UnsupportedOperationException());
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ImmediateEventExecutor.class);
    public static final ImmediateEventExecutor INSTANCE = new ImmediateEventExecutor();
    private static final FastThreadLocal<Queue<Runnable>> DELAYED_RUNNABLES = new FastThreadLocal<Queue<Runnable>>() { // from class: io.netty.util.concurrent.ImmediateEventExecutor.1
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Queue<Runnable> initialValue() {
            return new ArrayDeque();
        }
    };
    private static final FastThreadLocal<Boolean> RUNNING = new FastThreadLocal<Boolean>() { // from class: io.netty.util.concurrent.ImmediateEventExecutor.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    private ImmediateEventExecutor() {
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws Throwable {
        Runnable runnablePoll;
        ObjectUtil.checkNotNull(runnable, Contract.COMMAND);
        FastThreadLocal<Boolean> fastThreadLocal = RUNNING;
        if (fastThreadLocal.get().booleanValue()) {
            DELAYED_RUNNABLES.get().add(runnable);
            return;
        }
        fastThreadLocal.set(Boolean.TRUE);
        try {
            runnable.run();
            while (true) {
                if (runnablePoll == null) {
                    break;
                }
            }
        } catch (Throwable th) {
            try {
                logger.info("Throwable caught while executing Runnable {}", runnable, th);
                Queue<Runnable> queue = DELAYED_RUNNABLES.get();
                while (true) {
                    Runnable runnablePoll2 = queue.poll();
                    if (runnablePoll2 == null) {
                        break;
                    }
                    try {
                        runnablePoll2.run();
                    } catch (Throwable th2) {
                        logger.info("Throwable caught while executing Runnable {}", runnablePoll2, th2);
                    }
                }
            } finally {
                Queue<Runnable> queue2 = DELAYED_RUNNABLES.get();
                while (true) {
                    runnablePoll = queue2.poll();
                    if (runnablePoll == null) {
                        RUNNING.set(Boolean.FALSE);
                    }
                    try {
                        runnablePoll.run();
                    } catch (Throwable th3) {
                        logger.info("Throwable caught while executing Runnable {}", runnablePoll, th3);
                    }
                }
            }
        }
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public <V> ProgressivePromise<V> newProgressivePromise() {
        return new ImmediateProgressivePromise(this);
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public <V> Promise<V> newPromise() {
        return new ImmediatePromise(this);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImmediateProgressivePromise<V> extends DefaultProgressivePromise<V> {
        public ImmediateProgressivePromise(EventExecutor eventExecutor) {
            super(eventExecutor);
        }

        @Override // io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImmediatePromise<V> extends DefaultPromise<V> {
        public ImmediatePromise(EventExecutor eventExecutor) {
            super(eventExecutor);
        }

        @Override // io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
        }
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
    }
}
