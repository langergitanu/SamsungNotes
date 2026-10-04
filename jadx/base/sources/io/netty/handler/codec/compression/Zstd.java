package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Zstd {
    private static final Throwable cause;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Zstd.class);

    static {
        try {
            Class.forName("com.github.luben.zstd.Zstd", false, PlatformDependent.getClassLoader(Zstd.class));
            e = null;
        } catch (ClassNotFoundException e) {
            e = e;
            logger.debug("zstd-jni not in the classpath; Zstd support will be unavailable.");
        } catch (Throwable th) {
            e = th;
            logger.debug("Failed to load zstd-jni; Zstd support will be unavailable.", (Throwable) e);
        }
        cause = e;
    }

    private Zstd() {
    }

    public static Throwable cause() {
        return cause;
    }

    public static void ensureAvailability() throws Throwable {
        Throwable th = cause;
        if (th != null) {
            throw th;
        }
    }

    public static boolean isAvailable() {
        return cause == null;
    }
}
