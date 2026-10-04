package io.netty.channel.pool;

import io.netty.channel.Channel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractChannelPoolHandler implements ChannelPoolHandler {
    @Override // io.netty.channel.pool.ChannelPoolHandler
    public void channelAcquired(Channel channel) {
    }

    @Override // io.netty.channel.pool.ChannelPoolHandler
    public void channelReleased(Channel channel) {
    }
}
