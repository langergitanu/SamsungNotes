package io.grpc.netty;

import io.grpc.ChannelLogger;
import io.grpc.netty.InternalProtocolNegotiator;
import io.grpc.netty.ProtocolNegotiators;
import io.netty.channel.ChannelHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.util.AsciiString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class InternalProtocolNegotiators {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ProtocolNegotiationHandler extends ProtocolNegotiators.ProtocolNegotiationHandler {
        public ProtocolNegotiationHandler(ChannelHandler channelHandler, String str, ChannelLogger channelLogger) {
            super(channelHandler, str, channelLogger);
        }

        public ProtocolNegotiationHandler(ChannelHandler channelHandler, ChannelLogger channelLogger) {
            super(channelHandler, channelLogger);
        }
    }

    private InternalProtocolNegotiators() {
    }

    public static ChannelHandler clientTlsHandler(ChannelHandler channelHandler, SslContext sslContext, String str, ChannelLogger channelLogger) {
        return new ProtocolNegotiators.ClientTlsHandler(channelHandler, sslContext, str, null, channelLogger);
    }

    public static ChannelHandler grpcNegotiationHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
        return new ProtocolNegotiators.GrpcNegotiationHandler(grpcHttp2ConnectionHandler);
    }

    public static InternalProtocolNegotiator.ProtocolNegotiator plaintext() {
        final ProtocolNegotiator protocolNegotiatorPlaintext = ProtocolNegotiators.plaintext();
        return new InternalProtocolNegotiator.ProtocolNegotiator() { // from class: io.grpc.netty.InternalProtocolNegotiators.1PlaintextNegotiator
            @Override // io.grpc.netty.ProtocolNegotiator
            public void close() {
                protocolNegotiatorPlaintext.close();
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
                return protocolNegotiatorPlaintext.newHandler(grpcHttp2ConnectionHandler);
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public AsciiString scheme() {
                return protocolNegotiatorPlaintext.scheme();
            }
        };
    }

    public static InternalProtocolNegotiator.ProtocolNegotiator serverPlaintext() {
        final ProtocolNegotiator protocolNegotiatorServerPlaintext = ProtocolNegotiators.serverPlaintext();
        return new InternalProtocolNegotiator.ProtocolNegotiator() { // from class: io.grpc.netty.InternalProtocolNegotiators.1ServerPlaintextNegotiator
            @Override // io.grpc.netty.ProtocolNegotiator
            public void close() {
                protocolNegotiatorServerPlaintext.close();
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
                return protocolNegotiatorServerPlaintext.newHandler(grpcHttp2ConnectionHandler);
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public AsciiString scheme() {
                return protocolNegotiatorServerPlaintext.scheme();
            }
        };
    }

    public static InternalProtocolNegotiator.ProtocolNegotiator serverTls(SslContext sslContext) {
        final ProtocolNegotiator protocolNegotiatorServerTls = ProtocolNegotiators.serverTls(sslContext);
        return new InternalProtocolNegotiator.ProtocolNegotiator() { // from class: io.grpc.netty.InternalProtocolNegotiators.1ServerTlsNegotiator
            @Override // io.grpc.netty.ProtocolNegotiator
            public void close() {
                protocolNegotiatorServerTls.close();
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
                return protocolNegotiatorServerTls.newHandler(grpcHttp2ConnectionHandler);
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public AsciiString scheme() {
                return protocolNegotiatorServerTls.scheme();
            }
        };
    }

    public static InternalProtocolNegotiator.ProtocolNegotiator tls(SslContext sslContext) {
        final ProtocolNegotiator protocolNegotiatorTls = ProtocolNegotiators.tls(sslContext);
        return new InternalProtocolNegotiator.ProtocolNegotiator() { // from class: io.grpc.netty.InternalProtocolNegotiators.1TlsNegotiator
            @Override // io.grpc.netty.ProtocolNegotiator
            public void close() {
                protocolNegotiatorTls.close();
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public ChannelHandler newHandler(GrpcHttp2ConnectionHandler grpcHttp2ConnectionHandler) {
                return protocolNegotiatorTls.newHandler(grpcHttp2ConnectionHandler);
            }

            @Override // io.grpc.netty.ProtocolNegotiator
            public AsciiString scheme() {
                return protocolNegotiatorTls.scheme();
            }
        };
    }

    public static ChannelHandler waitUntilActiveHandler(ChannelHandler channelHandler, ChannelLogger channelLogger) {
        return new ProtocolNegotiators.WaitUntilActiveHandler(channelHandler, channelLogger);
    }
}
