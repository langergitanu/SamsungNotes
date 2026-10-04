package org.conscrypt;

import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
interface ConscryptSession extends SSLSession {
    String getApplicationProtocol();

    @Override // javax.net.ssl.SSLSession
    X509Certificate[] getPeerCertificates();

    byte[] getPeerSignedCertificateTimestamp();

    String getRequestedServerName();

    List<byte[]> getStatusResponses();
}
