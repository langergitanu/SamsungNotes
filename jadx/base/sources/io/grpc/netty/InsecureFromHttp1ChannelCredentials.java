package io.grpc.netty;

import io.grpc.ChannelCredentials;
import io.grpc.ExperimentalApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("There is no plan to make this API stable, given transport API instability")
public final class InsecureFromHttp1ChannelCredentials {
    private InsecureFromHttp1ChannelCredentials() {
    }

    public static ChannelCredentials create() {
        return NettyChannelCredentials.create(ProtocolNegotiators.plaintextUpgradeClientFactory());
    }
}
