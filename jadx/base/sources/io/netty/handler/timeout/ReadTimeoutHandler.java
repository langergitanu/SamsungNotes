package io.netty.handler.timeout;

import io.netty.channel.ChannelHandlerContext;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ReadTimeoutHandler extends IdleStateHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean closed;

    public ReadTimeoutHandler(int i) {
        this(i, TimeUnit.SECONDS);
    }

    @Override // io.netty.handler.timeout.IdleStateHandler
    public final void channelIdle(ChannelHandlerContext channelHandlerContext, IdleStateEvent idleStateEvent) {
        readTimedOut(channelHandlerContext);
    }

    public void readTimedOut(ChannelHandlerContext channelHandlerContext) {
        if (this.closed) {
            return;
        }
        channelHandlerContext.fireExceptionCaught((Throwable) ReadTimeoutException.INSTANCE);
        channelHandlerContext.close();
        this.closed = true;
    }

    public ReadTimeoutHandler(long j, TimeUnit timeUnit) {
        super(j, 0L, 0L, timeUnit);
    }
}
