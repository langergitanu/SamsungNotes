package io.grpc.netty;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.base.Ticker;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2Ping;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.TransportTracer;
import io.grpc.netty.AbstractNettyHandler;
import io.grpc.netty.GrpcHttp2HeadersUtils;
import io.grpc.netty.NettyClientStream;
import io.grpc.netty.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.DecoratingHttp2FrameWriter;
import io.netty.handler.codec.http2.DefaultHttp2Connection;
import io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder;
import io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder;
import io.netty.handler.codec.http2.DefaultHttp2FrameReader;
import io.netty.handler.codec.http2.DefaultHttp2FrameWriter;
import io.netty.handler.codec.http2.DefaultHttp2LocalFlowController;
import io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2ConnectionAdapter;
import io.netty.handler.codec.http2.Http2ConnectionDecoder;
import io.netty.handler.codec.http2.Http2ConnectionEncoder;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2FrameAdapter;
import io.netty.handler.codec.http2.Http2FrameLogger;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2InboundFrameLogger;
import io.netty.handler.codec.http2.Http2OutboundFrameLogger;
import io.netty.handler.codec.http2.Http2Settings;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.Http2StreamVisitor;
import io.netty.handler.codec.http2.StreamBufferingEncoder;
import io.netty.handler.codec.http2.WeightedFairQueueByteDistributor;
import io.netty.handler.logging.LogLevel;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import io.perfmark.TaskCloseable;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class NettyClientHandler extends AbstractNettyHandler {
    private static final long USER_PING_PAYLOAD = 1111;
    private Status abruptGoAwayStatus;
    private Attributes attributes;
    private final String authority;
    private Status channelInactiveReason;
    private WriteQueue clientWriteQueue;
    private final Attributes eagAttributes;
    private final InUseStateAggregator<Http2Stream> inUseState;
    private final KeepAliveManager keepAliveManager;
    private final ClientTransportLifecycleManager lifecycleManager;
    private Http2Ping ping;
    private InternalChannelz.Security securityInfo;
    private final Supplier<Stopwatch> stopwatchFactory;
    private final Http2Connection.PropertyKey streamKey;
    private final TransportTracer transportTracer;
    private static final Logger logger = Logger.getLogger(NettyClientHandler.class.getName());
    static final Object NOOP_MESSAGE = new Object();
    private static final Status EXHAUSTED_STREAMS_STATUS = Status.UNAVAILABLE.withDescription("Stream IDs have been exhausted");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class FrameListener extends Http2FrameAdapter {
        private boolean firstSettings;

        private FrameListener() {
            this.firstSettings = true;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) {
            NettyClientHandler.this.onDataRead(i, byteBuf, i2, z);
            return i2;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i4, boolean z2) {
            NettyClientHandler.this.onHeadersRead(i, http2Headers, z2);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j) {
            Http2Ping http2Ping = NettyClientHandler.this.ping;
            if (j == NettyClientHandler.this.flowControlPing().payload()) {
                NettyClientHandler.this.flowControlPing().updateWindow();
                NettyClientHandler.logger.log(Level.FINE, "Window: {0}", Integer.valueOf(NettyClientHandler.this.decoder().flowController().initialWindowSize(NettyClientHandler.this.connection().connectionStream())));
            } else if (http2Ping == null) {
                NettyClientHandler.logger.warning("Received unexpected ping ack. No ping outstanding");
            } else if (http2Ping.payload() == j) {
                http2Ping.complete();
                NettyClientHandler.this.ping = null;
            } else {
                NettyClientHandler.logger.log(Level.WARNING, "Received unexpected ping ack. Expecting {0}, got {1}", new Object[]{Long.valueOf(http2Ping.payload()), Long.valueOf(j)});
            }
            if (NettyClientHandler.this.keepAliveManager != null) {
                NettyClientHandler.this.keepAliveManager.onDataReceived();
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j) {
            if (NettyClientHandler.this.keepAliveManager != null) {
                NettyClientHandler.this.keepAliveManager.onDataReceived();
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) {
            NettyClientHandler.this.onRstStreamRead(i, j);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) {
            if (this.firstSettings) {
                this.firstSettings = false;
                NettyClientHandler.this.lifecycleManager.notifyReady();
            }
        }
    }

    private NettyClientHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, ChannelLogger channelLogger, ClientTransportLifecycleManager clientTransportLifecycleManager, KeepAliveManager keepAliveManager, Supplier<Stopwatch> supplier, final Runnable runnable, TransportTracer transportTracer, Attributes attributes, String str, boolean z, AbstractNettyHandler.PingLimiter pingLimiter, Ticker ticker) {
        super(null, http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, channelLogger, z, pingLimiter, ticker);
        this.inUseState = new InUseStateAggregator<Http2Stream>() { // from class: io.grpc.netty.NettyClientHandler.1
            @Override // io.grpc.internal.InUseStateAggregator
            public void handleInUse() {
                NettyClientHandler.this.lifecycleManager.notifyInUse(true);
            }

            @Override // io.grpc.internal.InUseStateAggregator
            public void handleNotInUse() {
                NettyClientHandler.this.lifecycleManager.notifyInUse(false);
            }
        };
        this.lifecycleManager = clientTransportLifecycleManager;
        this.keepAliveManager = keepAliveManager;
        this.stopwatchFactory = supplier;
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer);
        this.eagAttributes = attributes;
        this.authority = str;
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, attributes).build();
        decoder().frameListener(new FrameListener());
        Http2Connection http2ConnectionConnection = http2ConnectionEncoder.connection();
        this.streamKey = http2ConnectionConnection.newKey();
        http2ConnectionConnection.addListener(new Http2ConnectionAdapter() { // from class: io.grpc.netty.NettyClientHandler.2
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onGoAwayReceived(int i, long j, ByteBuf byteBuf) {
                byte[] bytes = ByteBufUtil.getBytes(byteBuf);
                NettyClientHandler.this.goingAway(j, bytes);
                if (j == Http2Error.ENHANCE_YOUR_CALM.code()) {
                    String str2 = new String(bytes, CharsetUtil.UTF_8);
                    NettyClientHandler.logger.log(Level.WARNING, "Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: {0}", str2);
                    if ("too_many_pings".equals(str2)) {
                        runnable.run();
                    }
                }
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamActive(Http2Stream http2Stream) {
                if (NettyClientHandler.this.connection().numActiveStreams() != 1 || NettyClientHandler.this.keepAliveManager == null) {
                    return;
                }
                NettyClientHandler.this.keepAliveManager.onTransportActive();
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                NettyClientHandler.this.inUseState.updateObjectInUse(http2Stream, false);
                if (NettyClientHandler.this.connection().numActiveStreams() != 0 || NettyClientHandler.this.keepAliveManager == null) {
                    return;
                }
                NettyClientHandler.this.keepAliveManager.onTransportIdle();
            }
        });
    }

    private void cancelPing(Throwable th) {
        Http2Ping http2Ping = this.ping;
        if (http2Ping != null) {
            http2Ping.failed(th);
            this.ping = null;
        }
    }

    private void cancelStream(ChannelHandlerContext channelHandlerContext, CancelClientStreamCommand cancelClientStreamCommand, ChannelPromise channelPromise) {
        NettyClientStream.TransportState transportStateStream = cancelClientStreamCommand.stream();
        TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyClientHandler.cancelStream");
        try {
            PerfMark.attachTag(transportStateStream.tag());
            PerfMark.linkIn(cancelClientStreamCommand.getLink());
            Status statusReason = cancelClientStreamCommand.reason();
            if (statusReason != null) {
                transportStateStream.transportReportStatus(statusReason, true, new Metadata());
            }
            if (cancelClientStreamCommand.stream().isNonExistent()) {
                channelPromise.setSuccess();
            } else {
                encoder().writeRstStream(channelHandlerContext, transportStateStream.mo13754id(), Http2Error.CANCEL.code(), channelPromise);
            }
            if (taskCloseableTraceTask != null) {
                taskCloseableTraceTask.close();
            }
        } catch (Throwable th) {
            if (taskCloseableTraceTask == null) {
                throw th;
            }
            try {
                taskCloseableTraceTask.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NettyClientStream.TransportState clientStream(Http2Stream http2Stream) {
        if (http2Stream == null) {
            return null;
        }
        return (NettyClientStream.TransportState) http2Stream.getProperty(this.streamKey);
    }

    private void createStream(CreateStreamCommand createStreamCommand, ChannelPromise channelPromise) throws Throwable {
        if (this.lifecycleManager.getShutdownThrowable() != null) {
            createStreamCommand.stream().setNonExistent();
            createStreamCommand.stream().transportReportStatus(this.lifecycleManager.getShutdownStatus(), ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
            channelPromise.setFailure(this.lifecycleManager.getShutdownThrowable());
            return;
        }
        try {
            int iIncrementAndGetNextStreamId = incrementAndGetNextStreamId();
            if (connection().goAwayReceived()) {
                Status statusAugmentDescription = this.abruptGoAwayStatus;
                int iMaxActiveStreams = connection().local().maxActiveStreams();
                int iLastStreamKnownByPeer = connection().local().lastStreamKnownByPeer();
                if (statusAugmentDescription == null) {
                    statusAugmentDescription = Status.INTERNAL.withDescription("Failed due to abrupt GOAWAY, but can't find GOAWAY details");
                } else if (iIncrementAndGetNextStreamId > iLastStreamKnownByPeer) {
                    statusAugmentDescription = statusAugmentDescription.augmentDescription("stream id: " + iIncrementAndGetNextStreamId + ", GOAWAY Last-Stream-ID:" + iLastStreamKnownByPeer);
                } else if (connection().local().numActiveStreams() == iMaxActiveStreams) {
                    statusAugmentDescription = statusAugmentDescription.augmentDescription("At MAX_CONCURRENT_STREAMS limit. limit: " + iMaxActiveStreams);
                }
                if (iIncrementAndGetNextStreamId > iLastStreamKnownByPeer || connection().local().numActiveStreams() == iMaxActiveStreams) {
                    createStreamCommand.stream().setNonExistent();
                    createStreamCommand.stream().transportReportStatus(statusAugmentDescription, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
                    channelPromise.setFailure(statusAugmentDescription.asRuntimeException());
                    return;
                }
            }
            NettyClientStream.TransportState transportStateStream = createStreamCommand.stream();
            Http2Headers http2HeadersHeaders = createStreamCommand.headers();
            transportStateStream.setId(iIncrementAndGetNextStreamId);
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyClientHandler.createStream");
            try {
                PerfMark.linkIn(createStreamCommand.getLink());
                PerfMark.attachTag(transportStateStream.tag());
            } catch (Throwable th) {
                th = th;
            }
            try {
                createStreamTraced(iIncrementAndGetNextStreamId, transportStateStream, http2HeadersHeaders, createStreamCommand.isGet(), createStreamCommand.shouldBeCountedForInUse(), channelPromise);
                if (taskCloseableTraceTask != null) {
                    taskCloseableTraceTask.close();
                }
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                if (taskCloseableTraceTask == null) {
                    throw th3;
                }
                try {
                    taskCloseableTraceTask.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        } catch (StatusException e) {
            createStreamCommand.stream().setNonExistent();
            channelPromise.setFailure((Throwable) e);
            if (connection().goAwaySent()) {
                return;
            }
            logger.fine("Stream IDs have been exhausted for this connection. Initiating graceful shutdown of the connection.");
            this.lifecycleManager.notifyShutdown(e.getStatus());
            close(ctx(), ctx().newPromise());
        }
    }

    private void createStreamTraced(final int i, final NettyClientStream.TransportState transportState, Http2Headers http2Headers, boolean z, final boolean z2, final ChannelPromise channelPromise) {
        encoder().writeHeaders(ctx(), i, http2Headers, 0, z, ctx().newPromise()).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.grpc.netty.NettyClientHandler.4
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                if (channelFuture.isSuccess()) {
                    Http2Stream http2StreamStream = NettyClientHandler.this.connection().stream(i);
                    if (http2StreamStream != null) {
                        transportState.getStatsTraceContext().clientOutboundHeaders();
                        http2StreamStream.setProperty(NettyClientHandler.this.streamKey, transportState);
                        if (z2) {
                            NettyClientHandler.this.inUseState.updateObjectInUse(http2StreamStream, true);
                        }
                        transportState.setHttp2Stream(http2StreamStream);
                    }
                    channelPromise.setSuccess();
                    return;
                }
                Throwable thCause = channelFuture.cause();
                if (thCause instanceof StreamBufferingEncoder.Http2GoAwayException) {
                    StreamBufferingEncoder.Http2GoAwayException http2GoAwayException = (StreamBufferingEncoder.Http2GoAwayException) thCause;
                    Status statusStatusFromH2Error = NettyClientHandler.this.statusFromH2Error(Status.Code.UNAVAILABLE, "GOAWAY closed buffered stream", http2GoAwayException.errorCode(), http2GoAwayException.debugData());
                    StatusRuntimeException statusRuntimeExceptionAsRuntimeException = statusStatusFromH2Error.asRuntimeException();
                    transportState.transportReportStatus(statusStatusFromH2Error, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
                    thCause = statusRuntimeExceptionAsRuntimeException;
                } else if (thCause instanceof StreamBufferingEncoder.Http2ChannelClosedException) {
                    Status shutdownStatus = NettyClientHandler.this.lifecycleManager.getShutdownStatus();
                    if (shutdownStatus == null) {
                        shutdownStatus = Status.UNAVAILABLE.withCause(thCause).withDescription("Connection closed while stream is buffered");
                    }
                    transportState.transportReportStatus(shutdownStatus, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
                }
                channelPromise.setFailure(thCause);
            }
        });
    }

    private void forcefulClose(final ChannelHandlerContext channelHandlerContext, final ForcefulCloseCommand forcefulCloseCommand, ChannelPromise channelPromise) {
        connection().forEachActiveStream(new Http2StreamVisitor() { // from class: io.grpc.netty.NettyClientHandler.6
            @Override // io.netty.handler.codec.http2.Http2StreamVisitor
            public boolean visit(Http2Stream http2Stream) {
                NettyClientStream.TransportState transportStateClientStream = NettyClientHandler.this.clientStream(http2Stream);
                Tag tag = transportStateClientStream != null ? transportStateClientStream.tag() : PerfMark.createTag();
                TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyClientHandler.forcefulClose");
                try {
                    PerfMark.linkIn(forcefulCloseCommand.getLink());
                    PerfMark.attachTag(tag);
                    if (transportStateClientStream != null) {
                        transportStateClientStream.transportReportStatus(forcefulCloseCommand.getStatus(), true, new Metadata());
                        NettyClientHandler.this.resetStream(channelHandlerContext, http2Stream.mo13773id(), Http2Error.CANCEL.code(), channelHandlerContext.newPromise());
                    }
                    http2Stream.close();
                    if (taskCloseableTraceTask != null) {
                        taskCloseableTraceTask.close();
                    }
                    return true;
                } finally {
                }
            }
        });
        close(channelHandlerContext, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goingAway(long j, byte[] bArr) {
        Status.Code code = Status.Code.UNAVAILABLE;
        Status statusStatusFromH2Error = statusFromH2Error(code, "GOAWAY shut down transport", j, bArr);
        this.lifecycleManager.notifyGracefulShutdown(statusStatusFromH2Error);
        this.abruptGoAwayStatus = statusFromH2Error(code, "Abrupt GOAWAY closed unsent stream", j, bArr);
        final Status statusStatusFromH2Error2 = statusFromH2Error(null, "Abrupt GOAWAY closed sent stream", j, bArr);
        final boolean z = j != Http2Error.NO_ERROR.code();
        this.clientWriteQueue.drainNow();
        if (this.lifecycleManager.notifyShutdown(statusStatusFromH2Error)) {
            this.channelInactiveReason = statusFromH2Error(null, "Connection closed after GOAWAY", j, bArr);
        }
        final int iLastStreamKnownByPeer = connection().local().lastStreamKnownByPeer();
        try {
            connection().forEachActiveStream(new Http2StreamVisitor() { // from class: io.grpc.netty.NettyClientHandler.7
                @Override // io.netty.handler.codec.http2.Http2StreamVisitor
                public boolean visit(Http2Stream http2Stream) {
                    if (http2Stream.mo13773id() <= iLastStreamKnownByPeer) {
                        return true;
                    }
                    NettyClientStream.TransportState transportStateClientStream = NettyClientHandler.this.clientStream(http2Stream);
                    if (transportStateClientStream != null) {
                        transportStateClientStream.transportReportStatus(statusStatusFromH2Error2, z ? ClientStreamListener.RpcProgress.PROCESSED : ClientStreamListener.RpcProgress.REFUSED, false, new Metadata());
                    }
                    http2Stream.close();
                    return true;
                }
            });
        } catch (Http2Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void gracefulClose(ChannelHandlerContext channelHandlerContext, GracefulCloseCommand gracefulCloseCommand, ChannelPromise channelPromise) {
        this.lifecycleManager.notifyShutdown(gracefulCloseCommand.getStatus());
        flush(channelHandlerContext);
        close(channelHandlerContext, channelPromise);
    }

    private int incrementAndGetNextStreamId() throws StatusException {
        int iIncrementAndGetNextStreamId = connection().local().incrementAndGetNextStreamId();
        if (iIncrementAndGetNextStreamId >= 0) {
            return iIncrementAndGetNextStreamId;
        }
        logger.fine("Stream IDs have been exhausted for this connection. Initiating graceful shutdown of the connection.");
        throw EXHAUSTED_STREAMS_STATUS.asException();
    }

    public static NettyClientHandler newHandler(ClientTransportLifecycleManager clientTransportLifecycleManager, @Nullable KeepAliveManager keepAliveManager, boolean z, int i, int i2, Supplier<Stopwatch> supplier, Runnable runnable, TransportTracer transportTracer, Attributes attributes, String str, ChannelLogger channelLogger, Ticker ticker) {
        Preconditions.checkArgument(i2 > 0, "maxHeaderListSize must be positive");
        DefaultHttp2FrameReader defaultHttp2FrameReader = new DefaultHttp2FrameReader(new GrpcHttp2HeadersUtils.GrpcHttp2ClientHeadersDecoder(i2));
        DefaultHttp2FrameWriter defaultHttp2FrameWriter = new DefaultHttp2FrameWriter();
        DefaultHttp2Connection defaultHttp2Connection = new DefaultHttp2Connection(false);
        WeightedFairQueueByteDistributor weightedFairQueueByteDistributor = new WeightedFairQueueByteDistributor(defaultHttp2Connection);
        weightedFairQueueByteDistributor.allocationQuantum(16384);
        defaultHttp2Connection.remote().flowController(new DefaultHttp2RemoteFlowController(defaultHttp2Connection, weightedFairQueueByteDistributor));
        return newHandler(defaultHttp2Connection, defaultHttp2FrameReader, defaultHttp2FrameWriter, clientTransportLifecycleManager, keepAliveManager, z, i, i2, supplier, runnable, transportTracer, attributes, str, channelLogger, ticker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataRead(int i, ByteBuf byteBuf, int i2, boolean z) {
        flowControlPing().onDataRead(byteBuf.readableBytes(), i2);
        NettyClientStream.TransportState transportStateClientStream = clientStream(requireHttp2Stream(i));
        PerfMark.event("NettyClientHandler.onDataRead", transportStateClientStream.tag());
        transportStateClientStream.transportDataReceived(byteBuf, z);
        KeepAliveManager keepAliveManager = this.keepAliveManager;
        if (keepAliveManager != null) {
            keepAliveManager.onDataReceived();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHeadersRead(int i, Http2Headers http2Headers, boolean z) {
        if (i != 1) {
            NettyClientStream.TransportState transportStateClientStream = clientStream(requireHttp2Stream(i));
            PerfMark.event("NettyClientHandler.onHeadersRead", transportStateClientStream.tag());
            transportStateClientStream.transportHeadersReceived(http2Headers, z);
        }
        KeepAliveManager keepAliveManager = this.keepAliveManager;
        if (keepAliveManager != null) {
            keepAliveManager.onDataReceived();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRstStreamRead(int i, long j) {
        NettyClientStream.TransportState transportStateClientStream = clientStream(connection().stream(i));
        if (transportStateClientStream != null) {
            PerfMark.event("NettyClientHandler.onRstStreamRead", transportStateClientStream.tag());
            transportStateClientStream.transportReportStatus(statusFromH2Error(null, "RST_STREAM closed stream", j, null), j == Http2Error.REFUSED_STREAM.code() ? ClientStreamListener.RpcProgress.REFUSED : ClientStreamListener.RpcProgress.PROCESSED, false, new Metadata());
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onDataReceived();
            }
        }
    }

    private Http2Stream requireHttp2Stream(int i) {
        Http2Stream http2StreamStream = connection().stream(i);
        if (http2StreamStream != null) {
            return http2StreamStream;
        }
        throw new AssertionError(AbstractC0000a.m11h(i, "Stream does not exist: "));
    }

    private void sendGrpcFrame(ChannelHandlerContext channelHandlerContext, SendGrpcFrameCommand sendGrpcFrameCommand, ChannelPromise channelPromise) {
        TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyClientHandler.sendGrpcFrame");
        try {
            PerfMark.attachTag(sendGrpcFrameCommand.stream().tag());
            PerfMark.linkIn(sendGrpcFrameCommand.getLink());
            encoder().writeData(channelHandlerContext, sendGrpcFrameCommand.stream().mo13754id(), sendGrpcFrameCommand.content(), 0, sendGrpcFrameCommand.endStream(), channelPromise);
            if (taskCloseableTraceTask != null) {
                taskCloseableTraceTask.close();
            }
        } catch (Throwable th) {
            if (taskCloseableTraceTask == null) {
                throw th;
            }
            try {
                taskCloseableTraceTask.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    private void sendPingFrame(ChannelHandlerContext channelHandlerContext, SendPingCommand sendPingCommand, ChannelPromise channelPromise) {
        TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyClientHandler.sendPingFrame");
        try {
            PerfMark.linkIn(sendPingCommand.getLink());
            sendPingFrameTraced(channelHandlerContext, sendPingCommand, channelPromise);
            if (taskCloseableTraceTask != null) {
                taskCloseableTraceTask.close();
            }
        } catch (Throwable th) {
            if (taskCloseableTraceTask != null) {
                try {
                    taskCloseableTraceTask.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void sendPingFrameTraced(ChannelHandlerContext channelHandlerContext, SendPingCommand sendPingCommand, ChannelPromise channelPromise) {
        ClientTransport.PingCallback pingCallbackCallback = sendPingCommand.callback();
        Executor executor = sendPingCommand.executor();
        if (this.ping != null) {
            channelPromise.setSuccess();
            this.ping.addCallback(pingCallbackCallback, executor);
            return;
        }
        channelPromise.setSuccess();
        ChannelPromise channelPromiseNewPromise = ctx().newPromise();
        Stopwatch stopwatch = this.stopwatchFactory.get();
        stopwatch.start();
        Http2Ping http2Ping = new Http2Ping(USER_PING_PAYLOAD, stopwatch);
        this.ping = http2Ping;
        http2Ping.addCallback(pingCallbackCallback, executor);
        encoder().writePing(channelHandlerContext, false, USER_PING_PAYLOAD, channelPromiseNewPromise);
        channelHandlerContext.flush();
        final Http2Ping http2Ping2 = this.ping;
        channelPromiseNewPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.grpc.netty.NettyClientHandler.5
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                if (channelFuture.isSuccess()) {
                    NettyClientHandler.this.transportTracer.reportKeepAliveSent();
                    return;
                }
                Throwable thCause = channelFuture.cause();
                if ((thCause instanceof ClosedChannelException) && (thCause = NettyClientHandler.this.lifecycleManager.getShutdownThrowable()) == null) {
                    thCause = Status.UNKNOWN.withDescription("Ping failed but for unknown reason.").withCause(channelFuture.cause()).asException();
                }
                http2Ping2.failed(thCause);
                if (NettyClientHandler.this.ping == http2Ping2) {
                    NettyClientHandler.this.ping = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Status statusFromH2Error(Status.Code code, String str, long j, byte[] bArr) {
        Status statusStatusForCode = GrpcUtil.Http2Error.statusForCode(j);
        if (code == null) {
            code = statusStatusForCode.getCode();
        }
        String strConcat = (bArr == null || bArr.length <= 0) ? "" : ", debug data: ".concat(new String(bArr, CharsetUtil.UTF_8));
        Status status = code.toStatus();
        StringBuilder sbM781w = AbstractC0541b.m781w(str, ". ");
        sbM781w.append(statusStatusForCode.getDescription());
        sbM781w.append(strConcat);
        return status.withDescription(sbM781w.toString());
    }

    public static void writeBufferingAndRemove(Channel channel) {
        ObjectUtil.checkNotNull(channel, NetworkConfig.CLIENTS_CHANNEL);
        ChannelHandlerContext channelHandlerContextContext = channel.pipeline().context(WriteBufferingAndExceptionHandler.class);
        if (channelHandlerContextContext == null) {
            return;
        }
        ((WriteBufferingAndExceptionHandler) channelHandlerContextContext.handler()).writeBufferedAndRemove(channelHandlerContextContext);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        try {
            logger.fine("Network channel is closed");
            Status statusWithDescription = Status.UNAVAILABLE.withDescription("Network closed for unknown reason");
            this.lifecycleManager.notifyShutdown(statusWithDescription);
            final Status shutdownStatus = this.channelInactiveReason;
            if (shutdownStatus == null) {
                shutdownStatus = this.lifecycleManager.getShutdownStatus();
            }
            try {
                cancelPing(this.lifecycleManager.getShutdownThrowable());
                connection().forEachActiveStream(new Http2StreamVisitor() { // from class: io.grpc.netty.NettyClientHandler.3
                    @Override // io.netty.handler.codec.http2.Http2StreamVisitor
                    public boolean visit(Http2Stream http2Stream) {
                        NettyClientStream.TransportState transportStateClientStream = NettyClientHandler.this.clientStream(http2Stream);
                        if (transportStateClientStream == null) {
                            return true;
                        }
                        transportStateClientStream.transportReportStatus(shutdownStatus, false, new Metadata());
                        return true;
                    }
                });
            } finally {
                this.lifecycleManager.notifyTerminated(statusWithDescription);
            }
        } finally {
            super.channelInactive(channelHandlerContext);
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportTermination();
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        logger.fine("Network channel being closed by the application.");
        if (channelHandlerContext.channel().isActive()) {
            this.lifecycleManager.notifyShutdown(Status.UNAVAILABLE.withDescription("Transport closed for unknown reason"));
        }
        super.close(channelHandlerContext, channelPromise);
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.netty.GrpcHttp2ConnectionHandler
    public String getAuthority() {
        return this.authority;
    }

    @Override // io.grpc.netty.GrpcHttp2ConnectionHandler
    public Attributes getEagAttributes() {
        return this.eagAttributes;
    }

    public ClientTransportLifecycleManager getLifecycleManager() {
        return this.lifecycleManager;
    }

    public InternalChannelz.Security getSecurityInfo() {
        return this.securityInfo;
    }

    public WriteQueue getWriteQueue() {
        return this.clientWriteQueue;
    }

    @Override // io.grpc.netty.GrpcHttp2ConnectionHandler
    public void handleProtocolNegotiationCompleted(Attributes attributes, InternalChannelz.Security security) {
        this.attributes = this.attributes.toBuilder().setAll(attributes).build();
        this.securityInfo = security;
        super.handleProtocolNegotiationCompleted(attributes, security);
        writeBufferingAndRemove(ctx().channel());
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
    public boolean isGracefulShutdownComplete() {
        return super.isGracefulShutdownComplete() && ((StreamBufferingEncoder) encoder()).numBufferedStreams() == 0;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
    public void onConnectionError(ChannelHandlerContext channelHandlerContext, boolean z, Throwable th, Http2Exception http2Exception) {
        logger.log(Level.FINE, "Caught a connection error", th);
        this.lifecycleManager.notifyShutdown(Utils.statusFromThrowable(th));
        super.onConnectionError(channelHandlerContext, z, th, http2Exception);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
    public void onStreamError(ChannelHandlerContext channelHandlerContext, boolean z, Throwable th, Http2Exception.StreamException streamException) {
        NettyClientStream.TransportState transportStateClientStream = clientStream(connection().stream(streamException.streamId()));
        if (transportStateClientStream != null) {
            transportStateClientStream.transportReportStatus(Utils.statusFromThrowable(th), false, new Metadata());
        } else {
            logger.log(Level.FINE, "Stream error for unknown stream " + streamException.streamId(), th);
        }
        super.onStreamError(channelHandlerContext, z, th, streamException);
    }

    public void returnProcessedBytes(Http2Stream http2Stream, int i) {
        try {
            decoder().flowController().consumeBytes(http2Stream, i);
        } catch (Http2Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void startWriteQueue(Channel channel) {
        this.clientWriteQueue = new WriteQueue(channel);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Throwable {
        if (obj instanceof CreateStreamCommand) {
            createStream((CreateStreamCommand) obj, channelPromise);
            return;
        }
        if (obj instanceof SendGrpcFrameCommand) {
            sendGrpcFrame(channelHandlerContext, (SendGrpcFrameCommand) obj, channelPromise);
            return;
        }
        if (obj instanceof CancelClientStreamCommand) {
            cancelStream(channelHandlerContext, (CancelClientStreamCommand) obj, channelPromise);
            return;
        }
        if (obj instanceof SendPingCommand) {
            sendPingFrame(channelHandlerContext, (SendPingCommand) obj, channelPromise);
            return;
        }
        if (obj instanceof GracefulCloseCommand) {
            gracefulClose(channelHandlerContext, (GracefulCloseCommand) obj, channelPromise);
        } else if (obj instanceof ForcefulCloseCommand) {
            forcefulClose(channelHandlerContext, (ForcefulCloseCommand) obj, channelPromise);
        } else {
            if (obj != NOOP_MESSAGE) {
                throw new AssertionError("Write called for unexpected type: ".concat(obj.getClass().getName()));
            }
            channelHandlerContext.write(Unpooled.EMPTY_BUFFER, channelPromise);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PingCountingFrameWriter extends DecoratingHttp2FrameWriter implements AbstractNettyHandler.PingLimiter {
        private int pingCount;

        public PingCountingFrameWriter(Http2FrameWriter http2FrameWriter) {
            super(http2FrameWriter);
        }

        @Override // io.grpc.netty.AbstractNettyHandler.PingLimiter
        public boolean isPingAllowed() {
            return this.pingCount < 2;
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2DataWriter
        public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z, ChannelPromise channelPromise) {
            if (byteBuf.isReadable()) {
                this.pingCount = 0;
            }
            return super.writeData(channelHandlerContext, i, byteBuf, i2, z, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
            this.pingCount = 0;
            return super.writeHeaders(channelHandlerContext, i, http2Headers, i2, z, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z, long j, ChannelPromise channelPromise) {
            if (!z) {
                this.pingCount++;
            }
            return super.writePing(channelHandlerContext, z, j, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i, int i2, ChannelPromise channelPromise) {
            this.pingCount = 0;
            return super.writeWindowUpdate(channelHandlerContext, i, i2, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i4, boolean z2, ChannelPromise channelPromise) {
            this.pingCount = 0;
            return super.writeHeaders(channelHandlerContext, i, http2Headers, i2, s, z, i4, z2, channelPromise);
        }
    }

    @VisibleForTesting
    public static NettyClientHandler newHandler(Http2Connection http2Connection, Http2FrameReader http2FrameReader, Http2FrameWriter http2FrameWriter, ClientTransportLifecycleManager clientTransportLifecycleManager, KeepAliveManager keepAliveManager, boolean z, int i, int i2, Supplier<Stopwatch> supplier, Runnable runnable, TransportTracer transportTracer, Attributes attributes, String str, ChannelLogger channelLogger, Ticker ticker) {
        Preconditions.checkNotNull(http2Connection, "connection");
        Preconditions.checkNotNull(http2FrameReader, "frameReader");
        Preconditions.checkNotNull(clientTransportLifecycleManager, "lifecycleManager");
        Preconditions.checkArgument(i > 0, "flowControlWindow must be positive");
        Preconditions.checkArgument(i2 > 0, "maxHeaderListSize must be positive");
        Preconditions.checkNotNull(supplier, "stopwatchFactory");
        Preconditions.checkNotNull(runnable, "tooManyPingsRunnable");
        Preconditions.checkNotNull(attributes, "eagAttributes");
        Preconditions.checkNotNull(str, "authority");
        Http2FrameLogger http2FrameLogger = new Http2FrameLogger(LogLevel.DEBUG, (Class<?>) NettyClientHandler.class);
        Http2InboundFrameLogger http2InboundFrameLogger = new Http2InboundFrameLogger(http2FrameReader, http2FrameLogger);
        PingCountingFrameWriter pingCountingFrameWriter = new PingCountingFrameWriter(new Http2OutboundFrameLogger(http2FrameWriter, http2FrameLogger));
        StreamBufferingEncoder streamBufferingEncoder = new StreamBufferingEncoder(new DefaultHttp2ConnectionEncoder(http2Connection, pingCountingFrameWriter));
        http2Connection.local().flowController(new DefaultHttp2LocalFlowController(http2Connection, 0.5f, true));
        DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = new DefaultHttp2ConnectionDecoder(http2Connection, streamBufferingEncoder, http2InboundFrameLogger);
        transportTracer.setFlowControlWindowReader(new Utils.FlowControlReader(http2Connection));
        Http2Settings http2Settings = new Http2Settings();
        http2Settings.pushEnabled(false);
        http2Settings.initialWindowSize(i);
        http2Settings.maxConcurrentStreams(0L);
        http2Settings.maxHeaderListSize(i2);
        return new NettyClientHandler(defaultHttp2ConnectionDecoder, streamBufferingEncoder, http2Settings, channelLogger, clientTransportLifecycleManager, keepAliveManager, supplier, runnable, transportTracer, attributes, str, z, pingCountingFrameWriter, ticker);
    }
}
