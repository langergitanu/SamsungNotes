package io.netty.resolver;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface AddressResolver<T extends SocketAddress> extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean isResolved(SocketAddress socketAddress);

    boolean isSupported(SocketAddress socketAddress);

    Future<T> resolve(SocketAddress socketAddress);

    Future<T> resolve(SocketAddress socketAddress, Promise<T> promise);

    Future<List<T>> resolveAll(SocketAddress socketAddress);

    Future<List<T>> resolveAll(SocketAddress socketAddress, Promise<List<T>> promise);
}
