package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECParameterTable;
import com.nimbusds.jose.util.ByteUtils;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ECDSA {
    private ECDSA() {
    }

    public static void ensureLegalSignature(byte[] bArr, JWSAlgorithm jWSAlgorithm) throws JOSEException {
        if (ByteUtils.isZeroFilled(bArr)) {
            throw new JOSEException("Blank signature");
        }
        Set<Curve> setForJWSAlgorithm = Curve.forJWSAlgorithm(jWSAlgorithm);
        if (setForJWSAlgorithm == null || setForJWSAlgorithm.size() > 1) {
            throw new JOSEException("Unsupported JWS algorithm: " + jWSAlgorithm);
        }
        Curve next = setForJWSAlgorithm.iterator().next();
        ECParameterSpec eCParameterSpec = ECParameterTable.get(next);
        if (eCParameterSpec == null) {
            throw new JOSEException("Unsupported curve: " + next);
        }
        int signatureByteArrayLength = getSignatureByteArrayLength(jWSAlgorithm);
        if (getSignatureByteArrayLength(jWSAlgorithm) != bArr.length) {
            throw new JOSEException("Illegal signature length");
        }
        int i = signatureByteArrayLength / 2;
        BigInteger bigInteger = new BigInteger(1, ByteUtils.subArray(bArr, 0, i));
        BigInteger bigInteger2 = new BigInteger(1, ByteUtils.subArray(bArr, i, i));
        BigInteger bigInteger3 = BigInteger.ZERO;
        if (bigInteger2.equals(bigInteger3) || bigInteger.equals(bigInteger3)) {
            throw new JOSEException("S and R must not be 0");
        }
        BigInteger order = eCParameterSpec.getOrder();
        if (order.compareTo(bigInteger) < 1 || order.compareTo(bigInteger2) < 1) {
            throw new JOSEException("S and R must not exceed N");
        }
        if (bigInteger.mod(order).equals(bigInteger3) || bigInteger2.mod(order).equals(bigInteger3)) {
            throw new JOSEException("R or S mod N != 0 check failed");
        }
    }

    public static int getSignatureByteArrayLength(JWSAlgorithm jWSAlgorithm) throws JOSEException {
        if (jWSAlgorithm.equals(JWSAlgorithm.ES256) || jWSAlgorithm.equals(JWSAlgorithm.ES256K)) {
            return 64;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.ES384)) {
            return 96;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.ES512)) {
            return 132;
        }
        throw new JOSEException(AlgorithmSupportMessage.unsupportedJWSAlgorithm(jWSAlgorithm, ECDSAProvider.SUPPORTED_ALGORITHMS));
    }

    public static Signature getSignerAndVerifier(JWSAlgorithm jWSAlgorithm, Provider provider) throws JOSEException {
        String str = "SHA256withECDSA";
        if (!jWSAlgorithm.equals(JWSAlgorithm.ES256) && !jWSAlgorithm.equals(JWSAlgorithm.ES256K)) {
            if (jWSAlgorithm.equals(JWSAlgorithm.ES384)) {
                str = "SHA384withECDSA";
            } else {
                if (!jWSAlgorithm.equals(JWSAlgorithm.ES512)) {
                    throw new JOSEException(AlgorithmSupportMessage.unsupportedJWSAlgorithm(jWSAlgorithm, ECDSAProvider.SUPPORTED_ALGORITHMS));
                }
                str = "SHA512withECDSA";
            }
        }
        try {
            return provider != null ? Signature.getInstance(str, provider) : Signature.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new JOSEException("Unsupported ECDSA algorithm: " + e.getMessage(), e);
        }
    }

    public static JWSAlgorithm resolveAlgorithm(ECKey eCKey) {
        return resolveAlgorithm(Curve.forECParameterSpec(eCKey.getParams()));
    }

    public static byte[] transcodeSignatureToConcat(byte[] bArr, int i) throws JOSEException {
        int i2;
        if (bArr.length < 8 || bArr[0] != 48) {
            throw new JOSEException("Invalid ECDSA signature format");
        }
        byte b = bArr[1];
        if (b > 0) {
            i2 = 2;
        } else {
            if (b != -127) {
                throw new JOSEException("Invalid ECDSA signature format");
            }
            i2 = 3;
        }
        int i4 = bArr[i2 + 1];
        int i5 = i4;
        while (i5 > 0 && bArr[((i2 + 2) + i4) - i5] == 0) {
            i5--;
        }
        int i6 = i2 + 2 + i4;
        int i7 = bArr[i6 + 1];
        int i8 = i7;
        while (i8 > 0 && bArr[((i6 + 2) + i7) - i8] == 0) {
            i8--;
        }
        int iMax = Math.max(Math.max(i5, i8), i / 2);
        int i9 = bArr[i2 - 1];
        if ((i9 & 255) != bArr.length - i2 || (i9 & 255) != i4 + 4 + i7 || bArr[i2] != 2 || bArr[i6] != 2) {
            throw new JOSEException("Invalid ECDSA signature format");
        }
        int i10 = iMax * 2;
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, i6 - i5, bArr2, iMax - i5, i5);
        System.arraycopy(bArr, ((i6 + 2) + i7) - i8, bArr2, i10 - i8, i8);
        return bArr2;
    }

    public static byte[] transcodeSignatureToDER(byte[] bArr) throws Exception {
        byte[] bArr2;
        try {
            int length = bArr.length / 2;
            int i = length;
            while (i > 0 && bArr[length - i] == 0) {
                i--;
            }
            int i2 = length - i;
            int i4 = bArr[i2] < 0 ? i + 1 : i;
            int i5 = length;
            while (i5 > 0 && bArr[(length * 2) - i5] == 0) {
                i5--;
            }
            int i6 = (length * 2) - i5;
            int i7 = bArr[i6] < 0 ? i5 + 1 : i5;
            int i8 = i4 + 4 + i7;
            if (i8 > 255) {
                throw new JOSEException("Invalid ECDSA signature format");
            }
            int i9 = 1;
            if (i8 < 128) {
                bArr2 = new byte[i4 + 6 + i7];
            } else {
                bArr2 = new byte[i4 + 7 + i7];
                bArr2[1] = -127;
                i9 = 2;
            }
            bArr2[0] = 48;
            bArr2[i9] = (byte) i8;
            bArr2[i9 + 1] = 2;
            bArr2[i9 + 2] = (byte) i4;
            int i10 = i9 + 3 + i4;
            System.arraycopy(bArr, i2, bArr2, i10 - i, i);
            bArr2[i10] = 2;
            bArr2[i10 + 1] = (byte) i7;
            System.arraycopy(bArr, i6, bArr2, ((i10 + 2) + i7) - i5, i5);
            return bArr2;
        } catch (Exception e) {
            if (e instanceof JOSEException) {
                throw e;
            }
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static JWSAlgorithm resolveAlgorithm(Curve curve) throws JOSEException {
        if (curve != null) {
            if (Curve.P_256.equals(curve)) {
                return JWSAlgorithm.ES256;
            }
            if (Curve.SECP256K1.equals(curve)) {
                return JWSAlgorithm.ES256K;
            }
            if (Curve.P_384.equals(curve)) {
                return JWSAlgorithm.ES384;
            }
            if (Curve.P_521.equals(curve)) {
                return JWSAlgorithm.ES512;
            }
            throw new JOSEException("Unexpected curve: " + curve);
        }
        throw new JOSEException("The EC key curve is not supported, must be P-256, P-384 or P-521");
    }
}
