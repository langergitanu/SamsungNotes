package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class DefaultChannelHandlerContext extends AbstractChannelHandlerContext {
    private final ChannelHandler handler;

    public DefaultChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, EventExecutor eventExecutor, String str, ChannelHandler channelHandler) {
        super(defaultChannelPipeline, eventExecutor, str, channelHandler.getClass());
        this.handler = channelHandler;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandler handler() {
        return this.handler;
    }
}
