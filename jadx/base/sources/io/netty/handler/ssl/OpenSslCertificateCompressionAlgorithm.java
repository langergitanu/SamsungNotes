package io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface OpenSslCertificateCompressionAlgorithm {
    int algorithmId();

    byte[] compress(SSLEngine sSLEngine, byte[] bArr);

    byte[] decompress(SSLEngine sSLEngine, int i, byte[] bArr);
}
