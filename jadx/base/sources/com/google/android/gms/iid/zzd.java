package com.google.android.gms.iid;

import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public final class zzd {
    public static KeyPair zzl() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA);
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
