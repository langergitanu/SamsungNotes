package io.grpc.netty;

import io.grpc.Internal;
import io.grpc.ServerCredentials;
import io.grpc.ServerProvider;
import io.grpc.netty.ProtocolNegotiators;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class NettyServerProvider extends ServerProvider {
    @Override // io.grpc.ServerProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.ServerProvider
    public ServerProvider.NewServerBuilderResult newServerBuilderForPort(int i, ServerCredentials serverCredentials) {
        ProtocolNegotiators.FromServerCredentialsResult fromServerCredentialsResultFrom = ProtocolNegotiators.from(serverCredentials);
        String str = fromServerCredentialsResultFrom.error;
        return str != null ? ServerProvider.NewServerBuilderResult.error(str) : ServerProvider.NewServerBuilderResult.serverBuilder(new NettyServerBuilder(new InetSocketAddress(i), fromServerCredentialsResultFrom.negotiator));
    }

    @Override // io.grpc.ServerProvider
    public int priority() {
        return 5;
    }

    @Override // io.grpc.ServerProvider
    public NettyServerBuilder builderForPort(int i) {
        return NettyServerBuilder.forPort(i);
    }
}
