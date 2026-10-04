package io.grpc;

import io.grpc.ManagedChannelProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalManagedChannelProvider {
    private InternalManagedChannelProvider() {
    }

    public static ManagedChannelBuilder<?> builderForAddress(ManagedChannelProvider managedChannelProvider, String str, int i) {
        return managedChannelProvider.builderForAddress(str, i);
    }

    public static ManagedChannelBuilder<?> builderForTarget(ManagedChannelProvider managedChannelProvider, String str) {
        return managedChannelProvider.builderForTarget(str);
    }

    public static boolean isAvailable(ManagedChannelProvider managedChannelProvider) {
        return managedChannelProvider.isAvailable();
    }

    public static ManagedChannelProvider.NewChannelBuilderResult newChannelBuilder(ManagedChannelProvider managedChannelProvider, String str, ChannelCredentials channelCredentials) {
        return managedChannelProvider.newChannelBuilder(str, channelCredentials);
    }
}
