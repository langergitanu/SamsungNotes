package com.samsung.scsp.pam.kps.lite;

import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface KeyManagementLite {
    String getServiceKeyId(String str);

    X509Certificate[] getWrapKey(String str);

    default void onJoinCompleted(String str) {
    }

    default void onKeySyncCompleted() {
    }

    default void onKeySyncStarted() {
    }

    default void onLeaveCompleted(String str) {
    }

    String setServiceKey(String str, String str2, byte[] bArr);
}
