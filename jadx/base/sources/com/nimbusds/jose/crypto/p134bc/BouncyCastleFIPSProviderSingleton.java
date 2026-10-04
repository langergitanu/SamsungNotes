package com.nimbusds.jose.crypto.p134bc;

import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class BouncyCastleFIPSProviderSingleton {
    private static BouncyCastleFipsProvider bouncyCastleFIPSProvider;

    private BouncyCastleFIPSProviderSingleton() {
    }

    public static BouncyCastleFipsProvider getInstance() {
        if (bouncyCastleFIPSProvider == null) {
            bouncyCastleFIPSProvider = new BouncyCastleFipsProvider();
        }
        return bouncyCastleFIPSProvider;
    }
}
