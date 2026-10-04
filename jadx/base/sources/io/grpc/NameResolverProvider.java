package io.grpc;

import io.grpc.NameResolver;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4159")
public abstract class NameResolverProvider extends NameResolver.Factory {
    public Collection<Class<? extends SocketAddress>> getProducedSocketAddressTypes() {
        return Collections.singleton(InetSocketAddress.class);
    }

    public String getScheme() {
        return getDefaultScheme();
    }

    public abstract boolean isAvailable();

    public abstract int priority();
}
