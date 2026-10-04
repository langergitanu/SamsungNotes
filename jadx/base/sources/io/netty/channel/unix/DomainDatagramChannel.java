package io.netty.channel.unix;

import io.netty.channel.Channel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface DomainDatagramChannel extends UnixChannel, Channel {
    @Override // io.netty.channel.Channel
    DomainDatagramChannelConfig config();

    boolean isConnected();

    @Override // io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    DomainSocketAddress remoteAddress();
}
