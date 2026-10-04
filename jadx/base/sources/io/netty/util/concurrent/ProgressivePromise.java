package io.netty.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ProgressivePromise<V> extends Promise<V>, ProgressiveFuture<V> {
    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> await();

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> awaitUninterruptibly();

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    ProgressivePromise<V> setFailure(Throwable th);

    ProgressivePromise<V> setProgress(long j, long j2);

    ProgressivePromise<V> setSuccess(V v);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> sync();

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> syncUninterruptibly();

    boolean tryProgress(long j, long j2);
}
