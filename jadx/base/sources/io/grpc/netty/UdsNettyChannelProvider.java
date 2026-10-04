package io.grpc.netty;

import io.grpc.ChannelCredentials;
import io.grpc.Internal;
import io.grpc.ManagedChannelProvider;
import io.grpc.internal.SharedResourcePool;
import io.netty.channel.unix.DomainSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class UdsNettyChannelProvider extends ManagedChannelProvider {
    @Override // io.grpc.ManagedChannelProvider
    public Collection<Class<? extends SocketAddress>> getSupportedSocketAddressTypes() {
        return Collections.singleton(DomainSocketAddress.class);
    }

    @Override // io.grpc.ManagedChannelProvider
    public boolean isAvailable() {
        return Utils.EPOLL_DOMAIN_CLIENT_CHANNEL_TYPE != null;
    }

    @Override // io.grpc.ManagedChannelProvider
    public ManagedChannelProvider.NewChannelBuilderResult newChannelBuilder(String str, ChannelCredentials channelCredentials) {
        ManagedChannelProvider.NewChannelBuilderResult newChannelBuilderResultNewChannelBuilder = new NettyChannelProvider().newChannelBuilder(str, channelCredentials);
        if (newChannelBuilderResultNewChannelBuilder.getChannelBuilder() != null) {
            ((NettyChannelBuilder) newChannelBuilderResultNewChannelBuilder.getChannelBuilder()).eventLoopGroupPool(SharedResourcePool.forResource(Utils.DEFAULT_WORKER_EVENT_LOOP_GROUP)).channelType(Utils.EPOLL_DOMAIN_CLIENT_CHANNEL_TYPE);
        }
        return newChannelBuilderResultNewChannelBuilder;
    }

    @Override // io.grpc.ManagedChannelProvider
    public int priority() {
        return 3;
    }

    @Override // io.grpc.ManagedChannelProvider
    public NettyChannelBuilder builderForAddress(String str, int i) {
        throw new AssertionError("NettyChannelProvider shadows this implementation");
    }

    @Override // io.grpc.ManagedChannelProvider
    public NettyChannelBuilder builderForTarget(String str) {
        throw new AssertionError("NettyChannelProvider shadows this implementation");
    }
}
