package com.samsung.scsp.framework.core.util;

import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.scsp.framework.core.ScspException;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HashUtil {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String SHA256 = "SHA-256";

    private static byte[] decodeHex(char[] cArr) throws ScspException {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i4 = i + 1;
            int digit = (toDigit(cArr[i], i) << 4) | toDigit(cArr[i4], i4);
            i += 2;
            bArr[i2] = (byte) (digit & 255);
            i2++;
        }
        return bArr;
    }

    private static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    private static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    public static String generateValidationKey(String str, String str2) throws ScspException {
        if (StringUtil.isEmpty(str2)) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "Access token is null or empty. please check access token.");
        }
        return encodeHexString(xor(decodeHex(str.toCharArray()), sha256(str2.split(" ")[1])));
    }

    public static String getByteArraySHA256(byte[] bArr) {
        return encodeHexString(sha256(bArr));
    }

    private static MessageDigest getDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String getFileSHA256(InputStream inputStream) throws IOException {
        MessageDigest digest = getDigest("SHA-256");
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i <= 0) {
                return encodeHexString(digest.digest());
            }
            digest.update(bArr, 0, i);
        }
    }

    public static String getStringSHA256(String str) {
        return encodeHexString(sha256(str));
    }

    private static byte[] sha256(byte[] bArr) {
        return getDigest("SHA-256").digest(bArr);
    }

    private static int toDigit(char c, int i) throws ScspException {
        int iDigit = Character.digit(c, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "Illegal hexadecimal character " + c + " at index " + i);
    }

    private static byte[] xor(byte[] bArr, byte[] bArr2) throws ScspException {
        if (bArr.length != bArr2.length) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "Lengths are different.");
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    private static byte[] sha256(String str) {
        return sha256(str.getBytes(StandardCharsets.UTF_8));
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b & CtapException.ERR_VENDOR_FIRST) >>> 4];
            i += 2;
            cArr2[i2] = cArr[b & 15];
        }
        return cArr2;
    }

    public static String getFileSHA256(String str) {
        return getFileSHA256(new File(str));
    }

    public static String getFileSHA256(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            String fileSHA256 = getFileSHA256(fileInputStream);
            fileInputStream.close();
            return fileSHA256;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }
}
