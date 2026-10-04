package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractNioChannel extends AbstractChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractNioChannel.class);

    /* JADX INFO: renamed from: ch */
    private final SelectableChannel f8863ch;
    private final Runnable clearReadPendingRunnable;
    private ChannelPromise connectPromise;
    private Future<?> connectTimeoutFuture;
    protected final int readInterestOp;
    boolean readPending;
    private SocketAddress requestedRemoteAddress;
    volatile SelectionKey selectionKey;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface NioUnsafe extends Channel.Unsafe {
        /* JADX INFO: renamed from: ch */
        SelectableChannel mo13768ch();

        void finishConnect();

        void forceFlush();

        void read();
    }

    public AbstractNioChannel(Channel channel, SelectableChannel selectableChannel, int i) {
        super(channel);
        this.clearReadPendingRunnable = new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractNioChannel.this.clearReadPending0();
            }
        };
        this.f8863ch = selectableChannel;
        this.readInterestOp = i;
        try {
            selectableChannel.configureBlocking(false);
        } catch (IOException e) {
            try {
                selectableChannel.close();
            } catch (IOException e2) {
                logger.warn("Failed to close a partially initialized socket.", (Throwable) e2);
            }
            throw new ChannelException("Failed to enter non-blocking mode.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadPending0() {
        this.readPending = false;
        ((AbstractNioUnsafe) unsafe()).removeReadOp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadPending0(boolean z) {
        this.readPending = z;
        if (z) {
            return;
        }
        ((AbstractNioUnsafe) unsafe()).removeReadOp();
    }

    public final void clearReadPending() {
        if (!isRegistered()) {
            this.readPending = false;
            return;
        }
        NioEventLoop nioEventLoopEventLoop = eventLoop();
        if (nioEventLoopEventLoop.inEventLoop()) {
            clearReadPending0();
        } else {
            nioEventLoopEventLoop.execute(this.clearReadPendingRunnable);
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doBeginRead() {
        SelectionKey selectionKey = this.selectionKey;
        if (selectionKey.isValid()) {
            this.readPending = true;
            int iInterestOps = selectionKey.interestOps();
            int i = this.readInterestOp;
            if ((iInterestOps & i) == 0) {
                selectionKey.interestOps(iInterestOps | i);
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doClose() {
        ChannelPromise channelPromise = this.connectPromise;
        if (channelPromise != null) {
            channelPromise.tryFailure(new ClosedChannelException());
            this.connectPromise = null;
        }
        Future<?> future = this.connectTimeoutFuture;
        if (future != null) {
            future.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }

    public abstract boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2);

    @Override // io.netty.channel.AbstractChannel
    public void doDeregister() {
        eventLoop().cancel(selectionKey());
    }

    public abstract void doFinishConnect();

    @Override // io.netty.channel.AbstractChannel
    public void doRegister() {
        boolean z = false;
        while (true) {
            try {
                this.selectionKey = javaChannel().register(eventLoop().unwrappedSelector(), 0, this);
                return;
            } catch (CancelledKeyException e) {
                if (z) {
                    throw e;
                }
                eventLoop().selectNow();
                z = true;
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof NioEventLoop;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.f8863ch.isOpen();
    }

    @Deprecated
    public boolean isReadPending() {
        return this.readPending;
    }

    public SelectableChannel javaChannel() {
        return this.f8863ch;
    }

    public final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        int i = byteBuf.readableBytes();
        if (i == 0) {
            ReferenceCountUtil.safeRelease(byteBuf);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator byteBufAllocatorAlloc = alloc();
        if (byteBufAllocatorAlloc.isDirectBufferPooled()) {
            ByteBuf byteBufDirectBuffer = byteBufAllocatorAlloc.directBuffer(i);
            byteBufDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i);
            ReferenceCountUtil.safeRelease(byteBuf);
            return byteBufDirectBuffer;
        }
        ByteBuf byteBufThreadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (byteBufThreadLocalDirectBuffer == null) {
            return byteBuf;
        }
        byteBufThreadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i);
        ReferenceCountUtil.safeRelease(byteBuf);
        return byteBufThreadLocalDirectBuffer;
    }

    public SelectionKey selectionKey() {
        return this.selectionKey;
    }

    @Deprecated
    public void setReadPending(final boolean z) {
        if (!isRegistered()) {
            this.readPending = z;
            return;
        }
        NioEventLoop nioEventLoopEventLoop = eventLoop();
        if (nioEventLoopEventLoop.inEventLoop()) {
            setReadPending0(z);
        } else {
            nioEventLoopEventLoop.execute(new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractNioChannel.this.setReadPending0(z);
                }
            });
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public NioEventLoop eventLoop() {
        return (NioEventLoop) super.eventLoop();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public NioUnsafe unsafe() {
        return (NioUnsafe) super.unsafe();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class AbstractNioUnsafe extends AbstractChannel.AbstractUnsafe implements NioUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public AbstractNioUnsafe() {
            super();
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, boolean z) {
            if (channelPromise == null) {
                return;
            }
            boolean zIsActive = AbstractNioChannel.this.isActive();
            boolean zTrySuccess = channelPromise.trySuccess();
            if (!z && zIsActive) {
                AbstractNioChannel.this.pipeline().fireChannelActive();
            }
            if (zTrySuccess) {
                return;
            }
            close(voidPromise());
        }

        private boolean isFlushPending() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            return selectionKey.isValid() && (selectionKey.interestOps() & 4) != 0;
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        /* JADX INFO: renamed from: ch */
        public final SelectableChannel mo13768ch() {
            return AbstractNioChannel.this.javaChannel();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void connect(final SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    if (AbstractNioChannel.this.connectPromise != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean zIsActive = AbstractNioChannel.this.isActive();
                    if (AbstractNioChannel.this.doConnect(socketAddress, socketAddress2)) {
                        fulfillConnectPromise(channelPromise, zIsActive);
                        return;
                    }
                    AbstractNioChannel.this.connectPromise = channelPromise;
                    AbstractNioChannel.this.requestedRemoteAddress = socketAddress;
                    int connectTimeoutMillis = AbstractNioChannel.this.config().getConnectTimeoutMillis();
                    if (connectTimeoutMillis > 0) {
                        AbstractNioChannel abstractNioChannel = AbstractNioChannel.this;
                        abstractNioChannel.connectTimeoutFuture = abstractNioChannel.eventLoop().schedule(new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChannelPromise channelPromise2 = AbstractNioChannel.this.connectPromise;
                                if (channelPromise2 == null || channelPromise2.isDone()) {
                                    return;
                                }
                                if (channelPromise2.tryFailure(new ConnectTimeoutException("connection timed out: " + socketAddress))) {
                                    AbstractNioUnsafe abstractNioUnsafe = AbstractNioUnsafe.this;
                                    abstractNioUnsafe.close(abstractNioUnsafe.voidPromise());
                                }
                            }
                        }, connectTimeoutMillis, TimeUnit.MILLISECONDS);
                    }
                    channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe.2
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(ChannelFuture channelFuture) {
                            if (channelFuture.isCancelled()) {
                                if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                                    AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                                }
                                AbstractNioChannel.this.connectPromise = null;
                                AbstractNioUnsafe abstractNioUnsafe = AbstractNioUnsafe.this;
                                abstractNioUnsafe.close(abstractNioUnsafe.voidPromise());
                            }
                        }
                    });
                } catch (Throwable th) {
                    channelPromise.tryFailure(annotateConnectException(th, socketAddress));
                    closeIfClosed();
                }
            }
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void finishConnect() {
            try {
                boolean zIsActive = AbstractNioChannel.this.isActive();
                AbstractNioChannel.this.doFinishConnect();
                fulfillConnectPromise(AbstractNioChannel.this.connectPromise, zIsActive);
            } catch (Throwable th) {
                try {
                    fulfillConnectPromise(AbstractNioChannel.this.connectPromise, annotateConnectException(th, AbstractNioChannel.this.requestedRemoteAddress));
                    if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                    }
                } finally {
                    if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                        AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                    }
                    AbstractNioChannel.this.connectPromise = null;
                }
            }
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        public final void flush0() {
            if (isFlushPending()) {
                return;
            }
            super.flush0();
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void forceFlush() {
            super.flush0();
        }

        public final void removeReadOp() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            if (selectionKey.isValid()) {
                int iInterestOps = selectionKey.interestOps();
                int i = AbstractNioChannel.this.readInterestOp;
                if ((iInterestOps & i) != 0) {
                    selectionKey.interestOps(iInterestOps & (~i));
                }
            }
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, Throwable th) {
            if (channelPromise == null) {
                return;
            }
            channelPromise.tryFailure(th);
            closeIfClosed();
        }
    }

    public final ByteBuf newDirectBuffer(ReferenceCounted referenceCounted, ByteBuf byteBuf) {
        int i = byteBuf.readableBytes();
        if (i == 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator byteBufAllocatorAlloc = alloc();
        if (byteBufAllocatorAlloc.isDirectBufferPooled()) {
            ByteBuf byteBufDirectBuffer = byteBufAllocatorAlloc.directBuffer(i);
            byteBufDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i);
            ReferenceCountUtil.safeRelease(referenceCounted);
            return byteBufDirectBuffer;
        }
        ByteBuf byteBufThreadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (byteBufThreadLocalDirectBuffer != null) {
            byteBufThreadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i);
            ReferenceCountUtil.safeRelease(referenceCounted);
            return byteBufThreadLocalDirectBuffer;
        }
        if (referenceCounted != byteBuf) {
            byteBuf.retain();
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
        return byteBuf;
    }
}
