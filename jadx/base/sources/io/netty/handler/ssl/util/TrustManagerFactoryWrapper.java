package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class TrustManagerFactoryWrapper extends SimpleTrustManagerFactory {

    /* JADX INFO: renamed from: tm */
    private final TrustManager f8954tm;

    public TrustManagerFactoryWrapper(TrustManager trustManager) {
        this.f8954tm = (TrustManager) ObjectUtil.checkNotNull(trustManager, "tm");
    }

    @Override // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public TrustManager[] engineGetTrustManagers() {
        return new TrustManager[]{this.f8954tm};
    }

    @Override // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public void engineInit(KeyStore keyStore) {
    }

    @Override // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public void engineInit(ManagerFactoryParameters managerFactoryParameters) {
    }
}
