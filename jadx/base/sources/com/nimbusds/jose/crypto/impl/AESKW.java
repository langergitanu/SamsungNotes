package com.nimbusds.jose.crypto.impl;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.KeyUtils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class AESKW {
    private AESKW() {
    }

    public static SecretKey unwrapCEK(SecretKey secretKey, byte[] bArr, Provider provider) throws JOSEException {
        try {
            Cipher cipher = provider != null ? Cipher.getInstance("AESWrap", provider) : Cipher.getInstance("AESWrap");
            cipher.init(4, KeyUtils.toAESKey(secretKey));
            return (SecretKey) cipher.unwrap(bArr, AES256KeyLoader.AES_ALGORITHM, 3);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new JOSEException("Couldn't unwrap AES key: " + e.getMessage(), e);
        }
    }

    public static byte[] wrapCEK(SecretKey secretKey, SecretKey secretKey2, Provider provider) throws JOSEException {
        try {
            Cipher cipher = provider != null ? Cipher.getInstance("AESWrap", provider) : Cipher.getInstance("AESWrap");
            cipher.init(3, secretKey2);
            return cipher.wrap(secretKey);
        } catch (InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new JOSEException("Couldn't wrap AES key: " + e.getMessage(), e);
        }
    }
}
