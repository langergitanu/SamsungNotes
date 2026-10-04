package net.lingala.zip4j.crypto.PBKDF2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class BinTools {
    public static final String hex = "0123456789ABCDEF";

    public static String bin2hex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            int i = (b + 256) % 256;
            stringBuffer.append(hex.charAt((i / 16) & 15));
            stringBuffer.append(hex.charAt((i % 16) & 15));
        }
        return stringBuffer.toString();
    }

    public static byte[] hex2bin(String str) {
        if (str == null) {
            str = "";
        } else if (str.length() % 2 != 0) {
            str = "0".concat(str);
        }
        byte[] bArr = new byte[str.length() / 2];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int i4 = i + 1;
            char cCharAt = str.charAt(i);
            i += 2;
            bArr[i2] = (byte) ((hex2bin(cCharAt) * 16) + hex2bin(str.charAt(i4)));
            i2++;
        }
        return bArr;
    }

    public static int hex2bin(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        StringBuffer stringBuffer = new StringBuffer("Input string may only contain hex digits, but found '");
        stringBuffer.append(c);
        stringBuffer.append("'");
        throw new IllegalArgumentException(stringBuffer.toString());
    }
}
