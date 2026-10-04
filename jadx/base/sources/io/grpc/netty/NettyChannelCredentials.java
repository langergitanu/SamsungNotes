package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.ChannelCredentials;
import io.grpc.netty.ProtocolNegotiator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class NettyChannelCredentials extends ChannelCredentials {
    private final ProtocolNegotiator.ClientFactory negotiator;

    private NettyChannelCredentials(ProtocolNegotiator.ClientFactory clientFactory) {
        this.negotiator = (ProtocolNegotiator.ClientFactory) Preconditions.checkNotNull(clientFactory, "negotiator");
    }

    public static ChannelCredentials create(ProtocolNegotiator.ClientFactory clientFactory) {
        return new NettyChannelCredentials(clientFactory);
    }

    public ProtocolNegotiator.ClientFactory getNegotiator() {
        return this.negotiator;
    }

    @Override // io.grpc.ChannelCredentials
    public ChannelCredentials withoutBearerTokens() {
        return this;
    }
}
