package io.grpc.netty;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.TrustManagerFactorySpi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class FixedTrustManagerFactory extends TrustManagerFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FixedTrustManagerFactorySpi extends TrustManagerFactorySpi {
        private final List<TrustManager> trustManagers;

        public FixedTrustManagerFactorySpi(List<TrustManager> list) {
            this.trustManagers = Collections.unmodifiableList(new ArrayList(list));
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        public TrustManager[] engineGetTrustManagers() {
            return (TrustManager[]) this.trustManagers.toArray(new TrustManager[0]);
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        public void engineInit(KeyStore keyStore) {
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        public void engineInit(ManagerFactoryParameters managerFactoryParameters) {
        }
    }

    public FixedTrustManagerFactory(List<TrustManager> list) {
        super(new FixedTrustManagerFactorySpi(list), new UnhelpfulSecurityProvider(), "FakeAlgorithm");
    }
}
