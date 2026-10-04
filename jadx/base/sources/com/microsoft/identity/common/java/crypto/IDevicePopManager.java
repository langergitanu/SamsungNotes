package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.crypto.AsymmetricAlgorithm;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import java.net.URL;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Date;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IDevicePopManager {
    public static final String MGF_1 = "MGF1";
    public static final String SHA_1 = "SHA-1";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Cipher implements AsymmetricAlgorithm {
        RSA_ECB_PKCS1_PADDING("RSA/ECB/PKCS1Padding"),
        RSA_NONE_OAEPWithSHA_1AndMGF1Padding("RSA/NONE/OAEPWithSHA-1AndMGF1Padding") { // from class: com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher.1
            @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher
            public AlgorithmParameterSpec getParameters() {
                return new OAEPParameterSpec(IDevicePopManager.SHA_1, IDevicePopManager.MGF_1, new MGF1ParameterSpec(IDevicePopManager.SHA_1), PSource.PSpecified.DEFAULT);
            }
        },
        RSA_ECB_OAEPWithSHA_1AndMGF1Padding("RSA/ECB/OAEPWithSHA-1AndMGF1Padding") { // from class: com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher.2
            @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher
            public AlgorithmParameterSpec getParameters() {
                return new OAEPParameterSpec(IDevicePopManager.SHA_1, IDevicePopManager.MGF_1, new MGF1ParameterSpec(IDevicePopManager.SHA_1), PSource.PSpecified.DEFAULT);
            }
        },
        RSA_ECB_OAEPWithSHA_256AndMGF1Padding("RSA/ECB/OAEPWithSHA-256AndMGF1Padding") { // from class: com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher.3
            @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager.Cipher
            public AlgorithmParameterSpec getParameters() {
                return new OAEPParameterSpec("SHA-256", IDevicePopManager.MGF_1, new MGF1ParameterSpec(IDevicePopManager.SHA_1), PSource.PSpecified.DEFAULT);
            }
        };

        private final String mValue;

        public Algorithm cipherName() {
            return AsymmetricAlgorithm.Builder.m4628of(this.mValue);
        }

        public AlgorithmParameterSpec getParameters() {
            return null;
        }

        public boolean supportsShr() {
            return true;
        }

        @Override // java.lang.Enum
        @NonNull
        public String toString() {
            return this.mValue;
        }

        Cipher(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("value is marked non-null but is null");
            }
            this.mValue = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PublicKeyFormat {
        X_509_SubjectPublicKeyInfo_ASN_1,
        JWK
    }

    boolean asymmetricKeyExists();

    boolean asymmetricKeyExists(String str);

    boolean clearAsymmetricKey();

    String decrypt(Cipher cipher, String str);

    byte[] decrypt(@NonNull Cipher cipher, byte[] bArr);

    String encrypt(Cipher cipher, String str);

    byte[] encrypt(@NonNull Cipher cipher, @NonNull byte[] bArr);

    String generateAsymmetricKey();

    void generateAsymmetricKey(TaskCompletedCallbackWithError<String, ClientException> taskCompletedCallbackWithError);

    Date getAsymmetricKeyCreationDate();

    String getAsymmetricKeyThumbprint();

    Certificate[] getCertificateChain();

    IKeyStoreKeyManager<KeyStore.PrivateKeyEntry> getKeyManager();

    String getPublicKey(PublicKeyFormat publicKeyFormat);

    PublicKey getPublicKey();

    String getRequestConfirmation();

    void getRequestConfirmation(TaskCompletedCallbackWithError<String, ClientException> taskCompletedCallbackWithError);

    SecureHardwareState getSecureHardwareState();

    String mintSignedAccessToken(String str, long j, URL url, String str2, String str3);

    String mintSignedAccessToken(String str, long j, URL url, String str2, String str3, String str4);

    String mintSignedHttpRequest(String str, long j, URL url, String str2, String str3);

    String sign(SigningAlgorithm signingAlgorithm, String str);

    byte[] sign(@NonNull SigningAlgorithm signingAlgorithm, byte[] bArr);

    boolean verify(SigningAlgorithm signingAlgorithm, String str, String str2);

    boolean verify(@NonNull SigningAlgorithm signingAlgorithm, byte[] bArr, byte[] bArr2);
}
