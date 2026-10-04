package com.nimbusds.jose.crypto;

import com.google.crypto.tink.subtle.X25519;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.AAD;
import com.nimbusds.jose.crypto.impl.ECDH;
import com.nimbusds.jose.crypto.impl.ECDHCryptoProvider;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.util.Base64URL;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class X25519Encrypter extends ECDHCryptoProvider implements JWEEncrypter {
    private final OctetKeyPair publicKey;

    public X25519Encrypter(OctetKeyPair octetKeyPair) {
        this(octetKeyPair, null);
    }

    @Deprecated
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) {
        return encrypt(jWEHeader, bArr, AAD.compute(jWEHeader));
    }

    public OctetKeyPair getPublicKey() {
        return this.publicKey;
    }

    @Override // com.nimbusds.jose.crypto.impl.ECDHCryptoProvider
    public Set<Curve> supportedEllipticCurves() {
        return Collections.singleton(Curve.X25519);
    }

    public X25519Encrypter(OctetKeyPair octetKeyPair, SecretKey secretKey) throws JOSEException {
        super(octetKeyPair.getCurve(), secretKey);
        if (!Curve.X25519.equals(octetKeyPair.getCurve())) {
            throw new JOSEException("X25519Encrypter only supports OctetKeyPairs with crv=X25519");
        }
        if (octetKeyPair.isPrivate()) {
            throw new JOSEException("X25519Encrypter requires a public key, use OctetKeyPair.toPublicJWK()");
        }
        this.publicKey = octetKeyPair;
    }

    @Override // com.nimbusds.jose.JWEEncrypter
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr, byte[] bArr2) throws JOSEException {
        byte[] bArrGeneratePrivateKey = X25519.generatePrivateKey();
        try {
            OctetKeyPair octetKeyPairBuild = new OctetKeyPair.Builder(getCurve(), Base64URL.encode(X25519.publicFromPrivate(bArrGeneratePrivateKey))).m4637d(Base64URL.encode(bArrGeneratePrivateKey)).build();
            JWEHeader jWEHeaderBuild = new JWEHeader.Builder(jWEHeader).ephemeralPublicKey(octetKeyPairBuild.toPublicJWK()).build();
            SecretKey secretKeyDeriveSharedSecret = ECDH.deriveSharedSecret(this.publicKey, octetKeyPairBuild);
            if (Arrays.equals(AAD.compute(jWEHeader), bArr2)) {
                bArr2 = AAD.compute(jWEHeaderBuild);
            }
            return encryptWithZ(jWEHeaderBuild, secretKeyDeriveSharedSecret, bArr, bArr2);
        } catch (InvalidKeyException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }
}
