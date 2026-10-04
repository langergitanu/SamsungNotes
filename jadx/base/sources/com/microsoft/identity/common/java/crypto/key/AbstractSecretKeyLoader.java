package com.microsoft.identity.common.java.crypto.key;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import cz.msebera.android.httpclient.extras.Base64;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSecretKeyLoader {
    private static final String TAG = "AbstractSecretKeyLoader";

    public SecretKey deserializeSecretKey(@NonNull String str) {
        if (str != null) {
            return generateKeyFromRawBytes(Base64.decode(str, 0));
        }
        throw new NullPointerException("serializedKey is marked non-null but is null");
    }

    @NonNull
    public SecretKey generateKeyFromRawBytes(@NonNull byte[] bArr) {
        if (bArr != null) {
            return new SecretKeySpec(bArr, getKeySpecAlgorithm());
        }
        throw new NullPointerException("rawBytes is marked non-null but is null");
    }

    @NonNull
    public SecretKey generateRandomKey() throws ClientException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(getKeySpecAlgorithm());
            keyGenerator.init(getKeySize(), new SecureRandom());
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            ClientException clientException = new ClientException("no_such_algorithm", e.getMessage(), e);
            Logger.error(AbstractC0622a.m1170p(TAG, ":generateRandomKey", new StringBuilder()), clientException.getErrorCode(), e);
            throw clientException;
        }
    }

    @NonNull
    public abstract String getAlias();

    @NonNull
    public abstract String getCipherAlgorithm();

    @NonNull
    public abstract SecretKey getKey();

    public abstract int getKeySize();

    @NonNull
    public abstract String getKeySpecAlgorithm();

    @NonNull
    public abstract String getKeyTypeIdentifier();

    public String serializeSecretKey(@NonNull SecretKey secretKey) {
        if (secretKey != null) {
            return Base64.encodeToString(secretKey.getEncoded(), 0);
        }
        throw new NullPointerException("key is marked non-null but is null");
    }
}
