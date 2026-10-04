package com.microsoft.identity.common.internal.platform;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.NonNull;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.java.crypto.CryptoSuite;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.crypto.IKeyAccessor;
import com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager;
import com.microsoft.identity.common.java.crypto.RawKeyAccessor;
import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import com.microsoft.identity.common.java.crypto.SigningAlgorithm;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.UUID;
import javax.crypto.KeyGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidKeyStoreAccessor {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    private static final int KEY_PURPOSES = 7;
    public static final Charset UTF8 = Charset.forName("UTF-8");

    public static IKeyAccessor forAlias(@NonNull Context context, @NonNull String str, @NonNull CryptoSuite cryptoSuite) {
        IDevicePopManager devicePopManager = AndroidPlatformComponentsFactory.createFromContext(context).getDevicePopManager(str);
        if (!(cryptoSuite.cipher() instanceof IDevicePopManager.Cipher)) {
            return new AndroidSecretKeyAccessor(new AndroidDeviceKeyManager(KeyStore.getInstance(ANDROID_KEYSTORE), str), cryptoSuite) { // from class: com.microsoft.identity.common.internal.platform.AndroidKeyStoreAccessor.1
                @Override // com.microsoft.identity.common.internal.platform.AndroidSecretKeyAccessor, com.microsoft.identity.common.java.crypto.IKeyAccessor
                public byte[] sign(byte[] bArr) {
                    throw new UnsupportedOperationException("This key instance does not support signing");
                }

                @Override // com.microsoft.identity.common.internal.platform.AndroidSecretKeyAccessor, com.microsoft.identity.common.java.crypto.IKeyAccessor
                public boolean verify(byte[] bArr, byte[] bArr2) {
                    throw new UnsupportedOperationException("This key instance does not support verification");
                }
            };
        }
        if (!devicePopManager.asymmetricKeyExists()) {
            devicePopManager.generateAsymmetricKey();
        }
        return getKeyAccessor((IDevicePopManager.Cipher) cryptoSuite.cipher(), cryptoSuite.signingAlgorithm(), devicePopManager);
    }

    private static final IKeyAccessor getKeyAccessor(@NonNull final IDevicePopManager.Cipher cipher, @NonNull final SigningAlgorithm signingAlgorithm, @NonNull final IDevicePopManager iDevicePopManager) {
        return new AsymmetricKeyAccessor() { // from class: com.microsoft.identity.common.internal.platform.AndroidKeyStoreAccessor.2
            @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
            public byte[] decrypt(byte[] bArr) {
                return iDevicePopManager.decrypt(cipher, bArr);
            }

            @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
            public byte[] encrypt(byte[] bArr) {
                return iDevicePopManager.encrypt(cipher, bArr);
            }

            @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
            public IKeyAccessor generateDerivedKey(byte[] bArr, byte[] bArr2, CryptoSuite cryptoSuite) {
                throw new UnsupportedOperationException("This operation is not supported by asymmetric keys");
            }

            @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
            public Certificate[] getCertificateChain() {
                return iDevicePopManager.getCertificateChain();
            }

            @Override // com.microsoft.identity.common.internal.platform.IManagedKeyAccessor
            public IKeyStoreKeyManager<KeyStore.PrivateKeyEntry> getManager() {
                return iDevicePopManager.getKeyManager();
            }

            @Override // com.microsoft.identity.common.internal.platform.AsymmetricKeyAccessor
            public String getPublicKey(IDevicePopManager.PublicKeyFormat publicKeyFormat) {
                return iDevicePopManager.getPublicKey(publicKeyFormat);
            }

            @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
            public SecureHardwareState getSecureHardwareState() {
                return iDevicePopManager.getSecureHardwareState();
            }

            @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
            public byte[] getThumbprint() {
                return iDevicePopManager.getAsymmetricKeyThumbprint().getBytes(AndroidKeyStoreAccessor.UTF8);
            }

            @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
            public byte[] sign(byte[] bArr) {
                return iDevicePopManager.sign(signingAlgorithm, bArr);
            }

            @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
            public boolean verify(byte[] bArr, byte[] bArr2) {
                return iDevicePopManager.verify(signingAlgorithm, bArr, bArr2);
            }

            @Override // com.microsoft.identity.common.internal.platform.AsymmetricKeyAccessor
            public PublicKey getPublicKey() {
                return iDevicePopManager.getPublicKey();
            }
        };
    }

    public static IKeyAccessor importSymmetricKey(@NonNull Context context, @NonNull SymmetricCipher symmetricCipher, @NonNull String str, @NonNull String str2, @NonNull IKeyAccessor iKeyAccessor) {
        throw new UnsupportedOperationException("This operation is not yet supported");
    }

    public static IKeyAccessor newInstance(@NonNull Context context, @NonNull IDevicePopManager.Cipher cipher, @NonNull SigningAlgorithm signingAlgorithm) {
        IDevicePopManager devicePopManager = AndroidPlatformComponentsFactory.createFromContext(context).getDevicePopManager(UUID.randomUUID().toString());
        devicePopManager.generateAsymmetricKey();
        return getKeyAccessor(cipher, signingAlgorithm, devicePopManager);
    }

    public static IKeyAccessor newInstance(@NonNull SymmetricCipher symmetricCipher, @NonNull boolean z) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenParameterSpec keyGenParameterSpecBuild;
        String string = UUID.randomUUID().toString();
        int i = Build.VERSION.SDK_INT;
        if (!z) {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEYSTORE);
            KeyGenParameterSpec keyGenParameterSpec = null;
            keyStore.load(null);
            String[] strArrSplit = symmetricCipher.cipher().name().split("/");
            KeyGenerator keyGenerator = KeyGenerator.getInstance(strArrSplit[0], ANDROID_KEYSTORE);
            try {
                if (i >= 28) {
                    keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(string, 7).setIsStrongBoxBacked(true).setKeySize(symmetricCipher.keySize()).setBlockModes(strArrSplit[1]).setEncryptionPaddings(strArrSplit[2]).setKeySize(symmetricCipher.keySize()).build();
                } else {
                    keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(string, 7).setKeySize(symmetricCipher.keySize()).setBlockModes(strArrSplit[1]).setEncryptionPaddings(strArrSplit[2]).setKeySize(symmetricCipher.keySize()).build();
                }
                keyGenerator.init(keyGenParameterSpecBuild);
                keyGenerator.generateKey();
                keyGenParameterSpec = keyGenParameterSpecBuild;
            } catch (ProviderException e) {
                if (!e.getClass().getSimpleName().equals("StrongBoxUnavailableException")) {
                    throw e;
                }
            }
            if (keyGenParameterSpec == null) {
                keyGenerator.init(new KeyGenParameterSpec.Builder(string, 7).setKeySize(symmetricCipher.keySize()).setBlockModes(strArrSplit[1]).setEncryptionPaddings(strArrSplit[2]).setKeySize(symmetricCipher.keySize()).build());
                keyGenerator.generateKey();
            }
            return new AndroidSecretKeyAccessor(new AndroidDeviceKeyManager(keyStore, string), symmetricCipher) { // from class: com.microsoft.identity.common.internal.platform.AndroidKeyStoreAccessor.3
                @Override // com.microsoft.identity.common.internal.platform.AndroidSecretKeyAccessor, com.microsoft.identity.common.java.crypto.IKeyAccessor
                public byte[] sign(byte[] bArr) {
                    throw new UnsupportedOperationException("This key instance does not support signing");
                }

                @Override // com.microsoft.identity.common.internal.platform.AndroidSecretKeyAccessor, com.microsoft.identity.common.java.crypto.IKeyAccessor
                public boolean verify(byte[] bArr, byte[] bArr2) {
                    throw new UnsupportedOperationException("This key instance does not support verification");
                }
            };
        }
        KeyGenerator keyGenerator2 = KeyGenerator.getInstance(AES256KeyLoader.AES_ALGORITHM);
        keyGenerator2.init(symmetricCipher.mKeySize);
        return RawKeyAccessor.builder().suite(symmetricCipher).key(keyGenerator2.generateKey().getEncoded()).alias(string).build();
    }
}
