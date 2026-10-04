package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class WebSocket00FrameDecoder extends ReplayingDecoder<Void> implements WebSocketFrameDecoder {
    static final int DEFAULT_MAX_FRAME_SIZE = 16384;
    private final long maxFrameSize;
    private boolean receivedClosingHandshake;

    public WebSocket00FrameDecoder() {
        this(16384);
    }

    private WebSocketFrame decodeBinaryFrame(ChannelHandlerContext channelHandlerContext, byte b, ByteBuf byteBuf) {
        byte b5;
        long j = 0;
        int i = 0;
        do {
            b5 = byteBuf.readByte();
            j = (j << 7) | ((long) (b5 & 127));
            if (j > this.maxFrameSize) {
                throw new TooLongFrameException();
            }
            i++;
            if (i > 8) {
                throw new TooLongFrameException();
            }
        } while ((b5 & 128) == 128);
        if (b != -1 || j != 0) {
            return new BinaryWebSocketFrame(ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, (int) j));
        }
        this.receivedClosingHandshake = true;
        return new CloseWebSocketFrame(true, 0, channelHandlerContext.alloc().buffer(0));
    }

    private WebSocketFrame decodeTextFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        int i = byteBuf.readerIndex();
        int iActualReadableBytes = actualReadableBytes();
        int iIndexOf = byteBuf.indexOf(i, i + iActualReadableBytes, (byte) -1);
        if (iIndexOf == -1) {
            if (iActualReadableBytes <= this.maxFrameSize) {
                return null;
            }
            throw new TooLongFrameException();
        }
        int i2 = iIndexOf - i;
        if (i2 > this.maxFrameSize) {
            throw new TooLongFrameException();
        }
        ByteBuf bytes = ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, i2);
        byteBuf.skipBytes(1);
        if (bytes.indexOf(bytes.readerIndex(), bytes.writerIndex(), (byte) -1) < 0) {
            return new TextWebSocketFrame(bytes);
        }
        bytes.release();
        throw new IllegalArgumentException("a text frame should not contain 0xFF.");
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (this.receivedClosingHandshake) {
            byteBuf.skipBytes(actualReadableBytes());
            return;
        }
        byte b = byteBuf.readByte();
        WebSocketFrame webSocketFrameDecodeBinaryFrame = (b & 128) == 128 ? decodeBinaryFrame(channelHandlerContext, b, byteBuf) : decodeTextFrame(channelHandlerContext, byteBuf);
        if (webSocketFrameDecodeBinaryFrame != null) {
            list.add(webSocketFrameDecodeBinaryFrame);
        }
    }

    public WebSocket00FrameDecoder(int i) {
        this.maxFrameSize = i;
    }

    public WebSocket00FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        this.maxFrameSize = ((WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig")).maxFramePayloadLength();
    }
}
