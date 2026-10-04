package org.apache.poi.javax.imageio.stream;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Stack;
import kotlin.UShort;
import org.apache.poi.javax.imageio.IIOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ImageInputStreamImpl implements ImageInputStream {
    private static final int BYTE_BUF_LENGTH = 8192;
    protected int bitOffset;
    protected long streamPos;
    private Stack markByteStack = new Stack();
    private Stack markBitStack = new Stack();
    private boolean isClosed = false;
    byte[] byteBuf = new byte[8192];
    protected ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    protected long flushedPos = 0;

    private void toChars(byte[] bArr, char[] cArr, int i, int i2) {
        int i4 = 0;
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i5 = 0;
            while (i4 < i2) {
                cArr[i + i4] = (char) ((bArr[i5] << 8) | (bArr[i5 + 1] & 255));
                i5 += 2;
                i4++;
            }
            return;
        }
        int i6 = 0;
        while (i4 < i2) {
            cArr[i + i4] = (char) ((bArr[i6 + 1] << 8) | (bArr[i6] & 255));
            i6 += 2;
            i4++;
        }
    }

    private void toDoubles(byte[] bArr, double[] dArr, int i, int i2) {
        int i4 = 0;
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i5 = 0;
            while (i4 < i2) {
                byte b = bArr[i5];
                int i6 = bArr[i5 + 1] & 255;
                int i7 = bArr[i5 + 2] & 255;
                dArr[i + i4] = Double.longBitsToDouble((((long) ((((b << 24) | (i6 << 16)) | (i7 << 8)) | (bArr[i5 + 3] & 255))) << 32) | (((long) ((bArr[i5 + 4] << 24) | ((bArr[i5 + 5] & 255) << 16) | ((bArr[i5 + 6] & 255) << 8) | (bArr[i5 + 7] & 255))) & 4294967295L));
                i5 += 8;
                i4++;
            }
            return;
        }
        int i8 = 0;
        while (i4 < i2) {
            byte b5 = bArr[i8 + 7];
            int i9 = bArr[i8 + 6] & 255;
            int i10 = bArr[i8 + 5] & 255;
            dArr[i + i4] = Double.longBitsToDouble((((long) ((((b5 << 24) | (i9 << 16)) | (i10 << 8)) | (bArr[i8 + 4] & 255))) << 32) | (((long) ((bArr[i8 + 3] << 24) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 1] & 255) << 8) | (bArr[i8] & 255))) & 4294967295L));
            i8 += 8;
            i4++;
        }
    }

    private void toFloats(byte[] bArr, float[] fArr, int i, int i2) {
        int i4 = 0;
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i5 = 0;
            while (i4 < i2) {
                fArr[i + i4] = Float.intBitsToFloat((bArr[i5] << 24) | ((bArr[i5 + 1] & 255) << 16) | ((bArr[i5 + 2] & 255) << 8) | (bArr[i5 + 3] & 255));
                i5 += 4;
                i4++;
            }
            return;
        }
        int i6 = 0;
        while (i4 < i2) {
            fArr[i + i4] = Float.intBitsToFloat((bArr[i6 + 3] << 24) | ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 1] & 255) << 8) | (bArr[i6] & 255));
            i6 += 4;
            i4++;
        }
    }

    private void toInts(byte[] bArr, int[] iArr, int i, int i2) {
        int i4 = 0;
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i5 = 0;
            while (i4 < i2) {
                iArr[i + i4] = (bArr[i5] << 24) | ((bArr[i5 + 1] & 255) << 16) | ((bArr[i5 + 2] & 255) << 8) | (bArr[i5 + 3] & 255);
                i5 += 4;
                i4++;
            }
            return;
        }
        int i6 = 0;
        while (i4 < i2) {
            iArr[i + i4] = (bArr[i6 + 3] << 24) | ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 1] & 255) << 8) | (bArr[i6] & 255);
            i6 += 4;
            i4++;
        }
    }

    private void toLongs(byte[] bArr, long[] jArr, int i, int i2) {
        int i4 = 0;
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i5 = 0;
            while (i4 < i2) {
                byte b = bArr[i5];
                int i6 = bArr[i5 + 1] & 255;
                int i7 = bArr[i5 + 2] & 255;
                jArr[i + i4] = (((long) ((((b << 24) | (i6 << 16)) | (i7 << 8)) | (bArr[i5 + 3] & 255))) << 32) | (((long) ((bArr[i5 + 4] << 24) | ((bArr[i5 + 5] & 255) << 16) | ((bArr[i5 + 6] & 255) << 8) | (bArr[i5 + 7] & 255))) & 4294967295L);
                i5 += 8;
                i4++;
            }
            return;
        }
        int i8 = 0;
        while (i4 < i2) {
            byte b5 = bArr[i8 + 7];
            int i9 = bArr[i8 + 6] & 255;
            int i10 = bArr[i8 + 5] & 255;
            jArr[i + i4] = (((long) ((((b5 << 24) | (i9 << 16)) | (i10 << 8)) | (bArr[i8 + 4] & 255))) << 32) | (((long) ((bArr[i8 + 3] << 24) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 1] & 255) << 8) | (bArr[i8] & 255))) & 4294967295L);
            i8 += 8;
            i4++;
        }
    }

    private void toShorts(byte[] bArr, short[] sArr, int i, int i2) {
        int i4 = 0;
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            int i5 = 0;
            while (i4 < i2) {
                sArr[i + i4] = (short) ((bArr[i5] << 8) | (bArr[i5 + 1] & 255));
                i5 += 2;
                i4++;
            }
            return;
        }
        int i6 = 0;
        while (i4 < i2) {
            sArr[i + i4] = (short) ((bArr[i6 + 1] << 8) | (bArr[i6] & 255));
            i6 += 2;
            i4++;
        }
    }

    public final void checkClosed() throws IOException {
        if (this.isClosed) {
            throw new IOException("closed");
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        checkClosed();
        this.isClosed = true;
    }

    public void finalize() throws Throwable {
        if (!this.isClosed) {
            try {
                close();
            } catch (IOException unused) {
            }
        }
        super.finalize();
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void flush() throws IOException {
        flushBefore(getStreamPosition());
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void flushBefore(long j) throws IOException {
        checkClosed();
        if (j < this.flushedPos) {
            throw new IndexOutOfBoundsException("pos < flushedPos!");
        }
        if (j > getStreamPosition()) {
            throw new IndexOutOfBoundsException("pos > getStreamPosition()!");
        }
        this.flushedPos = j;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public int getBitOffset() throws IOException {
        checkClosed();
        return this.bitOffset;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public ByteOrder getByteOrder() {
        return this.byteOrder;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public long getFlushedPosition() {
        return this.flushedPos;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public long getStreamPosition() throws IOException {
        checkClosed();
        return this.streamPos;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public boolean isCached() {
        return false;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public boolean isCachedFile() {
        return false;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public boolean isCachedMemory() {
        return false;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public long length() {
        return -1L;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void mark() {
        try {
            this.markByteStack.push(Long.valueOf(getStreamPosition()));
            this.markBitStack.push(Integer.valueOf(getBitOffset()));
        } catch (IOException unused) {
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public abstract int read();

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public abstract int read(byte[] bArr, int i, int i2);

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public int readBit() throws IOException {
        checkClosed();
        int i = (this.bitOffset + 1) & 7;
        int i2 = read();
        if (i2 == -1) {
            throw new EOFException();
        }
        if (i != 0) {
            seek(getStreamPosition() - 1);
            i2 >>= 8 - i;
        }
        this.bitOffset = i;
        return i2 & 1;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public long readBits(int i) throws IOException {
        checkClosed();
        if (i < 0 || i > 64) {
            throw new IllegalArgumentException();
        }
        long j = 0;
        if (i == 0) {
            return 0L;
        }
        int i2 = this.bitOffset;
        int i4 = i + i2;
        int i5 = (i2 + i) & 7;
        while (i4 > 0) {
            int i6 = read();
            if (i6 == -1) {
                throw new EOFException();
            }
            j = (j << 8) | ((long) i6);
            i4 -= 8;
        }
        if (i5 != 0) {
            seek(getStreamPosition() - 1);
        }
        this.bitOffset = i5;
        return (j >>> (-i4)) & ((-1) >>> (64 - i));
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public boolean readBoolean() throws EOFException {
        int i = read();
        if (i >= 0) {
            return i != 0;
        }
        throw new EOFException();
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public byte readByte() throws EOFException {
        int i = read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void readBytes(IIOByteBuffer iIOByteBuffer, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("len < 0!");
        }
        if (iIOByteBuffer == null) {
            throw new NullPointerException("buf == null!");
        }
        byte[] bArr = new byte[i];
        int i2 = read(bArr, 0, i);
        iIOByteBuffer.setData(bArr);
        iIOByteBuffer.setOffset(0);
        iIOByteBuffer.setLength(i2);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public char readChar() {
        return (char) readShort();
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws EOFException {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > bArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > b.length!");
        }
        while (i2 > 0) {
            int i5 = read(bArr, i, i2);
            if (i5 == -1) {
                throw new EOFException();
            }
            i += i5;
            i2 -= i5;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public int readInt() throws EOFException {
        if (read(this.byteBuf, 0, 4) != 4) {
            throw new EOFException();
        }
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.byteBuf;
            return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        }
        byte[] bArr2 = this.byteBuf;
        return (bArr2[0] & 255) | ((bArr2[3] & 255) << 24) | ((bArr2[2] & 255) << 16) | ((bArr2[1] & 255) << 8);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public String readLine() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        int i = -1;
        while (!z) {
            i = read();
            if (i != -1 && i != 10) {
                if (i != 13) {
                    stringBuffer.append((char) i);
                } else {
                    long streamPosition = getStreamPosition();
                    if (read() != 10) {
                        seek(streamPosition);
                    }
                }
            }
            z = true;
        }
        if (i == -1 && stringBuffer.length() == 0) {
            return null;
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public long readLong() throws EOFException {
        int i = readInt();
        int i2 = readInt();
        return this.byteOrder == ByteOrder.BIG_ENDIAN ? (((long) i) << 32) + (((long) i2) & 4294967295L) : (((long) i2) << 32) + (((long) i) & 4294967295L);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public short readShort() throws EOFException {
        int i;
        if (read(this.byteBuf, 0, 2) != 2) {
            throw new EOFException();
        }
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.byteBuf;
            i = (bArr[1] & 255) | ((bArr[0] & 255) << 8);
        } else {
            byte[] bArr2 = this.byteBuf;
            i = (bArr2[0] & 255) | ((bArr2[1] & 255) << 8);
        }
        return (short) i;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public String readUTF() throws IOException {
        this.bitOffset = 0;
        ByteOrder byteOrder = getByteOrder();
        setByteOrder(ByteOrder.BIG_ENDIAN);
        try {
            String utf = DataInputStream.readUTF(this);
            setByteOrder(byteOrder);
            return utf;
        } catch (IOException e) {
            setByteOrder(byteOrder);
            throw e;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public int readUnsignedByte() throws EOFException {
        int i = read();
        if (i >= 0) {
            return i;
        }
        throw new EOFException();
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public long readUnsignedInt() {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public int readUnsignedShort() {
        return readShort() & UShort.MAX_VALUE;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void reset() throws IOException {
        if (this.markByteStack.empty()) {
            return;
        }
        long jLongValue = ((Long) this.markByteStack.pop()).longValue();
        if (jLongValue < this.flushedPos) {
            throw new IIOException("Previous marked position has been discarded!");
        }
        seek(jLongValue);
        setBitOffset(((Integer) this.markBitStack.pop()).intValue());
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void seek(long j) throws IOException {
        checkClosed();
        if (j < this.flushedPos) {
            throw new IndexOutOfBoundsException("pos < flushedPos!");
        }
        this.streamPos = j;
        this.bitOffset = 0;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void setBitOffset(int i) throws IOException {
        checkClosed();
        if (i < 0 || i > 7) {
            throw new IllegalArgumentException("bitOffset must be betwwen 0 and 7!");
        }
        this.bitOffset = i;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void setByteOrder(ByteOrder byteOrder) {
        this.byteOrder = byteOrder;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public int skipBytes(int i) throws IOException {
        long streamPosition = getStreamPosition();
        seek(((long) i) + streamPosition);
        return (int) (getStreamPosition() - streamPosition);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public long skipBytes(long j) throws IOException {
        long streamPosition = getStreamPosition();
        seek(j + streamPosition);
        return getStreamPosition() - streamPosition;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public void readFully(byte[] bArr) throws EOFException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void readFully(short[] sArr, int i, int i2) throws EOFException {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > sArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > s.length!");
        }
        while (i2 > 0) {
            int iMin = Math.min(i2, this.byteBuf.length / 2);
            readFully(this.byteBuf, 0, iMin * 2);
            toShorts(this.byteBuf, sArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void readFully(char[] cArr, int i, int i2) throws EOFException {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > cArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > c.length!");
        }
        while (i2 > 0) {
            int iMin = Math.min(i2, this.byteBuf.length / 2);
            readFully(this.byteBuf, 0, iMin * 2);
            toChars(this.byteBuf, cArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void readFully(int[] iArr, int i, int i2) throws EOFException {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > iArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > i.length!");
        }
        while (i2 > 0) {
            int iMin = Math.min(i2, this.byteBuf.length / 4);
            readFully(this.byteBuf, 0, iMin * 4);
            toInts(this.byteBuf, iArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void readFully(long[] jArr, int i, int i2) throws EOFException {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > jArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > l.length!");
        }
        while (i2 > 0) {
            int iMin = Math.min(i2, this.byteBuf.length / 8);
            readFully(this.byteBuf, 0, iMin * 8);
            toLongs(this.byteBuf, jArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void readFully(float[] fArr, int i, int i2) throws EOFException {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > fArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > f.length!");
        }
        while (i2 > 0) {
            int iMin = Math.min(i2, this.byteBuf.length / 4);
            readFully(this.byteBuf, 0, iMin * 4);
            toFloats(this.byteBuf, fArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStream
    public void readFully(double[] dArr, int i, int i2) throws EOFException {
        int i4;
        if (i < 0 || i2 < 0 || (i4 = i + i2) > dArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > d.length!");
        }
        while (i2 > 0) {
            int iMin = Math.min(i2, this.byteBuf.length / 8);
            readFully(this.byteBuf, 0, iMin * 8);
            toDoubles(this.byteBuf, dArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        }
    }
}
