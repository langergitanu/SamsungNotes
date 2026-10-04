package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.Internal;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.netty.channel.unix.DomainSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class UdsNameResolverProvider extends NameResolverProvider {
    private static final String SCHEME = "unix";

    public static String getTargetPathFromUri(URI uri) {
        Preconditions.checkArgument(SCHEME.equals(uri.getScheme()), "scheme must be unix");
        String path = uri.getPath();
        return path == null ? (String) Preconditions.checkNotNull(uri.getSchemeSpecificPart(), "targetPath") : path;
    }

    @Override // io.grpc.NameResolver.Factory
    public String getDefaultScheme() {
        return SCHEME;
    }

    @Override // io.grpc.NameResolverProvider
    public Collection<Class<? extends SocketAddress>> getProducedSocketAddressTypes() {
        return Collections.singleton(DomainSocketAddress.class);
    }

    @Override // io.grpc.NameResolverProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.NameResolverProvider
    public int priority() {
        return 3;
    }

    @Override // io.grpc.NameResolver.Factory
    public UdsNameResolver newNameResolver(URI uri, NameResolver.Args args) {
        if (SCHEME.equals(uri.getScheme())) {
            return new UdsNameResolver(uri.getAuthority(), getTargetPathFromUri(uri));
        }
        return null;
    }
}
