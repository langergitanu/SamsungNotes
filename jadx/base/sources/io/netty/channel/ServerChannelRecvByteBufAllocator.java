package io.netty.channel;

import io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ServerChannelRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {
    public ServerChannelRecvByteBufAllocator() {
        super(1, true);
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle() { // from class: io.netty.channel.ServerChannelRecvByteBufAllocator.1
            @Override // io.netty.channel.RecvByteBufAllocator.Handle
            public int guess() {
                return 128;
            }
        };
    }
}
