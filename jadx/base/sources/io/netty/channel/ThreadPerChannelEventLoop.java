package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class ThreadPerChannelEventLoop extends SingleThreadEventLoop {

    /* JADX INFO: renamed from: ch */
    private Channel f8859ch;
    private final ThreadPerChannelEventLoopGroup parent;

    public ThreadPerChannelEventLoop(ThreadPerChannelEventLoopGroup threadPerChannelEventLoopGroup) {
        super((EventLoopGroup) threadPerChannelEventLoopGroup, threadPerChannelEventLoopGroup.executor, true);
        this.parent = threadPerChannelEventLoopGroup;
    }

    public void deregister() {
        this.f8859ch = null;
        this.parent.activeChildren.remove(this);
        this.parent.idleChildren.add(this);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [io.netty.channel.ChannelFuture] */
    @Override // io.netty.channel.SingleThreadEventLoop, io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        return super.register(channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.ThreadPerChannelEventLoop.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                if (!channelFuture.isSuccess()) {
                    ThreadPerChannelEventLoop.this.deregister();
                } else {
                    ThreadPerChannelEventLoop.this.f8859ch = channelFuture.channel();
                }
            }
        });
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return 1;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void run() {
        while (true) {
            Runnable runnableTakeTask = takeTask();
            if (runnableTakeTask != null) {
                runnableTakeTask.run();
                updateLastExecutionTime();
            }
            Channel channel = this.f8859ch;
            if (isShuttingDown()) {
                if (channel != null) {
                    channel.unsafe().close(channel.unsafe().voidPromise());
                }
                if (confirmShutdown()) {
                    return;
                }
            } else if (channel != null && !channel.isRegistered()) {
                runAllTasks();
                deregister();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [io.netty.channel.ChannelFuture] */
    @Override // io.netty.channel.SingleThreadEventLoop, io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        return super.register(channel, channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.ThreadPerChannelEventLoop.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                if (!channelFuture.isSuccess()) {
                    ThreadPerChannelEventLoop.this.deregister();
                } else {
                    ThreadPerChannelEventLoop.this.f8859ch = channelFuture.channel();
                }
            }
        });
    }
}
