package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class InetNameResolver extends SimpleNameResolver<InetAddress> {
    private volatile AddressResolver<InetSocketAddress> addressResolver;

    public InetNameResolver(EventExecutor eventExecutor) {
        super(eventExecutor);
    }

    public AddressResolver<InetSocketAddress> asAddressResolver() {
        AddressResolver<InetSocketAddress> inetSocketAddressResolver;
        AddressResolver<InetSocketAddress> addressResolver = this.addressResolver;
        if (addressResolver != null) {
            return addressResolver;
        }
        synchronized (this) {
            try {
                inetSocketAddressResolver = this.addressResolver;
                if (inetSocketAddressResolver == null) {
                    inetSocketAddressResolver = new InetSocketAddressResolver(executor(), this);
                    this.addressResolver = inetSocketAddressResolver;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return inetSocketAddressResolver;
    }
}
