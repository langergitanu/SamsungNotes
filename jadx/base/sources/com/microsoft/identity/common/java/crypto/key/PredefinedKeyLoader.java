package com.microsoft.identity.common.java.crypto.key;

import javax.crypto.SecretKey;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PredefinedKeyLoader extends AES256KeyLoader {
    public static final String USER_PROVIDED_KEY_IDENTIFIER = "U001";
    private final String mAlias;
    private final SecretKey mKey;

    public PredefinedKeyLoader(@NonNull String str, @NonNull byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        if (bArr == null) {
            throw new NullPointerException("rawBytes is marked non-null but is null");
        }
        this.mAlias = str;
        this.mKey = generateKeyFromRawBytes(bArr);
    }

    @Override // com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader
    @NonNull
    public String getAlias() {
        return this.mAlias;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader
    @NonNull
    public SecretKey getKey() {
        return this.mKey;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader
    @NonNull
    public String getKeyTypeIdentifier() {
        return "U001";
    }
}
