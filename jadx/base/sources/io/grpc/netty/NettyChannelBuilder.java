package io.grpc.netty;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.InlineMe;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.ExperimentalApi;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.Internal;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.AtomicBackoff;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ManagedChannelImplBuilder;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.SharedResourcePool;
import io.grpc.internal.TransportTracer;
import io.grpc.netty.ProtocolNegotiator;
import io.grpc.netty.ProtocolNegotiators;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.handler.ssl.SslContext;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@CheckReturnValue
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1784")
public final class NettyChannelBuilder extends AbstractManagedChannelImplBuilder<NettyChannelBuilder> {
    private static final boolean DEFAULT_AUTO_FLOW_CONTROL;
    public static final int DEFAULT_FLOW_CONTROL_WINDOW = 1048576;
    private boolean keepAliveWithoutCalls;
    private LocalSocketPicker localSocketPicker;
    private final ManagedChannelImplBuilder managedChannelImplBuilder;
    private ProtocolNegotiator.ClientFactory protocolNegotiatorFactory;
    private static final long AS_LARGE_AS_INFINITE = TimeUnit.DAYS.toNanos(1000);
    private static final ChannelFactory<? extends Channel> DEFAULT_CHANNEL_FACTORY = new ReflectiveChannelFactory(Utils.DEFAULT_CLIENT_CHANNEL_TYPE);
    private static final ObjectPool<? extends EventLoopGroup> DEFAULT_EVENT_LOOP_GROUP_POOL = SharedResourcePool.forResource(Utils.DEFAULT_WORKER_EVENT_LOOP_GROUP);
    private TransportTracer.Factory transportTracerFactory = TransportTracer.getDefaultFactory();
    private final Map<ChannelOption<?>, Object> channelOptions = new HashMap();
    private ChannelFactory<? extends Channel> channelFactory = DEFAULT_CHANNEL_FACTORY;
    private ObjectPool<? extends EventLoopGroup> eventLoopGroupPool = DEFAULT_EVENT_LOOP_GROUP_POOL;
    private boolean autoFlowControl = DEFAULT_AUTO_FLOW_CONTROL;
    private int flowControlWindow = 1048576;
    private int maxHeaderListSize = 8192;
    private long keepAliveTimeNanos = Long.MAX_VALUE;
    private long keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
    private final boolean useGetForSafeMethods = false;
    private final boolean freezeProtocolNegotiatorFactory = false;

