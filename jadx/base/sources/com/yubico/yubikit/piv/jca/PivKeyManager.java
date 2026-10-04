package com.yubico.yubikit.piv.jca;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.X509ExtendedKeyManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PivKeyManager extends X509ExtendedKeyManager {
    private final X509Certificate[] certificates;
    private final PivPrivateKey privateKey;

    public PivKeyManager(PivPrivateKey pivPrivateKey, X509Certificate[] x509CertificateArr) {
        this.privateKey = pivPrivateKey;
        this.certificates = (X509Certificate[]) Arrays.copyOf(x509CertificateArr, x509CertificateArr.length);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        return "YKPiv";
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        return "YKPiv";
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String str) {
        X509Certificate[] x509CertificateArr = this.certificates;
        return (X509Certificate[]) Arrays.copyOf(x509CertificateArr, x509CertificateArr.length);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String str, Principal[] principalArr) {
        return new String[]{"YKPiv"};
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String str) {
        return this.privateKey;
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String str, Principal[] principalArr) {
        return new String[]{"YKPiv"};
    }
}
