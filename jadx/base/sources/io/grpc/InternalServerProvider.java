package io.grpc;

import io.grpc.ServerProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalServerProvider {
    private InternalServerProvider() {
    }

    public static ServerBuilder<?> builderForPort(ServerProvider serverProvider, int i) {
        return serverProvider.builderForPort(i);
    }

    public static ServerProvider.NewServerBuilderResult newServerBuilderForPort(ServerProvider serverProvider, int i, ServerCredentials serverCredentials) {
        return serverProvider.newServerBuilderForPort(i, serverCredentials);
    }
}
