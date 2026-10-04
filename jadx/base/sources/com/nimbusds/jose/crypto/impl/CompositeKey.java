package com.nimbusds.jose.crypto.impl;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.KeyLengthException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class CompositeKey {
    private final SecretKey encKey;
    private final SecretKey inputKey;
    private final SecretKey macKey;
    private final int truncatedMacLength;

    public CompositeKey(SecretKey secretKey) throws KeyLengthException {
        this.inputKey = secretKey;
        byte[] encoded = secretKey.getEncoded();
        if (encoded.length == 32) {
            this.macKey = new SecretKeySpec(encoded, 0, 16, "HMACSHA256");
            this.encKey = new SecretKeySpec(encoded, 16, 16, AES256KeyLoader.AES_ALGORITHM);
            this.truncatedMacLength = 16;
        } else if (encoded.length == 48) {
            this.macKey = new SecretKeySpec(encoded, 0, 24, "HMACSHA384");
            this.encKey = new SecretKeySpec(encoded, 24, 24, AES256KeyLoader.AES_ALGORITHM);
            this.truncatedMacLength = 24;
        } else {
            if (encoded.length != 64) {
                throw new KeyLengthException("Unsupported AES/CBC/PKCS5Padding/HMAC-SHA2 key length, must be 256, 384 or 512 bits");
            }
            this.macKey = new SecretKeySpec(encoded, 0, 32, "HMACSHA512");
            this.encKey = new SecretKeySpec(encoded, 32, 32, AES256KeyLoader.AES_ALGORITHM);
            this.truncatedMacLength = 32;
        }
    }

    public SecretKey getAESKey() {
        return this.encKey;
    }

    public SecretKey getInputKey() {
        return this.inputKey;
    }

    public SecretKey getMACKey() {
        return this.macKey;
    }

    public int getTruncatedMACByteLength() {
        return this.truncatedMacLength;
    }
}
