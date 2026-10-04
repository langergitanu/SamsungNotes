package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.ManagerFactoryParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class KeyManagerFactoryWrapper extends SimpleKeyManagerFactory {

    /* JADX INFO: renamed from: km */
    private final KeyManager f8953km;

    public KeyManagerFactoryWrapper(KeyManager keyManager) {
        this.f8953km = (KeyManager) ObjectUtil.checkNotNull(keyManager, "km");
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public KeyManager[] engineGetKeyManagers() {
        return new KeyManager[]{this.f8953km};
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public void engineInit(KeyStore keyStore, char[] cArr) {
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public void engineInit(ManagerFactoryParameters managerFactoryParameters) {
    }
}
