package com.microsoft.identity.common.java.challengehandlers;

import java.security.cert.X509Certificate;
import java.util.List;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IDeviceCertificate {
    @NonNull
    X509Certificate getX509();

    boolean isValidIssuer(List<String> list);

    byte[] sign(@NonNull String str, byte[] bArr);
}
