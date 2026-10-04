package com.sec.android.app.voicenote.common.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SecureEncryption {
    private static final String ALGORITHM = "AES";
    private static final String TAG = "SecureEncryption";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SecurityKey {
        private static volatile byte[] KEY_IV_SPEC;
        private static volatile String KEY_SEC;

        private SecurityKey() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static synchronized byte[] makeIvSpec() {
            try {
                if (KEY_IV_SPEC == null) {
                    byte[] bArr = new byte[16];
                    for (int i = 0; i < 16; i++) {
                        bArr[i] = 0;
                    }
                    KEY_IV_SPEC = bArr;
                }
            } catch (Throwable th) {
                throw th;
            }
            return KEY_IV_SPEC;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static synchronized String makeSecretKey() {
            try {
                if (KEY_SEC == null || KEY_SEC.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 2; i++) {
                        for (int i2 = 1; i2 < 17; i2++) {
                            sb.append((i2 * 3) % 10);
                        }
                    }
                    KEY_SEC = sb.toString();
                }
            } catch (Throwable th) {
                throw th;
            }
            return KEY_SEC;
        }
    }

    @Nullable
    public static String decrypt(@NonNull String str) {
        String strMakeSecretKey = SecurityKey.makeSecretKey();
        byte[] bArrMakeIvSpec = SecurityKey.makeIvSpec();
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            Charset charset = StandardCharsets.UTF_8;
            byte[] bArrDecode = decoder.decode(str.getBytes(charset));
            if (bArrDecode == null) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(strMakeSecretKey.getBytes(charset), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArrMakeIvSpec);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(bArrDecode), charset);
        } catch (Exception e) {
            Log.e(TAG, "decrypt, Exception " + e);
            return null;
        }
    }

    @Nullable
    public static String encrypt(@NonNull String str) {
        String strMakeSecretKey = SecurityKey.makeSecretKey();
        byte[] bArrMakeIvSpec = SecurityKey.makeIvSpec();
        try {
            Charset charset = StandardCharsets.UTF_8;
            SecretKeySpec secretKeySpec = new SecretKeySpec(strMakeSecretKey.getBytes(charset), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArrMakeIvSpec);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return new String(Base64.getEncoder().encode(cipher.doFinal(str.getBytes(charset))), charset);
        } catch (Exception e) {
            Log.e(TAG, "encrypt, Exception " + e);
            return null;
        }
    }
}
