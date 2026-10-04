package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.Internal;
import io.grpc.internal.ObjectPool;
import io.grpc.netty.ProtocolNegotiator;
import io.netty.channel.ChannelHandler;
import io.netty.util.AsciiString;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalProtocolNegotiator {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ClientFactory extends ProtocolNegotiator.ClientFactory {
        @Override // io.grpc.netty.ProtocolNegotiator.ClientFactory
        ProtocolNegotiator newNegotiator();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ProtocolNegotiator extends io.grpc.netty.ProtocolNegotiator {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ProtocolNegotiatorAdapter implements ProtocolNegotiator {
        private final io.grpc.netty.ProtocolNegotiator negotiator;

        public ProtocolNegotiatorAdapter(io.grpc.netty.ProtocolNegotiator protocolNegotiator) {
            this.negotiator = (io.grpc.netty.ProtocolNegotiator) Preconditions.checkNotNull(protocolNegotiator, "negotiator");
        }

        @Override // io.grpc.netty.ProtocolNegotiator
        public void close() {
            this.negotiator.close();
        }

        @Override // io.grpc.netty.ProtocolNegotiator
        public ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
            return this.negotiator.newHandler(grpcHttp2ConnectionHandler);
        }

        @Override // io.grpc.netty.ProtocolNegotiator
        public AsciiString scheme() {
            return this.negotiator.scheme();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ServerFactory extends ProtocolNegotiator.ServerFactory {
        @Override // io.grpc.netty.ProtocolNegotiator.ServerFactory
        ProtocolNegotiator newNegotiator(ObjectPool<? extends Executor> objectPool);

        @Override // io.grpc.netty.ProtocolNegotiator.ServerFactory
        /* bridge */ /* synthetic */ default io.grpc.netty.ProtocolNegotiator newNegotiator(ObjectPool objectPool) {
            return newNegotiator((ObjectPool<? extends Executor>) objectPool);
        }
    }

    private InternalProtocolNegotiator() {
    }
}
