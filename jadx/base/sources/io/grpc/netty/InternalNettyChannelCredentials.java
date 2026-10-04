package io.grpc.netty;

import io.grpc.ChannelCredentials;
import io.grpc.Internal;
import io.grpc.netty.InternalProtocolNegotiator;
import io.grpc.netty.ProtocolNegotiators;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalNettyChannelCredentials {
    private InternalNettyChannelCredentials() {
    }

    public static ChannelCredentials create(InternalProtocolNegotiator.ClientFactory clientFactory) {
        return NettyChannelCredentials.create(clientFactory);
    }

    public static InternalProtocolNegotiator.ClientFactory toNegotiator(ChannelCredentials channelCredentials) {
        final ProtocolNegotiators.FromChannelCredentialsResult fromChannelCredentialsResultFrom = ProtocolNegotiators.from(channelCredentials);
        if (fromChannelCredentialsResultFrom.error == null) {
            return new InternalProtocolNegotiator.ClientFactory() { // from class: io.grpc.netty.InternalNettyChannelCredentials.1ClientFactory
                @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
                public int getDefaultPort() {
                    return fromChannelCredentialsResultFrom.negotiator.getDefaultPort();
                }

                @Override // io.grpc.netty.InternalProtocolNegotiator.ClientFactory, io.grpc.netty.ProtocolNegotiator.ClientFactory
                public InternalProtocolNegotiator.ProtocolNegotiator newNegotiator() {
                    return new InternalProtocolNegotiator.ProtocolNegotiatorAdapter(fromChannelCredentialsResultFrom.negotiator.newNegotiator());
                }
            };
        }
        throw new IllegalArgumentException(fromChannelCredentialsResultFrom.error);
    }
}
