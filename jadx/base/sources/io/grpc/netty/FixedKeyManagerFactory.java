package io.grpc.netty;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class FixedKeyManagerFactory extends KeyManagerFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FixedKeyManagerFactorySpi extends KeyManagerFactorySpi {
        private final List<KeyManager> keyManagers;

        public FixedKeyManagerFactorySpi(List<KeyManager> list) {
            this.keyManagers = Collections.unmodifiableList(new ArrayList(list));
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        public KeyManager[] engineGetKeyManagers() {
            return (KeyManager[]) this.keyManagers.toArray(new KeyManager[0]);
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        public void engineInit(KeyStore keyStore, char[] cArr) {
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        public void engineInit(ManagerFactoryParameters managerFactoryParameters) {
        }
    }

    public FixedKeyManagerFactory(List<KeyManager> list) {
        super(new FixedKeyManagerFactorySpi(list), new UnhelpfulSecurityProvider(), "FakeAlgorithm");
    }
}
