package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ByteProcessor;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class LineBasedFrameDecoder extends ByteToMessageDecoder {
    private int discardedBytes;
    private boolean discarding;
    private final boolean failFast;
    private final int maxLength;
    private int offset;
    private final boolean stripDelimiter;

    public LineBasedFrameDecoder(int i) {
        this(i, true, false);
    }

    private void fail(ChannelHandlerContext channelHandlerContext, int i) {
        fail(channelHandlerContext, String.valueOf(i));
    }

    private int findEndOfLine(ByteBuf byteBuf) {
        int i = byteBuf.readableBytes();
        int i2 = byteBuf.readerIndex();
        int i4 = this.offset;
        int iForEachByte = byteBuf.forEachByte(i2 + i4, i - i4, ByteProcessor.FIND_LF);
        if (iForEachByte >= 0) {
            this.offset = 0;
            return (iForEachByte <= 0 || byteBuf.getByte(iForEachByte + (-1)) != 13) ? iForEachByte : iForEachByte - 1;
        }
        this.offset = i;
        return iForEachByte;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        Object objDecode = decode(channelHandlerContext, byteBuf);
        if (objDecode != null) {
            list.add(objDecode);
        }
    }

    public LineBasedFrameDecoder(int i, boolean z, boolean z2) {
        this.maxLength = i;
        this.failFast = z2;
        this.stripDelimiter = z;
    }

    private void fail(ChannelHandlerContext channelHandlerContext, String str) {
        channelHandlerContext.fireExceptionCaught((Throwable) new TooLongFrameException(AbstractC0000a.m13j(AbstractC0000a.m15l("frame length (", str, ") exceeds the allowed maximum ("), this.maxLength, PropertyUtils.MAPPED_DELIM2)));
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        int iFindEndOfLine = findEndOfLine(byteBuf);
        if (this.discarding) {
            if (iFindEndOfLine >= 0) {
                int i = (this.discardedBytes + iFindEndOfLine) - byteBuf.readerIndex();
                byteBuf.readerIndex(iFindEndOfLine + (byteBuf.getByte(iFindEndOfLine) != 13 ? 1 : 2));
                this.discardedBytes = 0;
                this.discarding = false;
                if (!this.failFast) {
                    fail(channelHandlerContext, i);
                }
            } else {
                this.discardedBytes = byteBuf.readableBytes() + this.discardedBytes;
                byteBuf.readerIndex(byteBuf.writerIndex());
                this.offset = 0;
            }
            return null;
        }
        if (iFindEndOfLine >= 0) {
            int i2 = iFindEndOfLine - byteBuf.readerIndex();
            int i4 = byteBuf.getByte(iFindEndOfLine) != 13 ? 1 : 2;
            if (i2 > this.maxLength) {
                byteBuf.readerIndex(iFindEndOfLine + i4);
                fail(channelHandlerContext, i2);
                return null;
            }
            if (this.stripDelimiter) {
                ByteBuf retainedSlice = byteBuf.readRetainedSlice(i2);
                byteBuf.skipBytes(i4);
                return retainedSlice;
            }
            return byteBuf.readRetainedSlice(i2 + i4);
        }
        int i5 = byteBuf.readableBytes();
        if (i5 > this.maxLength) {
            this.discardedBytes = i5;
            byteBuf.readerIndex(byteBuf.writerIndex());
            this.discarding = true;
            this.offset = 0;
            if (this.failFast) {
                fail(channelHandlerContext, "over " + this.discardedBytes);
            }
        }
        return null;
    }
}
