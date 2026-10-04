package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ChannelPromise extends ChannelFuture, Promise<Void> {
    @Override // io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future
    Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future
    Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future
    Future<Void> await();

    @Override // io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future
    Future<Void> awaitUninterruptibly();

    @Override // io.netty.channel.ChannelFuture
    Channel channel();

    @Override // io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future
    Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future
    Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    ChannelPromise setFailure(Throwable th);

    ChannelPromise setSuccess();

    ChannelPromise setSuccess(Void r12);

    @Override // io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future
    Future<Void> sync();

    @Override // io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future
    Future<Void> syncUninterruptibly();

    boolean trySuccess();

    ChannelPromise unvoid();
}
