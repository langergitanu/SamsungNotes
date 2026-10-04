package org.apache.poi.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import kotlin.UShort;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LittleEndianByteArrayInputStream extends ByteArrayInputStream implements LittleEndianInput {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public LittleEndianByteArrayInputStream(byte[] bArr, int i, int i2) {
        super(bArr, i, i2);
    }

    public void checkPosition(int i) {
        if (i > ((ByteArrayInputStream) this).count - ((ByteArrayInputStream) this).pos) {
            throw new RuntimeException("Buffer overrun");
        }
    }

    public int getReadIndex() {
        return ((ByteArrayInputStream) this).pos;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        checkPosition(1);
        return (byte) read();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        checkPosition(i2);
        read(bArr, i, i2);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkPosition(4);
        int i = LittleEndian.getInt(((ByteArrayInputStream) this).buf, ((ByteArrayInputStream) this).pos);
        super.skip(4L);
        return i;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkPosition(8);
        long j = LittleEndian.getLong(((ByteArrayInputStream) this).buf, ((ByteArrayInputStream) this).pos);
        super.skip(8L);
        return j;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i, int i2) throws IOException {
        readFully(bArr, i, i2);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkPosition(2);
        short s = LittleEndian.getShort(((ByteArrayInputStream) this).buf, ((ByteArrayInputStream) this).pos);
        super.skip(2L);
        return s;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & 255;
    }

    public long readUInt() {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        return readShort() & UShort.MAX_VALUE;
    }

    public void setReadIndex(int i) {
        if (i < 0 || i >= ((ByteArrayInputStream) this).count) {
            throw new IndexOutOfBoundsException();
        }
        ((ByteArrayInputStream) this).pos = i;
    }

    public LittleEndianByteArrayInputStream(byte[] bArr, int i) {
        this(bArr, i, bArr.length - i);
    }

    public LittleEndianByteArrayInputStream(byte[] bArr) {
        this(bArr, 0);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) throws IOException {
        checkPosition(bArr.length);
        read(bArr, 0, bArr.length);
    }
}
