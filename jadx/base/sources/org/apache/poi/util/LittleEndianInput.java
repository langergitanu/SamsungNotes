package org.apache.poi.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface LittleEndianInput {
    int available();

    byte readByte();

    double readDouble();

    void readFully(byte[] bArr);

    void readFully(byte[] bArr, int i, int i2);

    int readInt();

    long readLong();

    void readPlain(byte[] bArr, int i, int i2);

    short readShort();

    int readUByte();

    int readUShort();
}
