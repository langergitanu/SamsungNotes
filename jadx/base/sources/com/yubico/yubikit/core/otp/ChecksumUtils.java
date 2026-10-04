package com.yubico.yubikit.core.otp;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ChecksumUtils {
    private static final short CRC_OK_RESIDUAL = -3912;

    private ChecksumUtils() {
        throw new IllegalStateException();
    }

    public static short calculateCrc(byte[] bArr, int i) {
        int i2 = 65535;
        for (int i4 = 0; i4 < i; i4++) {
            i2 ^= bArr[i4] & 255;
            for (int i5 = 0; i5 < 8; i5++) {
                int i6 = i2 & 1;
                i2 >>= 1;
                if (i6 == 1) {
                    i2 ^= 33800;
                }
            }
        }
        return (short) (i2 & 65535);
    }

    public static boolean checkCrc(byte[] bArr, int i) {
        return calculateCrc(bArr, i) == -3912;
    }
}
