package org.apache.poi.javax.imageio.stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IIOByteBuffer {
    private byte[] data;
    private int length;
    private int offset;

    public IIOByteBuffer(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.offset = i;
        this.length = i2;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getLength() {
        return this.length;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setOffset(int i) {
        this.offset = i;
    }
}
