package io.netty.channel;

import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import io.netty.util.concurrent.AbstractFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class VoidChannelPromise extends AbstractFuture<Void> implements ChannelPromise {
    private final Channel channel;
    private final ChannelFutureListener fireExceptionListener;

    public VoidChannelPromise(Channel channel, boolean z) {
        ObjectUtil.checkNotNull(channel, NetworkConfig.CLIENTS_CHANNEL);
        this.channel = channel;
        if (z) {
            this.fireExceptionListener = new ChannelFutureListener() { // from class: io.netty.channel.VoidChannelPromise.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    Throwable thCause = channelFuture.cause();
                    if (thCause != null) {
                        VoidChannelPromise.this.fireException0(thCause);
                    }
                }
            };
        } else {
            this.fireExceptionListener = null;
        }
    }

    private static void fail() {
        throw new IllegalStateException("void future");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireException0(Throwable th) {
        if (this.fireExceptionListener == null || !this.channel.isRegistered()) {
            return;
        }
        this.channel.pipeline().fireExceptionCaught(th);
    }

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override // io.netty.channel.ChannelPromise, io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.channel;
    }

    @Override // io.netty.util.concurrent.Future
    public Void getNow() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    @Override // io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        return this;
    }

    @Override // io.netty.channel.ChannelPromise
    public VoidChannelPromise setSuccess() {
        return this;
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        return true;
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean tryFailure(Throwable th) {
        fireException0(th);
        return false;
    }

    @Override // io.netty.channel.ChannelPromise
    public boolean trySuccess() {
        return false;
    }

    @Override // io.netty.channel.ChannelPromise
    public ChannelPromise unvoid() {
        DefaultChannelPromise defaultChannelPromise = new DefaultChannelPromise(this.channel);
        ChannelFutureListener channelFutureListener = this.fireExceptionListener;
        if (channelFutureListener != null) {
            defaultChannelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) channelFutureListener);
        }
        return defaultChannelPromise;
    }

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public VoidChannelPromise setSuccess(Void r12) {
        return this;
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean trySuccess(Void r12) {
        return false;
    }

    @Override // io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public VoidChannelPromise setFailure(Throwable th) {
        fireException0(th);
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        fail();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        fail();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> await() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> awaitUninterruptibly() {
        fail();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> sync() {
        fail();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        fail();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        fail();
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j, TimeUnit timeUnit) {
        fail();
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j) {
        fail();
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j) {
        fail();
        return false;
    }
}
