package io.grpc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class InsecureChannelCredentials extends ChannelCredentials {
    private InsecureChannelCredentials() {
    }

    public static ChannelCredentials create() {
        return new InsecureChannelCredentials();
    }

    @Override // io.grpc.ChannelCredentials
    public ChannelCredentials withoutBearerTokens() {
        return this;
    }
}