    /* JADX INFO: renamed from: io.grpc.netty.NettyChannelBuilder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C122291 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$netty$NegotiationType;

        static {
            int[] iArr = new int[NegotiationType.values().length];
            $SwitchMap$io$grpc$netty$NegotiationType = iArr;
            try {
                iArr[NegotiationType.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$netty$NegotiationType[NegotiationType.PLAINTEXT_UPGRADE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$grpc$netty$NegotiationType[NegotiationType.TLS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4917")
    public static class LocalSocketPicker {
        @Nullable
        public SocketAddress createSocketAddress(SocketAddress socketAddress, Attributes attributes) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class NettyChannelDefaultPortProvider implements ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider {
        private NettyChannelDefaultPortProvider() {
        }

        @Override // io.grpc.internal.ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider
        public int getDefaultPort() {
            return NettyChannelBuilder.this.protocolNegotiatorFactory.getDefaultPort();
        }

        public /* synthetic */ NettyChannelDefaultPortProvider(NettyChannelBuilder nettyChannelBuilder, C122291 c122291) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class NettyChannelTransportFactoryBuilder implements ManagedChannelImplBuilder.ClientTransportFactoryBuilder {
        private NettyChannelTransportFactoryBuilder() {
        }

        @Override // io.grpc.internal.ManagedChannelImplBuilder.ClientTransportFactoryBuilder
        public ClientTransportFactory buildClientTransportFactory() {
            return NettyChannelBuilder.this.buildTransportFactory();
        }

        public /* synthetic */ NettyChannelTransportFactoryBuilder(NettyChannelBuilder nettyChannelBuilder, C122291 c122291) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NettyTransportFactory implements ClientTransportFactory {
        private final boolean autoFlowControl;
        private final ChannelFactory<? extends Channel> channelFactory;
        private final Map<ChannelOption<?>, ?> channelOptions;
        private boolean closed;
        private final int flowControlWindow;
        private final EventLoopGroup group;
        private final ObjectPool<? extends EventLoopGroup> groupPool;
        private final AtomicBackoff keepAliveBackoff;
        private final long keepAliveTimeNanos;
        private final long keepAliveTimeoutNanos;
        private final boolean keepAliveWithoutCalls;
        private final LocalSocketPicker localSocketPicker;
        private final int maxHeaderListSize;
        private final int maxMessageSize;
        private final ProtocolNegotiator protocolNegotiator;
        private final TransportTracer.Factory transportTracerFactory;
        private final boolean useGetForSafeMethods;

        public NettyTransportFactory(ProtocolNegotiator protocolNegotiator, ChannelFactory<? extends Channel> channelFactory, Map<ChannelOption<?>, ?> map, ObjectPool<? extends EventLoopGroup> objectPool, boolean z, int i, int i2, int i4, long j, long j2, boolean z2, TransportTracer.Factory factory, LocalSocketPicker localSocketPicker, boolean z3) {
            this.protocolNegotiator = (ProtocolNegotiator) Preconditions.checkNotNull(protocolNegotiator, "protocolNegotiator");
            this.channelFactory = channelFactory;
            this.channelOptions = new HashMap(map);
            this.groupPool = objectPool;
            this.group = objectPool.getObject();
            this.autoFlowControl = z;
            this.flowControlWindow = i;
            this.maxMessageSize = i2;
            this.maxHeaderListSize = i4;
            this.keepAliveTimeNanos = j;
            this.keepAliveBackoff = new AtomicBackoff("keepalive time nanos", j);
            this.keepAliveTimeoutNanos = j2;
            this.keepAliveWithoutCalls = z2;
            this.transportTracerFactory = factory;
            this.localSocketPicker = localSocketPicker != null ? localSocketPicker : new LocalSocketPicker();
            this.useGetForSafeMethods = z3;
        }

        @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.protocolNegotiator.close();
            this.groupPool.returnObject(this.group);
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ScheduledExecutorService getScheduledExecutorService() {
            return this.group;
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportFactory.ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger) {
            SocketAddress targetAddress;
            ProtocolNegotiator protocolNegotiatorHttpProxy;
            Preconditions.checkState(!this.closed, "The transport factory is closed.");
            ProtocolNegotiator protocolNegotiator = this.protocolNegotiator;
            HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress = clientTransportOptions.getHttpConnectProxiedSocketAddress();
            if (httpConnectProxiedSocketAddress != null) {
                targetAddress = httpConnectProxiedSocketAddress.getTargetAddress();
                protocolNegotiatorHttpProxy = ProtocolNegotiators.httpProxy(httpConnectProxiedSocketAddress.getProxyAddress(), httpConnectProxiedSocketAddress.getUsername(), httpConnectProxiedSocketAddress.getPassword(), this.protocolNegotiator);
            } else {
                targetAddress = socketAddress;
                protocolNegotiatorHttpProxy = protocolNegotiator;
            }
            final AtomicBackoff.State state = this.keepAliveBackoff.getState();
            return new NettyClientTransport(targetAddress, this.channelFactory, this.channelOptions, this.group, protocolNegotiatorHttpProxy, this.autoFlowControl, this.flowControlWindow, this.maxMessageSize, this.maxHeaderListSize, state.get(), this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls, clientTransportOptions.getAuthority(), clientTransportOptions.getUserAgent(), new Runnable() { // from class: io.grpc.netty.NettyChannelBuilder.NettyTransportFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    state.backoff();
                }
            }, this.transportTracerFactory.create(), clientTransportOptions.getEagAttributes(), this.localSocketPicker, channelLogger, this.useGetForSafeMethods, Ticker.systemTicker());
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ClientTransportFactory.SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCredentials) {
            Preconditions.checkNotNull(channelCredentials, "channelCreds");
            ProtocolNegotiators.FromChannelCredentialsResult fromChannelCredentialsResultFrom = ProtocolNegotiators.from(channelCredentials);
            if (fromChannelCredentialsResultFrom.error != null) {
                return null;
            }
            return new ClientTransportFactory.SwapChannelCredentialsResult(new NettyTransportFactory(fromChannelCredentialsResultFrom.negotiator.newNegotiator(), this.channelFactory, this.channelOptions, this.groupPool, this.autoFlowControl, this.flowControlWindow, this.maxMessageSize, this.maxHeaderListSize, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls, this.transportTracerFactory, this.localSocketPicker, this.useGetForSafeMethods), fromChannelCredentialsResultFrom.callCredentials);
        }
    }

