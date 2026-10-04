package io.netty.handler.codec.http.websocketx;

import androidx.collection.AbstractC0622a;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteOrder;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class WebSocket08FrameDecoder extends ByteToMessageDecoder implements WebSocketFrameDecoder {
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocket08FrameDecoder.class);
    private final WebSocketDecoderConfig config;
    private int fragmentedFramesCount;
    private boolean frameFinalFlag;
    private boolean frameMasked;
    private int frameOpcode;
    private int framePayloadLen1;
    private long framePayloadLength;
    private int frameRsv;
    private int mask;
    private boolean receivedClosingHandshake;
    private State state;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125411 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State */
        static final /* synthetic */ int[] f8898xda7b7094;

        static {
            int[] iArr = new int[State.values().length];
            f8898xda7b7094 = iArr;
            try {
                iArr[State.READING_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8898xda7b7094[State.READING_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8898xda7b7094[State.READING_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8898xda7b7094[State.MASKING_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8898xda7b7094[State.PAYLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8898xda7b7094[State.CORRUPT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        READING_FIRST,
        READING_SECOND,
        READING_SIZE,
        MASKING_KEY,
        PAYLOAD,
        CORRUPT
    }

    public WebSocket08FrameDecoder(boolean z, boolean z2, int i) {
        this(z, z2, i, false);
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, String str) {
        protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.PROTOCOL_ERROR, str);
    }

    private static int toFrameLength(long j) {
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new TooLongFrameException(AbstractC0622a.m1169o("Length:", j));
    }

    private void unmask(ByteBuf byteBuf) {
        int i = byteBuf.readerIndex();
        int iWriterIndex = byteBuf.writerIndex();
        ByteOrder byteOrderOrder = byteBuf.order();
        int iReverseBytes = this.mask;
        long j = ((long) iReverseBytes) & 4294967295L;
        long j2 = j | (j << 32);
        int i2 = iWriterIndex - 7;
        while (i < i2) {
            byteBuf.setLong(i, byteBuf.getLong(i) ^ j2);
            i += 8;
        }
        if (i < iWriterIndex - 3) {
            byteBuf.setInt(i, ((int) j2) ^ byteBuf.getInt(i));
            i += 4;
        }
        if (byteOrderOrder == ByteOrder.LITTLE_ENDIAN) {
            iReverseBytes = Integer.reverseBytes(iReverseBytes);
        }
        int i4 = 0;
        while (i < iWriterIndex) {
            byteBuf.setByte(i, WebSocketUtil.byteAtIndex(iReverseBytes, i4 & 3) ^ byteBuf.getByte(i));
            i++;
            i4++;
        }
    }

    public void checkCloseFrameBody(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        if (byteBuf == null || !byteBuf.isReadable()) {
            return;
        }
        if (byteBuf.readableBytes() < 2) {
            protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "Invalid close frame body");
        }
        short s = byteBuf.getShort(byteBuf.readerIndex());
        if (!WebSocketCloseStatus.isValidStatusCode(s)) {
            protocolViolation(channelHandlerContext, byteBuf, AbstractC0000a.m11h(s, "Invalid close frame getStatus code: "));
        }
        if (byteBuf.readableBytes() > 2) {
            try {
                new Utf8Validator().check(byteBuf, byteBuf.readerIndex() + 2, byteBuf.readableBytes() - 2);
            } catch (CorruptedWebSocketFrameException e) {
                protocolViolation(channelHandlerContext, byteBuf, e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016e  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        long j;
        int i;
        long j2;
        long j3;
        if (this.receivedClosingHandshake) {
            byteBuf.skipBytes(actualReadableBytes());
            return;
        }
        switch (C125411.f8898xda7b7094[this.state.ordinal()]) {
            case 1:
                if (byteBuf.isReadable()) {
                    this.framePayloadLength = 0L;
                    byte b = byteBuf.readByte();
                    j = 0;
                    this.frameFinalFlag = (b & 128) != 0;
                    this.frameRsv = (b & SprAttributeBase.TYPE_SHADOW) >> 4;
                    this.frameOpcode = b & 15;
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isTraceEnabled()) {
                        internalLogger.trace("Decoding WebSocket Frame opCode={}", Integer.valueOf(this.frameOpcode));
                    }
                    this.state = State.READING_SECOND;
                    if (byteBuf.isReadable()) {
                        return;
                    }
                    byte b5 = byteBuf.readByte();
                    this.frameMasked = (b5 & 128) != 0;
                    this.framePayloadLen1 = b5 & 127;
                    if (this.frameRsv != 0 && !this.config.allowExtensions()) {
                        protocolViolation(channelHandlerContext, byteBuf, "RSV != 0 and no extension negotiated, RSV:" + this.frameRsv);
                        return;
                    }
                    if (!this.config.allowMaskMismatch() && this.config.expectMaskedFrames() != this.frameMasked) {
                        protocolViolation(channelHandlerContext, byteBuf, "received a frame that is not masked as expected");
                        return;
                    }
                    int i2 = this.frameOpcode;
                    if (i2 > 7) {
                        if (!this.frameFinalFlag) {
                            protocolViolation(channelHandlerContext, byteBuf, "fragmented control frame");
                            return;
                        }
                        int i4 = this.framePayloadLen1;
                        if (i4 > 125) {
                            protocolViolation(channelHandlerContext, byteBuf, "control frame with payload length > 125 octets");
                            return;
                        }
                        if (i2 != 8 && i2 != 9 && i2 != 10) {
                            protocolViolation(channelHandlerContext, byteBuf, "control frame using reserved opcode " + this.frameOpcode);
                            return;
                        } else if (i2 == 8 && i4 == 1) {
                            protocolViolation(channelHandlerContext, byteBuf, "received close control frame with payload len 1");
                            return;
                        }
                    } else {
                        if (i2 != 0 && i2 != 1 && i2 != 2) {
                            protocolViolation(channelHandlerContext, byteBuf, "data frame using reserved opcode " + this.frameOpcode);
                            return;
                        }
                        int i5 = this.fragmentedFramesCount;
                        if (i5 == 0 && i2 == 0) {
                            protocolViolation(channelHandlerContext, byteBuf, "received continuation data frame outside fragmented message");
                            return;
                        } else if (i5 != 0 && i2 != 0) {
                            protocolViolation(channelHandlerContext, byteBuf, "received non-continuation data frame while inside fragmented message");
                            return;
                        }
                    }
                    this.state = State.READING_SIZE;
                    i = this.framePayloadLen1;
                    if (i != 126) {
                        if (byteBuf.readableBytes() < 2) {
                            return;
                        }
                        long unsignedShort = byteBuf.readUnsignedShort();
                        this.framePayloadLength = unsignedShort;
                        if (unsignedShort < 126) {
                            protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (not using minimal length encoding)");
                            return;
                        }
                    } else if (i != 127) {
                        this.framePayloadLength = i;
                    } else {
                        if (byteBuf.readableBytes() < 8) {
                            return;
                        }
                        long j5 = byteBuf.readLong();
                        this.framePayloadLength = j5;
                        if (j5 < j) {
                            protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (negative length)");
                            return;
                        } else if (j5 < 65536) {
                            protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (not using minimal length encoding)");
                            return;
                        }
                    }
                    if (this.framePayloadLength <= this.config.maxFramePayloadLength()) {
                        protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.MESSAGE_TOO_BIG, "Max frame length of " + this.config.maxFramePayloadLength() + " has been exceeded.");
                        return;
                    }
                    InternalLogger internalLogger2 = logger;
                    if (internalLogger2.isTraceEnabled()) {
                        internalLogger2.trace("Decoding WebSocket Frame length={}", Long.valueOf(this.framePayloadLength));
                    }
                    this.state = State.MASKING_KEY;
                    if (this.frameMasked) {
                        if (byteBuf.readableBytes() < 4) {
                            return;
                        } else {
                            this.mask = byteBuf.readInt();
                        }
                    }
                    this.state = State.PAYLOAD;
                    j2 = byteBuf.readableBytes();
                    j3 = this.framePayloadLength;
                    if (j2 < j3) {
                        return;
                    }
                    ByteBuf bytes = Unpooled.EMPTY_BUFFER;
                    if (j3 > j) {
                        try {
                            bytes = ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, toFrameLength(this.framePayloadLength));
                        } catch (Throwable th) {
                            if (bytes != null) {
                                bytes.release();
                            }
                            throw th;
                        }
                    }
                    this.state = State.READING_FIRST;
                    if (this.frameMasked & (this.framePayloadLength > j)) {
                        unmask(bytes);
                    }
                    int i6 = this.frameOpcode;
                    if (i6 == 9) {
                        list.add(new PingWebSocketFrame(this.frameFinalFlag, this.frameRsv, bytes));
                        return;
                    }
                    if (i6 == 10) {
                        list.add(new PongWebSocketFrame(this.frameFinalFlag, this.frameRsv, bytes));
                        return;
                    }
                    if (i6 == 8) {
                        this.receivedClosingHandshake = true;
                        checkCloseFrameBody(channelHandlerContext, bytes);
                        list.add(new CloseWebSocketFrame(this.frameFinalFlag, this.frameRsv, bytes));
                        return;
                    }
                    boolean z = this.frameFinalFlag;
                    if (z) {
                        this.fragmentedFramesCount = 0;
                    } else {
                        this.fragmentedFramesCount++;
                    }
                    if (i6 == 1) {
                        list.add(new TextWebSocketFrame(z, this.frameRsv, bytes));
                        return;
                    }
                    if (i6 == 2) {
                        list.add(new BinaryWebSocketFrame(z, this.frameRsv, bytes));
                        return;
                    } else if (i6 == 0) {
                        list.add(new ContinuationWebSocketFrame(z, this.frameRsv, bytes));
                        return;
                    } else {
                        throw new UnsupportedOperationException("Cannot decode web socket frame with opcode: " + this.frameOpcode);
                    }
                }
                return;
            case 2:
                j = 0;
                if (byteBuf.isReadable()) {
                }
                break;
            case 3:
                j = 0;
                i = this.framePayloadLen1;
                if (i != 126) {
                }
                if (this.framePayloadLength <= this.config.maxFramePayloadLength()) {
                }
                break;
            case 4:
                j = 0;
                if (this.frameMasked) {
                }
                this.state = State.PAYLOAD;
                j2 = byteBuf.readableBytes();
                j3 = this.framePayloadLength;
                if (j2 < j3) {
                }
                break;
            case 5:
                j = 0;
                j2 = byteBuf.readableBytes();
                j3 = this.framePayloadLength;
                if (j2 < j3) {
                }
                break;
            case 6:
                if (byteBuf.isReadable()) {
                    byteBuf.readByte();
                    return;
                }
                return;
            default:
                throw new Error("Shouldn't reach here.");
        }
    }

    public WebSocket08FrameDecoder(boolean z, boolean z2, int i, boolean z3) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z).allowExtensions(z2).maxFramePayloadLength(i).allowMaskMismatch(z3).build());
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, WebSocketCloseStatus webSocketCloseStatus, String str) {
        protocolViolation(channelHandlerContext, byteBuf, new CorruptedWebSocketFrameException(webSocketCloseStatus, str));
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, CorruptedWebSocketFrameException corruptedWebSocketFrameException) {
        Object closeWebSocketFrame;
        this.state = State.CORRUPT;
        int i = byteBuf.readableBytes();
        if (i > 0) {
            byteBuf.skipBytes(i);
        }
        if (channelHandlerContext.channel().isActive() && this.config.closeOnProtocolViolation()) {
            if (!this.receivedClosingHandshake) {
                WebSocketCloseStatus webSocketCloseStatusCloseStatus = corruptedWebSocketFrameException.closeStatus();
                String message = corruptedWebSocketFrameException.getMessage();
                if (message == null) {
                    message = webSocketCloseStatusCloseStatus.reasonText();
                }
                closeWebSocketFrame = new CloseWebSocketFrame(webSocketCloseStatusCloseStatus, message);
            } else {
                closeWebSocketFrame = Unpooled.EMPTY_BUFFER;
            }
            channelHandlerContext.writeAndFlush(closeWebSocketFrame).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            throw corruptedWebSocketFrameException;
        }
        throw corruptedWebSocketFrameException;
    }

    public WebSocket08FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        this.state = State.READING_FIRST;
        this.config = (WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
    }
}
