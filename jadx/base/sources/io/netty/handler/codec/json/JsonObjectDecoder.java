package io.netty.handler.codec.json;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class JsonObjectDecoder extends ByteToMessageDecoder {
    private static final int ST_CORRUPTED = -1;
    private static final int ST_DECODING_ARRAY_STREAM = 2;
    private static final int ST_DECODING_NORMAL = 1;
    private static final int ST_INIT = 0;
    private int idx;
    private boolean insideString;
    private int lastReaderIndex;
    private final int maxObjectLength;
    private int openBraces;
    private int state;
    private final boolean streamArrayElements;

    public JsonObjectDecoder() {
        this(1048576);
    }

    private void decodeByte(byte b, ByteBuf byteBuf, int i) {
        if ((b == 123 || b == 91) && !this.insideString) {
            this.openBraces++;
            return;
        }
        if ((b == 125 || b == 93) && !this.insideString) {
            this.openBraces--;
            return;
        }
        if (b == 34) {
            if (!this.insideString) {
                this.insideString = true;
                return;
            }
            int i2 = 0;
            for (int i4 = i - 1; i4 >= 0 && byteBuf.getByte(i4) == 92; i4--) {
                i2++;
            }
            if (i2 % 2 == 0) {
                this.insideString = false;
            }
        }
    }

    private void initDecoding(byte b) {
        this.openBraces = 1;
        if (b == 91 && this.streamArrayElements) {
            this.state = 2;
        } else {
            this.state = 1;
        }
    }

    private void reset() {
        this.insideString = false;
        this.state = 0;
        this.openBraces = 0;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i;
        if (this.state == -1) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        if (this.idx > byteBuf.readerIndex() && this.lastReaderIndex != byteBuf.readerIndex()) {
            this.idx = (this.idx - this.lastReaderIndex) + byteBuf.readerIndex();
        }
        int i2 = this.idx;
        int iWriterIndex = byteBuf.writerIndex();
        if (iWriterIndex > this.maxObjectLength) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            reset();
            throw new TooLongFrameException(AbstractC2322a.m1625o(new StringBuilder("object length exceeds "), this.maxObjectLength, iWriterIndex, ": ", " bytes discarded"));
        }
        while (i2 < iWriterIndex) {
            byte b = byteBuf.getByte(i2);
            int i4 = this.state;
            if (i4 == 1) {
                decodeByte(b, byteBuf, i2);
                if (this.openBraces == 0) {
                    int i5 = i2 + 1;
                    ByteBuf byteBufExtractObject = extractObject(channelHandlerContext, byteBuf, byteBuf.readerIndex(), i5 - byteBuf.readerIndex());
                    if (byteBufExtractObject != null) {
                        list.add(byteBufExtractObject);
                    }
                    byteBuf.readerIndex(i5);
                    reset();
                }
            } else if (i4 == 2) {
                decodeByte(b, byteBuf, i2);
                if (!this.insideString && (((i = this.openBraces) == 1 && b == 44) || (i == 0 && b == 93))) {
                    for (int i6 = byteBuf.readerIndex(); Character.isWhitespace(byteBuf.getByte(i6)); i6++) {
                        byteBuf.skipBytes(1);
                    }
                    int i7 = i2 - 1;
                    while (i7 >= byteBuf.readerIndex() && Character.isWhitespace(byteBuf.getByte(i7))) {
                        i7--;
                    }
                    ByteBuf byteBufExtractObject2 = extractObject(channelHandlerContext, byteBuf, byteBuf.readerIndex(), (i7 + 1) - byteBuf.readerIndex());
                    if (byteBufExtractObject2 != null) {
                        list.add(byteBufExtractObject2);
                    }
                    byteBuf.readerIndex(i2 + 1);
                    if (b == 93) {
                        reset();
                    }
                }
            } else if (b == 123 || b == 91) {
                initDecoding(b);
                if (this.state == 2) {
                    byteBuf.skipBytes(1);
                }
            } else {
                if (!Character.isWhitespace(b)) {
                    this.state = -1;
                    StringBuilder sbM778t = AbstractC0541b.m778t(i2, "invalid JSON received at byte position ", ": ");
                    sbM778t.append(ByteBufUtil.hexDump(byteBuf));
                    throw new CorruptedFrameException(sbM778t.toString());
                }
                byteBuf.skipBytes(1);
            }
            i2++;
        }
        if (byteBuf.readableBytes() == 0) {
            this.idx = 0;
        } else {
            this.idx = i2;
        }
        this.lastReaderIndex = byteBuf.readerIndex();
    }

    public ByteBuf extractObject(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, int i2) {
        return byteBuf.retainedSlice(i, i2);
    }

    public JsonObjectDecoder(int i) {
        this(i, false);
    }

    public JsonObjectDecoder(boolean z) {
        this(1048576, z);
    }

    public JsonObjectDecoder(int i, boolean z) {
        this.maxObjectLength = ObjectUtil.checkPositive(i, "maxObjectLength");
        this.streamArrayElements = z;
    }
}
