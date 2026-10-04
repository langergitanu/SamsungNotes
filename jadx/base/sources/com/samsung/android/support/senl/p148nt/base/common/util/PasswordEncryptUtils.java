package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.security.keystore.KeyGenParameterSpec;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.yubico.yubikit.core.fido.CtapException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PSource;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J \u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001c\u0010 \u001a\u0004\u0018\u00010\u00102\u0006\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0007J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000bH\u0002J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/PasswordEncryptUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "HEX_TABLE", "", "PREF_GET_CERT_NULL_COUNT", "ALIAS_NAME_USER_PASSWORD", "DECRYPTION_ERROR_DECRYPT_FAILED", "", "encryptBytes", "context", "Landroid/content/Context;", VElementFormulasCmd.FVAL, "", "encryptString", "str", "decryptString", "exceptionResult", "", "getPasswordPublicKey", "Ljava/security/PublicKey;", "passwordPrivateKey", "Ljava/security/PrivateKey;", "getPasswordPrivateKey", "()Ljava/security/PrivateKey;", "getByteArray", "hex", "getHexString", "arr", "getSecureHash", "password", "salt", "makePasswordKeyPair", "Ljava/security/KeyPair;", "setPrefGetCertNullCount", "", "count", "getPrefGetCertNullCount", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PasswordEncryptUtils {

    @NotNull
    private static final String ALIAS_NAME_USER_PASSWORD = "com.samsung.android.app.notes_userpasswordkey";
    private static final int DECRYPTION_ERROR_DECRYPT_FAILED = -1;

    @NotNull
    private static final String PREF_GET_CERT_NULL_COUNT = "GetCertNullCount";

    @NotNull
    private static final String TAG = "PasswordEncryptUtils";

    @NotNull
    public static final PasswordEncryptUtils INSTANCE = new PasswordEncryptUtils();

    @NotNull
    private static final char[] HEX_TABLE = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f'};

    private PasswordEncryptUtils() {
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final String decryptString(@Nullable String str) {
        return decryptString$default(str, null, 2, null);
    }

    public static /* synthetic */ String decryptString$default(String str, int[] iArr, int i, Object obj) {
        if ((i & 2) != 0) {
            iArr = null;
        }
        return decryptString(str, iArr);
    }

    @JvmStatic
    @Nullable
    public static final String encryptBytes(@NotNull Context context, @Nullable byte[] val) {
        Intrinsics.checkNotNullParameter(context, "context");
        PublicKey passwordPublicKey = INSTANCE.getPasswordPublicKey(context);
        if (passwordPublicKey == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            Intrinsics.checkNotNullExpressionValue(cipher, "getInstance(...)");
            try {
                cipher.init(1, passwordPublicKey, new OAEPParameterSpec("SHA-256", IDevicePopManager.MGF_1, new MGF1ParameterSpec(IDevicePopManager.SHA_1), PSource.PSpecified.DEFAULT));
                try {
                    byte[] bArrDoFinal = cipher.doFinal(val);
                    Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                    return getHexString(bArrDoFinal);
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7133e(TAG, "encryption fail 3 - [" + e + "]");
                    return null;
                }
            } catch (Exception e2) {
                LoggerBase.INSTANCE.m7133e(TAG, "encryption fail 2 - [" + e2 + "]");
                return null;
            }
        } catch (Exception e3) {
            LoggerBase.INSTANCE.m7133e(TAG, "encryption fail 1 - [" + e3 + "]");
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String encryptString(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        byte[] byteArray = getByteArray(str);
        if (byteArray == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "encryption fail 1");
            return null;
        }
        PublicKey passwordPublicKey = INSTANCE.getPasswordPublicKey(context);
        if (passwordPublicKey == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "encryption fail 2");
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            Intrinsics.checkNotNullExpressionValue(cipher, "getInstance(...)");
            try {
                cipher.init(1, passwordPublicKey, new OAEPParameterSpec("SHA-256", IDevicePopManager.MGF_1, new MGF1ParameterSpec(IDevicePopManager.SHA_1), PSource.PSpecified.DEFAULT));
                try {
                    byte[] bArrDoFinal = cipher.doFinal(byteArray);
                    Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                    return getHexString(bArrDoFinal);
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7133e(TAG, "encryption fail 5 - [" + e + "]");
                    return null;
                }
            } catch (Exception e2) {
                LoggerBase.INSTANCE.m7133e(TAG, "encryption fail 4 - [" + e2 + "]");
                return null;
            }
        } catch (Exception e3) {
            LoggerBase.INSTANCE.m7133e(TAG, "encryption fail 3 - [" + e3 + "]");
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final byte[] getByteArray(@Nullable String hex) {
        if (hex == null || hex.length() == 0) {
            return null;
        }
        int length = hex.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            String strSubstring = hex.substring(i * 2, i2 * 2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            bArr[i] = (byte) Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
            i = i2;
        }
        return bArr;
    }

    @JvmStatic
    @Nullable
    public static final String getHexString(@Nullable byte[] arr) {
        if (arr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(arr.length * 2);
        for (byte b : arr) {
            char[] cArr = HEX_TABLE;
            sb.append(cArr[(b & CtapException.ERR_VENDOR_FIRST) >> 4]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }

    private final PrivateKey getPasswordPrivateKey() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            Intrinsics.checkNotNullExpressionValue(keyStore, "getInstance(...)");
            try {
                keyStore.load(null);
                try {
                    if (!keyStore.containsAlias(ALIAS_NAME_USER_PASSWORD)) {
                        KeyPair keyPairMakePasswordKeyPair = makePasswordKeyPair();
                        if (keyPairMakePasswordKeyPair != null) {
                            return keyPairMakePasswordKeyPair.getPrivate();
                        }
                        LoggerBase.INSTANCE.m7133e(TAG, "Fail to make key pair");
                        return null;
                    }
                    try {
                        Key key = keyStore.getKey(ALIAS_NAME_USER_PASSWORD, null);
                        Intrinsics.checkNotNull(key, "null cannot be cast to non-null type java.security.PrivateKey");
                        return (PrivateKey) key;
                    } catch (Exception e) {
                        LoggerBase.INSTANCE.m7133e(TAG, "Fail to get private key 4 - [" + e + "]");
                        return null;
                    }
                } catch (Exception e2) {
                    LoggerBase.INSTANCE.m7133e(TAG, "Fail to get private key 3 - [" + e2 + "]");
                    return null;
                }
            } catch (Exception e3) {
                LoggerBase.INSTANCE.m7133e(TAG, "Fail to get private key 2 - [" + e3 + "]");
                return null;
            }
        } catch (KeyStoreException e5) {
            LoggerBase.INSTANCE.m7133e(TAG, "Fail to get private key 1 - [" + e5 + "]");
            return null;
        }
    }

    private final PublicKey getPasswordPublicKey(Context context) {
        KeyPair keyPairMakePasswordKeyPair;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            Intrinsics.checkNotNullExpressionValue(keyStore, "getInstance(...)");
            try {
                keyStore.load(null);
                try {
                    if (!keyStore.containsAlias(ALIAS_NAME_USER_PASSWORD)) {
                        LoggerBase.Companion companion = LoggerBase.INSTANCE;
                        companion.m7133e(TAG, "KeyStore does not contain keyPair");
                        KeyPair keyPairMakePasswordKeyPair2 = makePasswordKeyPair();
                        if (keyPairMakePasswordKeyPair2 != null) {
                            return keyPairMakePasswordKeyPair2.getPublic();
                        }
                        companion.m7133e(TAG, "Fail to make key pair");
                        return null;
                    }
                    try {
                        int prefGetCertNullCount = getPrefGetCertNullCount(context);
                        Certificate certificate = keyStore.getCertificate(ALIAS_NAME_USER_PASSWORD);
                        if (certificate != null) {
                            PublicKey publicKey = certificate.getPublicKey();
                            Intrinsics.checkNotNullExpressionValue(publicKey, "getPublicKey(...)");
                            if (prefGetCertNullCount != 0) {
                                setPrefGetCertNullCount(context, 0);
                            }
                            return publicKey;
                        }
                        LoggerBase.Companion companion2 = LoggerBase.INSTANCE;
                        companion2.m7133e(TAG, "KeyStore contains keyPair but returns null");
                        if (prefGetCertNullCount > 3) {
                            companion2.m7133e(TAG, "retry make keyPair");
                            keyPairMakePasswordKeyPair = makePasswordKeyPair();
                            setPrefGetCertNullCount(context, 0);
                        } else {
                            companion2.m7133e(TAG, "retry get keyPair count" + prefGetCertNullCount);
                            setPrefGetCertNullCount(context, prefGetCertNullCount + 1);
                            keyPairMakePasswordKeyPair = null;
                        }
                        if (keyPairMakePasswordKeyPair != null) {
                            return keyPairMakePasswordKeyPair.getPublic();
                        }
                        companion2.m7133e(TAG, "Fail to get key pair 2");
                        return null;
                    } catch (Exception e) {
                        LoggerBase.INSTANCE.m7133e(TAG, "Fail to get public key 4 - [" + e + "]");
                        return null;
                    }
                } catch (Exception e2) {
                    LoggerBase.INSTANCE.m7133e(TAG, "Fail to get public key 3 - [" + e2 + "]");
                    return null;
                }
            } catch (Exception e3) {
                LoggerBase.INSTANCE.m7133e(TAG, "Fail to get public key 2 - [" + e3 + "]");
                return null;
            }
        } catch (Exception e5) {
            LoggerBase.INSTANCE.m7133e(TAG, "Fail to get public key 1 - [" + e5 + "]");
            return null;
        }
    }

    private final int getPrefGetCertNullCount(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(PREF_GET_CERT_NULL_COUNT, 0);
    }

    @JvmStatic
    @Nullable
    public static final byte[] getSecureHash(@NotNull String password, @Nullable byte[] salt) {
        Intrinsics.checkNotNullParameter(password, "password");
        char[] charArray = password.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        try {
            try {
                return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(charArray, salt, 4000, 256)).getEncoded();
            } catch (InvalidKeySpecException unused) {
                LoggerBase.INSTANCE.m7132d(TAG, "InvalidKeySpecException");
                return null;
            }
        } catch (NoSuchAlgorithmException unused2) {
            LoggerBase.INSTANCE.m7132d(TAG, "NoSuchAlgorithmException");
            return null;
        }
    }

    private final KeyPair makePasswordKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(ALIAS_NAME_USER_PASSWORD, 3).setKeySize(2048).setDigests("SHA-256").setEncryptionPaddings("OAEPPadding").build();
        Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "build(...)");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, "AndroidKeyStore");
        keyPairGenerator.initialize(keyGenParameterSpecBuild);
        return keyPairGenerator.generateKeyPair();
    }

    private final void setPrefGetCertNullCount(Context context, int count) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putInt(PREF_GET_CERT_NULL_COUNT, count);
        editorEdit.apply();
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final String decryptString(@Nullable String str, @Nullable int[] exceptionResult) {
        byte[] byteArray = getByteArray(str);
        if (byteArray == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "decryption fail 1");
            return null;
        }
        PrivateKey passwordPrivateKey = INSTANCE.getPasswordPrivateKey();
        if (passwordPrivateKey == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "decryption fail 2");
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            Intrinsics.checkNotNullExpressionValue(cipher, "getInstance(...)");
            try {
                cipher.init(2, passwordPrivateKey, new OAEPParameterSpec("SHA-256", IDevicePopManager.MGF_1, new MGF1ParameterSpec(IDevicePopManager.SHA_1), PSource.PSpecified.DEFAULT));
                try {
                    byte[] bArrDoFinal = cipher.doFinal(byteArray);
                    Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                    return getHexString(bArrDoFinal);
                } catch (Exception e) {
                    if (exceptionResult != null) {
                        if (!(exceptionResult.length == 0)) {
                            exceptionResult[0] = -1;
                        }
                    }
                    LoggerBase.INSTANCE.m7133e(TAG, "decryption fail 5 - [" + e + "]");
                    return null;
                }
            } catch (Exception e2) {
                LoggerBase.INSTANCE.m7133e(TAG, "decryption fail 4 - [" + e2 + "]");
                return null;
            }
        } catch (Exception e3) {
            LoggerBase.INSTANCE.m7133e(TAG, "decryption fail 3 - [" + e3 + "]");
            return null;
        }
    }
}
