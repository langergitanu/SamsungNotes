package io.netty.handler.codec.http2;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ServerChannel;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.ChannelOutputShutdownEvent;
import io.netty.handler.codec.http2.Http2FrameCodec;
import io.netty.handler.codec.http2.Http2FrameStreamEvent;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.ssl.SslCloseCompletionEvent;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.net.ssl.SSLException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Http2MultiplexHandler extends Http2ChannelDuplexHandler {
    static final ChannelFutureListener CHILD_CHANNEL_REGISTRATION_LISTENER = new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2MultiplexHandler.1
        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            Http2MultiplexHandler.registerDone(channelFuture);
        }
    };
    private volatile ChannelHandlerContext ctx;
    private int idCount;
    private final ChannelHandler inboundStreamHandler;
    private boolean parentReadInProgress;
    private final Queue<AbstractHttp2StreamChannel> readCompletePendingQueue;
    private final ChannelHandler upgradeStreamHandler;

    /* JADX INFO: renamed from: io.netty.handler.codec.http2.Http2MultiplexHandler$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126214 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class Http2MultiplexHandlerStreamChannel extends AbstractHttp2StreamChannel {
        public Http2MultiplexHandlerStreamChannel(Http2FrameCodec.DefaultHttp2FrameStream defaultHttp2FrameStream, ChannelHandler channelHandler) {
            super(defaultHttp2FrameStream, Http2MultiplexHandler.access$004(Http2MultiplexHandler.this), channelHandler);
        }

        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel
        public void addChannelToReadCompletePendingQueue() {
            while (!Http2MultiplexHandler.this.readCompletePendingQueue.offer(this)) {
                Http2MultiplexHandler.this.processPendingReadCompleteQueue();
            }
        }

        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel
        public boolean isParentReadInProgress() {
            return Http2MultiplexHandler.this.parentReadInProgress;
        }

        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel
        public ChannelHandlerContext parentContext() {
            return Http2MultiplexHandler.this.ctx;
        }
    }

    public Http2MultiplexHandler(ChannelHandler channelHandler) {
        this(channelHandler, null);
    }

    public static /* synthetic */ int access$004(Http2MultiplexHandler http2MultiplexHandler) {
        int i = http2MultiplexHandler.idCount + 1;
        http2MultiplexHandler.idCount = i;
        return i;
    }

    private void fireExceptionCaughtForActiveStream(final Throwable th) {
        forEachActiveStream(new Http2FrameStreamVisitor() { // from class: io.netty.handler.codec.http2.Http2MultiplexHandler.2
            @Override // io.netty.handler.codec.http2.Http2FrameStreamVisitor
            public boolean visit(Http2FrameStream http2FrameStream) {
                ((AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStream).attachment).pipeline().fireExceptionCaught(th);
                return true;
            }
        });
    }

    private static boolean isServer(ChannelHandlerContext channelHandlerContext) {
        return channelHandlerContext.channel().parent() instanceof ServerChannel;
    }

    private void onHttp2GoAwayFrame(ChannelHandlerContext channelHandlerContext, final Http2GoAwayFrame http2GoAwayFrame) {
        if (http2GoAwayFrame.lastStreamId() == Integer.MAX_VALUE) {
            return;
        }
        try {
            final boolean zIsServer = isServer(channelHandlerContext);
            forEachActiveStream(new Http2FrameStreamVisitor() { // from class: io.netty.handler.codec.http2.Http2MultiplexHandler.3
                @Override // io.netty.handler.codec.http2.Http2FrameStreamVisitor
                public boolean visit(Http2FrameStream http2FrameStream) {
                    int iMo13774id = http2FrameStream.mo13774id();
                    if (iMo13774id <= http2GoAwayFrame.lastStreamId() || !Http2CodecUtil.isStreamIdValid(iMo13774id, zIsServer)) {
                        return true;
                    }
                    ((AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStream).attachment).pipeline().fireUserEventTriggered((Object) http2GoAwayFrame.retainedDuplicate());
                    return true;
                }
            });
        } catch (Http2Exception e) {
            channelHandlerContext.fireExceptionCaught((Throwable) e);
            channelHandlerContext.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPendingReadCompleteQueue() {
        this.parentReadInProgress = true;
        AbstractHttp2StreamChannel abstractHttp2StreamChannelPoll = this.readCompletePendingQueue.poll();
        if (abstractHttp2StreamChannelPoll == null) {
            this.parentReadInProgress = false;
            return;
        }
        do {
            try {
                abstractHttp2StreamChannelPoll.fireChildReadComplete();
                abstractHttp2StreamChannelPoll = this.readCompletePendingQueue.poll();
            } finally {
                this.parentReadInProgress = false;
                this.readCompletePendingQueue.clear();
                this.ctx.flush();
            }
        } while (abstractHttp2StreamChannelPoll != null);
    }

    public static void registerDone(ChannelFuture channelFuture) {
        if (channelFuture.isSuccess()) {
            return;
        }
        Channel channel = channelFuture.channel();
        if (channel.isRegistered()) {
            channel.close();
        } else {
            channel.unsafe().closeForcibly();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        this.parentReadInProgress = true;
        if (!(obj instanceof Http2StreamFrame)) {
            if (obj instanceof Http2GoAwayFrame) {
                onHttp2GoAwayFrame(channelHandlerContext, (Http2GoAwayFrame) obj);
            }
            channelHandlerContext.fireChannelRead(obj);
        } else {
            if (obj instanceof Http2WindowUpdateFrame) {
                return;
            }
            Http2StreamFrame http2StreamFrame = (Http2StreamFrame) obj;
            AbstractHttp2StreamChannel abstractHttp2StreamChannel = (AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2StreamFrame.stream()).attachment;
            if (obj instanceof Http2ResetFrame) {
                abstractHttp2StreamChannel.pipeline().fireUserEventTriggered(obj);
            } else {
                abstractHttp2StreamChannel.fireChildRead(http2StreamFrame);
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        processPendingReadCompleteQueue();
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.channel().isWritable()) {
            forEachActiveStream(AbstractHttp2StreamChannel.WRITABLE_VISITOR);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        if (th instanceof Http2FrameStreamException) {
            Http2FrameStreamException http2FrameStreamException = (Http2FrameStreamException) th;
            AbstractHttp2StreamChannel abstractHttp2StreamChannel = (AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStreamException.stream()).attachment;
            try {
                abstractHttp2StreamChannel.pipeline().fireExceptionCaught(th.getCause());
                return;
            } finally {
                abstractHttp2StreamChannel.closeWithError(http2FrameStreamException.error());
            }
        }
        if (th instanceof Http2MultiplexActiveStreamsException) {
            fireExceptionCaughtForActiveStream(th.getCause());
            return;
        }
        if (th.getCause() instanceof SSLException) {
            fireExceptionCaughtForActiveStream(th);
        }
        channelHandlerContext.fireExceptionCaught(th);
    }

    @Override // io.netty.handler.codec.http2.Http2ChannelDuplexHandler
    public void handlerAdded0(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.executor() != channelHandlerContext.channel().eventLoop()) {
            throw new IllegalStateException("EventExecutor must be EventLoop of Channel");
        }
        this.ctx = channelHandlerContext;
    }

    @Override // io.netty.handler.codec.http2.Http2ChannelDuplexHandler
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) {
        this.readCompletePendingQueue.clear();
    }

    public Http2StreamChannel newOutboundStream() {
        return new Http2MultiplexHandlerStreamChannel((Http2FrameCodec.DefaultHttp2FrameStream) newStream(), null);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Http2Exception {
        Http2MultiplexHandlerStreamChannel http2MultiplexHandlerStreamChannel;
        AbstractHttp2StreamChannel abstractHttp2StreamChannel;
        if (!(obj instanceof Http2FrameStreamEvent)) {
            if (obj == ChannelInputShutdownReadComplete.INSTANCE) {
                forEachActiveStream(AbstractHttp2StreamChannel.CHANNEL_INPUT_SHUTDOWN_READ_COMPLETE_VISITOR);
            } else if (obj == ChannelOutputShutdownEvent.INSTANCE) {
                forEachActiveStream(AbstractHttp2StreamChannel.CHANNEL_OUTPUT_SHUTDOWN_EVENT_VISITOR);
            } else if (obj == SslCloseCompletionEvent.SUCCESS) {
                forEachActiveStream(AbstractHttp2StreamChannel.SSL_CLOSE_COMPLETION_EVENT_VISITOR);
            }
            channelHandlerContext.fireUserEventTriggered(obj);
            return;
        }
        Http2FrameStreamEvent http2FrameStreamEvent = (Http2FrameStreamEvent) obj;
        Http2FrameCodec.DefaultHttp2FrameStream defaultHttp2FrameStream = (Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStreamEvent.stream();
        if (http2FrameStreamEvent.type() == Http2FrameStreamEvent.Type.State) {
            int i = C126214.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[defaultHttp2FrameStream.state().ordinal()];
            if (i != 1) {
                if (i != 2 && i != 3) {
                    if (i == 4 && (abstractHttp2StreamChannel = (AbstractHttp2StreamChannel) defaultHttp2FrameStream.attachment) != null) {
                        abstractHttp2StreamChannel.streamClosed();
                        return;
                    }
                    return;
                }
            } else if (defaultHttp2FrameStream.mo13774id() != 1) {
                return;
            }
            if (defaultHttp2FrameStream.attachment != null) {
                return;
            }
            if (defaultHttp2FrameStream.mo13774id() != 1 || isServer(channelHandlerContext)) {
                http2MultiplexHandlerStreamChannel = new Http2MultiplexHandlerStreamChannel(defaultHttp2FrameStream, this.inboundStreamHandler);
            } else {
                if (this.upgradeStreamHandler == null) {
                    throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Client is misconfigured for upgrade requests", new Object[0]);
                }
                http2MultiplexHandlerStreamChannel = new Http2MultiplexHandlerStreamChannel(defaultHttp2FrameStream, this.upgradeStreamHandler);
                http2MultiplexHandlerStreamChannel.closeOutbound();
            }
            ChannelFuture channelFutureRegister = channelHandlerContext.channel().eventLoop().register(http2MultiplexHandlerStreamChannel);
            if (channelFutureRegister.isDone()) {
                registerDone(channelFutureRegister);
            } else {
                channelFutureRegister.addListener((GenericFutureListener<? extends Future<? super Void>>) CHILD_CHANNEL_REGISTRATION_LISTENER);
            }
        }
    }

    public Http2MultiplexHandler(ChannelHandler channelHandler, ChannelHandler channelHandler2) {
        this.readCompletePendingQueue = new MaxCapacityQueue(new ArrayDeque(8), 100);
        this.inboundStreamHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "inboundStreamHandler");
        this.upgradeStreamHandler = channelHandler2;
    }
}
