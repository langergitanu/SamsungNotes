package io.netty.channel.socket;

import io.netty.channel.ServerChannel;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ServerSocketChannel extends ServerChannel {
    @Override // io.netty.channel.Channel
    ServerSocketChannelConfig config();

    @Override // io.netty.channel.Channel
    InetSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    InetSocketAddress remoteAddress();
}
