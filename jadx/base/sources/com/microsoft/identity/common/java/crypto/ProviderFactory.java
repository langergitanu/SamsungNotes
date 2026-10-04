package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import javax.annotation.Nullable;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ProviderFactory {
    @NonNull
    public static Cipher getCipher(@NonNull String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            return provider != null ? Cipher.getInstance(str, provider) : Cipher.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        } catch (NoSuchPaddingException e2) {
            throw new ClientException(ClientException.NO_SUCH_PADDING, e2.getMessage(), e2);
        }
    }

    @NonNull
    public static KeyFactory getKeyFactory(@NonNull String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            return provider != null ? KeyFactory.getInstance(str, provider) : KeyFactory.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        }
    }

    @NonNull
    public static KeyPairGenerator getKeyPairGenerator(@NonNull String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            return provider != null ? KeyPairGenerator.getInstance(str, provider) : KeyPairGenerator.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        }
    }

    @NonNull
    public static Mac getMac(@NonNull String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            return provider != null ? Mac.getInstance(str, provider) : Mac.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        }
    }

    @NonNull
    public static Signature getSignature(@NonNull String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            return provider != null ? Signature.getInstance(str, provider) : Signature.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        }
    }
}
