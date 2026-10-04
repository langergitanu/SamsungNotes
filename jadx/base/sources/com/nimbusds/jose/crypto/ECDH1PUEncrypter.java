package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.AAD;
import com.nimbusds.jose.crypto.impl.ECDH1PU;
import com.nimbusds.jose.crypto.impl.ECDH1PUCryptoProvider;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class ECDH1PUEncrypter extends ECDH1PUCryptoProvider implements JWEEncrypter {
    public static final Set<Curve> SUPPORTED_ELLIPTIC_CURVES;
    private final ECPrivateKey privateKey;
    private final ECPublicKey publicKey;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(Curve.P_256);
        linkedHashSet.add(Curve.P_384);
        linkedHashSet.add(Curve.P_521);
        SUPPORTED_ELLIPTIC_CURVES = Collections.unmodifiableSet(linkedHashSet);
    }

    public ECDH1PUEncrypter(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) {
        this(eCPrivateKey, eCPublicKey, null);
    }

    private KeyPair generateEphemeralKeyPair(ECParameterSpec eCParameterSpec) throws JOSEException {
        Provider keyEncryptionProvider = getJCAContext().getKeyEncryptionProvider();
        try {
            KeyPairGenerator keyPairGenerator = keyEncryptionProvider != null ? KeyPairGenerator.getInstance("EC", keyEncryptionProvider) : KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(eCParameterSpec);
            return keyPairGenerator.generateKeyPair();
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            throw new JOSEException("Couldn't generate ephemeral EC key pair: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new JOSEException("Couldn't generate ephemeral EC key pair: " + e.getMessage(), e);
        }
    }

    @Deprecated
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) {
        return encrypt(jWEHeader, bArr, AAD.compute(jWEHeader));
    }

    public ECPrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public ECPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // com.nimbusds.jose.crypto.impl.ECDH1PUCryptoProvider
    public Set<Curve> supportedEllipticCurves() {
        return SUPPORTED_ELLIPTIC_CURVES;
    }

    public ECDH1PUEncrypter(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey, SecretKey secretKey) {
        super(Curve.forECParameterSpec(eCPublicKey.getParams()), secretKey);
        this.privateKey = eCPrivateKey;
        this.publicKey = eCPublicKey;
    }

    @Override // com.nimbusds.jose.JWEEncrypter
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr, byte[] bArr2) throws JOSEException {
        KeyPair keyPairGenerateEphemeralKeyPair = generateEphemeralKeyPair(this.publicKey.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateEphemeralKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateEphemeralKeyPair.getPrivate();
        JWEHeader jWEHeaderBuild = new JWEHeader.Builder(jWEHeader).ephemeralPublicKey(new ECKey.Builder(getCurve(), eCPublicKey).build()).build();
        SecretKey secretKeyDeriveSenderZ = ECDH1PU.deriveSenderZ(this.privateKey, this.publicKey, eCPrivateKey, getJCAContext().getKeyEncryptionProvider());
        if (Arrays.equals(AAD.compute(jWEHeader), bArr2)) {
            bArr2 = AAD.compute(jWEHeaderBuild);
        }
        return encryptWithZ(jWEHeaderBuild, secretKeyDeriveSenderZ, bArr, bArr2);
    }
}
