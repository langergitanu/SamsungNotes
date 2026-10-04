package org.apache.poi.openxml4j.opc.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class MemoryPackagePartOutputStream extends OutputStream {
    private ByteArrayOutputStream _buff = new ByteArrayOutputStream();
    private MemoryPackagePart _part;

    public MemoryPackagePartOutputStream(MemoryPackagePart memoryPackagePart) {
        this._part = memoryPackagePart;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this._buff.flush();
        MemoryPackagePart memoryPackagePart = this._part;
        byte[] bArr = memoryPackagePart.data;
        if (bArr != null) {
            byte[] bArr2 = new byte[this._buff.size() + bArr.length];
            byte[] bArr3 = this._part.data;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            byte[] byteArray = this._buff.toByteArray();
            System.arraycopy(byteArray, 0, bArr2, this._part.data.length, byteArray.length);
            this._part.data = bArr2;
        } else {
            memoryPackagePart.data = this._buff.toByteArray();
        }
        this._buff.reset();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this._buff.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this._buff.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this._buff.write(bArr);
    }
}
