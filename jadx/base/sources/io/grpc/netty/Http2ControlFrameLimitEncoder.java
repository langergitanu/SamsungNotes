package io.grpc.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.DecoratingHttp2ConnectionEncoder;
import io.netty.handler.codec.http2.Http2ConnectionEncoder;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2LifecycleManager;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class Http2ControlFrameLimitEncoder extends DecoratingHttp2ConnectionEncoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Http2ControlFrameLimitEncoder.class);
    private Http2LifecycleManager lifecycleManager;
    private boolean limitReached;
    private final int maxOutstandingControlFrames;
    private int outstandingControlFrames;
    private final ChannelFutureListener outstandingControlFramesListener;

    public Http2ControlFrameLimitEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i) {
        super(http2ConnectionEncoder);
        this.outstandingControlFramesListener = new ChannelFutureListener() { // from class: io.grpc.netty.Http2ControlFrameLimitEncoder.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                Http2ControlFrameLimitEncoder.access$010(Http2ControlFrameLimitEncoder.this);
            }
        };
        this.maxOutstandingControlFrames = ObjectUtil.checkPositive(i, "maxOutstandingControlFrames");
    }

    public static /* synthetic */ int access$010(Http2ControlFrameLimitEncoder http2ControlFrameLimitEncoder) {
        int i = http2ControlFrameLimitEncoder.outstandingControlFrames;
        http2ControlFrameLimitEncoder.outstandingControlFrames = i - 1;
        return i;
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [io.netty.channel.ChannelPromise] */
    private ChannelPromise handleOutstandingControlFrames(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.limitReached) {
            return channelPromise;
        }
        if (this.outstandingControlFrames == this.maxOutstandingControlFrames) {
            channelHandlerContext.flush();
        }
        int i = this.outstandingControlFrames;
        int i2 = this.maxOutstandingControlFrames;
        if (i == i2) {
            this.limitReached = true;
            Http2Exception http2ExceptionConnectionError = Http2Exception.connectionError(Http2Error.ENHANCE_YOUR_CALM, "Maximum number %d of outstanding control frames reached", Integer.valueOf(i2));
            logger.info("Maximum number {} of outstanding control frames reached. Closing channel {}", Integer.valueOf(this.maxOutstandingControlFrames), channelHandlerContext.channel(), http2ExceptionConnectionError);
            this.lifecycleManager.onError(channelHandlerContext, true, http2ExceptionConnectionError);
            channelHandlerContext.close();
        }
        this.outstandingControlFrames++;
        return channelPromise.unvoid().addListener((GenericFutureListener<? extends Future<? super Void>>) this.outstandingControlFramesListener);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2ConnectionEncoder, io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = http2LifecycleManager;
        super.lifecycleManager(http2LifecycleManager);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z, long j, ChannelPromise channelPromise) {
        if (!z) {
            return super.writePing(channelHandlerContext, z, j, channelPromise);
        }
        ChannelPromise channelPromiseHandleOutstandingControlFrames = handleOutstandingControlFrames(channelHandlerContext, channelPromise);
        return channelPromiseHandleOutstandingControlFrames == null ? channelPromise : super.writePing(channelHandlerContext, z, j, channelPromiseHandleOutstandingControlFrames);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        ChannelPromise channelPromiseHandleOutstandingControlFrames = handleOutstandingControlFrames(channelHandlerContext, channelPromise);
        return channelPromiseHandleOutstandingControlFrames == null ? channelPromise : super.writeRstStream(channelHandlerContext, i, j, channelPromiseHandleOutstandingControlFrames);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        ChannelPromise channelPromiseHandleOutstandingControlFrames = handleOutstandingControlFrames(channelHandlerContext, channelPromise);
        return channelPromiseHandleOutstandingControlFrames == null ? channelPromise : super.writeSettingsAck(channelHandlerContext, channelPromiseHandleOutstandingControlFrames);
    }
}
