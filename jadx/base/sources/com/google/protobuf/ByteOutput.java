package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ByteOutput {
    public abstract void write(byte b);

    public abstract void write(ByteBuffer byteBuffer);

    public abstract void write(byte[] bArr, int i, int i2);

    public abstract void writeLazy(ByteBuffer byteBuffer);

    public abstract void writeLazy(byte[] bArr, int i, int i2);
}
