package io.netty.handler.codec.http.websocketx;

import com.sun.imageio.plugins.jpeg.JPEG;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteOrder;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class WebSocket08FrameEncoder extends MessageToMessageEncoder<WebSocketFrame> implements WebSocketFrameEncoder {
    private static final int GATHERING_WRITE_THRESHOLD = 1024;
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocket08FrameEncoder.class);
    private final boolean maskPayload;

    public WebSocket08FrameEncoder(boolean z) {
        this.maskPayload = z;
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) {
        encode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) {
        byte b;
        ByteBuf byteBufBuffer;
        ByteBuf byteBufContent = webSocketFrame.content();
        int i = 0;
        if (webSocketFrame instanceof TextWebSocketFrame) {
            b = 1;
        } else if (webSocketFrame instanceof PingWebSocketFrame) {
            b = 9;
        } else if (webSocketFrame instanceof PongWebSocketFrame) {
            b = 10;
        } else if (webSocketFrame instanceof CloseWebSocketFrame) {
            b = 8;
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            b = 2;
        } else {
            if (!(webSocketFrame instanceof ContinuationWebSocketFrame)) {
                throw new UnsupportedOperationException("Cannot encode frame of type: ".concat(webSocketFrame.getClass().getName()));
            }
            b = 0;
        }
        int i2 = byteBufContent.readableBytes();
        InternalLogger internalLogger = logger;
        if (internalLogger.isTraceEnabled()) {
            internalLogger.trace("Encoding WebSocket Frame opCode={} length={}", Byte.valueOf(b), Integer.valueOf(i2));
        }
        int iRsv = ((webSocketFrame.rsv() % 8) << 4) | (webSocketFrame.isFinalFragment() ? 128 : 0) | (b % 128);
        if (b == 9 && i2 > 125) {
            throw new TooLongFrameException(AbstractC0000a.m11h(i2, "invalid payload for PING (payload length must be <= 125, was "));
        }
        ReferenceCounted referenceCounted = null;
        try {
            boolean z = this.maskPayload;
            int i4 = z ? 4 : 0;
            if (i2 <= 125) {
                byteBufBuffer = channelHandlerContext.alloc().buffer(i4 + 2 + i2);
                byteBufBuffer.writeByte(iRsv);
                byteBufBuffer.writeByte((byte) (this.maskPayload ? ((byte) i2) | 128 : (byte) i2));
            } else {
                int i5 = 255;
                if (i2 <= 65535) {
                    int i6 = i4 + 4;
                    if (z || i2 <= 1024) {
                        i6 += i2;
                    }
                    byteBufBuffer = channelHandlerContext.alloc().buffer(i6);
                    byteBufBuffer.writeByte(iRsv);
                    byteBufBuffer.writeByte(this.maskPayload ? JPEG.COM : 126);
                    byteBufBuffer.writeByte((i2 >>> 8) & 255);
                    byteBufBuffer.writeByte(i2 & 255);
                } else {
                    int i7 = i4 + 10;
                    if (z) {
                        i7 += i2;
                    }
                    byteBufBuffer = channelHandlerContext.alloc().buffer(i7);
                    byteBufBuffer.writeByte(iRsv);
                    if (!this.maskPayload) {
                        i5 = 127;
                    }
                    byteBufBuffer.writeByte(i5);
                    byteBufBuffer.writeLong(i2);
                }
            }
            if (!this.maskPayload) {
                if (byteBufBuffer.writableBytes() >= byteBufContent.readableBytes()) {
                    byteBufBuffer.writeBytes(byteBufContent);
                    list.add(byteBufBuffer);
                    return;
                } else {
                    list.add(byteBufBuffer);
                    list.add(byteBufContent.retain());
                    return;
                }
            }
            int iNextInt = PlatformDependent.threadLocalRandom().nextInt(Integer.MAX_VALUE);
            byteBufBuffer.writeInt(iNextInt);
            if (byteBufContent.isReadable()) {
                ByteOrder byteOrderOrder = byteBufContent.order();
                ByteOrder byteOrderOrder2 = byteBufBuffer.order();
                int i8 = byteBufContent.readerIndex();
                int iWriterIndex = byteBufContent.writerIndex();
                if (byteOrderOrder == byteOrderOrder2) {
                    long j = ((long) iNextInt) & 4294967295L;
                    long jReverseBytes = j | (j << 32);
                    if (byteOrderOrder == ByteOrder.LITTLE_ENDIAN) {
                        jReverseBytes = Long.reverseBytes(jReverseBytes);
                    }
                    int i9 = iWriterIndex - 7;
                    while (i8 < i9) {
                        byteBufBuffer.writeLong(byteBufContent.getLong(i8) ^ jReverseBytes);
                        i8 += 8;
                    }
                    if (i8 < iWriterIndex - 3) {
                        byteBufBuffer.writeInt(byteBufContent.getInt(i8) ^ ((int) jReverseBytes));
                        i8 += 4;
                    }
                }
                while (i8 < iWriterIndex) {
                    byteBufBuffer.writeByte(byteBufContent.getByte(i8) ^ WebSocketUtil.byteAtIndex(iNextInt, i & 3));
                    i8++;
                    i++;
                }
            }
            list.add(byteBufBuffer);
        } catch (Throwable th) {
            if (0 != 0) {
                referenceCounted.release();
            }
            throw th;
        }
    }
}
