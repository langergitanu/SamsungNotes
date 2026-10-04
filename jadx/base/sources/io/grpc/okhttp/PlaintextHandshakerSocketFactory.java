package io.grpc.okhttp;

import io.grpc.Attributes;
import io.grpc.Grpc;
import io.grpc.SecurityLevel;
import io.grpc.internal.GrpcAttributes;
import io.grpc.okhttp.HandshakerSocketFactory;
import java.net.Socket;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class PlaintextHandshakerSocketFactory implements HandshakerSocketFactory {
    @Override // io.grpc.okhttp.HandshakerSocketFactory
    public HandshakerSocketFactory.HandshakeResult handshake(Socket socket, Attributes attributes) {
        return new HandshakerSocketFactory.HandshakeResult(socket, attributes.toBuilder().set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, socket.getLocalSocketAddress()).set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, socket.getRemoteSocketAddress()).set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.NONE).build(), null);
    }
}
