package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.opentelemetry.CryptoFactoryTelemetryHelper;
import com.microsoft.identity.common.java.opentelemetry.CryptoObjectName;
import com.microsoft.identity.common.java.opentelemetry.ICryptoOperation;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BasicDecryptor implements IDecryptor {
    private final ICryptoFactory mCryptoFactory;

    public BasicDecryptor(ICryptoFactory iCryptoFactory) {
        this.mCryptoFactory = iCryptoFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] decryptWithGcmInternal(@NonNull Key key, @NonNull String str, byte[] bArr, byte[] bArr2, int i, @Nullable byte[] bArr3) throws ClientException {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("decryptAlgorithm is marked non-null but is null");
        }
        Cipher cipher = this.mCryptoFactory.getCipher(str);
        try {
            cipher.init(2, key, new GCMParameterSpec(i * 8, bArr));
            if (bArr3 != null) {
                cipher.updateAAD(bArr3);
            }
            return cipher.doFinal(bArr2);
        } catch (InvalidAlgorithmParameterException e) {
            throw new ClientException(ClientException.INVALID_ALG_PARAMETER, e.getMessage(), e);
        } catch (InvalidKeyException e2) {
            throw new ClientException(ClientException.INVALID_KEY, e2.getMessage(), e2);
        } catch (BadPaddingException e3) {
            throw new ClientException(ClientException.BAD_PADDING, e3.getMessage(), e3);
        } catch (IllegalBlockSizeException e5) {
            throw new ClientException(ClientException.INVALID_BLOCK_SIZE, e5.getMessage(), e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0021 A[Catch: InvalidAlgorithmParameterException -> 0x0019, InvalidKeyException -> 0x001b, IllegalBlockSizeException -> 0x001d, BadPaddingException -> 0x001f, TryCatch #2 {InvalidAlgorithmParameterException -> 0x0019, InvalidKeyException -> 0x001b, BadPaddingException -> 0x001f, IllegalBlockSizeException -> 0x001d, blocks: (B:6:0x000d, B:8:0x0010, B:18:0x0024, B:17:0x0021), top: B:32:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] decryptWithIvInternal(@NonNull Key key, @NonNull String str, byte[] bArr, byte[] bArr2) throws ClientException {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("decryptAlgorithm is marked non-null but is null");
        }
        Cipher cipher = this.mCryptoFactory.getCipher(str);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    cipher.init(2, key, new IvParameterSpec(bArr));
                } else {
                    cipher.init(2, key);
                }
            } catch (InvalidAlgorithmParameterException e) {
                throw new ClientException(ClientException.INVALID_ALG_PARAMETER, e.getMessage(), e);
            } catch (InvalidKeyException e2) {
                throw new ClientException(ClientException.INVALID_KEY, e2.getMessage(), e2);
            } catch (BadPaddingException e3) {
                throw new ClientException(ClientException.BAD_PADDING, e3.getMessage(), e3);
            } catch (IllegalBlockSizeException e5) {
                throw new ClientException(ClientException.INVALID_BLOCK_SIZE, e5.getMessage(), e5);
            }
        }
        return cipher.doFinal(bArr2);
    }

    @Override // com.microsoft.identity.common.java.crypto.IDecryptor
    public byte[] decryptWithGcm(@NonNull final Key key, @NonNull final String str, final byte[] bArr, final byte[] bArr2, final int i, final byte[] bArr3) {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str != null) {
            return (byte[]) CryptoFactoryTelemetryHelper.performCryptoOperationAndUploadTelemetry(CryptoObjectName.Cipher, str, this.mCryptoFactory, new ICryptoOperation<byte[]>() { // from class: com.microsoft.identity.common.java.crypto.BasicDecryptor.2
                @Override // com.microsoft.identity.common.java.opentelemetry.ICryptoOperation
                public byte[] perform() {
                    return BasicDecryptor.this.decryptWithGcmInternal(key, str, bArr, bArr2, i, bArr3);
                }
            });
        }
        throw new NullPointerException("decryptAlgorithm is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDecryptor
    public byte[] decryptWithIv(@NonNull final Key key, @NonNull final String str, final byte[] bArr, final byte[] bArr2) {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str != null) {
            return (byte[]) CryptoFactoryTelemetryHelper.performCryptoOperationAndUploadTelemetry(CryptoObjectName.Cipher, str, this.mCryptoFactory, new ICryptoOperation<byte[]>() { // from class: com.microsoft.identity.common.java.crypto.BasicDecryptor.1
                @Override // com.microsoft.identity.common.java.opentelemetry.ICryptoOperation
                public byte[] perform() {
                    return BasicDecryptor.this.decryptWithIvInternal(key, str, bArr, bArr2);
                }
            });
        }
        throw new NullPointerException("decryptAlgorithm is marked non-null but is null");
    }
}
