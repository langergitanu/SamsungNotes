package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class NoopAddressResolver extends AbstractAddressResolver<SocketAddress> {
    public NoopAddressResolver(EventExecutor eventExecutor) {
        super(eventExecutor);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    public boolean doIsResolved(SocketAddress socketAddress) {
        return true;
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    public void doResolve(SocketAddress socketAddress, Promise<SocketAddress> promise) {
        promise.setSuccess(socketAddress);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    public void doResolveAll(SocketAddress socketAddress, Promise<List<SocketAddress>> promise) {
        promise.setSuccess(Collections.singletonList(socketAddress));
    }
}
