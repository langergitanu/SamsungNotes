package com.microsoft.identity.common.internal.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.util.AndroidKeyStoreUtil;
import com.microsoft.identity.common.java.WarningType;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager;
import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.microsoft.identity.common.java.util.ported.DateUtilities;
import com.microsoft.identity.common.logging.Logger;
import com.nimbusds.jose.crypto.impl.RSAKeyUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.security.auth.x500.X500Principal;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidDevicePopManager extends AbstractDevicePopManager {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    public static final String FAILED_TO_GENERATE_ATTESTATION_CERTIFICATE_CHAIN = "Failed to generate attestation certificate chain";
    public static final String NEGATIVE_THOUSAND_INTERNAL_ERROR = "internal Keystore code: -1000";
    private static final int RSA_KEY_SIZE = 2048;
    public static final String STRONG_BOX_UNAVAILABLE_EXCEPTION = "StrongBoxUnavailableException";
    private static final String TAG = "AndroidDevicePopManager";
    private final Context mContext;

    public AndroidDevicePopManager(@NonNull Context context) {
        this(context, AbstractDevicePopManager.DEFAULT_KEYSTORE_ENTRY_ALIAS);
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
    }

    @androidx.annotation.NonNull
    @RequiresApi(28)
    @SuppressLint({WarningType.NewApi})
    private static KeyGenParameterSpec.Builder applyHardwareIsolation(@androidx.annotation.NonNull KeyGenParameterSpec.Builder builder) {
        return builder.setIsStrongBoxBacked(true);
    }

    private static IKeyStoreKeyManager<KeyStore.PrivateKeyEntry> createKeyStoreKeyManager(@NonNull String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        KeyStore keyStore = KeyStore.getInstance(ANDROID_KEYSTORE);
        keyStore.load(null);
        return AndroidDeviceKeyManager.builder().keyAlias(str).keyStore(keyStore).build();
    }

    @RequiresApi(api = 18)
    private KeyPair generateNewKeyPair(@androidx.annotation.NonNull Context context, boolean z, boolean z2, boolean z3) {
        KeyPair keyPairGenerateKeyPair;
        synchronized ((DateUtilities.isLocaleCalendarNonGregorian(Locale.getDefault()) ? DateUtilities.LOCALE_CHANGE_LOCK : new Object())) {
            try {
                Locale locale = Locale.getDefault();
                AndroidKeyStoreUtil.applyKeyStoreLocaleWorkarounds(locale);
                try {
                    keyPairGenerateKeyPair = getInitializedRsaKeyPairGenerator(context, 2048, z, z2, z3).generateKeyPair();
                } finally {
                    Locale.setDefault(locale);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return keyPairGenerateKeyPair;
    }

    @RequiresApi(api = 18)
    private KeyPairGenerator getInitializedRsaKeyPairGenerator(@androidx.annotation.NonNull Context context, int i, boolean z, boolean z2, boolean z3) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, ANDROID_KEYSTORE);
        initialize(context, keyPairGenerator, i, z, z2, z3);
        return keyPairGenerator;
    }

    @RequiresApi(api = 18)
    private void initialize(@androidx.annotation.NonNull Context context, @androidx.annotation.NonNull KeyPairGenerator keyPairGenerator, int i, boolean z, boolean z2, boolean z3) throws InvalidAlgorithmParameterException {
        if (Build.VERSION.SDK_INT < 28) {
            initialize23(keyPairGenerator, i, z, z3);
        } else {
            initialize28(keyPairGenerator, i, z, z2, z3);
        }
    }

    @RequiresApi(api = 23)
    @SuppressLint({"InlinedApi"})
    private void initialize23(@androidx.annotation.NonNull KeyPairGenerator keyPairGenerator, int i, boolean z, boolean z2) throws InvalidAlgorithmParameterException {
        KeyGenParameterSpec.Builder encryptionPaddings = new KeyGenParameterSpec.Builder(this.mKeyManager.getKeyAlias(), 15).setKeySize(i).setSignaturePaddings("PKCS1").setDigests(CoverStickerConstants.Category.NONE.NAME, IDevicePopManager.SHA_1, "SHA-256").setEncryptionPaddings("OAEPPadding", "PKCS1Padding");
        if (z2) {
            encryptionPaddings = setAttestationChallenge(encryptionPaddings);
        }
        if (Build.VERSION.SDK_INT >= 28 && z) {
            Logger.verbose(TAG, "Attempting to apply StrongBox isolation.");
            encryptionPaddings = applyHardwareIsolation(encryptionPaddings);
        }
        keyPairGenerator.initialize(encryptionPaddings.build());
    }

    @RequiresApi(api = 28)
    @SuppressLint({"InlinedApi"})
    private void initialize28(@androidx.annotation.NonNull KeyPairGenerator keyPairGenerator, int i, boolean z, boolean z2, boolean z3) throws InvalidAlgorithmParameterException {
        KeyGenParameterSpec.Builder encryptionPaddings = new KeyGenParameterSpec.Builder(this.mKeyManager.getKeyAlias(), (!z2 || Build.VERSION.SDK_INT < 28) ? 15 : 47).setKeySize(i).setSignaturePaddings("PKCS1").setDigests(CoverStickerConstants.Category.NONE.NAME, IDevicePopManager.SHA_1, "SHA-256").setEncryptionPaddings("OAEPPadding", "PKCS1Padding");
        if (z3) {
            encryptionPaddings = setAttestationChallenge(encryptionPaddings);
        }
        if (Build.VERSION.SDK_INT >= 28 && z) {
            Logger.verbose(TAG, "Attempting to apply StrongBox isolation.");
            encryptionPaddings = applyHardwareIsolation(encryptionPaddings);
        }
        keyPairGenerator.initialize(encryptionPaddings.build());
    }

    @RequiresApi(api = 18)
    @SuppressLint({WarningType.NewApi})
    private void initializePre23(@androidx.annotation.NonNull Context context, @androidx.annotation.NonNull KeyPairGenerator keyPairGenerator, int i) throws InvalidAlgorithmParameterException {
        Calendar calendar = Calendar.getInstance();
        Date now = AbstractDevicePopManager.getNow(calendar);
        calendar.add(1, 99);
        KeyPairGeneratorSpec.Builder subject = new KeyPairGeneratorSpec.Builder(context).setAlias(this.mKeyManager.getKeyAlias()).setStartDate(now).setEndDate(calendar.getTime()).setSerialNumber(AbstractDevicePopManager.CertificateProperties.SERIAL_NUMBER).setSubject(new X500Principal(AbstractDevicePopManager.CertificateProperties.COMMON_NAME));
        subject.setAlgorithmParameterSpec(new RSAKeyGenParameterSpec(i, RSAKeyGenParameterSpec.F4));
        keyPairGenerator.initialize(subject.build());
    }

    private static boolean isNegativeInternalError(@androidx.annotation.NonNull Throwable th) {
        boolean z = th.getMessage() != null && th.getMessage().contains(NEGATIVE_THOUSAND_INTERNAL_ERROR);
        if (z) {
            Logger.error(TAG, "StrongBox not supported. internal Keystore code: -1000", th);
        }
        return z;
    }

    private static boolean isStrongBoxUnavailableException(@androidx.annotation.NonNull Throwable th) {
        boolean zEquals = th.getClass().getSimpleName().equals("StrongBoxUnavailableException");
        if (zEquals) {
            Logger.error(TAG + ":isStrongBoxUnavailableException", "StrongBox not supported.", th);
        }
        return zEquals;
    }

    @androidx.annotation.NonNull
    @RequiresApi(24)
    @SuppressLint({WarningType.NewApi})
    private KeyGenParameterSpec.Builder setAttestationChallenge(@androidx.annotation.NonNull KeyGenParameterSpec.Builder builder) {
        return builder.setAttestationChallenge(null);
    }

    @Override // com.microsoft.identity.common.java.platform.AbstractDevicePopManager
    @RequiresApi(api = 18)
    public KeyPair generateNewRsaKeyPair(int i) {
        return generateNewRsaKeyPair(this.mContext, i);
    }

    @Override // com.microsoft.identity.common.java.platform.AbstractDevicePopManager
    public SecureHardwareState getSecureHardwareState(@NonNull KeyPair keyPair) {
        if (keyPair == null) {
            throw new NullPointerException("kp is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getSecureHardwareState", new StringBuilder());
        try {
            PrivateKey privateKey = keyPair.getPrivate();
            boolean zIsInsideSecureHardware = ((KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), ANDROID_KEYSTORE).getKeySpec(privateKey, KeyInfo.class)).isInsideSecureHardware();
            Logger.info(strM1170p, "SecretKey is secure hardware backed? " + zIsInsideSecureHardware);
            return zIsInsideSecureHardware ? SecureHardwareState.TRUE_UNATTESTED : SecureHardwareState.FALSE;
        } catch (NoSuchAlgorithmException e) {
            e = e;
            Logger.error(strM1170p, "Failed to query secure hardware state.", e);
            return SecureHardwareState.UNKNOWN_QUERY_ERROR;
        } catch (NoSuchProviderException e2) {
            e = e2;
            Logger.error(strM1170p, "Failed to query secure hardware state.", e);
            return SecureHardwareState.UNKNOWN_QUERY_ERROR;
        } catch (InvalidKeySpecException e3) {
            e = e3;
            Logger.error(strM1170p, "Failed to query secure hardware state.", e);
            return SecureHardwareState.UNKNOWN_QUERY_ERROR;
        }
    }

    @Override // com.microsoft.identity.common.java.platform.AbstractDevicePopManager
    public void performCleanupIfMintShrFails(@NonNull Exception exc) {
        if (exc == null) {
            throw new NullPointerException("e is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":performCleanupIfMintShrFails", new StringBuilder());
        if (exc.getCause() instanceof KeyPermanentlyInvalidatedException) {
            Logger.warn(strM1170p, "Unable to access asymmetric key - clearing.");
            clearAsymmetricKey();
        }
    }

    @RequiresApi(api = 18)
    @SuppressLint({WarningType.NewApi})
    private KeyPair generateNewRsaKeyPair(@androidx.annotation.NonNull Context context, int i) {
        boolean z;
        ProviderException e;
        for (int i2 = 0; i2 < 4; i2++) {
            KeyPair keyPairGenerateNewKeyPair = null;
            boolean z2 = false;
            boolean z3 = true;
            boolean z4 = true;
            boolean z5 = true;
            while (!z2) {
                try {
                    keyPairGenerateNewKeyPair = generateNewKeyPair(context, z3, z4, z5);
                } catch (ProviderException e2) {
                    z = z2;
                    e = e2;
                }
                try {
                    Logger.info(TAG, "Key pair generated successfully (StrongBox [" + z3 + "], Import [" + z4 + "], Attestation Challenge [" + z5 + "])");
                    z2 = true;
                } catch (ProviderException e3) {
                    e = e3;
                    z = true;
                    if (z3 && isStrongBoxUnavailableException(e)) {
                        Logger.error(TAG, "StrongBox unavailable. Skipping StrongBox then retry.", e);
                    } else {
                        if (z4 && e.getClass().getSimpleName().equals("SecureKeyImportUnavailableException")) {
                            Logger.error(TAG, "Import unsupported. Skipping import flag then retry.", e);
                            if (z3 && e.getCause() != null && (isStrongBoxUnavailableException(e.getCause()) || isNegativeInternalError(e.getCause()))) {
                                z3 = false;
                            }
                            z4 = false;
                        } else if (z5 && FAILED_TO_GENERATE_ATTESTATION_CERTIFICATE_CHAIN.equalsIgnoreCase(e.getMessage())) {
                            Logger.error(TAG, "Failed to generate attestation cert. Skipping attestation then retry.", e);
                            z5 = false;
                        } else {
                            if (!z3 || Build.VERSION.SDK_INT < 34 || e.getCause() == null || !isNegativeInternalError(e.getCause())) {
                                clearAsymmetricKey();
                                throw e;
                            }
                            Logger.error(TAG, "Android 14 Internal Key store error with StrongBox. Skipping strongbox then retry.", e);
                        }
                        z2 = z;
                    }
                    z3 = false;
                    z2 = z;
                }
            }
            int iKeyBitLength = RSAKeyUtils.keyBitLength(keyPairGenerateNewKeyPair.getPrivate());
            if (iKeyBitLength >= i || iKeyBitLength < 0) {
                getSecureHardwareState(keyPairGenerateNewKeyPair);
                return keyPairGenerateNewKeyPair;
            }
        }
        clearAsymmetricKey();
        throw new UnsupportedOperationException("Failed to generate valid KeyPair. Attempted 4 times.");
    }

    public AndroidDevicePopManager(@NonNull Context context, @NonNull String str) {
        super(createKeyStoreKeyManager(str));
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        if (str != null) {
            this.mContext = context;
            return;
        }
        throw new NullPointerException("alias is marked non-null but is null");
    }
}
