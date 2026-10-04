package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.opentelemetry.CryptoFactoryName;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICryptoFactory {
    @NonNull
    Cipher getCipher(@NonNull String str);

    @NonNull
    KeyFactory getKeyFactory(@NonNull String str);

    @NonNull
    KeyPairGenerator getKeyPairGenerator(@NonNull String str);

    @NonNull
    Mac getMac(@NonNull String str);

    @NonNull
    Signature getSignature(@NonNull String str);

    @NonNull
    CryptoFactoryName getTelemetryClassName();
}
