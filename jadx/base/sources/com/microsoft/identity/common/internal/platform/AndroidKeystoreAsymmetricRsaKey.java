package com.microsoft.identity.common.internal.platform;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import com.microsoft.identity.common.java.crypto.SigningAlgorithm;
import java.security.cert.Certificate;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidKeystoreAsymmetricRsaKey implements AsymmetricRsaKey {

    @RequiresApi(api = 18)
    public static final IDevicePopManager.Cipher RSA_ECB_PKCS_1_PADDING = IDevicePopManager.Cipher.RSA_ECB_PKCS1_PADDING;

    @RequiresApi(api = 18)
    public static final SigningAlgorithm SHA_256_WITH_RSA = SigningAlgorithm.SHA_256_WITH_RSA;
    private final String mAlias;
    private final IDevicePopManager mDevicePopManager;

    public AndroidKeystoreAsymmetricRsaKey(@NonNull IDevicePopManager iDevicePopManager, @NonNull String str) {
        this.mDevicePopManager = iDevicePopManager;
        this.mAlias = str;
        if (iDevicePopManager.asymmetricKeyExists()) {
            return;
        }
        iDevicePopManager.generateAsymmetricKey();
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    @RequiresApi(api = 18)
    public String decrypt(@NonNull String str) {
        return this.mDevicePopManager.decrypt(RSA_ECB_PKCS_1_PADDING, str);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    @RequiresApi(api = 18)
    public String encrypt(@NonNull String str) {
        return this.mDevicePopManager.encrypt(RSA_ECB_PKCS_1_PADDING, str);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    public String getAlias() {
        return this.mAlias;
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    public Certificate[] getCertificateChain() {
        return this.mDevicePopManager.getCertificateChain();
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    public Date getCreatedOn() {
        return this.mDevicePopManager.getAsymmetricKeyCreationDate();
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    public String getPublicKey() {
        return this.mDevicePopManager.getPublicKey(IDevicePopManager.PublicKeyFormat.JWK);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    public SecureHardwareState getSecureHardwareState() {
        return this.mDevicePopManager.getSecureHardwareState();
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    public String getThumbprint() {
        return this.mDevicePopManager.getAsymmetricKeyThumbprint();
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    @RequiresApi(api = 18)
    public String sign(@NonNull String str) {
        return this.mDevicePopManager.sign(SHA_256_WITH_RSA, str);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKey, com.microsoft.identity.common.internal.platform.AsymmetricKey
    @RequiresApi(api = 18)
    public boolean verify(@NonNull String str, @NonNull String str2) {
        return this.mDevicePopManager.verify(SHA_256_WITH_RSA, str, str2);
    }

    @Override // com.microsoft.identity.common.internal.platform.Key
    @RequiresApi(api = 18)
    public byte[] decrypt(byte[] bArr) {
        return this.mDevicePopManager.encrypt(RSA_ECB_PKCS_1_PADDING, bArr);
    }

    @Override // com.microsoft.identity.common.internal.platform.Key
    @RequiresApi(api = 18)
    public byte[] encrypt(byte[] bArr) {
        return this.mDevicePopManager.encrypt(RSA_ECB_PKCS_1_PADDING, bArr);
    }

    @Override // com.microsoft.identity.common.internal.platform.Key
    @RequiresApi(api = 18)
    public byte[] sign(byte[] bArr) {
        return this.mDevicePopManager.sign(SHA_256_WITH_RSA, bArr);
    }

    @Override // com.microsoft.identity.common.internal.platform.Key
    @RequiresApi(api = 18)
    public boolean verify(byte[] bArr, byte[] bArr2) {
        return this.mDevicePopManager.verify(SHA_256_WITH_RSA, bArr, bArr2);
    }
}
