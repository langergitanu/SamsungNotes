package com.nimbusds.jose.crypto;

import com.nimbusds.jose.CriticalHeaderParamsAware;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.CriticalHeaderParamsDeferral;
import com.nimbusds.jose.crypto.impl.ECDSA;
import com.nimbusds.jose.crypto.impl.ECDSAProvider;
import com.nimbusds.jose.crypto.utils.ECChecks;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.util.Base64URL;
import java.security.InvalidKeyException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class ECDSAVerifier extends ECDSAProvider implements JWSVerifier, CriticalHeaderParamsAware {
    private final CriticalHeaderParamsDeferral critPolicy;
    private final ECPublicKey publicKey;

    public ECDSAVerifier(ECPublicKey eCPublicKey) {
        this(eCPublicKey, null);
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getDeferredCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getProcessedCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    public ECPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // com.nimbusds.jose.JWSVerifier
    public boolean verify(JWSHeader jWSHeader, byte[] bArr, Base64URL base64URL) throws Exception {
        JWSAlgorithm algorithm = jWSHeader.getAlgorithm();
        if (!supportedJWSAlgorithms().contains(algorithm)) {
            throw new JOSEException(AlgorithmSupportMessage.unsupportedJWSAlgorithm(algorithm, supportedJWSAlgorithms()));
        }
        if (!this.critPolicy.headerPasses(jWSHeader)) {
            return false;
        }
        byte[] bArrDecode = base64URL.decode();
        try {
            ECDSA.ensureLegalSignature(bArrDecode, algorithm);
            byte[] bArrTranscodeSignatureToDER = ECDSA.transcodeSignatureToDER(bArrDecode);
            Signature signerAndVerifier = ECDSA.getSignerAndVerifier(algorithm, getJCAContext().getProvider());
            try {
                signerAndVerifier.initVerify(this.publicKey);
                signerAndVerifier.update(bArr);
                return signerAndVerifier.verify(bArrTranscodeSignatureToDER);
            } catch (InvalidKeyException e) {
                throw new JOSEException("Invalid EC public key: " + e.getMessage(), e);
            } catch (SignatureException unused) {
                return false;
            }
        } catch (JOSEException unused2) {
            return false;
        }
    }

    public ECDSAVerifier(ECKey eCKey) {
        this(eCKey.toECPublicKey());
    }

    public ECDSAVerifier(ECPublicKey eCPublicKey, Set<String> set) throws JOSEException {
        super(ECDSA.resolveAlgorithm(eCPublicKey));
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        this.publicKey = eCPublicKey;
        if (ECChecks.isPointOnCurve(eCPublicKey, Curve.forJWSAlgorithm(supportedECDSAAlgorithm()).iterator().next().toECParameterSpec())) {
            criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
            return;
        }
        throw new JOSEException("Curve / public key parameters mismatch");
    }
}
