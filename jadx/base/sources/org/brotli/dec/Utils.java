package org.brotli.dec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class Utils {
    private static final byte[] BYTE_ZEROES = new byte[1024];
    private static final int[] INT_ZEROES = new int[1024];

    public static void fillWithZeroes(byte[] bArr, int i, int i2) {
        int i4 = 0;
        while (i4 < i2) {
            int iMin = Math.min(i4 + 1024, i2) - i4;
            System.arraycopy(BYTE_ZEROES, 0, bArr, i + i4, iMin);
            i4 += iMin;
        }
    }

    public static void fillWithZeroes(int[] iArr, int i, int i2) {
        int i4 = 0;
        while (i4 < i2) {
            int iMin = Math.min(i4 + 1024, i2) - i4;
            System.arraycopy(INT_ZEROES, 0, iArr, i + i4, iMin);
            i4 += iMin;
        }
    }
}
