package org.conscrypt;

import androidx.appcompat.widget.AbstractC0541b;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.OpenSSLCipher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class OpenSSLCipherChaCha20 extends OpenSSLCipher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BLOCK_SIZE_BYTES = 64;
    private static final int NONCE_SIZE_BYTES = 12;
    private int currentBlockConsumedBytes = 0;
    private int blockCounter = 0;

    private void reset() {
        this.blockCounter = 0;
        this.currentBlockConsumedBytes = 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i) throws InvalidKeyException {
        if (i != 32) {
            throw new InvalidKeyException(AbstractC0541b.m767i(i, "Unsupported key size: ", " bytes (must be 32)"));
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        if (mode != OpenSSLCipher.Mode.NONE) {
            throw new NoSuchAlgorithmException("Mode must be NONE");
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        if (padding != OpenSSLCipher.Padding.NOPADDING) {
            throw new NoSuchPaddingException("Must be NoPadding");
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int doFinalInternal(byte[] bArr, int i, int i2) {
        reset();
        return 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            IvParameterSpec ivParameterSpec = (IvParameterSpec) algorithmParameterSpec;
            if (ivParameterSpec.getIV().length != 12) {
                throw new InvalidAlgorithmParameterException("IV must be 12 bytes long");
            }
            this.f10194iv = ivParameterSpec.getIV();
            return;
        }
        if (!isEncrypting()) {
            throw new InvalidAlgorithmParameterException("IV must be specified when decrypting");
        }
        byte[] bArr2 = new byte[12];
        this.f10194iv = bArr2;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr2);
        } else {
            NativeCrypto.RAND_bytes(bArr2);
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "ChaCha20";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i4, int i5) throws ShortBufferWithoutStackTraceException {
        int i6;
        int i7;
        int i8;
        if (i2 > bArr2.length - i4) {
            throw new ShortBufferWithoutStackTraceException("Insufficient output space");
        }
        int i9 = this.currentBlockConsumedBytes;
        if (i9 > 0) {
            int iMin = Math.min(64 - i9, i2);
            byte[] bArr3 = new byte[64];
            byte[] bArr4 = new byte[64];
            System.arraycopy(bArr, i, bArr3, this.currentBlockConsumedBytes, iMin);
            NativeCrypto.chacha20_encrypt_decrypt(bArr3, 0, bArr4, 0, 64, this.encodedKey, this.f10194iv, this.blockCounter);
            System.arraycopy(bArr4, this.currentBlockConsumedBytes, bArr2, i4, iMin);
            int i10 = this.currentBlockConsumedBytes + iMin;
            this.currentBlockConsumedBytes = i10;
            if (i10 < 64) {
                return iMin;
            }
            this.currentBlockConsumedBytes = 0;
            this.blockCounter++;
            i6 = i2 - iMin;
            i8 = i4 + iMin;
            i7 = i + iMin;
        } else {
            i6 = i2;
            i7 = i;
            i8 = i4;
        }
        NativeCrypto.chacha20_encrypt_decrypt(bArr, i7, bArr2, i8, i6, this.encodedKey, this.f10194iv, this.blockCounter);
        this.currentBlockConsumedBytes = i6 % 64;
        this.blockCounter = (i6 / 64) + this.blockCounter;
        return i2;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForFinal(int i) {
        return i;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForUpdate(int i) {
        return i;
    }
}
