package io.netty.channel.embedded;

import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class EmbeddedEventLoop extends AbstractScheduledEventExecutor implements EventLoop {
    private long frozenTimestamp;
    private long startTime = AbstractScheduledEventExecutor.initialNanoTime();
    private final Queue<Runnable> tasks = new ArrayDeque(2);
    private boolean timeFrozen;

    public void advanceTimeBy(long j) {
        if (this.timeFrozen) {
            this.frozenTimestamp += j;
        } else {
            this.startTime -= j;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public void cancelScheduledTasks() {
        super.cancelScheduledTasks();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.tasks.add((Runnable) ObjectUtil.checkNotNull(runnable, Contract.COMMAND));
    }

    public void freezeTime() {
        if (this.timeFrozen) {
            return;
        }
        this.frozenTimestamp = getCurrentTimeNanos();
        this.timeFrozen = true;
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public long getCurrentTimeNanos() {
        return this.timeFrozen ? this.frozenTimestamp : System.nanoTime() - this.startTime;
    }

    public boolean hasPendingNormalTasks() {
        return !this.tasks.isEmpty();
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

    public long nextScheduledTask() {
        return nextScheduledTaskNano();
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        return register(new DefaultChannelPromise(channel, this));
    }

    public long runScheduledTasks() {
        long currentTimeNanos = getCurrentTimeNanos();
        while (true) {
            Runnable runnablePollScheduledTask = pollScheduledTask(currentTimeNanos);
            if (runnablePollScheduledTask == null) {
                return nextScheduledTaskNano();
            }
            runnablePollScheduledTask.run();
        }
    }

    public void runTasks() {
        while (true) {
            Runnable runnablePoll = this.tasks.poll();
            if (runnablePoll == null) {
                return;
            } else {
                runnablePoll.run();
            }
        }
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        throw new UnsupportedOperationException();
    }

    public void unfreezeTime() {
        if (this.timeFrozen) {
            this.startTime = System.nanoTime() - this.frozenTimestamp;
            this.timeFrozen = false;
        }
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return true;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) super.next();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.channel.EventLoop
    public EventLoopGroup parent() {
        return (EventLoopGroup) super.parent();
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channelPromise, Contract.PROMISE);
        channelPromise.channel().unsafe().register(this, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        channel.unsafe().register(this, channelPromise);
        return channelPromise;
    }
}
