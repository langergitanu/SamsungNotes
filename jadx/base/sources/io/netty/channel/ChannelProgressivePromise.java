package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ProgressivePromise;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ChannelProgressivePromise extends ProgressivePromise<Void>, ChannelProgressiveFuture, ChannelPromise {
    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise await();

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise awaitUninterruptibly();

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    ChannelProgressivePromise setFailure(Throwable th);

    @Override // io.netty.util.concurrent.ProgressivePromise
    ProgressivePromise<Void> setProgress(long j, long j2);

    @Override // io.netty.channel.ChannelPromise
    ChannelProgressivePromise setSuccess();

    @Override // io.netty.channel.ChannelPromise
    ChannelProgressivePromise setSuccess(Void r12);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise sync();

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise syncUninterruptibly();

    @Override // io.netty.channel.ChannelPromise
    ChannelProgressivePromise unvoid();
}
