package io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class BouncyCastle {
    private static final boolean BOUNCY_CASTLE_ON_CLASSPATH;

    static {
        boolean z;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        BOUNCY_CASTLE_ON_CLASSPATH = z;
    }

    private BouncyCastle() {
    }

    public static boolean isAvailable() {
        return BOUNCY_CASTLE_ON_CLASSPATH;
    }

    public static boolean isInUse(SSLEngine sSLEngine) {
        return sSLEngine.getClass().getPackage().getName().startsWith("org.bouncycastle.jsse.provider");
    }
}
