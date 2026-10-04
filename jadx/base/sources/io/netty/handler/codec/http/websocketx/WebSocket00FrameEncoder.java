package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class WebSocket00FrameEncoder extends MessageToMessageEncoder<WebSocketFrame> implements WebSocketFrameEncoder {
    private static final ByteBuf _0X00 = Unpooled.unreleasableBuffer(Unpooled.directBuffer(1, 1).writeByte(0)).asReadOnly();
    private static final ByteBuf _0XFF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(1, 1).writeByte(-1)).asReadOnly();
    private static final ByteBuf _0XFF_0X00 = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2, 2).writeByte(-1).writeByte(0)).asReadOnly();

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) {
        encode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) {
        if (webSocketFrame instanceof TextWebSocketFrame) {
            ByteBuf byteBufContent = webSocketFrame.content();
            list.add(_0X00.duplicate());
            list.add(byteBufContent.retain());
            list.add(_0XFF.duplicate());
            return;
        }
        if (webSocketFrame instanceof CloseWebSocketFrame) {
            list.add(_0XFF_0X00.duplicate());
            return;
        }
        ByteBuf byteBufContent2 = webSocketFrame.content();
        int i = byteBufContent2.readableBytes();
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(5);
        try {
            byteBufBuffer.writeByte(-128);
            int i2 = (i >>> 28) & 127;
            int i4 = (i >>> 14) & 127;
            int i5 = (i >>> 7) & 127;
            int i6 = i & 127;
            if (i2 != 0) {
                byteBufBuffer.writeByte(i2 | 128);
                byteBufBuffer.writeByte(i4 | 128);
                byteBufBuffer.writeByte(i5 | 128);
                byteBufBuffer.writeByte(i6);
            } else if (i4 == 0) {
                if (i5 != 0) {
                    byteBufBuffer.writeByte(i5 | 128);
                }
                byteBufBuffer.writeByte(i6);
            } else {
                byteBufBuffer.writeByte(i4 | 128);
                byteBufBuffer.writeByte(i5 | 128);
                byteBufBuffer.writeByte(i6);
            }
            list.add(byteBufBuffer);
            list.add(byteBufContent2.retain());
        } catch (Throwable th) {
            byteBufBuffer.release();
            throw th;
        }
    }
}
