package com.microsoft.identity.common.java.crypto;

import java.security.cert.Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IKeyAccessor {
    byte[] decrypt(byte[] bArr);

    byte[] encrypt(byte[] bArr);

    IKeyAccessor generateDerivedKey(byte[] bArr, byte[] bArr2, CryptoSuite cryptoSuite);

    Certificate[] getCertificateChain();

    SecureHardwareState getSecureHardwareState();

    byte[] getThumbprint();

    byte[] sign(byte[] bArr);

    boolean verify(byte[] bArr, byte[] bArr2);
}
