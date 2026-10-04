package com.nimbusds.jose.crypto.impl;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.Container;
import java.security.Provider;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class AESGCMKW {
    private AESGCMKW() {
    }

    public static SecretKey decryptCEK(SecretKey secretKey, byte[] bArr, AuthenticatedCipherText authenticatedCipherText, int i, Provider provider) throws JOSEException {
        byte[] bArrDecrypt = AESGCM.decrypt(secretKey, bArr, authenticatedCipherText.getCipherText(), new byte[0], authenticatedCipherText.getAuthenticationTag(), provider);
        if (ByteUtils.safeBitLength(bArrDecrypt) == i) {
            return new SecretKeySpec(bArrDecrypt, AES256KeyLoader.AES_ALGORITHM);
        }
        throw new KeyLengthException("CEK key length mismatch: " + ByteUtils.safeBitLength(bArrDecrypt) + " != " + i);
    }

    public static AuthenticatedCipherText encryptCEK(SecretKey secretKey, Container<byte[]> container, SecretKey secretKey2, Provider provider) {
        return AESGCM.encrypt(secretKey2, container, secretKey.getEncoded(), new byte[0], provider);
    }
}
