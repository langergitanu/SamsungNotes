package io.netty.channel;

import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.MultithreadEventExecutorGroup;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class MultithreadEventLoopGroup extends MultithreadEventExecutorGroup implements EventLoopGroup {
    private static final int DEFAULT_EVENT_LOOP_THREADS;
    private static final InternalLogger logger;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) MultithreadEventLoopGroup.class);
        logger = internalLoggerFactory;
        int iMax = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
        DEFAULT_EVENT_LOOP_THREADS = iMax;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-Dio.netty.eventLoopThreads: {}", Integer.valueOf(iMax));
        }
    }

    public MultithreadEventLoopGroup(int i, Executor executor, Object... objArr) {
        super(i == 0 ? DEFAULT_EVENT_LOOP_THREADS : i, executor, objArr);
    }

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    public abstract EventLoop newChild(Executor executor, Object... objArr);

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    public ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(getClass(), 10);
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        return next().register(channel);
    }

    public MultithreadEventLoopGroup(int i, ThreadFactory threadFactory, Object... objArr) {
        super(i == 0 ? DEFAULT_EVENT_LOOP_THREADS : i, threadFactory, objArr);
    }

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) super.next();
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        return next().register(channelPromise);
    }

    public MultithreadEventLoopGroup(int i, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, Object... objArr) {
        super(i == 0 ? DEFAULT_EVENT_LOOP_THREADS : i, executor, eventExecutorChooserFactory, objArr);
    }

    @Override // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        return next().register(channel, channelPromise);
    }
}
