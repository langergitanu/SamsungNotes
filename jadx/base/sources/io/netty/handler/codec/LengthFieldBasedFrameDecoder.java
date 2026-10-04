package io.netty.handler.codec;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class LengthFieldBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteOrder byteOrder;
    private long bytesToDiscard;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private int frameLengthInt;
    private final int initialBytesToStrip;
    private final int lengthAdjustment;
    private final int lengthFieldEndOffset;
    private final int lengthFieldLength;
    private final int lengthFieldOffset;
    private final int maxFrameLength;
    private long tooLongFrameLength;

    public LengthFieldBasedFrameDecoder(int i, int i2, int i4) {
        this(i, i2, i4, 0, 0);
    }

    private void discardingTooLongFrame(ByteBuf byteBuf) {
        long j = this.bytesToDiscard;
        int iMin = (int) Math.min(j, byteBuf.readableBytes());
        byteBuf.skipBytes(iMin);
        this.bytesToDiscard = j - ((long) iMin);
        failIfNecessary(false);
    }

    private void exceededFrameLength(ByteBuf byteBuf, long j) {
        long j2 = j - ((long) byteBuf.readableBytes());
        this.tooLongFrameLength = j;
        if (j2 < 0) {
            byteBuf.skipBytes((int) j);
        } else {
            this.discardingTooLongFrame = true;
            this.bytesToDiscard = j2;
            byteBuf.skipBytes(byteBuf.readableBytes());
        }
        failIfNecessary(true);
    }

    private void fail(long j) {
        if (j <= 0) {
            throw new TooLongFrameException(AbstractC2821a.m2223n(new StringBuilder("Adjusted frame length exceeds "), " - discarding", this.maxFrameLength));
        }
        throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded");
    }

    private void failIfNecessary(boolean z) {
        if (this.bytesToDiscard != 0) {
            if (this.failFast && z) {
                fail(this.tooLongFrameLength);
                return;
            }
            return;
        }
        long j = this.tooLongFrameLength;
        this.tooLongFrameLength = 0L;
        this.discardingTooLongFrame = false;
        if (!this.failFast || z) {
            fail(j);
        }
    }

    private static void failOnFrameLengthLessThanInitialBytesToStrip(ByteBuf byteBuf, long j, int i) {
        byteBuf.skipBytes((int) j);
        throw new CorruptedFrameException("Adjusted frame length (" + j + ") is less than initialBytesToStrip: " + i);
    }

    private static void failOnFrameLengthLessThanLengthFieldEndOffset(ByteBuf byteBuf, long j, int i) {
        byteBuf.skipBytes(i);
        throw new CorruptedFrameException("Adjusted frame length (" + j + ") is less than lengthFieldEndOffset: " + i);
    }

    private static void failOnNegativeLengthField(ByteBuf byteBuf, long j, int i) {
        byteBuf.skipBytes(i);
        throw new CorruptedFrameException(AbstractC0622a.m1169o("negative pre-adjustment length field: ", j));
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        Object objDecode = decode(channelHandlerContext, byteBuf);
        if (objDecode != null) {
            list.add(objDecode);
        }
    }

    public ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, int i2) {
        return byteBuf.retainedSlice(i, i2);
    }

    public long getUnadjustedFrameLength(ByteBuf byteBuf, int i, int i2, ByteOrder byteOrder) {
        int unsignedByte;
        ByteBuf byteBufOrder = byteBuf.order(byteOrder);
        if (i2 == 1) {
            unsignedByte = byteBufOrder.getUnsignedByte(i);
        } else if (i2 == 2) {
            unsignedByte = byteBufOrder.getUnsignedShort(i);
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    return byteBufOrder.getUnsignedInt(i);
                }
                if (i2 == 8) {
                    return byteBufOrder.getLong(i);
                }
                throw new DecoderException(AbstractC2821a.m2223n(new StringBuilder("unsupported lengthFieldLength: "), " (expected: 1, 2, 3, 4, or 8)", this.lengthFieldLength));
            }
            unsignedByte = byteBufOrder.getUnsignedMedium(i);
        }
        return unsignedByte;
    }

    public LengthFieldBasedFrameDecoder(int i, int i2, int i4, int i5, int i6) {
        this(i, i2, i4, i5, i6, true);
    }

    public LengthFieldBasedFrameDecoder(int i, int i2, int i4, int i5, int i6, boolean z) {
        this(ByteOrder.BIG_ENDIAN, i, i2, i4, i5, i6, z);
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        long j = 0;
        if (this.frameLengthInt == -1) {
            if (this.discardingTooLongFrame) {
                discardingTooLongFrame(byteBuf);
            }
            if (byteBuf.readableBytes() < this.lengthFieldEndOffset) {
                return null;
            }
            long unadjustedFrameLength = getUnadjustedFrameLength(byteBuf, byteBuf.readerIndex() + this.lengthFieldOffset, this.lengthFieldLength, this.byteOrder);
            if (unadjustedFrameLength < 0) {
                failOnNegativeLengthField(byteBuf, unadjustedFrameLength, this.lengthFieldEndOffset);
            }
            int i = this.lengthAdjustment;
            int i2 = this.lengthFieldEndOffset;
            long j2 = unadjustedFrameLength + ((long) (i + i2));
            if (j2 < i2) {
                failOnFrameLengthLessThanLengthFieldEndOffset(byteBuf, j2, i2);
            }
            if (j2 > this.maxFrameLength) {
                exceededFrameLength(byteBuf, j2);
                return null;
            }
            this.frameLengthInt = (int) j2;
            j = j2;
        }
        int i4 = byteBuf.readableBytes();
        int i5 = this.frameLengthInt;
        if (i4 < i5) {
            return null;
        }
        int i6 = this.initialBytesToStrip;
        if (i6 > i5) {
            failOnFrameLengthLessThanInitialBytesToStrip(byteBuf, j, i6);
        }
        byteBuf.skipBytes(this.initialBytesToStrip);
        int i7 = byteBuf.readerIndex();
        int i8 = this.frameLengthInt - this.initialBytesToStrip;
        ByteBuf byteBufExtractFrame = extractFrame(channelHandlerContext, byteBuf, i7, i8);
        byteBuf.readerIndex(i7 + i8);
        this.frameLengthInt = -1;
        return byteBufExtractFrame;
    }

    public LengthFieldBasedFrameDecoder(ByteOrder byteOrder, int i, int i2, int i4, int i5, int i6, boolean z) {
        this.frameLengthInt = -1;
        this.byteOrder = (ByteOrder) ObjectUtil.checkNotNull(byteOrder, "byteOrder");
        ObjectUtil.checkPositive(i, "maxFrameLength");
        ObjectUtil.checkPositiveOrZero(i2, "lengthFieldOffset");
        ObjectUtil.checkPositiveOrZero(i6, "initialBytesToStrip");
        if (i2 <= i - i4) {
            this.maxFrameLength = i;
            this.lengthFieldOffset = i2;
            this.lengthFieldLength = i4;
            this.lengthAdjustment = i5;
            this.lengthFieldEndOffset = i2 + i4;
            this.initialBytesToStrip = i6;
            this.failFast = z;
            return;
        }
        throw new IllegalArgumentException(AbstractC2821a.m2223n(AbstractC0622a.m1173s(i, i2, "maxFrameLength (", ") must be equal to or greater than lengthFieldOffset (", ") + lengthFieldLength ("), ").", i4));
    }
}
