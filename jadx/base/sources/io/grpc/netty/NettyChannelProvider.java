package io.grpc.netty;

import io.grpc.ChannelCredentials;
import io.grpc.Internal;
import io.grpc.ManagedChannelProvider;
import io.grpc.netty.ProtocolNegotiators;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class NettyChannelProvider extends ManagedChannelProvider {
    @Override // io.grpc.ManagedChannelProvider
    public Collection<Class<? extends SocketAddress>> getSupportedSocketAddressTypes() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // io.grpc.ManagedChannelProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.ManagedChannelProvider
    public ManagedChannelProvider.NewChannelBuilderResult newChannelBuilder(String str, ChannelCredentials channelCredentials) {
        ProtocolNegotiators.FromChannelCredentialsResult fromChannelCredentialsResultFrom = ProtocolNegotiators.from(channelCredentials);
        String str2 = fromChannelCredentialsResultFrom.error;
        return str2 != null ? ManagedChannelProvider.NewChannelBuilderResult.error(str2) : ManagedChannelProvider.NewChannelBuilderResult.channelBuilder(new NettyChannelBuilder(str, channelCredentials, fromChannelCredentialsResultFrom.callCredentials, fromChannelCredentialsResultFrom.negotiator));
    }

    @Override // io.grpc.ManagedChannelProvider
    public int priority() {
        return 5;
    }

    @Override // io.grpc.ManagedChannelProvider
    public NettyChannelBuilder builderForAddress(String str, int i) {
        return NettyChannelBuilder.forAddress(str, i);
    }

    @Override // io.grpc.ManagedChannelProvider
    public NettyChannelBuilder builderForTarget(String str) {
        return NettyChannelBuilder.forTarget(str);
    }
}
