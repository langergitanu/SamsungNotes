package com.microsoft.identity.common.java.platform;

import com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.nio.charset.Charset;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Date;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractKeyStoreKeyManager<K extends KeyStore.Entry> implements IKeyStoreKeyManager<K> {
    private static final String TAG = "AbstractKeyStoreKeyManager";
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final String mKeyAlias;
    protected final KeyStore mKeyStore;
    private final KeyStore.PasswordProtection mPasswordProtection;

    public AbstractKeyStoreKeyManager(@NonNull KeyStore keyStore, @NonNull String str, @Nullable KeyStore.PasswordProtection passwordProtection) {
        if (keyStore == null) {
            throw new NullPointerException("keyStore is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("keyAlias is marked non-null but is null");
        }
        this.mKeyAlias = str;
        this.mKeyStore = keyStore;
        this.mPasswordProtection = passwordProtection;
    }

    public static KeyPair getKeyPairForEntry(@NonNull KeyStore.PrivateKeyEntry privateKeyEntry) {
        if (privateKeyEntry == null) {
            throw new NullPointerException("entry is marked non-null but is null");
        }
        return new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
    }

    public static RSAKey getRsaKeyForKeyPair(@NonNull KeyPair keyPair) {
        if (keyPair == null) {
            throw new NullPointerException("keyPair is marked non-null but is null");
        }
        if (keyPair.getPublic() instanceof RSAPublicKey) {
            return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic()).keyUse(null).build();
        }
        throw new UnsupportedOperationException("Cannot get RSAKey for key of type: " + keyPair.getPublic().getClass().getCanonicalName());
    }

    public static String getRsaThumbprint(@NonNull KeyStore.PrivateKeyEntry privateKeyEntry) {
        if (privateKeyEntry != null) {
            return getThumbprintForRsaKey(getRsaKeyForKeyPair(getKeyPairForEntry(privateKeyEntry)));
        }
        throw new NullPointerException("entry is marked non-null but is null");
    }

    public static byte[] getSecretKeyThumbprint(@NonNull KeyStore.SecretKeyEntry secretKeyEntry) {
        if (secretKeyEntry == null) {
            throw new NullPointerException("entry is marked non-null but is null");
        }
        try {
            SecretKey secretKey = secretKeyEntry.getSecretKey();
            Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
            return MessageDigest.getInstance("SHA256").digest(cipher.doFinal((secretKey.getAlgorithm() + cipher.getBlockSize() + cipher.getParameters()).getBytes(UTF8)));
        } catch (NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            Logger.error("KeyAccessor:newInstance", null, "Exception while getting key entry", e);
            return null;
        }
    }

    public static String getThumbprintForRsaKey(@NonNull RSAKey rSAKey) {
        if (rSAKey != null) {
            return rSAKey.computeThumbprint().toString();
        }
        throw new NullPointerException("rsaKey is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public boolean clear() {
        try {
            this.mKeyStore.deleteEntry(this.mKeyAlias);
            return true;
        } catch (KeyStoreException e) {
            Logger.error(TAG, "Error while clearing KeyStore", e);
            return false;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public boolean exists() {
        try {
            return this.mKeyStore.containsAlias(this.mKeyAlias);
        } catch (KeyStoreException e) {
            Logger.error(TAG, "Error while querying KeyStore", e);
            return false;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public Certificate[] getCertificateChain() throws ClientException {
        try {
            return this.mKeyStore.getCertificateChain(this.mKeyAlias);
        } catch (KeyStoreException e) {
            ClientException clientException = new ClientException(ClientException.KEYSTORE_NOT_INITIALIZED, e.getMessage(), e);
            Logger.error(TAG, clientException.getMessage(), clientException);
            throw clientException;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public Date getCreationDate() throws ClientException {
        try {
            return this.mKeyStore.getCreationDate(this.mKeyAlias);
        } catch (KeyStoreException e) {
            Logger.error(TAG, "Error while getting creation date for alias " + this.mKeyAlias, e);
            throw new ClientException(ClientException.KEYSTORE_NOT_INITIALIZED, e.getMessage(), e);
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public K getEntry() {
        return (K) this.mKeyStore.getEntry(this.mKeyAlias, this.mPasswordProtection);
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public String getKeyAlias() {
        return this.mKeyAlias;
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public byte[] getThumbprint() throws ClientException {
        String str;
        try {
            KeyStore.Entry entry = getEntry();
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                return getRsaThumbprint((KeyStore.PrivateKeyEntry) entry).getBytes(UTF8);
            }
            if (entry instanceof KeyStore.SecretKeyEntry) {
                return getSecretKeyThumbprint((KeyStore.SecretKeyEntry) entry);
            }
            throw new UnsupportedOperationException("Get thumbprint currently not supported for key of type: " + entry.getClass().getCanonicalName());
        } catch (JOSEException e) {
            e = e;
            str = ClientException.THUMBPRINT_COMPUTATION_FAILURE;
            throw new ClientException(str, e.getMessage(), e);
        } catch (KeyStoreException e2) {
            e = e2;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            throw new ClientException(str, e.getMessage(), e);
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str = "no_such_algorithm";
            throw new ClientException(str, e.getMessage(), e);
        } catch (UnrecoverableEntryException e5) {
            e = e5;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            throw new ClientException(str, e.getMessage(), e);
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public boolean hasThumbprint(byte[] bArr) {
        try {
            return Arrays.equals(bArr, getThumbprint());
        } catch (ClientException unused) {
            return false;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager
    public void importKey(@NonNull byte[] bArr, @NonNull String str) {
        if (bArr == null) {
            throw new NullPointerException("jwk is marked non-null but is null");
        }
        if (str != null) {
            throw new UnsupportedOperationException("This is not currently supported");
        }
        throw new NullPointerException("algorithm is marked non-null but is null");
    }
}
