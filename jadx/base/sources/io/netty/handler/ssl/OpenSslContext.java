package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class OpenSslContext extends ReferenceCountedOpenSslContext {
    public OpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, int i, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z, boolean z2, Map.Entry<SslContextOption<?>, Object>... entryArr) {
        super(iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), i, certificateArr, clientAuth, strArr, z, z2, false, entryArr);
    }

    public final void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    public final SSLEngine newEngine0(ByteBufAllocator byteBufAllocator, String str, int i, boolean z) {
        return new OpenSslEngine(this, byteBufAllocator, str, i, z);
    }

    public OpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, int i, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z, boolean z2, Map.Entry<SslContextOption<?>, Object>... entryArr) {
        super(iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, i, certificateArr, clientAuth, strArr, z, z2, false, entryArr);
    }
}
