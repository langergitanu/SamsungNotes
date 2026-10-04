package com.nimbusds.jose.jwk.gen;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ECKeyGenerator extends JWKGenerator<ECKey> {
    private final Curve crv;

    public ECKeyGenerator(Curve curve) {
        if (curve == null) {
            throw new IllegalArgumentException("The curve must not be null");
        }
        this.crv = curve;
    }

    @Override // com.nimbusds.jose.jwk.gen.JWKGenerator
    public ECKey generate() throws JOSEException {
        KeyPairGenerator keyPairGenerator;
        ECParameterSpec eCParameterSpec = this.crv.toECParameterSpec();
        try {
            KeyStore keyStore = this.keyStore;
            if (keyStore != null) {
                keyPairGenerator = KeyPairGenerator.getInstance("EC", keyStore.getProvider());
            } else {
                Provider provider = this.provider;
                keyPairGenerator = provider != null ? KeyPairGenerator.getInstance("EC", provider) : KeyPairGenerator.getInstance("EC");
            }
            SecureRandom secureRandom = this.secureRandom;
            if (secureRandom != null) {
                keyPairGenerator.initialize(eCParameterSpec, secureRandom);
            } else {
                keyPairGenerator.initialize(eCParameterSpec);
            }
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            ECKey.Builder builderKeyStore = new ECKey.Builder(this.crv, (ECPublicKey) keyPairGenerateKeyPair.getPublic()).privateKey(keyPairGenerateKeyPair.getPrivate()).keyUse(this.use).keyOperations(this.ops).algorithm(this.alg).expirationTime(this.exp).notBeforeTime(this.nbf).issueTime(this.iat).keyStore(this.keyStore);
            if (this.x5tKid) {
                builderKeyStore.keyIDFromThumbprint();
            } else {
                builderKeyStore.keyID(this.kid);
            }
            return builderKeyStore.build();
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            throw new JOSEException(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new JOSEException(e.getMessage(), e);
        }
    }
}
