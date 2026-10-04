package io.netty.handler.ssl;

import java.security.cert.Certificate;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
interface OpenSslSession extends SSLSession {
    OpenSslSessionContext getSessionContext();

    void handshakeFinished(byte[] bArr, String str, String str2, byte[] bArr2, byte[][] bArr3, long j, long j2);

    OpenSslSessionId sessionId();

    void setLocalCertificate(Certificate[] certificateArr);

    void setSessionId(OpenSslSessionId openSslSessionId);

    void tryExpandApplicationBufferSize(int i);
}
