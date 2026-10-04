package io.netty.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ProgressiveFuture<V> extends Future<V> {
    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> await();

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> awaitUninterruptibly();

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> sync();

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> syncUninterruptibly();
}
