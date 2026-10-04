package androidx.emoji2.text.flatbuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b);

    void put(byte[] bArr, int i, int i2);

    void putBoolean(boolean z);

    void putDouble(double d);

    void putFloat(float f);

    void putInt(int i);

    void putLong(long j);

    void putShort(short s);

    boolean requestCapacity(int i);

    void set(int i, byte b);

    void set(int i, byte[] bArr, int i2, int i4);

    void setBoolean(int i, boolean z);

    void setDouble(int i, double d);

    void setFloat(int i, float f);

    void setInt(int i, int i2);

    void setLong(int i, long j);

    void setShort(int i, short s);

    int writePosition();
}
