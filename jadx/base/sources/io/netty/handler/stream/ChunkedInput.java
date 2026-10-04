package io.netty.handler.stream;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ChunkedInput<B> {
    void close();

    boolean isEndOfInput();

    long length();

    long progress();

    B readChunk(ByteBufAllocator byteBufAllocator);

    @Deprecated
    B readChunk(ChannelHandlerContext channelHandlerContext);
}
