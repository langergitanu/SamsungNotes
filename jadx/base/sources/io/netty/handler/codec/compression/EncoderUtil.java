package io.netty.handler.codec.compression;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class EncoderUtil {
    private static final int THREAD_POOL_DELAY_SECONDS = 10;

    private EncoderUtil() {
    }

    public static void closeAfterFinishEncode(final ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        if (channelFuture.isDone()) {
            channelHandlerContext.close(channelPromise);
        } else {
            final ScheduledFuture<?> scheduledFutureSchedule = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.compression.EncoderUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    channelHandlerContext.close(channelPromise);
                }
            }, 10L, TimeUnit.SECONDS);
            channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.EncoderUtil.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) {
                    scheduledFutureSchedule.cancel(true);
                    if (channelPromise.isDone()) {
                        return;
                    }
                    channelHandlerContext.close(channelPromise);
                }
            });
        }
    }
}
