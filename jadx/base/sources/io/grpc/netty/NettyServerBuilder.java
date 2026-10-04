package io.grpc.netty;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.InlineMe;
import io.grpc.Attributes;
import io.grpc.ExperimentalApi;
import io.grpc.Internal;
import io.grpc.ServerBuilder;
import io.grpc.ServerCredentials;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.AbstractServerImplBuilder;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InternalServer;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerImplBuilder;
import io.grpc.internal.SharedResourcePool;
import io.grpc.internal.TransportTracer;
import io.grpc.netty.ProtocolNegotiator;
import io.grpc.netty.ProtocolNegotiators;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.channel.ServerChannel;
import io.netty.handler.ssl.SslContext;
import java.io.File;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@CheckReturnValue
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1784")
public final class NettyServerBuilder extends AbstractServerImplBuilder<NettyServerBuilder> {
    private static final long AS_LARGE_AS_INFINITE;
    private static final ObjectPool<? extends EventLoopGroup> DEFAULT_BOSS_EVENT_LOOP_GROUP_POOL;
    public static final int DEFAULT_FLOW_CONTROL_WINDOW = 1048576;
    private static final ObjectPool<? extends EventLoopGroup> DEFAULT_WORKER_EVENT_LOOP_GROUP_POOL;
    static final long MAX_CONNECTION_AGE_GRACE_NANOS_INFINITE = Long.MAX_VALUE;
    static final long MAX_CONNECTION_AGE_NANOS_DISABLED = Long.MAX_VALUE;
    static final long MAX_CONNECTION_IDLE_NANOS_DISABLED = Long.MAX_VALUE;
    private static final long MIN_MAX_CONNECTION_AGE_NANO;
    private static final long MIN_MAX_CONNECTION_IDLE_NANO;
    private boolean autoFlowControl;
    private ObjectPool<? extends EventLoopGroup> bossEventLoopGroupPool;
    private ChannelFactory<? extends ServerChannel> channelFactory;
    private final Map<ChannelOption<?>, Object> channelOptions;
    private final Map<ChannelOption<?>, Object> childChannelOptions;
    private Attributes eagAttributes;
    private int flowControlWindow;
    private boolean forceHeapBuffer;
    private final boolean freezeProtocolNegotiatorFactory;
    private long keepAliveTimeInNanos;
    private long keepAliveTimeoutInNanos;
    private final List<SocketAddress> listenAddresses;
    private int maxConcurrentCallsPerConnection;
    private long maxConnectionAgeGraceInNanos;
    private long maxConnectionAgeInNanos;
    private long maxConnectionIdleInNanos;
    private int maxHeaderListSize;
    private int maxMessageSize;
    private long permitKeepAliveTimeInNanos;
    private boolean permitKeepAliveWithoutCalls;
    private ProtocolNegotiator.ServerFactory protocolNegotiatorFactory;
    private final ServerImplBuilder serverImplBuilder;
    private TransportTracer.Factory transportTracerFactory;
    private ObjectPool<? extends EventLoopGroup> workerEventLoopGroupPool;
    private static final long MIN_KEEPALIVE_TIME_NANO = TimeUnit.MILLISECONDS.toNanos(1);
    private static final long MIN_KEEPALIVE_TIMEOUT_NANO = TimeUnit.MICROSECONDS.toNanos(499);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class NettyClientTransportServersBuilder implements ServerImplBuilder.ClientTransportServersBuilder {
        private NettyClientTransportServersBuilder() {
        }

        @Override // io.grpc.internal.ServerImplBuilder.ClientTransportServersBuilder
        public InternalServer buildClientTransportServers(List<? extends ServerStreamTracer.Factory> list) {
            return NettyServerBuilder.this.buildTransportServers(list);
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        MIN_MAX_CONNECTION_IDLE_NANO = timeUnit.toNanos(1L);
        MIN_MAX_CONNECTION_AGE_NANO = timeUnit.toNanos(1L);
        AS_LARGE_AS_INFINITE = TimeUnit.DAYS.toNanos(1000L);
        DEFAULT_BOSS_EVENT_LOOP_GROUP_POOL = SharedResourcePool.forResource(Utils.DEFAULT_BOSS_EVENT_LOOP_GROUP);
        DEFAULT_WORKER_EVENT_LOOP_GROUP_POOL = SharedResourcePool.forResource(Utils.DEFAULT_WORKER_EVENT_LOOP_GROUP);
    }

    private NettyServerBuilder(SocketAddress socketAddress) {
        ArrayList arrayList = new ArrayList();
        this.listenAddresses = arrayList;
        this.transportTracerFactory = TransportTracer.getDefaultFactory();
        this.channelFactory = Utils.DEFAULT_SERVER_CHANNEL_FACTORY;
        this.channelOptions = new HashMap();
        this.childChannelOptions = new HashMap();
        this.bossEventLoopGroupPool = DEFAULT_BOSS_EVENT_LOOP_GROUP_POOL;
        this.workerEventLoopGroupPool = DEFAULT_WORKER_EVENT_LOOP_GROUP_POOL;
        this.maxConcurrentCallsPerConnection = Integer.MAX_VALUE;
        this.autoFlowControl = true;
        this.flowControlWindow = 1048576;
        this.maxMessageSize = 4194304;
        this.maxHeaderListSize = 8192;
        this.keepAliveTimeInNanos = GrpcUtil.DEFAULT_SERVER_KEEPALIVE_TIME_NANOS;
        this.keepAliveTimeoutInNanos = GrpcUtil.DEFAULT_SERVER_KEEPALIVE_TIMEOUT_NANOS;
        this.maxConnectionIdleInNanos = Long.MAX_VALUE;
        this.maxConnectionAgeInNanos = Long.MAX_VALUE;
        this.maxConnectionAgeGraceInNanos = Long.MAX_VALUE;
        this.permitKeepAliveTimeInNanos = TimeUnit.MINUTES.toNanos(5L);
        this.eagAttributes = Attributes.EMPTY;
        this.serverImplBuilder = new ServerImplBuilder(new NettyClientTransportServersBuilder());
        arrayList.add(socketAddress);
        this.protocolNegotiatorFactory = ProtocolNegotiators.serverPlaintextFactory();
        this.freezeProtocolNegotiatorFactory = false;
    }

    public static NettyServerBuilder forAddress(SocketAddress socketAddress) {
        return new NettyServerBuilder(socketAddress);
    }

    public static NettyServerBuilder forPort(int i) {
        return forAddress(new InetSocketAddress(i));
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder addListenAddress(SocketAddress socketAddress) {
        this.listenAddresses.add((SocketAddress) Preconditions.checkNotNull(socketAddress, "listenAddress"));
        return this;
    }

    @VisibleForTesting
    public void assertEventLoopsAndChannelType() {
        ChannelFactory<? extends ServerChannel> channelFactory = this.channelFactory;
        ChannelFactory<? extends ServerChannel> channelFactory2 = Utils.DEFAULT_SERVER_CHANNEL_FACTORY;
        Preconditions.checkState((channelFactory != channelFactory2 && this.bossEventLoopGroupPool != DEFAULT_BOSS_EVENT_LOOP_GROUP_POOL && this.workerEventLoopGroupPool != DEFAULT_WORKER_EVENT_LOOP_GROUP_POOL) || (channelFactory == channelFactory2 && this.bossEventLoopGroupPool == DEFAULT_BOSS_EVENT_LOOP_GROUP_POOL && this.workerEventLoopGroupPool == DEFAULT_WORKER_EVENT_LOOP_GROUP_POOL), "All of BossEventLoopGroup, WorkerEventLoopGroup and ChannelType should be provided or neither should be");
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder bossEventLoopGroup(EventLoopGroup eventLoopGroup) {
        return eventLoopGroup != null ? bossEventLoopGroupPool(new FixedObjectPool(eventLoopGroup)) : bossEventLoopGroupPool(DEFAULT_BOSS_EVENT_LOOP_GROUP_POOL);
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder bossEventLoopGroupPool(ObjectPool<? extends EventLoopGroup> objectPool) {
        this.bossEventLoopGroupPool = (ObjectPool) Preconditions.checkNotNull(objectPool, "bossEventLoopGroupPool");
        return this;
    }

    public NettyServer buildTransportServers(List<? extends ServerStreamTracer.Factory> list) {
        assertEventLoopsAndChannelType();
        return new NettyServer(this.listenAddresses, this.channelFactory, this.channelOptions, this.childChannelOptions, this.bossEventLoopGroupPool, this.workerEventLoopGroupPool, this.forceHeapBuffer, this.protocolNegotiatorFactory.newNegotiator(this.serverImplBuilder.getExecutorPool()), list, this.transportTracerFactory, this.maxConcurrentCallsPerConnection, this.autoFlowControl, this.flowControlWindow, this.maxMessageSize, this.maxHeaderListSize, this.keepAliveTimeInNanos, this.keepAliveTimeoutInNanos, this.maxConnectionIdleInNanos, this.maxConnectionAgeInNanos, this.maxConnectionAgeGraceInNanos, this.permitKeepAliveWithoutCalls, this.permitKeepAliveTimeInNanos, this.eagAttributes, this.serverImplBuilder.getChannelz());
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder channelFactory(ChannelFactory<? extends ServerChannel> channelFactory) {
        this.channelFactory = (ChannelFactory) Preconditions.checkNotNull(channelFactory, "channelFactory");
        return this;
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder channelType(Class<? extends ServerChannel> cls) {
        Preconditions.checkNotNull(cls, "channelType");
        return channelFactory(new ReflectiveChannelFactory(cls));
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder
    @Internal
    public ServerBuilder<?> delegate() {
        return this.serverImplBuilder;
    }

    public void eagAttributes(Attributes attributes) {
        this.eagAttributes = (Attributes) Preconditions.checkNotNull(attributes, "eagAttributes");
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder flowControlWindow(int i) {
        Preconditions.checkArgument(i > 0, "flowControlWindow must be positive: %s", i);
        this.flowControlWindow = i;
        this.autoFlowControl = false;
        return this;
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder initialFlowControlWindow(int i) {
        Preconditions.checkArgument(i > 0, "initialFlowControlWindow must be positive");
        this.flowControlWindow = i;
        this.autoFlowControl = true;
        return this;
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder maxConcurrentCallsPerConnection(int i) {
        Preconditions.checkArgument(i > 0, "max must be positive: %s", i);
        this.maxConcurrentCallsPerConnection = i;
        return this;
    }

    @CanIgnoreReturnValue
    @InlineMe(replacement = "this.maxInboundMetadataSize(maxHeaderListSize)")
    @Deprecated
    public NettyServerBuilder maxHeaderListSize(int i) {
        return maxInboundMetadataSize(i);
    }

    @CanIgnoreReturnValue
    @InlineMe(replacement = "this.maxInboundMessageSize(maxMessageSize)")
    @Deprecated
    public NettyServerBuilder maxMessageSize(int i) {
        return maxInboundMessageSize(i);
    }

    @CanIgnoreReturnValue
    @Internal
    public final NettyServerBuilder protocolNegotiator(ProtocolNegotiator protocolNegotiator) {
        Preconditions.checkState(!this.freezeProtocolNegotiatorFactory, "Cannot change security when using ServerCredentials");
        this.protocolNegotiatorFactory = ProtocolNegotiators.fixedServerFactory(protocolNegotiator);
        return this;
    }

    public void setForceHeapBuffer(boolean z) {
        this.forceHeapBuffer = z;
    }

    public void setStatsEnabled(boolean z) {
        this.serverImplBuilder.setStatsEnabled(z);
    }

    public void setStatsRecordRealTimeMetrics(boolean z) {
        this.serverImplBuilder.setStatsRecordRealTimeMetrics(z);
    }

    public void setStatsRecordStartedRpcs(boolean z) {
        this.serverImplBuilder.setStatsRecordStartedRpcs(z);
    }

    public void setTracingEnabled(boolean z) {
        this.serverImplBuilder.setTracingEnabled(z);
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder setTransportTracerFactory(TransportTracer.Factory factory) {
        this.transportTracerFactory = factory;
        return this;
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder sslContext(SslContext sslContext) {
        Preconditions.checkState(!this.freezeProtocolNegotiatorFactory, "Cannot change security when using ServerCredentials");
        if (sslContext == null) {
            this.protocolNegotiatorFactory = ProtocolNegotiators.serverPlaintextFactory();
            return this;
        }
        Preconditions.checkArgument(sslContext.isServer(), "Client SSL context can not be used for server");
        GrpcSslContexts.ensureAlpnAndH2Enabled(sslContext.applicationProtocolNegotiator());
        this.protocolNegotiatorFactory = ProtocolNegotiators.serverTlsFactory(sslContext);
        return this;
    }

    @CanIgnoreReturnValue
    public <T> NettyServerBuilder withChildOption(ChannelOption<T> channelOption, T t) {
        this.childChannelOptions.put(channelOption, t);
        return this;
    }

    @CanIgnoreReturnValue
    public <T> NettyServerBuilder withOption(ChannelOption<T> channelOption, T t) {
        this.channelOptions.put(channelOption, t);
        return this;
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder workerEventLoopGroup(EventLoopGroup eventLoopGroup) {
        return eventLoopGroup != null ? workerEventLoopGroupPool(new FixedObjectPool(eventLoopGroup)) : workerEventLoopGroupPool(DEFAULT_WORKER_EVENT_LOOP_GROUP_POOL);
    }

    @CanIgnoreReturnValue
    public NettyServerBuilder workerEventLoopGroupPool(ObjectPool<? extends EventLoopGroup> objectPool) {
        this.workerEventLoopGroupPool = (ObjectPool) Preconditions.checkNotNull(objectPool, "workerEventLoopGroupPool");
        return this;
    }

    public static NettyServerBuilder forAddress(SocketAddress socketAddress, ServerCredentials serverCredentials) {
        ProtocolNegotiators.FromServerCredentialsResult fromServerCredentialsResultFrom = ProtocolNegotiators.from(serverCredentials);
        if (fromServerCredentialsResultFrom.error == null) {
            return new NettyServerBuilder(socketAddress, fromServerCredentialsResultFrom.negotiator);
        }
        throw new IllegalArgumentException(fromServerCredentialsResultFrom.error);
    }

    public static NettyServerBuilder forPort(int i, ServerCredentials serverCredentials) {
        return forAddress(new InetSocketAddress(i), serverCredentials);
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder keepAliveTime(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "keepalive time must be positive：%s", j);
        long nanos = timeUnit.toNanos(j);
        this.keepAliveTimeInNanos = nanos;
        long jClampKeepAliveTimeInNanos = KeepAliveManager.clampKeepAliveTimeInNanos(nanos);
        this.keepAliveTimeInNanos = jClampKeepAliveTimeInNanos;
        if (jClampKeepAliveTimeInNanos >= AS_LARGE_AS_INFINITE) {
            this.keepAliveTimeInNanos = Long.MAX_VALUE;
        }
        long j2 = this.keepAliveTimeInNanos;
        long j3 = MIN_KEEPALIVE_TIME_NANO;
        if (j2 < j3) {
            this.keepAliveTimeInNanos = j3;
        }
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder keepAliveTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "keepalive timeout must be positive: %s", j);
        long nanos = timeUnit.toNanos(j);
        this.keepAliveTimeoutInNanos = nanos;
        long jClampKeepAliveTimeoutInNanos = KeepAliveManager.clampKeepAliveTimeoutInNanos(nanos);
        this.keepAliveTimeoutInNanos = jClampKeepAliveTimeoutInNanos;
        long j2 = MIN_KEEPALIVE_TIMEOUT_NANO;
        if (jClampKeepAliveTimeoutInNanos < j2) {
            this.keepAliveTimeoutInNanos = j2;
        }
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder maxConnectionAge(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "max connection age must be positive: %s", j);
        long nanos = timeUnit.toNanos(j);
        this.maxConnectionAgeInNanos = nanos;
        if (nanos >= AS_LARGE_AS_INFINITE) {
            this.maxConnectionAgeInNanos = Long.MAX_VALUE;
        }
        long j2 = this.maxConnectionAgeInNanos;
        long j3 = MIN_MAX_CONNECTION_AGE_NANO;
        if (j2 < j3) {
            this.maxConnectionAgeInNanos = j3;
        }
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder maxConnectionAgeGrace(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j >= 0, "max connection age grace must be non-negative: %s", j);
        long nanos = timeUnit.toNanos(j);
        this.maxConnectionAgeGraceInNanos = nanos;
        if (nanos >= AS_LARGE_AS_INFINITE) {
            this.maxConnectionAgeGraceInNanos = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder maxConnectionIdle(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "max connection idle must be positive: %s", j);
        long nanos = timeUnit.toNanos(j);
        this.maxConnectionIdleInNanos = nanos;
        if (nanos >= AS_LARGE_AS_INFINITE) {
            this.maxConnectionIdleInNanos = Long.MAX_VALUE;
        }
        long j2 = this.maxConnectionIdleInNanos;
        long j3 = MIN_MAX_CONNECTION_IDLE_NANO;
        if (j2 < j3) {
            this.maxConnectionIdleInNanos = j3;
        }
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder maxInboundMessageSize(int i) {
        Preconditions.checkArgument(i >= 0, "bytes must be non-negative: %s", i);
        this.maxMessageSize = i;
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder maxInboundMetadataSize(int i) {
        Preconditions.checkArgument(i > 0, "maxInboundMetadataSize must be positive: %s", i);
        this.maxHeaderListSize = i;
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder permitKeepAliveTime(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j >= 0, "permit keepalive time must be non-negative: %s", j);
        this.permitKeepAliveTimeInNanos = timeUnit.toNanos(j);
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder permitKeepAliveWithoutCalls(boolean z) {
        this.permitKeepAliveWithoutCalls = z;
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder useTransportSecurity(File file, File file2) {
        Preconditions.checkState(!this.freezeProtocolNegotiatorFactory, "Cannot change security when using ServerCredentials");
        try {
            this.protocolNegotiatorFactory = ProtocolNegotiators.serverTlsFactory(GrpcSslContexts.forServer(file, file2).build());
            return this;
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    @CanIgnoreReturnValue
    public NettyServerBuilder useTransportSecurity(InputStream inputStream, InputStream inputStream2) {
        Preconditions.checkState(!this.freezeProtocolNegotiatorFactory, "Cannot change security when using ServerCredentials");
        try {
            this.protocolNegotiatorFactory = ProtocolNegotiators.serverTlsFactory(GrpcSslContexts.forServer(inputStream, inputStream2).build());
            return this;
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }

    public NettyServerBuilder(SocketAddress socketAddress, ProtocolNegotiator.ServerFactory serverFactory) {
        ArrayList arrayList = new ArrayList();
        this.listenAddresses = arrayList;
        this.transportTracerFactory = TransportTracer.getDefaultFactory();
        this.channelFactory = Utils.DEFAULT_SERVER_CHANNEL_FACTORY;
        this.channelOptions = new HashMap();
        this.childChannelOptions = new HashMap();
        this.bossEventLoopGroupPool = DEFAULT_BOSS_EVENT_LOOP_GROUP_POOL;
        this.workerEventLoopGroupPool = DEFAULT_WORKER_EVENT_LOOP_GROUP_POOL;
        this.maxConcurrentCallsPerConnection = Integer.MAX_VALUE;
        this.autoFlowControl = true;
        this.flowControlWindow = 1048576;
        this.maxMessageSize = 4194304;
        this.maxHeaderListSize = 8192;
        this.keepAliveTimeInNanos = GrpcUtil.DEFAULT_SERVER_KEEPALIVE_TIME_NANOS;
        this.keepAliveTimeoutInNanos = GrpcUtil.DEFAULT_SERVER_KEEPALIVE_TIMEOUT_NANOS;
        this.maxConnectionIdleInNanos = Long.MAX_VALUE;
        this.maxConnectionAgeInNanos = Long.MAX_VALUE;
        this.maxConnectionAgeGraceInNanos = Long.MAX_VALUE;
        this.permitKeepAliveTimeInNanos = TimeUnit.MINUTES.toNanos(5L);
        this.eagAttributes = Attributes.EMPTY;
        this.serverImplBuilder = new ServerImplBuilder(new NettyClientTransportServersBuilder());
        arrayList.add(socketAddress);
        this.protocolNegotiatorFactory = (ProtocolNegotiator.ServerFactory) Preconditions.checkNotNull(serverFactory, "negotiatorFactory");
        this.freezeProtocolNegotiatorFactory = true;
    }
}
