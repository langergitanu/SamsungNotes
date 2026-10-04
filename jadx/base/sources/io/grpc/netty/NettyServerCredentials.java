package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.ServerCredentials;
import io.grpc.netty.ProtocolNegotiator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class NettyServerCredentials extends ServerCredentials {
    private final ProtocolNegotiator.ServerFactory negotiator;

    private NettyServerCredentials(ProtocolNegotiator.ServerFactory serverFactory) {
        this.negotiator = (ProtocolNegotiator.ServerFactory) Preconditions.checkNotNull(serverFactory, "negotiator");
    }

    public static ServerCredentials create(ProtocolNegotiator.ServerFactory serverFactory) {
        return new NettyServerCredentials(serverFactory);
    }

    public ProtocolNegotiator.ServerFactory getNegotiator() {
        return this.negotiator;
    }
}
