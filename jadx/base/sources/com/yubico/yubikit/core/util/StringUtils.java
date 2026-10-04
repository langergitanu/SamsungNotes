package com.yubico.yubikit.core.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class StringUtils {
    private StringUtils() {
        throw new IllegalStateException();
    }

    public static String bytesToHex(byte[] bArr) {
        return bytesToHex(bArr, 0, bArr.length);
    }

    public static String bytesToHex(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            sb.append(String.format("%02x ", Byte.valueOf(bArr[i])));
            i++;
        }
        return sb.toString();
    }
}
