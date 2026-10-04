package io.netty.handler.codec;

import androidx.glance.AbstractC2821a;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DelimiterBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteBuf[] delimiters;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private final LineBasedFrameDecoder lineBasedDecoder;
    private final int maxFrameLength;
    private final boolean stripDelimiter;
    private int tooLongFrameLength;

    public DelimiterBasedFrameDecoder(int i, ByteBuf byteBuf) {
        this(i, true, byteBuf);
    }

    private void fail(long j) {
        if (j <= 0) {
            throw new TooLongFrameException(AbstractC2821a.m2223n(new StringBuilder("frame length exceeds "), " - discarding", this.maxFrameLength));
        }
        throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded");
    }

    private static int indexOf(ByteBuf byteBuf, ByteBuf byteBuf2) {
        for (int i = byteBuf.readerIndex(); i < byteBuf.writerIndex(); i++) {
            int i2 = 0;
            int i4 = i;
            while (i2 < byteBuf2.capacity() && byteBuf.getByte(i4) == byteBuf2.getByte(i2)) {
                i4++;
                if (i4 == byteBuf.writerIndex() && i2 != byteBuf2.capacity() - 1) {
                    return -1;
                }
                i2++;
            }
            if (i2 == byteBuf2.capacity()) {
                return i - byteBuf.readerIndex();
            }
        }
        return -1;
    }

    private static boolean isLineBased(ByteBuf[] byteBufArr) {
        if (byteBufArr.length != 2) {
            return false;
        }
        ByteBuf byteBuf = byteBufArr[0];
        ByteBuf byteBuf2 = byteBufArr[1];
        if (byteBuf.capacity() < byteBuf2.capacity()) {
            byteBuf = byteBufArr[1];
            byteBuf2 = byteBufArr[0];
        }
        return byteBuf.capacity() == 2 && byteBuf2.capacity() == 1 && byteBuf.getByte(0) == 13 && byteBuf.getByte(1) == 10 && byteBuf2.getByte(0) == 10;
    }

    private boolean isSubclass() {
        return getClass() != DelimiterBasedFrameDecoder.class;
    }

    private static void validateDelimiter(ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "delimiter");
        if (!byteBuf.isReadable()) {
            throw new IllegalArgumentException("empty delimiter");
        }
    }

    private static void validateMaxFrameLength(int i) {
        ObjectUtil.checkPositive(i, "maxFrameLength");
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        Object objDecode = decode(channelHandlerContext, byteBuf);
        if (objDecode != null) {
            list.add(objDecode);
        }
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, ByteBuf byteBuf) {
        this(i, z, true, byteBuf);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, boolean z2, ByteBuf byteBuf) {
        this(i, z, z2, byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes()));
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        LineBasedFrameDecoder lineBasedFrameDecoder = this.lineBasedDecoder;
        if (lineBasedFrameDecoder != null) {
            return lineBasedFrameDecoder.decode(channelHandlerContext, byteBuf);
        }
        int i = Integer.MAX_VALUE;
        ByteBuf byteBuf2 = null;
        for (ByteBuf byteBuf3 : this.delimiters) {
            int iIndexOf = indexOf(byteBuf, byteBuf3);
            if (iIndexOf >= 0 && iIndexOf < i) {
                byteBuf2 = byteBuf3;
                i = iIndexOf;
            }
        }
        if (byteBuf2 != null) {
            int iCapacity = byteBuf2.capacity();
            if (this.discardingTooLongFrame) {
                this.discardingTooLongFrame = false;
                byteBuf.skipBytes(i + iCapacity);
                int i2 = this.tooLongFrameLength;
                this.tooLongFrameLength = 0;
                if (!this.failFast) {
                    fail(i2);
                }
                return null;
            }
            if (i > this.maxFrameLength) {
                byteBuf.skipBytes(iCapacity + i);
                fail(i);
                return null;
            }
            if (this.stripDelimiter) {
                ByteBuf retainedSlice = byteBuf.readRetainedSlice(i);
                byteBuf.skipBytes(iCapacity);
                return retainedSlice;
            }
            return byteBuf.readRetainedSlice(i + iCapacity);
        }
        if (!this.discardingTooLongFrame) {
            if (byteBuf.readableBytes() > this.maxFrameLength) {
                this.tooLongFrameLength = byteBuf.readableBytes();
                byteBuf.skipBytes(byteBuf.readableBytes());
                this.discardingTooLongFrame = true;
                if (this.failFast) {
                    fail(this.tooLongFrameLength);
                }
            }
        } else {
            this.tooLongFrameLength = byteBuf.readableBytes() + this.tooLongFrameLength;
            byteBuf.skipBytes(byteBuf.readableBytes());
        }
        return null;
    }

    public DelimiterBasedFrameDecoder(int i, ByteBuf... byteBufArr) {
        this(i, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, ByteBuf... byteBufArr) {
        this(i, z, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, boolean z2, ByteBuf... byteBufArr) {
        validateMaxFrameLength(i);
        ObjectUtil.checkNonEmpty(byteBufArr, "delimiters");
        if (isLineBased(byteBufArr) && !isSubclass()) {
            this.lineBasedDecoder = new LineBasedFrameDecoder(i, z, z2);
            this.delimiters = null;
        } else {
            this.delimiters = new ByteBuf[byteBufArr.length];
            for (int i2 = 0; i2 < byteBufArr.length; i2++) {
                ByteBuf byteBuf = byteBufArr[i2];
                validateDelimiter(byteBuf);
                this.delimiters[i2] = byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes());
            }
            this.lineBasedDecoder = null;
        }
        this.maxFrameLength = i;
        this.stripDelimiter = z;
        this.failFast = z2;
    }
}
