package com.nimbusds.jose.crypto;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.UnprotectedHeader;
import com.nimbusds.jose.crypto.impl.AAD;
import com.nimbusds.jose.crypto.impl.AESCryptoProvider;
import com.nimbusds.jose.crypto.impl.DirectCryptoProvider;
import com.nimbusds.jose.crypto.impl.ECDHCryptoProvider;
import com.nimbusds.jose.crypto.impl.JWEHeaderValidation;
import com.nimbusds.jose.crypto.impl.MultiCryptoProvider;
import com.nimbusds.jose.crypto.impl.RSACryptoProvider;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyType;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONArrayUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class MultiEncrypter extends MultiCryptoProvider implements JWEEncrypter {
    private static final String[] RECIPIENT_HEADER_PARAMS = {"kid", "alg", "x5u", "x5t", "x5t#S256", "x5c"};
    private final JWKSet keys;

    public MultiEncrypter(JWKSet jWKSet) {
        this(jWKSet, findDirectCEK(jWKSet));
    }

    private static SecretKey findDirectCEK(JWKSet jWKSet) {
        if (jWKSet == null) {
            return null;
        }
        for (JWK jwk : jWKSet.getKeys()) {
            if (JWEAlgorithm.DIR.equals(jwk.getAlgorithm()) && KeyType.OCT.equals(jwk.getKeyType())) {
                return jwk.toOctetSequenceKey().toSecretKey(AES256KeyLoader.AES_ALGORITHM);
            }
        }
        return null;
    }

    @Deprecated
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) {
        return encrypt(jWEHeader, bArr, AAD.compute(jWEHeader));
    }

    public MultiEncrypter(JWKSet jWKSet, SecretKey secretKey) {
        super(secretKey);
        if (jWKSet == null) {
            throw new IllegalArgumentException("The JWK set must not be null");
        }
        for (JWK jwk : jWKSet.getKeys()) {
            KeyType keyType = jwk.getKeyType();
            if (jwk.getAlgorithm() == null) {
                throw new IllegalArgumentException("Each JWK must specify a key encryption algorithm");
            }
            JWEAlgorithm jWEAlgorithm = JWEAlgorithm.parse(jwk.getAlgorithm().toString());
            if (JWEAlgorithm.DIR.equals(jWEAlgorithm) && KeyType.OCT.equals(keyType) && !jwk.toOctetSequenceKey().toSecretKey(AES256KeyLoader.AES_ALGORITHM).equals(secretKey)) {
                throw new IllegalArgumentException("Bad CEK");
            }
            if (!KeyType.RSA.equals(keyType) || !RSACryptoProvider.SUPPORTED_ALGORITHMS.contains(jWEAlgorithm)) {
                if (!KeyType.f3634EC.equals(keyType) || !ECDHCryptoProvider.SUPPORTED_ALGORITHMS.contains(jWEAlgorithm)) {
                    KeyType keyType2 = KeyType.OCT;
                    if (!keyType2.equals(keyType) || !AESCryptoProvider.SUPPORTED_ALGORITHMS.contains(jWEAlgorithm)) {
                        if (!keyType2.equals(keyType) || !DirectCryptoProvider.SUPPORTED_ALGORITHMS.contains(jWEAlgorithm)) {
                            if (!KeyType.OKP.equals(keyType) || !ECDHCryptoProvider.SUPPORTED_ALGORITHMS.contains(jWEAlgorithm)) {
                                throw new IllegalArgumentException("Unsupported key encryption algorithm: " + jWEAlgorithm);
                            }
                        }
                    }
                }
            }
        }
        this.keys = jWKSet;
    }

    @Override // com.nimbusds.jose.JWEEncrypter
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr, byte[] bArr2) throws JOSEException {
        JWEEncrypter x25519Encrypter;
        Payload payload;
        if (bArr2 == null) {
            throw new JOSEException("Missing JWE additional authenticated data (AAD)");
        }
        SecretKey cek = getCEK(jWEHeader.getEncryptionMethod());
        Payload payload2 = new Payload(bArr);
        List<Object> listNewJSONArray = JSONArrayUtils.newJSONArray();
        Base64URL base64URLEncode = null;
        Base64URL base64URL = null;
        Base64URL base64URL2 = null;
        Base64URL authenticationTag = null;
        for (JWK jwk : this.keys.getKeys()) {
            KeyType keyType = jwk.getKeyType();
            Map<String, Object> jSONObject = jwk.toJSONObject();
            UnprotectedHeader.Builder builder = new UnprotectedHeader.Builder();
            String[] strArr = RECIPIENT_HEADER_PARAMS;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i;
                String str = strArr[i2];
                if (jSONObject.containsKey(str)) {
                    payload = payload2;
                    builder.param(str, jSONObject.get(str));
                } else {
                    payload = payload2;
                }
                i = i2 + 1;
                payload2 = payload;
            }
            Payload payload3 = payload2;
            try {
                JWEHeader jWEHeader2 = (JWEHeader) jWEHeader.join(builder.build());
                JWEAlgorithm algorithmAndEnsureNotNull = JWEHeaderValidation.getAlgorithmAndEnsureNotNull(jWEHeader2);
                if (KeyType.RSA.equals(keyType) && RSACryptoProvider.SUPPORTED_ALGORITHMS.contains(algorithmAndEnsureNotNull)) {
                    x25519Encrypter = new RSAEncrypter(jwk.toRSAKey().toRSAPublicKey(), cek);
                } else if (KeyType.f3634EC.equals(keyType) && ECDHCryptoProvider.SUPPORTED_ALGORITHMS.contains(algorithmAndEnsureNotNull)) {
                    x25519Encrypter = new ECDHEncrypter(jwk.toECKey().toECPublicKey(), cek);
                } else {
                    KeyType keyType2 = KeyType.OCT;
                    if (keyType2.equals(keyType) && AESCryptoProvider.SUPPORTED_ALGORITHMS.contains(algorithmAndEnsureNotNull)) {
                        x25519Encrypter = new AESEncrypter(jwk.toOctetSequenceKey().toSecretKey(AES256KeyLoader.AES_ALGORITHM), cek);
                    } else if (keyType2.equals(keyType) && DirectCryptoProvider.SUPPORTED_ALGORITHMS.contains(algorithmAndEnsureNotNull)) {
                        x25519Encrypter = new DirectEncrypter(jwk.toOctetSequenceKey().toSecretKey(AES256KeyLoader.AES_ALGORITHM));
                    } else if (KeyType.OKP.equals(keyType) && ECDHCryptoProvider.SUPPORTED_ALGORITHMS.contains(algorithmAndEnsureNotNull)) {
                        x25519Encrypter = new X25519Encrypter(jwk.toOctetKeyPair().toPublicJWK(), cek);
                    } else {
                        payload2 = payload3;
                    }
                }
                JWECryptoParts jWECryptoPartsEncrypt = x25519Encrypter.encrypt(jWEHeader2, payload3.toBytes(), bArr2);
                Map<String, Object> jSONObject2 = jWECryptoPartsEncrypt.getHeader().toJSONObject();
                Iterator<String> it = jWEHeader.getIncludedParams().iterator();
                while (it.hasNext()) {
                    jSONObject2.remove(it.next());
                }
                Map<String, Object> mapNewJSONObject = JSONObjectUtils.newJSONObject();
                mapNewJSONObject.put("header", jSONObject2);
                if (!JWEAlgorithm.DIR.equals(algorithmAndEnsureNotNull)) {
                    mapNewJSONObject.put("encrypted_key", jWECryptoPartsEncrypt.getEncryptedKey().toString());
                }
                listNewJSONArray.add(mapNewJSONObject);
                if (listNewJSONArray.size() == 1) {
                    payload2 = new Payload("");
                    base64URLEncode = jWECryptoPartsEncrypt.getEncryptedKey();
                    Base64URL initializationVector = jWECryptoPartsEncrypt.getInitializationVector();
                    Base64URL cipherText = jWECryptoPartsEncrypt.getCipherText();
                    authenticationTag = jWECryptoPartsEncrypt.getAuthenticationTag();
                    base64URL = initializationVector;
                    base64URL2 = cipherText;
                } else {
                    payload2 = payload3;
                }
            } catch (Exception e) {
                throw new JOSEException(e.getMessage(), e);
            }
        }
        if (listNewJSONArray.size() > 1) {
            Map<String, Object> mapNewJSONObject2 = JSONObjectUtils.newJSONObject();
            mapNewJSONObject2.put("recipients", listNewJSONArray);
            base64URLEncode = Base64URL.encode(JSONObjectUtils.toJSONString(mapNewJSONObject2));
        }
        return new JWECryptoParts(jWEHeader, base64URLEncode, base64URL, base64URL2, authenticationTag);
    }
}
