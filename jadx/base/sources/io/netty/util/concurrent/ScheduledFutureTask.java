package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class ScheduledFutureTask<V> extends PromiseTask<V> implements ScheduledFuture<V>, PriorityQueueNode {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long deadlineNanos;

    /* JADX INFO: renamed from: id */
    private long f8959id;
    private final long periodNanos;
    private int queueIndex;

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Runnable runnable, long j) {
        super(abstractScheduledEventExecutor, runnable);
        this.queueIndex = -1;
        this.deadlineNanos = j;
        this.periodNanos = 0L;
    }

    public static long deadlineToDelayNanos(long j, long j2) {
        if (j2 == 0) {
            return 0L;
        }
        return Math.max(0L, j2 - j);
    }

    private AbstractScheduledEventExecutor scheduledExecutor() {
        return (AbstractScheduledEventExecutor) executor();
    }

    private static long validatePeriod(long j) {
        if (j != 0) {
            return j;
        }
        throw new IllegalArgumentException("period: 0 (expected: != 0)");
    }

    @Override // io.netty.util.concurrent.PromiseTask, io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean zCancel = super.cancel(z);
        if (zCancel) {
            scheduledExecutor().removeScheduled(this);
        }
        return zCancel;
    }

    public boolean cancelWithoutRemove(boolean z) {
        return super.cancel(z);
    }

    public long deadlineNanos() {
        return this.deadlineNanos;
    }

    public long delayNanos() {
        return delayNanos(scheduledExecutor().getCurrentTimeNanos());
    }

    @Override // io.netty.util.concurrent.DefaultPromise
    public EventExecutor executor() {
        return super.executor();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(delayNanos(), TimeUnit.NANOSECONDS);
    }

    @Override // io.netty.util.internal.PriorityQueueNode
    public int priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue) {
        return this.queueIndex;
    }

    @Override // io.netty.util.concurrent.PromiseTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        try {
            if (delayNanos() > 0) {
                if (isCancelled()) {
                    scheduledExecutor().scheduledTaskQueue().removeTyped(this);
                    return;
                } else {
                    scheduledExecutor().scheduleFromEventLoop(this);
                    return;
                }
            }
            if (this.periodNanos == 0) {
                if (setUncancellableInternal()) {
                    setSuccessInternal(runTask());
                }
            } else {
                if (isCancelled()) {
                    return;
                }
                runTask();
                if (executor().isShutdown()) {
                    return;
                }
                long j = this.periodNanos;
                if (j > 0) {
                    this.deadlineNanos += j;
                } else {
                    this.deadlineNanos = scheduledExecutor().getCurrentTimeNanos() - this.periodNanos;
                }
                if (isCancelled()) {
                    return;
                }
                scheduledExecutor().scheduledTaskQueue().add(this);
            }
        } catch (Throwable th) {
            setFailureInternal(th);
        }
    }

    public void setConsumed() {
        if (this.periodNanos == 0) {
            this.deadlineNanos = 0L;
        }
    }

    public ScheduledFutureTask<V> setId(long j) {
        if (this.f8959id == 0) {
            this.f8959id = j;
        }
        return this;
    }

    @Override // io.netty.util.concurrent.PromiseTask, io.netty.util.concurrent.DefaultPromise
    public StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, ',');
        stringBuilder.append(" deadline: ");
        stringBuilder.append(this.deadlineNanos);
        stringBuilder.append(", period: ");
        stringBuilder.append(this.periodNanos);
        stringBuilder.append(PropertyUtils.MAPPED_DELIM2);
        return stringBuilder;
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        if (this == delayed) {
            return 0;
        }
        ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask) delayed;
        long jDeadlineNanos = deadlineNanos() - scheduledFutureTask.deadlineNanos();
        if (jDeadlineNanos < 0) {
            return -1;
        }
        return (jDeadlineNanos <= 0 && this.f8959id < scheduledFutureTask.f8959id) ? -1 : 1;
    }

    public long delayNanos(long j) {
        return deadlineToDelayNanos(j, this.deadlineNanos);
    }

    @Override // io.netty.util.internal.PriorityQueueNode
    public void priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue, int i) {
        this.queueIndex = i;
    }

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Runnable runnable, long j, long j2) {
        super(abstractScheduledEventExecutor, runnable);
        this.queueIndex = -1;
        this.deadlineNanos = j;
        this.periodNanos = validatePeriod(j2);
    }

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j, long j2) {
        super(abstractScheduledEventExecutor, callable);
        this.queueIndex = -1;
        this.deadlineNanos = j;
        this.periodNanos = validatePeriod(j2);
    }

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j) {
        super(abstractScheduledEventExecutor, callable);
        this.queueIndex = -1;
        this.deadlineNanos = j;
        this.periodNanos = 0L;
    }
}
