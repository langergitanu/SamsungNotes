package com.adobe.internal.xmp.impl;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Latin1Converter {
    private static final int STATE_START = 0;
    private static final int STATE_UTF8CHAR = 11;

    private Latin1Converter() {
    }

    public static ByteBuffer convert(ByteBuffer byteBuffer) {
        if (!"UTF-8".equals(byteBuffer.getEncoding())) {
            return byteBuffer;
        }
        byte[] bArr = new byte[8];
        ByteBuffer byteBuffer2 = new ByteBuffer((byteBuffer.length() * 4) / 3);
        int i = 0;
        char c = 0;
        int i2 = 0;
        int i4 = 0;
        while (i < byteBuffer.length()) {
            int iCharAt = byteBuffer.charAt(i);
            if (c == 11) {
                if (i2 <= 0 || (iCharAt & 192) != 128) {
                    byteBuffer2.append(convertToUTF8(bArr[0]));
                    i -= i4;
                } else {
                    int i5 = i4 + 1;
                    bArr[i4] = (byte) iCharAt;
                    i2--;
                    if (i2 == 0) {
                        byteBuffer2.append(bArr, 0, i5);
                    } else {
                        i4 = i5;
                    }
                }
                c = 0;
                i4 = 0;
            } else if (iCharAt < 127) {
                byteBuffer2.append((byte) iCharAt);
            } else if (iCharAt >= 192) {
                i2 = -1;
                for (int i6 = iCharAt; i2 < 8 && (i6 & 128) == 128; i6 <<= 1) {
                    i2++;
                }
                bArr[i4] = (byte) iCharAt;
                i4++;
                c = 11;
            } else {
                byteBuffer2.append(convertToUTF8((byte) iCharAt));
            }
            i++;
        }
        if (c == 11) {
            for (int i7 = 0; i7 < i4; i7++) {
                byteBuffer2.append(convertToUTF8(bArr[i7]));
            }
        }
        return byteBuffer2;
    }

    private static byte[] convertToUTF8(byte b) {
        int i = b & 255;
        if (i >= 128) {
            try {
                return (i == 129 || i == 141 || i == 143 || i == 144 || i == 157) ? new byte[]{32} : new String(new byte[]{b}, "cp1252").getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return new byte[]{b};
    }
}
