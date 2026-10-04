package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Conscrypt {
    private static final Method IS_CONSCRYPT_SSLENGINE;

    static {
        Method method;
        if ((PlatformDependent.javaVersion() < 8 || PlatformDependent.javaVersion() >= 15) && !PlatformDependent.isAndroid()) {
            method = null;
        } else {
            try {
                Class.forName("org.conscrypt.OpenSSLProvider", true, PlatformDependent.getClassLoader(ConscryptAlpnSslEngine.class)).newInstance();
                method = Class.forName("org.conscrypt.Conscrypt", true, PlatformDependent.getClassLoader(ConscryptAlpnSslEngine.class)).getMethod("isConscrypt", SSLEngine.class);
            } catch (Throwable unused) {
                method = null;
            }
        }
        IS_CONSCRYPT_SSLENGINE = method;
    }

    private Conscrypt() {
    }

    public static boolean isAvailable() {
        return IS_CONSCRYPT_SSLENGINE != null;
    }

    public static boolean isEngineSupported(SSLEngine sSLEngine) {
        try {
            Method method = IS_CONSCRYPT_SSLENGINE;
            if (method != null) {
                if (((Boolean) method.invoke(null, sSLEngine)).booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (IllegalAccessException unused) {
            return false;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
