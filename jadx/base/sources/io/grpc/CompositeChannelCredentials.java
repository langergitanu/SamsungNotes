package io.grpc;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class CompositeChannelCredentials extends ChannelCredentials {
    private final CallCredentials callCredentials;
    private final ChannelCredentials channelCredentials;

    private CompositeChannelCredentials(ChannelCredentials channelCredentials, CallCredentials callCredentials) {
        this.channelCredentials = (ChannelCredentials) Preconditions.checkNotNull(channelCredentials, "channelCreds");
        this.callCredentials = (CallCredentials) Preconditions.checkNotNull(callCredentials, "callCreds");
    }

    public static ChannelCredentials create(ChannelCredentials channelCredentials, CallCredentials callCredentials) {
        return new CompositeChannelCredentials(channelCredentials, callCredentials);
    }

    public CallCredentials getCallCredentials() {
        return this.callCredentials;
    }

    public ChannelCredentials getChannelCredentials() {
        return this.channelCredentials;
    }

    @Override // io.grpc.ChannelCredentials
    public ChannelCredentials withoutBearerTokens() {
        return this.channelCredentials.withoutBearerTokens();
    }
}
