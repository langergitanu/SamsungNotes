package io.netty.handler.codec.compression;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Bzip2BitWriter {
    private long bitBuffer;
    private int bitCount;

    public void flush(ByteBuf byteBuf) {
        int i = this.bitCount;
        if (i > 0) {
            long j = this.bitBuffer;
            int i2 = 64 - i;
            if (i <= 8) {
                byteBuf.writeByte((int) ((j >>> i2) << (8 - i)));
                return;
            }
            if (i <= 16) {
                byteBuf.writeShort((int) ((j >>> i2) << (16 - i)));
            } else if (i <= 24) {
                byteBuf.writeMedium((int) ((j >>> i2) << (24 - i)));
            } else {
                byteBuf.writeInt((int) ((j >>> i2) << (32 - i)));
            }
        }
    }

    public void writeBits(ByteBuf byteBuf, int i, long j) {
        if (i < 0 || i > 32) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "count: ", " (expected: 0-32)"));
        }
        int i2 = this.bitCount;
        long j2 = ((j << (64 - i)) >>> i2) | this.bitBuffer;
        int i4 = i2 + i;
        if (i4 >= 32) {
            byteBuf.writeInt((int) (j2 >>> 32));
            j2 <<= 32;
            i4 -= 32;
        }
        this.bitBuffer = j2;
        this.bitCount = i4;
    }

    public void writeBoolean(ByteBuf byteBuf, boolean z) {
        int i = this.bitCount + 1;
        long j = 0;
        long j2 = this.bitBuffer | (z ? 1 << (64 - i) : 0L);
        if (i == 32) {
            byteBuf.writeInt((int) (j2 >>> 32));
            i = 0;
        } else {
            j = j2;
        }
        this.bitBuffer = j;
        this.bitCount = i;
    }

    public void writeInt(ByteBuf byteBuf, int i) {
        writeBits(byteBuf, 32, i);
    }

    public void writeUnary(ByteBuf byteBuf, int i) {
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "value: ", " (expected 0 or more)"));
        }
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                writeBoolean(byteBuf, false);
                return;
            } else {
                writeBoolean(byteBuf, true);
                i = i2;
            }
        }
    }
}
