package com.yubico.yubikit.core.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class RandomUtils {
    private RandomUtils() {
        throw new IllegalStateException();
    }

    public static byte[] getRandomBytes(int i) {
        byte[] bArr = new byte[i];
        try {
            SecureRandom.getInstanceStrong().nextBytes(bArr);
            return bArr;
        } catch (NoSuchMethodError | NoSuchAlgorithmException unused) {
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }
    }
}
