package io.grpc.okhttp;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Grpc;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2Ping;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.okhttp.OkHttpClientStream;
import io.grpc.okhttp.OkHttpFrameLogger;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.Credentials;
import io.grpc.okhttp.internal.StatusLine;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import io.grpc.okhttp.internal.framed.Variant;
import io.grpc.okhttp.internal.proxy.HttpUrl;
import io.grpc.okhttp.internal.proxy.Request;
import io.perfmark.PerfMark;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import okio.Timeout;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class OkHttpClientTransport implements ConnectionClientTransport, ExceptionHandlingFrameWriter.TransportExceptionHandler, OutboundFlowController.Transport {
    private static final Map<ErrorCode, Status> ERROR_CODE_TO_STATUS = buildErrorCodeToStatusMap();
    private static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
    private final InetSocketAddress address;
    private Attributes attributes;
    private ClientFrameHandler clientFrameHandler;
    SettableFuture<Void> connectedFuture;
    Runnable connectingCallback;
    private final ConnectionSpec connectionSpec;
    private int connectionUnacknowledgedBytesRead;
    private final String defaultAuthority;
    private boolean enableKeepAlive;
    private final Executor executor;

    @GuardedBy("lock")
    private ExceptionHandlingFrameWriter frameWriter;

    @GuardedBy("lock")
    private boolean goAwaySent;

    @GuardedBy("lock")
    private Status goAwayStatus;

    @GuardedBy("lock")
    private boolean hasStream;
    private HostnameVerifier hostnameVerifier;

    @GuardedBy("lock")
    private final InUseStateAggregator<OkHttpClientStream> inUseState;
    private final int initialWindowSize;
    private KeepAliveManager keepAliveManager;
    private long keepAliveTimeNanos;
    private long keepAliveTimeoutNanos;
    private boolean keepAliveWithoutCalls;
    private ManagedClientTransport.Listener listener;
    private final Object lock;
    private final InternalLogId logId;

    @GuardedBy("lock")
    private int maxConcurrentStreams;
    private final int maxInboundMetadataSize;
    private final int maxMessageSize;

    @GuardedBy("lock")
    private int nextStreamId;
    private OutboundFlowController outboundFlow;

    @GuardedBy("lock")
    private final Deque<OkHttpClientStream> pendingStreams;

    @GuardedBy("lock")
    private Http2Ping ping;

    @VisibleForTesting
    @Nullable
    final HttpConnectProxiedSocketAddress proxiedAddr;

    @VisibleForTesting
    int proxySocketTimeout;
    private final Random random;
    private final ScheduledExecutorService scheduler;

    @GuardedBy("lock")
    private InternalChannelz.Security securityInfo;
    private final SerializingExecutor serializingExecutor;
    private Socket socket;
    private final SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;

    @GuardedBy("lock")
    private boolean stopped;
    private final Supplier<Stopwatch> stopwatchFactory;

    @GuardedBy("lock")
    private final Map<Integer, OkHttpClientStream> streams;
    private final Runnable tooManyPingsRunnable;

    @GuardedBy("lock")
    private final TransportTracer transportTracer;
    private final boolean useGetForSafeMethods;
    private final String userAgent;
    private final Variant variant;

    public OkHttpClientTransport(OkHttpChannelBuilder.OkHttpTransportFactory okHttpTransportFactory, InetSocketAddress inetSocketAddress, String str, @Nullable String str2, Attributes attributes, @Nullable HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress, Runnable runnable) {
        this(okHttpTransportFactory, inetSocketAddress, str, str2, attributes, GrpcUtil.STOPWATCH_SUPPLIER, new Http2(), httpConnectProxiedSocketAddress, runnable);
    }

    public static /* synthetic */ int access$2412(OkHttpClientTransport okHttpClientTransport, int i) {
        int i2 = okHttpClientTransport.connectionUnacknowledgedBytesRead + i;
        okHttpClientTransport.connectionUnacknowledgedBytesRead = i2;
        return i2;
    }

    private static Map<ErrorCode, Status> buildErrorCodeToStatusMap() {
        EnumMap enumMap = new EnumMap(ErrorCode.class);
        ErrorCode errorCode = ErrorCode.NO_ERROR;
        Status status = Status.INTERNAL;
        enumMap.put(errorCode, status.withDescription("No error: A GRPC status of OK should have been sent"));
        enumMap.put(ErrorCode.PROTOCOL_ERROR, status.withDescription("Protocol error"));
        enumMap.put(ErrorCode.INTERNAL_ERROR, status.withDescription(IErrors.ERROR_MESSAGE_SMP_0401));
        enumMap.put(ErrorCode.FLOW_CONTROL_ERROR, status.withDescription("Flow control error"));
        enumMap.put(ErrorCode.STREAM_CLOSED, status.withDescription("Stream closed"));
        enumMap.put(ErrorCode.FRAME_TOO_LARGE, status.withDescription("Frame too large"));
        enumMap.put(ErrorCode.REFUSED_STREAM, Status.UNAVAILABLE.withDescription("Refused stream"));
        enumMap.put(ErrorCode.CANCEL, Status.CANCELLED.withDescription("Cancelled"));
        enumMap.put(ErrorCode.COMPRESSION_ERROR, status.withDescription("Compression error"));
        enumMap.put(ErrorCode.CONNECT_ERROR, status.withDescription("Connect error"));
        enumMap.put(ErrorCode.ENHANCE_YOUR_CALM, Status.RESOURCE_EXHAUSTED.withDescription("Enhance your calm"));
        enumMap.put(ErrorCode.INADEQUATE_SECURITY, Status.PERMISSION_DENIED.withDescription("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    private Request createHttpProxyRequest(InetSocketAddress inetSocketAddress, String str, String str2) {
        HttpUrl httpUrlBuild = new HttpUrl.Builder().scheme(AuthenticationConstants.HTTPS_PROTOCOL_STRING).host(inetSocketAddress.getHostName()).port(inetSocketAddress.getPort()).build();
        Request.Builder builderHeader = new Request.Builder().url(httpUrlBuild).header("Host", httpUrlBuild.host() + ":" + httpUrlBuild.port()).header("User-Agent", this.userAgent);
        if (str != null && str2 != null) {
            builderHeader.header("Proxy-Authorization", Credentials.basic(str, str2));
        }
        return builderHeader.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Socket createHttpProxySocket(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws StatusException {
        Socket socketCreateSocket = null;
        try {
            socketCreateSocket = inetSocketAddress2.getAddress() != null ? this.socketFactory.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : this.socketFactory.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            socketCreateSocket.setTcpNoDelay(true);
            socketCreateSocket.setSoTimeout(this.proxySocketTimeout);
            Source source = Okio.source(socketCreateSocket);
            BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(socketCreateSocket));
            Request requestCreateHttpProxyRequest = createHttpProxyRequest(inetSocketAddress, str, str2);
            HttpUrl httpUrl = requestCreateHttpProxyRequest.httpUrl();
            Locale locale = Locale.US;
            bufferedSinkBuffer.writeUtf8("CONNECT " + httpUrl.host() + ":" + httpUrl.port() + " HTTP/1.1").writeUtf8("\r\n");
            int size = requestCreateHttpProxyRequest.headers().size();
            for (int i = 0; i < size; i++) {
                bufferedSinkBuffer.writeUtf8(requestCreateHttpProxyRequest.headers().name(i)).writeUtf8(": ").writeUtf8(requestCreateHttpProxyRequest.headers().value(i)).writeUtf8("\r\n");
            }
            bufferedSinkBuffer.writeUtf8("\r\n");
            bufferedSinkBuffer.flush();
            StatusLine statusLine = StatusLine.parse(readUtf8LineStrictUnbuffered(source));
            while (!readUtf8LineStrictUnbuffered(source).equals("")) {
            }
            int i2 = statusLine.code;
            if (i2 >= 200 && i2 < 300) {
                socketCreateSocket.setSoTimeout(0);
                return socketCreateSocket;
            }
            Buffer buffer = new Buffer();
            try {
                socketCreateSocket.shutdownOutput();
                source.read(buffer, 1024L);
            } catch (IOException e) {
                buffer.writeUtf8("Unable to read body: " + e.toString());
            }
            try {
                socketCreateSocket.close();
            } catch (IOException unused) {
            }
            Locale locale2 = Locale.US;
            throw Status.UNAVAILABLE.withDescription("Response returned from proxy was not successful (expected 2xx, got " + statusLine.code + " " + statusLine.message + "). Response body:\n" + buffer.readUtf8()).asException();
        } catch (IOException e2) {
            if (socketCreateSocket != null) {
                GrpcUtil.closeQuietly(socketCreateSocket);
            }
            throw Status.UNAVAILABLE.withDescription("Failed trying to connect with proxy").withCause(e2).asException();
        }
    }

    private Throwable getPingFailure() {
        synchronized (this.lock) {
            try {
                Status status = this.goAwayStatus;
                if (status != null) {
                    return status.asException();
                }
                return Status.UNAVAILABLE.withDescription("Connection closed").asException();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void initTransportTracer() {
        synchronized (this.lock) {
            this.transportTracer.setFlowControlWindowReader(new TransportTracer.FlowControlReader() { // from class: io.grpc.okhttp.OkHttpClientTransport.2
                @Override // io.grpc.internal.TransportTracer.FlowControlReader
                public TransportTracer.FlowControlWindows read() {
                    TransportTracer.FlowControlWindows flowControlWindows;
                    synchronized (OkHttpClientTransport.this.lock) {
                        flowControlWindows = new TransportTracer.FlowControlWindows(OkHttpClientTransport.this.outboundFlow == null ? -1L : OkHttpClientTransport.this.outboundFlow.windowUpdate(null, 0), (long) (OkHttpClientTransport.this.initialWindowSize * 0.5f));
                    }
                    return flowControlWindows;
                }
            });
        }
    }

    @GuardedBy("lock")
    private void maybeClearInUse(OkHttpClientStream okHttpClientStream) {
        if (this.hasStream && this.pendingStreams.isEmpty() && this.streams.isEmpty()) {
            this.hasStream = false;
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportIdle();
            }
        }
        if (okHttpClientStream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(okHttpClientStream, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ErrorCode errorCode, String str) {
        startGoAway(0, errorCode, toGrpcStatus(errorCode).augmentDescription(str));
    }

    private static String readUtf8LineStrictUnbuffered(Source source) throws EOFException {
        Buffer buffer = new Buffer();
        while (source.read(buffer, 1L) != -1) {
            if (buffer.getByte(buffer.size() - 1) == 10) {
                return buffer.readUtf8LineStrict();
            }
        }
        throw new EOFException("\\n not found: " + buffer.readByteString().hex());
    }

    private void sendConnectionPrefaceAndSettings() {
        synchronized (this.lock) {
            try {
                this.frameWriter.connectionPreface();
                Settings settings = new Settings();
                OkHttpSettingsUtil.set(settings, 7, this.initialWindowSize);
                this.frameWriter.settings(settings);
                if (this.initialWindowSize > 65535) {
                    this.frameWriter.windowUpdate(0, r1 - 65535);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("lock")
    private void setInUse(OkHttpClientStream okHttpClientStream) {
        if (!this.hasStream) {
            this.hasStream = true;
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportActive();
            }
        }
        if (okHttpClientStream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(okHttpClientStream, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGoAway(int i, ErrorCode errorCode, Status status) {
        synchronized (this.lock) {
            try {
                if (this.goAwayStatus == null) {
                    this.goAwayStatus = status;
                    this.listener.transportShutdown(status);
                }
                if (errorCode != null && !this.goAwaySent) {
                    this.goAwaySent = true;
                    this.frameWriter.goAway(0, errorCode, new byte[0]);
                }
                Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, OkHttpClientStream> next = it.next();
                    if (next.getKey().intValue() > i) {
                        it.remove();
                        next.getValue().transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.REFUSED, false, new Metadata());
                        maybeClearInUse(next.getValue());
                    }
                }
                for (OkHttpClientStream okHttpClientStream : this.pendingStreams) {
                    okHttpClientStream.transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
                    maybeClearInUse(okHttpClientStream);
                }
                this.pendingStreams.clear();
                stopIfNecessary();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean startPendingStreams() {
        boolean z = false;
        while (!this.pendingStreams.isEmpty() && this.streams.size() < this.maxConcurrentStreams) {
            startStream(this.pendingStreams.poll());
            z = true;
        }
        return z;
    }

    @GuardedBy("lock")
    private void startStream(OkHttpClientStream okHttpClientStream) {
        Preconditions.checkState(okHttpClientStream.transportState().m13755id() == -1, "StreamId already assigned");
        this.streams.put(Integer.valueOf(this.nextStreamId), okHttpClientStream);
        setInUse(okHttpClientStream);
        okHttpClientStream.transportState().start(this.nextStreamId);
        if ((okHttpClientStream.getType() != MethodDescriptor.MethodType.UNARY && okHttpClientStream.getType() != MethodDescriptor.MethodType.SERVER_STREAMING) || okHttpClientStream.useGet()) {
            this.frameWriter.flush();
        }
        int i = this.nextStreamId;
        if (i < 2147483645) {
            this.nextStreamId = i + 2;
        } else {
            this.nextStreamId = Integer.MAX_VALUE;
            startGoAway(Integer.MAX_VALUE, ErrorCode.NO_ERROR, Status.UNAVAILABLE.withDescription("Stream ids exhausted"));
        }
    }

    @GuardedBy("lock")
    private void stopIfNecessary() {
        if (this.goAwayStatus == null || !this.streams.isEmpty() || !this.pendingStreams.isEmpty() || this.stopped) {
            return;
        }
        this.stopped = true;
        KeepAliveManager keepAliveManager = this.keepAliveManager;
        if (keepAliveManager != null) {
            keepAliveManager.onTransportTermination();
        }
        Http2Ping http2Ping = this.ping;
        if (http2Ping != null) {
            http2Ping.failed(getPingFailure());
            this.ping = null;
        }
        if (!this.goAwaySent) {
            this.goAwaySent = true;
            this.frameWriter.goAway(0, ErrorCode.NO_ERROR, new byte[0]);
        }
        this.frameWriter.close();
    }

    @VisibleForTesting
    public static Status toGrpcStatus(ErrorCode errorCode) {
        Status status = ERROR_CODE_TO_STATUS.get(errorCode);
        if (status != null) {
            return status;
        }
        return Status.UNKNOWN.withDescription("Unknown http2 error code: " + errorCode.httpCode);
    }

    public void enableKeepAlive(boolean z, long j, long j2, boolean z2) {
        this.enableKeepAlive = z;
        this.keepAliveTimeNanos = j;
        this.keepAliveTimeoutNanos = j2;
        this.keepAliveWithoutCalls = z2;
    }

    public void finishStream(int i, @Nullable Status status, ClientStreamListener.RpcProgress rpcProgress, boolean z, @Nullable ErrorCode errorCode, @Nullable Metadata metadata) {
        synchronized (this.lock) {
            try {
                OkHttpClientStream okHttpClientStreamRemove = this.streams.remove(Integer.valueOf(i));
                if (okHttpClientStreamRemove != null) {
                    if (errorCode != null) {
                        this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                    }
                    if (status != null) {
                        OkHttpClientStream.TransportState transportState = okHttpClientStreamRemove.transportState();
                        if (metadata == null) {
                            metadata = new Metadata();
                        }
                        transportState.transportReportStatus(status, rpcProgress, z, metadata);
                    }
                    if (!startPendingStreams()) {
                        stopIfNecessary();
                        maybeClearInUse(okHttpClientStreamRemove);
                    }
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
                Iterator<OkHttpClientStream> it = this.streams.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    streamStateArr[i] = it.next().transportState().getOutboundFlowState();
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return streamStateArr;
    }

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttributes() {
        return this.attributes;
    }

    @VisibleForTesting
    public ClientFrameHandler getHandler() {
        return this.clientFrameHandler;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @VisibleForTesting
    public String getOverridenHost() {
        URI uriAuthorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        return uriAuthorityToUri.getHost() != null ? uriAuthorityToUri.getHost() : this.defaultAuthority;
    }

    @VisibleForTesting
    public int getOverridenPort() {
        URI uriAuthorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        return uriAuthorityToUri.getPort() != -1 ? uriAuthorityToUri.getPort() : this.address.getPort();
    }

    @VisibleForTesting
    public int getPendingStreamSize() {
        int size;
        synchronized (this.lock) {
            size = this.pendingStreams.size();
        }
        return size;
    }

    @VisibleForTesting
    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture settableFutureCreate = SettableFuture.create();
        synchronized (this.lock) {
            try {
                if (this.socket == null) {
                    settableFutureCreate.set(new InternalChannelz.SocketStats(this.transportTracer.getStats(), null, null, new InternalChannelz.SocketOptions.Builder().build(), null));
                } else {
                    settableFutureCreate.set(new InternalChannelz.SocketStats(this.transportTracer.getStats(), this.socket.getLocalSocketAddress(), this.socket.getRemoteSocketAddress(), Utils.getSocketOptions(this.socket), this.securityInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return settableFutureCreate;
    }

    public OkHttpClientStream getStream(int i) {
        OkHttpClientStream okHttpClientStream;
        synchronized (this.lock) {
            okHttpClientStream = this.streams.get(Integer.valueOf(i));
        }
        return okHttpClientStream;
    }

    public boolean isUsingPlaintext() {
        return this.sslSocketFactory == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mayHaveCreatedStream(int i) {
        boolean z;
        synchronized (this.lock) {
            if (i < this.nextStreamId) {
                z = true;
                if ((i & 1) != 1) {
                    z = false;
                }
            }
        }
        return z;
    }

    @Override // io.grpc.internal.ClientTransport
    public /* bridge */ /* synthetic */ ClientStream newStream(MethodDescriptor methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
        return newStream((MethodDescriptor<?, ?>) methodDescriptor, metadata, callOptions, clientStreamTracerArr);
    }

    @Override // io.grpc.okhttp.ExceptionHandlingFrameWriter.TransportExceptionHandler
    public void onException(Throwable th) {
        Preconditions.checkNotNull(th, "failureCause");
        startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withCause(th));
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        long jNextLong;
        synchronized (this.lock) {
            try {
                boolean z = true;
                Preconditions.checkState(this.frameWriter != null);
                if (this.stopped) {
                    Http2Ping.notifyFailed(pingCallback, executor, getPingFailure());
                    return;
                }
                Http2Ping http2Ping = this.ping;
                if (http2Ping != null) {
                    jNextLong = 0;
                    z = false;
                } else {
                    jNextLong = this.random.nextLong();
                    Stopwatch stopwatch = this.stopwatchFactory.get();
                    stopwatch.start();
                    Http2Ping http2Ping2 = new Http2Ping(jNextLong, stopwatch);
                    this.ping = http2Ping2;
                    this.transportTracer.reportKeepAliveSent();
                    http2Ping = http2Ping2;
                }
                if (z) {
                    this.frameWriter.ping(false, (int) (jNextLong >>> 32), (int) jNextLong);
                }
                http2Ping.addCallback(pingCallback, executor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("lock")
    public void removePendingStream(OkHttpClientStream okHttpClientStream) {
        this.pendingStreams.remove(okHttpClientStream);
        maybeClearInUse(okHttpClientStream);
    }

    @VisibleForTesting
    public void setNextStreamId(int i) {
        synchronized (this.lock) {
            this.nextStreamId = i;
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdown(Status status) {
        synchronized (this.lock) {
            try {
                if (this.goAwayStatus != null) {
                    return;
                }
                this.goAwayStatus = status;
                this.listener.transportShutdown(status);
                stopIfNecessary();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdownNow(Status status) {
        shutdown(status);
        synchronized (this.lock) {
            try {
                Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, OkHttpClientStream> next = it.next();
                    it.remove();
                    next.getValue().transportState().transportReportStatus(status, false, new Metadata());
                    maybeClearInUse(next.getValue());
                }
                for (OkHttpClientStream okHttpClientStream : this.pendingStreams) {
                    okHttpClientStream.transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
                    maybeClearInUse(okHttpClientStream);
                }
                this.pendingStreams.clear();
                stopIfNecessary();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public Runnable start(ManagedClientTransport.Listener listener) {
        this.listener = (ManagedClientTransport.Listener) Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.enableKeepAlive) {
            KeepAliveManager keepAliveManager = new KeepAliveManager(new KeepAliveManager.ClientKeepAlivePinger(this), this.scheduler, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
            this.keepAliveManager = keepAliveManager;
            keepAliveManager.onTransportStarted();
        }
        final AsyncSink asyncSinkSink = AsyncSink.sink(this.serializingExecutor, this, 10000);
        FrameWriter frameWriterLimitControlFramesWriter = asyncSinkSink.limitControlFramesWriter(this.variant.newWriter(Okio.buffer(asyncSinkSink), true));
        synchronized (this.lock) {
            ExceptionHandlingFrameWriter exceptionHandlingFrameWriter = new ExceptionHandlingFrameWriter(this, frameWriterLimitControlFramesWriter);
            this.frameWriter = exceptionHandlingFrameWriter;
            this.outboundFlow = new OutboundFlowController(this, exceptionHandlingFrameWriter);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.3
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                OkHttpClientTransport okHttpClientTransport;
                ClientFrameHandler clientFrameHandler;
                Socket socketCreateHttpProxySocket;
                SSLSession session;
                Socket socket;
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                BufferedSource bufferedSourceBuffer = Okio.buffer(new Source() { // from class: io.grpc.okhttp.OkHttpClientTransport.3.1
                    @Override // okio.Source
                    public long read(Buffer buffer, long j) {
                        return -1L;
                    }

                    @Override // okio.Source
                    /* JADX INFO: renamed from: timeout */
                    public Timeout getTimeout() {
                        return Timeout.NONE;
                    }

                    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                    }
                });
                try {
                    try {
                        OkHttpClientTransport okHttpClientTransport2 = OkHttpClientTransport.this;
                        HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress = okHttpClientTransport2.proxiedAddr;
                        if (httpConnectProxiedSocketAddress == null) {
                            socketCreateHttpProxySocket = okHttpClientTransport2.socketFactory.createSocket(OkHttpClientTransport.this.address.getAddress(), OkHttpClientTransport.this.address.getPort());
                        } else {
                            if (!(httpConnectProxiedSocketAddress.getProxyAddress() instanceof InetSocketAddress)) {
                                throw Status.INTERNAL.withDescription("Unsupported SocketAddress implementation " + OkHttpClientTransport.this.proxiedAddr.getProxyAddress().getClass()).asException();
                            }
                            OkHttpClientTransport okHttpClientTransport3 = OkHttpClientTransport.this;
                            socketCreateHttpProxySocket = okHttpClientTransport3.createHttpProxySocket(okHttpClientTransport3.proxiedAddr.getTargetAddress(), (InetSocketAddress) OkHttpClientTransport.this.proxiedAddr.getProxyAddress(), OkHttpClientTransport.this.proxiedAddr.getUsername(), OkHttpClientTransport.this.proxiedAddr.getPassword());
                        }
                        Socket socket2 = socketCreateHttpProxySocket;
                        if (OkHttpClientTransport.this.sslSocketFactory != null) {
                            SSLSocket sSLSocketUpgrade = OkHttpTlsUpgrader.upgrade(OkHttpClientTransport.this.sslSocketFactory, OkHttpClientTransport.this.hostnameVerifier, socket2, OkHttpClientTransport.this.getOverridenHost(), OkHttpClientTransport.this.getOverridenPort(), OkHttpClientTransport.this.connectionSpec);
                            session = sSLSocketUpgrade.getSession();
                            socket = sSLSocketUpgrade;
                        } else {
                            session = null;
                            socket = socket2;
                        }
                        socket.setTcpNoDelay(true);
                        BufferedSource bufferedSourceBuffer2 = Okio.buffer(Okio.source(socket));
                        asyncSinkSink.becomeConnected(Okio.sink(socket), socket);
                        OkHttpClientTransport okHttpClientTransport4 = OkHttpClientTransport.this;
                        okHttpClientTransport4.attributes = okHttpClientTransport4.attributes.toBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, socket.getRemoteSocketAddress()).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, socket.getLocalSocketAddress()).set(Grpc.TRANSPORT_ATTR_SSL_SESSION, session).set(GrpcAttributes.ATTR_SECURITY_LEVEL, session == null ? SecurityLevel.NONE : SecurityLevel.PRIVACY_AND_INTEGRITY).build();
                        OkHttpClientTransport okHttpClientTransport5 = OkHttpClientTransport.this;
                        okHttpClientTransport5.clientFrameHandler = okHttpClientTransport5.new ClientFrameHandler(okHttpClientTransport5.variant.newReader(bufferedSourceBuffer2, true));
                        synchronized (OkHttpClientTransport.this.lock) {
                            try {
                                OkHttpClientTransport.this.socket = (Socket) Preconditions.checkNotNull(socket, "socket");
                                if (session != null) {
                                    OkHttpClientTransport.this.securityInfo = new InternalChannelz.Security(new InternalChannelz.Tls(session));
                                }
                            } finally {
                            }
                        }
                    } catch (Throwable th) {
                        OkHttpClientTransport okHttpClientTransport6 = OkHttpClientTransport.this;
                        okHttpClientTransport6.clientFrameHandler = okHttpClientTransport6.new ClientFrameHandler(okHttpClientTransport6.variant.newReader(bufferedSourceBuffer, true));
                        throw th;
                    }
                } catch (StatusException e) {
                    OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, e.getStatus());
                    okHttpClientTransport = OkHttpClientTransport.this;
                    clientFrameHandler = okHttpClientTransport.new ClientFrameHandler(okHttpClientTransport.variant.newReader(bufferedSourceBuffer, true));
                    okHttpClientTransport.clientFrameHandler = clientFrameHandler;
                } catch (Exception e2) {
                    OkHttpClientTransport.this.onException(e2);
                    okHttpClientTransport = OkHttpClientTransport.this;
                    clientFrameHandler = okHttpClientTransport.new ClientFrameHandler(okHttpClientTransport.variant.newReader(bufferedSourceBuffer, true));
                    okHttpClientTransport.clientFrameHandler = clientFrameHandler;
                }
            }
        });
        try {
            sendConnectionPrefaceAndSettings();
            countDownLatch.countDown();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.4
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable = OkHttpClientTransport.this.connectingCallback;
                    if (runnable != null) {
                        runnable.run();
                    }
                    OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                    synchronized (OkHttpClientTransport.this.lock) {
                        OkHttpClientTransport.this.maxConcurrentStreams = Integer.MAX_VALUE;
                        OkHttpClientTransport.this.startPendingStreams();
                    }
                    SettableFuture<Void> settableFuture = OkHttpClientTransport.this.connectedFuture;
                    if (settableFuture != null) {
                        settableFuture.set(null);
                    }
                }
            });
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    @GuardedBy("lock")
    public void streamReadyToStart(OkHttpClientStream okHttpClientStream) {
        if (this.goAwayStatus != null) {
            okHttpClientStream.transportState().transportReportStatus(this.goAwayStatus, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
        } else if (this.streams.size() < this.maxConcurrentStreams) {
            startStream(okHttpClientStream);
        } else {
            this.pendingStreams.add(okHttpClientStream);
            setInUse(okHttpClientStream);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("address", this.address).toString();
    }

    private OkHttpClientTransport(OkHttpChannelBuilder.OkHttpTransportFactory okHttpTransportFactory, InetSocketAddress inetSocketAddress, String str, @Nullable String str2, Attributes attributes, Supplier<Stopwatch> supplier, Variant variant, @Nullable HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress, Runnable runnable) {
        this.random = new Random();
        this.lock = new Object();
        this.streams = new HashMap();
        this.maxConcurrentStreams = 0;
        this.pendingStreams = new LinkedList();
        this.inUseState = new InUseStateAggregator<OkHttpClientStream>() { // from class: io.grpc.okhttp.OkHttpClientTransport.1
            @Override // io.grpc.internal.InUseStateAggregator
            public void handleInUse() {
                OkHttpClientTransport.this.listener.transportInUse(true);
            }

            @Override // io.grpc.internal.InUseStateAggregator
            public void handleNotInUse() {
                OkHttpClientTransport.this.listener.transportInUse(false);
            }
        };
        this.proxySocketTimeout = 30000;
        this.address = (InetSocketAddress) Preconditions.checkNotNull(inetSocketAddress, "address");
        this.defaultAuthority = str;
        this.maxMessageSize = okHttpTransportFactory.maxMessageSize;
        this.initialWindowSize = okHttpTransportFactory.flowControlWindow;
        this.executor = (Executor) Preconditions.checkNotNull(okHttpTransportFactory.executor, "executor");
        this.serializingExecutor = new SerializingExecutor(okHttpTransportFactory.executor);
        this.scheduler = (ScheduledExecutorService) Preconditions.checkNotNull(okHttpTransportFactory.scheduledExecutorService, "scheduledExecutorService");
        this.nextStreamId = 3;
        SocketFactory socketFactory = okHttpTransportFactory.socketFactory;
        this.socketFactory = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.sslSocketFactory = okHttpTransportFactory.sslSocketFactory;
        this.hostnameVerifier = okHttpTransportFactory.hostnameVerifier;
        this.connectionSpec = (ConnectionSpec) Preconditions.checkNotNull(okHttpTransportFactory.connectionSpec, "connectionSpec");
        this.stopwatchFactory = (Supplier) Preconditions.checkNotNull(supplier, "stopwatchFactory");
        this.variant = (Variant) Preconditions.checkNotNull(variant, "variant");
        this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", str2);
        this.proxiedAddr = httpConnectProxiedSocketAddress;
        this.tooManyPingsRunnable = (Runnable) Preconditions.checkNotNull(runnable, "tooManyPingsRunnable");
        this.maxInboundMetadataSize = okHttpTransportFactory.maxInboundMetadataSize;
        this.transportTracer = okHttpTransportFactory.transportTracerFactory.create();
        this.logId = InternalLogId.allocate(getClass(), inetSocketAddress.toString());
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, attributes).build();
        this.useGetForSafeMethods = okHttpTransportFactory.useGetForSafeMethods;
        initTransportTracer();
    }

    @Override // io.grpc.internal.ClientTransport
    public OkHttpClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
        OkHttpClientStream okHttpClientStream;
        Preconditions.checkNotNull(methodDescriptor, "method");
        Preconditions.checkNotNull(metadata, Contract.HEADERS);
        StatsTraceContext statsTraceContextNewClientContext = StatsTraceContext.newClientContext(clientStreamTracerArr, getAttributes(), metadata);
        synchronized (this.lock) {
            okHttpClientStream = new OkHttpClientStream(methodDescriptor, metadata, this.frameWriter, this, this.outboundFlow, this.lock, this.maxMessageSize, this.initialWindowSize, this.defaultAuthority, this.userAgent, statsTraceContextNewClientContext, this.transportTracer, callOptions, this.useGetForSafeMethods);
        }
        return okHttpClientStream;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ClientFrameHandler implements FrameReader.Handler, Runnable {
        FrameReader frameReader;
        private final OkHttpFrameLogger logger = new OkHttpFrameLogger(Level.FINE, (Class<?>) OkHttpClientTransport.class);
        boolean firstSettings = true;

        public ClientFrameHandler(FrameReader frameReader) {
            this.frameReader = frameReader;
        }

        private int headerBlockSize(List<Header> list) {
            long size = 0;
            for (int i = 0; i < list.size(); i++) {
                Header header = list.get(i);
                size += (long) (header.value.size() + header.name.size() + 32);
            }
            return (int) Math.min(size, 2147483647L);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) {
            this.logger.logData(OkHttpFrameLogger.Direction.INBOUND, i, bufferedSource.getBuffer(), i2, z);
            OkHttpClientStream stream = OkHttpClientTransport.this.getStream(i);
            if (stream != null) {
                long j = i2;
                bufferedSource.require(j);
                Buffer buffer = new Buffer();
                buffer.write(bufferedSource.getBuffer(), j);
                PerfMark.event("OkHttpClientTransport$ClientFrameHandler.data", stream.transportState().tag());
                synchronized (OkHttpClientTransport.this.lock) {
                    stream.transportState().transportDataReceived(buffer, z);
                }
            } else {
                if (!OkHttpClientTransport.this.mayHaveCreatedStream(i)) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, AbstractC0000a.m11h(i, "Received data for unknown stream: "));
                    return;
                }
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.STREAM_CLOSED);
                }
                bufferedSource.skip(i2);
            }
            OkHttpClientTransport.access$2412(OkHttpClientTransport.this, i2);
            if (OkHttpClientTransport.this.connectionUnacknowledgedBytesRead >= OkHttpClientTransport.this.initialWindowSize * 0.5f) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.windowUpdate(0, OkHttpClientTransport.this.connectionUnacknowledgedBytesRead);
                }
                OkHttpClientTransport.this.connectionUnacknowledgedBytesRead = 0;
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            this.logger.logGoAway(OkHttpFrameLogger.Direction.INBOUND, i, errorCode, byteString);
            if (errorCode == ErrorCode.ENHANCE_YOUR_CALM) {
                String strUtf8 = byteString.utf8();
                OkHttpClientTransport.log.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, strUtf8));
                if ("too_many_pings".equals(strUtf8)) {
                    OkHttpClientTransport.this.tooManyPingsRunnable.run();
                }
            }
            Status statusAugmentDescription = GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).augmentDescription("Received Goaway");
            if (byteString.size() > 0) {
                statusAugmentDescription = statusAugmentDescription.augmentDescription(byteString.utf8());
            }
            OkHttpClientTransport.this.startGoAway(i, null, statusAugmentDescription);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void headers(boolean z, boolean z2, int i, int i2, List<Header> list, HeadersMode headersMode) {
            Status statusWithDescription;
            boolean z3;
            int iHeaderBlockSize;
            this.logger.logHeaders(OkHttpFrameLogger.Direction.INBOUND, i, list, z2);
            if (OkHttpClientTransport.this.maxInboundMetadataSize == Integer.MAX_VALUE || (iHeaderBlockSize = headerBlockSize(list)) <= OkHttpClientTransport.this.maxInboundMetadataSize) {
                statusWithDescription = null;
            } else {
                Status status = Status.RESOURCE_EXHAUSTED;
                Locale locale = Locale.US;
                StringBuilder sbM780v = AbstractC0541b.m780v("Response ", OkHttpClientTransport.this.maxInboundMetadataSize, z2 ? "trailer" : "header", " metadata larger than ", ": ");
                sbM780v.append(iHeaderBlockSize);
                statusWithDescription = status.withDescription(sbM780v.toString());
            }
            synchronized (OkHttpClientTransport.this.lock) {
                try {
                    OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                    z3 = false;
                    if (okHttpClientStream == null) {
                        if (OkHttpClientTransport.this.mayHaveCreatedStream(i)) {
                            OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.STREAM_CLOSED);
                        } else {
                            z3 = true;
                        }
                    } else if (statusWithDescription == null) {
                        PerfMark.event("OkHttpClientTransport$ClientFrameHandler.headers", okHttpClientStream.transportState().tag());
                        okHttpClientStream.transportState().transportHeadersReceived(list, z2);
                    } else {
                        if (!z2) {
                            OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                        }
                        okHttpClientStream.transportState().transportReportStatus(statusWithDescription, false, new Metadata());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z3) {
                OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, AbstractC0000a.m11h(i, "Received header for unknown stream: "));
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ping(boolean z, int i, int i2) {
            Http2Ping http2Ping;
            long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
            this.logger.logPing(OkHttpFrameLogger.Direction.INBOUND, j);
            if (!z) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.ping(true, i, i2);
                }
                return;
            }
            synchronized (OkHttpClientTransport.this.lock) {
                try {
                    http2Ping = null;
                    if (OkHttpClientTransport.this.ping == null) {
                        OkHttpClientTransport.log.warning("Received unexpected ping ack. No ping outstanding");
                    } else if (OkHttpClientTransport.this.ping.payload() == j) {
                        Http2Ping http2Ping2 = OkHttpClientTransport.this.ping;
                        OkHttpClientTransport.this.ping = null;
                        http2Ping = http2Ping2;
                    } else {
                        Logger logger = OkHttpClientTransport.log;
                        Level level = Level.WARNING;
                        Locale locale = Locale.US;
                        logger.log(level, "Received unexpected ping ack. Expecting " + OkHttpClientTransport.this.ping.payload() + ", got " + j);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (http2Ping != null) {
                http2Ping.complete();
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            this.logger.logPushPromise(OkHttpFrameLogger.Direction.INBOUND, i, i2, list);
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.PROTOCOL_ERROR);
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            this.logger.logRstStream(OkHttpFrameLogger.Direction.INBOUND, i, errorCode);
            Status statusAugmentDescription = OkHttpClientTransport.toGrpcStatus(errorCode).augmentDescription("Rst Stream");
            boolean z = statusAugmentDescription.getCode() == Status.Code.CANCELLED || statusAugmentDescription.getCode() == Status.Code.DEADLINE_EXCEEDED;
            synchronized (OkHttpClientTransport.this.lock) {
                try {
                    OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                    if (okHttpClientStream != null) {
                        PerfMark.event("OkHttpClientTransport$ClientFrameHandler.rstStream", okHttpClientStream.transportState().tag());
                        OkHttpClientTransport.this.finishStream(i, statusAugmentDescription, errorCode == ErrorCode.REFUSED_STREAM ? ClientStreamListener.RpcProgress.REFUSED : ClientStreamListener.RpcProgress.PROCESSED, z, null, null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Status statusWithDescription;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.frameReader.nextFrame(this)) {
                try {
                    if (OkHttpClientTransport.this.keepAliveManager != null) {
                        OkHttpClientTransport.this.keepAliveManager.onDataReceived();
                    }
                } catch (Throwable th) {
                    try {
                        OkHttpClientTransport.this.startGoAway(0, ErrorCode.PROTOCOL_ERROR, Status.INTERNAL.withDescription("error in frame handler").withCause(th));
                        try {
                            this.frameReader.close();
                        } catch (IOException e) {
                            e = e;
                            OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                        }
                    } catch (Throwable th2) {
                        try {
                            this.frameReader.close();
                        } catch (IOException e2) {
                            OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e2);
                        }
                        OkHttpClientTransport.this.listener.transportTerminated();
                        Thread.currentThread().setName(name);
                        throw th2;
                    }
                }
            }
            synchronized (OkHttpClientTransport.this.lock) {
                statusWithDescription = OkHttpClientTransport.this.goAwayStatus;
            }
            if (statusWithDescription == null) {
                statusWithDescription = Status.UNAVAILABLE.withDescription("End of stream or IOException");
            }
            OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, statusWithDescription);
            try {
                this.frameReader.close();
            } catch (IOException e3) {
                e = e3;
                OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
            }
            OkHttpClientTransport.this.listener.transportTerminated();
            Thread.currentThread().setName(name);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void settings(boolean z, Settings settings) {
            boolean zInitialOutboundWindowSize;
            this.logger.logSettings(OkHttpFrameLogger.Direction.INBOUND, settings);
            synchronized (OkHttpClientTransport.this.lock) {
                try {
                    if (OkHttpSettingsUtil.isSet(settings, 4)) {
                        OkHttpClientTransport.this.maxConcurrentStreams = OkHttpSettingsUtil.get(settings, 4);
                    }
                    if (OkHttpSettingsUtil.isSet(settings, 7)) {
                        zInitialOutboundWindowSize = OkHttpClientTransport.this.outboundFlow.initialOutboundWindowSize(OkHttpSettingsUtil.get(settings, 7));
                    } else {
                        zInitialOutboundWindowSize = false;
                    }
                    if (this.firstSettings) {
                        OkHttpClientTransport.this.listener.transportReady();
                        this.firstSettings = false;
                    }
                    OkHttpClientTransport.this.frameWriter.ackSettings(settings);
                    if (zInitialOutboundWindowSize) {
                        OkHttpClientTransport.this.outboundFlow.writeStreams();
                    }
                    OkHttpClientTransport.this.startPendingStreams();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void windowUpdate(int i, long j) {
            boolean z;
            this.logger.logWindowsUpdate(OkHttpFrameLogger.Direction.INBOUND, i, j);
            if (j == 0) {
                if (i == 0) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received 0 flow control window increment.");
                    return;
                } else {
                    OkHttpClientTransport.this.finishStream(i, Status.INTERNAL.withDescription("Received 0 flow control window increment."), ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.PROTOCOL_ERROR, null);
                    return;
                }
            }
            synchronized (OkHttpClientTransport.this.lock) {
                try {
                    if (i == 0) {
                        OkHttpClientTransport.this.outboundFlow.windowUpdate(null, (int) j);
                        return;
                    }
                    OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                    if (okHttpClientStream == null) {
                        z = OkHttpClientTransport.this.mayHaveCreatedStream(i) ? false : true;
                        if (z) {
                            return;
                        }
                        OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, AbstractC0000a.m11h(i, "Received window_update for unknown stream: "));
                        return;
                    }
                    OkHttpClientTransport.this.outboundFlow.windowUpdate(okHttpClientStream.transportState().getOutboundFlowState(), (int) j);
                    if (z) {
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
        public void priority(int i, int i2, int i4, boolean z) {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }
    }

    @VisibleForTesting
    public OkHttpClientTransport(OkHttpChannelBuilder.OkHttpTransportFactory okHttpTransportFactory, String str, Supplier<Stopwatch> supplier, Variant variant, @Nullable Runnable runnable, SettableFuture<Void> settableFuture, Runnable runnable2) {
        this(okHttpTransportFactory, new InetSocketAddress("127.0.0.1", 80), "notarealauthority:80", str, Attributes.EMPTY, supplier, variant, null, runnable2);
        this.connectingCallback = runnable;
        this.connectedFuture = (SettableFuture) Preconditions.checkNotNull(settableFuture, "connectedFuture");
    }
}
