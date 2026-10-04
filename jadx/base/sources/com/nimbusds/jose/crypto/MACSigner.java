package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.HMAC;
import com.nimbusds.jose.crypto.impl.MACProvider;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.StandardCharset;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class MACSigner extends MACProvider implements JWSSigner {
    public MACSigner(byte[] bArr) {
        super(bArr, getCompatibleAlgorithms(ByteUtils.bitLength(bArr.length)));
    }

    public static Set<JWSAlgorithm> getCompatibleAlgorithms(int i) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i >= 256) {
            linkedHashSet.add(JWSAlgorithm.HS256);
        }
        if (i >= 384) {
            linkedHashSet.add(JWSAlgorithm.HS384);
        }
        if (i >= 512) {
            linkedHashSet.add(JWSAlgorithm.HS512);
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public static int getMinRequiredSecretLength(JWSAlgorithm jWSAlgorithm) throws JOSEException {
        if (JWSAlgorithm.HS256.equals(jWSAlgorithm)) {
            return 256;
        }
        if (JWSAlgorithm.HS384.equals(jWSAlgorithm)) {
            return 384;
        }
        if (JWSAlgorithm.HS512.equals(jWSAlgorithm)) {
            return 512;
        }
        throw new JOSEException(AlgorithmSupportMessage.unsupportedJWSAlgorithm(jWSAlgorithm, MACProvider.SUPPORTED_ALGORITHMS));
    }

    @Override // com.nimbusds.jose.JWSSigner
    public Base64URL sign(JWSHeader jWSHeader, byte[] bArr) throws JOSEException {
        if (getSecret() != null) {
            int minRequiredSecretLength = getMinRequiredSecretLength(jWSHeader.getAlgorithm());
            if (getSecret().length < ByteUtils.byteLength(minRequiredSecretLength)) {
                throw new KeyLengthException("The secret length for " + jWSHeader.getAlgorithm() + " must be at least " + minRequiredSecretLength + " bits");
            }
        }
        return Base64URL.encode(HMAC.compute(MACProvider.getJCAAlgorithmName(jWSHeader.getAlgorithm()), getSecretKey(), bArr, getJCAContext().getProvider()));
    }

    public MACSigner(String str) {
        this(str.getBytes(StandardCharset.UTF_8));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MACSigner(SecretKey secretKey) {
        Set<JWSAlgorithm> compatibleAlgorithms;
        if (secretKey.getEncoded() != null) {
            compatibleAlgorithms = getCompatibleAlgorithms(ByteUtils.bitLength(secretKey.getEncoded()));
        } else {
            compatibleAlgorithms = MACProvider.SUPPORTED_ALGORITHMS;
        }
        super(secretKey, compatibleAlgorithms);
    }

    public MACSigner(OctetSequenceKey octetSequenceKey) {
        this(octetSequenceKey.toByteArray());
    }
}
