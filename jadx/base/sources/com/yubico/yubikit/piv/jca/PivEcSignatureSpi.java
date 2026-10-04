package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.jca.PivPrivateKey;
import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class PivEcSignatureSpi extends SignatureSpi {

    @Nullable
    private PivPrivateKey.EcKey privateKey;
    private final Callback<Callback<Result<PivSession, Exception>>> provider;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Hashed extends PivEcSignatureSpi {
        private final MessageDigest digest;

        public Hashed(Callback<Callback<Result<PivSession, Exception>>> callback, String str) {
            super(callback);
            this.digest = MessageDigest.getInstance(str);
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        public byte[] digest() {
            return this.digest.digest();
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi, java.security.SignatureSpi
        public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
            super.engineInitSign(privateKey);
            this.digest.reset();
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        public void update(byte b) {
            this.digest.update(b);
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        public void update(byte[] bArr, int i, int i2) {
            this.digest.update(bArr, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Prehashed extends PivEcSignatureSpi {
        private final ByteArrayOutputStream buffer;

        public Prehashed(Callback<Callback<Result<PivSession, Exception>>> callback) {
            super(callback);
            this.buffer = new ByteArrayOutputStream();
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        public byte[] digest() {
            return this.buffer.toByteArray();
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi, java.security.SignatureSpi
        public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
            super.engineInitSign(privateKey);
            this.buffer.reset();
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        public void update(byte b) {
            this.buffer.write(b);
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        public void update(byte[] bArr, int i, int i2) {
            this.buffer.write(bArr, i, i2);
        }
    }

    public PivEcSignatureSpi(Callback<Callback<Result<PivSession, Exception>>> callback) {
        this.provider = callback;
    }

    public abstract byte[] digest();

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new InvalidParameterException("ECDSA doesn't take parameters");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof PivPrivateKey.EcKey)) {
            throw new InvalidKeyException("Unsupported key type");
        }
        this.privateKey = (PivPrivateKey.EcKey) privateKey;
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        throw new InvalidKeyException("Can only be used for signing.");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new InvalidParameterException("ECDSA doesn't take parameters");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        PivPrivateKey.EcKey ecKey = this.privateKey;
        if (ecKey == null) {
            throw new SignatureException("Not initialized");
        }
        try {
            return ecKey.rawSignOrDecrypt(this.provider, digest());
        } catch (Exception e) {
            throw new SignatureException(e);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) throws SignatureException {
        if (this.privateKey == null) {
            throw new SignatureException("Not initialized");
        }
        update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        throw new SignatureException("Not initialized");
    }

    public abstract void update(byte b);

    public abstract void update(byte[] bArr, int i, int i2);

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        if (this.privateKey != null) {
            update(bArr, i, i2);
            return;
        }
        throw new SignatureException("Not initialized");
    }
}
