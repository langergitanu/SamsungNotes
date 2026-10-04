package com.nimbusds.jose.crypto.impl;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.utils.ConstantTimeUtils;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.StandardCharset;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.nio.ByteBuffer;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class AESCBC {
    public static final int IV_BIT_LENGTH = 128;

    private AESCBC() {
    }

    private static Cipher createAESCBCCipher(SecretKey secretKey, boolean z, byte[] bArr, Provider provider) throws JOSEException {
        try {
            Cipher cipherHelper = CipherHelper.getInstance("AES/CBC/PKCS5Padding", provider);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), AES256KeyLoader.AES_ALGORITHM);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            if (z) {
                cipherHelper.init(1, secretKeySpec, ivParameterSpec);
                return cipherHelper;
            }
            cipherHelper.init(2, secretKeySpec, ivParameterSpec);
            return cipherHelper;
        } catch (Exception e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr, byte[] bArr2, Provider provider) throws JOSEException {
        try {
            return createAESCBCCipher(secretKey, false, bArr, provider).doFinal(bArr2);
        } catch (Exception e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static byte[] decryptAuthenticated(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, Provider provider, Provider provider2) {
        CompositeKey compositeKey = new CompositeKey(secretKey);
        byte[] bArrComputeLength = AAD.computeLength(bArr3);
        if (ConstantTimeUtils.areEqual(Arrays.copyOf(HMAC.compute(compositeKey.getMACKey(), ByteBuffer.allocate(bArr3.length + bArr.length + bArr2.length + bArrComputeLength.length).put(bArr3).put(bArr).put(bArr2).put(bArrComputeLength).array(), provider2), compositeKey.getTruncatedMACByteLength()), bArr4)) {
            return decrypt(compositeKey.getAESKey(), bArr, bArr2, provider);
        }
        throw new JOSEException("MAC check failed");
    }

    public static byte[] decryptWithConcatKDF(JWEHeader jWEHeader, SecretKey secretKey, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Provider provider, Provider provider2) {
        byte[] bArrDecode = jWEHeader.getCustomParam("epu") instanceof String ? new Base64URL((String) jWEHeader.getCustomParam("epu")).decode() : null;
        byte[] bArrDecode2 = jWEHeader.getCustomParam("epv") instanceof String ? new Base64URL((String) jWEHeader.getCustomParam("epv")).decode() : null;
        if (ConstantTimeUtils.areEqual(base64URL4.decode(), HMAC.compute(LegacyConcatKDF.generateCIK(secretKey, jWEHeader.getEncryptionMethod(), bArrDecode, bArrDecode2), (jWEHeader.toBase64URL().toString() + Extension.DOT + base64URL.toString() + Extension.DOT + base64URL2.toString() + Extension.DOT + base64URL3.toString()).getBytes(StandardCharset.UTF_8), provider2))) {
            return decrypt(LegacyConcatKDF.generateCEK(secretKey, jWEHeader.getEncryptionMethod(), bArrDecode, bArrDecode2), base64URL2.decode(), base64URL3.decode(), provider);
        }
        throw new JOSEException("MAC check failed");
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] bArr, byte[] bArr2, Provider provider) throws JOSEException {
        try {
            return createAESCBCCipher(secretKey, true, bArr, provider).doFinal(bArr2);
        } catch (Exception e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static AuthenticatedCipherText encryptAuthenticated(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, Provider provider, Provider provider2) {
        CompositeKey compositeKey = new CompositeKey(secretKey);
        byte[] bArrEncrypt = encrypt(compositeKey.getAESKey(), bArr, bArr2, provider);
        byte[] bArrComputeLength = AAD.computeLength(bArr3);
        return new AuthenticatedCipherText(bArrEncrypt, Arrays.copyOf(HMAC.compute(compositeKey.getMACKey(), ByteBuffer.allocate(bArr3.length + bArr.length + bArrEncrypt.length + bArrComputeLength.length).put(bArr3).put(bArr).put(bArrEncrypt).put(bArrComputeLength).array(), provider2), compositeKey.getTruncatedMACByteLength()));
    }

    public static AuthenticatedCipherText encryptWithConcatKDF(JWEHeader jWEHeader, SecretKey secretKey, Base64URL base64URL, byte[] bArr, byte[] bArr2, Provider provider, Provider provider2) {
        byte[] bArrDecode = jWEHeader.getCustomParam("epu") instanceof String ? new Base64URL((String) jWEHeader.getCustomParam("epu")).decode() : null;
        byte[] bArrDecode2 = jWEHeader.getCustomParam("epv") instanceof String ? new Base64URL((String) jWEHeader.getCustomParam("epv")).decode() : null;
        byte[] bArrEncrypt = encrypt(LegacyConcatKDF.generateCEK(secretKey, jWEHeader.getEncryptionMethod(), bArrDecode, bArrDecode2), bArr, bArr2, provider);
        return new AuthenticatedCipherText(bArrEncrypt, HMAC.compute(LegacyConcatKDF.generateCIK(secretKey, jWEHeader.getEncryptionMethod(), bArrDecode, bArrDecode2), (jWEHeader.toBase64URL() + Extension.DOT + base64URL + Extension.DOT + Base64URL.encode(bArr) + Extension.DOT + Base64URL.encode(bArrEncrypt)).getBytes(StandardCharset.UTF_8), provider2));
    }

    public static byte[] generateIV(SecureRandom secureRandom) {
        byte[] bArr = new byte[ByteUtils.byteLength(128)];
        secureRandom.nextBytes(bArr);
        return bArr;
    }
}
