package org.brotli.dec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class IntReader {
    private byte[] byteBuffer;
    private int[] intBuffer;

    public static void convert(IntReader intReader, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int[] iArr = intReader.intBuffer;
            byte[] bArr = intReader.byteBuffer;
            int i4 = i2 * 4;
            iArr[i2] = ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
        }
    }

    public static void init(IntReader intReader, byte[] bArr, int[] iArr) {
        intReader.byteBuffer = bArr;
        intReader.intBuffer = iArr;
    }
}
