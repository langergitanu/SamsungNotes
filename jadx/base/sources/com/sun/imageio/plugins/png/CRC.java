package com.sun.imageio.plugins.png;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class CRC {
    private static int[] crcTable = new int[256];
    private int crc = -1;

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i4 = 0; i4 < 8; i4++) {
                i2 = (i2 & 1) == 1 ? (i2 >>> 1) ^ (-306674912) : i2 >>> 1;
                crcTable[i] = i2;
            }
        }
    }

    public int getValue() {
        return ~this.crc;
    }

    public void reset() {
        this.crc = -1;
    }

    public void update(byte[] bArr, int i, int i2) {
        for (int i4 = 0; i4 < i2; i4++) {
            int[] iArr = crcTable;
            int i5 = this.crc;
            this.crc = iArr[(bArr[i + i4] ^ i5) & 255] ^ (i5 >>> 8);
        }
    }

    public void update(int i) {
        int[] iArr = crcTable;
        int i2 = this.crc;
        this.crc = iArr[(i ^ i2) & 255] ^ (i2 >>> 8);
    }
}
