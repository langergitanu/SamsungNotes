package com.samsung.android.sdk.smp.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SecurityUtil {
    private static final int IV_LENGTH = 16;
    private static final int KEY_LENGTH = 16;
    private static final String TAG = "SecurityUtil";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static String decode(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            byte[] bArr = new byte[16];
            byte[] bArr2 = new byte[16];
            byte[] signature = getSignature(context);
            System.arraycopy(signature, 0, bArr, 0, 16);
            System.arraycopy(signature, 16, bArr2, 0, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AES256KeyLoader.AES_ALGORITHM);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(toByteFromHex(str)), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] getSignature(Context context) {
        try {
            return PackageManagerUtil.getPackageInfo(context, context.getPackageName(), 64).signatures[0].toByteArray();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String makeSHA256Hash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            SmpLog.m6494e(TAG, "error while hashing. " + e);
            return null;
        }
    }

    private static byte[] toByteFromHex(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Short.parseShort(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }
}
