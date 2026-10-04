package com.microsoft.identity.common.internal.platform;

import androidx.annotation.RequiresApi;
import com.microsoft.identity.common.java.crypto.CryptoSuite;
import com.microsoft.identity.common.java.crypto.IKeyAccessor;
import com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager;
import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import com.microsoft.identity.common.java.exception.ClientException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidSecretKeyAccessor implements IManagedKeyAccessor<KeyStore.SecretKeyEntry> {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final AndroidDeviceKeyManager<KeyStore.SecretKeyEntry> mKeyManager;
    private final CryptoSuite suite;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AndroidSecretKeyAccessorBuilder {
        private AndroidDeviceKeyManager<KeyStore.SecretKeyEntry> keyManager;
        private CryptoSuite suite;

        public AndroidSecretKeyAccessor build() {
            return new AndroidSecretKeyAccessor(this.keyManager, this.suite);
        }

        public AndroidSecretKeyAccessorBuilder keyManager(AndroidDeviceKeyManager<KeyStore.SecretKeyEntry> androidDeviceKeyManager) {
            this.keyManager = androidDeviceKeyManager;
            return this;
        }

        public AndroidSecretKeyAccessorBuilder suite(CryptoSuite cryptoSuite) {
            this.suite = cryptoSuite;
            return this;
        }

        public String toString() {
            return "AndroidSecretKeyAccessor.AndroidSecretKeyAccessorBuilder(keyManager=" + this.keyManager + ", suite=" + this.suite + ")";
        }
    }

    public AndroidSecretKeyAccessor(AndroidDeviceKeyManager<KeyStore.SecretKeyEntry> androidDeviceKeyManager, CryptoSuite cryptoSuite) {
        this.mKeyManager = androidDeviceKeyManager;
        this.suite = cryptoSuite;
    }

    public static AndroidSecretKeyAccessorBuilder builder() {
        return new AndroidSecretKeyAccessorBuilder();
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    @RequiresApi(api = 19)
    public byte[] decrypt(@NonNull byte[] bArr) throws ClientException {
        String str;
        if (bArr == null) {
            throw new NullPointerException("ciphertext is marked non-null but is null");
        }
        try {
            SecretKey secretKey = this.mKeyManager.getEntry().getSecretKey();
            Cipher cipher = Cipher.getInstance(this.suite.cipher().name());
            cipher.init(2, secretKey, new GCMParameterSpec(128, bArr, 0, 12));
            return cipher.doFinal(Arrays.copyOfRange(bArr, 12, bArr.length));
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            str = ClientException.INVALID_ALG_PARAMETER;
            throw new ClientException(str, e.getMessage(), e);
        } catch (InvalidKeyException e2) {
            e = e2;
            str = ClientException.INVALID_KEY;
            throw new ClientException(str, e.getMessage(), e);
        } catch (KeyStoreException e3) {
            e = e3;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            throw new ClientException(str, e.getMessage(), e);
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            str = "no_such_algorithm";
            throw new ClientException(str, e.getMessage(), e);
        } catch (UnrecoverableEntryException e6) {
            e = e6;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            throw new ClientException(str, e.getMessage(), e);
        } catch (BadPaddingException e7) {
            e = e7;
            str = ClientException.BAD_PADDING;
            throw new ClientException(str, e.getMessage(), e);
        } catch (IllegalBlockSizeException e8) {
            e = e8;
            str = ClientException.INVALID_BLOCK_SIZE;
            throw new ClientException(str, e.getMessage(), e);
        } catch (NoSuchPaddingException e9) {
            e = e9;
            str = ClientException.NO_SUCH_PADDING;
            throw new ClientException(str, e.getMessage(), e);
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    @RequiresApi(api = 19)
    public byte[] encrypt(@NonNull byte[] bArr) throws ClientException {
        String str;
        if (bArr == null) {
            throw new NullPointerException("plaintext is marked non-null but is null");
        }
        try {
            SecretKey secretKey = this.mKeyManager.getEntry().getSecretKey();
            Cipher cipher = Cipher.getInstance(this.suite.cipher().name());
            cipher.init(1, secretKey);
            byte[] iv = cipher.getIV();
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] bArr2 = new byte[iv.length + bArrDoFinal.length];
            System.arraycopy(iv, 0, bArr2, 0, iv.length);
            System.arraycopy(bArrDoFinal, 0, bArr2, iv.length, bArrDoFinal.length);
            return bArr2;
        } catch (InvalidKeyException e) {
            e = e;
            str = ClientException.INVALID_KEY;
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
        } catch (BadPaddingException e6) {
            e = e6;
            str = ClientException.BAD_PADDING;
            throw new ClientException(str, e.getMessage(), e);
        } catch (IllegalBlockSizeException e7) {
            e = e7;
            str = ClientException.INVALID_BLOCK_SIZE;
            throw new ClientException(str, e.getMessage(), e);
        } catch (NoSuchPaddingException e8) {
            e = e8;
            str = ClientException.NO_SUCH_PADDING;
            throw new ClientException(str, e.getMessage(), e);
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public IKeyAccessor generateDerivedKey(byte[] bArr, byte[] bArr2, CryptoSuite cryptoSuite) {
        throw new UnsupportedOperationException("This operation is not supported by inaccessible keys");
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public Certificate[] getCertificateChain() {
        return this.mKeyManager.getCertificateChain();
    }

    @Override // com.microsoft.identity.common.internal.platform.IManagedKeyAccessor
    public IKeyStoreKeyManager<KeyStore.SecretKeyEntry> getManager() {
        return this.mKeyManager;
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public SecureHardwareState getSecureHardwareState() {
        return this.mKeyManager.getSecureHardwareState();
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public byte[] getThumbprint() {
        return this.mKeyManager.getThumbprint();
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public byte[] sign(@NonNull byte[] bArr) throws ClientException {
        String str;
        if (bArr == null) {
            throw new NullPointerException("text is marked non-null but is null");
        }
        try {
            SecretKey secretKey = this.mKeyManager.getEntry().getSecretKey();
            Mac mac = Mac.getInstance(this.suite.macName());
            mac.init(secretKey);
            return mac.doFinal(bArr);
        } catch (InvalidKeyException e) {
            e = e;
            str = ClientException.INVALID_KEY;
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

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public boolean verify(@NonNull byte[] bArr, @NonNull byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("text is marked non-null but is null");
        }
        if (bArr2 != null) {
            return Arrays.equals(bArr2, sign(bArr));
        }
        throw new NullPointerException("signature is marked non-null but is null");
    }
}
