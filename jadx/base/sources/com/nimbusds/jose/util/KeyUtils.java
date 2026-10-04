package com.nimbusds.jose.util;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class KeyUtils {
    private KeyUtils() {
    }

    public static SecretKey toAESKey(final SecretKey secretKey) {
        return (secretKey == null || secretKey.getAlgorithm().equals(AES256KeyLoader.AES_ALGORITHM)) ? secretKey : new SecretKey() { // from class: com.nimbusds.jose.util.KeyUtils.1
            @Override // java.security.Key
            public String getAlgorithm() {
                return AES256KeyLoader.AES_ALGORITHM;
            }

            @Override // java.security.Key
            public byte[] getEncoded() {
                return secretKey.getEncoded();
            }

            @Override // java.security.Key
            public String getFormat() {
                return secretKey.getFormat();
            }
        };
    }
}
