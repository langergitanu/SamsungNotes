package org.apache.poi.javax.imageio.stream;

import java.io.DataOutput;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ImageOutputStream extends ImageInputStream, DataOutput {
    void flushBefore(long j);

    @Override // java.io.DataOutput
    void write(int i);

    @Override // java.io.DataOutput
    void write(byte[] bArr);

    @Override // java.io.DataOutput
    void write(byte[] bArr, int i, int i2);

    void writeBit(int i);

    void writeBits(long j, int i);

    @Override // java.io.DataOutput
    void writeBoolean(boolean z);

    @Override // java.io.DataOutput
    void writeByte(int i);

    @Override // java.io.DataOutput
    void writeBytes(String str);

    @Override // java.io.DataOutput
    void writeChar(int i);

    @Override // java.io.DataOutput
    void writeChars(String str);

    void writeChars(char[] cArr, int i, int i2);

    @Override // java.io.DataOutput
    void writeDouble(double d);

    void writeDoubles(double[] dArr, int i, int i2);

    @Override // java.io.DataOutput
    void writeFloat(float f);

    void writeFloats(float[] fArr, int i, int i2);

    @Override // java.io.DataOutput
    void writeInt(int i);

    void writeInts(int[] iArr, int i, int i2);

    @Override // java.io.DataOutput
    void writeLong(long j);

    void writeLongs(long[] jArr, int i, int i2);

    @Override // java.io.DataOutput
    void writeShort(int i);

    void writeShorts(short[] sArr, int i, int i2);

    @Override // java.io.DataOutput
    void writeUTF(String str);
}
