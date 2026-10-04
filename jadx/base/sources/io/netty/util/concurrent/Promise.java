package io.netty.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Promise<V> extends Future<V> {
    Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Promise<V> await();

    Promise<V> awaitUninterruptibly();

    Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Promise<V> setFailure(Throwable th);

    Promise<V> setSuccess(V v);

    boolean setUncancellable();

    Promise<V> sync();

    Promise<V> syncUninterruptibly();

    boolean tryFailure(Throwable th);

    boolean trySuccess(V v);
}
