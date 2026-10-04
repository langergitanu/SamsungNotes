package io.grpc.netty;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Ticker;
import cz.msebera.android.httpclient.HttpStatus;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz;
import io.grpc.InternalMetadata;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.KeepAliveEnforcer;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.LogExceptionRunnable;
import io.grpc.internal.MaxConnectionIdleManager;
import io.grpc.internal.ServerTransportListener;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.netty.GrpcHttp2HeadersUtils;
import io.grpc.netty.NettyServerStream;
import io.grpc.netty.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http2.DecoratingHttp2FrameWriter;
import io.netty.handler.codec.http2.DefaultHttp2Connection;
import io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder;
import io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder;
import io.netty.handler.codec.http2.DefaultHttp2FrameReader;
import io.netty.handler.codec.http2.DefaultHttp2FrameWriter;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
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
import io.netty.handler.codec.http2.WeightedFairQueueByteDistributor;
import io.netty.handler.logging.LogLevel;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GenericFutureListener;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import io.perfmark.TaskCloseable;
import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class NettyServerHandler extends AbstractNettyHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @VisibleForTesting
    static final long GRACEFUL_SHUTDOWN_PING = 40715087873L;
    private static final long KEEPALIVE_PING = 57005;
    private Attributes attributes;
    private Throwable connectionError;
    private final Attributes eagAttributes;

    @CheckForNull
    private GracefulShutdown gracefulShutdown;
    private final KeepAliveEnforcer keepAliveEnforcer;

    @CheckForNull
    private KeepAliveManager keepAliveManager;
    private final long keepAliveTimeInNanos;
    private final long keepAliveTimeoutInNanos;
    private AsciiString lastKnownAuthority;
    private final long maxConnectionAgeGraceInNanos;
    private final long maxConnectionAgeInNanos;

    @CheckForNull
    private ScheduledFuture<?> maxConnectionAgeMonitor;

    @CheckForNull
    private MaxConnectionIdleManager maxConnectionIdleManager;
    private final int maxMessageSize;
    private Attributes negotiationAttributes;
    private InternalChannelz.Security securityInfo;
    private WriteQueue serverWriteQueue;
    private final Http2Connection.PropertyKey streamKey;
    private final List<? extends ServerStreamTracer.Factory> streamTracerFactories;
    private boolean teWarningLogged;
    private final ServerTransportListener transportListener;
    private final TransportTracer transportTracer;
    private static final Logger logger = Logger.getLogger(NettyServerHandler.class.getName());
    private static final long GRACEFUL_SHUTDOWN_PING_TIMEOUT_NANOS = TimeUnit.SECONDS.toNanos(10);
    private static final boolean DISABLE_CONNECTION_HEADER_CHECK = Boolean.parseBoolean(System.getProperty("io.grpc.netty.disableConnectionHeaderCheck", "false"));

    /* JADX INFO: renamed from: io.grpc.netty.NettyServerHandler$7 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C122627 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel;

        static {
            int[] iArr = new int[ChannelLogger.ChannelLogLevel.values().length];
            $SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel = iArr;
            try {
                iArr[ChannelLogger.ChannelLogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel[ChannelLogger.ChannelLogLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class FrameListener extends Http2FrameAdapter {
        private boolean firstSettings;

        private FrameListener() {
            this.firstSettings = true;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
            if (NettyServerHandler.this.keepAliveManager != null) {
                NettyServerHandler.this.keepAliveManager.onDataReceived();
            }
            NettyServerHandler.this.onDataRead(i, byteBuf, i2, z);
            return i2;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i4, boolean z2) throws Http2Exception {
            if (NettyServerHandler.this.keepAliveManager != null) {
                NettyServerHandler.this.keepAliveManager.onDataReceived();
            }
            NettyServerHandler.this.onHeadersRead(channelHandlerContext, i, http2Headers);
            if (z2) {
                NettyServerHandler.this.onDataRead(i, Unpooled.EMPTY_BUFFER, 0, z2);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j) {
            if (NettyServerHandler.this.keepAliveManager != null) {
                NettyServerHandler.this.keepAliveManager.onDataReceived();
            }
            if (j == NettyServerHandler.this.flowControlPing().payload()) {
                NettyServerHandler.this.flowControlPing().updateWindow();
                NettyServerHandler.logger.log(Level.FINE, "Window: {0}", Integer.valueOf(NettyServerHandler.this.decoder().flowController().initialWindowSize(NettyServerHandler.this.connection().connectionStream())));
            } else if (j != NettyServerHandler.GRACEFUL_SHUTDOWN_PING) {
                if (j != NettyServerHandler.KEEPALIVE_PING) {
                    NettyServerHandler.logger.warning("Received unexpected ping ack. No ping outstanding");
                }
            } else if (NettyServerHandler.this.gracefulShutdown == null) {
                NettyServerHandler.logger.warning("Received GRACEFUL_SHUTDOWN_PING Ack but gracefulShutdown is null");
            } else {
                NettyServerHandler.this.gracefulShutdown.secondGoAwayAndClose(channelHandlerContext);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j) {
            if (NettyServerHandler.this.keepAliveManager != null) {
                NettyServerHandler.this.keepAliveManager.onDataReceived();
            }
            if (NettyServerHandler.this.keepAliveEnforcer.pingAcceptable()) {
                return;
            }
            ByteBuf byteBufWriteAscii = ByteBufUtil.writeAscii(channelHandlerContext.alloc(), "too_many_pings");
            NettyServerHandler nettyServerHandler = NettyServerHandler.this;
            nettyServerHandler.goAway(channelHandlerContext, nettyServerHandler.connection().remote().lastStreamCreated(), Http2Error.ENHANCE_YOUR_CALM.code(), byteBufWriteAscii, channelHandlerContext.newPromise());
            try {
                NettyServerHandler.this.forcefulClose(channelHandlerContext, new ForcefulCloseCommand(Status.RESOURCE_EXHAUSTED.withDescription("Too many pings from client")), channelHandlerContext.newPromise());
            } catch (Exception e) {
                NettyServerHandler.this.onError(channelHandlerContext, true, e);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) throws Http2Exception {
            if (NettyServerHandler.this.keepAliveManager != null) {
                NettyServerHandler.this.keepAliveManager.onDataReceived();
            }
            NettyServerHandler.this.onRstStreamRead(i, j);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) {
            if (this.firstSettings) {
                this.firstSettings = false;
                NettyServerHandler nettyServerHandler = NettyServerHandler.this;
                nettyServerHandler.attributes = nettyServerHandler.transportListener.transportReady(NettyServerHandler.this.negotiationAttributes);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class GracefulShutdown {
        String goAwayMessage;

        @CheckForNull
        Long graceTimeInNanos;
        boolean pingAckedOrTimeout;
        Future<?> pingFuture;

        public GracefulShutdown(String str, @Nullable Long l) {
            this.goAwayMessage = str;
            this.graceTimeInNanos = l;
        }

        private long graceTimeOverrideMillis(long j) {
            Long l = this.graceTimeInNanos;
            if (l == null) {
                return j;
            }
            if (l.longValue() == Long.MAX_VALUE) {
                return -1L;
            }
            return TimeUnit.NANOSECONDS.toMillis(this.graceTimeInNanos.longValue());
        }

        public void secondGoAwayAndClose(ChannelHandlerContext channelHandlerContext) {
            if (this.pingAckedOrTimeout) {
                return;
            }
            this.pingAckedOrTimeout = true;
            Preconditions.checkNotNull(this.pingFuture, "pingFuture");
            this.pingFuture.cancel(false);
            NettyServerHandler nettyServerHandler = NettyServerHandler.this;
            nettyServerHandler.goAway(channelHandlerContext, nettyServerHandler.connection().remote().lastStreamCreated(), Http2Error.NO_ERROR.code(), ByteBufUtil.writeAscii(channelHandlerContext.alloc(), this.goAwayMessage), channelHandlerContext.newPromise());
            long jGracefulShutdownTimeoutMillis = NettyServerHandler.this.gracefulShutdownTimeoutMillis();
            try {
                try {
                    NettyServerHandler.this.gracefulShutdownTimeoutMillis(graceTimeOverrideMillis(jGracefulShutdownTimeoutMillis));
                    NettyServerHandler.super.close(channelHandlerContext, channelHandlerContext.newPromise());
                } catch (Exception e) {
                    NettyServerHandler.this.onError(channelHandlerContext, true, e);
                }
                NettyServerHandler.this.gracefulShutdownTimeoutMillis(jGracefulShutdownTimeoutMillis);
            } catch (Throwable th) {
                NettyServerHandler.this.gracefulShutdownTimeoutMillis(jGracefulShutdownTimeoutMillis);
                throw th;
            }
        }

        public void start(final ChannelHandlerContext channelHandlerContext) {
            NettyServerHandler.this.goAway(channelHandlerContext, Integer.MAX_VALUE, Http2Error.NO_ERROR.code(), ByteBufUtil.writeAscii(channelHandlerContext.alloc(), this.goAwayMessage), channelHandlerContext.newPromise());
            this.pingFuture = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.grpc.netty.NettyServerHandler.GracefulShutdown.1
                @Override // java.lang.Runnable
                public void run() {
                    GracefulShutdown.this.secondGoAwayAndClose(channelHandlerContext);
                }
            }, NettyServerHandler.GRACEFUL_SHUTDOWN_PING_TIMEOUT_NANOS, TimeUnit.NANOSECONDS);
            NettyServerHandler.this.encoder().writePing(channelHandlerContext, false, NettyServerHandler.GRACEFUL_SHUTDOWN_PING, channelHandlerContext.newPromise());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class KeepAlivePinger implements KeepAliveManager.KeepAlivePinger {
        final ChannelHandlerContext ctx;

        public KeepAlivePinger(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // io.grpc.internal.KeepAliveManager.KeepAlivePinger
        public void onPingTimeout() {
            try {
                NettyServerHandler.this.forcefulClose(this.ctx, new ForcefulCloseCommand(Status.UNAVAILABLE.withDescription("Keepalive failed. The connection is likely gone")), this.ctx.newPromise());
            } catch (Exception e) {
                try {
                    NettyServerHandler.this.exceptionCaught(this.ctx, e);
                } catch (Exception e2) {
                    Logger logger = NettyServerHandler.logger;
                    Level level = Level.WARNING;
                    logger.log(level, "Exception while propagating exception", (Throwable) e2);
                    NettyServerHandler.logger.log(level, "Original failure", (Throwable) e);
                }
            }
        }

        @Override // io.grpc.internal.KeepAliveManager.KeepAlivePinger
        public void ping() {
            Http2ConnectionEncoder http2ConnectionEncoderEncoder = NettyServerHandler.this.encoder();
            ChannelHandlerContext channelHandlerContext = this.ctx;
            ChannelFuture channelFutureWritePing = http2ConnectionEncoderEncoder.writePing(channelHandlerContext, false, NettyServerHandler.KEEPALIVE_PING, channelHandlerContext.newPromise());
            this.ctx.flush();
            channelFutureWritePing.addListener((GenericFutureListener<? extends io.netty.util.concurrent.Future<? super Void>>) new ChannelFutureListener() { // from class: io.grpc.netty.NettyServerHandler.KeepAlivePinger.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess()) {
                        NettyServerHandler.this.transportTracer.reportKeepAliveSent();
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ServerChannelLogger extends ChannelLogger {
        private static final Logger log = Logger.getLogger(ChannelLogger.class.getName());

        private ServerChannelLogger() {
        }

        @Override // io.grpc.ChannelLogger
        public void log(ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
            log.log(NettyServerHandler.toJavaLogLevel(channelLogLevel), str);
        }

        @Override // io.grpc.ChannelLogger
        public void log(ChannelLogger.ChannelLogLevel channelLogLevel, String str, Object... objArr) {
            log(channelLogLevel, MessageFormat.format(str, objArr));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private NettyServerHandler(ChannelPromise channelPromise, final Http2Connection http2Connection, ServerTransportListener serverTransportListener, List<? extends ServerStreamTracer.Factory> list, TransportTracer transportTracer, Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, int i, long j, long j2, long j3, long j5, long j6, final KeepAliveEnforcer keepAliveEnforcer, boolean z, Attributes attributes, Ticker ticker) {
        super(channelPromise, http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, new ServerChannelLogger(), z, null, ticker);
        final MaxConnectionIdleManager maxConnectionIdleManager = j3 == Long.MAX_VALUE ? null : new MaxConnectionIdleManager(j3);
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.grpc.netty.NettyServerHandler.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamActive(Http2Stream http2Stream) {
                if (http2Connection.numActiveStreams() == 1) {
                    keepAliveEnforcer.onTransportActive();
                    MaxConnectionIdleManager maxConnectionIdleManager2 = maxConnectionIdleManager;
                    if (maxConnectionIdleManager2 != null) {
                        maxConnectionIdleManager2.onTransportActive();
                    }
                }
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                if (http2Connection.numActiveStreams() == 0) {
                    keepAliveEnforcer.onTransportIdle();
                    MaxConnectionIdleManager maxConnectionIdleManager2 = maxConnectionIdleManager;
                    if (maxConnectionIdleManager2 != null) {
                        maxConnectionIdleManager2.onTransportIdle();
                    }
                }
            }
        });
        Preconditions.checkArgument(i >= 0, "maxMessageSize must be non-negative: %s", i);
        this.maxMessageSize = i;
        this.keepAliveTimeInNanos = j;
        this.keepAliveTimeoutInNanos = j2;
        this.maxConnectionIdleManager = maxConnectionIdleManager;
        this.maxConnectionAgeInNanos = j5;
        this.maxConnectionAgeGraceInNanos = j6;
        this.keepAliveEnforcer = (KeepAliveEnforcer) Preconditions.checkNotNull(keepAliveEnforcer, "keepAliveEnforcer");
        this.eagAttributes = (Attributes) Preconditions.checkNotNull(attributes, "eagAttributes");
        this.streamKey = http2ConnectionEncoder.connection().newKey();
        this.transportListener = (ServerTransportListener) Preconditions.checkNotNull(serverTransportListener, "transportListener");
        this.streamTracerFactories = (List) Preconditions.checkNotNull(list, "streamTracerFactories");
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
        decoder().frameListener(new FrameListener());
    }

    private void cancelStream(ChannelHandlerContext channelHandlerContext, CancelServerStreamCommand cancelServerStreamCommand, ChannelPromise channelPromise) {
        TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerHandler.cancelStream");
        try {
            PerfMark.attachTag(cancelServerStreamCommand.stream().tag());
            PerfMark.linkIn(cancelServerStreamCommand.getLink());
            cancelServerStreamCommand.stream().transportReportStatus(cancelServerStreamCommand.reason());
            encoder().writeRstStream(channelHandlerContext, cancelServerStreamCommand.stream().mo13754id(), Http2Error.CANCEL.code(), channelPromise);
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

    private void closeStreamWhenDone(ChannelPromise channelPromise, int i) {
        final NettyServerStream.TransportState transportStateServerStream = serverStream(requireHttp2Stream(i));
        if (transportStateServerStream != null) {
            channelPromise.addListener((GenericFutureListener<? extends io.netty.util.concurrent.Future<? super Void>>) new ChannelFutureListener() { // from class: io.grpc.netty.NettyServerHandler.5
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    transportStateServerStream.complete();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forcefulClose(final ChannelHandlerContext channelHandlerContext, final ForcefulCloseCommand forcefulCloseCommand, ChannelPromise channelPromise) {
        super.close(channelHandlerContext, channelPromise);
        connection().forEachActiveStream(new Http2StreamVisitor() { // from class: io.grpc.netty.NettyServerHandler.6
            @Override // io.netty.handler.codec.http2.Http2StreamVisitor
            public boolean visit(Http2Stream http2Stream) {
                NettyServerStream.TransportState transportStateServerStream = NettyServerHandler.this.serverStream(http2Stream);
                if (transportStateServerStream != null) {
                    TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerHandler.forcefulClose");
                    try {
                        PerfMark.attachTag(transportStateServerStream.tag());
                        PerfMark.linkIn(forcefulCloseCommand.getLink());
                        transportStateServerStream.transportReportStatus(forcefulCloseCommand.getStatus());
                        NettyServerHandler.this.resetStream(channelHandlerContext, http2Stream.mo13773id(), Http2Error.CANCEL.code(), channelHandlerContext.newPromise());
                        if (taskCloseableTraceTask != null) {
                            taskCloseableTraceTask.close();
                        }
                    } finally {
                    }
                }
                http2Stream.close();
                return true;
            }
        });
    }

    private String getOrUpdateAuthority(AsciiString asciiString) {
        if (asciiString == null) {
            return null;
        }
        if (!asciiString.equals(this.lastKnownAuthority)) {
            this.lastKnownAuthority = asciiString;
        }
        return this.lastKnownAuthority.toString();
    }

    private void gracefulClose(ChannelHandlerContext channelHandlerContext, GracefulServerCloseCommand gracefulServerCloseCommand, ChannelPromise channelPromise) {
        if (this.gracefulShutdown == null) {
            GracefulShutdown gracefulShutdown = new GracefulShutdown(gracefulServerCloseCommand.getGoAwayDebugString(), gracefulServerCloseCommand.getGraceTimeUnit() != null ? Long.valueOf(gracefulServerCloseCommand.getGraceTimeUnit().toNanos(gracefulServerCloseCommand.getGraceTime())) : null);
            this.gracefulShutdown = gracefulShutdown;
            gracefulShutdown.start(channelHandlerContext);
        }
        channelPromise.setSuccess();
    }

    public static NettyServerHandler newHandler(ServerTransportListener serverTransportListener, ChannelPromise channelPromise, List<? extends ServerStreamTracer.Factory> list, TransportTracer transportTracer, int i, boolean z, int i2, int i4, int i5, long j, long j2, long j3, long j5, long j6, boolean z2, long j7, Attributes attributes) {
        Preconditions.checkArgument(i4 > 0, "maxHeaderListSize must be positive: %s", i4);
        Http2FrameLogger http2FrameLogger = new Http2FrameLogger(LogLevel.DEBUG, (Class<?>) NettyServerHandler.class);
        return newHandler(channelPromise, new Http2InboundFrameLogger(new DefaultHttp2FrameReader(new GrpcHttp2HeadersUtils.GrpcHttp2ServerHeadersDecoder(i4)), http2FrameLogger), new Http2OutboundFrameLogger(new DefaultHttp2FrameWriter(), http2FrameLogger), serverTransportListener, list, transportTracer, i, z, i2, i4, i5, j, j2, j3, j5, j6, z2, j7, attributes, Ticker.systemTicker());
    }

    private Http2Exception newStreamException(int i, Throwable th) {
        return Http2Exception.streamError(i, Http2Error.INTERNAL_ERROR, th, Strings.nullToEmpty(th.getMessage()), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataRead(int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
        flowControlPing().onDataRead(byteBuf.readableBytes(), i2);
        try {
            NettyServerStream.TransportState transportStateServerStream = serverStream(requireHttp2Stream(i));
            if (transportStateServerStream == null) {
                return;
            }
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerHandler.onDataRead");
            try {
                PerfMark.attachTag(transportStateServerStream.tag());
                transportStateServerStream.inboundDataReceived(byteBuf, z);
                if (taskCloseableTraceTask != null) {
                    taskCloseableTraceTask.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            logger.log(Level.WARNING, "Exception in onDataRead()", th);
            throw newStreamException(i, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers) throws Http2Exception {
        NettyServerHandler nettyServerHandler;
        int i2;
        try {
        } catch (Exception e) {
            e = e;
            nettyServerHandler = this;
            i2 = i;
        }
        if (!DISABLE_CONNECTION_HEADER_CHECK && http2Headers.contains(HttpHeaderNames.CONNECTION)) {
            resetStream(channelHandlerContext, i, Http2Error.PROTOCOL_ERROR.code(), channelHandlerContext.newPromise());
            return;
        }
        if (http2Headers.authority() == null) {
            List<CharSequence> all = http2Headers.getAll(HttpHeaderNames.HOST);
            if (all.size() > 1) {
                respondWithHttpError(channelHandlerContext, i, 400, Status.Code.INTERNAL, "Multiple host headers");
                return;
            } else if (!all.isEmpty()) {
                http2Headers.add(Http2Headers.PseudoHeaderName.AUTHORITY.value(), all.get(0));
            }
        }
        http2Headers.remove(HttpHeaderNames.HOST);
        CharSequence charSequencePath = http2Headers.path();
        if (charSequencePath == null) {
            respondWithHttpError(channelHandlerContext, i, 404, Status.Code.UNIMPLEMENTED, "Expected path but is missing");
            return;
        }
        if (charSequencePath.charAt(0) != '/') {
            respondWithHttpError(channelHandlerContext, i, 404, Status.Code.UNIMPLEMENTED, String.format("Expected path to start with /: %s", charSequencePath));
            return;
        }
        String string = charSequencePath.subSequence(1, charSequencePath.length()).toString();
        CharSequence charSequence = http2Headers.get(Utils.CONTENT_TYPE_HEADER);
        if (charSequence == null) {
            respondWithHttpError(channelHandlerContext, i, HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, Status.Code.INTERNAL, "Content-Type is missing from the request");
            return;
        }
        String string2 = charSequence.toString();
        if (!GrpcUtil.isGrpcContentType(string2)) {
            respondWithHttpError(channelHandlerContext, i, HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, Status.Code.INTERNAL, "Content-Type '" + string2 + "' is not supported");
            return;
        }
        if (Utils.HTTP_METHOD.contentEquals(http2Headers.method())) {
            nettyServerHandler = this;
            i2 = i;
            try {
                if (!nettyServerHandler.teWarningLogged) {
                    AsciiString asciiString = Utils.TE_TRAILERS;
                    AsciiString asciiString2 = Utils.TE_HEADER;
                    if (!asciiString.contentEquals(http2Headers.get(asciiString2))) {
                        logger.warning(String.format("Expected header TE: %s, but %s is received. This means some intermediate proxy may not support trailers", asciiString, http2Headers.get(asciiString2)));
                        nettyServerHandler.teWarningLogged = true;
                    }
                }
                Http2Stream http2StreamRequireHttp2Stream = nettyServerHandler.requireHttp2Stream(i2);
                Metadata metadataConvertHeaders = Utils.convertHeaders(http2Headers);
                StatsTraceContext statsTraceContextNewServerContext = StatsTraceContext.newServerContext(nettyServerHandler.streamTracerFactories, string, metadataConvertHeaders);
                NettyServerStream.TransportState transportState = new NettyServerStream.TransportState(nettyServerHandler, channelHandlerContext.channel().eventLoop(), http2StreamRequireHttp2Stream, nettyServerHandler.maxMessageSize, statsTraceContextNewServerContext, nettyServerHandler.transportTracer, string);
                TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerHandler.onHeadersRead");
                try {
                    PerfMark.attachTag(transportState.tag());
                    nettyServerHandler.transportListener.streamCreated(new NettyServerStream(channelHandlerContext.channel(), transportState, nettyServerHandler.attributes, nettyServerHandler.getOrUpdateAuthority((AsciiString) http2Headers.authority()), statsTraceContextNewServerContext, nettyServerHandler.transportTracer), string, metadataConvertHeaders);
                    transportState.onStreamAllocated();
                    http2StreamRequireHttp2Stream.setProperty(nettyServerHandler.streamKey, transportState);
                    if (taskCloseableTraceTask != null) {
                        taskCloseableTraceTask.close();
                        return;
                    }
                    return;
                } finally {
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            nettyServerHandler = this;
            try {
                nettyServerHandler.respondWithHttpError(channelHandlerContext, i, 405, Status.Code.INTERNAL, String.format("Method '%s' is not supported", http2Headers.method()));
                return;
            } catch (Exception e3) {
                e = e3;
                i2 = i;
            }
        }
        logger.log(Level.WARNING, "Exception in onHeadersRead()", (Throwable) e);
        throw nettyServerHandler.newStreamException(i2, e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRstStreamRead(int i, long j) throws Http2Exception {
        try {
            NettyServerStream.TransportState transportStateServerStream = serverStream(connection().stream(i));
            if (transportStateServerStream != null) {
                TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerHandler.onRstStreamRead");
                try {
                    PerfMark.attachTag(transportStateServerStream.tag());
                    transportStateServerStream.transportReportStatus(Status.CANCELLED.withDescription("RST_STREAM received for code " + j));
                    if (taskCloseableTraceTask != null) {
                        taskCloseableTraceTask.close();
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            logger.log(Level.WARNING, "Exception in onRstStreamRead()", th);
            throw newStreamException(i, th);
        }
    }

    private Http2Stream requireHttp2Stream(int i) {
        Http2Stream http2StreamStream = connection().stream(i);
        if (http2StreamStream != null) {
            return http2StreamStream;
        }
        throw new AssertionError(AbstractC0000a.m11h(i, "Stream does not exist: "));
    }

    private void respondWithHttpError(ChannelHandlerContext channelHandlerContext, int i, int i2, Status.Code code, String str) {
        Metadata metadata = new Metadata();
        metadata.put(InternalStatus.CODE_KEY, code.toStatus());
        metadata.put(InternalStatus.MESSAGE_KEY, str);
        byte[][] bArrSerialize = InternalMetadata.serialize(metadata);
        Http2Headers http2Headers = new DefaultHttp2Headers(true, bArrSerialize.length / 2).status("" + i2).set(Utils.CONTENT_TYPE_HEADER, "text/plain; charset=utf-8");
        for (int i4 = 0; i4 < bArrSerialize.length; i4 += 2) {
            http2Headers.add(new AsciiString(bArrSerialize[i4], false), new AsciiString(bArrSerialize[i4 + 1], false));
        }
        encoder().writeHeaders(channelHandlerContext, i, http2Headers, 0, false, channelHandlerContext.newPromise());
        encoder().writeData(channelHandlerContext, i, ByteBufUtil.writeUtf8(channelHandlerContext.alloc(), str), 0, true, channelHandlerContext.newPromise());
    }

    private void sendGrpcFrame(ChannelHandlerContext channelHandlerContext, SendGrpcFrameCommand sendGrpcFrameCommand, ChannelPromise channelPromise) {
        TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerHandler.sendGrpcFrame");
        try {
            PerfMark.attachTag(sendGrpcFrameCommand.stream().tag());
            PerfMark.linkIn(sendGrpcFrameCommand.getLink());
            if (sendGrpcFrameCommand.endStream()) {
                closeStreamWhenDone(channelPromise, sendGrpcFrameCommand.stream().mo13754id());
            }
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

    private void sendResponseHeaders(ChannelHandlerContext channelHandlerContext, SendResponseHeadersCommand sendResponseHeadersCommand, ChannelPromise channelPromise) throws Throwable {
        TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerHandler.sendResponseHeaders");
        try {
            PerfMark.attachTag(sendResponseHeadersCommand.stream().tag());
            PerfMark.linkIn(sendResponseHeadersCommand.getLink());
            int iMo13754id = sendResponseHeadersCommand.stream().mo13754id();
            if (connection().stream(iMo13754id) == null) {
                try {
                    resetStream(channelHandlerContext, iMo13754id, Http2Error.CANCEL.code(), channelPromise);
                    if (taskCloseableTraceTask != null) {
                        taskCloseableTraceTask.close();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                }
            } else {
                try {
                    if (sendResponseHeadersCommand.endOfStream()) {
                        closeStreamWhenDone(channelPromise, iMo13754id);
                    }
                    encoder().writeHeaders(channelHandlerContext, iMo13754id, sendResponseHeadersCommand.headers(), 0, sendResponseHeadersCommand.endOfStream(), channelPromise);
                    if (taskCloseableTraceTask != null) {
                        taskCloseableTraceTask.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
        Throwable th4 = th;
        if (taskCloseableTraceTask == null) {
            throw th4;
        }
        try {
            taskCloseableTraceTask.close();
            throw th4;
        } catch (Throwable th5) {
            th4.addSuppressed(th5);
            throw th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NettyServerStream.TransportState serverStream(Http2Stream http2Stream) {
        if (http2Stream == null) {
            return null;
        }
        return (NettyServerStream.TransportState) http2Stream.getProperty(this.streamKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Level toJavaLogLevel(ChannelLogger.ChannelLogLevel channelLogLevel) {
        int i = C122627.$SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel[channelLogLevel.ordinal()];
        return i != 1 ? i != 2 ? Level.FINEST : Level.FINER : Level.FINE;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        try {
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportTermination();
            }
            MaxConnectionIdleManager maxConnectionIdleManager = this.maxConnectionIdleManager;
            if (maxConnectionIdleManager != null) {
                maxConnectionIdleManager.onTransportTermination();
            }
            ScheduledFuture<?> scheduledFuture = this.maxConnectionAgeMonitor;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            final Status statusWithDescription = Status.UNAVAILABLE.withDescription("connection terminated for unknown reason");
            connection().forEachActiveStream(new Http2StreamVisitor() { // from class: io.grpc.netty.NettyServerHandler.4
                @Override // io.netty.handler.codec.http2.Http2StreamVisitor
                public boolean visit(Http2Stream http2Stream) {
                    NettyServerStream.TransportState transportStateServerStream = NettyServerHandler.this.serverStream(http2Stream);
                    if (transportStateServerStream == null) {
                        return true;
                    }
                    transportStateServerStream.transportReportStatus(statusWithDescription);
                    return true;
                }
            });
            super.channelInactive(channelHandlerContext);
        } catch (Throwable th) {
            super.channelInactive(channelHandlerContext);
            throw th;
        }
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        gracefulClose(channelHandlerContext, new GracefulServerCloseCommand("app_requested"), channelPromise);
        channelHandlerContext.flush();
    }

    @Nullable
    public Throwable connectionError() {
        return this.connectionError;
    }

    @Override // io.grpc.netty.GrpcHttp2ConnectionHandler
    public Attributes getEagAttributes() {
        return this.eagAttributes;
    }

    @VisibleForTesting
    public KeepAliveManager getKeepAliveManagerForTest() {
        return this.keepAliveManager;
    }

    public InternalChannelz.Security getSecurityInfo() {
        return this.securityInfo;
    }

    public WriteQueue getWriteQueue() {
        return this.serverWriteQueue;
    }

    @Override // io.grpc.netty.GrpcHttp2ConnectionHandler
    public void handleProtocolNegotiationCompleted(Attributes attributes, InternalChannelz.Security security) {
        this.negotiationAttributes = attributes;
        this.securityInfo = security;
        super.handleProtocolNegotiationCompleted(attributes, security);
        NettyClientHandler.writeBufferingAndRemove(ctx().channel());
    }

    @Override // io.grpc.netty.AbstractNettyHandler, io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(final ChannelHandlerContext channelHandlerContext) {
        this.serverWriteQueue = new WriteQueue(channelHandlerContext.channel());
        if (this.maxConnectionAgeInNanos != Long.MAX_VALUE) {
            this.maxConnectionAgeMonitor = channelHandlerContext.executor().schedule((Runnable) new LogExceptionRunnable(new Runnable() { // from class: io.grpc.netty.NettyServerHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    if (NettyServerHandler.this.gracefulShutdown == null) {
                        NettyServerHandler nettyServerHandler = NettyServerHandler.this;
                        nettyServerHandler.gracefulShutdown = nettyServerHandler.new GracefulShutdown("max_age", Long.valueOf(nettyServerHandler.maxConnectionAgeGraceInNanos));
                        NettyServerHandler.this.gracefulShutdown.start(channelHandlerContext);
                        channelHandlerContext.flush();
                    }
                }
            }), this.maxConnectionAgeInNanos, TimeUnit.NANOSECONDS);
        }
        MaxConnectionIdleManager maxConnectionIdleManager = this.maxConnectionIdleManager;
        if (maxConnectionIdleManager != null) {
            maxConnectionIdleManager.start(new Runnable() { // from class: io.grpc.netty.NettyServerHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    if (NettyServerHandler.this.gracefulShutdown == null) {
                        NettyServerHandler nettyServerHandler = NettyServerHandler.this;
                        nettyServerHandler.gracefulShutdown = nettyServerHandler.new GracefulShutdown("max_idle", null);
                        NettyServerHandler.this.gracefulShutdown.start(channelHandlerContext);
                        channelHandlerContext.flush();
                    }
                }
            }, channelHandlerContext.executor());
        }
        if (this.keepAliveTimeInNanos != Long.MAX_VALUE) {
            KeepAliveManager keepAliveManager = new KeepAliveManager(new KeepAlivePinger(channelHandlerContext), channelHandlerContext.executor(), this.keepAliveTimeInNanos, this.keepAliveTimeoutInNanos, true);
            this.keepAliveManager = keepAliveManager;
            keepAliveManager.onTransportStarted();
        }
        this.transportTracer.setFlowControlWindowReader(new Utils.FlowControlReader(encoder().connection()));
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
    public void onConnectionError(ChannelHandlerContext channelHandlerContext, boolean z, Throwable th, Http2Exception http2Exception) {
        logger.log(Level.FINE, "Connection Error", th);
        this.connectionError = th;
        super.onConnectionError(channelHandlerContext, z, th, http2Exception);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
    public void onStreamError(ChannelHandlerContext channelHandlerContext, boolean z, Throwable th, Http2Exception.StreamException streamException) {
        NettyServerStream.TransportState transportStateServerStream = serverStream(connection().stream(Http2Exception.streamId(streamException)));
        Level level = Level.WARNING;
        if (transportStateServerStream == null && streamException.error() == Http2Error.STREAM_CLOSED) {
            level = Level.FINE;
        }
        logger.log(level, "Stream Error", th);
        Tag tag = transportStateServerStream != null ? transportStateServerStream.tag() : PerfMark.createTag();
        TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerHandler.onStreamError");
        try {
            PerfMark.attachTag(tag);
            if (transportStateServerStream != null) {
                transportStateServerStream.transportReportStatus(Utils.statusFromThrowable(th));
            }
            super.onStreamError(channelHandlerContext, z, th, streamException);
            if (taskCloseableTraceTask != null) {
                taskCloseableTraceTask.close();
            }
        } catch (Throwable th2) {
            if (taskCloseableTraceTask != null) {
                try {
                    taskCloseableTraceTask.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public void returnProcessedBytes(Http2Stream http2Stream, int i) {
        try {
            decoder().flowController().consumeBytes(http2Stream, i);
        } catch (Http2Exception e) {
            throw new RuntimeException(e);
        }
    }

    @VisibleForTesting
    public void setKeepAliveManagerForTest(KeepAliveManager keepAliveManager) {
        this.keepAliveManager = keepAliveManager;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Throwable {
        if (obj instanceof SendGrpcFrameCommand) {
            sendGrpcFrame(channelHandlerContext, (SendGrpcFrameCommand) obj, channelPromise);
            return;
        }
        if (obj instanceof SendResponseHeadersCommand) {
            sendResponseHeaders(channelHandlerContext, (SendResponseHeadersCommand) obj, channelPromise);
            return;
        }
        if (obj instanceof CancelServerStreamCommand) {
            cancelStream(channelHandlerContext, (CancelServerStreamCommand) obj, channelPromise);
            return;
        }
        if (obj instanceof GracefulServerCloseCommand) {
            gracefulClose(channelHandlerContext, (GracefulServerCloseCommand) obj, channelPromise);
        } else {
            if (obj instanceof ForcefulCloseCommand) {
                forcefulClose(channelHandlerContext, (ForcefulCloseCommand) obj, channelPromise);
                return;
            }
            AssertionError assertionError = new AssertionError("Write called for unexpected type: ".concat(obj.getClass().getName()));
            ReferenceCountUtil.release(obj);
            channelPromise.setFailure((Throwable) assertionError);
            throw assertionError;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WriteMonitoringFrameWriter extends DecoratingHttp2FrameWriter {
        private final KeepAliveEnforcer keepAliveEnforcer;

        public WriteMonitoringFrameWriter(Http2FrameWriter http2FrameWriter, KeepAliveEnforcer keepAliveEnforcer) {
            super(http2FrameWriter);
            this.keepAliveEnforcer = keepAliveEnforcer;
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2DataWriter
        public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z, ChannelPromise channelPromise) {
            this.keepAliveEnforcer.resetCounters();
            return super.writeData(channelHandlerContext, i, byteBuf, i2, z, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
            this.keepAliveEnforcer.resetCounters();
            return super.writeHeaders(channelHandlerContext, i, http2Headers, i2, z, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i4, boolean z2, ChannelPromise channelPromise) {
            this.keepAliveEnforcer.resetCounters();
            return super.writeHeaders(channelHandlerContext, i, http2Headers, i2, s, z, i4, z2, channelPromise);
        }
    }

    public static NettyServerHandler newHandler(ChannelPromise channelPromise, Http2FrameReader http2FrameReader, Http2FrameWriter http2FrameWriter, ServerTransportListener serverTransportListener, List<? extends ServerStreamTracer.Factory> list, TransportTracer transportTracer, int i, boolean z, int i2, int i4, int i5, long j, long j2, long j3, long j5, long j6, boolean z2, long j7, Attributes attributes, Ticker ticker) {
        Preconditions.checkArgument(i > 0, "maxStreams must be positive: %s", i);
        Preconditions.checkArgument(i2 > 0, "flowControlWindow must be positive: %s", i2);
        Preconditions.checkArgument(i4 > 0, "maxHeaderListSize must be positive: %s", i4);
        Preconditions.checkArgument(i5 > 0, "maxMessageSize must be positive: %s", i5);
        DefaultHttp2Connection defaultHttp2Connection = new DefaultHttp2Connection(true);
        WeightedFairQueueByteDistributor weightedFairQueueByteDistributor = new WeightedFairQueueByteDistributor(defaultHttp2Connection);
        weightedFairQueueByteDistributor.allocationQuantum(16384);
        defaultHttp2Connection.remote().flowController(new DefaultHttp2RemoteFlowController(defaultHttp2Connection, weightedFairQueueByteDistributor));
        KeepAliveEnforcer keepAliveEnforcer = new KeepAliveEnforcer(z2, j7, TimeUnit.NANOSECONDS);
        defaultHttp2Connection.local().flowController(new DefaultHttp2LocalFlowController(defaultHttp2Connection, 0.5f, true));
        Http2ControlFrameLimitEncoder http2ControlFrameLimitEncoder = new Http2ControlFrameLimitEncoder(new DefaultHttp2ConnectionEncoder(defaultHttp2Connection, new WriteMonitoringFrameWriter(http2FrameWriter, keepAliveEnforcer)), 10000);
        DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = new DefaultHttp2ConnectionDecoder(defaultHttp2Connection, http2ControlFrameLimitEncoder, http2FrameReader);
        Http2Settings http2Settings = new Http2Settings();
        http2Settings.initialWindowSize(i2);
        http2Settings.maxConcurrentStreams(i);
        http2Settings.maxHeaderListSize(i4);
        return new NettyServerHandler(channelPromise, defaultHttp2Connection, serverTransportListener, list, transportTracer, defaultHttp2ConnectionDecoder, http2ControlFrameLimitEncoder, http2Settings, i5, j, j2, j3, j5, j6, keepAliveEnforcer, z, attributes, ticker == null ? Ticker.systemTicker() : ticker);
    }
}
