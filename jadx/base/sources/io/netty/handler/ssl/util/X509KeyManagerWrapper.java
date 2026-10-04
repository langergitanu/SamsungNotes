package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class X509KeyManagerWrapper extends X509ExtendedKeyManager {
    private final X509KeyManager delegate;

    public X509KeyManagerWrapper(X509KeyManager x509KeyManager) {
        this.delegate = (X509KeyManager) ObjectUtil.checkNotNull(x509KeyManager, "delegate");
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        return this.delegate.chooseClientAlias(strArr, principalArr, socket);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        return this.delegate.chooseClientAlias(strArr, principalArr, null);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
        return this.delegate.chooseServerAlias(str, principalArr, null);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        return this.delegate.chooseServerAlias(str, principalArr, socket);
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String str) {
        return this.delegate.getCertificateChain(str);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String str, Principal[] principalArr) {
        return this.delegate.getClientAliases(str, principalArr);
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String str) {
        return this.delegate.getPrivateKey(str);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String str, Principal[] principalArr) {
        return this.delegate.getServerAliases(str, principalArr);
    }
}
