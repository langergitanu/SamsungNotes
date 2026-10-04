package com.google.android.play.core.internal;

import android.util.Pair;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.play.core.internal.h */
/* JADX INFO: loaded from: classes5.dex */
public final class C5224h {
    /* JADX INFO: renamed from: a */
    private static int m3988a(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case SlidingPaneLayout.SESL_PENDING_COLLAPSED_LOCK /* 258 */:
            case 260:
                return 2;
            default:
                String strValueOf = String.valueOf(Long.toHexString(i));
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(strValueOf) : new String("Unknown signature algorithm: 0x"));
        }
    }

    /* JADX INFO: renamed from: b */
    public static long m4002b(ByteBuffer byteBuffer) {
        m4006c(byteBuffer);
        return m3990a(byteBuffer, byteBuffer.position() + 12);
    }

    /* JADX INFO: renamed from: c */
    private static int m4005c(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        throw new IllegalArgumentException(AbstractC4539a.m3197g(44, i, "Unknown content digest algorthm: "));
    }

    /* JADX INFO: renamed from: d */
    private static ByteBuffer m4007d(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException(AbstractC4539a.m3197g(93, byteBuffer.remaining(), "Remaining buffer too short to contain length of length-prefixed field. Remaining: "));
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            return m4004b(byteBuffer, i);
        }
        int iRemaining = byteBuffer.remaining();
        StringBuilder sb = new StringBuilder(101);
        sb.append("Length-prefixed field longer than remaining buffer. Field length: ");
        sb.append(i);
        sb.append(", remaining: ");
        sb.append(iRemaining);
        throw new IOException(sb.toString());
    }

    /* JADX INFO: renamed from: e */
    private static byte[] m4008e(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        int iRemaining = byteBuffer.remaining();
        StringBuilder sb = new StringBuilder(90);
        sb.append("Underflow while reading length-prefixed value. Length: ");
        sb.append(i);
        sb.append(", available: ");
        sb.append(iRemaining);
        throw new IOException(sb.toString());
    }

    /* JADX INFO: renamed from: a */
    public static long m3989a(ByteBuffer byteBuffer) {
        m4006c(byteBuffer);
        return m3990a(byteBuffer, byteBuffer.position() + 16);
    }

    /* JADX INFO: renamed from: b */
    private static String m4003b(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException(AbstractC4539a.m3197g(44, i, "Unknown content digest algorthm: "));
    }

    /* JADX INFO: renamed from: a */
    private static long m3990a(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    /* JADX INFO: renamed from: a */
    public static Pair<ByteBuffer, Long> m3991a(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairM3992a = m3992a(randomAccessFile, 0);
        return pairM3992a != null ? pairM3992a : m3992a(randomAccessFile, 65535);
    }

    /* JADX INFO: renamed from: a */
    private static Pair<ByteBuffer, Long> m3992a(RandomAccessFile randomAccessFile, int i) throws IOException {
        int i2;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i, (-22) + length)) + 22);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jCapacity = length - ((long) byteBufferAllocate.capacity());
        randomAccessFile.seek(jCapacity);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        m4006c(byteBufferAllocate);
        int iCapacity = byteBufferAllocate.capacity();
        if (iCapacity < 22) {
            i2 = -1;
        } else {
            int i4 = iCapacity - 22;
            int iMin = Math.min(i4, 65535);
            for (int i5 = 0; i5 < iMin; i5++) {
                i2 = i4 - i5;
                if (byteBufferAllocate.getInt(i2) == 101010256 && ((char) byteBufferAllocate.getShort(i2 + 20)) == i5) {
                    break;
                }
            }
            i2 = -1;
        }
        if (i2 == -1) {
            return null;
        }
        byteBufferAllocate.position(i2);
        ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) i2)));
    }

    /* JADX INFO: renamed from: a */
    public static String m3993a(String str, String str2) {
        return AbstractC2322a.m1626p(new StringBuilder(str.length() + 1 + String.valueOf(str2).length()), str, ":", str2);
    }

    /* JADX INFO: renamed from: c */
    private static void m4006c(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* JADX INFO: renamed from: b */
    private static ByteBuffer m4004b(ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC4539a.m3197g(17, i, "size: "));
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (i2 < iPosition || i2 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m3994a(String str, String str2, String str3) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(str2).length() + String.valueOf(str3).length());
        AbstractC2821a.m2207B(sb, str, ":", str2, ":");
        sb.append(str3);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static void m3995a(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }

    /* JADX INFO: renamed from: a */
    public static void m3996a(ByteBuffer byteBuffer, long j) {
        m4006c(byteBuffer);
        int iPosition = byteBuffer.position() + 16;
        if (j >= 0 && j <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + iPosition, (int) j);
            return;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("uint32 value of out range: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: renamed from: a */
    private static void m3997a(Map<Integer, byte[]> map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        C5205c c5205c = new C5205c(fileChannel, 0L, j);
        C5205c c5205c2 = new C5205c(fileChannel, j2, j3 - j2);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        m3996a(byteBufferDuplicate, j);
        C5151a c5151a = new C5151a(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] bArrM3999a = m3999a(iArr, new InterfaceC5178b[]{c5205c, c5205c2, c5151a});
            for (int i2 = 0; i2 < size; i2++) {
                int i4 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i4)), bArrM3999a[i2])) {
                    throw new SecurityException(m4003b(i4).concat(" digest of contents did not verify"));
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0141 A[Catch: SignatureException -> 0x0145, InvalidAlgorithmParameterException -> 0x0148, InvalidKeyException -> 0x014b, InvalidKeySpecException -> 0x014e, NoSuchAlgorithmException -> 0x0151, TryCatch #5 {InvalidAlgorithmParameterException -> 0x0148, InvalidKeyException -> 0x014b, NoSuchAlgorithmException -> 0x0151, SignatureException -> 0x0145, InvalidKeySpecException -> 0x014e, blocks: (B:69:0x012b, B:71:0x0141, B:82:0x0154), top: B:141:0x012b }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015d  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static X509Certificate[] m3998a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException {
        String str;
        String str2;
        Pair pairCreate;
        String str3;
        AlgorithmParameterSpec algorithmParameterSpec;
        Signature signature;
        PSSParameterSpec pSSParameterSpec;
        String str4;
        ByteBuffer byteBufferM4007d = m4007d(byteBuffer);
        ByteBuffer byteBufferM4007d2 = m4007d(byteBuffer);
        byte[] bArrM4008e = m4008e(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrM4008e2 = null;
        int i = -1;
        byte[] bArrM4008e3 = null;
        int i2 = 0;
        while (byteBufferM4007d2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer byteBufferM4007d3 = m4007d(byteBufferM4007d2);
                if (byteBufferM4007d3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i4 = byteBufferM4007d3.getInt();
                arrayList.add(Integer.valueOf(i4));
                if (i4 != 513 && i4 != 514 && i4 != 769) {
                    switch (i4) {
                        case 257:
                        case SlidingPaneLayout.SESL_PENDING_COLLAPSED_LOCK /* 258 */:
                        case 259:
                        case 260:
                            break;
                        default:
                            continue;
                    }
                }
                if (i != -1) {
                    int iM3988a = m3988a(i4);
                    int iM3988a2 = m3988a(i);
                    if (iM3988a != 1 && iM3988a2 == 1) {
                    }
                }
                bArrM4008e3 = m4008e(byteBufferM4007d3);
                i = i4;
            } catch (IOException e) {
                e = e;
                throw new SecurityException(AbstractC4539a.m3197g(45, i2, "Failed to parse signature record #"), e);
            } catch (BufferUnderflowException e2) {
                e = e2;
                throw new SecurityException(AbstractC4539a.m3197g(45, i2, "Failed to parse signature record #"), e);
            }
        }
        if (i == -1) {
            if (i2 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        if (i == 513 || i == 514) {
            str = "EC";
        } else if (i != 769) {
            switch (i) {
                case 257:
                case SlidingPaneLayout.SESL_PENDING_COLLAPSED_LOCK /* 258 */:
                case 259:
                case 260:
                    str = AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA;
                    break;
                default:
                    String strValueOf = String.valueOf(Long.toHexString(i));
                    throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(strValueOf) : new String("Unknown signature algorithm: 0x"));
            }
        } else {
            str = "DSA";
        }
        try {
            if (i == 513) {
                str2 = "SHA256withECDSA";
            } else if (i == 514) {
                str2 = "SHA512withECDSA";
            } else if (i != 769) {
                switch (i) {
                    case 257:
                        pSSParameterSpec = new PSSParameterSpec("SHA-256", IDevicePopManager.MGF_1, MGF1ParameterSpec.SHA256, 32, 1);
                        str4 = "SHA256withRSA/PSS";
                        pairCreate = Pair.create(str4, pSSParameterSpec);
                        str3 = (String) pairCreate.first;
                        algorithmParameterSpec = (AlgorithmParameterSpec) pairCreate.second;
                        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrM4008e));
                        signature = Signature.getInstance(str3);
                        signature.initVerify(publicKeyGeneratePublic);
                        if (algorithmParameterSpec != null) {
                            signature.setParameter(algorithmParameterSpec);
                        }
                        signature.update(byteBufferM4007d);
                        if (!signature.verify(bArrM4008e3)) {
                            throw new SecurityException(String.valueOf(str3).concat(" signature did not verify"));
                        }
                        byteBufferM4007d.clear();
                        ByteBuffer byteBufferM4007d4 = m4007d(byteBufferM4007d);
                        ArrayList arrayList2 = new ArrayList();
                        int i5 = 0;
                        while (byteBufferM4007d4.hasRemaining()) {
                            i5++;
                            try {
                                ByteBuffer byteBufferM4007d5 = m4007d(byteBufferM4007d4);
                                if (byteBufferM4007d5.remaining() < 8) {
                                    throw new IOException("Record too short");
                                }
                                int i6 = byteBufferM4007d5.getInt();
                                arrayList2.add(Integer.valueOf(i6));
                                if (i6 == i) {
                                    bArrM4008e2 = m4008e(byteBufferM4007d5);
                                }
                            } catch (IOException e3) {
                                e = e3;
                                throw new IOException(AbstractC4539a.m3197g(42, i5, "Failed to parse digest record #"), e);
                            } catch (BufferUnderflowException e5) {
                                e = e5;
                                throw new IOException(AbstractC4539a.m3197g(42, i5, "Failed to parse digest record #"), e);
                            }
                        }
                        if (!arrayList.equals(arrayList2)) {
                            throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                        }
                        int iM3988a3 = m3988a(i);
                        byte[] bArrPut = map.put(Integer.valueOf(iM3988a3), bArrM4008e2);
                        if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrM4008e2)) {
                            throw new SecurityException(m4003b(iM3988a3).concat(" contents digest does not match the digest specified by a preceding signer"));
                        }
                        ByteBuffer byteBufferM4007d6 = m4007d(byteBufferM4007d);
                        ArrayList arrayList3 = new ArrayList();
                        int i7 = 0;
                        while (byteBufferM4007d6.hasRemaining()) {
                            i7++;
                            byte[] bArrM4008e4 = m4008e(byteBufferM4007d6);
                            try {
                                arrayList3.add(new C5222f((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrM4008e4)), bArrM4008e4));
                            } catch (CertificateException e6) {
                                throw new SecurityException(AbstractC4539a.m3197g(41, i7, "Failed to decode certificate #"), e6);
                            }
                        }
                        if (arrayList3.isEmpty()) {
                            throw new SecurityException("No certificates listed");
                        }
                        if (Arrays.equals(bArrM4008e, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                        }
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                    case SlidingPaneLayout.SESL_PENDING_COLLAPSED_LOCK /* 258 */:
                        pSSParameterSpec = new PSSParameterSpec("SHA-512", IDevicePopManager.MGF_1, MGF1ParameterSpec.SHA512, 64, 1);
                        str4 = "SHA512withRSA/PSS";
                        pairCreate = Pair.create(str4, pSSParameterSpec);
                        str3 = (String) pairCreate.first;
                        algorithmParameterSpec = (AlgorithmParameterSpec) pairCreate.second;
                        PublicKey publicKeyGeneratePublic2 = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrM4008e));
                        signature = Signature.getInstance(str3);
                        signature.initVerify(publicKeyGeneratePublic2);
                        if (algorithmParameterSpec != null) {
                        }
                        signature.update(byteBufferM4007d);
                        if (!signature.verify(bArrM4008e3)) {
                        }
                        break;
                    case 259:
                        str2 = "SHA256withRSA";
                        break;
                    case 260:
                        str2 = "SHA512withRSA";
                        break;
                    default:
                        String strValueOf2 = String.valueOf(Long.toHexString(i));
                        throw new IllegalArgumentException(strValueOf2.length() != 0 ? "Unknown signature algorithm: 0x".concat(strValueOf2) : new String("Unknown signature algorithm: 0x"));
                }
            } else {
                str2 = "SHA256withDSA";
            }
            PublicKey publicKeyGeneratePublic22 = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrM4008e));
            signature = Signature.getInstance(str3);
            signature.initVerify(publicKeyGeneratePublic22);
            if (algorithmParameterSpec != null) {
            }
            signature.update(byteBufferM4007d);
            if (!signature.verify(bArrM4008e3)) {
            }
        } catch (InvalidAlgorithmParameterException e7) {
            e = e7;
            throw new SecurityException(AbstractC2322a.m1626p(new StringBuilder(String.valueOf(str3).length() + 27), "Failed to verify ", str3, " signature"), e);
        } catch (InvalidKeyException e8) {
            e = e8;
            throw new SecurityException(AbstractC2322a.m1626p(new StringBuilder(String.valueOf(str3).length() + 27), "Failed to verify ", str3, " signature"), e);
        } catch (NoSuchAlgorithmException e9) {
            e = e9;
            throw new SecurityException(AbstractC2322a.m1626p(new StringBuilder(String.valueOf(str3).length() + 27), "Failed to verify ", str3, " signature"), e);
        } catch (SignatureException e10) {
            e = e10;
            throw new SecurityException(AbstractC2322a.m1626p(new StringBuilder(String.valueOf(str3).length() + 27), "Failed to verify ", str3, " signature"), e);
        } catch (InvalidKeySpecException e11) {
            e = e11;
            throw new SecurityException(AbstractC2322a.m1626p(new StringBuilder(String.valueOf(str3).length() + 27), "Failed to verify ", str3, " signature"), e);
        }
        pairCreate = Pair.create(str2, null);
        str3 = (String) pairCreate.first;
        algorithmParameterSpec = (AlgorithmParameterSpec) pairCreate.second;
    }

    /* JADX INFO: renamed from: a */
    private static byte[][] m3999a(int[] iArr, InterfaceC5178b[] interfaceC5178bArr) throws DigestException {
        long j;
        int i;
        int length;
        char c;
        int i2 = 0;
        long jMo3864a = 0;
        while (true) {
            j = 1048576;
            if (i2 >= 3) {
                break;
            }
            jMo3864a += (interfaceC5178bArr[i2].mo3864a() + 1048575) / 1048576;
            i2++;
        }
        if (jMo3864a >= 2097151) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Too many chunks: ");
            sb.append(jMo3864a);
            throw new DigestException(sb.toString());
        }
        int i4 = (int) jMo3864a;
        byte[][] bArr = new byte[iArr.length][];
        int i5 = 0;
        while (true) {
            length = iArr.length;
            c = 5;
            if (i5 >= length) {
                break;
            }
            byte[] bArr2 = new byte[(m4005c(iArr[i5]) * i4) + 5];
            bArr2[0] = 90;
            m3995a(i4, bArr2);
            bArr[i5] = bArr2;
            i5++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            String strM4003b = m4003b(iArr[i6]);
            try {
                messageDigestArr[i6] = MessageDigest.getInstance(strM4003b);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(strM4003b.concat(" digest not supported"), e);
            }
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (i = 3; i7 < i; i = 3) {
            InterfaceC5178b interfaceC5178b = interfaceC5178bArr[i7];
            char c2 = c;
            long j2 = 0;
            int i10 = i7;
            long jMo3864a2 = interfaceC5178b.mo3864a();
            while (jMo3864a2 > 0) {
                int iMin = (int) Math.min(jMo3864a2, j);
                m3995a(iMin, bArr3);
                length = length;
                for (int i11 = 0; i11 < length; i11++) {
                    messageDigestArr[i11].update(bArr3);
                }
                try {
                    interfaceC5178b.mo3865a(messageDigestArr, j2, iMin);
                    int i12 = 0;
                    while (i12 < iArr.length) {
                        int i13 = iArr[i12];
                        InterfaceC5178b interfaceC5178b2 = interfaceC5178b;
                        byte[] bArr4 = bArr[i12];
                        int iM4005c = m4005c(i13);
                        long j3 = j2;
                        MessageDigest messageDigest = messageDigestArr[i12];
                        int iDigest = messageDigest.digest(bArr4, (i8 * iM4005c) + 5, iM4005c);
                        if (iDigest != iM4005c) {
                            String algorithm = messageDigest.getAlgorithm();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(algorithm).length() + 46);
                            sb2.append("Unexpected output size of ");
                            sb2.append(algorithm);
                            sb2.append(" digest: ");
                            sb2.append(iDigest);
                            throw new RuntimeException(sb2.toString());
                        }
                        i12++;
                        interfaceC5178b = interfaceC5178b2;
                        j2 = j3;
                    }
                    InterfaceC5178b interfaceC5178b3 = interfaceC5178b;
                    long j5 = iMin;
                    jMo3864a2 -= j5;
                    i8++;
                    j2 += j5;
                    interfaceC5178b = interfaceC5178b3;
                    j = 1048576;
                } catch (IOException e2) {
                    StringBuilder sb3 = new StringBuilder(59);
                    sb3.append("Failed to digest chunk #");
                    sb3.append(i8);
                    sb3.append(" of section #");
                    sb3.append(i9);
                    throw new DigestException(sb3.toString(), e2);
                }
            }
            i9++;
            i7 = i10 + 1;
            c = c2;
            j = 1048576;
        }
        byte[][] bArr5 = new byte[iArr.length][];
        for (int i14 = 0; i14 < iArr.length; i14++) {
            int i15 = iArr[i14];
            byte[] bArr6 = bArr[i14];
            String strM4003b2 = m4003b(i15);
            try {
                bArr5[i14] = MessageDigest.getInstance(strM4003b2).digest(bArr6);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(strM4003b2.concat(" digest not supported"), e3);
            }
        }
        return bArr5;
    }

    /* JADX INFO: renamed from: a */
    public static X509Certificate[][] m4000a(String str) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> pairM3991a = m3991a(randomAccessFile);
            if (pairM3991a == null) {
                long length = randomAccessFile.length();
                StringBuilder sb = new StringBuilder(102);
                sb.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
                sb.append(length);
                sb.append(" bytes");
                throw new C5221e(sb.toString());
            }
            ByteBuffer byteBuffer = (ByteBuffer) pairM3991a.first;
            long jLongValue = ((Long) pairM3991a.second).longValue();
            long j = (-20) + jLongValue;
            if (j >= 0) {
                randomAccessFile.seek(j);
                if (randomAccessFile.readInt() == 1347094023) {
                    throw new C5221e("ZIP64 APK not supported");
                }
            }
            long jM3989a = m3989a(byteBuffer);
            if (jM3989a >= jLongValue) {
                StringBuilder sb2 = new StringBuilder(122);
                sb2.append("ZIP Central Directory offset out of range: ");
                sb2.append(jM3989a);
                sb2.append(". ZIP End of Central Directory offset: ");
                sb2.append(jLongValue);
                throw new C5221e(sb2.toString());
            }
            if (m4002b(byteBuffer) + jM3989a != jLongValue) {
                throw new C5221e("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            if (jM3989a < 32) {
                StringBuilder sb3 = new StringBuilder(87);
                sb3.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                sb3.append(jM3989a);
                throw new C5221e(sb3.toString());
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile.seek(jM3989a - ((long) byteBufferAllocate.capacity()));
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
                throw new C5221e("No APK Signing Block before ZIP Central Directory");
            }
            long j2 = byteBufferAllocate.getLong(0);
            if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
                StringBuilder sb4 = new StringBuilder(57);
                sb4.append("APK Signing Block size out of range: ");
                sb4.append(j2);
                throw new C5221e(sb4.toString());
            }
            int i = (int) (8 + j2);
            long j3 = jM3989a - ((long) i);
            if (j3 < 0) {
                StringBuilder sb5 = new StringBuilder(59);
                sb5.append("APK Signing Block offset out of range: ");
                sb5.append(j3);
                throw new C5221e(sb5.toString());
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
            byteBufferAllocate2.order(byteOrder);
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
            long j5 = jM3989a;
            long j6 = byteBufferAllocate2.getLong(0);
            if (j6 != j2) {
                StringBuilder sb6 = new StringBuilder(103);
                sb6.append("APK Signing Block sizes in header and footer do not match: ");
                sb6.append(j6);
                sb6.append(" vs ");
                sb6.append(j2);
                throw new C5221e(sb6.toString());
            }
            Pair pairCreate = Pair.create(byteBufferAllocate2, Long.valueOf(j3));
            ByteBuffer byteBuffer2 = (ByteBuffer) pairCreate.first;
            long jLongValue2 = ((Long) pairCreate.second).longValue();
            if (byteBuffer2.order() != byteOrder) {
                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
            }
            int iCapacity = byteBuffer2.capacity() - 24;
            if (iCapacity < 8) {
                StringBuilder sb7 = new StringBuilder(38);
                sb7.append("end < start: ");
                sb7.append(iCapacity);
                sb7.append(" < 8");
                throw new IllegalArgumentException(sb7.toString());
            }
            int iCapacity2 = byteBuffer2.capacity();
            if (iCapacity > byteBuffer2.capacity()) {
                StringBuilder sb8 = new StringBuilder(41);
                sb8.append("end > capacity: ");
                sb8.append(iCapacity);
                sb8.append(" > ");
                sb8.append(iCapacity2);
                throw new IllegalArgumentException(sb8.toString());
            }
            int iLimit = byteBuffer2.limit();
            int iPosition = byteBuffer2.position();
            try {
                byteBuffer2.position(0);
                byteBuffer2.limit(iCapacity);
                byteBuffer2.position(8);
                ByteBuffer byteBufferSlice = byteBuffer2.slice();
                byteBufferSlice.order(byteBuffer2.order());
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                int i2 = 0;
                while (byteBufferSlice.hasRemaining()) {
                    int i4 = i2 + 1;
                    if (byteBufferSlice.remaining() < 8) {
                        StringBuilder sb9 = new StringBuilder(70);
                        sb9.append("Insufficient data to read size of APK Signing Block entry #");
                        sb9.append(i4);
                        throw new C5221e(sb9.toString());
                    }
                    long j7 = byteBufferSlice.getLong();
                    if (j7 < 4 || j7 > 2147483647L) {
                        StringBuilder sb10 = new StringBuilder(76);
                        sb10.append("APK Signing Block entry #");
                        sb10.append(i4);
                        sb10.append(" size out of range: ");
                        sb10.append(j7);
                        throw new C5221e(sb10.toString());
                    }
                    int i5 = (int) j7;
                    int iPosition2 = byteBufferSlice.position() + i5;
                    if (i5 > byteBufferSlice.remaining()) {
                        int iRemaining = byteBufferSlice.remaining();
                        StringBuilder sb11 = new StringBuilder(91);
                        sb11.append("APK Signing Block entry #");
                        sb11.append(i4);
                        sb11.append(" size out of range: ");
                        sb11.append(i5);
                        sb11.append(", available: ");
                        sb11.append(iRemaining);
                        throw new C5221e(sb11.toString());
                    }
                    if (byteBufferSlice.getInt() == 1896449818) {
                        X509Certificate[][] x509CertificateArrM4001a = m4001a(randomAccessFile.getChannel(), new C5220d(m4004b(byteBufferSlice, i5 - 4), jLongValue2, j5, jLongValue, byteBuffer));
                        randomAccessFile.close();
                        return x509CertificateArrM4001a;
                    }
                    long j8 = jLongValue2;
                    long j9 = j5;
                    byteBufferSlice.position(iPosition2);
                    i2 = i4;
                    j5 = j9;
                    jLongValue2 = j8;
                }
                throw new C5221e("No APK Signature Scheme v2 block in APK Signing Block");
            } catch (Throwable th) {
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                throw th;
            }
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static X509Certificate[][] m4001a(FileChannel fileChannel, C5220d c5220d) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferM4007d = m4007d(c5220d.f2986a);
                int i = 0;
                while (byteBufferM4007d.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(m3998a(m4007d(byteBufferM4007d), map, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (map.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                m3997a(map, fileChannel, c5220d.f2987b, c5220d.f2988c, c5220d.f2989d, c5220d.f2990e);
                return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }
}
