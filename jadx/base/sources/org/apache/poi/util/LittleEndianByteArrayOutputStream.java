package org.apache.poi.util;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class LittleEndianByteArrayOutputStream extends OutputStream implements LittleEndianOutput, DelayableLittleEndianOutput {
    private final byte[] _buf;
    private final int _endIndex;
    private int _writeIndex;

    public LittleEndianByteArrayOutputStream(byte[] bArr, int i, int i2) {
        if (i < 0 || i > bArr.length) {
            throw new IllegalArgumentException(AbstractC2821a.m2223n(AbstractC0541b.m778t(i, "Specified startOffset (", ") is out of allowable range (0.."), ")", bArr.length));
        }
        this._buf = bArr;
        this._writeIndex = i;
        int i4 = i2 + i;
        this._endIndex = i4;
        if (i4 < i || i4 > bArr.length) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i4, "calculated end index (", ") is out of allowable range (");
            sbM778t.append(this._writeIndex);
            sbM778t.append("..");
            throw new IllegalArgumentException(AbstractC2821a.m2223n(sbM778t, ")", bArr.length));
        }
    }

    private void checkPosition(int i) {
        if (i > this._endIndex - this._writeIndex) {
            throw new RuntimeException("Buffer overrun");
        }
    }

    public LittleEndianOutput createDelayedOutput(int i) {
        checkPosition(i);
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(this._buf, this._writeIndex, i);
        this._writeIndex += i;
        return littleEndianByteArrayOutputStream;
    }

    public int getWriteIndex() {
        return this._writeIndex;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        writeByte(i);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int i) {
        checkPosition(1);
        byte[] bArr = this._buf;
        int i2 = this._writeIndex;
        this._writeIndex = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double d) {
        writeLong(Double.doubleToLongBits(d));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int i) {
        checkPosition(4);
        int i2 = this._writeIndex;
        byte[] bArr = this._buf;
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
        this._writeIndex = i2 + 4;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long j) {
        writeInt((int) j);
        writeInt((int) (j >> 32));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int i) {
        checkPosition(2);
        int i2 = this._writeIndex;
        byte[] bArr = this._buf;
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        this._writeIndex = i2 + 2;
    }

    @Override // java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr) {
        int length = bArr.length;
        checkPosition(length);
        System.arraycopy(bArr, 0, this._buf, this._writeIndex, length);
        this._writeIndex += length;
    }

    @Override // java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr, int i, int i2) {
        checkPosition(i2);
        System.arraycopy(bArr, i, this._buf, this._writeIndex, i2);
        this._writeIndex += i2;
    }

    public LittleEndianByteArrayOutputStream(byte[] bArr, int i) {
        this(bArr, i, bArr.length - i);
    }
}
