package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class FixedLengthFrameDecoder extends ByteToMessageDecoder {
    private final int frameLength;

    public FixedLengthFrameDecoder(int i) {
        ObjectUtil.checkPositive(i, "frameLength");
        this.frameLength = i;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        Object objDecode = decode(channelHandlerContext, byteBuf);
        if (objDecode != null) {
            list.add(objDecode);
        }
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        int i = byteBuf.readableBytes();
        int i2 = this.frameLength;
        if (i < i2) {
            return null;
        }
        return byteBuf.readRetainedSlice(i2);
    }
}
