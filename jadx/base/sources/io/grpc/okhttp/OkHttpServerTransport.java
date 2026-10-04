package io.grpc.okhttp;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.api.client.http.HttpMethods;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import cz.msebera.android.httpclient.HttpStatus;
import io.grpc.Attributes;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.KeepAliveEnforcer;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.LogExceptionRunnable;
import io.grpc.internal.MaxConnectionIdleManager;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.HandshakerSocketFactory;
import io.grpc.okhttp.OkHttpFrameLogger;
import io.grpc.okhttp.OkHttpServerStream;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import io.grpc.okhttp.internal.framed.Variant;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class OkHttpServerTransport implements ServerTransport, ExceptionHandlingFrameWriter.TransportExceptionHandler, OutboundFlowController.Transport {
    private static final int GRACEFUL_SHUTDOWN_PING = 4369;
    private static final int KEEPALIVE_PING = 57005;

    @GuardedBy("lock")
    private boolean abruptShutdown;
    private Attributes attributes;
    private final Socket bareSocket;
    private final Config config;

    @GuardedBy("lock")
    private ScheduledFuture<?> forcefulCloseTimer;

    @GuardedBy("lock")
    private ExceptionHandlingFrameWriter frameWriter;

    @GuardedBy("lock")
    private Status goAwayStatus;

    @GuardedBy("lock")
    private boolean gracefulShutdown;

    @GuardedBy("lock")
    private boolean handshakeShutdown;
    private final KeepAliveEnforcer keepAliveEnforcer;
    private KeepAliveManager keepAliveManager;

    @GuardedBy("lock")
    private int lastStreamId;
    private ServerTransportListener listener;
    private final InternalLogId logId;
    private ScheduledFuture<?> maxConnectionAgeMonitor;
    private MaxConnectionIdleManager maxConnectionIdleManager;

    @GuardedBy("lock")
    private OutboundFlowController outboundFlow;
    private ScheduledExecutorService scheduledExecutorService;

    @GuardedBy("lock")
    private ScheduledFuture<?> secondGoawayTimer;

    @GuardedBy("lock")
    private InternalChannelz.Security securityInfo;
    private final TransportTracer tracer;
    private Executor transportExecutor;
    private static final Logger log = Logger.getLogger(OkHttpServerTransport.class.getName());
    private static final ByteString HTTP_METHOD = ByteString.encodeUtf8(Header.TARGET_METHOD_UTF8);
    private static final ByteString CONNECT_METHOD = ByteString.encodeUtf8(HttpMethods.CONNECT);
    private static final ByteString POST_METHOD = ByteString.encodeUtf8("POST");
    private static final ByteString SCHEME = ByteString.encodeUtf8(Header.TARGET_SCHEME_UTF8);
    private static final ByteString PATH = ByteString.encodeUtf8(Header.TARGET_PATH_UTF8);
    private static final ByteString AUTHORITY = ByteString.encodeUtf8(Header.TARGET_AUTHORITY_UTF8);
    private static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
    private static final ByteString HOST = ByteString.encodeUtf8("host");

    /* JADX INFO: renamed from: TE */
    private static final ByteString f8845TE = ByteString.encodeUtf8("te");
    private static final ByteString TE_TRAILERS = ByteString.encodeUtf8("trailers");
    private static final ByteString CONTENT_TYPE = ByteString.encodeUtf8("content-type");
    private static final ByteString CONTENT_LENGTH = ByteString.encodeUtf8("content-length");
    private final Variant variant = new Http2();
    private final Object lock = new Object();

    @GuardedBy("lock")
    private final Map<Integer, StreamState> streams = new TreeMap();

    @GuardedBy("lock")
    private int goAwayStreamId = Integer.MAX_VALUE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Config {
        final int flowControlWindow;
        final HandshakerSocketFactory handshakerSocketFactory;
        final long keepAliveTimeNanos;
        final long keepAliveTimeoutNanos;
        final long maxConnectionAgeGraceInNanos;
        final long maxConnectionAgeInNanos;
        final long maxConnectionIdleNanos;
        final int maxInboundMessageSize;
        final int maxInboundMetadataSize;
        final long permitKeepAliveTimeInNanos;
        final boolean permitKeepAliveWithoutCalls;
        final ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool;
        final List<? extends ServerStreamTracer.Factory> streamTracerFactories;
        final ObjectPool<Executor> transportExecutorPool;
        final TransportTracer.Factory transportTracerFactory;

        public Config(OkHttpServerBuilder okHttpServerBuilder, List<? extends ServerStreamTracer.Factory> list) {
            this.streamTracerFactories = (List) Preconditions.checkNotNull(list, "streamTracerFactories");
            this.transportExecutorPool = (ObjectPool) Preconditions.checkNotNull(okHttpServerBuilder.transportExecutorPool, "transportExecutorPool");
            this.scheduledExecutorServicePool = (ObjectPool) Preconditions.checkNotNull(okHttpServerBuilder.scheduledExecutorServicePool, "scheduledExecutorServicePool");
            this.transportTracerFactory = (TransportTracer.Factory) Preconditions.checkNotNull(okHttpServerBuilder.transportTracerFactory, "transportTracerFactory");
            this.handshakerSocketFactory = (HandshakerSocketFactory) Preconditions.checkNotNull(okHttpServerBuilder.handshakerSocketFactory, "handshakerSocketFactory");
            this.keepAliveTimeNanos = okHttpServerBuilder.keepAliveTimeNanos;
            this.keepAliveTimeoutNanos = okHttpServerBuilder.keepAliveTimeoutNanos;
            this.flowControlWindow = okHttpServerBuilder.flowControlWindow;
            this.maxInboundMessageSize = okHttpServerBuilder.maxInboundMessageSize;
            this.maxInboundMetadataSize = okHttpServerBuilder.maxInboundMetadataSize;
            this.maxConnectionIdleNanos = okHttpServerBuilder.maxConnectionIdleInNanos;
            this.permitKeepAliveWithoutCalls = okHttpServerBuilder.permitKeepAliveWithoutCalls;
            this.permitKeepAliveTimeInNanos = okHttpServerBuilder.permitKeepAliveTimeInNanos;
            this.maxConnectionAgeInNanos = okHttpServerBuilder.maxConnectionAgeInNanos;
            this.maxConnectionAgeGraceInNanos = okHttpServerBuilder.maxConnectionAgeGraceInNanos;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class KeepAlivePinger implements KeepAliveManager.KeepAlivePinger {
        private KeepAlivePinger() {
        }

        @Override // io.grpc.internal.KeepAliveManager.KeepAlivePinger
        public void onPingTimeout() {
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.goAwayStatus = Status.UNAVAILABLE.withDescription("Keepalive failed. Considering connection dead");
                GrpcUtil.closeQuietly(OkHttpServerTransport.this.bareSocket);
            }
        }

        @Override // io.grpc.internal.KeepAliveManager.KeepAlivePinger
        public void ping() {
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.frameWriter.ping(false, 0, OkHttpServerTransport.KEEPALIVE_PING);
                OkHttpServerTransport.this.frameWriter.flush();
            }
            OkHttpServerTransport.this.tracer.reportKeepAliveSent();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StreamState {
        OutboundFlowController.StreamState getOutboundFlowState();

        boolean hasReceivedEndOfStream();

        void inboundDataReceived(Buffer buffer, int i, boolean z);

        void inboundRstReceived(Status status);

        int inboundWindowAvailable();

        void transportReportStatus(Status status);
    }

    public OkHttpServerTransport(Config config, Socket socket) {
        this.config = (Config) Preconditions.checkNotNull(config, ExternalDataConstants.EmbeddingConfig.KEY);
        this.bareSocket = (Socket) Preconditions.checkNotNull(socket, "bareSocket");
        TransportTracer transportTracerCreate = config.transportTracerFactory.create();
        this.tracer = transportTracerCreate;
        transportTracerCreate.setFlowControlWindowReader(new TransportTracer.FlowControlReader() { // from class: io.grpc.okhttp.d
            @Override // io.grpc.internal.TransportTracer.FlowControlReader
            public final TransportTracer.FlowControlWindows read() {
                return this.f8852a.readFlowControlWindow();
            }
        });
        this.logId = InternalLogId.allocate((Class<?>) OkHttpServerTransport.class, socket.getRemoteSocketAddress().toString());
        this.transportExecutor = config.transportExecutorPool.getObject();
        this.scheduledExecutorService = config.scheduledExecutorServicePool.getObject();
        this.keepAliveEnforcer = new KeepAliveEnforcer(config.permitKeepAliveWithoutCalls, config.permitKeepAliveTimeInNanos, TimeUnit.NANOSECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abruptShutdown(ErrorCode errorCode, String str, Status status, boolean z) {
        synchronized (this.lock) {
            try {
                if (this.abruptShutdown) {
                    return;
                }
                this.abruptShutdown = true;
                this.goAwayStatus = status;
                ScheduledFuture<?> scheduledFuture = this.secondGoawayTimer;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    this.secondGoawayTimer = null;
                }
                for (Map.Entry<Integer, StreamState> entry : this.streams.entrySet()) {
                    if (z) {
                        this.frameWriter.rstStream(entry.getKey().intValue(), ErrorCode.CANCEL);
                    }
                    entry.getValue().transportReportStatus(status);
                }
                this.streams.clear();
                this.frameWriter.goAway(this.lastStreamId, errorCode, str.getBytes(GrpcUtil.US_ASCII));
                this.goAwayStreamId = this.lastStreamId;
                this.frameWriter.close();
                this.forcefulCloseTimer = this.scheduledExecutorService.schedule(new RunnableC12292c(this, 0), 1L, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String asciiString(ByteString byteString) {
        for (int i = 0; i < byteString.size(); i++) {
            if (byteString.getByte(i) >= 128) {
                return byteString.string(GrpcUtil.US_ASCII);
            }
        }
        return byteString.utf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean headerContains(List<io.grpc.okhttp.internal.framed.Header> list, ByteString byteString) {
        return headerFind(list, byteString, 0) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int headerFind(List<io.grpc.okhttp.internal.framed.Header> list, ByteString byteString, int i) {
        while (i < list.size()) {
            if (list.get(i).name.equals(byteString)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString headerGetRequiredSingle(List<io.grpc.okhttp.internal.framed.Header> list, ByteString byteString) {
        int iHeaderFind = headerFind(list, byteString, 0);
        if (iHeaderFind != -1 && headerFind(list, byteString, iHeaderFind + 1) == -1) {
            return list.get(iHeaderFind).value;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void headerRemove(List<io.grpc.okhttp.internal.framed.Header> list, ByteString byteString) {
        int iHeaderFind = 0;
        while (true) {
            iHeaderFind = headerFind(list, byteString, iHeaderFind);
            if (iHeaderFind == -1) {
                return;
            } else {
                list.remove(iHeaderFind);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startIo$1() {
        shutdown(Long.valueOf(this.config.maxConnectionAgeGraceInNanos));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TransportTracer.FlowControlWindows readFlowControlWindow() {
        TransportTracer.FlowControlWindows flowControlWindows;
        synchronized (this.lock) {
            flowControlWindows = new TransportTracer.FlowControlWindows(this.outboundFlow == null ? -1L : r1.windowUpdate(null, 0), (long) (this.config.flowControlWindow * 0.5f));
        }
        return flowControlWindows;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: startIo, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lambda$start$0(SerializingExecutor serializingExecutor) {
        try {
            this.bareSocket.setTcpNoDelay(true);
            HandshakerSocketFactory.HandshakeResult handshakeResultHandshake = this.config.handshakerSocketFactory.handshake(this.bareSocket, Attributes.EMPTY);
            Socket socket = handshakeResultHandshake.socket;
            this.attributes = handshakeResultHandshake.attributes;
            AsyncSink asyncSinkSink = AsyncSink.sink(serializingExecutor, this, 10000);
            asyncSinkSink.becomeConnected(Okio.sink(socket), socket);
            ForwardingFrameWriter forwardingFrameWriter = new ForwardingFrameWriter(asyncSinkSink.limitControlFramesWriter(this.variant.newWriter(Okio.buffer(asyncSinkSink), false))) { // from class: io.grpc.okhttp.OkHttpServerTransport.1
                @Override // io.grpc.okhttp.ForwardingFrameWriter, io.grpc.okhttp.internal.framed.FrameWriter
                public void data(boolean z, int i, Buffer buffer, int i2) {
                    OkHttpServerTransport.this.keepAliveEnforcer.resetCounters();
                    super.data(z, i, buffer, i2);
                }

                @Override // io.grpc.okhttp.ForwardingFrameWriter, io.grpc.okhttp.internal.framed.FrameWriter
                public void headers(int i, List<io.grpc.okhttp.internal.framed.Header> list) {
                    OkHttpServerTransport.this.keepAliveEnforcer.resetCounters();
                    super.headers(i, list);
                }

                @Override // io.grpc.okhttp.ForwardingFrameWriter, io.grpc.okhttp.internal.framed.FrameWriter
                public void synReply(boolean z, int i, List<io.grpc.okhttp.internal.framed.Header> list) {
                    OkHttpServerTransport.this.keepAliveEnforcer.resetCounters();
                    super.synReply(z, i, list);
                }
            };
            synchronized (this.lock) {
                try {
                    this.securityInfo = handshakeResultHandshake.securityInfo;
                    ExceptionHandlingFrameWriter exceptionHandlingFrameWriter = new ExceptionHandlingFrameWriter(this, forwardingFrameWriter);
                    this.frameWriter = exceptionHandlingFrameWriter;
                    this.outboundFlow = new OutboundFlowController(this, exceptionHandlingFrameWriter);
                    this.frameWriter.connectionPreface();
                    Settings settings = new Settings();
                    OkHttpSettingsUtil.set(settings, 7, this.config.flowControlWindow);
                    OkHttpSettingsUtil.set(settings, 6, this.config.maxInboundMetadataSize);
                    this.frameWriter.settings(settings);
                    if (this.config.flowControlWindow > 65535) {
                        this.frameWriter.windowUpdate(0, r0 - 65535);
                    }
                    this.frameWriter.flush();
                } finally {
                }
            }
            if (this.config.keepAliveTimeNanos != Long.MAX_VALUE) {
                KeepAlivePinger keepAlivePinger = new KeepAlivePinger();
                ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
                Config config = this.config;
                KeepAliveManager keepAliveManager = new KeepAliveManager(keepAlivePinger, scheduledExecutorService, config.keepAliveTimeNanos, config.keepAliveTimeoutNanos, true);
                this.keepAliveManager = keepAliveManager;
                keepAliveManager.onTransportStarted();
            }
            if (this.config.maxConnectionIdleNanos != Long.MAX_VALUE) {
                MaxConnectionIdleManager maxConnectionIdleManager = new MaxConnectionIdleManager(this.config.maxConnectionIdleNanos);
                this.maxConnectionIdleManager = maxConnectionIdleManager;
                maxConnectionIdleManager.start(new RunnableC12292c(this, 1), this.scheduledExecutorService);
            }
            if (this.config.maxConnectionAgeInNanos != Long.MAX_VALUE) {
                this.maxConnectionAgeMonitor = this.scheduledExecutorService.schedule(new LogExceptionRunnable(new RunnableC12292c(this, 2)), (long) (((Math.random() * 0.2d) + 0.9d) * this.config.maxConnectionAgeInNanos), TimeUnit.NANOSECONDS);
            }
            this.transportExecutor.execute(new FrameHandler(this.variant.newReader(Okio.buffer(Okio.source(socket)), false)));
        } catch (IOException e) {
            e = e;
            synchronized (this.lock) {
                try {
                    if (!this.handshakeShutdown) {
                        log.log(Level.INFO, "Socket failed to handshake", e);
                    }
                } finally {
                }
            }
            GrpcUtil.closeQuietly(this.bareSocket);
            terminated();
        } catch (Error e2) {
            e = e2;
            synchronized (this.lock) {
            }
        } catch (RuntimeException e3) {
            e = e3;
            synchronized (this.lock) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void terminated() {
        synchronized (this.lock) {
            try {
                ScheduledFuture<?> scheduledFuture = this.forcefulCloseTimer;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    this.forcefulCloseTimer = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        KeepAliveManager keepAliveManager = this.keepAliveManager;
        if (keepAliveManager != null) {
            keepAliveManager.onTransportTermination();
        }
        MaxConnectionIdleManager maxConnectionIdleManager = this.maxConnectionIdleManager;
        if (maxConnectionIdleManager != null) {
            maxConnectionIdleManager.onTransportTermination();
        }
        ScheduledFuture<?> scheduledFuture2 = this.maxConnectionAgeMonitor;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
        }
        this.transportExecutor = this.config.transportExecutorPool.returnObject(this.transportExecutor);
        this.scheduledExecutorService = this.config.scheduledExecutorServicePool.returnObject(this.scheduledExecutorService);
        this.listener.transportTerminated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerForcefulClose() {
        GrpcUtil.closeQuietly(this.bareSocket);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerGracefulSecondGoaway() {
        synchronized (this.lock) {
            try {
                ScheduledFuture<?> scheduledFuture = this.secondGoawayTimer;
                if (scheduledFuture == null) {
                    return;
                }
                scheduledFuture.cancel(false);
                this.secondGoawayTimer = null;
                this.frameWriter.goAway(this.lastStreamId, ErrorCode.NO_ERROR, new byte[0]);
                this.goAwayStreamId = this.lastStreamId;
                if (this.streams.isEmpty()) {
                    this.frameWriter.close();
                } else {
                    this.frameWriter.flush();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.okhttp.OutboundFlowController.Transport
    public OutboundFlowController.StreamState[] getActiveStreams() {
        OutboundFlowController.StreamState[] streamStateArr;
        synchronized (this.lock) {
            try {
                streamStateArr = new OutboundFlowController.StreamState[this.streams.size()];
                Iterator<StreamState> it = this.streams.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    streamStateArr[i] = it.next().getOutboundFlowState();
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return streamStateArr;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.internal.ServerTransport
    public ScheduledExecutorService getScheduledExecutorService() {
        return this.scheduledExecutorService;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        ListenableFuture<InternalChannelz.SocketStats> listenableFutureImmediateFuture;
        synchronized (this.lock) {
            listenableFutureImmediateFuture = Futures.immediateFuture(new InternalChannelz.SocketStats(this.tracer.getStats(), this.bareSocket.getLocalSocketAddress(), this.bareSocket.getRemoteSocketAddress(), Utils.getSocketOptions(this.bareSocket), this.securityInfo));
        }
        return listenableFutureImmediateFuture;
    }

    @Override // io.grpc.okhttp.ExceptionHandlingFrameWriter.TransportExceptionHandler
    public void onException(Throwable th) {
        Preconditions.checkNotNull(th, "failureCause");
        abruptShutdown(ErrorCode.INTERNAL_ERROR, "I/O failure", Status.UNAVAILABLE.withCause(th), false);
    }

    @Override // io.grpc.internal.ServerTransport
    public void shutdown() {
        shutdown(Long.valueOf(TimeUnit.SECONDS.toNanos(1L)));
    }

    @Override // io.grpc.internal.ServerTransport, io.grpc.internal.ManagedClientTransport
    public void shutdownNow(Status status) {
        synchronized (this.lock) {
            try {
                if (this.frameWriter != null) {
                    abruptShutdown(ErrorCode.NO_ERROR, "", status, true);
                } else {
                    this.handshakeShutdown = true;
                    GrpcUtil.closeQuietly(this.bareSocket);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void start(ServerTransportListener serverTransportListener) {
        this.listener = (ServerTransportListener) Preconditions.checkNotNull(serverTransportListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SerializingExecutor serializingExecutor = new SerializingExecutor(this.transportExecutor);
        serializingExecutor.execute(new RunnableC12291b(this, serializingExecutor, 1));
    }

    public void streamClosed(int i, boolean z) {
        synchronized (this.lock) {
            try {
                this.streams.remove(Integer.valueOf(i));
                if (this.streams.isEmpty()) {
                    this.keepAliveEnforcer.onTransportIdle();
                    MaxConnectionIdleManager maxConnectionIdleManager = this.maxConnectionIdleManager;
                    if (maxConnectionIdleManager != null) {
                        maxConnectionIdleManager.onTransportIdle();
                    }
                }
                if (this.gracefulShutdown && this.streams.isEmpty()) {
                    this.frameWriter.close();
                } else if (z) {
                    this.frameWriter.flush();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void shutdown(Long l) {
        synchronized (this.lock) {
            try {
                if (!this.gracefulShutdown && !this.abruptShutdown) {
                    this.gracefulShutdown = true;
                    if (this.frameWriter == null) {
                        this.handshakeShutdown = true;
                        GrpcUtil.closeQuietly(this.bareSocket);
                    } else {
                        this.secondGoawayTimer = this.scheduledExecutorService.schedule(new RunnableC12292c(this, 3), l.longValue(), TimeUnit.NANOSECONDS);
                        this.frameWriter.goAway(Integer.MAX_VALUE, ErrorCode.NO_ERROR, new byte[0]);
                        this.frameWriter.ping(false, 0, GRACEFUL_SHUTDOWN_PING);
                        this.frameWriter.flush();
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class FrameHandler implements FrameReader.Handler, Runnable {
        private int connectionUnacknowledgedBytesRead;
        private final OkHttpFrameLogger frameLogger = new OkHttpFrameLogger(Level.FINE, (Class<?>) OkHttpServerTransport.class);
        private final FrameReader frameReader;
        private boolean receivedSettings;

        public FrameHandler(FrameReader frameReader) {
            this.frameReader = frameReader;
        }

        private void connectionError(ErrorCode errorCode, String str) {
            OkHttpServerTransport.this.abruptShutdown(errorCode, str, GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).withDescription("HTTP2 connection error: " + errorCode + " '" + str + "'"), false);
        }

        private int headerBlockSize(List<io.grpc.okhttp.internal.framed.Header> list) {
            long size = 0;
            for (int i = 0; i < list.size(); i++) {
                io.grpc.okhttp.internal.framed.Header header = list.get(i);
                size += (long) (header.value.size() + header.name.size() + 32);
            }
            return (int) Math.min(size, 2147483647L);
        }

        private void respondWithGrpcError(int i, boolean z, Status.Code code, String str) {
            Metadata metadata = new Metadata();
            metadata.put(InternalStatus.CODE_KEY, code.toStatus());
            metadata.put(InternalStatus.MESSAGE_KEY, str);
            List<io.grpc.okhttp.internal.framed.Header> listCreateResponseTrailers = Headers.createResponseTrailers(metadata, false);
            synchronized (OkHttpServerTransport.this.lock) {
                try {
                    OkHttpServerTransport.this.frameWriter.synReply(true, i, listCreateResponseTrailers);
                    if (!z) {
                        OkHttpServerTransport.this.frameWriter.rstStream(i, ErrorCode.NO_ERROR);
                    }
                    OkHttpServerTransport.this.frameWriter.flush();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private void respondWithHttpError(int i, boolean z, int i2, Status.Code code, String str) {
            Metadata metadata = new Metadata();
            metadata.put(InternalStatus.CODE_KEY, code.toStatus());
            metadata.put(InternalStatus.MESSAGE_KEY, str);
            List<io.grpc.okhttp.internal.framed.Header> listCreateHttpResponseHeaders = Headers.createHttpResponseHeaders(i2, "text/plain; charset=utf-8", metadata);
            Buffer bufferWriteUtf8 = new Buffer().writeUtf8(str);
            synchronized (OkHttpServerTransport.this.lock) {
                try {
                    Http2ErrorStreamState http2ErrorStreamState = new Http2ErrorStreamState(i, OkHttpServerTransport.this.lock, OkHttpServerTransport.this.outboundFlow, OkHttpServerTransport.this.config.flowControlWindow);
                    if (OkHttpServerTransport.this.streams.isEmpty()) {
                        OkHttpServerTransport.this.keepAliveEnforcer.onTransportActive();
                        if (OkHttpServerTransport.this.maxConnectionIdleManager != null) {
                            OkHttpServerTransport.this.maxConnectionIdleManager.onTransportActive();
                        }
                    }
                    OkHttpServerTransport.this.streams.put(Integer.valueOf(i), http2ErrorStreamState);
                    if (z) {
                        http2ErrorStreamState.inboundDataReceived(new Buffer(), 0, true);
                    }
                    OkHttpServerTransport.this.frameWriter.headers(i, listCreateHttpResponseHeaders);
                    OkHttpServerTransport.this.outboundFlow.data(true, http2ErrorStreamState.getOutboundFlowState(), bufferWriteUtf8, true);
                    OkHttpServerTransport.this.outboundFlow.notifyWhenNoPendingData(http2ErrorStreamState.getOutboundFlowState(), new RunnableC12291b(this, http2ErrorStreamState, 2));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: rstOkAtEndOfHttpError, reason: merged with bridge method [inline-methods] */
        public void lambda$respondWithHttpError$0(Http2ErrorStreamState http2ErrorStreamState) {
            synchronized (OkHttpServerTransport.this.lock) {
                try {
                    if (!http2ErrorStreamState.hasReceivedEndOfStream()) {
                        OkHttpServerTransport.this.frameWriter.rstStream(http2ErrorStreamState.streamId, ErrorCode.NO_ERROR);
                    }
                    OkHttpServerTransport.this.streamClosed(http2ErrorStreamState.streamId, true);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private void streamError(int i, ErrorCode errorCode, String str) {
            if (errorCode == ErrorCode.PROTOCOL_ERROR) {
                OkHttpServerTransport.log.log(Level.FINE, "Responding with RST_STREAM {0}: {1}", new Object[]{errorCode, str});
            }
            synchronized (OkHttpServerTransport.this.lock) {
                try {
                    OkHttpServerTransport.this.frameWriter.rstStream(i, errorCode);
                    OkHttpServerTransport.this.frameWriter.flush();
                    StreamState streamState = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(i));
                    if (streamState != null) {
                        streamState.transportReportStatus(Status.INTERNAL.withDescription("Responded with RST_STREAM " + errorCode + ": " + str));
                        OkHttpServerTransport.this.streamClosed(i, false);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) {
            this.frameLogger.logData(OkHttpFrameLogger.Direction.INBOUND, i, bufferedSource.getBuffer(), i2, z);
            if (i == 0) {
                connectionError(ErrorCode.PROTOCOL_ERROR, "Stream 0 is reserved for control messages. RFC7540 section 5.1.1");
                return;
            }
            if ((i & 1) == 0) {
                connectionError(ErrorCode.PROTOCOL_ERROR, "Clients cannot open even numbered streams. RFC7540 section 5.1.1");
                return;
            }
            long j = i2;
            bufferedSource.require(j);
            synchronized (OkHttpServerTransport.this.lock) {
                try {
                    StreamState streamState = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(i));
                    if (streamState == null) {
                        bufferedSource.skip(j);
                        streamError(i, ErrorCode.STREAM_CLOSED, "Received data for closed stream");
                        return;
                    }
                    if (streamState.hasReceivedEndOfStream()) {
                        bufferedSource.skip(j);
                        streamError(i, ErrorCode.STREAM_CLOSED, "Received DATA for half-closed (remote) stream. RFC7540 section 5.1");
                        return;
                    }
                    if (streamState.inboundWindowAvailable() < i2) {
                        bufferedSource.skip(j);
                        streamError(i, ErrorCode.FLOW_CONTROL_ERROR, "Received DATA size exceeded window size. RFC7540 section 6.9");
                        return;
                    }
                    Buffer buffer = new Buffer();
                    buffer.write(bufferedSource.getBuffer(), j);
                    streamState.inboundDataReceived(buffer, i2, z);
                    int i4 = this.connectionUnacknowledgedBytesRead + i2;
                    this.connectionUnacknowledgedBytesRead = i4;
                    if (i4 >= OkHttpServerTransport.this.config.flowControlWindow * 0.5f) {
                        synchronized (OkHttpServerTransport.this.lock) {
                            OkHttpServerTransport.this.frameWriter.windowUpdate(0, this.connectionUnacknowledgedBytesRead);
                            OkHttpServerTransport.this.frameWriter.flush();
                        }
                        this.connectionUnacknowledgedBytesRead = 0;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            this.frameLogger.logGoAway(OkHttpFrameLogger.Direction.INBOUND, i, errorCode, byteString);
            Status statusWithDescription = GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).withDescription("Received GOAWAY: " + errorCode + " '" + byteString.utf8() + "'");
            if (!ErrorCode.NO_ERROR.equals(errorCode)) {
                OkHttpServerTransport.log.log(Level.WARNING, "Received GOAWAY: {0} {1}", new Object[]{errorCode, byteString.utf8()});
            }
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.goAwayStatus = statusWithDescription;
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void headers(boolean z, boolean z2, int i, int i2, List<io.grpc.okhttp.internal.framed.Header> list, HeadersMode headersMode) {
            int iHeaderFind;
            this.frameLogger.logHeaders(OkHttpFrameLogger.Direction.INBOUND, i, list, z2);
            if ((i & 1) == 0) {
                connectionError(ErrorCode.PROTOCOL_ERROR, "Clients cannot open even numbered streams. RFC7540 section 5.1.1");
                return;
            }
            synchronized (OkHttpServerTransport.this.lock) {
                try {
                    if (i > OkHttpServerTransport.this.goAwayStreamId) {
                        return;
                    }
                    boolean z3 = i > OkHttpServerTransport.this.lastStreamId;
                    if (z3) {
                        OkHttpServerTransport.this.lastStreamId = i;
                    }
                    int iHeaderBlockSize = headerBlockSize(list);
                    if (iHeaderBlockSize > OkHttpServerTransport.this.config.maxInboundMetadataSize) {
                        Status.Code code = Status.Code.RESOURCE_EXHAUSTED;
                        Locale locale = Locale.US;
                        respondWithHttpError(i, z2, 431, code, AbstractC1038a.m1214o(OkHttpServerTransport.this.config.maxInboundMetadataSize, iHeaderBlockSize, "Request metadata larger than ", ": "));
                        return;
                    }
                    OkHttpServerTransport.headerRemove(list, ByteString.EMPTY);
                    ByteString byteString = null;
                    ByteString byteString2 = null;
                    ByteString byteString3 = null;
                    ByteString byteString4 = null;
                    while (list.size() > 0 && list.get(0).name.getByte(0) == 58) {
                        io.grpc.okhttp.internal.framed.Header headerRemove = list.remove(0);
                        if (OkHttpServerTransport.HTTP_METHOD.equals(headerRemove.name) && byteString == null) {
                            byteString = headerRemove.value;
                        } else if (OkHttpServerTransport.SCHEME.equals(headerRemove.name) && byteString2 == null) {
                            byteString2 = headerRemove.value;
                        } else if (OkHttpServerTransport.PATH.equals(headerRemove.name) && byteString3 == null) {
                            byteString3 = headerRemove.value;
                        } else {
                            if (!OkHttpServerTransport.AUTHORITY.equals(headerRemove.name) || byteString4 != null) {
                                streamError(i, ErrorCode.PROTOCOL_ERROR, "Unexpected pseudo header. RFC7540 section 8.1.2.1");
                                return;
                            }
                            byteString4 = headerRemove.value;
                        }
                    }
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        if (list.get(i4).name.getByte(0) == 58) {
                            streamError(i, ErrorCode.PROTOCOL_ERROR, "Pseudo header not before regular headers. RFC7540 section 8.1.2.1");
                            return;
                        }
                    }
                    if (!OkHttpServerTransport.CONNECT_METHOD.equals(byteString) && z3 && (byteString == null || byteString2 == null || byteString3 == null)) {
                        streamError(i, ErrorCode.PROTOCOL_ERROR, "Missing required pseudo header. RFC7540 section 8.1.2.3");
                        return;
                    }
                    if (OkHttpServerTransport.headerContains(list, OkHttpServerTransport.CONNECTION)) {
                        streamError(i, ErrorCode.PROTOCOL_ERROR, "Connection-specific headers not permitted. RFC7540 section 8.1.2.2");
                        return;
                    }
                    if (!z3) {
                        if (!z2) {
                            streamError(i, ErrorCode.PROTOCOL_ERROR, "Headers disallowed in the middle of the stream. RFC7540 section 8.1");
                            return;
                        }
                        synchronized (OkHttpServerTransport.this.lock) {
                            try {
                                StreamState streamState = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(i));
                                if (streamState == null) {
                                    streamError(i, ErrorCode.STREAM_CLOSED, "Received headers for closed stream");
                                    return;
                                } else if (streamState.hasReceivedEndOfStream()) {
                                    streamError(i, ErrorCode.STREAM_CLOSED, "Received HEADERS for half-closed (remote) stream. RFC7540 section 5.1");
                                    return;
                                } else {
                                    streamState.inboundDataReceived(new Buffer(), 0, true);
                                    return;
                                }
                            } finally {
                            }
                        }
                    }
                    if (byteString4 == null && (iHeaderFind = OkHttpServerTransport.headerFind(list, OkHttpServerTransport.HOST, 0)) != -1) {
                        if (OkHttpServerTransport.headerFind(list, OkHttpServerTransport.HOST, iHeaderFind + 1) != -1) {
                            respondWithHttpError(i, z2, 400, Status.Code.INTERNAL, "Multiple host headers disallowed. RFC7230 section 5.4");
                            return;
                        }
                        byteString4 = list.get(iHeaderFind).value;
                    }
                    ByteString byteString5 = byteString4;
                    OkHttpServerTransport.headerRemove(list, OkHttpServerTransport.HOST);
                    if (byteString3.size() == 0 || byteString3.getByte(0) != 47) {
                        respondWithHttpError(i, z2, 404, Status.Code.UNIMPLEMENTED, "Expected path to start with /: " + OkHttpServerTransport.asciiString(byteString3));
                        return;
                    }
                    String strSubstring = OkHttpServerTransport.asciiString(byteString3).substring(1);
                    ByteString byteStringHeaderGetRequiredSingle = OkHttpServerTransport.headerGetRequiredSingle(list, OkHttpServerTransport.CONTENT_TYPE);
                    if (byteStringHeaderGetRequiredSingle == null) {
                        respondWithHttpError(i, z2, HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, Status.Code.INTERNAL, "Content-Type is missing or duplicated");
                        return;
                    }
                    String strAsciiString = OkHttpServerTransport.asciiString(byteStringHeaderGetRequiredSingle);
                    if (!GrpcUtil.isGrpcContentType(strAsciiString)) {
                        respondWithHttpError(i, z2, HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, Status.Code.INTERNAL, AbstractC0541b.m772n("Content-Type is not supported: ", strAsciiString));
                        return;
                    }
                    if (!OkHttpServerTransport.POST_METHOD.equals(byteString)) {
                        respondWithHttpError(i, z2, 405, Status.Code.INTERNAL, "HTTP Method is not supported: " + OkHttpServerTransport.asciiString(byteString));
                        return;
                    }
                    ByteString byteStringHeaderGetRequiredSingle2 = OkHttpServerTransport.headerGetRequiredSingle(list, OkHttpServerTransport.f8845TE);
                    if (!OkHttpServerTransport.TE_TRAILERS.equals(byteStringHeaderGetRequiredSingle2)) {
                        respondWithGrpcError(i, z2, Status.Code.INTERNAL, AbstractC0541b.m775q("Expected header TE: ", OkHttpServerTransport.asciiString(OkHttpServerTransport.TE_TRAILERS), ", but ", byteStringHeaderGetRequiredSingle2 == null ? "<missing>" : OkHttpServerTransport.asciiString(byteStringHeaderGetRequiredSingle2), " is received. Some intermediate proxy may not support trailers"));
                        return;
                    }
                    OkHttpServerTransport.headerRemove(list, OkHttpServerTransport.CONTENT_LENGTH);
                    Metadata metadataConvertHeaders = Utils.convertHeaders(list);
                    StatsTraceContext statsTraceContextNewServerContext = StatsTraceContext.newServerContext(OkHttpServerTransport.this.config.streamTracerFactories, strSubstring, metadataConvertHeaders);
                    synchronized (OkHttpServerTransport.this.lock) {
                        try {
                            OkHttpServerTransport okHttpServerTransport = OkHttpServerTransport.this;
                            OkHttpServerStream.TransportState transportState = new OkHttpServerStream.TransportState(okHttpServerTransport, i, okHttpServerTransport.config.maxInboundMessageSize, statsTraceContextNewServerContext, OkHttpServerTransport.this.lock, OkHttpServerTransport.this.frameWriter, OkHttpServerTransport.this.outboundFlow, OkHttpServerTransport.this.config.flowControlWindow, OkHttpServerTransport.this.tracer, strSubstring);
                            OkHttpServerStream okHttpServerStream = new OkHttpServerStream(transportState, OkHttpServerTransport.this.attributes, byteString5 == null ? null : OkHttpServerTransport.asciiString(byteString5), statsTraceContextNewServerContext, OkHttpServerTransport.this.tracer);
                            if (OkHttpServerTransport.this.streams.isEmpty()) {
                                OkHttpServerTransport.this.keepAliveEnforcer.onTransportActive();
                                if (OkHttpServerTransport.this.maxConnectionIdleManager != null) {
                                    OkHttpServerTransport.this.maxConnectionIdleManager.onTransportActive();
                                }
                            }
                            OkHttpServerTransport.this.streams.put(Integer.valueOf(i), transportState);
                            OkHttpServerTransport.this.listener.streamCreated(okHttpServerStream, strSubstring, metadataConvertHeaders);
                            transportState.onStreamAllocated();
                            if (z2) {
                                transportState.inboundDataReceived(new Buffer(), 0, z2);
                            }
                        } finally {
                        }
                    }
                } finally {
                }
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ping(boolean z, int i, int i2) {
            if (!OkHttpServerTransport.this.keepAliveEnforcer.pingAcceptable()) {
                OkHttpServerTransport.this.abruptShutdown(ErrorCode.ENHANCE_YOUR_CALM, "too_many_pings", Status.RESOURCE_EXHAUSTED.withDescription("Too many pings from client"), false);
                return;
            }
            long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
            if (!z) {
                this.frameLogger.logPing(OkHttpFrameLogger.Direction.INBOUND, j);
                synchronized (OkHttpServerTransport.this.lock) {
                    OkHttpServerTransport.this.frameWriter.ping(true, i, i2);
                    OkHttpServerTransport.this.frameWriter.flush();
                }
                return;
            }
            this.frameLogger.logPingAck(OkHttpFrameLogger.Direction.INBOUND, j);
            if (57005 == j) {
                return;
            }
            if (4369 == j) {
                OkHttpServerTransport.this.triggerGracefulSecondGoaway();
                return;
            }
            OkHttpServerTransport.log.log(Level.INFO, "Received unexpected ping ack: " + j);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void priority(int i, int i2, int i4, boolean z) {
            this.frameLogger.logPriority(OkHttpFrameLogger.Direction.INBOUND, i, i2, i4, z);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void pushPromise(int i, int i2, List<io.grpc.okhttp.internal.framed.Header> list) {
            this.frameLogger.logPushPromise(OkHttpFrameLogger.Direction.INBOUND, i, i2, list);
            connectionError(ErrorCode.PROTOCOL_ERROR, "PUSH_PROMISE only allowed on peer-initiated streams. RFC7540 section 6.6");
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            this.frameLogger.logRstStream(OkHttpFrameLogger.Direction.INBOUND, i, errorCode);
            if (!ErrorCode.NO_ERROR.equals(errorCode) && !ErrorCode.CANCEL.equals(errorCode) && !ErrorCode.STREAM_CLOSED.equals(errorCode)) {
                OkHttpServerTransport.log.log(Level.INFO, "Received RST_STREAM: " + errorCode);
            }
            Status statusWithDescription = GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).withDescription("RST_STREAM");
            synchronized (OkHttpServerTransport.this.lock) {
                try {
                    StreamState streamState = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(i));
                    if (streamState != null) {
                        streamState.inboundRstReceived(statusWithDescription);
                        OkHttpServerTransport.this.streamClosed(i, false);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            InputStream inputStream;
            Status statusWithDescription;
            InputStream inputStream2;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpServerTransport");
            try {
                try {
                    this.frameReader.readConnectionPreface();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                try {
                    OkHttpServerTransport.log.log(Level.WARNING, "Error decoding HTTP/2 frames", th);
                    OkHttpServerTransport.this.abruptShutdown(ErrorCode.INTERNAL_ERROR, "Error in frame decoder", Status.INTERNAL.withDescription("Error decoding HTTP/2 frames").withCause(th), false);
                    inputStream = OkHttpServerTransport.this.bareSocket.getInputStream();
                } catch (Throwable th2) {
                    try {
                        GrpcUtil.exhaust(OkHttpServerTransport.this.bareSocket.getInputStream());
                    } catch (IOException unused2) {
                    }
                    GrpcUtil.closeQuietly(OkHttpServerTransport.this.bareSocket);
                    OkHttpServerTransport.this.terminated();
                    Thread.currentThread().setName(name);
                    throw th2;
                }
            }
            if (this.frameReader.nextFrame(this)) {
                if (this.receivedSettings) {
                    while (this.frameReader.nextFrame(this)) {
                        if (OkHttpServerTransport.this.keepAliveManager != null) {
                            OkHttpServerTransport.this.keepAliveManager.onDataReceived();
                        }
                    }
                    synchronized (OkHttpServerTransport.this.lock) {
                        statusWithDescription = OkHttpServerTransport.this.goAwayStatus;
                    }
                    if (statusWithDescription == null) {
                        statusWithDescription = Status.UNAVAILABLE.withDescription("TCP connection closed or IOException");
                    }
                    OkHttpServerTransport.this.abruptShutdown(ErrorCode.INTERNAL_ERROR, "I/O failure", statusWithDescription, false);
                    inputStream = OkHttpServerTransport.this.bareSocket.getInputStream();
                    GrpcUtil.exhaust(inputStream);
                } else {
                    connectionError(ErrorCode.PROTOCOL_ERROR, "First HTTP/2 frame must be SETTINGS. RFC7540 section 3.5");
                    inputStream2 = OkHttpServerTransport.this.bareSocket.getInputStream();
                }
                GrpcUtil.closeQuietly(OkHttpServerTransport.this.bareSocket);
                OkHttpServerTransport.this.terminated();
                Thread.currentThread().setName(name);
                return;
            }
            connectionError(ErrorCode.INTERNAL_ERROR, "Failed to read initial SETTINGS");
            inputStream2 = OkHttpServerTransport.this.bareSocket.getInputStream();
            GrpcUtil.exhaust(inputStream2);
            GrpcUtil.closeQuietly(OkHttpServerTransport.this.bareSocket);
            OkHttpServerTransport.this.terminated();
            Thread.currentThread().setName(name);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void settings(boolean z, Settings settings) {
            boolean zInitialOutboundWindowSize;
            this.frameLogger.logSettings(OkHttpFrameLogger.Direction.INBOUND, settings);
            synchronized (OkHttpServerTransport.this.lock) {
                try {
                    if (OkHttpSettingsUtil.isSet(settings, 7)) {
                        zInitialOutboundWindowSize = OkHttpServerTransport.this.outboundFlow.initialOutboundWindowSize(OkHttpSettingsUtil.get(settings, 7));
                    } else {
                        zInitialOutboundWindowSize = false;
                    }
                    OkHttpServerTransport.this.frameWriter.ackSettings(settings);
                    OkHttpServerTransport.this.frameWriter.flush();
                    if (!this.receivedSettings) {
                        this.receivedSettings = true;
                        OkHttpServerTransport okHttpServerTransport = OkHttpServerTransport.this;
                        okHttpServerTransport.attributes = okHttpServerTransport.listener.transportReady(OkHttpServerTransport.this.attributes);
                    }
                    if (zInitialOutboundWindowSize) {
                        OkHttpServerTransport.this.outboundFlow.writeStreams();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void windowUpdate(int i, long j) {
            this.frameLogger.logWindowsUpdate(OkHttpFrameLogger.Direction.INBOUND, i, j);
            synchronized (OkHttpServerTransport.this.lock) {
                try {
                    if (i == 0) {
                        OkHttpServerTransport.this.outboundFlow.windowUpdate(null, (int) j);
                    } else {
                        StreamState streamState = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(i));
                        if (streamState != null) {
                            OkHttpServerTransport.this.outboundFlow.windowUpdate(streamState.getOutboundFlowState(), (int) j);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Http2ErrorStreamState implements StreamState, OutboundFlowController.Stream {
        private final Object lock;
        private final OutboundFlowController.StreamState outboundFlowState;

        @GuardedBy("lock")
        private boolean receivedEndOfStream;
        private final int streamId;

        @GuardedBy("lock")
        private int window;

        public Http2ErrorStreamState(int i, Object obj, OutboundFlowController outboundFlowController, int i2) {
            this.streamId = i;
            this.lock = obj;
            this.outboundFlowState = outboundFlowController.createState(this, i);
            this.window = i2;
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public OutboundFlowController.StreamState getOutboundFlowState() {
            OutboundFlowController.StreamState streamState;
            synchronized (this.lock) {
                streamState = this.outboundFlowState;
            }
            return streamState;
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public boolean hasReceivedEndOfStream() {
            boolean z;
            synchronized (this.lock) {
                z = this.receivedEndOfStream;
            }
            return z;
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public void inboundDataReceived(Buffer buffer, int i, boolean z) {
            synchronized (this.lock) {
                if (z) {
                    try {
                        this.receivedEndOfStream = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.window -= i;
                try {
                    buffer.skip(buffer.size());
                } catch (IOException e) {
                    throw new AssertionError(e);
                }
            }
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public int inboundWindowAvailable() {
            int i;
            synchronized (this.lock) {
                i = this.window;
            }
            return i;
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public void inboundRstReceived(Status status) {
        }

        @Override // io.grpc.okhttp.OutboundFlowController.Stream
        public void onSentBytes(int i) {
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public void transportReportStatus(Status status) {
        }
    }
}
