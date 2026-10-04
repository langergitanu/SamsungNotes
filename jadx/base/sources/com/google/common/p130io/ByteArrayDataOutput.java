package com.google.common.p130io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.DataOutput;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
public interface ByteArrayDataOutput extends DataOutput {
    byte[] toByteArray();

    @Override // java.io.DataOutput
    void write(int i);

    @Override // java.io.DataOutput
    void write(byte[] bArr);

    @Override // java.io.DataOutput
    void write(byte[] bArr, int i, int i2);

    @Override // java.io.DataOutput
    void writeBoolean(boolean z);

    @Override // java.io.DataOutput
    void writeByte(int i);

    @Override // java.io.DataOutput
    @Deprecated
    void writeBytes(String str);

    @Override // java.io.DataOutput
    void writeChar(int i);

    @Override // java.io.DataOutput
    void writeChars(String str);

    @Override // java.io.DataOutput
    void writeDouble(double d);

    @Override // java.io.DataOutput
    void writeFloat(float f);

    @Override // java.io.DataOutput
    void writeInt(int i);

    @Override // java.io.DataOutput
    void writeLong(long j);

    @Override // java.io.DataOutput
    void writeShort(int i);

    @Override // java.io.DataOutput
    void writeUTF(String str);
}
