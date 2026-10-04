package com.microsoft.identity.common.java.crypto.key;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class KeyUtil {
    public static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final String HMAC_KEYSPEC_ALGORITHM = "AES";
    public static final String HMAC_KEY_HASH_ALGORITHM = "SHA-256";
    private static final String TAG = "KeyUtil";
    public static final String UNKNOWN_THUMBPRINT = "UNKNOWN_THUMBPRINT";

    public static SecretKey getHMacKey(@NonNull SecretKey secretKey) {
        if (secretKey == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        byte[] encoded = secretKey.getEncoded();
        return encoded != null ? new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest(encoded), "AES") : secretKey;
    }

    public static String getKeyThumbPrint(@NonNull AbstractSecretKeyLoader abstractSecretKeyLoader) {
        if (abstractSecretKeyLoader == null) {
            throw new NullPointerException("keyLoader is marked non-null but is null");
        }
        try {
            return getKeyThumbPrint(abstractSecretKeyLoader.getKey());
        } catch (Throwable th) {
            Logger.warn(AbstractC0622a.m1170p(TAG, ":getKeyThumbPrint", new StringBuilder()), "failed to load key:" + th.getMessage());
            return UNKNOWN_THUMBPRINT;
        }
    }

    public static String getKeyThumbPrintFromHmacKey(@NonNull SecretKey secretKey) {
        if (secretKey == null) {
            throw new NullPointerException("hmacKey is marked non-null but is null");
        }
        try {
            byte[] bytes = "012345678910111213141516".getBytes(AuthenticationConstants.ENCODING_UTF8);
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            mac.init(secretKey);
            return StringUtil.encodeUrlSafeString(mac.doFinal(bytes));
        } catch (Throwable th) {
            Logger.warn(AbstractC0622a.m1170p(TAG, ":getKeyThumbPrintFromHmacKey", new StringBuilder()), "failed to calculate thumbprint:" + th.getMessage());
            return UNKNOWN_THUMBPRINT;
        }
    }

    public static String getKeyThumbPrint(@NonNull SecretKey secretKey) {
        if (secretKey != null) {
            try {
                return getKeyThumbPrintFromHmacKey(getHMacKey(secretKey));
            } catch (Throwable th) {
                Logger.warn(AbstractC0622a.m1170p(TAG, ":getKeyThumbPrint", new StringBuilder()), "failed to calculate thumbprint:" + th.getMessage());
                return UNKNOWN_THUMBPRINT;
            }
        }
        throw new NullPointerException("key is marked non-null but is null");
    }
}
