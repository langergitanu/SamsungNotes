package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PinPolicy;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.Slot;
import com.yubico.yubikit.piv.TouchPolicy;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import javax.annotation.Nullable;
import javax.security.auth.Destroyable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class PivPrivateKey implements PrivateKey, Destroyable {
    private boolean destroyed = false;
    final KeyType keyType;

    @Nullable
    protected char[] pin;

    @Nullable
    private final PinPolicy pinPolicy;
    final Slot slot;

    @Nullable
    private final TouchPolicy touchPolicy;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EcKey extends PivPrivateKey implements ECKey {
        private final ECPublicKey publicKey;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ byte[] lambda$keyAgreement$0(Result result, ECPublicKey eCPublicKey) {
            PivSession pivSession = (PivSession) result.getValue();
            char[] cArr = this.pin;
            if (cArr != null) {
                pivSession.verifyPin(cArr);
            }
            return pivSession.calculateSecret(this.slot, eCPublicKey);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$keyAgreement$1(BlockingQueue blockingQueue, ECPublicKey eCPublicKey, Result result) {
            blockingQueue.add(Result.m13504of(new CallableC11925f(this, result, eCPublicKey, 0)));
        }

        @Override // java.security.interfaces.ECKey
        public ECParameterSpec getParams() {
            return this.publicKey.getParams();
        }

        public byte[] keyAgreement(Callback<Callback<Result<PivSession, Exception>>> callback, ECPublicKey eCPublicKey) {
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            callback.invoke(new C11924e(this, arrayBlockingQueue, eCPublicKey, 0));
            return (byte[]) ((Result) arrayBlockingQueue.take()).getValue();
        }

        private EcKey(Slot slot, KeyType keyType, @Nullable PinPolicy pinPolicy, @Nullable TouchPolicy touchPolicy, ECPublicKey eCPublicKey, @Nullable char[] cArr) {
            super(slot, keyType, pinPolicy, touchPolicy, cArr);
            this.publicKey = eCPublicKey;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RsaKey extends PivPrivateKey implements RSAKey {
        private final BigInteger modulus;

        @Override // java.security.interfaces.RSAKey
        public BigInteger getModulus() {
            return this.modulus;
        }

        private RsaKey(Slot slot, KeyType keyType, @Nullable PinPolicy pinPolicy, @Nullable TouchPolicy touchPolicy, BigInteger bigInteger, @Nullable char[] cArr) {
            super(slot, keyType, pinPolicy, touchPolicy, cArr);
            this.modulus = bigInteger;
        }
    }

    public PivPrivateKey(Slot slot, KeyType keyType, @Nullable PinPolicy pinPolicy, @Nullable TouchPolicy touchPolicy, @Nullable char[] cArr) {
        this.slot = slot;
        this.keyType = keyType;
        this.pinPolicy = pinPolicy;
        this.touchPolicy = touchPolicy;
        this.pin = cArr != null ? Arrays.copyOf(cArr, cArr.length) : null;
    }

    public static PivPrivateKey from(PublicKey publicKey, Slot slot, @Nullable PinPolicy pinPolicy, @Nullable TouchPolicy touchPolicy, @Nullable char[] cArr) {
        KeyType keyTypeFromKey = KeyType.fromKey(publicKey);
        return keyTypeFromKey.params.algorithm == KeyType.Algorithm.RSA ? new RsaKey(slot, keyTypeFromKey, pinPolicy, touchPolicy, ((RSAPublicKey) publicKey).getModulus(), cArr) : new EcKey(slot, keyTypeFromKey, pinPolicy, touchPolicy, (ECPublicKey) publicKey, cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ byte[] lambda$rawSignOrDecrypt$0(Result result, byte[] bArr) {
        PivSession pivSession = (PivSession) result.getValue();
        char[] cArr = this.pin;
        if (cArr != null) {
            pivSession.verifyPin(cArr);
        }
        return pivSession.rawSignOrDecrypt(this.slot, this.keyType, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$rawSignOrDecrypt$1(BlockingQueue blockingQueue, byte[] bArr, Result result) {
        blockingQueue.add(Result.m13504of(new CallableC11925f(this, result, (Serializable) bArr, 3)));
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        char[] cArr = this.pin;
        if (cArr != null) {
            Arrays.fill(cArr, (char) 0);
        }
        this.destroyed = true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.keyType.params.algorithm.name();
    }

    @Override // java.security.Key
    @Nullable
    public byte[] getEncoded() {
        return null;
    }

    @Override // java.security.Key
    @Nullable
    public String getFormat() {
        return null;
    }

    @Nullable
    public PinPolicy getPinPolicy() {
        return this.pinPolicy;
    }

    public Slot getSlot() {
        return this.slot;
    }

    @Nullable
    public TouchPolicy getTouchPolicy() {
        return this.touchPolicy;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.destroyed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public byte[] rawSignOrDecrypt(Callback<Callback<Result<PivSession, Exception>>> callback, byte[] bArr) {
        if (this.destroyed) {
            throw new IllegalStateException("PivPrivateKey has been destroyed");
        }
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        callback.invoke(new C11924e(this, arrayBlockingQueue, (Serializable) bArr, 3));
        return (byte[]) ((Result) arrayBlockingQueue.take()).getValue();
    }

    public void setPin(@Nullable char[] cArr) {
        if (this.destroyed) {
            throw new IllegalStateException("PivPrivateKey has been destroyed");
        }
        char[] cArr2 = this.pin;
        if (cArr2 != null) {
            Arrays.fill(cArr2, (char) 0);
        }
        this.pin = cArr != null ? Arrays.copyOf(cArr, cArr.length) : null;
    }
}
