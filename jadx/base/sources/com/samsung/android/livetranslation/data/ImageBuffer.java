package com.samsung.android.livetranslation.data;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ImageBuffer {
    private int mBaseImageHash;
    private byte[] mImageBuffer;

    public ImageBuffer(byte[] bArr, int i) {
        this.mImageBuffer = bArr;
        this.mBaseImageHash = i;
    }

    public int getBaseImageHash() {
        return this.mBaseImageHash;
    }

    public byte[] getImageBuffer() {
        return this.mImageBuffer;
    }
}
