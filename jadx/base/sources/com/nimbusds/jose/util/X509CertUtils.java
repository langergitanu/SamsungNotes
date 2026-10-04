package com.nimbusds.jose.util;

import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class X509CertUtils {
    public static final String PEM_BEGIN_MARKER = "-----BEGIN CERTIFICATE-----";
    public static final String PEM_END_MARKER = "-----END CERTIFICATE-----";
    private static Provider jcaProvider;

    public static Base64URL computeSHA256Thumbprint(X509Certificate x509Certificate) {
        try {
            return Base64URL.encode(MessageDigest.getInstance("SHA-256").digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException | CertificateEncodingException unused) {
            return null;
        }
    }

    public static Provider getProvider() {
        return jcaProvider;
    }

    public static X509Certificate parse(byte[] bArr) {
        try {
            return parseWithException(bArr);
        } catch (CertificateException unused) {
            return null;
        }
    }

    public static X509Certificate parseWithException(byte[] bArr) throws CertificateException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Provider provider = jcaProvider;
        Certificate certificateGenerateCertificate = (provider != null ? CertificateFactory.getInstance("X.509", provider) : CertificateFactory.getInstance("X.509")).generateCertificate(new ByteArrayInputStream(bArr));
        if (certificateGenerateCertificate instanceof X509Certificate) {
            return (X509Certificate) certificateGenerateCertificate;
        }
        throw new CertificateException("Not a X.509 certificate: " + certificateGenerateCertificate.getType());
    }

    public static void setProvider(Provider provider) {
        jcaProvider = provider;
    }

    public static UUID store(KeyStore keyStore, PrivateKey privateKey, char[] cArr, X509Certificate x509Certificate) throws KeyStoreException {
        UUID uuidRandomUUID = UUID.randomUUID();
        keyStore.setKeyEntry(uuidRandomUUID.toString(), privateKey, cArr, new Certificate[]{x509Certificate});
        return uuidRandomUUID;
    }

    public static String toPEMString(X509Certificate x509Certificate) {
        return toPEMString(x509Certificate, true);
    }

    public static X509Certificate parse(String str) {
        int iIndexOf;
        String strSubstring;
        int iIndexOf2;
        if (str == null || str.isEmpty() || (iIndexOf = str.indexOf(PEM_BEGIN_MARKER)) < 0 || (iIndexOf2 = (strSubstring = str.substring(iIndexOf + 27)).indexOf(PEM_END_MARKER)) < 0) {
            return null;
        }
        return parse(new Base64(strSubstring.substring(0, iIndexOf2).replaceAll("\\s", "")).decode());
    }

    public static String toPEMString(X509Certificate x509Certificate, boolean z) {
        StringBuilder sb = new StringBuilder(PEM_BEGIN_MARKER);
        if (z) {
            sb.append('\n');
        }
        try {
            sb.append(Base64.encode(x509Certificate.getEncoded()));
            if (z) {
                sb.append('\n');
            }
            sb.append(PEM_END_MARKER);
            return sb.toString();
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    public static X509Certificate parseWithException(String str) throws CertificateException {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int iIndexOf = str.indexOf(PEM_BEGIN_MARKER);
        if (iIndexOf >= 0) {
            String strSubstring = str.substring(iIndexOf + 27);
            int iIndexOf2 = strSubstring.indexOf(PEM_END_MARKER);
            if (iIndexOf2 >= 0) {
                return parseWithException(new Base64(strSubstring.substring(0, iIndexOf2).replaceAll("\\s", "")).decode());
            }
            throw new CertificateException("PEM end marker not found");
        }
        throw new CertificateException("PEM begin marker not found");
    }
}
