package com.yubico.yubikit.piv;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum ManagementKeyType {
    TDES((byte) 3, "DESede", 24, 8),
    AES128((byte) 8, AES256KeyLoader.AES_ALGORITHM, 16, 16),
    AES192((byte) 10, AES256KeyLoader.AES_ALGORITHM, 24, 16),
    AES256((byte) 12, AES256KeyLoader.AES_ALGORITHM, 32, 16);

    public final int challengeLength;
    public final String cipherName;
    public final int keyLength;
    public final byte value;

    ManagementKeyType(byte b, String str, int i, int i2) {
        this.value = b;
        this.cipherName = str;
        this.keyLength = i;
        this.challengeLength = i2;
    }

    public static ManagementKeyType fromValue(byte b) {
        for (ManagementKeyType managementKeyType : values()) {
            if (managementKeyType.value == b) {
                return managementKeyType;
            }
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(b, "Not a valid ManagementKeyType:"));
    }
}
