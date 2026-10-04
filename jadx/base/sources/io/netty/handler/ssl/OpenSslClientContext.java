package io.netty.handler.ssl;

import java.io.File;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class OpenSslClientContext extends OpenSslContext {
    private final OpenSslSessionContext sessionContext;

    @Deprecated
    public OpenSslClientContext() {
        this(null, null, null, null, null, null, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
    }

    @Deprecated
    public OpenSslClientContext(File file) {
        this(file, null);
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext, io.netty.handler.ssl.SslContext
    public OpenSslSessionContext sessionContext() {
        return this.sessionContext;
    }

    @Deprecated
    public OpenSslClientContext(TrustManagerFactory trustManagerFactory) {
        this(null, trustManagerFactory);
    }

    @Deprecated
    public OpenSslClientContext(File file, TrustManagerFactory trustManagerFactory) {
        this(file, trustManagerFactory, null, null, null, null, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
    }

    @Deprecated
    public OpenSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) {
        this(file, trustManagerFactory, null, null, null, null, iterable, IdentityCipherSuiteFilter.INSTANCE, applicationProtocolConfig, j, j2);
    }

    @Deprecated
    public OpenSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) {
        this(file, trustManagerFactory, null, null, null, null, iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2);
    }

    @Deprecated
    public OpenSslClientContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) {
        this(SslContext.toX509CertificatesInternal(file), trustManagerFactory, SslContext.toX509CertificatesInternal(file2), SslContext.toPrivateKeyInternal(file3, str), str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, null, j, j2, false, KeyStore.getDefaultType(), new Map.Entry[0]);
    }

    public OpenSslClientContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j, long j2, boolean z, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) {
        super(iterable, cipherSuiteFilter, applicationProtocolConfig, 0, (Certificate[]) x509CertificateArr2, ClientAuth.NONE, strArr, false, z, entryArr);
        try {
            OpenSslKeyMaterialProvider.validateKeyMaterialSupported(x509CertificateArr2, privateKey, str);
            this.sessionContext = ReferenceCountedOpenSslClientContext.newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, str2, j, j2);
        } catch (Throwable th) {
            release();
            throw th;
        }
    }
}
