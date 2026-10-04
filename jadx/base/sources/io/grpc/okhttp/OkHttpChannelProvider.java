package io.grpc.okhttp;

import io.grpc.ChannelCredentials;
import io.grpc.Internal;
import io.grpc.InternalServiceProviders;
import io.grpc.ManagedChannelProvider;
import io.grpc.okhttp.OkHttpChannelBuilder;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Internal
public final class OkHttpChannelProvider extends ManagedChannelProvider {
    @Override // io.grpc.ManagedChannelProvider
    public Collection<Class<? extends SocketAddress>> getSupportedSocketAddressTypes() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // io.grpc.ManagedChannelProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.ManagedChannelProvider
    public ManagedChannelProvider.NewChannelBuilderResult newChannelBuilder(String str, ChannelCredentials channelCredentials) {
        OkHttpChannelBuilder.SslSocketFactoryResult sslSocketFactoryResultSslSocketFactoryFrom = OkHttpChannelBuilder.sslSocketFactoryFrom(channelCredentials);
        String str2 = sslSocketFactoryResultSslSocketFactoryFrom.error;
        return str2 != null ? ManagedChannelProvider.NewChannelBuilderResult.error(str2) : ManagedChannelProvider.NewChannelBuilderResult.channelBuilder(new OkHttpChannelBuilder(str, channelCredentials, sslSocketFactoryResultSslSocketFactoryFrom.callCredentials, sslSocketFactoryResultSslSocketFactoryFrom.factory));
    }

    @Override // io.grpc.ManagedChannelProvider
    public int priority() {
        return InternalServiceProviders.isAndroid(OkHttpChannelProvider.class.getClassLoader()) ? 8 : 3;
    }

    @Override // io.grpc.ManagedChannelProvider
    public OkHttpChannelBuilder builderForAddress(String str, int i) {
        return OkHttpChannelBuilder.forAddress(str, i);
    }

    @Override // io.grpc.ManagedChannelProvider
    public OkHttpChannelBuilder builderForTarget(String str) {
        return OkHttpChannelBuilder.forTarget(str);
    }
}
