package com.microsoft.identity.common.crypto;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.java.crypto.StorageEncryptionManager;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader;
import com.microsoft.identity.common.java.crypto.key.PredefinedKeyLoader;
import com.microsoft.identity.common.logging.Logger;
import java.util.Collections;
import java.util.List;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidAuthSdkStorageEncryptionManager extends StorageEncryptionManager {
    private static final String TAG = "AndroidAuthSdkStorageEncryptionManager";
    public static final String WRAPPED_KEY_FILE_NAME = "adalks";
    public static final String WRAPPING_KEY_ALIAS = "AdalKey";
    private final AndroidWrappedKeyLoader mKeyStoreKeyLoader;
    private final PredefinedKeyLoader mPredefinedKeyLoader;

    public AndroidAuthSdkStorageEncryptionManager(@NonNull Context context) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        AuthenticationSettings authenticationSettings = AuthenticationSettings.INSTANCE;
        if (authenticationSettings.getSecretKeyData() == null) {
            this.mPredefinedKeyLoader = null;
        } else {
            this.mPredefinedKeyLoader = new PredefinedKeyLoader("USER_DEFINED_KEY", authenticationSettings.getSecretKeyData());
        }
        this.mKeyStoreKeyLoader = new AndroidWrappedKeyLoader(WRAPPING_KEY_ALIAS, WRAPPED_KEY_FILE_NAME, context);
    }

    @Override // com.microsoft.identity.common.java.crypto.StorageEncryptionManager
    @NonNull
    public List<AbstractSecretKeyLoader> getKeyLoaderForDecryption(byte[] bArr) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getKeyLoaderForDecryption", new StringBuilder());
        String keyIdentifierFromCipherText = StorageEncryptionManager.getKeyIdentifierFromCipherText(bArr);
        if ("U001".equalsIgnoreCase(keyIdentifierFromCipherText)) {
            PredefinedKeyLoader predefinedKeyLoader = this.mPredefinedKeyLoader;
            if (predefinedKeyLoader != null) {
                return Collections.singletonList(predefinedKeyLoader);
            }
            throw new IllegalStateException("Cipher Text is encrypted by USER_PROVIDED_KEY_IDENTIFIER, but mPredefinedKeyLoader is null.");
        }
        if ("A001".equalsIgnoreCase(keyIdentifierFromCipherText)) {
            return Collections.singletonList(this.mKeyStoreKeyLoader);
        }
        Logger.warn(strM1170p, "Cannot find a matching key to decrypt the given blob. Key Identifier = " + keyIdentifierFromCipherText);
        return Collections.EMPTY_LIST;
    }

    @Override // com.microsoft.identity.common.java.crypto.StorageEncryptionManager
    @NonNull
    public AES256KeyLoader getKeyLoaderForEncryption() {
        PredefinedKeyLoader predefinedKeyLoader = this.mPredefinedKeyLoader;
        return predefinedKeyLoader != null ? predefinedKeyLoader : this.mKeyStoreKeyLoader;
    }
}
