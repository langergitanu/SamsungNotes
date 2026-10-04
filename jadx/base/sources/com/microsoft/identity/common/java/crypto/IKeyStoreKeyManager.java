package com.microsoft.identity.common.java.crypto;

import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IKeyStoreKeyManager<K extends KeyStore.Entry> {
    boolean clear();

    boolean exists();

    Certificate[] getCertificateChain();

    Date getCreationDate();

    K getEntry();

    String getKeyAlias();

    SecureHardwareState getSecureHardwareState();

    byte[] getThumbprint();

    boolean hasThumbprint(byte[] bArr);

    void importKey(byte[] bArr, String str);

    void storeAsymmetricKey(PrivateKey privateKey, Certificate[] certificateArr);
}
