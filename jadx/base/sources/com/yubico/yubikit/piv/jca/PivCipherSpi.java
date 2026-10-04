package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PivSession;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Map;
import javax.annotation.Nullable;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PivCipherSpi extends CipherSpi {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) PivCipherSpi.class);
    private final Map<KeyType, KeyPair> dummyKeys;

    @Nullable
    private String mode;

    @Nullable
    private String padding;

    @Nullable
    private PivPrivateKey privateKey;
    private final Callback<Callback<Result<PivSession, Exception>>> provider;
    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private int opmode = -1;

    public PivCipherSpi(Callback<Callback<Result<PivSession, Exception>>> callback, Map<KeyType, KeyPair> map) {
        this.provider = callback;
        this.dummyKeys = map;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        if (this.privateKey == null) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (i2 > 0) {
            this.buffer.write(bArr, i, i2);
        }
        byte[] byteArray = this.buffer.toByteArray();
        try {
            KeyPair keyPair = this.dummyKeys.get(this.privateKey.keyType);
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            cipher.init(this.opmode, keyPair.getPublic());
            Cipher cipher2 = Cipher.getInstance("RSA/" + this.mode + "/" + this.padding);
            cipher2.init(this.opmode, keyPair.getPrivate());
            int i4 = this.opmode;
            if (i4 != 1) {
                if (i4 == 2) {
                    return cipher2.doFinal(cipher.doFinal(this.privateKey.rawSignOrDecrypt(this.provider, byteArray)));
                }
                throw new UnsupportedOperationException();
            }
            try {
                return this.privateKey.rawSignOrDecrypt(this.provider, cipher.doFinal(cipher2.doFinal(byteArray)));
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                throw new IllegalStateException(e);
            }
        } catch (NoSuchPaddingException e2) {
            throw new UnsupportedOperationException("SecurityProvider doesn't support RSA without padding", e2);
        } catch (Exception e3) {
            throw new IllegalStateException(e3);
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        PivPrivateKey pivPrivateKey = this.privateKey;
        if (pivPrivateKey != null) {
            return pivPrivateKey.keyType.params.bitLength / 8;
        }
        throw new IllegalStateException("Cipher not initialized");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return new byte[0];
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        return engineGetBlockSize();
    }

    @Override // javax.crypto.CipherSpi
    @Nullable
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Engine init: mode={} padding={}", this.mode, this.padding);
        if (!(key instanceof PivPrivateKey)) {
            throw new InvalidKeyException("Unsupported key type");
        }
        if (!KeyType.Algorithm.RSA.name().equals(key.getAlgorithm())) {
            throw new InvalidKeyException("Cipher only supports RSA.");
        }
        this.privateKey = (PivPrivateKey) key;
        this.opmode = i;
        this.buffer.reset();
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) {
        this.mode = str;
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) {
        this.padding = str;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.buffer.write(bArr, i, i2);
        return new byte[0];
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i4) {
        this.buffer.write(bArr, i, i2);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, @Nullable AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null) {
            engineInit(i, key, secureRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("Cipher must be initialized with params = null");
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, @Nullable AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            engineInit(i, key, secureRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("Cipher must be initialized with params = null");
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i4) throws ShortBufferException {
        byte[] bArrEngineDoFinal = engineDoFinal(bArr, i, i2);
        try {
            System.arraycopy(bArrEngineDoFinal, 0, bArr2, i4, bArrEngineDoFinal.length);
            return bArrEngineDoFinal.length;
        } catch (IndexOutOfBoundsException unused) {
            throw new ShortBufferException();
        }
    }
}
