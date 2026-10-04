package com.microsoft.identity.common.internal.platform;

import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.NonNull;
import com.microsoft.identity.common.java.crypto.Algorithm;
import com.microsoft.identity.common.java.crypto.CryptoSuite;
import com.microsoft.identity.common.java.crypto.SigningAlgorithm;
import com.microsoft.identity.common.java.crypto.SymmetricAlgorithm;
import com.microsoft.identity.common.java.crypto.key.KeyUtil;
import java.security.KeyStore;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum SymmetricCipher implements CryptoSuite {
    AES_GCM_NONE_HMACSHA256(SymmetricAlgorithm.Builder.m4629of("AES/GCM/NoPadding"), KeyUtil.HMAC_ALGORITHM, 256) { // from class: com.microsoft.identity.common.internal.platform.SymmetricCipher.1
        @Override // com.microsoft.identity.common.internal.platform.SymmetricCipher
        public KeyGenParameterSpec.Builder decorateKeyGenerator(@NonNull KeyGenParameterSpec.Builder builder) {
            return builder.setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(keySize());
        }
    };

    int mKeySize;
    String mMacString;
    SymmetricAlgorithm mValue;

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public Algorithm cipher() {
        return this.mValue;
    }

    @NonNull
    public abstract KeyGenParameterSpec.Builder decorateKeyGenerator(@NonNull KeyGenParameterSpec.Builder builder);

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public boolean isAsymmetric() {
        return false;
    }

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public Class<? extends KeyStore.Entry> keyClass() {
        return KeyStore.SecretKeyEntry.class;
    }

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public int keySize() {
        return this.mKeySize;
    }

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public String macName() {
        return this.mMacString;
    }

    @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
    public SigningAlgorithm signingAlgorithm() {
        return null;
    }

    SymmetricCipher(@NonNull SymmetricAlgorithm symmetricAlgorithm, @NonNull String str, int i) {
        this.mValue = symmetricAlgorithm;
        this.mMacString = str;
        this.mKeySize = i;
    }
}
