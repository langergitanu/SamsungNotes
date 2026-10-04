package io.netty.channel.socket.nio;

import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ProtocolFamily;
import java.nio.channels.Channel;
import java.nio.channels.spi.SelectorProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class SelectorProviderUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SelectorProviderUtil.class);

    private SelectorProviderUtil() {
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static Method findOpenMethod(String str) {
        if (PlatformDependent.javaVersion() < 15) {
            return null;
        }
        try {
            return SelectorProvider.class.getMethod(str, ProtocolFamily.class);
        } catch (Throwable th) {
            logger.debug("SelectorProvider.{}(ProtocolFamily) not available, will use default", str, th);
            return null;
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <C extends Channel> C newChannel(Method method, SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) throws IOException {
        if (internetProtocolFamily == null || method == null) {
            return null;
        }
        try {
            return (C) method.invoke(selectorProvider, ProtocolFamilyConverter.convert(internetProtocolFamily));
        } catch (IllegalAccessException e) {
            throw new IOException(e);
        } catch (InvocationTargetException e2) {
            throw new IOException(e2);
        }
    }
}
