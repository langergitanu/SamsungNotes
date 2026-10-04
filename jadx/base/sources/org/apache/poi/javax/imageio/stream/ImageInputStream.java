package org.apache.poi.javax.imageio.stream;

import java.io.Closeable;
import java.io.DataInput;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ImageInputStream extends DataInput, Closeable {
    void close();

    void flush();

    void flushBefore(long j);

    int getBitOffset();

    ByteOrder getByteOrder();

    long getFlushedPosition();

    long getStreamPosition();

    boolean isCached();

    boolean isCachedFile();

    boolean isCachedMemory();

    long length();

    void mark();

    int read();

    int read(byte[] bArr);

    int read(byte[] bArr, int i, int i2);

    int readBit();

    long readBits(int i);

    @Override // java.io.DataInput
    boolean readBoolean();

    @Override // java.io.DataInput
    byte readByte();

    void readBytes(IIOByteBuffer iIOByteBuffer, int i);

    @Override // java.io.DataInput
    char readChar();

    @Override // java.io.DataInput
    double readDouble();

    @Override // java.io.DataInput
    float readFloat();

    @Override // java.io.DataInput
    void readFully(byte[] bArr);

    @Override // java.io.DataInput
    void readFully(byte[] bArr, int i, int i2);

    void readFully(char[] cArr, int i, int i2);

    void readFully(double[] dArr, int i, int i2);

    void readFully(float[] fArr, int i, int i2);

    void readFully(int[] iArr, int i, int i2);

    void readFully(long[] jArr, int i, int i2);

    void readFully(short[] sArr, int i, int i2);

    @Override // java.io.DataInput
    int readInt();

    @Override // java.io.DataInput
    String readLine();

    @Override // java.io.DataInput
    long readLong();

    @Override // java.io.DataInput
    short readShort();

    @Override // java.io.DataInput
    String readUTF();

    @Override // java.io.DataInput
    int readUnsignedByte();

    long readUnsignedInt();

    @Override // java.io.DataInput
    int readUnsignedShort();

    void reset();

    void seek(long j);

    void setBitOffset(int i);

    void setByteOrder(ByteOrder byteOrder);

    @Override // java.io.DataInput
    int skipBytes(int i);

    long skipBytes(long j);
}
