package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import java.security.cert.Certificate;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface AsymmetricKey extends Key {
    String decrypt(String str);

    String encrypt(String str);

    String getAlias();

    Certificate[] getCertificateChain();

    Date getCreatedOn();

    String getPublicKey();

    SecureHardwareState getSecureHardwareState();

    String getThumbprint();

    String sign(String str);

    boolean verify(String str, String str2);
}