    static {
        String str = System.getenv("GRPC_EXPERIMENTAL_AUTOFLOWCONTROL");
        if (str == null) {
            str = "true";
        }
        DEFAULT_AUTO_FLOW_CONTROL = Boolean.parseBoolean(str);
    }

    public NettyChannelBuilder(String str) {
        C122291 c122291 = null;
        this.protocolNegotiatorFactory = new DefaultProtocolNegotiator(this, c122291);
        this.managedChannelImplBuilder = new ManagedChannelImplBuilder(str, new NettyChannelTransportFactoryBuilder(this, c122291), new NettyChannelDefaultPortProvider(this, c122291));
    }

    @VisibleForTesting
    public static ProtocolNegotiator createProtocolNegotiatorByType(NegotiationType negotiationType, SslContext sslContext, ObjectPool<? extends Executor> objectPool) {
        int i = C122291.$SwitchMap$io$grpc$netty$NegotiationType[negotiationType.ordinal()];
        if (i == 1) {
            return ProtocolNegotiators.plaintext();
        }
        if (i == 2) {
            return ProtocolNegotiators.plaintextUpgrade();
        }
        if (i == 3) {
            return ProtocolNegotiators.tls(sslContext, objectPool);
        }
        throw new IllegalArgumentException("Unsupported negotiationType: " + negotiationType);
    }

    public static NettyChannelBuilder forAddress(SocketAddress socketAddress) {
        return new NettyChannelBuilder(socketAddress);
    }

    public static NettyChannelBuilder forTarget(String str) {
        return new NettyChannelBuilder(str);
    }

