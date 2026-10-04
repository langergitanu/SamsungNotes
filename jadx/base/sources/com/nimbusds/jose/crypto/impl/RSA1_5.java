package com.nimbusds.jose.crypto.impl;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.ByteUtils;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class RSA1_5 {
    private RSA1_5() {
    }

    public static SecretKey decryptCEK(PrivateKey privateKey, byte[] bArr, int i, Provider provider) throws JOSEException {
        try {
            Cipher cipherHelper = CipherHelper.getInstance("RSA/ECB/PKCS1Padding", provider);
            cipherHelper.init(2, privateKey);
            byte[] bArrDoFinal = cipherHelper.doFinal(bArr);
            if (ByteUtils.safeBitLength(bArrDoFinal) != i) {
                return null;
            }
            return new SecretKeySpec(bArrDoFinal, AES256KeyLoader.AES_ALGORITHM);
        } catch (Exception e) {
            throw new JOSEException(AbstractC2322a.m1619i(e, new StringBuilder("Couldn't decrypt Content Encryption Key (CEK): ")), e);
        }
    }

    public static byte[] encryptCEK(RSAPublicKey rSAPublicKey, SecretKey secretKey, Provider provider) throws JOSEException {
        try {
            Cipher cipherHelper = CipherHelper.getInstance("RSA/ECB/PKCS1Padding", provider);
            cipherHelper.init(1, rSAPublicKey);
            return cipherHelper.doFinal(secretKey.getEncoded());
        } catch (IllegalBlockSizeException e) {
            throw new JOSEException("RSA block size exception: The RSA key is too short, use a longer one", e);
        } catch (Exception e2) {
            throw new JOSEException(AbstractC2322a.m1619i(e2, new StringBuilder("Couldn't encrypt Content Encryption Key (CEK): ")), e2);
        }
    }
}
