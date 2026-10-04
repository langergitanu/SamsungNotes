package com.nimbusds.jose.crypto.factories;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.Ed25519Signer;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.impl.ECDSAProvider;
import com.nimbusds.jose.crypto.impl.EdDSAProvider;
import com.nimbusds.jose.crypto.impl.MACProvider;
import com.nimbusds.jose.crypto.impl.RSASSAProvider;
import com.nimbusds.jose.jca.JCAContext;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKException;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.produce.JWSSignerFactory;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultJWSSignerFactory implements JWSSignerFactory {
    public static final Set<JWSAlgorithm> SUPPORTED_ALGORITHMS;
    private final JCAContext jcaContext = new JCAContext();

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(MACProvider.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(RSASSAProvider.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(ECDSAProvider.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(EdDSAProvider.SUPPORTED_ALGORITHMS);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
    }

    @Override // com.nimbusds.jose.produce.JWSSignerFactory
    public JWSSigner createJWSSigner(JWK jwk) throws JOSEException {
        JWSSigner ed25519Signer;
        if (!jwk.isPrivate()) {
            throw JWKException.expectedPrivate();
        }
        if (jwk.getKeyUse() != null && !KeyUse.SIGNATURE.equals(jwk.getKeyUse())) {
            throw new JWKException("The JWK use must be sig (signature) or unspecified");
        }
        if (jwk instanceof OctetSequenceKey) {
            ed25519Signer = new MACSigner((OctetSequenceKey) jwk);
        } else if (jwk instanceof RSAKey) {
            ed25519Signer = new RSASSASigner((RSAKey) jwk);
        } else if (jwk instanceof ECKey) {
            ed25519Signer = new ECDSASigner((ECKey) jwk);
        } else {
            if (!(jwk instanceof OctetKeyPair)) {
                throw new JOSEException("Unsupported JWK type: " + jwk);
            }
            ed25519Signer = new Ed25519Signer((OctetKeyPair) jwk);
        }
        ed25519Signer.getJCAContext().setSecureRandom(this.jcaContext.getSecureRandom());
        ed25519Signer.getJCAContext().setProvider(this.jcaContext.getProvider());
        return ed25519Signer;
    }

    @Override // com.nimbusds.jose.jca.JCAAware
    public JCAContext getJCAContext() {
        return this.jcaContext;
    }

    @Override // com.nimbusds.jose.JWSProvider
    public Set<JWSAlgorithm> supportedJWSAlgorithms() {
        return SUPPORTED_ALGORITHMS;
    }

    @Override // com.nimbusds.jose.produce.JWSSignerFactory
    public JWSSigner createJWSSigner(JWK jwk, JWSAlgorithm jWSAlgorithm) throws JOSEException {
        JWSSigner ed25519Signer;
        if (jwk.isPrivate()) {
            if (jwk.getKeyUse() != null && !KeyUse.SIGNATURE.equals(jwk.getKeyUse())) {
                throw new JWKException("The JWK use must be sig (signature) or unspecified");
            }
            if (MACProvider.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
                if (jwk instanceof OctetSequenceKey) {
                    ed25519Signer = new MACSigner((OctetSequenceKey) jwk);
                } else {
                    throw JWKException.expectedClass(OctetSequenceKey.class);
                }
            } else if (RSASSAProvider.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
                if (jwk instanceof RSAKey) {
                    ed25519Signer = new RSASSASigner((RSAKey) jwk);
                } else {
                    throw JWKException.expectedClass(RSAKey.class);
                }
            } else if (ECDSAProvider.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
                if (jwk instanceof ECKey) {
                    ed25519Signer = new ECDSASigner((ECKey) jwk);
                } else {
                    throw JWKException.expectedClass(ECKey.class);
                }
            } else if (EdDSAProvider.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
                if (jwk instanceof OctetKeyPair) {
                    ed25519Signer = new Ed25519Signer((OctetKeyPair) jwk);
                } else {
                    throw JWKException.expectedClass(OctetKeyPair.class);
                }
            } else {
                throw new JOSEException("Unsupported JWS algorithm: " + jWSAlgorithm);
            }
            ed25519Signer.getJCAContext().setSecureRandom(this.jcaContext.getSecureRandom());
            ed25519Signer.getJCAContext().setProvider(this.jcaContext.getProvider());
            return ed25519Signer;
        }
        throw JWKException.expectedPrivate();
    }
}
