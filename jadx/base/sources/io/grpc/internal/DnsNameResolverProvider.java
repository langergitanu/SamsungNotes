package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import io.grpc.InternalServiceProviders;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class DnsNameResolverProvider extends NameResolverProvider {
    private static final boolean IS_ANDROID = InternalServiceProviders.isAndroid(DnsNameResolverProvider.class.getClassLoader());
    private static final String SCHEME = "dns";

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f8834a = 0;

    @Override // io.grpc.NameResolver.Factory
    public String getDefaultScheme() {
        return "dns";
    }

    @Override // io.grpc.NameResolverProvider
    public Collection<Class<? extends SocketAddress>> getProducedSocketAddressTypes() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // io.grpc.NameResolverProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.NameResolver.Factory
    public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String str = (String) Preconditions.checkNotNull(uri.getPath(), "targetPath");
        Preconditions.checkArgument(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new DnsNameResolver(uri.getAuthority(), str.substring(1), args, GrpcUtil.SHARED_CHANNEL_EXECUTOR, Stopwatch.createUnstarted(), IS_ANDROID);
    }

    @Override // io.grpc.NameResolverProvider
    public int priority() {
        return 5;
    }
}
