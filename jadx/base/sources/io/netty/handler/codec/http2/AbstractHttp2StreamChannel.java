package io.netty.handler.codec.http2;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.VoidChannelPromise;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.ChannelOutputShutdownEvent;
import io.netty.handler.codec.http2.Http2FrameCodec;
import io.netty.handler.ssl.SslCloseCompletionEvent;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
abstract class AbstractHttp2StreamChannel extends DefaultAttributeMap implements Http2StreamChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MIN_HTTP2_FRAME_SIZE = 9;
    private final ChannelId channelId;
    private final ChannelPromise closePromise;
    private Runnable fireChannelWritabilityChangedTask;
    private boolean firstFrameWritten;
    private int flowControlledBytes;
    private Queue<Object> inboundBuffer;
    private boolean outboundClosed;
    private final ChannelPipeline pipeline;
    private boolean readCompletePending;
    private volatile boolean registered;
    private final Http2FrameCodec.DefaultHttp2FrameStream stream;
    private volatile long totalPendingSize;
    private volatile int unwritable;
    static final Http2FrameStreamVisitor WRITABLE_VISITOR = new Http2FrameStreamVisitor() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.1
        @Override // io.netty.handler.codec.http2.Http2FrameStreamVisitor
        public boolean visit(Http2FrameStream http2FrameStream) {
            ((AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStream).attachment).trySetWritable();
            return true;
        }
    };
    static final Http2FrameStreamVisitor CHANNEL_INPUT_SHUTDOWN_READ_COMPLETE_VISITOR = new UserEventStreamVisitor(ChannelInputShutdownReadComplete.INSTANCE);
    static final Http2FrameStreamVisitor CHANNEL_OUTPUT_SHUTDOWN_EVENT_VISITOR = new UserEventStreamVisitor(ChannelOutputShutdownEvent.INSTANCE);
    static final Http2FrameStreamVisitor SSL_CLOSE_COMPLETION_EVENT_VISITOR = new UserEventStreamVisitor(SslCloseCompletionEvent.SUCCESS);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractHttp2StreamChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final AtomicLongFieldUpdater<AbstractHttp2StreamChannel> TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(AbstractHttp2StreamChannel.class, "totalPendingSize");
    private static final AtomicIntegerFieldUpdater<AbstractHttp2StreamChannel> UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractHttp2StreamChannel.class, "unwritable");
    private final ChannelFutureListener windowUpdateFrameWriteListener = new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.2
        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            AbstractHttp2StreamChannel.windowUpdateFrameWriteComplete(channelFuture, AbstractHttp2StreamChannel.this);
        }
    };
    private final Http2StreamChannelConfig config = new Http2StreamChannelConfig(this);
    private final Http2ChannelUnsafe unsafe = new Http2ChannelUnsafe();
    private ReadStatus readStatus = ReadStatus.IDLE;

    /* JADX INFO: renamed from: io.netty.handler.codec.http2.AbstractHttp2StreamChannel$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125725 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$http2$AbstractHttp2StreamChannel$ReadStatus */
        static final /* synthetic */ int[] f8900x5f8c880f;

        static {
            int[] iArr = new int[ReadStatus.values().length];
            f8900x5f8c880f = iArr;
            try {
                iArr[ReadStatus.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8900x5f8c880f[ReadStatus.IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FlowControlledFrameSizeEstimator implements MessageSizeEstimator {
        static final FlowControlledFrameSizeEstimator INSTANCE = new FlowControlledFrameSizeEstimator();
        private static final MessageSizeEstimator.Handle HANDLE_INSTANCE = new MessageSizeEstimator.Handle() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.FlowControlledFrameSizeEstimator.1
            @Override // io.netty.channel.MessageSizeEstimator.Handle
            public int size(Object obj) {
                if (obj instanceof Http2DataFrame) {
                    return (int) Math.min(2147483647L, ((long) ((Http2DataFrame) obj).initialFlowControlledBytes()) + 9);
                }
                return 9;
            }
        };

        private FlowControlledFrameSizeEstimator() {
        }

        @Override // io.netty.channel.MessageSizeEstimator
        public MessageSizeEstimator.Handle newHandle() {
            return HANDLE_INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class Http2ChannelUnsafe implements Channel.Unsafe {
        private boolean closeInitiated;
        private boolean readEOS;
        private RecvByteBufAllocator.Handle recvHandle;
        private final VoidChannelPromise unsafeVoidPromise;
        private boolean writeDoneAndNoFlush;

        private Http2ChannelUnsafe() {
            this.unsafeVoidPromise = new VoidChannelPromise(AbstractHttp2StreamChannel.this, false);
        }

        private void fireChannelInactiveAndDeregister(final ChannelPromise channelPromise, final boolean z) {
            if (channelPromise.setUncancellable()) {
                if (AbstractHttp2StreamChannel.this.registered) {
                    invokeLater(new Runnable() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z) {
                                AbstractHttp2StreamChannel.this.pipeline.fireChannelInactive();
                            }
                            if (AbstractHttp2StreamChannel.this.registered) {
                                AbstractHttp2StreamChannel.this.registered = false;
                                AbstractHttp2StreamChannel.this.pipeline.fireChannelUnregistered();
                            }
                            Http2ChannelUnsafe.this.safeSetSuccess(channelPromise);
                        }
                    });
                } else {
                    channelPromise.setSuccess();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void firstWriteComplete(ChannelFuture channelFuture, ChannelPromise channelPromise) {
            Throwable thCause = channelFuture.cause();
            if (thCause == null) {
                channelPromise.setSuccess();
            } else {
                closeForcibly();
                channelPromise.setFailure(wrapStreamClosedError(thCause));
            }
        }

        private void invokeLater(Runnable runnable) {
            try {
                AbstractHttp2StreamChannel.this.eventLoop().execute(runnable);
            } catch (RejectedExecutionException e) {
                AbstractHttp2StreamChannel.logger.warn("Can't invoke task later as EventLoop rejected it", (Throwable) e);
            }
        }

        private Object pollQueuedMessage() {
            if (AbstractHttp2StreamChannel.this.inboundBuffer == null) {
                return null;
            }
            return AbstractHttp2StreamChannel.this.inboundBuffer.poll();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void safeSetSuccess(ChannelPromise channelPromise) {
            if ((channelPromise instanceof VoidChannelPromise) || channelPromise.trySuccess()) {
                return;
            }
            AbstractHttp2StreamChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", channelPromise);
        }

        private void updateLocalWindowIfNeeded() {
            if (AbstractHttp2StreamChannel.this.flowControlledBytes != 0) {
                int i = AbstractHttp2StreamChannel.this.flowControlledBytes;
                AbstractHttp2StreamChannel.this.flowControlledBytes = 0;
                AbstractHttp2StreamChannel abstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
                ChannelFuture channelFutureWrite0 = abstractHttp2StreamChannel.write0(abstractHttp2StreamChannel.parentContext(), new DefaultHttp2WindowUpdateFrame(i).stream((Http2FrameStream) AbstractHttp2StreamChannel.this.stream));
                this.writeDoneAndNoFlush = true;
                if (channelFutureWrite0.isDone()) {
                    AbstractHttp2StreamChannel.windowUpdateFrameWriteComplete(channelFutureWrite0, AbstractHttp2StreamChannel.this);
                } else {
                    channelFutureWrite0.addListener((GenericFutureListener<? extends Future<? super Void>>) AbstractHttp2StreamChannel.this.windowUpdateFrameWriteListener);
                }
            }
        }

        private Http2StreamFrame validateStreamFrame(Http2StreamFrame http2StreamFrame) {
            if (http2StreamFrame.stream() == null || http2StreamFrame.stream() == AbstractHttp2StreamChannel.this.stream) {
                return http2StreamFrame;
            }
            String string = http2StreamFrame.toString();
            ReferenceCountUtil.release(http2StreamFrame);
            throw new IllegalArgumentException("Stream " + http2StreamFrame.stream() + " must not be set on the frame: " + string);
        }

        private Throwable wrapStreamClosedError(Throwable th) {
            return ((th instanceof Http2Exception) && ((Http2Exception) th).error() == Http2Error.STREAM_CLOSED) ? new ClosedChannelException().initCause(th) : th;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeComplete(ChannelFuture channelFuture, ChannelPromise channelPromise) {
            Throwable thCause = channelFuture.cause();
            if (thCause == null) {
                channelPromise.setSuccess();
                return;
            }
            Throwable thWrapStreamClosedError = wrapStreamClosedError(thCause);
            if (thWrapStreamClosedError instanceof IOException) {
                if (AbstractHttp2StreamChannel.this.config.isAutoClose()) {
                    closeForcibly();
                } else {
                    AbstractHttp2StreamChannel.this.outboundClosed = true;
                }
            }
            channelPromise.setFailure(thWrapStreamClosedError);
        }

        private void writeHttp2StreamFrame(Http2StreamFrame http2StreamFrame, final ChannelPromise channelPromise) {
            if (!AbstractHttp2StreamChannel.this.firstFrameWritten && !Http2CodecUtil.isStreamIdValid(AbstractHttp2StreamChannel.this.stream().mo13774id()) && !(http2StreamFrame instanceof Http2HeadersFrame)) {
                ReferenceCountUtil.release(http2StreamFrame);
                channelPromise.setFailure((Throwable) new IllegalArgumentException("The first frame must be a headers frame. Was: " + http2StreamFrame.name()));
                return;
            }
            final boolean z = AbstractHttp2StreamChannel.this.firstFrameWritten ? false : AbstractHttp2StreamChannel.this.firstFrameWritten = true;
            AbstractHttp2StreamChannel abstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
            ChannelFuture channelFutureWrite0 = abstractHttp2StreamChannel.write0(abstractHttp2StreamChannel.parentContext(), http2StreamFrame);
            if (channelFutureWrite0.isDone()) {
                if (z) {
                    firstWriteComplete(channelFutureWrite0, channelPromise);
                    return;
                } else {
                    writeComplete(channelFutureWrite0, channelPromise);
                    return;
                }
            }
            final long size = FlowControlledFrameSizeEstimator.HANDLE_INSTANCE.size(http2StreamFrame);
            AbstractHttp2StreamChannel.this.incrementPendingOutboundBytes(size, false);
            channelFutureWrite0.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.3
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    if (z) {
                        Http2ChannelUnsafe.this.firstWriteComplete(channelFuture, channelPromise);
                    } else {
                        Http2ChannelUnsafe.this.writeComplete(channelFuture, channelPromise);
                    }
                    AbstractHttp2StreamChannel.this.decrementPendingOutboundBytes(size, false);
                }
            });
            this.writeDoneAndNoFlush = true;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void beginRead() {
            if (AbstractHttp2StreamChannel.this.isActive()) {
                updateLocalWindowIfNeeded();
                int i = C125725.f8900x5f8c880f[AbstractHttp2StreamChannel.this.readStatus.ordinal()];
                if (i == 1) {
                    AbstractHttp2StreamChannel.this.readStatus = ReadStatus.IN_PROGRESS;
                    doBeginRead();
                } else {
                    if (i != 2) {
                        return;
                    }
                    AbstractHttp2StreamChannel.this.readStatus = ReadStatus.REQUESTED;
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable()) {
                channelPromise.setFailure((Throwable) new UnsupportedOperationException());
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void close(ChannelPromise channelPromise) {
            close(channelPromise, Http2Error.CANCEL);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void closeForcibly() {
            close(AbstractHttp2StreamChannel.this.unsafe().voidPromise());
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable()) {
                channelPromise.setFailure((Throwable) new UnsupportedOperationException());
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void deregister(ChannelPromise channelPromise) {
            fireChannelInactiveAndDeregister(channelPromise, false);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void disconnect(ChannelPromise channelPromise) {
            close(channelPromise);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0045 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:? A[LOOP:1: B:12:0x002f->B:39:?, LOOP_END, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void doBeginRead() {
            boolean zContinueReading;
            while (AbstractHttp2StreamChannel.this.readStatus != ReadStatus.IDLE) {
                Object objPollQueuedMessage = pollQueuedMessage();
                if (objPollQueuedMessage == null) {
                    if (this.readEOS) {
                        AbstractHttp2StreamChannel.this.unsafe.closeForcibly();
                    }
                    flush();
                    return;
                }
                RecvByteBufAllocator.Handle handleRecvBufAllocHandle = recvBufAllocHandle();
                handleRecvBufAllocHandle.reset(AbstractHttp2StreamChannel.this.config());
                boolean z = false;
                while (true) {
                    doRead0((Http2Frame) objPollQueuedMessage, handleRecvBufAllocHandle);
                    if (!this.readEOS) {
                        zContinueReading = handleRecvBufAllocHandle.continueReading();
                        if (!zContinueReading) {
                            break;
                        }
                        z = zContinueReading;
                        objPollQueuedMessage = pollQueuedMessage();
                        if (objPollQueuedMessage != null) {
                        }
                    } else {
                        objPollQueuedMessage = pollQueuedMessage();
                        if (objPollQueuedMessage != null) {
                            zContinueReading = z;
                            break;
                        }
                    }
                }
                if (zContinueReading && AbstractHttp2StreamChannel.this.isParentReadInProgress() && !this.readEOS) {
                    AbstractHttp2StreamChannel.this.maybeAddChannelToReadCompletePendingQueue();
                } else {
                    notifyReadComplete(handleRecvBufAllocHandle, true);
                }
            }
        }

        public void doRead0(Http2Frame http2Frame, RecvByteBufAllocator.Handle handle) {
            int iInitialFlowControlledBytes;
            if (http2Frame instanceof Http2DataFrame) {
                iInitialFlowControlledBytes = ((Http2DataFrame) http2Frame).initialFlowControlledBytes();
                AbstractHttp2StreamChannel.this.flowControlledBytes += iInitialFlowControlledBytes;
            } else {
                iInitialFlowControlledBytes = 9;
            }
            handle.attemptedBytesRead(iInitialFlowControlledBytes);
            handle.lastBytesRead(iInitialFlowControlledBytes);
            handle.incMessagesRead(1);
            AbstractHttp2StreamChannel.this.pipeline().fireChannelRead((Object) http2Frame);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void flush() {
            if (!this.writeDoneAndNoFlush || AbstractHttp2StreamChannel.this.isParentReadInProgress()) {
                return;
            }
            this.writeDoneAndNoFlush = false;
            AbstractHttp2StreamChannel abstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
            abstractHttp2StreamChannel.flush0(abstractHttp2StreamChannel.parentContext());
        }

        @Override // io.netty.channel.Channel.Unsafe
        public SocketAddress localAddress() {
            return AbstractHttp2StreamChannel.this.parent().unsafe().localAddress();
        }

        public void notifyReadComplete(RecvByteBufAllocator.Handle handle, boolean z) {
            if (AbstractHttp2StreamChannel.this.readCompletePending || z) {
                AbstractHttp2StreamChannel.this.readCompletePending = false;
                if (AbstractHttp2StreamChannel.this.readStatus == ReadStatus.REQUESTED) {
                    AbstractHttp2StreamChannel.this.readStatus = ReadStatus.IN_PROGRESS;
                } else {
                    AbstractHttp2StreamChannel.this.readStatus = ReadStatus.IDLE;
                }
                handle.readComplete();
                AbstractHttp2StreamChannel.this.pipeline().fireChannelReadComplete();
                flush();
                if (this.readEOS) {
                    AbstractHttp2StreamChannel.this.unsafe.closeForcibly();
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public ChannelOutboundBuffer outboundBuffer() {
            return null;
        }

        public void readEOS() {
            this.readEOS = true;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public RecvByteBufAllocator.Handle recvBufAllocHandle() {
            if (this.recvHandle == null) {
                RecvByteBufAllocator.Handle handleNewHandle = AbstractHttp2StreamChannel.this.config().getRecvByteBufAllocator().newHandle();
                this.recvHandle = handleNewHandle;
                handleNewHandle.reset(AbstractHttp2StreamChannel.this.config());
            }
            return this.recvHandle;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void register(EventLoop eventLoop, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable()) {
                if (AbstractHttp2StreamChannel.this.registered) {
                    channelPromise.setFailure((Throwable) new UnsupportedOperationException("Re-register is not supported"));
                    return;
                }
                AbstractHttp2StreamChannel.this.registered = true;
                channelPromise.setSuccess();
                AbstractHttp2StreamChannel.this.pipeline().fireChannelRegistered();
                if (AbstractHttp2StreamChannel.this.isActive()) {
                    AbstractHttp2StreamChannel.this.pipeline().fireChannelActive();
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public SocketAddress remoteAddress() {
            return AbstractHttp2StreamChannel.this.parent().unsafe().remoteAddress();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public ChannelPromise voidPromise() {
            return this.unsafeVoidPromise;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void write(Object obj, ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable()) {
                ReferenceCountUtil.release(obj);
                return;
            }
            if (!AbstractHttp2StreamChannel.this.isActive() || (AbstractHttp2StreamChannel.this.outboundClosed && ((obj instanceof Http2HeadersFrame) || (obj instanceof Http2DataFrame)))) {
                ReferenceCountUtil.release(obj);
                channelPromise.setFailure((Throwable) new ClosedChannelException());
                return;
            }
            try {
                if (obj instanceof Http2StreamFrame) {
                    writeHttp2StreamFrame(validateStreamFrame((Http2StreamFrame) obj).stream(AbstractHttp2StreamChannel.this.stream()), channelPromise);
                    return;
                }
                String string = obj.toString();
                ReferenceCountUtil.release(obj);
                channelPromise.setFailure((Throwable) new IllegalArgumentException("Message must be an " + StringUtil.simpleClassName((Class<?>) Http2StreamFrame.class) + ": " + string));
            } catch (Throwable th) {
                channelPromise.tryFailure(th);
            }
        }

        public void close(final ChannelPromise channelPromise, Http2Error http2Error) {
            if (channelPromise.setUncancellable()) {
                if (this.closeInitiated) {
                    if (AbstractHttp2StreamChannel.this.closePromise.isDone()) {
                        channelPromise.setSuccess();
                        return;
                    } else {
                        if (channelPromise instanceof VoidChannelPromise) {
                            return;
                        }
                        AbstractHttp2StreamChannel.this.closePromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.1
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) {
                                channelPromise.setSuccess();
                            }
                        });
                        return;
                    }
                }
                this.closeInitiated = true;
                AbstractHttp2StreamChannel.this.readCompletePending = false;
                boolean zIsActive = AbstractHttp2StreamChannel.this.isActive();
                if (AbstractHttp2StreamChannel.this.parent().isActive() && !this.readEOS && Http2CodecUtil.isStreamIdValid(AbstractHttp2StreamChannel.this.stream.mo13774id())) {
                    write(new DefaultHttp2ResetFrame(http2Error).stream(AbstractHttp2StreamChannel.this.stream()), AbstractHttp2StreamChannel.this.unsafe().voidPromise());
                    flush();
                }
                if (AbstractHttp2StreamChannel.this.inboundBuffer != null) {
                    while (true) {
                        Object objPoll = AbstractHttp2StreamChannel.this.inboundBuffer.poll();
                        if (objPoll == null) {
                            break;
                        } else {
                            ReferenceCountUtil.release(objPoll);
                        }
                    }
                    AbstractHttp2StreamChannel.this.inboundBuffer = null;
                }
                AbstractHttp2StreamChannel.this.outboundClosed = true;
                AbstractHttp2StreamChannel.this.closePromise.setSuccess();
                channelPromise.setSuccess();
                fireChannelInactiveAndDeregister(voidPromise(), zIsActive);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Http2StreamChannelConfig extends DefaultChannelConfig {
        public Http2StreamChannelConfig(Channel channel) {
            super(channel);
        }

        @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public MessageSizeEstimator getMessageSizeEstimator() {
            return FlowControlledFrameSizeEstimator.INSTANCE;
        }

        @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
            if (!(recvByteBufAllocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle)) {
                throw new IllegalArgumentException(AbstractC2322a.m1621k("allocator.newHandle() must return an object of type: ", RecvByteBufAllocator.ExtendedHandle.class));
            }
            super.setRecvByteBufAllocator(recvByteBufAllocator);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ReadStatus {
        IDLE,
        IN_PROGRESS,
        REQUESTED
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UserEventStreamVisitor implements Http2FrameStreamVisitor {
        private final Object event;

        public UserEventStreamVisitor(Object obj) {
            this.event = ObjectUtil.checkNotNull(obj, "event");
        }

        @Override // io.netty.handler.codec.http2.Http2FrameStreamVisitor
        public boolean visit(Http2FrameStream http2FrameStream) {
            ((AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStream).attachment).pipeline().fireUserEventTriggered(this.event);
            return true;
        }
    }

    public AbstractHttp2StreamChannel(Http2FrameCodec.DefaultHttp2FrameStream defaultHttp2FrameStream, int i, ChannelHandler channelHandler) {
        this.stream = defaultHttp2FrameStream;
        defaultHttp2FrameStream.attachment = this;
        DefaultChannelPipeline defaultChannelPipeline = new DefaultChannelPipeline(this) { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.3
            @Override // io.netty.channel.DefaultChannelPipeline
            public void decrementPendingOutboundBytes(long j) {
                AbstractHttp2StreamChannel.this.decrementPendingOutboundBytes(j, true);
            }

            @Override // io.netty.channel.DefaultChannelPipeline
            public void incrementPendingOutboundBytes(long j) {
                AbstractHttp2StreamChannel.this.incrementPendingOutboundBytes(j, true);
            }
        };
        this.pipeline = defaultChannelPipeline;
        this.closePromise = defaultChannelPipeline.newPromise();
        this.channelId = new Http2StreamChannelId(parent().mo13765id(), i);
        if (channelHandler != null) {
            defaultChannelPipeline.addLast(channelHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decrementPendingOutboundBytes(long j, boolean z) {
        if (j != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -j) < config().getWriteBufferLowWaterMark() && parent().isWritable()) {
            setWritable(z);
        }
    }

    private void fireChannelWritabilityChanged(boolean z) {
        final ChannelPipeline channelPipelinePipeline = pipeline();
        if (!z) {
            channelPipelinePipeline.fireChannelWritabilityChanged();
            return;
        }
        Runnable runnable = this.fireChannelWritabilityChangedTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.4
                @Override // java.lang.Runnable
                public void run() {
                    channelPipelinePipeline.fireChannelWritabilityChanged();
                }
            };
            this.fireChannelWritabilityChangedTask = runnable;
        }
        eventLoop().execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void incrementPendingOutboundBytes(long j, boolean z) {
        if (j != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, j) > config().getWriteBufferHighWaterMark()) {
            setUnwritable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeAddChannelToReadCompletePendingQueue() {
        if (this.readCompletePending) {
            return;
        }
        this.readCompletePending = true;
        addChannelToReadCompletePendingQueue();
    }

    private void setUnwritable(boolean z) {
        int i;
        do {
            i = this.unwritable;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, i | 1));
        if (i == 0) {
            fireChannelWritabilityChanged(z);
        }
    }

    private void setWritable(boolean z) {
        int i;
        int i2;
        do {
            i = this.unwritable;
            i2 = i & (-2);
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, i2));
        if (i == 0 || i2 != 0) {
            return;
        }
        fireChannelWritabilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void windowUpdateFrameWriteComplete(ChannelFuture channelFuture, Channel channel) {
        Throwable cause;
        Throwable thCause = channelFuture.cause();
        if (thCause != null) {
            if ((thCause instanceof Http2FrameStreamException) && (cause = thCause.getCause()) != null) {
                thCause = cause;
            }
            channel.pipeline().fireExceptionCaught(thCause);
            channel.unsafe().close(channel.unsafe().voidPromise());
        }
    }

    public abstract void addChannelToReadCompletePendingQueue();

    @Override // io.netty.channel.Channel
    public ByteBufAllocator alloc() {
        return config().getAllocator();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress) {
        return pipeline().bind(socketAddress);
    }

    @Override // io.netty.channel.Channel
    public long bytesBeforeUnwritable() {
        long writeBufferHighWaterMark = (((long) config().getWriteBufferHighWaterMark()) - this.totalPendingSize) + 1;
        if (writeBufferHighWaterMark <= 0 || !isWritable()) {
            return 0L;
        }
        return writeBufferHighWaterMark;
    }

    @Override // io.netty.channel.Channel
    public long bytesBeforeWritable() {
        long writeBufferLowWaterMark = (this.totalPendingSize - ((long) config().getWriteBufferLowWaterMark())) + 1;
        if (writeBufferLowWaterMark <= 0 || isWritable()) {
            return 0L;
        }
        return writeBufferLowWaterMark;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return pipeline().close();
    }

    @Override // io.netty.channel.Channel
    public ChannelFuture closeFuture() {
        return this.closePromise;
    }

    public void closeOutbound() {
        this.outboundClosed = true;
    }

    public final void closeWithError(Http2Error http2Error) {
        Http2ChannelUnsafe http2ChannelUnsafe = this.unsafe;
        http2ChannelUnsafe.close(http2ChannelUnsafe.voidPromise(), http2Error);
    }

    @Override // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress) {
        return pipeline().connect(socketAddress);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister() {
        return pipeline().deregister();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect() {
        return pipeline().disconnect();
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // io.netty.channel.Channel
    public EventLoop eventLoop() {
        return parent().eventLoop();
    }

    public void fireChildRead(Http2Frame http2Frame) {
        if (!isActive()) {
            ReferenceCountUtil.release(http2Frame);
            return;
        }
        if (this.readStatus == ReadStatus.IDLE) {
            if (this.inboundBuffer == null) {
                this.inboundBuffer = new ArrayDeque(4);
            }
            this.inboundBuffer.add(http2Frame);
        } else {
            RecvByteBufAllocator.Handle handleRecvBufAllocHandle = this.unsafe.recvBufAllocHandle();
            this.unsafe.doRead0(http2Frame, handleRecvBufAllocHandle);
            if (handleRecvBufAllocHandle.continueReading()) {
                maybeAddChannelToReadCompletePendingQueue();
            } else {
                this.unsafe.notifyReadComplete(handleRecvBufAllocHandle, true);
            }
        }
    }

    public void fireChildReadComplete() {
        Http2ChannelUnsafe http2ChannelUnsafe = this.unsafe;
        http2ChannelUnsafe.notifyReadComplete(http2ChannelUnsafe.recvBufAllocHandle(), false);
    }

    public void flush0(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.flush();
    }

    public int hashCode() {
        return mo13765id().hashCode();
    }

    @Override // io.netty.channel.Channel
    /* JADX INFO: renamed from: id */
    public ChannelId mo13765id() {
        return this.channelId;
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return isOpen();
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return !this.closePromise.isDone();
    }

    public abstract boolean isParentReadInProgress();

    @Override // io.netty.channel.Channel
    public boolean isRegistered() {
        return this.registered;
    }

    @Override // io.netty.channel.Channel
    public boolean isWritable() {
        return this.unwritable == 0;
    }

    @Override // io.netty.channel.Channel
    public SocketAddress localAddress() {
        return parent().localAddress();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable th) {
        return pipeline().newFailedFuture(th);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelProgressivePromise newProgressivePromise() {
        return pipeline().newProgressivePromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return pipeline().newPromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newSucceededFuture() {
        return pipeline().newSucceededFuture();
    }

    @Override // io.netty.channel.Channel
    public Channel parent() {
        return parentContext().channel();
    }

    public abstract ChannelHandlerContext parentContext();

    @Override // io.netty.channel.Channel
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override // io.netty.channel.Channel
    public SocketAddress remoteAddress() {
        return parent().remoteAddress();
    }

    @Override // io.netty.handler.codec.http2.Http2StreamChannel
    public Http2FrameStream stream() {
        return this.stream;
    }

    public void streamClosed() {
        this.unsafe.readEOS();
        this.unsafe.doBeginRead();
    }

    public String toString() {
        return parent().toString() + "(H2 - " + this.stream + PropertyUtils.MAPPED_DELIM2;
    }

    public final void trySetWritable() {
        if (this.totalPendingSize < config().getWriteBufferLowWaterMark()) {
            setWritable(false);
        }
    }

    @Override // io.netty.channel.Channel
    public Channel.Unsafe unsafe() {
        return this.unsafe;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise voidPromise() {
        return pipeline().voidPromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj) {
        return pipeline().write(obj);
    }

    public ChannelFuture write0(ChannelHandlerContext channelHandlerContext, Object obj) {
        ChannelPromise channelPromiseNewPromise = channelHandlerContext.newPromise();
        channelHandlerContext.write(obj, channelPromiseNewPromise);
        return channelPromiseNewPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        return pipeline().writeAndFlush(obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return pipeline().bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(ChannelPromise channelPromise) {
        return pipeline().close(channelPromise);
    }

    @Override // java.lang.Comparable
    public int compareTo(Channel channel) {
        if (this == channel) {
            return 0;
        }
        return mo13765id().compareTo(channel.mo13765id());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return pipeline().connect(socketAddress, socketAddress2);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister(ChannelPromise channelPromise) {
        return pipeline().deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect(ChannelPromise channelPromise) {
        return pipeline().disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public Channel flush() {
        pipeline().flush();
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public Channel read() {
        pipeline().read();
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        return pipeline().write(obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj) {
        return pipeline().writeAndFlush(obj);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return pipeline().connect(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        return pipeline().connect(socketAddress, socketAddress2, channelPromise);
    }
}
