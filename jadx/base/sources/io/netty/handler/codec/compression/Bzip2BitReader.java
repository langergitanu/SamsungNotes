package io.netty.handler.codec.compression;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class Bzip2BitReader {
    private static final int MAX_COUNT_OF_READABLE_BYTES = 268435455;
    private long bitBuffer;
    private int bitCount;

    /* JADX INFO: renamed from: in */
    private ByteBuf f8874in;

    public boolean hasReadableBits(int i) {
        if (i >= 0) {
            return this.bitCount >= i || ((this.f8874in.readableBytes() << 3) & Integer.MAX_VALUE) >= i - this.bitCount;
        }
        throw new IllegalArgumentException(AbstractC0541b.m767i(i, "count: ", " (expected value greater than 0)"));
    }

    public boolean hasReadableBytes(int i) {
        if (i < 0 || i > MAX_COUNT_OF_READABLE_BYTES) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "count: ", " (expected: 0-268435455)"));
        }
        return hasReadableBits(i << 3);
    }

    public boolean isReadable() {
        return this.bitCount > 0 || this.f8874in.isReadable();
    }

    public int readBits(int i) {
        long unsignedByte;
        int i2;
        if (i < 0 || i > 32) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "count: ", " (expected: 0-32 )"));
        }
        int i4 = this.bitCount;
        long j = this.bitBuffer;
        if (i4 < i) {
            int i5 = this.f8874in.readableBytes();
            if (i5 == 1) {
                unsignedByte = this.f8874in.readUnsignedByte();
                i2 = 8;
            } else if (i5 == 2) {
                unsignedByte = this.f8874in.readUnsignedShort();
                i2 = 16;
            } else if (i5 != 3) {
                unsignedByte = this.f8874in.readUnsignedInt();
                i2 = 32;
            } else {
                unsignedByte = this.f8874in.readUnsignedMedium();
                i2 = 24;
            }
            j = (j << i2) | unsignedByte;
            i4 += i2;
            this.bitBuffer = j;
        }
        int i6 = i4 - i;
        this.bitCount = i6;
        return (int) ((j >>> i6) & (i != 32 ? (1 << i) - 1 : 4294967295L));
    }

    public boolean readBoolean() {
        return readBits(1) != 0;
    }

    public int readInt() {
        return readBits(32);
    }

    public void refill() {
        this.bitBuffer = (this.bitBuffer << 8) | ((long) this.f8874in.readUnsignedByte());
        this.bitCount += 8;
    }

    public void setByteBuf(ByteBuf byteBuf) {
        this.f8874in = byteBuf;
    }
}
