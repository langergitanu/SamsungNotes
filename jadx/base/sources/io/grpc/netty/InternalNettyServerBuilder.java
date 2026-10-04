package io.grpc.netty;

import io.grpc.Attributes;
import io.grpc.Internal;
import io.grpc.internal.SharedResourcePool;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalNettyServerBuilder {
    private InternalNettyServerBuilder() {
    }

    public static void eagAttributes(NettyServerBuilder nettyServerBuilder, Attributes attributes) {
        nettyServerBuilder.eagAttributes(attributes);
    }

    public static void setForceHeapBuffer(NettyServerBuilder nettyServerBuilder, boolean z) {
        nettyServerBuilder.setForceHeapBuffer(z);
    }

    public static void setStatsEnabled(NettyServerBuilder nettyServerBuilder, boolean z) {
        nettyServerBuilder.setStatsEnabled(z);
    }

    public static void setStatsRecordRealTimeMetrics(NettyServerBuilder nettyServerBuilder, boolean z) {
        nettyServerBuilder.setStatsRecordRealTimeMetrics(z);
    }

    public static void setStatsRecordStartedRpcs(NettyServerBuilder nettyServerBuilder, boolean z) {
        nettyServerBuilder.setStatsRecordStartedRpcs(z);
    }

    public static void setTracingEnabled(NettyServerBuilder nettyServerBuilder, boolean z) {
        nettyServerBuilder.setTracingEnabled(z);
    }

    public static void useNioTransport(NettyServerBuilder nettyServerBuilder) {
        nettyServerBuilder.channelType(NioServerSocketChannel.class);
        nettyServerBuilder.bossEventLoopGroupPool(SharedResourcePool.forResource(Utils.NIO_BOSS_EVENT_LOOP_GROUP));
        nettyServerBuilder.workerEventLoopGroupPool(SharedResourcePool.forResource(Utils.NIO_WORKER_EVENT_LOOP_GROUP));
    }
}
