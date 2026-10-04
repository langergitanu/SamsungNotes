package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.Async;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractEventExecutor extends AbstractExecutorService implements EventExecutor, AutoCloseable {
    static final long DEFAULT_SHUTDOWN_QUIET_PERIOD = 2;
    static final long DEFAULT_SHUTDOWN_TIMEOUT = 15;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractEventExecutor.class);
    private final EventExecutorGroup parent;
    private final Collection<EventExecutor> selfCollection;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public interface LazyRunnable extends Runnable {
    }

    public AbstractEventExecutor() {
        this(null);
    }

    public static void runTask(@Async.Execute Runnable runnable) {
        runnable.run();
    }

    public static void safeExecute(Runnable runnable) {
        try {
            runTask(runnable);
        } catch (Throwable th) {
            logger.warn("A task raised an exception. Task: {}", runnable, th);
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        boolean zIsTerminated;
        if (this == ForkJoinPool.commonPool() || (zIsTerminated = isTerminated())) {
            return;
        }
        shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean inEventLoop() {
        return inEventLoop(Thread.currentThread());
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        return this.selfCollection.iterator();
    }

    public void lazyExecute(Runnable runnable) {
        execute(runnable);
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public <V> Future<V> newFailedFuture(Throwable th) {
        return new FailedFuture(this, th);
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public <V> ProgressivePromise<V> newProgressivePromise() {
        return new DefaultProgressivePromise(this);
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public <V> Promise<V> newPromise() {
        return new DefaultPromise(this);
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public <V> Future<V> newSucceededFuture(V v) {
        return new SucceededFuture(this, v);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new PromiseTask(this, runnable, t);
    }

    public EventExecutorGroup parent() {
        return this.parent;
    }

    @Override // java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public abstract void shutdown();

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully() {
        return shutdownGracefully(2L, 15L, TimeUnit.SECONDS);
    }

    @Override // java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.EMPTY_LIST;
    }

    public AbstractEventExecutor(EventExecutorGroup eventExecutorGroup) {
        this.selfCollection = Collections.singleton(this);
        this.parent = eventExecutorGroup;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new PromiseTask(this, callable);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return (Future) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return (Future) super.submit(runnable, (Object) t);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return (Future) super.submit((Callable) callable);
    }

    public EventExecutor next() {
        return this;
    }
}
