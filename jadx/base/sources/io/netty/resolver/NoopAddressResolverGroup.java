package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class NoopAddressResolverGroup extends AddressResolverGroup<SocketAddress> {
    public static final NoopAddressResolverGroup INSTANCE = new NoopAddressResolverGroup();

    private NoopAddressResolverGroup() {
    }

    @Override // io.netty.resolver.AddressResolverGroup
    public AddressResolver<SocketAddress> newResolver(EventExecutor eventExecutor) {
        return new NoopAddressResolver(eventExecutor);
    }
}
