package org.apache.xmlbeans.impl.util;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class HexBin {
    private static final int BASELENGTH = 255;
    private static final int LOOKUPLENGTH = 16;
    private static byte[] hexNumberTable = new byte[255];
    private static byte[] lookUpHexAlphabet = new byte[16];

    static {
        int i;
        int i2 = 0;
        for (int i4 = 0; i4 < 255; i4++) {
            hexNumberTable[i4] = -1;
        }
        for (int i5 = 57; i5 >= 48; i5--) {
            hexNumberTable[i5] = (byte) (i5 - 48);
        }
        for (int i6 = 70; i6 >= 65; i6--) {
            hexNumberTable[i6] = (byte) (i6 - 55);
        }
        for (int i7 = 102; i7 >= 97; i7--) {
            hexNumberTable[i7] = (byte) (i7 - 87);
        }
        while (true) {
            if (i2 >= 10) {
                break;
            }
            lookUpHexAlphabet[i2] = (byte) (i2 + 48);
            i2++;
        }
        for (i = 10; i <= 15; i++) {
            lookUpHexAlphabet[i] = (byte) (i + 55);
        }
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(encode(bArr));
    }

    public static byte[] decode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (length % 2 != 0) {
            return null;
        }
        int i = length / 2;
        byte[] bArr2 = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i4 = i2 * 2;
            if (isHex(bArr[i4])) {
                int i5 = i4 + 1;
                if (isHex(bArr[i5])) {
                    byte[] bArr3 = hexNumberTable;
                    bArr2[i2] = (byte) ((bArr3[bArr[i4]] << 4) | bArr3[bArr[i5]]);
                }
            }
            return null;
        }
        return bArr2;
    }

    public static byte[] encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length * 2];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            byte[] bArr3 = lookUpHexAlphabet;
            bArr2[i2] = bArr3[(bArr[i] >> 4) & 15];
            bArr2[i2 + 1] = bArr3[bArr[i] & 15];
        }
        return bArr2;
    }

    public static boolean isHex(byte b) {
        return hexNumberTable[b] != -1;
    }

    public static byte[] stringToBytes(String str) {
        return decode(str.getBytes());
    }

    public static String encode(String str) {
        byte[] bArrEncode;
        if (str == null) {
            return null;
        }
        try {
            bArrEncode = encode(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException unused) {
            bArrEncode = null;
        }
        if (bArrEncode == null) {
            return null;
        }
        return new String(bArrEncode);
    }

    public static String decode(String str) {
        byte[] bArrDecode;
        if (str == null) {
            return null;
        }
        try {
            bArrDecode = decode(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException unused) {
            bArrDecode = null;
        }
        if (bArrDecode == null) {
            return null;
        }
        return new String(bArrDecode);
    }
}
