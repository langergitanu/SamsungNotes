package com.microsoft.identity.common.java.crypto;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings({"EI_EXPOSE_REP"})
public class RawKeyAccessor implements IKeyAccessor {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private final String mAlias;

    @NonNull
    private final byte[] mKey;

    @NonNull
    private final CryptoSuite mSuite;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RawKeyAccessorBuilder {
        private String alias;
        private byte[] key;
        private CryptoSuite suite;

        public RawKeyAccessorBuilder alias(String str) {
            this.alias = str;
            return this;
        }

        public RawKeyAccessor build() {
            return new RawKeyAccessor(this.suite, this.key, this.alias);
        }

        public RawKeyAccessorBuilder key(@NonNull byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("key is marked non-null but is null");
            }
            this.key = bArr;
            return this;
        }

        public RawKeyAccessorBuilder suite(@NonNull CryptoSuite cryptoSuite) {
            if (cryptoSuite == null) {
                throw new NullPointerException("suite is marked non-null but is null");
            }
            this.suite = cryptoSuite;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("RawKeyAccessor.RawKeyAccessorBuilder(suite=");
            sb.append(this.suite);
            sb.append(", key=");
            sb.append(Arrays.toString(this.key));
            sb.append(", alias=");
            return AbstractC0622a.m1170p(this.alias, ")", sb);
        }
    }

    public RawKeyAccessor(@NonNull CryptoSuite cryptoSuite, @NonNull byte[] bArr, String str) {
        if (cryptoSuite == null) {
            throw new NullPointerException("suite is marked non-null but is null");
        }
        if (bArr == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        this.mSuite = cryptoSuite;
        this.mKey = bArr;
        this.mAlias = str;
    }

    public static RawKeyAccessorBuilder builder() {
        return new RawKeyAccessorBuilder();
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public byte[] decrypt(@NonNull byte[] bArr) throws ClientException {
        String str;
        if (bArr == null) {
            throw new NullPointerException("ciphertext is marked non-null but is null");
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.mKey, this.mSuite.cipher().name());
            Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr, 0, 12));
            return cipher.doFinal(Arrays.copyOfRange(bArr, 12, bArr.length));
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            str = ClientException.INVALID_ALG_PARAMETER;
            throw new ClientException(str, e.getMessage(), e);
        } catch (InvalidKeyException e2) {
            e = e2;
            str = ClientException.INVALID_KEY;
            throw new ClientException(str, e.getMessage(), e);
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str = "no_such_algorithm";
            throw new ClientException(str, e.getMessage(), e);
        } catch (BadPaddingException e5) {
            e = e5;
            str = ClientException.BAD_PADDING;
            throw new ClientException(str, e.getMessage(), e);
        } catch (IllegalBlockSizeException e6) {
            e = e6;
            str = ClientException.INVALID_BLOCK_SIZE;
            throw new ClientException(str, e.getMessage(), e);
        } catch (NoSuchPaddingException e7) {
            e = e7;
            str = ClientException.NO_SUCH_PADDING;
            throw new ClientException(str, e.getMessage(), e);
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public byte[] encrypt(@NonNull byte[] bArr) throws ClientException {
        String str;
        if (bArr == null) {
            throw new NullPointerException("plaintext is marked non-null but is null");
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.mKey, this.mSuite.cipher().name());
            Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
            byte[] bArr2 = new byte[12];
            SECURE_RANDOM.nextBytes(bArr2);
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
            byte[] bArrUpdate = cipher.update(bArr);
            byte[] bArrDoFinal = cipher.doFinal();
            byte[] bArr3 = new byte[bArrUpdate.length + 12 + bArrDoFinal.length];
            System.arraycopy(bArr2, 0, bArr3, 0, 12);
            System.arraycopy(bArrUpdate, 0, bArr3, 12, bArrUpdate.length);
            System.arraycopy(bArrDoFinal, 0, bArr3, 12 + bArrUpdate.length, bArrDoFinal.length);
            return bArr3;
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            str = ClientException.INVALID_ALG_PARAMETER;
            throw new ClientException(str, e.getMessage());
        } catch (InvalidKeyException e2) {
            e = e2;
            str = ClientException.INVALID_KEY;
            throw new ClientException(str, e.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str = "no_such_algorithm";
            throw new ClientException(str, e.getMessage());
        } catch (BadPaddingException e5) {
            e = e5;
            str = ClientException.BAD_PADDING;
            throw new ClientException(str, e.getMessage());
        } catch (IllegalBlockSizeException e6) {
            e = e6;
            str = ClientException.INVALID_BLOCK_SIZE;
            throw new ClientException(str, e.getMessage());
        } catch (NoSuchPaddingException e7) {
            e = e7;
            str = ClientException.NO_SUCH_PADDING;
            throw new ClientException(str, e.getMessage());
        }
    }

    public byte[] generateDerivedKey(byte[] bArr, @NonNull byte[] bArr2) throws ClientException {
        if (bArr2 == null) {
            throw new NullPointerException("ctx is marked non-null but is null");
        }
        try {
            return new SP800108KeyGen(new DefaultCryptoFactory()).generateDerivedKey(this.mKey, bArr, bArr2);
        } catch (IOException e) {
            throw new ClientException("io_error", e.getMessage(), e);
        } catch (InvalidKeyException e2) {
            throw new ClientException(ClientException.INVALID_KEY, e2.getMessage(), e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new ClientException("no_such_algorithm", e3.getMessage(), e3);
        }
    }

    public String getAlias() {
        return this.mAlias;
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    @Nullable
    public Certificate[] getCertificateChain() {
        return null;
    }

    @NonNull
    public byte[] getKey() {
        return this.mKey;
    }

    public byte[] getRawKey() {
        byte[] bArr = this.mKey;
        return Arrays.copyOf(bArr, bArr.length);
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public SecureHardwareState getSecureHardwareState() {
        return SecureHardwareState.FALSE;
    }

    @NonNull
    public CryptoSuite getSuite() {
        return this.mSuite;
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public byte[] getThumbprint() throws ClientException {
        String str;
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.mKey, this.mSuite.cipher().name());
        try {
            Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
            return MessageDigest.getInstance("SHA256").digest(cipher.doFinal((secretKeySpec.getAlgorithm() + cipher.getBlockSize() + cipher.getParameters()).getBytes(AuthenticationConstants.CHARSET_UTF8)));
        } catch (NoSuchAlgorithmException e) {
            e = e;
            str = "no_such_algorithm";
            throw new ClientException(str, e.getMessage(), e);
        } catch (BadPaddingException e2) {
            e = e2;
            str = ClientException.BAD_PADDING;
            throw new ClientException(str, e.getMessage(), e);
        } catch (IllegalBlockSizeException e3) {
            e = e3;
            str = ClientException.INVALID_BLOCK_SIZE;
            throw new ClientException(str, e.getMessage(), e);
        } catch (NoSuchPaddingException e5) {
            e = e5;
            str = ClientException.NO_SUCH_PADDING;
            throw new ClientException(str, e.getMessage(), e);
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public byte[] sign(@NonNull byte[] bArr) throws ClientException {
        String str;
        if (bArr == null) {
            throw new NullPointerException("text is marked non-null but is null");
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.mKey, this.mSuite.cipher().name());
            Mac mac = Mac.getInstance(this.mSuite.macName());
            mac.init(secretKeySpec);
            return mac.doFinal(bArr);
        } catch (InvalidKeyException e) {
            e = e;
            str = ClientException.INVALID_KEY;
            throw new ClientException(str, e.getMessage());
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            str = "no_such_algorithm";
            throw new ClientException(str, e.getMessage());
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

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessor
    public IKeyAccessor generateDerivedKey(@NonNull byte[] bArr, @NonNull byte[] bArr2, @NonNull CryptoSuite cryptoSuite) throws ClientException {
        if (bArr == null) {
            throw new NullPointerException("label is marked non-null but is null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("ctx is marked non-null but is null");
        }
        if (cryptoSuite != null) {
            try {
                return new RawKeyAccessor(cryptoSuite, new SP800108KeyGen(new DefaultCryptoFactory()).generateDerivedKey(this.mKey, bArr, bArr2), null);
            } catch (IOException e) {
                throw new ClientException("io_error", e.getMessage(), e);
            } catch (InvalidKeyException e2) {
                throw new ClientException(ClientException.INVALID_KEY, e2.getMessage(), e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new ClientException("no_such_algorithm", e3.getMessage(), e3);
            }
        }
        throw new NullPointerException("suite is marked non-null but is null");
    }
}
