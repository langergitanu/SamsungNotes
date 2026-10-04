package io.netty.channel.nio;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface NioTask<C extends SelectableChannel> {
    void channelReady(C c, SelectionKey selectionKey);

    void channelUnregistered(C c, Throwable th);
}
