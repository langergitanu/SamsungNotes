package com.nimbusds.jose.crypto;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.AAD;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.ContentCryptoProvider;
import com.nimbusds.jose.crypto.impl.DirectCryptoProvider;
import com.nimbusds.jose.crypto.impl.JWEHeaderValidation;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class DirectEncrypter extends DirectCryptoProvider implements JWEEncrypter {
    public DirectEncrypter(SecretKey secretKey) {
        super(secretKey);
    }

    @Deprecated
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) {
        return encrypt(jWEHeader, bArr, AAD.compute(jWEHeader));
    }

    public DirectEncrypter(byte[] bArr) {
        this(new SecretKeySpec(bArr, AES256KeyLoader.AES_ALGORITHM));
    }

    @Override // com.nimbusds.jose.JWEEncrypter
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr, byte[] bArr2) throws JOSEException {
        JWEAlgorithm algorithmAndEnsureNotNull = JWEHeaderValidation.getAlgorithmAndEnsureNotNull(jWEHeader);
        if (algorithmAndEnsureNotNull.equals(JWEAlgorithm.DIR)) {
            return ContentCryptoProvider.encrypt(jWEHeader, bArr, bArr2, getKey(), null, getJCAContext());
        }
        throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(algorithmAndEnsureNotNull, DirectCryptoProvider.SUPPORTED_ALGORITHMS));
    }

    public DirectEncrypter(OctetSequenceKey octetSequenceKey) {
        this(octetSequenceKey.toSecretKey(AES256KeyLoader.AES_ALGORITHM));
    }
}
