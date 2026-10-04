package org.apache.poi.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface LittleEndianOutput {
    void write(byte[] bArr);

    void write(byte[] bArr, int i, int i2);

    void writeByte(int i);

    void writeDouble(double d);

    void writeInt(int i);

    void writeLong(long j);

    void writeShort(int i);
}
