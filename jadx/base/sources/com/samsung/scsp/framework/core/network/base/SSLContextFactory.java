package com.samsung.scsp.framework.core.network.base;

import com.samsung.scsp.error.FaultBarrier;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SSLContextFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final SSLContext sslContext = (SSLContext) FaultBarrier.get(new C11681k(), null).obj;

        private LazyHolder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ SSLContext lambda$static$0() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, KeyManagementException {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            KeyStore keyStore2 = KeyStore.getInstance("AndroidCAStore");
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
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            return sSLContext;
        }
    }

    public static SSLContext get() {
        return LazyHolder.sslContext;
    }
}
