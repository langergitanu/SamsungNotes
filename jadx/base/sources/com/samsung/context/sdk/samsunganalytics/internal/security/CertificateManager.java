package com.samsung.context.sdk.samsunganalytics.internal.security;

import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CertificateManager {
    private static final String CA_STORE_NAME = "AndroidCAStore";
    private static final String SSL_PROTOCOL = "TLS";
    private SSLContext sslContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Singleton {
        private static final CertificateManager instance = new CertificateManager();

        private Singleton() {
        }
    }

    public static CertificateManager getInstance() {
        return Singleton.instance;
    }

    private void pinningSystemCA() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            KeyStore keyStore2 = KeyStore.getInstance(CA_STORE_NAME);
            keyStore2.load(null, null);
            Enumeration<String> enumerationAliases = keyStore2.aliases();
            while (enumerationAliases.hasMoreElements()) {
                String strNextElement = enumerationAliases.nextElement();
                X509Certificate x509Certificate = (X509Certificate) keyStore2.getCertificate(strNextElement);
                if (strNextElement.startsWith("system:")) {
                    keyStore.setCertificateEntry(strNextElement, x509Certificate);
                }
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            this.sslContext = sSLContext;
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            Debug.LogENG("pinning success");
        } catch (Exception e) {
            Debug.logwingW("pinning fail : " + e.getMessage());
        }
    }

    public SSLContext getSSLContext() {
        return this.sslContext;
    }

    private CertificateManager() {
        pinningSystemCA();
    }
}
