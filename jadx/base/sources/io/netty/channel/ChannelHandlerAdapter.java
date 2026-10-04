package io.netty.channel;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerMask;
import io.netty.util.internal.InternalThreadLocalMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ChannelHandlerAdapter implements ChannelHandler {
    boolean added;

    public void ensureNotSharable() {
        if (isSharable()) {
            throw new IllegalStateException("ChannelHandler " + getClass().getName() + " is not allowed to be shared");
        }
    }

    @Override // io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    @Deprecated
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.fireExceptionCaught(th);
    }

    public boolean isSharable() {
        Class<?> cls = getClass();
        Map<Class<?>, Boolean> mapHandlerSharableCache = InternalThreadLocalMap.get().handlerSharableCache();
        Boolean boolValueOf = mapHandlerSharableCache.get(cls);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(cls.isAnnotationPresent(ChannelHandler.Sharable.class));
            mapHandlerSharableCache.put(cls, boolValueOf);
        }
        return boolValueOf.booleanValue();
    }

    @Override // io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
    }
}
