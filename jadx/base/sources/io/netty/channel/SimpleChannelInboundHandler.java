package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SimpleChannelInboundHandler<I> extends ChannelInboundHandlerAdapter {
    private final boolean autoRelease;
    private final TypeParameterMatcher matcher;

    public SimpleChannelInboundHandler() {
        this(true);
    }

    public boolean acceptInboundMessage(Object obj) {
        return this.matcher.match(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        boolean z = true;
        try {
            if (acceptInboundMessage(obj)) {
                channelRead0(channelHandlerContext, obj);
            } else {
                z = false;
                channelHandlerContext.fireChannelRead(obj);
            }
            if (this.autoRelease && z) {
                ReferenceCountUtil.release(obj);
            }
        } catch (Throwable th) {
            if (this.autoRelease && 1 != 0) {
                ReferenceCountUtil.release(obj);
            }
            throw th;
        }
    }

    public abstract void channelRead0(ChannelHandlerContext channelHandlerContext, I i);

    public SimpleChannelInboundHandler(boolean z) {
        this.matcher = TypeParameterMatcher.find(this, SimpleChannelInboundHandler.class, "I");
        this.autoRelease = z;
    }

    public SimpleChannelInboundHandler(Class<? extends I> cls) {
        this(cls, true);
    }

    public SimpleChannelInboundHandler(Class<? extends I> cls, boolean z) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.autoRelease = z;
    }
}
