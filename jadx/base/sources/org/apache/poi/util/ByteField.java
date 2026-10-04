package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ByteField implements FixedField {
    private static final byte _default_value = 0;
    private final int _offset;
    private byte _value;

    public ByteField(int i) {
        this(i, (byte) 0);
    }

    public byte get() {
        return this._value;
    }

    public void readFromBytes(byte[] bArr) {
        this._value = bArr[this._offset];
    }

    public void readFromStream(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i < 0) {
            throw new BufferUnderflowException();
        }
        this._value = (byte) i;
    }

    public void set(byte b) {
        this._value = b;
    }

    public String toString() {
        return String.valueOf((int) this._value);
    }

    public void writeToBytes(byte[] bArr) {
        bArr[this._offset] = this._value;
    }

    public ByteField(int i, byte b) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("offset cannot be negative");
        }
        this._offset = i;
        set(b);
    }

    public void set(byte b, byte[] bArr) {
        set(b);
        writeToBytes(bArr);
    }

    public ByteField(int i, byte[] bArr) {
        this(i);
        readFromBytes(bArr);
    }

    public ByteField(int i, byte b, byte[] bArr) {
        this(i, b);
        writeToBytes(bArr);
    }
}
