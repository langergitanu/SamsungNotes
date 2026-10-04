package io.grpc.netty;

import io.grpc.Internal;
import io.grpc.ServerCredentials;
import io.grpc.internal.ObjectPool;
import io.grpc.netty.InternalProtocolNegotiator;
import io.grpc.netty.ProtocolNegotiators;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalNettyServerCredentials {
    private InternalNettyServerCredentials() {
    }

    public static ServerCredentials create(InternalProtocolNegotiator.ProtocolNegotiator protocolNegotiator) {
        return NettyServerCredentials.create(ProtocolNegotiators.fixedServerFactory(protocolNegotiator));
    }

    public static InternalProtocolNegotiator.ServerFactory toNegotiator(ServerCredentials serverCredentials) {
        final ProtocolNegotiators.FromServerCredentialsResult fromServerCredentialsResultFrom = ProtocolNegotiators.from(serverCredentials);
        if (fromServerCredentialsResultFrom.error == null) {
            return new InternalProtocolNegotiator.ServerFactory() { // from class: io.grpc.netty.InternalNettyServerCredentials.1ServerFactory
                @Override // io.grpc.netty.InternalProtocolNegotiator.ServerFactory, io.grpc.netty.ProtocolNegotiator.ServerFactory
                public /* bridge */ /* synthetic */ ProtocolNegotiator newNegotiator(ObjectPool objectPool) {
                    return newNegotiator((ObjectPool<? extends Executor>) objectPool);
                }

                @Override // io.grpc.netty.InternalProtocolNegotiator.ServerFactory, io.grpc.netty.ProtocolNegotiator.ServerFactory
                public InternalProtocolNegotiator.ProtocolNegotiator newNegotiator(ObjectPool<? extends Executor> objectPool) {
                    return new InternalProtocolNegotiator.ProtocolNegotiatorAdapter(fromServerCredentialsResultFrom.negotiator.newNegotiator(objectPool));
                }
            };
        }
        throw new IllegalArgumentException(fromServerCredentialsResultFrom.error);
    }

    public static ServerCredentials create(InternalProtocolNegotiator.ServerFactory serverFactory) {
        return NettyServerCredentials.create(serverFactory);
    }
}
