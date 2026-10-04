package com.nimbusds.jose.crypto.impl;

import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jca.JCAAware;
import com.nimbusds.jose.jca.JCAContext;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.IntegerUtils;
import com.nimbusds.jose.util.StandardCharset;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class ConcatKDF implements JCAAware<JCAContext> {
    private final JCAContext jcaContext = new JCAContext();
    private final String jcaHashAlg;

    public ConcatKDF(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The JCA hash algorithm must not be null");
        }
        this.jcaHashAlg = str;
    }

    public static byte[] composeOtherInfo(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        return ByteUtils.concat(bArr, bArr2, bArr3, bArr4, bArr5);
    }

    public static int computeDigestCycles(int i, int i2) {
        return AbstractC4539a.m3211u(i2, i, 1, i);
    }

    public static byte[] encodeDataWithLength(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        return ByteUtils.concat(IntegerUtils.toBytes(bArr.length), bArr);
    }

    public static byte[] encodeIntData(int i) {
        return IntegerUtils.toBytes(i);
    }

    public static byte[] encodeNoData() {
        return new byte[0];
    }

    public static byte[] encodeStringData(String str) {
        return encodeDataWithLength(str != null ? str.getBytes(StandardCharset.UTF_8) : null);
    }

    private MessageDigest getMessageDigest() throws JOSEException {
        Provider provider = getJCAContext().getProvider();
        try {
            return provider == null ? MessageDigest.getInstance(this.jcaHashAlg) : MessageDigest.getInstance(this.jcaHashAlg, provider);
        } catch (NoSuchAlgorithmException e) {
            throw new JOSEException("Couldn't get message digest for KDF: " + e.getMessage(), e);
        }
    }

    public SecretKey deriveKey(SecretKey secretKey, int i, byte[] bArr) throws JOSEException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MessageDigest messageDigest = getMessageDigest();
        for (int i2 = 1; i2 <= computeDigestCycles(ByteUtils.safeBitLength(messageDigest.getDigestLength()), i); i2++) {
            messageDigest.update(IntegerUtils.toBytes(i2));
            messageDigest.update(secretKey.getEncoded());
            if (bArr != null) {
                messageDigest.update(bArr);
            }
            try {
                byteArrayOutputStream.write(messageDigest.digest());
            } catch (IOException e) {
                throw new JOSEException("Couldn't write derived key: " + e.getMessage(), e);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int iByteLength = ByteUtils.byteLength(i);
        return byteArray.length == iByteLength ? new SecretKeySpec(byteArray, AES256KeyLoader.AES_ALGORITHM) : new SecretKeySpec(ByteUtils.subArray(byteArray, 0, iByteLength), AES256KeyLoader.AES_ALGORITHM);
    }

    public String getHashAlgorithm() {
        return this.jcaHashAlg;
    }

    @Override // com.nimbusds.jose.jca.JCAAware
    public JCAContext getJCAContext() {
        return this.jcaContext;
    }

    public static byte[] composeOtherInfo(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        return ByteUtils.concat(bArr, bArr2, bArr3, bArr4, bArr5, bArr6);
    }

    public static byte[] encodeDataWithLength(Base64URL base64URL) {
        return encodeDataWithLength(base64URL != null ? base64URL.decode() : null);
    }

    public SecretKey deriveKey(SecretKey secretKey, int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        return deriveKey(secretKey, i, composeOtherInfo(bArr, bArr2, bArr3, bArr4, bArr5));
    }

    public SecretKey deriveKey(SecretKey secretKey, int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        return deriveKey(secretKey, i, composeOtherInfo(bArr, bArr2, bArr3, bArr4, bArr5, bArr6));
    }
}
