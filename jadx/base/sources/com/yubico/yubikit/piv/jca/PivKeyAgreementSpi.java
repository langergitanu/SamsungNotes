package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.jca.PivPrivateKey;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import javax.annotation.Nullable;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PivKeyAgreementSpi extends KeyAgreementSpi {

    @Nullable
    private PivPrivateKey.EcKey privateKey;
    private final Callback<Callback<Result<PivSession, Exception>>> provider;

    @Nullable
    private ECPublicKey publicKey;

    public PivKeyAgreementSpi(Callback<Callback<Result<PivSession, Exception>>> callback) {
        this.provider = callback;
    }

    @Override // javax.crypto.KeyAgreementSpi
    @Nullable
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException {
        if (this.privateKey == null) {
            throw new IllegalStateException("KeyAgreement not initialized");
        }
        if (!z) {
            throw new IllegalStateException("Multiple phases not supported");
        }
        if (!(key instanceof PublicKey) || KeyType.fromKey(key) != this.privateKey.keyType) {
            throw new InvalidKeyException("Wrong key type");
        }
        this.publicKey = (ECPublicKey) key;
        return null;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() {
        ECPublicKey eCPublicKey;
        PivPrivateKey.EcKey ecKey = this.privateKey;
        if (ecKey == null || (eCPublicKey = this.publicKey) == null) {
            throw new IllegalStateException("Not initialized with both private and public keys");
        }
        try {
            try {
                return ecKey.keyAgreement(this.provider, eCPublicKey);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } finally {
            this.publicKey = null;
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (!(key instanceof PivPrivateKey.EcKey)) {
            throw new InvalidKeyException("Key must be instance of PivPrivateKey");
        }
        this.privateKey = (PivPrivateKey.EcKey) key;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException {
        engineInit(key, secureRandom);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i) throws ShortBufferException {
        byte[] bArrEngineGenerateSecret = engineGenerateSecret();
        try {
            System.arraycopy(bArrEngineGenerateSecret, 0, bArr, i, bArrEngineGenerateSecret.length);
            return bArrEngineGenerateSecret.length;
        } catch (IndexOutOfBoundsException unused) {
            throw new ShortBufferException();
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) {
        throw new IllegalStateException("Not supported");
    }
}
