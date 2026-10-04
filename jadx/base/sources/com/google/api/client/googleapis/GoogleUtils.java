package com.google.api.client.googleapis;

import com.google.api.client.util.SecurityUtils;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.security.KeyStore;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class GoogleUtils {
    static KeyStore certTrustStore;
    public static final Integer MAJOR_VERSION = 1;
    public static final Integer MINOR_VERSION = 22;
    public static final Integer BUGFIX_VERSION = 0;
    public static final String VERSION = (((Object) 1) + Extension.DOT + ((Object) 22) + Extension.DOT + ((Object) 0) + "").toString();

    private GoogleUtils() {
    }

    public static synchronized KeyStore getCertificateTrustStore() {
        try {
            if (certTrustStore == null) {
                certTrustStore = SecurityUtils.getJavaKeyStore();
                SecurityUtils.loadKeyStore(certTrustStore, GoogleUtils.class.getResourceAsStream("google.jks"), "notasecret");
            }
        } catch (Throwable th) {
            throw th;
        }
        return certTrustStore;
    }
}
