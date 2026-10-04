package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.ChannelCredentials;
import io.grpc.ExperimentalApi;
import io.netty.handler.ssl.SslContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("There is no plan to make this API stable, given transport API instability")
public final class NettySslContextChannelCredentials {
    private NettySslContextChannelCredentials() {
    }

    public static ChannelCredentials create(SslContext sslContext) {
        Preconditions.checkArgument(sslContext.isClient(), "Server SSL context can not be used for client channel");
        GrpcSslContexts.ensureAlpnAndH2Enabled(sslContext.applicationProtocolNegotiator());
        return NettyChannelCredentials.create(ProtocolNegotiators.tlsClientFactory(sslContext));
    }
}
