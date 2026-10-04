package io.grpc.netty;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.Internal;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.SharedResourcePool;
import io.grpc.internal.TransportTracer;
import io.grpc.netty.InternalProtocolNegotiator;
import io.grpc.netty.ProtocolNegotiator;
import io.netty.channel.socket.nio.NioSocketChannel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalNettyChannelBuilder {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ProtocolNegotiatorFactory {
        InternalProtocolNegotiator.ProtocolNegotiator buildProtocolNegotiator();
    }

    private InternalNettyChannelBuilder() {
    }

    public static ClientTransportFactory buildTransportFactory(NettyChannelBuilder nettyChannelBuilder) {
        return nettyChannelBuilder.buildTransportFactory();
    }

    public static void disableCheckAuthority(NettyChannelBuilder nettyChannelBuilder) {
        nettyChannelBuilder.disableCheckAuthority();
    }

    public static void enableCheckAuthority(NettyChannelBuilder nettyChannelBuilder) {
        nettyChannelBuilder.enableCheckAuthority();
    }

    public static void setProtocolNegotiatorFactory(NettyChannelBuilder nettyChannelBuilder, final ProtocolNegotiatorFactory protocolNegotiatorFactory) {
        nettyChannelBuilder.protocolNegotiatorFactory(new ProtocolNegotiator.ClientFactory() { // from class: io.grpc.netty.InternalNettyChannelBuilder.1
            @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
            public int getDefaultPort() {
                return GrpcUtil.DEFAULT_PORT_SSL;
            }

            @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
            public ProtocolNegotiator newNegotiator() {
                return protocolNegotiatorFactory.buildProtocolNegotiator();
            }
        });
    }

    public static void setStatsEnabled(NettyChannelBuilder nettyChannelBuilder, boolean z) {
        nettyChannelBuilder.setStatsEnabled(z);
    }

    public static void setStatsRecordFinishedRpcs(NettyChannelBuilder nettyChannelBuilder, boolean z) {
        nettyChannelBuilder.setStatsRecordFinishedRpcs(z);
    }

    public static void setStatsRecordRealTimeMetrics(NettyChannelBuilder nettyChannelBuilder, boolean z) {
        nettyChannelBuilder.setStatsRecordRealTimeMetrics(z);
    }

    public static void setStatsRecordRetryMetrics(NettyChannelBuilder nettyChannelBuilder, boolean z) {
        nettyChannelBuilder.setStatsRecordRetryMetrics(z);
    }

    public static void setStatsRecordStartedRpcs(NettyChannelBuilder nettyChannelBuilder, boolean z) {
        nettyChannelBuilder.setStatsRecordStartedRpcs(z);
    }

    public static void setTracingEnabled(NettyChannelBuilder nettyChannelBuilder, boolean z) {
        nettyChannelBuilder.setTracingEnabled(z);
    }

    @VisibleForTesting
    public static void setTransportTracerFactory(NettyChannelBuilder nettyChannelBuilder, TransportTracer.Factory factory) {
        nettyChannelBuilder.setTransportTracerFactory(factory);
    }

    public static void useNioTransport(NettyChannelBuilder nettyChannelBuilder) {
        nettyChannelBuilder.channelType(NioSocketChannel.class);
        nettyChannelBuilder.eventLoopGroupPool(SharedResourcePool.forResource(Utils.NIO_WORKER_EVENT_LOOP_GROUP));
    }

    public static void setProtocolNegotiatorFactory(NettyChannelBuilder nettyChannelBuilder, InternalProtocolNegotiator.ClientFactory clientFactory) {
        nettyChannelBuilder.protocolNegotiatorFactory(clientFactory);
    }
}
