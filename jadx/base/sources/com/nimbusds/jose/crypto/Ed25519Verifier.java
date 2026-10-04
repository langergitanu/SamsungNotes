package com.nimbusds.jose.crypto;

import com.google.crypto.tink.subtle.Ed25519Verify;
import com.nimbusds.jose.CriticalHeaderParamsAware;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.impl.CriticalHeaderParamsDeferral;
import com.nimbusds.jose.crypto.impl.EdDSAProvider;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.util.Base64URL;
import java.security.GeneralSecurityException;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class Ed25519Verifier extends EdDSAProvider implements JWSVerifier, CriticalHeaderParamsAware {
    private final CriticalHeaderParamsDeferral critPolicy;
    private final OctetKeyPair publicKey;
    private final Ed25519Verify tinkVerifier;

    public Ed25519Verifier(OctetKeyPair octetKeyPair) {
        this(octetKeyPair, null);
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getDeferredCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getProcessedCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    public OctetKeyPair getPublicKey() {
        return this.publicKey;
    }

    @Override // com.nimbusds.jose.JWSVerifier
    public boolean verify(JWSHeader jWSHeader, byte[] bArr, Base64URL base64URL) throws JOSEException {
        if (!JWSAlgorithm.EdDSA.equals(jWSHeader.getAlgorithm())) {
            throw new JOSEException("Ed25519Verifier requires alg=EdDSA in JWSHeader");
        }
        if (!this.critPolicy.headerPasses(jWSHeader)) {
            return false;
        }
        try {
            this.tinkVerifier.verify(base64URL.decode(), bArr);
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public Ed25519Verifier(OctetKeyPair octetKeyPair, Set<String> set) throws JOSEException {
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        if (!Curve.Ed25519.equals(octetKeyPair.getCurve())) {
            throw new JOSEException("Ed25519Verifier only supports OctetKeyPairs with crv=Ed25519");
        }
        if (octetKeyPair.isPrivate()) {
            throw new JOSEException("Ed25519Verifier requires a public key, use OctetKeyPair.toPublicJWK()");
        }
        this.publicKey = octetKeyPair;
        this.tinkVerifier = new Ed25519Verify(octetKeyPair.getDecodedX());
        criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
    }
}
