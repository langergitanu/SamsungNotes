package io.grpc.internal;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.serverspis.SCloudServerConstants;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.InternalMetadata;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.StreamListener;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class GrpcUtil {
    public static final Splitter ACCEPT_ENCODING_SPLITTER;
    public static final CallOptions.Key<Boolean> CALL_OPTIONS_RPC_OWNED_BY_BALANCER;
    public static final String CONTENT_ACCEPT_ENCODING = "accept-encoding";
    public static final Metadata.Key<byte[]> CONTENT_ACCEPT_ENCODING_KEY;
    public static final String CONTENT_ENCODING = "content-encoding";
    public static final Metadata.Key<String> CONTENT_ENCODING_KEY;
    static final Metadata.Key<String> CONTENT_LENGTH_KEY;
    public static final String CONTENT_TYPE_GRPC = "application/grpc";
    public static final Metadata.Key<String> CONTENT_TYPE_KEY;
    public static final long DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
    public static final String DEFAULT_LB_POLICY = "pick_first";
    public static final int DEFAULT_MAX_HEADER_LIST_SIZE = 8192;
    public static final int DEFAULT_MAX_MESSAGE_SIZE = 4194304;
    public static final int DEFAULT_PORT_PLAINTEXT = 80;
    public static final int DEFAULT_PORT_SSL = 443;
    public static final ProxyDetector DEFAULT_PROXY_DETECTOR;
    public static final long DEFAULT_SERVER_KEEPALIVE_TIMEOUT_NANOS;
    public static final long DEFAULT_SERVER_KEEPALIVE_TIME_NANOS;
    public static final String HTTP_METHOD = "POST";
    private static final String IMPLEMENTATION_VERSION = "1.57.0";
    public static final long KEEPALIVE_TIME_NANOS_DISABLED = Long.MAX_VALUE;
    public static final String MESSAGE_ACCEPT_ENCODING = "grpc-accept-encoding";
    public static final Metadata.Key<byte[]> MESSAGE_ACCEPT_ENCODING_KEY;
    public static final String MESSAGE_ENCODING = "grpc-encoding";
    public static final Metadata.Key<String> MESSAGE_ENCODING_KEY;
    public static final ProxyDetector NOOP_PROXY_DETECTOR;
    private static final ClientStreamTracer NOOP_TRACER;
    public static final long SERVER_KEEPALIVE_TIME_NANOS_DISABLED = Long.MAX_VALUE;
    public static final SharedResourceHolder.Resource<Executor> SHARED_CHANNEL_EXECUTOR;
    public static final Supplier<Stopwatch> STOPWATCH_SUPPLIER;
    public static final Metadata.Key<String> TE_HEADER;
    public static final String TE_TRAILERS = "trailers";
    public static final SharedResourceHolder.Resource<ScheduledExecutorService> TIMER_SERVICE;
    public static final Metadata.Key<String> USER_AGENT_KEY;
    private static final Logger log = Logger.getLogger(GrpcUtil.class.getName());
    private static final Set<Status.Code> INAPPROPRIATE_CONTROL_PLANE_STATUS = Collections.unmodifiableSet(EnumSet.of(Status.Code.OK, Status.Code.INVALID_ARGUMENT, Status.Code.NOT_FOUND, Status.Code.ALREADY_EXISTS, Status.Code.FAILED_PRECONDITION, Status.Code.ABORTED, Status.Code.OUT_OF_RANGE, Status.Code.DATA_LOSS));
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final String TIMEOUT = "grpc-timeout";
    public static final Metadata.Key<Long> TIMEOUT_KEY = Metadata.Key.m13734of(TIMEOUT, new TimeoutMarshaller());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AcceptEncodingMarshaller implements InternalMetadata.TrustedAsciiMarshaller<byte[]> {
        private AcceptEncodingMarshaller() {
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] parseAsciiString(byte[] bArr) {
            return bArr;
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(byte[] bArr) {
            return bArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    public static final class GrpcBuildVersion {
        private final String implementationVersion;
        private final String userAgent;

        public String getImplementationVersion() {
            return this.implementationVersion;
        }

        public String getUserAgent() {
            return this.userAgent;
        }

        public String toString() {
            return this.userAgent + " " + this.implementationVersion;
        }

        private GrpcBuildVersion(String str, String str2) {
            this.userAgent = (String) Preconditions.checkNotNull(str, "userAgentName");
            this.implementationVersion = (String) Preconditions.checkNotNull(str2, "implementationVersion");
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NO_ERROR' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Http2Error {
        private static final /* synthetic */ Http2Error[] $VALUES;
        public static final Http2Error CANCEL;
        public static final Http2Error COMPRESSION_ERROR;
        public static final Http2Error CONNECT_ERROR;
        public static final Http2Error ENHANCE_YOUR_CALM;
        public static final Http2Error FLOW_CONTROL_ERROR;
        public static final Http2Error FRAME_SIZE_ERROR;
        public static final Http2Error HTTP_1_1_REQUIRED;
        public static final Http2Error INADEQUATE_SECURITY;
        public static final Http2Error INTERNAL_ERROR;
        public static final Http2Error NO_ERROR;
        public static final Http2Error PROTOCOL_ERROR;
        public static final Http2Error REFUSED_STREAM;
        public static final Http2Error SETTINGS_TIMEOUT;
        public static final Http2Error STREAM_CLOSED;
        private static final Http2Error[] codeMap;
        private final int code;
        private final Status status;

        static {
            Status status = Status.UNAVAILABLE;
            Http2Error http2Error = new Http2Error("NO_ERROR", 0, 0, status);
            NO_ERROR = http2Error;
            Status status2 = Status.INTERNAL;
            Http2Error http2Error2 = new Http2Error("PROTOCOL_ERROR", 1, 1, status2);
            PROTOCOL_ERROR = http2Error2;
            Http2Error http2Error3 = new Http2Error("INTERNAL_ERROR", 2, 2, status2);
            INTERNAL_ERROR = http2Error3;
            Http2Error http2Error4 = new Http2Error("FLOW_CONTROL_ERROR", 3, 3, status2);
            FLOW_CONTROL_ERROR = http2Error4;
            Http2Error http2Error5 = new Http2Error("SETTINGS_TIMEOUT", 4, 4, status2);
            SETTINGS_TIMEOUT = http2Error5;
            Http2Error http2Error6 = new Http2Error("STREAM_CLOSED", 5, 5, status2);
            STREAM_CLOSED = http2Error6;
            Http2Error http2Error7 = new Http2Error("FRAME_SIZE_ERROR", 6, 6, status2);
            FRAME_SIZE_ERROR = http2Error7;
            Http2Error http2Error8 = new Http2Error("REFUSED_STREAM", 7, 7, status);
            REFUSED_STREAM = http2Error8;
            Http2Error http2Error9 = new Http2Error("CANCEL", 8, 8, Status.CANCELLED);
            CANCEL = http2Error9;
            Http2Error http2Error10 = new Http2Error("COMPRESSION_ERROR", 9, 9, status2);
            COMPRESSION_ERROR = http2Error10;
            Http2Error http2Error11 = new Http2Error("CONNECT_ERROR", 10, 10, status2);
            CONNECT_ERROR = http2Error11;
            Http2Error http2Error12 = new Http2Error("ENHANCE_YOUR_CALM", 11, 11, Status.RESOURCE_EXHAUSTED.withDescription("Bandwidth exhausted"));
            ENHANCE_YOUR_CALM = http2Error12;
            Http2Error http2Error13 = new Http2Error("INADEQUATE_SECURITY", 12, 12, Status.PERMISSION_DENIED.withDescription("Permission denied as protocol is not secure enough to call"));
            INADEQUATE_SECURITY = http2Error13;
            Http2Error http2Error14 = new Http2Error("HTTP_1_1_REQUIRED", 13, 13, Status.UNKNOWN);
            HTTP_1_1_REQUIRED = http2Error14;
            $VALUES = new Http2Error[]{http2Error, http2Error2, http2Error3, http2Error4, http2Error5, http2Error6, http2Error7, http2Error8, http2Error9, http2Error10, http2Error11, http2Error12, http2Error13, http2Error14};
            codeMap = buildHttp2CodeMap();
        }

        private Http2Error(String str, int i, int i2, Status status) {
            this.code = i2;
            String string = "HTTP/2 error code: " + name();
            if (status.getDescription() != null) {
                StringBuilder sbM781w = AbstractC0541b.m781w(string, " (");
                sbM781w.append(status.getDescription());
                sbM781w.append(")");
                string = sbM781w.toString();
            }
            this.status = status.withDescription(string);
        }

        private static Http2Error[] buildHttp2CodeMap() {
            Http2Error[] http2ErrorArrValues = values();
            Http2Error[] http2ErrorArr = new Http2Error[((int) http2ErrorArrValues[http2ErrorArrValues.length - 1].code()) + 1];
            for (Http2Error http2Error : http2ErrorArrValues) {
                http2ErrorArr[(int) http2Error.code()] = http2Error;
            }
            return http2ErrorArr;
        }

        public static Http2Error forCode(long j) {
            Http2Error[] http2ErrorArr = codeMap;
            if (j >= http2ErrorArr.length || j < 0) {
                return null;
            }
            return http2ErrorArr[(int) j];
        }

        public static Status statusForCode(long j) {
            Http2Error http2ErrorForCode = forCode(j);
            if (http2ErrorForCode != null) {
                return http2ErrorForCode.status();
            }
            return Status.fromCodeValue(INTERNAL_ERROR.status().getCode().value()).withDescription("Unrecognized HTTP/2 error code: " + j);
        }

        public static Http2Error valueOf(String str) {
            return (Http2Error) Enum.valueOf(Http2Error.class, str);
        }

        public static Http2Error[] values() {
            return (Http2Error[]) $VALUES.clone();
        }

        public long code() {
            return this.code;
        }

        public Status status() {
            return this.status;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static class TimeoutMarshaller implements Metadata.AsciiMarshaller<Long> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.AsciiMarshaller
        public Long parseAsciiString(String str) {
            Preconditions.checkArgument(str.length() > 0, "empty timeout");
            Preconditions.checkArgument(str.length() <= 9, "bad timeout format");
            long j = Long.parseLong(str.substring(0, str.length() - 1));
            char cM4a = AbstractC0000a.m4a(1, str);
            if (cM4a == 'H') {
                return Long.valueOf(TimeUnit.HOURS.toNanos(j));
            }
            if (cM4a == 'M') {
                return Long.valueOf(TimeUnit.MINUTES.toNanos(j));
            }
            if (cM4a == 'S') {
                return Long.valueOf(TimeUnit.SECONDS.toNanos(j));
            }
            if (cM4a == 'u') {
                return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(j));
            }
            if (cM4a == 'm') {
                return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j));
            }
            if (cM4a == 'n') {
                return Long.valueOf(j);
            }
            throw new IllegalArgumentException("Invalid timeout unit: " + cM4a);
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(Long l) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            }
            if (l.longValue() < 100000000) {
                return l + "n";
            }
            if (l.longValue() < 100000000000L) {
                return timeUnit.toMicros(l.longValue()) + CoeditServiceConstants.CacheFilePath.UPDATE_CACHE;
            }
            if (l.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l.longValue()) + "m";
            }
            if (l.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l.longValue()) + "S";
            }
            if (l.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l.longValue()) + "M";
            }
            return timeUnit.toHours(l.longValue()) + "H";
        }
    }

    static {
        Metadata.AsciiMarshaller<String> asciiMarshaller = Metadata.ASCII_STRING_MARSHALLER;
        MESSAGE_ENCODING_KEY = Metadata.Key.m13734of(MESSAGE_ENCODING, asciiMarshaller);
        MESSAGE_ACCEPT_ENCODING_KEY = InternalMetadata.keyOf(MESSAGE_ACCEPT_ENCODING, new AcceptEncodingMarshaller());
        CONTENT_ENCODING_KEY = Metadata.Key.m13734of(CONTENT_ENCODING, asciiMarshaller);
        CONTENT_ACCEPT_ENCODING_KEY = InternalMetadata.keyOf(CONTENT_ACCEPT_ENCODING, new AcceptEncodingMarshaller());
        CONTENT_LENGTH_KEY = Metadata.Key.m13734of("content-length", asciiMarshaller);
        CONTENT_TYPE_KEY = Metadata.Key.m13734of("content-type", asciiMarshaller);
        TE_HEADER = Metadata.Key.m13734of("te", asciiMarshaller);
        USER_AGENT_KEY = Metadata.Key.m13734of(SCloudServerConstants.USER_AGENT_HEADER, asciiMarshaller);
        ACCEPT_ENCODING_SPLITTER = Splitter.m4272on(',').trimResults();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        DEFAULT_KEEPALIVE_TIMEOUT_NANOS = timeUnit.toNanos(20L);
        DEFAULT_SERVER_KEEPALIVE_TIME_NANOS = TimeUnit.HOURS.toNanos(2L);
        DEFAULT_SERVER_KEEPALIVE_TIMEOUT_NANOS = timeUnit.toNanos(20L);
        DEFAULT_PROXY_DETECTOR = new ProxyDetectorImpl();
        NOOP_PROXY_DETECTOR = new ProxyDetector() { // from class: io.grpc.internal.GrpcUtil.1
            @Override // io.grpc.ProxyDetector
            @Nullable
            public ProxiedSocketAddress proxyFor(SocketAddress socketAddress) {
                return null;
            }
        };
        CALL_OPTIONS_RPC_OWNED_BY_BALANCER = CallOptions.Key.create("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        NOOP_TRACER = new ClientStreamTracer() { // from class: io.grpc.internal.GrpcUtil.2
        };
        SHARED_CHANNEL_EXECUTOR = new SharedResourceHolder.Resource<Executor>() { // from class: io.grpc.internal.GrpcUtil.3
            private static final String NAME = "grpc-default-executor";

            public String toString() {
                return NAME;
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public void close(Executor executor) {
                ((ExecutorService) executor).shutdown();
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public Executor create() {
                return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-default-executor-%d", true));
            }
        };
        TIMER_SERVICE = new SharedResourceHolder.Resource<ScheduledExecutorService>() { // from class: io.grpc.internal.GrpcUtil.4
            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public void close(ScheduledExecutorService scheduledExecutorService) {
                scheduledExecutorService.shutdown();
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public ScheduledExecutorService create() {
                ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, GrpcUtil.getThreadFactory("grpc-timer-%d", true));
                try {
                    scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
                } catch (NoSuchMethodException unused) {
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
                return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
            }
        };
        STOPWATCH_SUPPLIER = new Supplier<Stopwatch>() { // from class: io.grpc.internal.GrpcUtil.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.common.base.Supplier
            public Stopwatch get() {
                return Stopwatch.createUnstarted();
            }
        };
    }

    private GrpcUtil() {
    }

    public static String authorityFromHostAndPort(String str, int i) {
        String str2;
        int i2;
        try {
            str2 = str;
            i2 = i;
            try {
                return new URI(null, null, str2, i2, null, null, null).getAuthority();
            } catch (URISyntaxException e) {
                e = e;
                throw new IllegalArgumentException("Invalid host or port: " + str2 + " " + i2, e);
            }
        } catch (URISyntaxException e2) {
            e = e2;
            str2 = str;
            i2 = i;
        }
    }

    public static URI authorityToUri(String str) {
        String str2;
        Preconditions.checkNotNull(str, "authority");
        try {
            str2 = str;
            try {
                return new URI(null, str2, null, null, null);
            } catch (URISyntaxException e) {
                e = e;
                throw new IllegalArgumentException(AbstractC0541b.m772n("Invalid authority: ", str2), e);
            }
        } catch (URISyntaxException e2) {
            e = e2;
            str2 = str;
        }
    }

    public static String checkAuthority(String str) {
        URI uriAuthorityToUri = authorityToUri(str);
        Preconditions.checkArgument(uriAuthorityToUri.getHost() != null, "No host in authority '%s'", str);
        Preconditions.checkArgument(uriAuthorityToUri.getUserInfo() == null, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    public static void closeQuietly(StreamListener.MessageProducer messageProducer) {
        while (true) {
            InputStream next = messageProducer.next();
            if (next == null) {
                return;
            } else {
                closeQuietly(next);
            }
        }
    }

    public static void exhaust(InputStream inputStream) {
        while (inputStream.read(new byte[256]) != -1) {
        }
    }

    public static ClientStreamTracer[] getClientStreamTracers(CallOptions callOptions, Metadata metadata, int i, boolean z) {
        List<ClientStreamTracer.Factory> streamTracerFactories = callOptions.getStreamTracerFactories();
        int size = streamTracerFactories.size();
        ClientStreamTracer[] clientStreamTracerArr = new ClientStreamTracer[size + 1];
        ClientStreamTracer.StreamInfo streamInfoBuild = ClientStreamTracer.StreamInfo.newBuilder().setCallOptions(callOptions).setPreviousAttempts(i).setIsTransparentRetry(z).build();
        for (int i2 = 0; i2 < streamTracerFactories.size(); i2++) {
            clientStreamTracerArr[i2] = streamTracerFactories.get(i2).newClientStreamTracer(streamInfoBuild, metadata);
        }
        clientStreamTracerArr[size] = NOOP_TRACER;
        return clientStreamTracerArr;
    }

    public static GrpcBuildVersion getGrpcBuildVersion() {
        return new GrpcBuildVersion("gRPC Java", IMPLEMENTATION_VERSION);
    }

    public static String getGrpcUserAgent(String str, @Nullable String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        return AbstractC2322a.m1626p(sb, "grpc-java-", str, "/1.57.0");
    }

    public static String getHost(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", null).invoke(inetSocketAddress, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory getThreadFactory(String str, boolean z) {
        return new ThreadFactoryBuilder().setDaemon(z).setNameFormat(str).build();
    }

    @Nullable
    public static ClientTransport getTransportFromPickResult(LoadBalancer.PickResult pickResult, boolean z) {
        LoadBalancer.Subchannel subchannel = pickResult.getSubchannel();
        final ClientTransport clientTransportObtainActiveTransport = subchannel != null ? ((TransportProvider) subchannel.getInternalSubchannel()).obtainActiveTransport() : null;
        if (clientTransportObtainActiveTransport != null) {
            final ClientStreamTracer.Factory streamTracerFactory = pickResult.getStreamTracerFactory();
            return streamTracerFactory == null ? clientTransportObtainActiveTransport : new ClientTransport() { // from class: io.grpc.internal.GrpcUtil.6
                @Override // io.grpc.InternalWithLogId
                public InternalLogId getLogId() {
                    return clientTransportObtainActiveTransport.getLogId();
                }

                @Override // io.grpc.InternalInstrumented
                public ListenableFuture<InternalChannelz.SocketStats> getStats() {
                    return clientTransportObtainActiveTransport.getStats();
                }

                @Override // io.grpc.internal.ClientTransport
                public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
                    ClientStreamTracer clientStreamTracerNewClientStreamTracer = streamTracerFactory.newClientStreamTracer(ClientStreamTracer.StreamInfo.newBuilder().setCallOptions(callOptions).build(), metadata);
                    Preconditions.checkState(clientStreamTracerArr[clientStreamTracerArr.length - 1] == GrpcUtil.NOOP_TRACER, "lb tracer already assigned");
                    clientStreamTracerArr[clientStreamTracerArr.length - 1] = clientStreamTracerNewClientStreamTracer;
                    return clientTransportObtainActiveTransport.newStream(methodDescriptor, metadata, callOptions, clientStreamTracerArr);
                }

                @Override // io.grpc.internal.ClientTransport
                public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
                    clientTransportObtainActiveTransport.ping(pingCallback, executor);
                }
            };
        }
        if (!pickResult.getStatus().isOk()) {
            if (pickResult.isDrop()) {
                return new FailingClientTransport(replaceInappropriateControlPlaneStatus(pickResult.getStatus()), ClientStreamListener.RpcProgress.DROPPED);
            }
            if (!z) {
                return new FailingClientTransport(replaceInappropriateControlPlaneStatus(pickResult.getStatus()), ClientStreamListener.RpcProgress.PROCESSED);
            }
        }
        return null;
    }

    private static Status.Code httpStatusToGrpcCode(int i) {
        if (i >= 100 && i < 200) {
            return Status.Code.INTERNAL;
        }
        if (i != 400) {
            if (i == 401) {
                return Status.Code.UNAUTHENTICATED;
            }
            if (i == 403) {
                return Status.Code.PERMISSION_DENIED;
            }
            if (i == 404) {
                return Status.Code.UNIMPLEMENTED;
            }
            if (i != 429) {
                if (i != 431) {
                    switch (i) {
                        case 502:
                        case 503:
                        case 504:
                            break;
                        default:
                            return Status.Code.UNKNOWN;
                    }
                }
            }
            return Status.Code.UNAVAILABLE;
        }
        return Status.Code.INTERNAL;
    }

    public static Status httpStatusToGrpcStatus(int i) {
        return httpStatusToGrpcCode(i).toStatus().withDescription("HTTP status code " + i);
    }

    public static boolean isGrpcContentType(String str) {
        char cCharAt;
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.startsWith(CONTENT_TYPE_GRPC)) {
            return lowerCase.length() == 16 || (cCharAt = lowerCase.charAt(16)) == '+' || cCharAt == ';';
        }
        return false;
    }

    public static <T> boolean iterableContains(Iterable<T> iterable, T t) {
        if (iterable instanceof Collection) {
            try {
                return ((Collection) iterable).contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            if (Objects.equal(it.next(), t)) {
                return true;
            }
        }
        return false;
    }

    public static Status replaceInappropriateControlPlaneStatus(Status status) {
        Preconditions.checkArgument(status != null);
        if (!INAPPROPRIATE_CONTROL_PLANE_STATUS.contains(status.getCode())) {
            return status;
        }
        return Status.INTERNAL.withDescription("Inappropriate status code from control plane: " + status.getCode() + " " + status.getDescription()).withCause(status.getCause());
    }

    public static boolean shouldBeCountedForInUse(CallOptions callOptions) {
        return !Boolean.TRUE.equals(callOptions.getOption(CALL_OPTIONS_RPC_OWNED_BY_BALANCER));
    }

    public static void closeQuietly(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            log.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e);
        }
    }
}
