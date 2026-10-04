package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class InetSocketAddressResolver extends AbstractAddressResolver<InetSocketAddress> {
    final NameResolver<InetAddress> nameResolver;

    public InetSocketAddressResolver(EventExecutor eventExecutor, NameResolver<InetAddress> nameResolver) {
        super(eventExecutor, InetSocketAddress.class);
        this.nameResolver = nameResolver;
    }

    @Override // io.netty.resolver.AbstractAddressResolver, io.netty.resolver.AddressResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.nameResolver.close();
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    public /* bridge */ /* synthetic */ void doResolve(SocketAddress socketAddress, Promise promise) {
        doResolve((InetSocketAddress) socketAddress, (Promise<InetSocketAddress>) promise);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    public /* bridge */ /* synthetic */ void doResolveAll(SocketAddress socketAddress, Promise promise) {
        doResolveAll((InetSocketAddress) socketAddress, (Promise<List<InetSocketAddress>>) promise);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    public boolean doIsResolved(InetSocketAddress inetSocketAddress) {
        return !inetSocketAddress.isUnresolved();
    }

    public void doResolve(final InetSocketAddress inetSocketAddress, final Promise<InetSocketAddress> promise) {
        this.nameResolver.resolve(inetSocketAddress.getHostName()).addListener(new FutureListener<InetAddress>() { // from class: io.netty.resolver.InetSocketAddressResolver.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<InetAddress> future) {
                if (future.isSuccess()) {
                    promise.setSuccess(new InetSocketAddress(future.getNow(), inetSocketAddress.getPort()));
                } else {
                    promise.setFailure(future.cause());
                }
            }
        });
    }

    public void doResolveAll(final InetSocketAddress inetSocketAddress, final Promise<List<InetSocketAddress>> promise) {
        this.nameResolver.resolveAll(inetSocketAddress.getHostName()).addListener(new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.InetSocketAddressResolver.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) {
                if (!future.isSuccess()) {
                    promise.setFailure(future.cause());
                    return;
                }
                List<InetAddress> now = future.getNow();
                ArrayList arrayList = new ArrayList(now.size());
                Iterator<InetAddress> it = now.iterator();
                while (it.hasNext()) {
                    arrayList.add(new InetSocketAddress(it.next(), inetSocketAddress.getPort()));
                }
                promise.setSuccess(arrayList);
            }
        });
    }
}
