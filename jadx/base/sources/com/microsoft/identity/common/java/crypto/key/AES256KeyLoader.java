package com.microsoft.identity.common.java.crypto.key;

import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AES256KeyLoader extends AbstractSecretKeyLoader {
    public static final String AES_ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final int KEY_SIZE = 256;
    private static final String TAG = "AES256KeyLoader";

    @Override // com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader
    @NonNull
    public String getCipherAlgorithm() {
        return CIPHER_ALGORITHM;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader
    public int getKeySize() {
        return 256;
    }

    @Override // com.microsoft.identity.common.java.crypto.key.AbstractSecretKeyLoader
    @NonNull
    public String getKeySpecAlgorithm() {
        return AES_ALGORITHM;
    }
}
