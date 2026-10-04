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
public class DefaultCryptoFactory implements ICryptoFactory {
    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    @NonNull
    public Cipher getCipher(@NonNull String str) {
        if (str != null) {
            return ProviderFactory.getCipher(str, null);
        }
        throw new NullPointerException("algorithm is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    @NonNull
    public KeyFactory getKeyFactory(@NonNull String str) {
        if (str != null) {
            return ProviderFactory.getKeyFactory(str, null);
        }
        throw new NullPointerException("algorithm is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    @NonNull
    public KeyPairGenerator getKeyPairGenerator(@NonNull String str) {
        if (str != null) {
            return ProviderFactory.getKeyPairGenerator(str, null);
        }
        throw new NullPointerException("algorithm is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    @NonNull
    public Mac getMac(@NonNull String str) {
        if (str != null) {
            return ProviderFactory.getMac(str, null);
        }
        throw new NullPointerException("algorithm is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    @NonNull
    public Signature getSignature(@NonNull String str) {
        if (str != null) {
            return ProviderFactory.getSignature(str, null);
        }
        throw new NullPointerException("algorithm is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.ICryptoFactory
    @NonNull
    public CryptoFactoryName getTelemetryClassName() {
        return CryptoFactoryName.DefaultCryptoFactory;
    }
}
