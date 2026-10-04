package io.grpc.netty;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.TaskCloseable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class WriteQueue {

    @VisibleForTesting
    static final int DEQUE_CHUNK_SIZE = 128;
    private final Channel channel;
    private final Runnable later = new Runnable() { // from class: io.grpc.netty.WriteQueue.1
        @Override // java.lang.Runnable
        public void run() {
            WriteQueue.this.flush();
        }
    };
    private final AtomicBoolean scheduled = new AtomicBoolean();
    private final Queue<QueuedCommand> queue = new ConcurrentLinkedQueue();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AbstractQueuedCommand implements QueuedCommand {
        private final Link link = PerfMark.linkOut();
        private ChannelPromise promise;

        @Override // io.grpc.netty.WriteQueue.QueuedCommand
        public Link getLink() {
            return this.link;
        }

        @Override // io.grpc.netty.WriteQueue.QueuedCommand
        public final void promise(ChannelPromise channelPromise) {
            this.promise = channelPromise;
        }

        @Override // io.grpc.netty.WriteQueue.QueuedCommand
        public final void run(Channel channel) {
            channel.write(this, this.promise);
        }

        @Override // io.grpc.netty.WriteQueue.QueuedCommand
        public final ChannelPromise promise() {
            return this.promise;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface QueuedCommand {
        Link getLink();

        ChannelPromise promise();

        void promise(ChannelPromise channelPromise);

        void run(Channel channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RunnableCommand implements QueuedCommand {
        private final Link link = PerfMark.linkOut();
        private final Runnable runnable;

        public RunnableCommand(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override // io.grpc.netty.WriteQueue.QueuedCommand
        public Link getLink() {
            return this.link;
        }

        @Override // io.grpc.netty.WriteQueue.QueuedCommand
        public final void promise(ChannelPromise channelPromise) {
            throw new UnsupportedOperationException();
        }

        @Override // io.grpc.netty.WriteQueue.QueuedCommand
        public final void run(Channel channel) {
            this.runnable.run();
        }

        @Override // io.grpc.netty.WriteQueue.QueuedCommand
        public final ChannelPromise promise() {
            throw new UnsupportedOperationException();
        }
    }

    public WriteQueue(Channel channel) {
        this.channel = (Channel) Preconditions.checkNotNull(channel, NetworkConfig.CLIENTS_CHANNEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flush() {
        TaskCloseable taskCloseableTraceTask;
        int i;
        boolean z;
        TaskCloseable taskCloseableTraceTask2;
        try {
            taskCloseableTraceTask = PerfMark.traceTask("WriteQueue.periodicFlush");
            i = 0;
            z = false;
        } finally {
        }
        while (true) {
            try {
                QueuedCommand queuedCommandPoll = this.queue.poll();
                if (queuedCommandPoll == null) {
                    break;
                }
                queuedCommandPoll.run(this.channel);
                i++;
                if (i == 128) {
                    taskCloseableTraceTask2 = PerfMark.traceTask("WriteQueue.flush0");
                    try {
                        this.channel.flush();
                        if (taskCloseableTraceTask2 != null) {
                            taskCloseableTraceTask2.close();
                        }
                        z = true;
                        i = 0;
                    } finally {
                    }
                }
            } finally {
            }
            this.scheduled.set(false);
            if (!this.queue.isEmpty()) {
                scheduleFlush();
            }
        }
        if (i != 0 || !z) {
            taskCloseableTraceTask2 = PerfMark.traceTask("WriteQueue.flush1");
            try {
                this.channel.flush();
                if (taskCloseableTraceTask2 != null) {
                    taskCloseableTraceTask2.close();
                }
            } finally {
            }
        }
        if (taskCloseableTraceTask != null) {
            taskCloseableTraceTask.close();
        }
    }

    public void drainNow() {
        Preconditions.checkState(this.channel.eventLoop().inEventLoop(), "must be on the event loop");
        if (this.queue.peek() == null) {
            return;
        }
        flush();
    }

    @CanIgnoreReturnValue
    public ChannelFuture enqueue(QueuedCommand queuedCommand, boolean z) {
        Preconditions.checkArgument(queuedCommand.promise() == null, "promise must not be set on command");
        ChannelPromise channelPromiseNewPromise = this.channel.newPromise();
        queuedCommand.promise(channelPromiseNewPromise);
        this.queue.add(queuedCommand);
        if (z) {
            scheduleFlush();
        }
        return channelPromiseNewPromise;
    }

    public void scheduleFlush() {
        if (this.scheduled.compareAndSet(false, true)) {
            this.channel.eventLoop().execute(this.later);
        }
    }

    public void enqueue(Runnable runnable, boolean z) {
        this.queue.add(new RunnableCommand(runnable));
        if (z) {
            scheduleFlush();
        }
    }
}
