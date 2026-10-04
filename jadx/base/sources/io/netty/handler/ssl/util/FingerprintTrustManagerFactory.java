package io.netty.handler.ssl.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.scs.p140ai.sdkcommon.suggestion.SuggestionConst;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class FingerprintTrustManagerFactory extends SimpleTrustManagerFactory {
    private static final Pattern FINGERPRINT_PATTERN = Pattern.compile("^[0-9a-fA-F:]+$");
    private static final Pattern FINGERPRINT_STRIP_PATTERN = Pattern.compile(":");
    private final byte[][] fingerprints;
    private final FastThreadLocal<MessageDigest> tlmd;

    /* JADX INFO: renamed from: tm */
    private final TrustManager f8951tm;

    @Deprecated
    public FingerprintTrustManagerFactory(Iterable<String> iterable) {
        this("SHA1", toFingerprintArray(iterable));
    }

    public static FingerprintTrustManagerFactoryBuilder builder(String str) {
        return new FingerprintTrustManagerFactoryBuilder(str);
    }

    public static byte[][] toFingerprintArray(Iterable<String> iterable) {
        String next;
        ObjectUtil.checkNotNull(iterable, "fingerprints");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (!FINGERPRINT_PATTERN.matcher(next).matches()) {
                throw new IllegalArgumentException("malformed fingerprint: ".concat(next));
            }
            arrayList.add(StringUtil.decodeHexDump(FINGERPRINT_STRIP_PATTERN.matcher(next).replaceAll("")));
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    @Override // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public TrustManager[] engineGetTrustManagers() {
        return new TrustManager[]{this.f8951tm};
    }

    @Override // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public void engineInit(KeyStore keyStore) {
    }

    @Deprecated
    public FingerprintTrustManagerFactory(String... strArr) {
        this("SHA1", toFingerprintArray(Arrays.asList(strArr)));
    }

    @Override // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public void engineInit(ManagerFactoryParameters managerFactoryParameters) {
    }

    @Deprecated
    public FingerprintTrustManagerFactory(byte[]... bArr) {
        this("SHA1", bArr);
    }

    public FingerprintTrustManagerFactory(final String str, byte[][] bArr) {
        this.f8951tm = new X509TrustManager() { // from class: io.netty.handler.ssl.util.FingerprintTrustManagerFactory.1
            private void checkTrusted(String str2, X509Certificate[] x509CertificateArr) throws CertificateException {
                X509Certificate x509Certificate = x509CertificateArr[0];
                byte[] bArrFingerprint = fingerprint(x509Certificate);
                for (byte[] bArr2 : FingerprintTrustManagerFactory.this.fingerprints) {
                    if (Arrays.equals(bArrFingerprint, bArr2)) {
                        return;
                    }
                }
                StringBuilder sbM781w = AbstractC0541b.m781w(str2, " certificate with unknown fingerprint: ");
                sbM781w.append(x509Certificate.getSubjectDN());
                throw new CertificateException(sbM781w.toString());
            }

            private byte[] fingerprint(X509Certificate x509Certificate) {
                MessageDigest messageDigest = (MessageDigest) FingerprintTrustManagerFactory.this.tlmd.get();
                messageDigest.reset();
                return messageDigest.digest(x509Certificate.getEncoded());
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str2) throws CertificateException {
                checkTrusted(SuggestionConst.KEY_PARAM_CLIENT, x509CertificateArr);
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str2) throws CertificateException {
                checkTrusted("server", x509CertificateArr);
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return EmptyArrays.EMPTY_X509_CERTIFICATES;
            }
        };
        ObjectUtil.checkNotNull(str, "algorithm");
        ObjectUtil.checkNotNull(bArr, "fingerprints");
        if (bArr.length != 0) {
            try {
                int digestLength = MessageDigest.getInstance(str).getDigestLength();
                ArrayList arrayList = new ArrayList(bArr.length);
                for (byte[] bArr2 : bArr) {
                    if (bArr2 == null) {
                        break;
                    }
                    if (bArr2.length == digestLength) {
                        arrayList.add(bArr2.clone());
                    } else {
                        throw new IllegalArgumentException(String.format("malformed fingerprint (length is %d but expected %d): %s", Integer.valueOf(bArr2.length), Integer.valueOf(digestLength), ByteBufUtil.hexDump(Unpooled.wrappedBuffer(bArr2))));
                    }
                }
                this.tlmd = new FastThreadLocal<MessageDigest>() { // from class: io.netty.handler.ssl.util.FingerprintTrustManagerFactory.2
                    @Override // io.netty.util.concurrent.FastThreadLocal
                    public MessageDigest initialValue() {
                        try {
                            return MessageDigest.getInstance(str);
                        } catch (NoSuchAlgorithmException e) {
                            throw new IllegalArgumentException(AbstractC0541b.m772n("Unsupported hash algorithm: ", str), e);
                        }
                    }
                };
                this.fingerprints = (byte[][]) arrayList.toArray(new byte[0][]);
                return;
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalArgumentException(AbstractC0541b.m772n("Unsupported hash algorithm: ", str), e);
            }
        }
        throw new IllegalArgumentException("No fingerprints provided");
    }
}
