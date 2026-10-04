package com.adobe.internal.xmp.impl;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.yubico.yubikit.core.fido.CtapException;
import okio.Utf8;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Base64 {
    private static final byte EQUAL = -3;
    private static final byte INVALID = -1;
    private static final byte WHITESPACE = -2;
    private static byte[] base64 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, SprAttributeBase.TYPE_ANIMATOR_SET, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, SprAttributeBase.TYPE_SHADOW, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 43, 47};
    private static byte[] ascii = new byte[255];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 255; i2++) {
            ascii[i2] = -1;
        }
        while (true) {
            byte[] bArr = base64;
            if (i >= bArr.length) {
                byte[] bArr2 = ascii;
                bArr2[9] = WHITESPACE;
                bArr2[10] = WHITESPACE;
                bArr2[13] = WHITESPACE;
                bArr2[32] = WHITESPACE;
                bArr2[61] = EQUAL;
                return;
            }
            ascii[bArr[i]] = (byte) i;
            i++;
        }
    }

    public static final byte[] decode(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            byte b5 = ascii[b];
            if (b5 >= 0) {
                bArr[i2] = b5;
                i2++;
            } else if (b5 == -1) {
                throw new IllegalArgumentException("Invalid base 64 string");
            }
        }
        while (i2 > 0 && bArr[i2 - 1] == -3) {
            i2--;
        }
        int i4 = (i2 * 3) / 4;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        while (i < i4 - 2) {
            int i6 = i5 + 1;
            bArr2[i] = (byte) (((bArr[i5] << 2) & 255) | ((bArr[i6] >>> 4) & 3));
            int i7 = i5 + 2;
            bArr2[i + 1] = (byte) (((bArr[i6] << 4) & 255) | ((bArr[i7] >>> 2) & 15));
            bArr2[i + 2] = (byte) (((bArr[i7] << 6) & 255) | (bArr[i5 + 3] & Utf8.REPLACEMENT_BYTE));
            i5 += 4;
            i += 3;
        }
        if (i < i4) {
            bArr2[i] = (byte) (((bArr[i5] << 2) & 255) | ((bArr[i5 + 1] >>> 4) & 3));
        }
        int i8 = i + 1;
        if (i8 < i4) {
            bArr2[i8] = (byte) (((bArr[i5 + 2] >>> 2) & 15) | ((bArr[i5 + 1] << 4) & 255));
        }
        return bArr2;
    }

    public static final byte[] encode(byte[] bArr) {
        return encode(bArr, 0);
    }

    public static final byte[] encode(byte[] bArr, int i) {
        int i2 = (i / 4) * 4;
        int i4 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        int length = ((bArr.length + 2) / 3) * 4;
        if (i2 > 0) {
            length = AbstractC0000a.m7d(length, 1, i2, length);
        }
        byte[] bArr2 = new byte[length];
        int i5 = 0;
        int i6 = 0;
        while (i4 + 3 <= bArr.length) {
            int i7 = i4 + 2;
            int i8 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16);
            i4 += 3;
            int i9 = i8 | (bArr[i7] & 255);
            byte[] bArr3 = base64;
            bArr2[i5] = bArr3[(i9 & 16515072) >> 18];
            bArr2[i5 + 1] = bArr3[(i9 & 258048) >> 12];
            bArr2[i5 + 2] = bArr3[(i9 & 4032) >> 6];
            int i10 = i5 + 4;
            bArr2[i5 + 3] = bArr3[i9 & 63];
            i6 += 4;
            if (i10 >= length || i2 <= 0 || i6 % i2 != 0) {
                i5 = i10;
            } else {
                i5 += 5;
                bArr2[i10] = 10;
            }
        }
        if (bArr.length - i4 == 2) {
            int i11 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16);
            byte[] bArr4 = base64;
            bArr2[i5] = bArr4[(i11 & 16515072) >> 18];
            bArr2[i5 + 1] = bArr4[(i11 & 258048) >> 12];
            bArr2[i5 + 2] = bArr4[(i11 & 4032) >> 6];
            bArr2[i5 + 3] = 61;
            return bArr2;
        }
        if (bArr.length - i4 == 1) {
            int i12 = (bArr[i4] & 255) << 16;
            byte[] bArr5 = base64;
            bArr2[i5] = bArr5[(i12 & 16515072) >> 18];
            bArr2[i5 + 1] = bArr5[(i12 & 258048) >> 12];
            bArr2[i5 + 2] = 61;
            bArr2[i5 + 3] = 61;
        }
        return bArr2;
    }

    public static final String decode(String str) {
        return new String(decode(str.getBytes()));
    }

    public static final String encode(String str) {
        return new String(encode(str.getBytes()));
    }
}
