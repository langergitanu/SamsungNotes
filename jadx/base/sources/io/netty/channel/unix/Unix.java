package io.netty.channel.unix;

import io.netty.util.internal.ClassInitializerUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.PortUnreachableException;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Unix {
    private static final AtomicBoolean registered = new AtomicBoolean();

    static {
        ClassInitializerUtil.tryLoadClasses(Unix.class, OutOfMemoryError.class, RuntimeException.class, ClosedChannelException.class, IOException.class, PortUnreachableException.class, DatagramSocketAddress.class, DomainDatagramSocketAddress.class, InetSocketAddress.class);
    }

    private Unix() {
    }

    @Deprecated
    public static void ensureAvailability() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static boolean isAvailable() {
        return false;
    }

    public static synchronized void registerInternal(Runnable runnable) {
        runnable.run();
        Socket.initialize();
    }

    @Deprecated
    public static Throwable unavailabilityCause() {
        return new UnsupportedOperationException();
    }
}
