package org.conscrypt;

import androidx.appcompat.widget.AbstractC0541b;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.OpenSSLCipher;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class OpenSSLAeadCipher extends OpenSSLCipher {
    static final int DEFAULT_TAG_SIZE_BITS = 128;
    private static final boolean ENABLE_BYTEBUFFER_OPTIMIZATIONS = true;
    private static int lastGlobalMessageSize = 32;
    private byte[] aad;
    byte[] buf;
    int bufCount;
    long evpAead;
    private boolean mustInitialize;
    private byte[] previousIv;
    private byte[] previousKey;
    int tagLengthInBytes;

    public OpenSSLAeadCipher(OpenSSLCipher.Mode mode) {
        super(mode, OpenSSLCipher.Padding.NOPADDING);
    }

    private boolean arraysAreEqual(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0;
    }

    private void checkInitialization() {
        if (this.mustInitialize) {
            throw new IllegalStateException("Cannot re-use same key and IV for multiple encryptions");
        }
    }

    private void expand(int i) {
        int i2 = this.bufCount;
        int i4 = i2 + i;
        byte[] bArr = this.buf;
        if (i4 <= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[(i + i2) * 2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.buf = bArr2;
    }

    private void reset() {
        this.aad = null;
        int i = lastGlobalMessageSize;
        byte[] bArr = this.buf;
        if (bArr == null) {
            this.buf = new byte[i];
        } else {
            int i2 = this.bufCount;
            if (i2 > 0 && i2 != i) {
                lastGlobalMessageSize = i2;
                if (bArr.length != i2) {
                    this.buf = new byte[i2];
                }
            }
        }
        this.bufCount = 0;
    }

    private void throwAEADBadTagExceptionIfAvailable(String str, Throwable th) throws BadPaddingException {
        BadPaddingException badPaddingException;
        try {
            BadPaddingException badPaddingException2 = null;
            try {
                try {
                    badPaddingException = (BadPaddingException) Class.forName("javax.crypto.AEADBadTagException").getConstructor(String.class).newInstance(str);
                    try {
                        badPaddingException.initCause(th);
                    } catch (IllegalAccessException | InstantiationException unused) {
                        badPaddingException2 = badPaddingException;
                        badPaddingException = badPaddingException2;
                    }
                } catch (InvocationTargetException e) {
                    throw ((BadPaddingException) new BadPaddingException().initCause(e.getTargetException()));
                }
            } catch (IllegalAccessException | InstantiationException unused2) {
            }
            if (badPaddingException != null) {
                throw badPaddingException;
            }
        } catch (Exception unused3) {
        }
    }

    public boolean allowsNonceReuse() {
        return false;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        if (padding != OpenSSLCipher.Padding.NOPADDING) {
            throw new NoSuchPaddingException("Must be NoPadding for AEAD ciphers");
        }
    }

    public void checkSupportedTagLength(int i) throws InvalidAlgorithmParameterException {
        if (i % 8 != 0) {
            throw new InvalidAlgorithmParameterException(AbstractC0000a.m11h(i, "Tag length must be a multiple of 8; was "));
        }
    }

    public int doFinalInternal(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws BadPaddingException {
        checkInitialization();
        try {
            int iEVP_AEAD_CTX_seal_buf = isEncrypting() ? NativeCrypto.EVP_AEAD_CTX_seal_buf(this.evpAead, this.encodedKey, this.tagLengthInBytes, byteBuffer2, this.f10194iv, byteBuffer, this.aad) : NativeCrypto.EVP_AEAD_CTX_open_buf(this.evpAead, this.encodedKey, this.tagLengthInBytes, byteBuffer2, this.f10194iv, byteBuffer, this.aad);
            if (isEncrypting()) {
                this.mustInitialize = true;
            }
            return iEVP_AEAD_CTX_seal_buf;
        } catch (BadPaddingException e) {
            throwAEADBadTagExceptionIfAvailable(e.getMessage(), e.getCause());
            throw e;
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws BadPaddingException, ShortBufferWithoutStackTraceException {
        if (byteBuffer == null || byteBuffer2 == null) {
            throw new NullPointerException("Null ByteBuffer Error");
        }
        if (getOutputSizeForFinal(byteBuffer.remaining()) > byteBuffer2.remaining()) {
            throw new ShortBufferWithoutStackTraceException("Insufficient Bytes for Output Buffer");
        }
        if (byteBuffer2.isReadOnly()) {
            throw new IllegalArgumentException("Cannot write to Read Only ByteBuffer");
        }
        if (this.bufCount != 0) {
            return super.engineDoFinal(byteBuffer, byteBuffer2);
        }
        if (!byteBuffer.isDirect()) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
            byteBufferAllocateDirect.mark();
            byteBufferAllocateDirect.put(byteBuffer);
            byteBufferAllocateDirect.reset();
            byteBuffer = byteBufferAllocateDirect;
        }
        if (byteBuffer2.isDirect()) {
            int iDoFinalInternal = doFinalInternal(byteBuffer, byteBuffer2);
            byteBuffer2.position(byteBuffer2.position() + iDoFinalInternal);
            byteBuffer.position(byteBuffer.limit());
            return iDoFinalInternal;
        }
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(getOutputSizeForFinal(byteBuffer.remaining()));
        int iDoFinalInternal2 = doFinalInternal(byteBuffer, byteBufferAllocateDirect2);
        byteBuffer2.put(byteBufferAllocateDirect2);
        byteBuffer.position(byteBuffer.limit());
        return iDoFinalInternal2;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        byte[] iv = null;
        int tLen = 128;
        if (algorithmParameterSpec != null) {
            GCMParameters gCMParametersFromGCMParameterSpec = Platform.fromGCMParameterSpec(algorithmParameterSpec);
            if (gCMParametersFromGCMParameterSpec != null) {
                iv = gCMParametersFromGCMParameterSpec.getIV();
                tLen = gCMParametersFromGCMParameterSpec.getTLen();
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
            }
        }
        checkSupportedTagLength(tLen);
        this.tagLengthInBytes = tLen / 8;
        boolean zIsEncrypting = isEncrypting();
        long evp_aead = getEVP_AEAD(bArr.length);
        this.evpAead = evp_aead;
        int iEVP_AEAD_nonce_length = NativeCrypto.EVP_AEAD_nonce_length(evp_aead);
        if (iv != null || iEVP_AEAD_nonce_length == 0) {
            if (iEVP_AEAD_nonce_length == 0 && iv != null) {
                throw new InvalidAlgorithmParameterException("IV not used in " + this.mode + " mode");
            }
            if (iv != null && iv.length != iEVP_AEAD_nonce_length) {
                StringBuilder sbM778t = AbstractC0541b.m778t(iEVP_AEAD_nonce_length, "Expected IV length of ", " but was ");
                sbM778t.append(iv.length);
                throw new InvalidAlgorithmParameterException(sbM778t.toString());
            }
        } else {
            if (!zIsEncrypting) {
                throw new InvalidAlgorithmParameterException("IV must be specified in " + this.mode + " mode");
            }
            iv = new byte[iEVP_AEAD_nonce_length];
            if (secureRandom != null) {
                secureRandom.nextBytes(iv);
            } else {
                NativeCrypto.RAND_bytes(iv);
            }
        }
        if (isEncrypting() && iv != null && !allowsNonceReuse()) {
            byte[] bArr2 = this.previousKey;
            if (bArr2 != null && this.previousIv != null && arraysAreEqual(bArr2, bArr) && arraysAreEqual(this.previousIv, iv)) {
                this.mustInitialize = true;
                throw new InvalidAlgorithmParameterException("When using AEAD key and IV must not be re-used");
            }
            this.previousKey = bArr;
            this.previousIv = iv;
        }
        this.mustInitialize = false;
        this.f10194iv = iv;
        reset();
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(byte[] bArr, int i, int i2) {
        checkInitialization();
        byte[] bArr2 = this.aad;
        if (bArr2 == null) {
            this.aad = Arrays.copyOfRange(bArr, i, i2 + i);
            return;
        }
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, this.aad.length, i2);
        this.aad = bArr3;
    }

    public abstract long getEVP_AEAD(int i);

    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForFinal(int i) {
        return this.bufCount + i + (isEncrypting() ? NativeCrypto.EVP_AEAD_max_overhead(this.evpAead) : 0);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForUpdate(int i) {
        return 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i4, int i5) {
        checkInitialization();
        if (this.buf == null) {
            throw new IllegalStateException("Cipher not initialized");
        }
        ArrayUtils.checkOffsetAndCount(bArr.length, i, i2);
        if (i2 <= 0) {
            return 0;
        }
        expand(i2);
        System.arraycopy(bArr, i, this.buf, this.bufCount, i2);
        this.bufCount += i2;
        return 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int doFinalInternal(byte[] bArr, int i, int i2) throws BadPaddingException {
        int iEVP_AEAD_CTX_open;
        checkInitialization();
        try {
            if (isEncrypting()) {
                iEVP_AEAD_CTX_open = NativeCrypto.EVP_AEAD_CTX_seal(this.evpAead, this.encodedKey, this.tagLengthInBytes, bArr, i, this.f10194iv, this.buf, 0, this.bufCount, this.aad);
            } else {
                iEVP_AEAD_CTX_open = NativeCrypto.EVP_AEAD_CTX_open(this.evpAead, this.encodedKey, this.tagLengthInBytes, bArr, i, this.f10194iv, this.buf, 0, this.bufCount, this.aad);
            }
            if (isEncrypting()) {
                this.mustInitialize = true;
            }
            reset();
            return iEVP_AEAD_CTX_open;
        } catch (BadPaddingException e) {
            throwAEADBadTagExceptionIfAvailable(e.getMessage(), e.getCause());
            throw e;
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        checkInitialization();
        byte[] bArr = this.aad;
        if (bArr == null) {
            byte[] bArr2 = new byte[byteBuffer.remaining()];
            this.aad = bArr2;
            byteBuffer.get(bArr2);
        } else {
            byte[] bArr3 = new byte[byteBuffer.remaining() + bArr.length];
            byte[] bArr4 = this.aad;
            System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
            byteBuffer.get(bArr3, this.aad.length, byteBuffer.remaining());
            this.aad = bArr3;
        }
    }

    @Override // org.conscrypt.OpenSSLCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i4) throws ShortBufferWithoutStackTraceException {
        if (bArr2 != null && getOutputSizeForFinal(i2) > bArr2.length - i4) {
            throw new ShortBufferWithoutStackTraceException("Insufficient output space");
        }
        return super.engineDoFinal(bArr, i, i2, bArr2, i4);
    }
}
