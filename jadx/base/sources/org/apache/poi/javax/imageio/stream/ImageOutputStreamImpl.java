package org.apache.poi.javax.imageio.stream;

import androidx.compose.runtime.AbstractC1974b;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ImageOutputStreamImpl extends ImageInputStreamImpl implements ImageOutputStream {
    public final void flushBits() throws IOException {
        int i;
        checkClosed();
        int i2 = this.bitOffset;
        if (i2 != 0) {
            int i4 = read();
            if (i4 < 0) {
                i = 0;
                this.bitOffset = 0;
            } else {
                seek(getStreamPosition() - 1);
                i = ((-1) << (8 - i2)) & i4;
            }
            write(i);
        }
    }

    public abstract void write(int i);

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public abstract void write(byte[] bArr, int i, int i2);

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void writeBit(int i) throws IOException {
        writeBits(1 & ((long) i), 1);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void writeBits(long j, int i) throws IOException {
        checkClosed();
        if (i < 0 || i > 64) {
            throw new IllegalArgumentException("Bad value for numBits!");
        }
        if (i == 0) {
            return;
        }
        int i2 = 0;
        if (getStreamPosition() > 0 || this.bitOffset > 0) {
            int i4 = this.bitOffset;
            int i5 = read();
            if (i5 != -1) {
                seek(getStreamPosition() - 1);
            } else {
                i5 = 0;
            }
            int i6 = i + i4;
            if (i6 < 8) {
                int i7 = 8 - i6;
                int i8 = (-1) >>> (32 - i);
                write((int) (((long) (i5 & (~(i8 << i7)))) | ((((long) i8) & j) << i7)));
                seek(getStreamPosition() - 1);
                this.bitOffset = i6;
                i = 0;
            } else {
                int i9 = 8 - i4;
                int i10 = (-1) >>> (32 - i9);
                i -= i9;
                write((int) ((((long) i10) & (j >> i)) | ((long) (i5 & (~i10)))));
            }
        }
        if (i > 7) {
            int i11 = i % 8;
            for (int i12 = i / 8; i12 > 0; i12--) {
                int iM1304A = AbstractC1974b.m1304A(i12, 1, 8, i11);
                write((int) (iM1304A == 0 ? j & 255 : (j >> iM1304A) & 255));
            }
            i = i11;
        }
        if (i != 0) {
            int i13 = read();
            if (i13 != -1) {
                seek(getStreamPosition() - 1);
                i2 = i13;
            }
            int i14 = 8 - i;
            int i15 = (-1) >>> (32 - i);
            write((int) (((j & ((long) i15)) << i14) | ((long) (i2 & (~(i15 << i14))))));
            seek(getStreamPosition() - 1);
            this.bitOffset = i;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeBoolean(boolean z) {
        write(z ? 1 : 0);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeByte(int i) {
        write(i);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeBytes(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            write((byte) str.charAt(i));
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeChar(int i) {
        writeShort(i);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeChars(String str) {
        int length = str.length();
        int i = length * 2;
        byte[] bArr = new byte[i];
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i2 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                char cCharAt = str.charAt(i4);
                int i5 = i2 + 1;
                bArr[i2] = (byte) (cCharAt >>> '\b');
                i2 += 2;
                bArr[i5] = (byte) cCharAt;
            }
        } else {
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                char cCharAt2 = str.charAt(i7);
                int i8 = i6 + 1;
                bArr[i6] = (byte) cCharAt2;
                i6 += 2;
                bArr[i8] = (byte) (cCharAt2 >>> '\b');
            }
        }
        write(bArr, 0, i);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeDouble(double d) {
        writeLong(Double.doubleToLongBits(d));
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void writeDoubles(double[] dArr, int i, int i2) {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > dArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > d.length!");
        }
        int i5 = i2 * 8;
        byte[] bArr = new byte[i5];
        char c = '8';
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < i2) {
                long jDoubleToLongBits = Double.doubleToLongBits(dArr[i + i6]);
                bArr[i7] = (byte) (jDoubleToLongBits >>> c);
                bArr[i7 + 1] = (byte) (jDoubleToLongBits >>> 48);
                bArr[i7 + 2] = (byte) (jDoubleToLongBits >>> 40);
                bArr[i7 + 3] = (byte) (jDoubleToLongBits >>> 32);
                bArr[i7 + 4] = (byte) (jDoubleToLongBits >>> 24);
                bArr[i7 + 5] = (byte) (jDoubleToLongBits >>> 16);
                int i8 = i7 + 7;
                bArr[i7 + 6] = (byte) (jDoubleToLongBits >>> 8);
                i7 += 8;
                bArr[i8] = (byte) jDoubleToLongBits;
                i6++;
                c = c;
            }
        } else {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                bArr[i9] = (byte) Double.doubleToLongBits(dArr[i + i10]);
                bArr[i9 + 1] = (byte) (r7 >>> 8);
                bArr[i9 + 2] = (byte) (r7 >>> 16);
                bArr[i9 + 3] = (byte) (r7 >>> 24);
                bArr[i9 + 4] = (byte) (r7 >>> 32);
                bArr[i9 + 5] = (byte) (r7 >>> 40);
                int i11 = i9 + 7;
                bArr[i9 + 6] = (byte) (r7 >>> 48);
                i9 += 8;
                bArr[i11] = (byte) (r7 >>> 56);
            }
        }
        write(bArr, 0, i5);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeFloat(float f) {
        writeInt(Float.floatToIntBits(f));
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void writeFloats(float[] fArr, int i, int i2) {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > fArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > f.length!");
        }
        int i5 = i2 * 4;
        byte[] bArr = new byte[i5];
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                int iFloatToIntBits = Float.floatToIntBits(fArr[i + i7]);
                bArr[i6] = (byte) (iFloatToIntBits >>> 24);
                bArr[i6 + 1] = (byte) (iFloatToIntBits >>> 16);
                int i8 = i6 + 3;
                bArr[i6 + 2] = (byte) (iFloatToIntBits >>> 8);
                i6 += 4;
                bArr[i8] = (byte) iFloatToIntBits;
            }
        } else {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                int iFloatToIntBits2 = Float.floatToIntBits(fArr[i + i10]);
                bArr[i9] = (byte) iFloatToIntBits2;
                bArr[i9 + 1] = (byte) (iFloatToIntBits2 >>> 8);
                int i11 = i9 + 3;
                bArr[i9 + 2] = (byte) (iFloatToIntBits2 >>> 16);
                i9 += 4;
                bArr[i11] = (byte) (iFloatToIntBits2 >>> 24);
            }
        }
        write(bArr, 0, i5);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeInt(int i) {
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.byteBuf;
            bArr[0] = (byte) (i >>> 24);
            bArr[1] = (byte) (i >>> 16);
            bArr[2] = (byte) (i >>> 8);
            bArr[3] = (byte) i;
        } else {
            byte[] bArr2 = this.byteBuf;
            bArr2[0] = (byte) i;
            bArr2[1] = (byte) (i >>> 8);
            bArr2[2] = (byte) (i >>> 16);
            bArr2[3] = (byte) (i >>> 24);
        }
        write(this.byteBuf, 0, 4);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void writeInts(int[] iArr, int i, int i2) {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > iArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > i.length!");
        }
        int i5 = i2 * 4;
        byte[] bArr = new byte[i5];
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = iArr[i + i7];
                bArr[i6] = (byte) (i8 >>> 24);
                bArr[i6 + 1] = (byte) (i8 >>> 16);
                int i9 = i6 + 3;
                bArr[i6 + 2] = (byte) (i8 >>> 8);
                i6 += 4;
                bArr[i9] = (byte) i8;
            }
        } else {
            int i10 = 0;
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = iArr[i + i11];
                bArr[i10] = (byte) i12;
                bArr[i10 + 1] = (byte) (i12 >>> 8);
                int i13 = i10 + 3;
                bArr[i10 + 2] = (byte) (i12 >>> 16);
                i10 += 4;
                bArr[i13] = (byte) (i12 >>> 24);
            }
        }
        write(bArr, 0, i5);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeLong(long j) {
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.byteBuf;
            bArr[0] = (byte) (j >>> 56);
            bArr[1] = (byte) (j >>> 48);
            bArr[2] = (byte) (j >>> 40);
            bArr[3] = (byte) (j >>> 32);
            bArr[4] = (byte) (j >>> 24);
            bArr[5] = (byte) (j >>> 16);
            bArr[6] = (byte) (j >>> 8);
            bArr[7] = (byte) j;
        } else {
            byte[] bArr2 = this.byteBuf;
            bArr2[0] = (byte) j;
            bArr2[1] = (byte) (j >>> 8);
            bArr2[2] = (byte) (j >>> 16);
            bArr2[3] = (byte) (j >>> 24);
            bArr2[4] = (byte) (j >>> 32);
            bArr2[5] = (byte) (j >>> 40);
            bArr2[6] = (byte) (j >>> 48);
            bArr2[7] = (byte) (j >>> 56);
        }
        write(this.byteBuf, 0, 4);
        write(this.byteBuf, 4, 4);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void writeLongs(long[] jArr, int i, int i2) {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > jArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > l.length!");
        }
        int i5 = i2 * 8;
        byte[] bArr = new byte[i5];
        char c = '8';
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < i2) {
                long j = jArr[i + i6];
                bArr[i7] = (byte) (j >>> c);
                bArr[i7 + 1] = (byte) (j >>> 48);
                bArr[i7 + 2] = (byte) (j >>> 40);
                bArr[i7 + 3] = (byte) (j >>> 32);
                bArr[i7 + 4] = (byte) (j >>> 24);
                bArr[i7 + 5] = (byte) (j >>> 16);
                int i8 = i7 + 7;
                bArr[i7 + 6] = (byte) (j >>> 8);
                i7 += 8;
                bArr[i8] = (byte) j;
                i6++;
                c = c;
            }
        } else {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                bArr[i9] = (byte) jArr[i + i10];
                bArr[i9 + 1] = (byte) (r7 >>> 8);
                bArr[i9 + 2] = (byte) (r7 >>> 16);
                bArr[i9 + 3] = (byte) (r7 >>> 24);
                bArr[i9 + 4] = (byte) (r7 >>> 32);
                bArr[i9 + 5] = (byte) (r7 >>> 40);
                int i11 = i9 + 7;
                bArr[i9 + 6] = (byte) (r7 >>> 48);
                i9 += 8;
                bArr[i11] = (byte) (r7 >>> 56);
            }
        }
        write(bArr, 0, i5);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeShort(int i) {
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.byteBuf;
            bArr[0] = (byte) (i >>> 8);
            bArr[1] = (byte) i;
        } else {
            byte[] bArr2 = this.byteBuf;
            bArr2[0] = (byte) i;
            bArr2[1] = (byte) (i >>> 8);
        }
        write(this.byteBuf, 0, 2);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void writeShorts(short[] sArr, int i, int i2) {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > sArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > s.length!");
        }
        int i5 = i2 * 2;
        byte[] bArr = new byte[i5];
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                short s = sArr[i + i7];
                int i8 = i6 + 1;
                bArr[i6] = (byte) (s >>> 8);
                i6 += 2;
                bArr[i8] = (byte) s;
            }
        } else {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s2 = sArr[i + i10];
                int i11 = i9 + 1;
                bArr[i9] = (byte) s2;
                i9 += 2;
                bArr[i11] = (byte) (s2 >>> 8);
            }
        }
        write(bArr, 0, i5);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeUTF(String str) throws UTFDataFormatException {
        int length = str.length();
        char[] cArr = new char[length];
        str.getChars(0, length, cArr, 0);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char c = cArr[i2];
            i = (c < 1 || c > 127) ? c > 2047 ? i + 3 : i + 2 : i + 1;
        }
        if (i > 65535) {
            throw new UTFDataFormatException("utflen > 65536!");
        }
        int i4 = i + 2;
        byte[] bArr = new byte[i4];
        bArr[0] = (byte) ((i >>> 8) & 255);
        bArr[1] = (byte) (i & 255);
        int i5 = 2;
        for (int i6 = 0; i6 < length; i6++) {
            char c2 = cArr[i6];
            if (c2 >= 1 && c2 <= 127) {
                bArr[i5] = (byte) c2;
                i5++;
            } else if (c2 > 2047) {
                bArr[i5] = (byte) (((c2 >> '\f') & 15) | JPEG.APP0);
                int i7 = i5 + 2;
                bArr[i5 + 1] = (byte) (((c2 >> 6) & 63) | 128);
                i5 += 3;
                bArr[i7] = (byte) ((c2 & '?') | 128);
            } else {
                int i8 = i5 + 1;
                bArr[i5] = (byte) (((c2 >> 6) & 31) | 192);
                i5 += 2;
                bArr[i8] = (byte) ((c2 & '?') | 128);
            }
        }
        write(bArr, 0, i4);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void writeChars(char[] cArr, int i, int i2) {
        int i4;
        if (i >= 0 && i2 >= 0 && (i4 = i + i2) <= cArr.length && i4 >= 0) {
            int i5 = i2 * 2;
            byte[] bArr = new byte[i5];
            if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    char c = cArr[i + i7];
                    int i8 = i6 + 1;
                    bArr[i6] = (byte) (c >>> '\b');
                    i6 += 2;
                    bArr[i8] = (byte) c;
                }
            } else {
                int i9 = 0;
                for (int i10 = 0; i10 < i2; i10++) {
                    char c2 = cArr[i + i10];
                    int i11 = i9 + 1;
                    bArr[i9] = (byte) c2;
                    i9 += 2;
                    bArr[i11] = (byte) (c2 >>> '\b');
                }
            }
            write(bArr, 0, i5);
            return;
        }
        throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > c.length!");
    }
}
