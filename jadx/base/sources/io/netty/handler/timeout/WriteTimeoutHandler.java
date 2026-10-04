package io.netty.handler.timeout;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;
import opennlp.tools.namefind.BilouCodec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class WriteTimeoutHandler extends ChannelOutboundHandlerAdapter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private boolean closed;
    private WriteTimeoutTask lastTask;
    private final long timeoutNanos;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class WriteTimeoutTask implements Runnable, ChannelFutureListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ChannelHandlerContext ctx;
        WriteTimeoutTask next;
        WriteTimeoutTask prev;
        private final ChannelPromise promise;
        Future<?> scheduledFuture;

        public WriteTimeoutTask(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.promise.isDone()) {
                try {
                    WriteTimeoutHandler.this.writeTimedOut(this.ctx);
                } catch (Throwable th) {
                    this.ctx.fireExceptionCaught(th);
                }
            }
            WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            this.scheduledFuture.cancel(false);
            if (this.ctx.executor().inEventLoop()) {
                WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
            } else {
                this.ctx.executor().execute(this);
            }
        }
    }

    public WriteTimeoutHandler(int i) {
        this(i, TimeUnit.SECONDS);
    }

    private void addWriteTimeoutTask(WriteTimeoutTask writeTimeoutTask) {
        WriteTimeoutTask writeTimeoutTask2 = this.lastTask;
        if (writeTimeoutTask2 != null) {
            writeTimeoutTask2.next = writeTimeoutTask;
            writeTimeoutTask.prev = writeTimeoutTask2;
        }
        this.lastTask = writeTimeoutTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWriteTimeoutTask(WriteTimeoutTask writeTimeoutTask) {
        WriteTimeoutTask writeTimeoutTask2 = this.lastTask;
        if (writeTimeoutTask == writeTimeoutTask2) {
            WriteTimeoutTask writeTimeoutTask3 = writeTimeoutTask2.prev;
            this.lastTask = writeTimeoutTask3;
            if (writeTimeoutTask3 != null) {
                writeTimeoutTask3.next = null;
            }
        } else {
            WriteTimeoutTask writeTimeoutTask4 = writeTimeoutTask.prev;
            if (writeTimeoutTask4 == null && writeTimeoutTask.next == null) {
                return;
            }
            if (writeTimeoutTask4 == null) {
                writeTimeoutTask.next.prev = null;
            } else {
                writeTimeoutTask4.next = writeTimeoutTask.next;
                writeTimeoutTask.next.prev = writeTimeoutTask4;
            }
        }
        writeTimeoutTask.prev = null;
        writeTimeoutTask.next = null;
    }

    private void scheduleTimeout(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        WriteTimeoutTask writeTimeoutTask = new WriteTimeoutTask(channelHandlerContext, channelPromise);
        ScheduledFuture<?> scheduledFutureSchedule = channelHandlerContext.executor().schedule((Runnable) writeTimeoutTask, this.timeoutNanos, TimeUnit.NANOSECONDS);
        writeTimeoutTask.scheduledFuture = scheduledFutureSchedule;
        if (scheduledFutureSchedule.isDone()) {
            return;
        }
        addWriteTimeoutTask(writeTimeoutTask);
        channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) writeTimeoutTask);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        WriteTimeoutTask writeTimeoutTask = this.lastTask;
        this.lastTask = null;
        while (writeTimeoutTask != null) {
            writeTimeoutTask.scheduledFuture.cancel(false);
            WriteTimeoutTask writeTimeoutTask2 = writeTimeoutTask.prev;
            writeTimeoutTask.prev = null;
            writeTimeoutTask.next = null;
            writeTimeoutTask = writeTimeoutTask2;
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        if (this.timeoutNanos > 0) {
            channelPromise = channelPromise.unvoid();
            scheduleTimeout(channelHandlerContext, channelPromise);
        }
        channelHandlerContext.write(obj, channelPromise);
    }

    public void writeTimedOut(ChannelHandlerContext channelHandlerContext) {
        if (this.closed) {
            return;
        }
        channelHandlerContext.fireExceptionCaught((Throwable) WriteTimeoutException.INSTANCE);
        channelHandlerContext.close();
        this.closed = true;
    }

    public WriteTimeoutHandler(long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(timeUnit, BilouCodec.UNIT);
        if (j <= 0) {
            this.timeoutNanos = 0L;
        } else {
            this.timeoutNanos = Math.max(timeUnit.toNanos(j), MIN_TIMEOUT_NANOS);
        }
    }
}
