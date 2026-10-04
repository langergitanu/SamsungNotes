package com.microsoft.identity.common.internal.platform;

import android.security.keystore.KeyInfo;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.platform.AbstractKeyStoreKeyManager;
import com.microsoft.identity.common.logging.Logger;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidDeviceKeyManager<K extends KeyStore.Entry> extends AbstractKeyStoreKeyManager<K> {
    private static final String TAG = "AndroidDeviceKeyManager";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AndroidDeviceKeyManagerBuilder<K extends KeyStore.Entry> {
        private String keyAlias;
        private KeyStore keyStore;

        public AndroidDeviceKeyManager<K> build() {
            return new AndroidDeviceKeyManager<>(this.keyStore, this.keyAlias);
        }

        public AndroidDeviceKeyManagerBuilder<K> keyAlias(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("keyAlias is marked non-null but is null");
            }
            this.keyAlias = str;
            return this;
        }

        public AndroidDeviceKeyManagerBuilder<K> keyStore(@NonNull KeyStore keyStore) {
            if (keyStore == null) {
                throw new NullPointerException("keyStore is marked non-null but is null");
            }
            this.keyStore = keyStore;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("AndroidDeviceKeyManager.AndroidDeviceKeyManagerBuilder(keyStore=");
            sb.append(this.keyStore);
            sb.append(", keyAlias=");
            return AbstractC0622a.m1170p(this.keyAlias, ")", sb);
        }
    }

    public AndroidDeviceKeyManager(@NonNull KeyStore keyStore, @NonNull String str) {
        super(keyStore, str, null);
        if (keyStore == null) {
            throw new NullPointerException("keyStore is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("keyAlias is marked non-null but is null");
        }
    }

    public static <K extends KeyStore.Entry> AndroidDeviceKeyManagerBuilder<K> builder() {
        return new AndroidDeviceKeyManagerBuilder<>();
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public SecureHardwareState getSecureHardwareState() throws ClientException {
        String str;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getSecureHardwareState", new StringBuilder());
        try {
            try {
                K entry = getEntry();
                if (entry instanceof KeyStore.PrivateKeyEntry) {
                    try {
                        PrivateKey privateKey = ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
                        boolean zIsInsideSecureHardware = ((KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), this.mKeyStore.getProvider()).getKeySpec(privateKey, KeyInfo.class)).isInsideSecureHardware();
                        Logger.info(strM1170p, "PrivateKey is secure hardware backed? " + zIsInsideSecureHardware);
                        return zIsInsideSecureHardware ? SecureHardwareState.TRUE_UNATTESTED : SecureHardwareState.FALSE;
                    } catch (NoSuchAlgorithmException e) {
                        e = e;
                        Logger.error(strM1170p, "Failed to query secure hardware state.", e);
                        return SecureHardwareState.UNKNOWN_QUERY_ERROR;
                    } catch (InvalidKeySpecException e2) {
                        e = e2;
                        Logger.error(strM1170p, "Failed to query secure hardware state.", e);
                        return SecureHardwareState.UNKNOWN_QUERY_ERROR;
                    }
                }
                if (!(entry instanceof KeyStore.SecretKeyEntry)) {
                    throw new ClientException("unknown_error", "Cannot handle entries of type " + entry.getClass().getCanonicalName());
                }
                try {
                    SecretKey secretKey = ((KeyStore.SecretKeyEntry) entry).getSecretKey();
                    boolean zIsInsideSecureHardware2 = ((KeyInfo) SecretKeyFactory.getInstance(secretKey.getAlgorithm(), this.mKeyStore.getProvider()).getKeySpec(secretKey, KeyInfo.class)).isInsideSecureHardware();
                    Logger.info(strM1170p, "SecretKey is secure hardware backed? " + zIsInsideSecureHardware2);
                    return zIsInsideSecureHardware2 ? SecureHardwareState.TRUE_UNATTESTED : SecureHardwareState.FALSE;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    Logger.error(strM1170p, "Failed to query secure hardware state.", e);
                    return SecureHardwareState.UNKNOWN_QUERY_ERROR;
                } catch (InvalidKeySpecException e5) {
                    e = e5;
                    Logger.error(strM1170p, "Failed to query secure hardware state.", e);
                    return SecureHardwareState.UNKNOWN_QUERY_ERROR;
                }
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                str = "no_such_algorithm";
                ClientException clientException = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException;
            }
        } catch (KeyStoreException e7) {
            e = e7;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, str, e);
            throw clientException2;
        } catch (UnrecoverableEntryException e8) {
            e = e8;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException22 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, str, e);
            throw clientException22;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public void storeAsymmetricKey(@NonNull PrivateKey privateKey, @NonNull Certificate[] certificateArr) {
        if (privateKey == null) {
            throw new NullPointerException("privateKey is marked non-null but is null");
        }
        if (certificateArr != null) {
            throw new UnsupportedOperationException("This is not currently supported");
        }
        throw new NullPointerException("certChain is marked non-null but is null");
    }
}
