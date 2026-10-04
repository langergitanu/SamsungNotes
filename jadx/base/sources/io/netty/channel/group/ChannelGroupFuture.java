package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ChannelGroupFuture extends Future<Void>, Iterable<ChannelFuture> {
    @Override // io.netty.util.concurrent.Future
    Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // io.netty.util.concurrent.Future
    Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Future
    Future<Void> await();

    @Override // io.netty.util.concurrent.Future
    Future<Void> awaitUninterruptibly();

    @Override // io.netty.util.concurrent.Future
    ChannelGroupException cause();

    ChannelFuture find(Channel channel);

    ChannelGroup group();

    boolean isPartialFailure();

    boolean isPartialSuccess();

    @Override // io.netty.util.concurrent.Future
    boolean isSuccess();

    @Override // java.lang.Iterable
    Iterator<ChannelFuture> iterator();

    @Override // io.netty.util.concurrent.Future
    Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // io.netty.util.concurrent.Future
    Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Future
    Future<Void> sync();

    @Override // io.netty.util.concurrent.Future
    Future<Void> syncUninterruptibly();
}
