package io.grpc.netty;

import io.grpc.internal.ObjectPool;
import io.netty.channel.ChannelHandler;
import io.netty.util.AsciiString;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
interface ProtocolNegotiator {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ClientFactory {
        int getDefaultPort();

        ProtocolNegotiator newNegotiator();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ServerFactory {
        ProtocolNegotiator newNegotiator(ObjectPool<? extends Executor> objectPool);
    }

    void close();

    ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler);

    AsciiString scheme();
}
