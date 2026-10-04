package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.Brotli4jLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Brotli {
    private static final ClassNotFoundException CNFE;
    private static Throwable cause;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Brotli.class);

    static {
        try {
            Class.forName("com.aayushatharva.brotli4j.Brotli4jLoader", false, PlatformDependent.getClassLoader(Brotli.class));
            e = null;
        } catch (ClassNotFoundException e) {
            e = e;
            logger.debug("brotli4j not in the classpath; Brotli support will be unavailable.");
        }
        CNFE = e;
        if (e == null) {
            Throwable unavailabilityCause = Brotli4jLoader.getUnavailabilityCause();
            cause = unavailabilityCause;
            if (unavailabilityCause != null) {
                logger.debug("Failed to load brotli4j; Brotli support will be unavailable.", unavailabilityCause);
            }
        }
    }

    private Brotli() {
    }

    public static Throwable cause() {
        return cause;
    }

    public static void ensureAvailability() throws ClassNotFoundException {
        ClassNotFoundException classNotFoundException = CNFE;
        if (classNotFoundException != null) {
            throw classNotFoundException;
        }
        Brotli4jLoader.ensureAvailability();
    }

    public static boolean isAvailable() {
        return CNFE == null && Brotli4jLoader.isAvailable();
    }
}
