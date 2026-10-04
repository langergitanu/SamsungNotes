package io.netty.handler.ssl;

import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum SslProvider {
    JDK,
    OPENSSL,
    OPENSSL_REFCNT;

    /* JADX INFO: renamed from: io.netty.handler.ssl.SslProvider$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C127441 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$SslProvider;

        static {
            int[] iArr = new int[SslProvider.values().length];
            $SwitchMap$io$netty$handler$ssl$SslProvider = iArr;
            try {
                iArr[SslProvider.JDK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL_REFCNT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static boolean isAlpnSupported(SslProvider sslProvider) {
        int i = C127441.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            return JdkAlpnApplicationProtocolNegotiator.isAlpnSupported();
        }
        if (i == 2 || i == 3) {
            return OpenSsl.isAlpnSupported();
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }

    public static boolean isOptionSupported(SslProvider sslProvider, SslContextOption<?> sslContextOption) {
        int i = C127441.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2 || i == 3) {
            return OpenSsl.isOptionSupported(sslContextOption);
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }

    public static boolean isTlsv13EnabledByDefault(SslProvider sslProvider, Provider provider) {
        int i = C127441.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            return SslUtils.isTLSv13EnabledByJDK(provider);
        }
        if (i == 2 || i == 3) {
            return OpenSsl.isTlsv13Supported();
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }

    public static boolean isTlsv13Supported(SslProvider sslProvider) {
        return isTlsv13Supported(sslProvider, null);
    }

    public static boolean isTlsv13Supported(SslProvider sslProvider, Provider provider) {
        int i = C127441.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            return SslUtils.isTLSv13SupportedByJDK(provider);
        }
        if (i == 2 || i == 3) {
            return OpenSsl.isTlsv13Supported();
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }
}
