package com.samsung.android.kmxservice.sdk.e2ee.manager;

import com.samsung.android.kmxservice.sdk.e2ee.data.MemberKeyInfo;
import java.security.cert.X509Certificate;
import kotlin.Triple;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface DeviceKeyManagement {
    Triple<byte[], byte[], X509Certificate[]> getDeviceKey();

    String getDeviceKeyId();

    MemberKeyInfo getDeviceKeyPQC();

    boolean removeDeviceKey(String str);
}
