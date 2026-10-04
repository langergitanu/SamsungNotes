package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultAddressResolverGroup extends AddressResolverGroup<InetSocketAddress> {
    public static final DefaultAddressResolverGroup INSTANCE = new DefaultAddressResolverGroup();

    private DefaultAddressResolverGroup() {
    }

    @Override // io.netty.resolver.AddressResolverGroup
    public AddressResolver<InetSocketAddress> newResolver(EventExecutor eventExecutor) {
        return new DefaultNameResolver(eventExecutor).asAddressResolver();
    }
}