    private static String getAuthorityFromAddress(SocketAddress socketAddress) {
        if (!(socketAddress instanceof InetSocketAddress)) {
            return socketAddress.toString();
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        return GrpcUtil.authorityFromHostAndPort(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
    }

    @VisibleForTesting
    public void assertEventLoopAndChannelType() {
        ChannelFactory<? extends Channel> channelFactory = this.channelFactory;
        ChannelFactory<? extends Channel> channelFactory2 = DEFAULT_CHANNEL_FACTORY;
        Preconditions.checkState((channelFactory != channelFactory2 && this.eventLoopGroupPool != DEFAULT_EVENT_LOOP_GROUP_POOL) || (channelFactory == channelFactory2 && this.eventLoopGroupPool == DEFAULT_EVENT_LOOP_GROUP_POOL), "Both EventLoopGroup and ChannelType should be provided or neither should be");
    }

    public ClientTransportFactory buildTransportFactory() {
        assertEventLoopAndChannelType();
        return new NettyTransportFactory(this.protocolNegotiatorFactory.newNegotiator(), this.channelFactory, this.channelOptions, this.eventLoopGroupPool, this.autoFlowControl, this.flowControlWindow, this.maxInboundMessageSize, this.maxHeaderListSize, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls, this.transportTracerFactory, this.localSocketPicker, false);
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder channelFactory(ChannelFactory<? extends Channel> channelFactory) {
        this.channelFactory = (ChannelFactory) Preconditions.checkNotNull(channelFactory, "channelFactory");
        return this;
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder channelType(Class<? extends Channel> cls) {
        Preconditions.checkNotNull(cls, "channelType");
        return channelFactory(new ReflectiveChannelFactory(cls));
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    @Internal
    public ManagedChannelBuilder<?> delegate() {
        return this.managedChannelImplBuilder;
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder disableCheckAuthority() {
        this.managedChannelImplBuilder.disableCheckAuthority();
        return this;
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder enableCheckAuthority() {
        this.managedChannelImplBuilder.enableCheckAuthority();
        return this;
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder eventLoopGroup(@Nullable EventLoopGroup eventLoopGroup) {
        return eventLoopGroup != null ? eventLoopGroupPool(new FixedObjectPool(eventLoopGroup)) : eventLoopGroupPool(DEFAULT_EVENT_LOOP_GROUP_POOL);
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder eventLoopGroupPool(ObjectPool<? extends EventLoopGroup> objectPool) {
        this.eventLoopGroupPool = (ObjectPool) Preconditions.checkNotNull(objectPool, "eventLoopGroupPool");
        return this;
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder flowControlWindow(int i) {
        Preconditions.checkArgument(i > 0, "flowControlWindow must be positive");
        this.flowControlWindow = i;
        this.autoFlowControl = false;
        return this;
    }

    public int getDefaultPort() {
        return this.protocolNegotiatorFactory.getDefaultPort();
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder initialFlowControlWindow(int i) {
        Preconditions.checkArgument(i > 0, "initialFlowControlWindow must be positive");
        this.flowControlWindow = i;
        this.autoFlowControl = true;
        return this;
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder localSocketPicker(@Nullable LocalSocketPicker localSocketPicker) {
        this.localSocketPicker = localSocketPicker;
        return this;
    }

    @CanIgnoreReturnValue
    @InlineMe(replacement = "this.maxInboundMetadataSize(maxHeaderListSize)")
    @Deprecated
    public NettyChannelBuilder maxHeaderListSize(int i) {
        return maxInboundMetadataSize(i);
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder negotiationType(NegotiationType negotiationType) {
        Preconditions.checkState(!this.freezeProtocolNegotiatorFactory, "Cannot change security when using ChannelCredentials");
        ProtocolNegotiator.ClientFactory clientFactory = this.protocolNegotiatorFactory;
        if (!(clientFactory instanceof DefaultProtocolNegotiator)) {
            return this;
        }
        ((DefaultProtocolNegotiator) clientFactory).negotiationType = negotiationType;
        return this;
    }

    public void protocolNegotiatorFactory(ProtocolNegotiator.ClientFactory clientFactory) {
        Preconditions.checkState(!this.freezeProtocolNegotiatorFactory, "Cannot change security when using ChannelCredentials");
        this.protocolNegotiatorFactory = (ProtocolNegotiator.ClientFactory) Preconditions.checkNotNull(clientFactory, "protocolNegotiatorFactory");
    }

    public void setStatsEnabled(boolean z) {
        this.managedChannelImplBuilder.setStatsEnabled(z);
    }

    public void setStatsRecordFinishedRpcs(boolean z) {
        this.managedChannelImplBuilder.setStatsRecordFinishedRpcs(z);
    }

    public void setStatsRecordRealTimeMetrics(boolean z) {
        this.managedChannelImplBuilder.setStatsRecordRealTimeMetrics(z);
    }

    public void setStatsRecordRetryMetrics(boolean z) {
        this.managedChannelImplBuilder.setStatsRecordRetryMetrics(z);
    }

    public void setStatsRecordStartedRpcs(boolean z) {
        this.managedChannelImplBuilder.setStatsRecordStartedRpcs(z);
    }

    public void setTracingEnabled(boolean z) {
        this.managedChannelImplBuilder.setTracingEnabled(z);
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    public NettyChannelBuilder setTransportTracerFactory(TransportTracer.Factory factory) {
        this.transportTracerFactory = factory;
        return this;
    }

    @CanIgnoreReturnValue
    public NettyChannelBuilder sslContext(SslContext sslContext) {
        Preconditions.checkState(!this.freezeProtocolNegotiatorFactory, "Cannot change security when using ChannelCredentials");
        if (sslContext != null) {
            Preconditions.checkArgument(sslContext.isClient(), "Server SSL context can not be used for client channel");
            GrpcSslContexts.ensureAlpnAndH2Enabled(sslContext.applicationProtocolNegotiator());
        }
        ProtocolNegotiator.ClientFactory clientFactory = this.protocolNegotiatorFactory;
        if (!(clientFactory instanceof DefaultProtocolNegotiator)) {
            return this;
        }
        ((DefaultProtocolNegotiator) clientFactory).sslContext = sslContext;
        return this;
    }

    @CanIgnoreReturnValue
    public <T> NettyChannelBuilder withOption(ChannelOption<T> channelOption, T t) {
        this.channelOptions.put(channelOption, t);
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class DefaultProtocolNegotiator implements ProtocolNegotiator.ClientFactory {
        private NegotiationType negotiationType;
        private SslContext sslContext;

        private DefaultProtocolNegotiator() {
            this.negotiationType = NegotiationType.TLS;
        }

        @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
        public int getDefaultPort() {
            int i = C122291.$SwitchMap$io$grpc$netty$NegotiationType[this.negotiationType.ordinal()];
            if (i == 1 || i == 2) {
                return 80;
            }
            if (i == 3) {
                return GrpcUtil.DEFAULT_PORT_SSL;
            }
            throw new AssertionError(this.negotiationType + " not handled");
        }

        @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
        public ProtocolNegotiator newNegotiator() {
            SslContext sslContextBuild = this.sslContext;
            if (this.negotiationType == NegotiationType.TLS && sslContextBuild == null) {
                try {
                    sslContextBuild = GrpcSslContexts.forClient().build();
                } catch (SSLException e) {
                    throw new RuntimeException(e);
                }
            }
            return NettyChannelBuilder.createProtocolNegotiatorByType(this.negotiationType, sslContextBuild, NettyChannelBuilder.this.managedChannelImplBuilder.getOffloadExecutorPool());
        }

        public /* synthetic */ DefaultProtocolNegotiator(NettyChannelBuilder nettyChannelBuilder, C122291 c122291) {
            this();
        }
    }

    public static NettyChannelBuilder forAddress(SocketAddress socketAddress, ChannelCredentials channelCredentials) {
        ProtocolNegotiators.FromChannelCredentialsResult fromChannelCredentialsResultFrom = ProtocolNegotiators.from(channelCredentials);
        if (fromChannelCredentialsResultFrom.error == null) {
            return new NettyChannelBuilder(socketAddress, channelCredentials, fromChannelCredentialsResultFrom.callCredentials, fromChannelCredentialsResultFrom.negotiator);
        }
        throw new IllegalArgumentException(fromChannelCredentialsResultFrom.error);
    }

    public static NettyChannelBuilder forTarget(String str, ChannelCredentials channelCredentials) {
        ProtocolNegotiators.FromChannelCredentialsResult fromChannelCredentialsResultFrom = ProtocolNegotiators.from(channelCredentials);
        if (fromChannelCredentialsResultFrom.error == null) {
            return new NettyChannelBuilder(str, channelCredentials, fromChannelCredentialsResultFrom.callCredentials, fromChannelCredentialsResultFrom.negotiator);
        }
        throw new IllegalArgumentException(fromChannelCredentialsResultFrom.error);
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    @CanIgnoreReturnValue
    public NettyChannelBuilder keepAliveTime(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "keepalive time must be positive");
        long nanos = timeUnit.toNanos(j);
        this.keepAliveTimeNanos = nanos;
        long jClampKeepAliveTimeInNanos = KeepAliveManager.clampKeepAliveTimeInNanos(nanos);
        this.keepAliveTimeNanos = jClampKeepAliveTimeInNanos;
        if (jClampKeepAliveTimeInNanos >= AS_LARGE_AS_INFINITE) {
            this.keepAliveTimeNanos = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    @CanIgnoreReturnValue
    public NettyChannelBuilder keepAliveTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "keepalive timeout must be positive");
        long nanos = timeUnit.toNanos(j);
        this.keepAliveTimeoutNanos = nanos;
        this.keepAliveTimeoutNanos = KeepAliveManager.clampKeepAliveTimeoutInNanos(nanos);
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    @CanIgnoreReturnValue
    public NettyChannelBuilder keepAliveWithoutCalls(boolean z) {
        this.keepAliveWithoutCalls = z;
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    @CanIgnoreReturnValue
    public NettyChannelBuilder maxInboundMessageSize(int i) {
        Preconditions.checkArgument(i >= 0, "negative max");
        this.maxInboundMessageSize = i;
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    @CanIgnoreReturnValue
    public NettyChannelBuilder maxInboundMetadataSize(int i) {
        Preconditions.checkArgument(i > 0, "maxInboundMetadataSize must be > 0");
        this.maxHeaderListSize = i;
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    @CanIgnoreReturnValue
    public NettyChannelBuilder usePlaintext() {
        negotiationType(NegotiationType.PLAINTEXT);
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    @CanIgnoreReturnValue
    public NettyChannelBuilder useTransportSecurity() {
        negotiationType(NegotiationType.TLS);
        return this;
    }

    public static NettyChannelBuilder forAddress(String str, int i) {
        return forTarget(GrpcUtil.authorityFromHostAndPort(str, i));
    }

    public static NettyChannelBuilder forAddress(String str, int i, ChannelCredentials channelCredentials) {
        return forTarget(GrpcUtil.authorityFromHostAndPort(str, i), channelCredentials);
    }

    public NettyChannelBuilder(String str, ChannelCredentials channelCredentials, CallCredentials callCredentials, ProtocolNegotiator.ClientFactory clientFactory) {
        C122291 c122291 = null;
        this.protocolNegotiatorFactory = new DefaultProtocolNegotiator(this, c122291);
        this.managedChannelImplBuilder = new ManagedChannelImplBuilder(str, channelCredentials, callCredentials, new NettyChannelTransportFactoryBuilder(this, c122291), new NettyChannelDefaultPortProvider(this, c122291));
        this.protocolNegotiatorFactory = (ProtocolNegotiator.ClientFactory) Preconditions.checkNotNull(clientFactory, "negotiator");
    }

    public NettyChannelBuilder(SocketAddress socketAddress) {
        C122291 c122291 = null;
        this.protocolNegotiatorFactory = new DefaultProtocolNegotiator(this, c122291);
        this.managedChannelImplBuilder = new ManagedChannelImplBuilder(socketAddress, getAuthorityFromAddress(socketAddress), new NettyChannelTransportFactoryBuilder(this, c122291), new NettyChannelDefaultPortProvider(this, c122291));
    }

    public NettyChannelBuilder(SocketAddress socketAddress, ChannelCredentials channelCredentials, CallCredentials callCredentials, ProtocolNegotiator.ClientFactory clientFactory) {
        C122291 c122291 = null;
        this.protocolNegotiatorFactory = new DefaultProtocolNegotiator(this, c122291);
        this.managedChannelImplBuilder = new ManagedChannelImplBuilder(socketAddress, getAuthorityFromAddress(socketAddress), channelCredentials, callCredentials, new NettyChannelTransportFactoryBuilder(this, c122291), new NettyChannelDefaultPortProvider(this, c122291));
        this.protocolNegotiatorFactory = (ProtocolNegotiator.ClientFactory) Preconditions.checkNotNull(clientFactory, "negotiator");
    }
}
