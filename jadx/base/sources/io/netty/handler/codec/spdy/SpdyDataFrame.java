package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface SpdyDataFrame extends ByteBufHolder, SpdyStreamFrame {
    @Override // io.netty.buffer.ByteBufHolder
    ByteBuf content();

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame copy();

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame retain(int i);

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame retainedDuplicate();

    SpdyDataFrame setLast(boolean z);

    SpdyDataFrame setStreamId(int i);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame touch(Object obj);
}
