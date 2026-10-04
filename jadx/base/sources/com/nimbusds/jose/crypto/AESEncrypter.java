package com.nimbusds.jose.crypto;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.impl.AAD;
import com.nimbusds.jose.crypto.impl.AESCryptoProvider;
import com.nimbusds.jose.crypto.impl.AESGCM;
import com.nimbusds.jose.crypto.impl.AESGCMKW;
import com.nimbusds.jose.crypto.impl.AESKW;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.AuthenticatedCipherText;
import com.nimbusds.jose.crypto.impl.ContentCryptoProvider;
import com.nimbusds.jose.crypto.impl.JWEHeaderValidation;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.Container;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class AESEncrypter extends AESCryptoProvider implements JWEEncrypter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum AlgFamily {
        AESKW,
        AESGCMKW
    }

    public AESEncrypter(SecretKey secretKey, SecretKey secretKey2) {
        super(secretKey, secretKey2);
    }

    @Deprecated
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) {
        return encrypt(jWEHeader, bArr, AAD.compute(jWEHeader));
    }

    public AESEncrypter(SecretKey secretKey) {
        this(secretKey, null);
    }

    @Override // com.nimbusds.jose.JWEEncrypter
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr, byte[] bArr2) throws JOSEException {
        AlgFamily algFamily;
        JWEHeader jWEHeaderBuild;
        Base64URL base64URLEncode;
        JWEAlgorithm algorithmAndEnsureNotNull = JWEHeaderValidation.getAlgorithmAndEnsureNotNull(jWEHeader);
        EncryptionMethod encryptionMethod = jWEHeader.getEncryptionMethod();
        if (algorithmAndEnsureNotNull.equals(JWEAlgorithm.A128KW)) {
            if (ByteUtils.safeBitLength(getKey().getEncoded()) != 128) {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 128 bits for A128KW encryption");
            }
            algFamily = AlgFamily.AESKW;
        } else if (algorithmAndEnsureNotNull.equals(JWEAlgorithm.A192KW)) {
            if (ByteUtils.safeBitLength(getKey().getEncoded()) != 192) {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 192 bits for A192KW encryption");
            }
            algFamily = AlgFamily.AESKW;
        } else if (algorithmAndEnsureNotNull.equals(JWEAlgorithm.A256KW)) {
            if (ByteUtils.safeBitLength(getKey().getEncoded()) != 256) {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 256 bits for A256KW encryption");
            }
            algFamily = AlgFamily.AESKW;
        } else if (algorithmAndEnsureNotNull.equals(JWEAlgorithm.A128GCMKW)) {
            if (ByteUtils.safeBitLength(getKey().getEncoded()) != 128) {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 128 bits for A128GCMKW encryption");
            }
            algFamily = AlgFamily.AESGCMKW;
        } else if (algorithmAndEnsureNotNull.equals(JWEAlgorithm.A192GCMKW)) {
            if (ByteUtils.safeBitLength(getKey().getEncoded()) != 192) {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 192 bits for A192GCMKW encryption");
            }
            algFamily = AlgFamily.AESGCMKW;
        } else {
            if (!algorithmAndEnsureNotNull.equals(JWEAlgorithm.A256GCMKW)) {
                throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(algorithmAndEnsureNotNull, AESCryptoProvider.SUPPORTED_ALGORITHMS));
            }
            if (ByteUtils.safeBitLength(getKey().getEncoded()) != 256) {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 256 bits for A256GCMKW encryption");
            }
            algFamily = AlgFamily.AESGCMKW;
        }
        SecretKey cek = getCEK(encryptionMethod);
        if (AlgFamily.AESKW.equals(algFamily)) {
            jWEHeaderBuild = jWEHeader;
            base64URLEncode = Base64URL.encode(AESKW.wrapCEK(cek, getKey(), getJCAContext().getKeyEncryptionProvider()));
        } else {
            if (!AlgFamily.AESGCMKW.equals(algFamily)) {
                throw new JOSEException("Unexpected JWE algorithm: " + algorithmAndEnsureNotNull);
            }
            Container container = new Container(AESGCM.generateIV(getJCAContext().getSecureRandom()));
            AuthenticatedCipherText authenticatedCipherTextEncryptCEK = AESGCMKW.encryptCEK(cek, container, getKey(), getJCAContext().getKeyEncryptionProvider());
            Base64URL base64URLEncode2 = Base64URL.encode(authenticatedCipherTextEncryptCEK.getCipherText());
            jWEHeaderBuild = new JWEHeader.Builder(jWEHeader).m4635iv(Base64URL.encode((byte[]) container.get())).authTag(Base64URL.encode(authenticatedCipherTextEncryptCEK.getAuthenticationTag())).build();
            base64URLEncode = base64URLEncode2;
        }
        if (Arrays.equals(AAD.compute(jWEHeader), bArr2)) {
            bArr2 = AAD.compute(jWEHeaderBuild);
        }
        return ContentCryptoProvider.encrypt(jWEHeaderBuild, bArr, bArr2, cek, base64URLEncode, getJCAContext());
    }

    public AESEncrypter(byte[] bArr) {
        this(new SecretKeySpec(bArr, AES256KeyLoader.AES_ALGORITHM));
    }

    public AESEncrypter(OctetSequenceKey octetSequenceKey) {
        this(octetSequenceKey.toSecretKey(AES256KeyLoader.AES_ALGORITHM));
    }
}
