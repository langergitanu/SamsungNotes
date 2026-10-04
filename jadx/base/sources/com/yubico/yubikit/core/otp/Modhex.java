package com.yubico.yubikit.core.otp;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Modhex {
    private static final char[] ALPHABET = "cbdefghijklnrtuv".toCharArray();
    private static final Map<Character, Integer> table = new HashMap();

    static {
        int i = 0;
        while (true) {
            char[] cArr = ALPHABET;
            if (i >= cArr.length) {
                return;
            }
            table.put(Character.valueOf(cArr[i]), Integer.valueOf(i));
            i++;
        }
    }

    public static byte[] decode(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Input string length is not a multiple of 2");
        }
        char[] charArray = str.toLowerCase().toCharArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte bIntValue = 0;
        for (int i = 0; i < charArray.length; i++) {
            Integer num = table.get(Character.valueOf(charArray[i]));
            if (num == null) {
                throw new IllegalArgumentException("Input string contains non-modhex character(s).");
            }
            if (i % 2 == 0) {
                bIntValue = (byte) (num.intValue() << 4);
            } else {
                bIntValue = (byte) (bIntValue | num.intValue());
                byteArrayOutputStream.write(bIntValue);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String encode(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            char[] cArr = ALPHABET;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }
}
