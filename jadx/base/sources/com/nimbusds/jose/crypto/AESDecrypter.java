package com.nimbusds.jose.crypto;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.CriticalHeaderParamsAware;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.AAD;
import com.nimbusds.jose.crypto.impl.AESCryptoProvider;
import com.nimbusds.jose.crypto.impl.AESGCMKW;
import com.nimbusds.jose.crypto.impl.AESKW;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.AuthenticatedCipherText;
import com.nimbusds.jose.crypto.impl.ContentCryptoProvider;
import com.nimbusds.jose.crypto.impl.CriticalHeaderParamsDeferral;
import com.nimbusds.jose.crypto.impl.JWEHeaderValidation;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.util.Base64URL;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class AESDecrypter extends AESCryptoProvider implements JWEDecrypter, CriticalHeaderParamsAware {
    private final CriticalHeaderParamsDeferral critPolicy;

    public AESDecrypter(SecretKey secretKey) {
        this(secretKey, null);
    }

    @Deprecated
    public byte[] decrypt(JWEHeader jWEHeader, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) {
        return decrypt(jWEHeader, base64URL, base64URL2, base64URL3, base64URL4, AAD.compute(jWEHeader));
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getDeferredCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getProcessedCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    public AESDecrypter(byte[] bArr) {
        this(new SecretKeySpec(bArr, AES256KeyLoader.AES_ALGORITHM));
    }

    @Override // com.nimbusds.jose.JWEDecrypter
    public byte[] decrypt(JWEHeader jWEHeader, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, byte[] bArr) throws JOSEException {
        SecretKey secretKeyUnwrapCEK;
        if (base64URL == null) {
            throw new JOSEException("Missing JWE encrypted key");
        }
        if (base64URL2 == null) {
            throw new JOSEException("Missing JWE initialization vector (IV)");
        }
        if (base64URL4 == null) {
            throw new JOSEException("Missing JWE authentication tag");
        }
        JWEAlgorithm algorithmAndEnsureNotNull = JWEHeaderValidation.getAlgorithmAndEnsureNotNull(jWEHeader);
        this.critPolicy.ensureHeaderPasses(jWEHeader);
        int iCekBitLength = jWEHeader.getEncryptionMethod().cekBitLength();
        if (algorithmAndEnsureNotNull.equals(JWEAlgorithm.A128KW) || algorithmAndEnsureNotNull.equals(JWEAlgorithm.A192KW) || algorithmAndEnsureNotNull.equals(JWEAlgorithm.A256KW)) {
            secretKeyUnwrapCEK = AESKW.unwrapCEK(getKey(), base64URL.decode(), getJCAContext().getKeyEncryptionProvider());
        } else {
            if (!algorithmAndEnsureNotNull.equals(JWEAlgorithm.A128GCMKW) && !algorithmAndEnsureNotNull.equals(JWEAlgorithm.A192GCMKW) && !algorithmAndEnsureNotNull.equals(JWEAlgorithm.A256GCMKW)) {
                throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(algorithmAndEnsureNotNull, AESCryptoProvider.SUPPORTED_ALGORITHMS));
            }
            if (jWEHeader.getIV() == null) {
                throw new JOSEException("Missing JWE \"iv\" header parameter");
            }
            byte[] bArrDecode = jWEHeader.getIV().decode();
            if (jWEHeader.getAuthTag() == null) {
                throw new JOSEException("Missing JWE \"tag\" header parameter");
            }
            secretKeyUnwrapCEK = AESGCMKW.decryptCEK(getKey(), bArrDecode, new AuthenticatedCipherText(base64URL.decode(), jWEHeader.getAuthTag().decode()), iCekBitLength, getJCAContext().getKeyEncryptionProvider());
        }
        return ContentCryptoProvider.decrypt(jWEHeader, bArr, base64URL, base64URL2, base64URL3, base64URL4, secretKeyUnwrapCEK, getJCAContext());
    }

    public AESDecrypter(OctetSequenceKey octetSequenceKey) {
        this(octetSequenceKey.toSecretKey(AES256KeyLoader.AES_ALGORITHM));
    }

    public AESDecrypter(SecretKey secretKey, Set<String> set) {
        super(secretKey, null);
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
    }
}
