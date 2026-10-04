package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class HMAC {
    @Deprecated
    public static byte[] compute(String str, byte[] bArr, byte[] bArr2, Provider provider) {
        return compute(str, new SecretKeySpec(bArr, str), bArr2, provider);
    }

    public static Mac getInitMac(SecretKey secretKey, Provider provider) {
        return getInitMac(secretKey.getAlgorithm(), secretKey, provider);
    }

    public static byte[] compute(String str, SecretKey secretKey, byte[] bArr, Provider provider) throws JOSEException {
        Mac initMac = getInitMac(str, secretKey, provider);
        initMac.update(bArr);
        return initMac.doFinal();
    }

    public static Mac getInitMac(String str, SecretKey secretKey, Provider provider) throws JOSEException {
        try {
            Mac mac = provider != null ? Mac.getInstance(str, provider) : Mac.getInstance(str);
            mac.init(secretKey);
            return mac;
        } catch (InvalidKeyException e) {
            throw new JOSEException("Invalid HMAC key: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new JOSEException("Unsupported HMAC algorithm: " + e2.getMessage(), e2);
        }
    }

    public static byte[] compute(SecretKey secretKey, byte[] bArr, Provider provider) {
        return compute(secretKey.getAlgorithm(), secretKey, bArr, provider);
    }
}
