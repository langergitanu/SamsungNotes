package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class CleanerJava9 implements Cleaner {
    private static final Method INVOKE_CLEANER;
    private static final InternalLogger logger;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    static {
        Throwable unsupportedOperationException;
        Method method;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) CleanerJava9.class);
        logger = internalLoggerFactory;
        Throwable th = null;
        if (PlatformDependent0.hasUnsafe()) {
            final ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(1);
            Object objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.CleanerJava9.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Unsafe unsafe = PlatformDependent0.UNSAFE;
                        Method declaredMethod = unsafe.getClass().getDeclaredMethod("invokeCleaner", ByteBuffer.class);
                        declaredMethod.invoke(unsafe, byteBufferAllocateDirect);
                        return declaredMethod;
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                        return e;
                    }
                }
            });
            if (!(objDoPrivileged instanceof Throwable)) {
                method = (Method) objDoPrivileged;
                if (th != null) {
                    internalLoggerFactory.debug("java.nio.ByteBuffer.cleaner(): available");
                } else {
                    internalLoggerFactory.debug("java.nio.ByteBuffer.cleaner(): unavailable", th);
                }
                INVOKE_CLEANER = method;
            }
            unsupportedOperationException = (Throwable) objDoPrivileged;
        } else {
            unsupportedOperationException = new UnsupportedOperationException("sun.misc.Unsafe unavailable");
        }
        th = unsupportedOperationException;
        method = null;
        if (th != null) {
        }
        INVOKE_CLEANER = method;
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer byteBuffer) {
        Exception exc = (Exception) AccessController.doPrivileged(new PrivilegedAction<Exception>() { // from class: io.netty.util.internal.CleanerJava9.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Exception run() {
                try {
                    CleanerJava9.INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, byteBuffer);
                    return null;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    return e;
                }
            }
        });
        if (exc != null) {
            PlatformDependent0.throwException(exc);
        }
    }

    public static boolean isSupported() {
        return INVOKE_CLEANER != null;
    }

    @Override // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (System.getSecurityManager() != null) {
            freeDirectBufferPrivileged(byteBuffer);
            return;
        }
        try {
            INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, byteBuffer);
        } catch (Throwable th) {
            PlatformDependent0.throwException(th);
        }
    }
}
