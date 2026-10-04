package io.netty.channel.pool;

import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ChannelHealthChecker {
    public static final ChannelHealthChecker ACTIVE = new ChannelHealthChecker() { // from class: io.netty.channel.pool.ChannelHealthChecker.1
        @Override // io.netty.channel.pool.ChannelHealthChecker
        public Future<Boolean> isHealthy(Channel channel) {
            return channel.eventLoop().newSucceededFuture(channel.isActive() ? Boolean.TRUE : Boolean.FALSE);
        }
    };

    Future<Boolean> isHealthy(Channel channel);
}
