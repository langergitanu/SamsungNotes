package com.samsung.android.kmxservice.sdk.util;

import android.util.Log;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HashUtil {
    private static final int BYTE_SIZE = 8192;
    private static final int BYTE_SIZE_ARRAY = 262144;
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f'};
    private static final String EMPTY = "";

    /* JADX INFO: renamed from: KB */
    private static final int f4810KB = 1024;
    private static final String MD5 = "MD5";
    private static final String SHA_1 = "SHA-1";
    private static final String SHA_256 = "SHA-256";
    private static final String TAG = "HashUtil";

    private static String convertByteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return sb.toString();
    }

    private static String encodeHex(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = DIGITS_LOWER;
            cArr[i] = cArr2[(b & CtapException.ERR_VENDOR_FIRST) >>> 4];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    private static String getHash(InputStream inputStream, String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr, 0, 8192);
                if (i <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i);
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            Log.e(TAG, "[getHash] :");
        }
        return encodeHex(messageDigest.digest());
    }

    private static String getHashAlgorithm(String str, String str2) {
        if (str != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str2);
                messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
                return encodeHex(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return "";
    }

    public static String getHashByPath(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[262144];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        String strConvertByteArrayToHexString = convertByteArrayToHexString(messageDigest.digest());
                        fileInputStream.close();
                        return strConvertByteArrayToHexString;
                    }
                    messageDigest.update(bArr, 0, i);
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String getMd5Checksum(String str) throws IOException {
        int i;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance(MD5);
            while (true) {
                int i2 = byteArrayInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                int i4 = b & 255;
                if (i4 <= 15) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(i4));
            }
            String upperCase = sb.toString().toUpperCase(Locale.ENGLISH);
            byteArrayInputStream.close();
            return upperCase;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String getSHA1Hash(File file) throws IOException {
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            String hash = getHash(fileInputStream, "SHA-1");
            fileInputStream.close();
            return hash;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String getSHA256Hash(InputStream inputStream) {
        return getHash(inputStream, "SHA-256");
    }

    public static String getSHA256Hash(File file) throws IOException {
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            String hash = getHash(fileInputStream, "SHA-256");
            fileInputStream.close();
            return hash;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String getSHA1Hash(String str) {
        return getHashAlgorithm(str, "SHA-1");
    }

    public static String getSHA256Hash(String str) {
        return getHashAlgorithm(str, "SHA-256");
    }
}
