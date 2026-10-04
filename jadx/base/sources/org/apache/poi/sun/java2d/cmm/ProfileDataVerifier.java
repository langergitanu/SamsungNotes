package org.apache.poi.sun.java2d.cmm;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ProfileDataVerifier {
    private static final int HEADER_SIZE = 128;
    private static final int MAX_TAG_COUNT = 100;
    private static final int PROFILE_FILE_SIGNATURE = 1633907568;
    private static final int TOC_OFFSET = 132;
    private static final int TOC_RECORD_SIZE = 12;

    private static int getTagOffset(int i, byte[] bArr) {
        return readInt32(bArr, (i * 12) + 136);
    }

    private static int getTagSize(int i, byte[] bArr) {
        return readInt32(bArr, (i * 12) + 140);
    }

    private static int readInt32(byte[] bArr, int i) {
        int i2 = 0;
        int i4 = 0;
        while (i2 < 4) {
            i4 = (i4 << 8) | (bArr[i] & 255);
            i2++;
            i++;
        }
        return i4;
    }

    public static void verify(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Invalid ICC Profile Data");
        }
        if (bArr.length < 132) {
            throw new IllegalArgumentException("Invalid ICC Profile Data");
        }
        int int32 = readInt32(bArr, 0);
        int int322 = readInt32(bArr, 128);
        if (int322 < 0 || int322 > 100) {
            throw new IllegalArgumentException("Invalid ICC Profile Data");
        }
        if (int32 < (int322 * 12) + 132 || int32 > bArr.length) {
            throw new IllegalArgumentException("Invalid ICC Profile Data");
        }
        if (PROFILE_FILE_SIGNATURE != readInt32(bArr, 36)) {
            throw new IllegalArgumentException("Invalid ICC Profile Data");
        }
        for (int i = 0; i < int322; i++) {
            int tagOffset = getTagOffset(i, bArr);
            int tagSize = getTagSize(i, bArr);
            if (tagOffset < 132 || tagOffset > int32) {
                throw new IllegalArgumentException("Invalid ICC Profile Data");
            }
            if (tagSize < 0 || tagSize > Integer.MAX_VALUE - tagOffset || tagSize + tagOffset > int32) {
                throw new IllegalArgumentException("Invalid ICC Profile Data");
            }
        }
    }
}
