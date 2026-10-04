package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultEventExecutorGroup extends MultithreadEventExecutorGroup {
    public DefaultEventExecutorGroup(int i) {
        this(i, null);
    }

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventExecutor newChild(Executor executor, Object... objArr) {
        return new DefaultEventExecutor(this, executor, ((Integer) objArr[0]).intValue(), (RejectedExecutionHandler) objArr[1]);
    }

    public DefaultEventExecutorGroup(int i, ThreadFactory threadFactory) {
        this(i, threadFactory, SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    public DefaultEventExecutorGroup(int i, ThreadFactory threadFactory, int i2, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, threadFactory, Integer.valueOf(i2), rejectedExecutionHandler);
    }
}
