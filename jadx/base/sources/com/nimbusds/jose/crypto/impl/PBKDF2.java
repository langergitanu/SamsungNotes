package com.nimbusds.jose.crypto.impl;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.IntegerUtils;
import com.nimbusds.jose.util.StandardCharset;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PBKDF2 {
    static final long MAX_DERIVED_KEY_LENGTH = 4294967295L;
    public static final int MIN_SALT_LENGTH = 8;
    static final byte[] ZERO_BYTE = {0};

    private PBKDF2() {
    }

    public static SecretKey deriveKey(byte[] bArr, byte[] bArr2, int i, PRFParams pRFParams) throws JOSEException {
        if (bArr2 == null) {
            throw new JOSEException("The formatted salt must not be null");
        }
        if (i < 1) {
            throw new JOSEException("The iteration count must be greater than 0");
        }
        Mac initMac = HMAC.getInitMac(new SecretKeySpec(bArr, pRFParams.getMACAlgorithm()), pRFParams.getMacProvider());
        int macLength = initMac.getMacLength();
        if (pRFParams.getDerivedKeyByteLength() > 4294967295L) {
            throw new JOSEException("Derived key too long: " + pRFParams.getDerivedKeyByteLength());
        }
        int iCeil = (int) Math.ceil(((double) pRFParams.getDerivedKeyByteLength()) / ((double) macLength));
        int i2 = iCeil - 1;
        int derivedKeyByteLength = pRFParams.getDerivedKeyByteLength() - (macLength * i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        while (i4 < iCeil) {
            int i5 = i4 + 1;
            byte[] bArrExtractBlock = extractBlock(bArr2, i, i5, initMac);
            if (i4 == i2) {
                bArrExtractBlock = ByteUtils.subArray(bArrExtractBlock, 0, derivedKeyByteLength);
            }
            byteArrayOutputStream.write(bArrExtractBlock, 0, bArrExtractBlock.length);
            i4 = i5;
        }
        return new SecretKeySpec(byteArrayOutputStream.toByteArray(), AES256KeyLoader.AES_ALGORITHM);
    }

    public static byte[] extractBlock(byte[] bArr, int i, int i2, Mac mac) throws JOSEException {
        if (bArr == null) {
            throw new JOSEException("The formatted salt must not be null");
        }
        if (i < 1) {
            throw new JOSEException("The iteration count must be greater than 0");
        }
        byte[] bArrDoFinal = null;
        byte[] bArrDoFinal2 = null;
        for (int i4 = 1; i4 <= i; i4++) {
            if (i4 == 1) {
                bArrDoFinal = mac.doFinal(ByteUtils.concat(bArr, IntegerUtils.toBytes(i2)));
                bArrDoFinal2 = bArrDoFinal;
            } else {
                bArrDoFinal2 = mac.doFinal(bArrDoFinal2);
                for (int i5 = 0; i5 < bArrDoFinal2.length; i5++) {
                    bArrDoFinal[i5] = (byte) (bArrDoFinal2[i5] ^ bArrDoFinal[i5]);
                }
            }
        }
        return bArrDoFinal;
    }

    public static byte[] formatSalt(JWEAlgorithm jWEAlgorithm, byte[] bArr) throws JOSEException {
        byte[] bytes = jWEAlgorithm.toString().getBytes(StandardCharset.UTF_8);
        if (bArr == null) {
            throw new JOSEException("The salt must not be null");
        }
        if (bArr.length < 8) {
            throw new JOSEException("The salt must be at least 8 bytes long");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bytes);
            byteArrayOutputStream.write(ZERO_BYTE);
            byteArrayOutputStream.write(bArr);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }
}
