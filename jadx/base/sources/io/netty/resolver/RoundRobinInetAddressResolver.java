package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.PlatformDependent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class RoundRobinInetAddressResolver extends InetNameResolver {
    private final NameResolver<InetAddress> nameResolver;

    public RoundRobinInetAddressResolver(EventExecutor eventExecutor, NameResolver<InetAddress> nameResolver) {
        super(eventExecutor);
        this.nameResolver = nameResolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int randomIndex(int i) {
        if (i == 1) {
            return 0;
        }
        return PlatformDependent.threadLocalRandom().nextInt(i);
    }

    @Override // io.netty.resolver.SimpleNameResolver, io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.nameResolver.close();
    }

    @Override // io.netty.resolver.SimpleNameResolver
    public void doResolve(final String str, final Promise<InetAddress> promise) {
        this.nameResolver.resolveAll(str).addListener(new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.RoundRobinInetAddressResolver.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) {
                if (!future.isSuccess()) {
                    promise.setFailure(future.cause());
                    return;
                }
                List<InetAddress> now = future.getNow();
                int size = now.size();
                if (size > 0) {
                    promise.setSuccess(now.get(RoundRobinInetAddressResolver.randomIndex(size)));
                } else {
                    promise.setFailure(new UnknownHostException(str));
                }
            }
        });
    }

    @Override // io.netty.resolver.SimpleNameResolver
    public void doResolveAll(String str, final Promise<List<InetAddress>> promise) {
        this.nameResolver.resolveAll(str).addListener(new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.RoundRobinInetAddressResolver.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) {
                if (!future.isSuccess()) {
                    promise.setFailure(future.cause());
                    return;
                }
                List<InetAddress> now = future.getNow();
                if (now.isEmpty()) {
                    promise.setSuccess(now);
                    return;
                }
                ArrayList arrayList = new ArrayList(now);
                Collections.rotate(arrayList, RoundRobinInetAddressResolver.randomIndex(now.size()));
                promise.setSuccess(arrayList);
            }
        });
    }
}
