package com.microsoft.identity.common.internal.platform;

import androidx.annotation.RequiresApi;
import com.microsoft.identity.common.java.crypto.AsymmetricAlgorithm;
import com.microsoft.identity.common.java.crypto.CryptoSuite;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.crypto.SigningAlgorithm;
import com.microsoft.identity.common.java.crypto.key.KeyUtil;
import java.security.KeyStore;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum AsymmetricCipher implements CryptoSuite {
    RSA_NONE_OAEPWithSHA_1AndMGF1PaddingAndHmacSha256 { // from class: com.microsoft.identity.common.internal.platform.AsymmetricCipher.1
        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        public boolean isAsymmetric() {
            return true;
        }

        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        public Class<? extends KeyStore.Entry> keyClass() {
            return KeyStore.PrivateKeyEntry.class;
        }

        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        public int keySize() {
            return 2048;
        }

        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        public String macName() {
            return KeyUtil.HMAC_ALGORITHM;
        }

        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        @RequiresApi(api = 18)
        public SigningAlgorithm signingAlgorithm() {
            return SigningAlgorithm.SHA_256_WITH_RSA;
        }

        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        public AsymmetricAlgorithm cipher() {
            return IDevicePopManager.Cipher.RSA_NONE_OAEPWithSHA_1AndMGF1Padding;
        }
    },
    RSA_ECB_PKCS1_PADDING_HMACSHA256 { // from class: com.microsoft.identity.common.internal.platform.AsymmetricCipher.2
        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        public boolean isAsymmetric() {
            return true;
        }

        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        public Class<? extends KeyStore.Entry> keyClass() {
            return KeyStore.PrivateKeyEntry.class;
        }

        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        public int keySize() {
            return 2048;
        }

        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        public String macName() {
            return KeyUtil.HMAC_ALGORITHM;
        }

        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        @RequiresApi(api = 18)
        public SigningAlgorithm signingAlgorithm() {
            return SigningAlgorithm.SHA_256_WITH_RSA;
        }

        @Override // com.microsoft.identity.common.java.crypto.CryptoSuite
        public AsymmetricAlgorithm cipher() {
            return AsymmetricAlgorithm.Builder.m4628of("RSA/ECB/PKCS1Padding");
        }
    }
}
