package com.microsoft.identity.common.crypto;

import android.annotation.TargetApi;
import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.util.AndroidKeyStoreUtil;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.microsoft.identity.common.java.crypto.key.KeyUtil;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.util.CachedData;
import com.microsoft.identity.common.java.util.FileUtil;
import com.microsoft.identity.common.logging.Logger;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.Locale;
import javax.crypto.SecretKey;
import javax.security.auth.x500.X500Principal;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@TargetApi(18)
public class AndroidWrappedKeyLoader extends AES256KeyLoader {
    static final int KEY_FILE_SIZE = 1024;
    private static final String TAG = "AndroidWrappedKeyLoader#";
    public static final String WRAPPED_KEY_KEY_IDENTIFIER = "A001";
    private static final String WRAP_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final String WRAP_KEY_ALGORITHM = "RSA";

    @SuppressFBWarnings({"MS_SHOULD_BE_FINAL"})
    public static boolean sSkipKeyInvalidationCheck = false;
    private final String mAlias;
    private final Context mContext;
    private final String mFilePath;
    private final CachedData<SecretKey> mKeyCache = new CachedData<SecretKey>() { // from class: com.microsoft.identity.common.crypto.AndroidWrappedKeyLoader.1
        @Override // com.microsoft.identity.common.java.util.CachedData
        public SecretKey getData() {
            if (!AndroidWrappedKeyLoader.sSkipKeyInvalidationCheck && (!AndroidKeyStoreUtil.canLoadKey(AndroidWrappedKeyLoader.this.mAlias) || !AndroidWrappedKeyLoader.this.getKeyFile().exists())) {
                clear();
            }
            return (SecretKey) super.getData();
        }
    };

    public AndroidWrappedKeyLoader(@NonNull String str, @NonNull String str2, @NonNull Context context) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("filePath is marked non-null but is null");
        }
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        this.mAlias = str;
        this.mFilePath = str2;
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getKeyFile() {
        Context context = this.mContext;
        return new File(context.getDir(context.getPackageName(), 0), this.mFilePath);
    }

    @RequiresApi(api = 18)
    private static AlgorithmParameterSpec getSpecForKeyStoreKey(@NonNull Context context, @NonNull String str) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        Locale locale = Locale.ROOT;
        String strM774p = AbstractC0541b.m774p("CN=", str, ", OU=", context.getPackageName());
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(1, 100);
        return new KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new X500Principal(strM774p)).setSerialNumber(BigInteger.ONE).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
    }

    private void saveSecretKeyToStorage(@NonNull SecretKey secretKey) throws ClientException {
        if (secretKey == null) {
            throw new NullPointerException("unencryptedKey is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":saveSecretKeyToStorage", new StringBuilder());
        KeyPair key = AndroidKeyStoreUtil.readKey(this.mAlias);
        if (key == null) {
            Logger.info(strM1170p, "No existing keypair. Generating a new one.");
            key = AndroidKeyStoreUtil.generateKeyPair("RSA", getSpecForKeyStoreKey(this.mContext, this.mAlias));
        }
        FileUtil.writeDataToFile(AndroidKeyStoreUtil.wrap(secretKey, key, WRAP_ALGORITHM), getKeyFile());
    }

    public void deleteSecretKeyFromStorage() {
        AndroidKeyStoreUtil.deleteKey(this.mAlias);
        FileUtil.deleteFile(getKeyFile());
        this.mKeyCache.clear();
    }

    @Override // com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader
    @NonNull
    public SecretKey generateRandomKey() throws ClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":generateRandomKey", new StringBuilder());
        SecretKey secretKeyGenerateRandomKey = super.generateRandomKey();
        saveSecretKeyToStorage(secretKeyGenerateRandomKey);
        Logger.info(strM1170p, "New key is generated with thumbprint: " + KeyUtil.getKeyThumbPrint(secretKeyGenerateRandomKey));
        return secretKeyGenerateRandomKey;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader
    @NonNull
    public String getAlias() {
        return this.mAlias;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader
    @NonNull
    public synchronized SecretKey getKey() {
        SecretKey data;
        try {
            data = this.mKeyCache.getData();
            if (data == null) {
                data = readSecretKeyFromStorage();
            }
            if (data == null) {
                data = generateRandomKey();
            }
            this.mKeyCache.setData(data);
        } catch (Throwable th) {
            throw th;
        }
        return data;
    }

    @NonNull
    public CachedData<SecretKey> getKeyCache() {
        return this.mKeyCache;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader
    @NonNull
    public String getKeyTypeIdentifier() {
        return "A001";
    }

    @Nullable
    public SecretKey readSecretKeyFromStorage() throws ClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":readSecretKeyFromStorage", new StringBuilder());
        try {
            KeyPair key = AndroidKeyStoreUtil.readKey(this.mAlias);
            if (key == null) {
                Logger.info(strM1170p, "key does not exist in keystore");
                deleteSecretKeyFromStorage();
                return null;
            }
            byte[] fromFile = FileUtil.readFromFile(getKeyFile(), 1024);
            if (fromFile == null) {
                Logger.warn(strM1170p, "Key file is empty");
                FileUtil.deleteFile(getKeyFile());
                this.mKeyCache.clear();
                return null;
            }
            SecretKey secretKeyUnwrap = AndroidKeyStoreUtil.unwrap(fromFile, getKeySpecAlgorithm(), key, WRAP_ALGORITHM);
            Logger.info(strM1170p, "Key is loaded with thumbprint: " + KeyUtil.getKeyThumbPrint(secretKeyUnwrap));
            return secretKeyUnwrap;
        } catch (ClientException e) {
            Logger.warn(strM1170p, "Error when loading key from Storage, wipe all existing key data ");
            deleteSecretKeyFromStorage();
            throw e;
        }
    }
}
