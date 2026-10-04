package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultEventExecutor extends SingleThreadEventExecutor {
    public DefaultEventExecutor() {
        this((EventExecutorGroup) null);
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void run() {
        do {
            Runnable runnableTakeTask = takeTask();
            if (runnableTakeTask != null) {
                AbstractEventExecutor.runTask(runnableTakeTask);
                updateLastExecutionTime();
            }
        } while (!confirmShutdown());
    }

    public DefaultEventExecutor(ThreadFactory threadFactory) {
        this((EventExecutorGroup) null, threadFactory);
    }

    public DefaultEventExecutor(Executor executor) {
        this((EventExecutorGroup) null, executor);
    }

    public DefaultEventExecutor(EventExecutorGroup eventExecutorGroup) {
        this(eventExecutorGroup, new DefaultThreadFactory((Class<?>) DefaultEventExecutor.class));
    }

    public DefaultEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory) {
        super(eventExecutorGroup, threadFactory, true);
    }

    public DefaultEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor) {
        super(eventExecutorGroup, executor, true);
    }

    public DefaultEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventExecutorGroup, threadFactory, true, i, rejectedExecutionHandler);
    }

    public DefaultEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventExecutorGroup, executor, true, i, rejectedExecutionHandler);
    }
}
