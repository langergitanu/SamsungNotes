package com.google.api.client.googleapis.apache;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.http.apache.ApacheHttpTransport;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class GoogleApacheHttpTransport {
    private GoogleApacheHttpTransport() {
    }

    public static ApacheHttpTransport newTrustedTransport() {
        return new ApacheHttpTransport.Builder().trustCertificates(GoogleUtils.getCertificateTrustStore()).build();
    }
}
