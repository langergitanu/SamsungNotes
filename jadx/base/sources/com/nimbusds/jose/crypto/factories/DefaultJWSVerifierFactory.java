package com.nimbusds.jose.crypto.factories;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.KeyTypeException;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.crypto.impl.ECDSAProvider;
import com.nimbusds.jose.crypto.impl.MACProvider;
import com.nimbusds.jose.crypto.impl.RSASSAProvider;
import com.nimbusds.jose.jca.JCAContext;
import com.nimbusds.jose.proc.JWSVerifierFactory;
import java.security.Key;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class DefaultJWSVerifierFactory implements JWSVerifierFactory {
    public static final Set<JWSAlgorithm> SUPPORTED_ALGORITHMS;
    private final JCAContext jcaContext = new JCAContext();

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(MACProvider.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(RSASSAProvider.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(ECDSAProvider.SUPPORTED_ALGORITHMS);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
    }

    @Override // com.nimbusds.jose.proc.JWSVerifierFactory
    public JWSVerifier createJWSVerifier(JWSHeader jWSHeader, Key key) throws JOSEException {
        JWSVerifier eCDSAVerifier;
        if (MACProvider.SUPPORTED_ALGORITHMS.contains(jWSHeader.getAlgorithm())) {
            if (!(key instanceof SecretKey)) {
                throw new KeyTypeException(SecretKey.class);
            }
            eCDSAVerifier = new MACVerifier((SecretKey) key);
        } else if (RSASSAProvider.SUPPORTED_ALGORITHMS.contains(jWSHeader.getAlgorithm())) {
            if (!(key instanceof RSAPublicKey)) {
                throw new KeyTypeException(RSAPublicKey.class);
            }
            eCDSAVerifier = new RSASSAVerifier((RSAPublicKey) key);
        } else {
            if (!ECDSAProvider.SUPPORTED_ALGORITHMS.contains(jWSHeader.getAlgorithm())) {
                throw new JOSEException("Unsupported JWS algorithm: " + jWSHeader.getAlgorithm());
            }
            if (!(key instanceof ECPublicKey)) {
                throw new KeyTypeException(ECPublicKey.class);
            }
            eCDSAVerifier = new ECDSAVerifier((ECPublicKey) key);
        }
        eCDSAVerifier.getJCAContext().setProvider(this.jcaContext.getProvider());
        return eCDSAVerifier;
    }

    @Override // com.nimbusds.jose.jca.JCAAware
    public JCAContext getJCAContext() {
        return this.jcaContext;
    }

    @Override // com.nimbusds.jose.JWSProvider
    public Set<JWSAlgorithm> supportedJWSAlgorithms() {
        return SUPPORTED_ALGORITHMS;
    }
}
