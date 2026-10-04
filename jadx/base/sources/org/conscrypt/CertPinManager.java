package org.conscrypt;

import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface CertPinManager {
    void checkChainPinning(String str, List<X509Certificate> list);
}
