package com.nimbusds.jose.crypto;

import com.nimbusds.jose.CriticalHeaderParamsAware;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.impl.CriticalHeaderParamsDeferral;
import com.nimbusds.jose.crypto.impl.HMAC;
import com.nimbusds.jose.crypto.impl.MACProvider;
import com.nimbusds.jose.crypto.utils.ConstantTimeUtils;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class MACVerifier extends MACProvider implements JWSVerifier, CriticalHeaderParamsAware {
    private final CriticalHeaderParamsDeferral critPolicy;

    public MACVerifier(byte[] bArr) {
        this(bArr, (Set<String>) null);
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getDeferredCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getProcessedCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.JWSVerifier
    public boolean verify(JWSHeader jWSHeader, byte[] bArr, Base64URL base64URL) {
        if (this.critPolicy.headerPasses(jWSHeader)) {
            return ConstantTimeUtils.areEqual(HMAC.compute(MACProvider.getJCAAlgorithmName(jWSHeader.getAlgorithm()), getSecretKey(), bArr, getJCAContext().getProvider()), base64URL.decode());
        }
        return false;
    }

    public MACVerifier(String str) {
        this(str.getBytes(StandardCharset.UTF_8));
    }

    public MACVerifier(SecretKey secretKey) {
        this(secretKey, (Set<String>) null);
    }

    public MACVerifier(OctetSequenceKey octetSequenceKey) {
        this(octetSequenceKey.toByteArray());
    }

    public MACVerifier(byte[] bArr, Set<String> set) {
        super(bArr, MACProvider.SUPPORTED_ALGORITHMS);
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
    }

    public MACVerifier(SecretKey secretKey, Set<String> set) {
        super(secretKey, MACProvider.SUPPORTED_ALGORITHMS);
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
    }

    public MACVerifier(OctetSequenceKey octetSequenceKey, Set<String> set) {
        this(octetSequenceKey.toByteArray(), set);
    }
}
