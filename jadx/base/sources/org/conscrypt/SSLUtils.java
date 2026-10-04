package org.conscrypt;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.UShort;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class SSLUtils {
    private static final String KEY_TYPE_EC = "EC";
    private static final String KEY_TYPE_RSA = "RSA";
    private static final int MAX_ENCRYPTION_OVERHEAD_DIFF = 2147483561;
    private static final int MAX_ENCRYPTION_OVERHEAD_LENGTH = 86;
    private static final int MAX_PROTOCOL_LENGTH = 255;
    static final boolean USE_ENGINE_SOCKET_BY_DEFAULT = Boolean.parseBoolean(System.getProperty("org.conscrypt.useEngineSocketByDefault", "true"));
    private static final Charset US_ASCII = Charset.forName("US-ASCII");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EngineStates {
        static final int STATE_CLOSED = 8;
        static final int STATE_CLOSED_INBOUND = 6;
        static final int STATE_CLOSED_OUTBOUND = 7;
        static final int STATE_HANDSHAKE_COMPLETED = 3;
        static final int STATE_HANDSHAKE_STARTED = 2;
        static final int STATE_MODE_SET = 1;
        static final int STATE_NEW = 0;
        static final int STATE_READY = 5;
        static final int STATE_READY_HANDSHAKE_CUT_THROUGH = 4;

        private EngineStates() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SessionType {
        OPEN_SSL(1),
        OPEN_SSL_WITH_OCSP(2),
        OPEN_SSL_WITH_TLS_SCT(3);

        final int value;

        SessionType(int i) {
            this.value = i;
        }

        public static boolean isSupportedType(int i) {
            return i == OPEN_SSL.value || i == OPEN_SSL_WITH_OCSP.value || i == OPEN_SSL_WITH_TLS_SCT.value;
        }
    }

    private SSLUtils() {
    }

    public static int calculateOutNetBufSize(int i) {
        return Math.min(16709, Math.min(MAX_ENCRYPTION_OVERHEAD_DIFF, i) + 86);
    }

    public static String[] concat(String[]... strArr) {
        int length = 0;
        for (String[] strArr2 : strArr) {
            length += strArr2.length;
        }
        String[] strArr3 = new String[length];
        int length2 = 0;
        for (String[] strArr4 : strArr) {
            System.arraycopy(strArr4, 0, strArr3, length2, strArr4.length);
            length2 += strArr4.length;
        }
        return strArr3;
    }

    public static String[] decodeProtocols(byte[] bArr) {
        if (bArr.length == 0) {
            return EmptyArray.STRING;
        }
        int i = 0;
        int i2 = 0;
        int i4 = 0;
        while (i2 < bArr.length) {
            byte b = bArr[i2];
            if (b < 0 || b > bArr.length - i2) {
                StringBuilder sbM1173s = AbstractC0622a.m1173s(b, i2, "Protocol has invalid length (", " at position ", "): ");
                sbM1173s.append(bArr.length < 50 ? Arrays.toString(bArr) : AbstractC2821a.m2223n(new StringBuilder(), " byte array", bArr.length));
                throw new IllegalArgumentException(sbM1173s.toString());
            }
            i4++;
            i2 += b + 1;
        }
        String[] strArr = new String[i4];
        int i5 = 0;
        while (i < bArr.length) {
            byte b5 = bArr[i];
            int i6 = i5 + 1;
            strArr[i5] = b5 > 0 ? new String(bArr, i + 1, b5, US_ASCII) : "";
            i += b5 + 1;
            i5 = i6;
        }
        return strArr;
    }

    private static X509Certificate decodeX509Certificate(CertificateFactory certificateFactory, byte[] bArr) {
        return certificateFactory != null ? (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr)) : OpenSSLX509Certificate.fromX509Der(bArr);
    }

    public static X509Certificate[] decodeX509CertificateChain(byte[][] bArr) {
        CertificateFactory certificateFactory = getCertificateFactory();
        int length = bArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i = 0; i < length; i++) {
            x509CertificateArr[i] = decodeX509Certificate(certificateFactory, bArr[i]);
        }
        return x509CertificateArr;
    }

    public static byte[] encodeProtocols(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("protocols array must be non-null");
        }
        if (strArr.length == 0) {
            return EmptyArray.BYTE;
        }
        int i = 0;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (str == null) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "protocol[", "] is null"));
            }
            int length = str.length();
            if (length == 0 || length > 255) {
                throw new IllegalArgumentException(AbstractC1038a.m1214o(i2, length, "protocol[", "] has invalid length: "));
            }
            i += length + 1;
        }
        byte[] bArr = new byte[i];
        int i4 = 0;
        for (String str2 : strArr) {
            int length2 = str2.length();
            bArr[i4] = (byte) length2;
            i4++;
            int i5 = 0;
            while (i5 < length2) {
                char cCharAt = str2.charAt(i5);
                if (cCharAt > 127) {
                    throw new IllegalArgumentException("Protocol contains invalid character: " + cCharAt + "(protocol=" + str2 + ")");
                }
                bArr[i4] = (byte) cCharAt;
                i5++;
                i4++;
            }
        }
        return bArr;
    }

    public static byte[][] encodeSubjectX509Principals(X509Certificate[] x509CertificateArr) {
        byte[][] bArr = new byte[x509CertificateArr.length][];
        for (int i = 0; i < x509CertificateArr.length; i++) {
            bArr[i] = x509CertificateArr[i].getSubjectX500Principal().getEncoded();
        }
        return bArr;
    }

    private static CertificateFactory getCertificateFactory() {
        try {
            return CertificateFactory.getInstance("X.509");
        } catch (CertificateException unused) {
            return null;
        }
    }

    public static String getClientKeyType(byte b) {
        if (b == 1) {
            return "RSA";
        }
        if (b != 64) {
            return null;
        }
        return KEY_TYPE_EC;
    }

    public static String getClientKeyTypeFromSignatureAlg(int i) {
        int iSSL_get_signature_algorithm_key_type = NativeCrypto.SSL_get_signature_algorithm_key_type(i);
        if (iSSL_get_signature_algorithm_key_type == 6) {
            return "RSA";
        }
        if (iSSL_get_signature_algorithm_key_type != 408) {
            return null;
        }
        return KEY_TYPE_EC;
    }

    public static int getEncryptedPacketLength(ByteBuffer[] byteBufferArr, int i) {
        ByteBuffer byteBuffer = byteBufferArr[i];
        if (byteBuffer.remaining() >= 5) {
            return getEncryptedPacketLength(byteBuffer);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        while (true) {
            int i2 = i + 1;
            ByteBuffer byteBuffer2 = byteBufferArr[i];
            int iPosition = byteBuffer2.position();
            int iLimit = byteBuffer2.limit();
            if (byteBuffer2.remaining() > byteBufferAllocate.remaining()) {
                byteBuffer2.limit(byteBufferAllocate.remaining() + iPosition);
            }
            try {
                byteBufferAllocate.put(byteBuffer2);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                if (!byteBufferAllocate.hasRemaining()) {
                    byteBufferAllocate.flip();
                    return getEncryptedPacketLength(byteBufferAllocate);
                }
                i = i2;
            } catch (Throwable th) {
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                throw th;
            }
        }
    }

    public static String getServerX509KeyType(long j) {
        String strSSL_CIPHER_get_kx_name = NativeCrypto.SSL_CIPHER_get_kx_name(j);
        if (strSSL_CIPHER_get_kx_name.equals("RSA") || strSSL_CIPHER_get_kx_name.equals("DHE_RSA") || strSSL_CIPHER_get_kx_name.equals("ECDHE_RSA")) {
            return "RSA";
        }
        if (strSSL_CIPHER_get_kx_name.equals("ECDHE_ECDSA")) {
            return KEY_TYPE_EC;
        }
        return null;
    }

    public static Set<String> getSupportedClientKeyTypes(byte[] bArr, int[] iArr) {
        HashSet hashSet = new HashSet(bArr.length);
        for (byte b : bArr) {
            String clientKeyType = getClientKeyType(b);
            if (clientKeyType != null) {
                hashSet.add(clientKeyType);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(iArr.length);
        for (int i : iArr) {
            String clientKeyTypeFromSignatureAlg = getClientKeyTypeFromSignatureAlg(i);
            if (clientKeyTypeFromSignatureAlg != null) {
                linkedHashSet.add(clientKeyTypeFromSignatureAlg);
            }
        }
        if (bArr.length <= 0 || iArr.length <= 0) {
            return iArr.length > 0 ? linkedHashSet : hashSet;
        }
        linkedHashSet.retainAll(hashSet);
        return linkedHashSet;
    }

    public static javax.security.cert.X509Certificate[] toCertificateChain(X509Certificate[] x509CertificateArr) throws Throwable {
        try {
            javax.security.cert.X509Certificate[] x509CertificateArr2 = new javax.security.cert.X509Certificate[x509CertificateArr.length];
            for (int i = 0; i < x509CertificateArr.length; i++) {
                x509CertificateArr2[i] = javax.security.cert.X509Certificate.getInstance(x509CertificateArr[i].getEncoded());
            }
            return x509CertificateArr2;
        } catch (CertificateEncodingException e) {
            Throwable sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(sSLPeerUnverifiedException);
            throw sSLPeerUnverifiedException;
        } catch (javax.security.cert.CertificateException e2) {
            Throwable sSLPeerUnverifiedException2 = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException2.initCause(sSLPeerUnverifiedException2);
            throw sSLPeerUnverifiedException2;
        }
    }

    public static byte[] toProtocolBytes(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes(US_ASCII);
    }

    public static String toProtocolString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, US_ASCII);
    }

    public static SSLException toSSLException(Throwable th) {
        return th instanceof SSLException ? (SSLException) th : new SSLException(th);
    }

    public static SSLHandshakeException toSSLHandshakeException(Throwable th) {
        return th instanceof SSLHandshakeException ? (SSLHandshakeException) th : (SSLHandshakeException) new SSLHandshakeException(th.getMessage()).initCause(th);
    }

    private static short unsignedByte(byte b) {
        return (short) (b & 255);
    }

    private static int unsignedShort(short s) {
        return s & UShort.MAX_VALUE;
    }

    private static int getEncryptedPacketLength(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        switch (unsignedByte(byteBuffer.get(iPosition))) {
            case 20:
            case 21:
            case 22:
            case 23:
                if (unsignedByte(byteBuffer.get(iPosition + 1)) == 3 && (r4 = unsignedShort(byteBuffer.getShort(iPosition + 3)) + 5) > 5) {
                }
                break;
        }
        return -1;
    }
}
