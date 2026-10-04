package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ZlibCodecFactory {
    private static final int DEFAULT_JDK_MEM_LEVEL = 8;
    private static final int DEFAULT_JDK_WINDOW_SIZE = 15;
    private static final InternalLogger logger;
    private static final boolean noJdkZlibDecoder;
    private static final boolean noJdkZlibEncoder;
    private static final boolean supportsWindowSizeAndMemLevel;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ZlibCodecFactory.class);
        logger = internalLoggerFactory;
        boolean z = true;
        boolean z2 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibDecoder", PlatformDependent.javaVersion() < 7);
        noJdkZlibDecoder = z2;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibDecoder: {}", Boolean.valueOf(z2));
        boolean z3 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibEncoder", false);
        noJdkZlibEncoder = z3;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibEncoder: {}", Boolean.valueOf(z3));
        if (!z2 && PlatformDependent.javaVersion() < 7) {
            z = false;
        }
        supportsWindowSizeAndMemLevel = z;
    }

    private ZlibCodecFactory() {
    }

    public static boolean isSupportingWindowSizeAndMemLevel() {
        return supportsWindowSizeAndMemLevel;
    }

    public static ZlibDecoder newZlibDecoder() {
        return (PlatformDependent.javaVersion() < 7 || noJdkZlibDecoder) ? new JZlibDecoder() : new JdkZlibDecoder(true);
    }

    public static ZlibEncoder newZlibEncoder(int i) {
        return (PlatformDependent.javaVersion() < 7 || noJdkZlibEncoder) ? new JZlibEncoder(i) : new JdkZlibEncoder(i);
    }

    public static ZlibDecoder newZlibDecoder(ZlibWrapper zlibWrapper) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibDecoder) {
            return new JdkZlibDecoder(zlibWrapper, true);
        }
        return new JZlibDecoder(zlibWrapper);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(zlibWrapper);
        }
        return new JZlibEncoder(zlibWrapper);
    }

    public static ZlibDecoder newZlibDecoder(byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibDecoder) {
            return new JdkZlibDecoder(bArr);
        }
        return new JZlibDecoder(bArr);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper, int i) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(zlibWrapper, i);
        }
        return new JZlibEncoder(zlibWrapper, i);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper, int i, int i2, int i4) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder && i2 == 15 && i4 == 8) {
            return new JdkZlibEncoder(zlibWrapper, i);
        }
        return new JZlibEncoder(zlibWrapper, i, i2, i4);
    }

    public static ZlibEncoder newZlibEncoder(byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(bArr);
        }
        return new JZlibEncoder(bArr);
    }

    public static ZlibEncoder newZlibEncoder(int i, byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(i, bArr);
        }
        return new JZlibEncoder(i, bArr);
    }

    public static ZlibEncoder newZlibEncoder(int i, int i2, int i4, byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder && i2 == 15 && i4 == 8) {
            return new JdkZlibEncoder(i, bArr);
        }
        return new JZlibEncoder(i, i2, i4, bArr);
    }
}
