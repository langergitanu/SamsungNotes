package io.netty.util.internal;

import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ThreadExecutorMap {
    private static final FastThreadLocal<EventExecutor> mappings = new FastThreadLocal<>();

    private ThreadExecutorMap() {
    }

    public static Executor apply(final Executor executor, final EventExecutor eventExecutor) {
        ObjectUtil.checkNotNull(executor, "executor");
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        return new Executor() { // from class: io.netty.util.internal.ThreadExecutorMap.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                executor.execute(ThreadExecutorMap.apply(runnable, eventExecutor));
            }
        };
    }

    public static EventExecutor currentExecutor() {
        return mappings.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setCurrentEventExecutor(EventExecutor eventExecutor) throws Throwable {
        mappings.set(eventExecutor);
    }

    public static Runnable apply(final Runnable runnable, final EventExecutor eventExecutor) {
        ObjectUtil.checkNotNull(runnable, Contract.COMMAND);
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        return new Runnable() { // from class: io.netty.util.internal.ThreadExecutorMap.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ThreadExecutorMap.setCurrentEventExecutor(eventExecutor);
                try {
                    runnable.run();
                } finally {
                    ThreadExecutorMap.setCurrentEventExecutor(null);
                }
            }
        };
    }

    public static ThreadFactory apply(final ThreadFactory threadFactory, final EventExecutor eventExecutor) {
        ObjectUtil.checkNotNull(threadFactory, "threadFactory");
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        return new ThreadFactory() { // from class: io.netty.util.internal.ThreadExecutorMap.3
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return threadFactory.newThread(ThreadExecutorMap.apply(runnable, eventExecutor));
            }
        };
    }
}
