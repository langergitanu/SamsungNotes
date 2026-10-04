package io.netty.buffer;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.util.internal.ObjectUtil;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;
import kotlin.UShort;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ByteBufInputStream extends InputStream implements DataInput {
    private final ByteBuf buffer;
    private boolean closed;
    private final int endIndex;
    private StringBuilder lineBuf;
    private final boolean releaseOnClose;
    private final int startIndex;

    public ByteBufInputStream(ByteBuf byteBuf) {
        this(byteBuf, byteBuf.readableBytes());
    }

    private void checkAvailable(int i) throws EOFException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fieldSize cannot be a negative number");
        }
        if (i <= available()) {
            return;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "fieldSize is too long! Length is ", ", but maximum is ");
        sbM778t.append(available());
        throw new EOFException(sbM778t.toString());
    }

    @Override // java.io.InputStream
    public int available() {
        return this.endIndex - this.buffer.readerIndex();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } finally {
            if (this.releaseOnClose && !this.closed) {
                this.closed = true;
                this.buffer.release();
            }
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.buffer.markReaderIndex();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() == 0) {
            return -1;
        }
        return this.buffer.readByte() & 255;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws EOFException {
        checkAvailable(1);
        return read() != 0;
    }

    @Override // java.io.DataInput
    public byte readByte() throws EOFException {
        if (available() != 0) {
            return this.buffer.readByte();
        }
        throw new EOFException();
    }

    public int readBytes() {
        return this.buffer.readerIndex() - this.startIndex;
    }

    @Override // java.io.DataInput
    public char readChar() {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws EOFException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public int readInt() throws EOFException {
        checkAvailable(4);
        return this.buffer.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        int iAvailable = available();
        if (iAvailable == 0) {
            return null;
        }
        StringBuilder sb = this.lineBuf;
        if (sb != null) {
            sb.setLength(0);
        }
        while (true) {
            short unsignedByte = this.buffer.readUnsignedByte();
            iAvailable--;
            if (unsignedByte == 10) {
                break;
            }
            if (unsignedByte != 13) {
                if (this.lineBuf == null) {
                    this.lineBuf = new StringBuilder();
                }
                this.lineBuf.append((char) unsignedByte);
                if (iAvailable <= 0) {
                    break;
                }
            } else if (iAvailable > 0) {
                ByteBuf byteBuf = this.buffer;
                if (((char) byteBuf.getUnsignedByte(byteBuf.readerIndex())) == '\n') {
                    this.buffer.skipBytes(1);
                }
            }
        }
        StringBuilder sb2 = this.lineBuf;
        return (sb2 == null || sb2.length() <= 0) ? "" : this.lineBuf.toString();
    }

    @Override // java.io.DataInput
    public long readLong() throws EOFException {
        checkAvailable(8);
        return this.buffer.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() throws EOFException {
        checkAvailable(2);
        return this.buffer.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return DataInputStream.readUTF(this);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return readByte() & 255;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return readShort() & UShort.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.buffer.resetReaderIndex();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return j > 2147483647L ? skipBytes(Integer.MAX_VALUE) : skipBytes((int) j);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        int iMin = Math.min(available(), i);
        this.buffer.skipBytes(iMin);
        return iMin;
    }

    public ByteBufInputStream(ByteBuf byteBuf, int i) {
        this(byteBuf, i, false);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws EOFException {
        checkAvailable(i2);
        this.buffer.readBytes(bArr, i, i2);
    }

    public ByteBufInputStream(ByteBuf byteBuf, boolean z) {
        this(byteBuf, byteBuf.readableBytes(), z);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int iAvailable = available();
        if (iAvailable == 0) {
            return -1;
        }
        int iMin = Math.min(iAvailable, i2);
        this.buffer.readBytes(bArr, i, iMin);
        return iMin;
    }

    public ByteBufInputStream(ByteBuf byteBuf, int i, boolean z) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        if (i < 0) {
            if (z) {
                byteBuf.release();
            }
            ObjectUtil.checkPositiveOrZero(i, "length");
        }
        if (i > byteBuf.readableBytes()) {
            if (z) {
                byteBuf.release();
            }
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "Too many bytes to be read - Needs ", ", maximum is ");
            sbM778t.append(byteBuf.readableBytes());
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        this.releaseOnClose = z;
        this.buffer = byteBuf;
        int i2 = byteBuf.readerIndex();
        this.startIndex = i2;
        this.endIndex = i2 + i;
        byteBuf.markReaderIndex();
    }
}
