package com.nimbusds.jose.jwk.gen;

import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RSAKeyGenerator extends JWKGenerator<RSAKey> {
    public static final int MIN_KEY_SIZE_BITS = 2048;
    private final int size;

    public RSAKeyGenerator(int i) {
        this(i, false);
    }

    public RSAKeyGenerator(int i, boolean z) {
        if (!z && i < 2048) {
            throw new IllegalArgumentException("The key size must be at least 2048 bits");
        }
        this.size = i;
    }

    @Override // com.nimbusds.jose.jwk.gen.JWKGenerator
    public RSAKey generate() throws JOSEException {
        KeyPairGenerator keyPairGenerator;
        try {
            KeyStore keyStore = this.keyStore;
            if (keyStore != null) {
                keyPairGenerator = KeyPairGenerator.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, keyStore.getProvider());
            } else {
                Provider provider = this.provider;
                keyPairGenerator = provider != null ? KeyPairGenerator.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, provider) : KeyPairGenerator.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA);
            }
            SecureRandom secureRandom = this.secureRandom;
            if (secureRandom != null) {
                keyPairGenerator.initialize(this.size, secureRandom);
            } else {
                keyPairGenerator.initialize(this.size);
            }
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            RSAKey.Builder builderKeyStore = new RSAKey.Builder((RSAPublicKey) keyPairGenerateKeyPair.getPublic()).privateKey(keyPairGenerateKeyPair.getPrivate()).keyUse(this.use).keyOperations(this.ops).algorithm(this.alg).expirationTime(this.exp).notBeforeTime(this.nbf).issueTime(this.iat).keyStore(this.keyStore);
            if (this.x5tKid) {
                builderKeyStore.keyIDFromThumbprint();
            } else {
                builderKeyStore.keyID(this.kid);
            }
            return builderKeyStore.build();
        } catch (NoSuchAlgorithmException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }
}
