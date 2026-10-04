package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PivSession;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class PivKeyPairGeneratorSpi extends KeyPairGeneratorSpi {
    private final KeyType.Algorithm algorithm;
    private final Callback<Callback<Result<PivSession, Exception>>> provider;

    @Nullable
    PivAlgorithmParameterSpec spec;

    /* JADX INFO: renamed from: com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi$Ec */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class C11913Ec extends PivKeyPairGeneratorSpi {
        public C11913Ec(Callback<Callback<Result<PivSession, Exception>>> callback) {
            super(callback, KeyType.Algorithm.EC);
        }

        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ KeyPair generateKeyPair() {
            return super.generateKeyPair();
        }

        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ void initialize(int i, SecureRandom secureRandom) {
            super.initialize(i, secureRandom);
        }

        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            super.initialize(algorithmParameterSpec, secureRandom);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Rsa extends PivKeyPairGeneratorSpi {
        public Rsa(Callback<Callback<Result<PivSession, Exception>>> callback) {
            super(callback, KeyType.Algorithm.RSA);
        }

        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ KeyPair generateKeyPair() {
            return super.generateKeyPair();
        }

        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ void initialize(int i, SecureRandom secureRandom) {
            super.initialize(i, secureRandom);
        }

        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            super.initialize(algorithmParameterSpec, secureRandom);
        }
    }

    public PivKeyPairGeneratorSpi(Callback<Callback<Result<PivSession, Exception>>> callback, KeyType.Algorithm algorithm) {
        this.provider = callback;
        this.algorithm = algorithm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KeyPair lambda$generateKeyPair$0(Result result) {
        PivSession pivSession = (PivSession) result.getValue();
        PivAlgorithmParameterSpec pivAlgorithmParameterSpec = this.spec;
        PublicKey publicKeyGenerateKey = pivSession.generateKey(pivAlgorithmParameterSpec.slot, pivAlgorithmParameterSpec.keyType, pivAlgorithmParameterSpec.pinPolicy, pivAlgorithmParameterSpec.touchPolicy);
        PivAlgorithmParameterSpec pivAlgorithmParameterSpec2 = this.spec;
        return new KeyPair(publicKeyGenerateKey, PivPrivateKey.from(publicKeyGenerateKey, pivAlgorithmParameterSpec2.slot, pivAlgorithmParameterSpec2.pinPolicy, pivAlgorithmParameterSpec2.touchPolicy, pivAlgorithmParameterSpec2.pin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateKeyPair$1(BlockingQueue blockingQueue, Result result) {
        blockingQueue.add(Result.m13504of(new CallableC11920a(this, result)));
    }

    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.spec == null) {
            throw new IllegalStateException("KeyPairGenerator not initialized!");
        }
        try {
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            this.provider.invoke(new C11922c(this, arrayBlockingQueue));
            return (KeyPair) ((Result) arrayBlockingQueue.take()).getValue();
        } catch (Exception e) {
            throw new IllegalStateException("An error occurred when generating the key pair", e);
        }
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof PivAlgorithmParameterSpec)) {
            throw new InvalidAlgorithmParameterException("Must be instance of PivAlgorithmParameterSpec");
        }
        PivAlgorithmParameterSpec pivAlgorithmParameterSpec = (PivAlgorithmParameterSpec) algorithmParameterSpec;
        this.spec = pivAlgorithmParameterSpec;
        if (pivAlgorithmParameterSpec.keyType.params.algorithm != this.algorithm) {
            throw new InvalidAlgorithmParameterException("Invalid key algorithm for this KeyPairGenerator");
        }
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("Initialize with PivAlgorithmParameterSpec!");
    }
}
