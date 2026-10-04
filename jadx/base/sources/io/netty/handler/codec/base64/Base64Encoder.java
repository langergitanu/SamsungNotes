package io.netty.handler.codec.base64;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class Base64Encoder extends MessageToMessageEncoder<ByteBuf> {
    private final boolean breakLines;
    private final Base64Dialect dialect;

    public Base64Encoder() {
        this(true);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) {
        encode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public Base64Encoder(boolean z) {
        this(z, Base64Dialect.STANDARD);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        list.add(Base64.encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), this.breakLines, this.dialect));
    }

    public Base64Encoder(boolean z, Base64Dialect base64Dialect) {
        this.dialect = (Base64Dialect) ObjectUtil.checkNotNull(base64Dialect, "dialect");
        this.breakLines = z;
    }
}
