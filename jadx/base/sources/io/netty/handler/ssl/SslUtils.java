package io.netty.handler.ssl;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;
import io.netty.util.NetUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.KeyManagementException;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import kotlin.UShort;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class SslUtils {
    static final String[] DEFAULT_CIPHER_SUITES;
    static final String[] DEFAULT_TLSV13_CIPHER_SUITES;
    static final int GMSSL_PROTOCOL_VERSION = 257;
    static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
    static final int NOT_ENCRYPTED = -2;
    static final int NOT_ENOUGH_DATA = -1;
    static final int SSL_CONTENT_TYPE_ALERT = 21;
    static final int SSL_CONTENT_TYPE_APPLICATION_DATA = 23;
    static final int SSL_CONTENT_TYPE_CHANGE_CIPHER_SPEC = 20;
    static final int SSL_CONTENT_TYPE_EXTENSION_HEARTBEAT = 24;
    static final int SSL_CONTENT_TYPE_HANDSHAKE = 22;
    static final int SSL_RECORD_HEADER_LENGTH = 5;
    static final String[] TLSV13_CIPHER_SUITES;
    private static final boolean TLSV1_3_JDK_DEFAULT_ENABLED;
    private static final boolean TLSV1_3_JDK_SUPPORTED;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SslUtils.class);
    static final Set<String> TLSV13_CIPHERS = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(Ciphers.TLS_AES_256_GCM_SHA384, Ciphers.TLS_CHACHA20_POLY1305_SHA256, Ciphers.TLS_AES_128_GCM_SHA256, "TLS_AES_128_CCM_8_SHA256", "TLS_AES_128_CCM_SHA256")));

    static {
        String[] strArr = {Ciphers.TLS_AES_128_GCM_SHA256, Ciphers.TLS_AES_256_GCM_SHA384};
        TLSV13_CIPHER_SUITES = strArr;
        boolean zIsTLSv13SupportedByJDK0 = isTLSv13SupportedByJDK0(null);
        TLSV1_3_JDK_SUPPORTED = zIsTLSv13SupportedByJDK0;
        TLSV1_3_JDK_DEFAULT_ENABLED = isTLSv13EnabledByJDK0(null);
        if (zIsTLSv13SupportedByJDK0) {
            DEFAULT_TLSV13_CIPHER_SUITES = strArr;
        } else {
            DEFAULT_TLSV13_CIPHER_SUITES = EmptyArrays.EMPTY_STRINGS;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384);
        linkedHashSet.add(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
        linkedHashSet.add(Ciphers.TLS_RSA_WITH_AES_128_GCM_SHA256);
        linkedHashSet.add(Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA);
        linkedHashSet.add(Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA);
        Collections.addAll(linkedHashSet, DEFAULT_TLSV13_CIPHER_SUITES);
        DEFAULT_CIPHER_SUITES = (String[]) linkedHashSet.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    private SslUtils() {
    }

    public static void addIfSupported(Set<String> set, List<String> list, String... strArr) {
        for (String str : strArr) {
            if (set.contains(str)) {
                list.add(str);
            }
        }
    }

    public static boolean arrayContains(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getEncryptedPacketLength(ByteBuf byteBuf, int i) {
        boolean z;
        int iUnsignedShortBE;
        boolean z2 = false;
        switch (byteBuf.getUnsignedByte(i)) {
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            int i2 = i + 1;
            if (byteBuf.getUnsignedByte(i2) == 3 || byteBuf.getShort(i2) == 257) {
                iUnsignedShortBE = unsignedShortBE(byteBuf, i + 3) + 5;
                if (iUnsignedShortBE > 5) {
                }
            } else {
                iUnsignedShortBE = 0;
            }
            if (!z2) {
                return iUnsignedShortBE;
            }
            int i4 = (byteBuf.getUnsignedByte(i) & 128) != 0 ? 2 : 3;
            short unsignedByte = byteBuf.getUnsignedByte(i + i4 + 1);
            if (unsignedByte != 2 && unsignedByte != 3) {
                return -2;
            }
            int iShortBE = i4 == 2 ? (shortBE(byteBuf, i) & ShortCompanionObject.MAX_VALUE) + 2 : (shortBE(byteBuf, i) & 16383) + 3;
            if (iShortBE <= i4) {
                return -1;
            }
            return iShortBE;
        }
        iUnsignedShortBE = 0;
        z2 = z;
        if (!z2) {
        }
    }

    public static SSLContext getSSLContext(String str) throws KeyManagementException {
        SSLContext sSLContext = StringUtil.isNullOrEmpty(str) ? SSLContext.getInstance(getTlsVersion()) : SSLContext.getInstance(getTlsVersion(), str);
        sSLContext.init(null, new TrustManager[0], null);
        return sSLContext;
    }

    private static String getTlsVersion() {
        return TLSV1_3_JDK_SUPPORTED ? SslProtocols.TLS_v1_3 : SslProtocols.TLS_v1_2;
    }

    public static void handleHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th, boolean z) {
        channelHandlerContext.flush();
        if (z) {
            channelHandlerContext.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(th));
        }
        channelHandlerContext.close();
    }

    public static boolean isTLSv13Cipher(String str) {
        return TLSV13_CIPHERS.contains(str);
    }

    public static boolean isTLSv13EnabledByJDK(Provider provider) {
        return provider == null ? TLSV1_3_JDK_DEFAULT_ENABLED : isTLSv13EnabledByJDK0(provider);
    }

    private static boolean isTLSv13EnabledByJDK0(Provider provider) {
        try {
            return arrayContains(newInitContext(provider).getDefaultSSLParameters().getProtocols(), SslProtocols.TLS_v1_3);
        } catch (Throwable th) {
            logger.debug("Unable to detect if JDK SSLEngine with provider {} enables TLSv1.3 by default, assuming no", provider, th);
            return false;
        }
    }

    public static boolean isTLSv13SupportedByJDK(Provider provider) {
        return provider == null ? TLSV1_3_JDK_SUPPORTED : isTLSv13SupportedByJDK0(provider);
    }

    private static boolean isTLSv13SupportedByJDK0(Provider provider) {
        try {
            return arrayContains(newInitContext(provider).getSupportedSSLParameters().getProtocols(), SslProtocols.TLS_v1_3);
        } catch (Throwable th) {
            logger.debug("Unable to detect if JDK SSLEngine with provider {} supports TLSv1.3, assuming no", provider, th);
            return false;
        }
    }

    public static boolean isValidHostNameForSNI(String str) {
        return (str == null || str.indexOf(46) <= 0 || str.endsWith(Extension.DOT) || str.startsWith("/") || NetUtil.isValidIpV4Address(str) || NetUtil.isValidIpV6Address(str)) ? false : true;
    }

    private static SSLContext newInitContext(Provider provider) throws KeyManagementException {
        SSLContext sSLContext = provider == null ? SSLContext.getInstance("TLS") : SSLContext.getInstance("TLS", provider);
        sSLContext.init(null, new TrustManager[0], null);
        return sSLContext;
    }

    private static short shortBE(ByteBuf byteBuf, int i) {
        short s = byteBuf.getShort(i);
        return byteBuf.order() == ByteOrder.LITTLE_ENDIAN ? Short.reverseBytes(s) : s;
    }

    public static ByteBuf toBase64(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        ByteBuf byteBufEncode = Base64.encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), true, Base64Dialect.STANDARD, byteBufAllocator);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return byteBufEncode;
    }

    public static SSLHandshakeException toSSLHandshakeException(Throwable th) {
        return th instanceof SSLHandshakeException ? (SSLHandshakeException) th : (SSLHandshakeException) new SSLHandshakeException(th.getMessage()).initCause(th);
    }

    private static short unsignedByte(byte b) {
        return (short) (b & 255);
    }

    private static int unsignedShortBE(ByteBuf byteBuf, int i) {
        int unsignedShort = byteBuf.getUnsignedShort(i);
        return byteBuf.order() == ByteOrder.LITTLE_ENDIAN ? Integer.reverseBytes(unsignedShort) >>> 16 : unsignedShort;
    }

    public static void useFallbackCiphersIfDefaultIsEmpty(List<String> list, Iterable<String> iterable) {
        if (list.isEmpty()) {
            for (String str : iterable) {
                if (!str.startsWith("SSL_") && !str.contains("_RC4_")) {
                    list.add(str);
                }
            }
        }
    }

    public static void zeroout(ByteBuf byteBuf) {
        if (byteBuf.isReadOnly()) {
            return;
        }
        byteBuf.setZero(0, byteBuf.capacity());
    }

    public static void zerooutAndRelease(ByteBuf byteBuf) {
        zeroout(byteBuf);
        byteBuf.release();
    }

    private static short shortBE(ByteBuffer byteBuffer, int i) {
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? byteBuffer.getShort(i) : ByteBufUtil.swapShort(byteBuffer.getShort(i));
    }

    private static int unsignedShortBE(ByteBuffer byteBuffer, int i) {
        return shortBE(byteBuffer, i) & UShort.MAX_VALUE;
    }

    public static void useFallbackCiphersIfDefaultIsEmpty(List<String> list, String... strArr) {
        useFallbackCiphersIfDefaultIsEmpty(list, Arrays.asList(strArr));
    }

    public static int getEncryptedPacketLength(ByteBuffer[] byteBufferArr, int i) {
        ByteBuffer byteBuffer = byteBufferArr[i];
        if (byteBuffer.remaining() >= 5) {
            return getEncryptedPacketLength(byteBuffer);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        while (true) {
            int i2 = i + 1;
            ByteBuffer byteBufferDuplicate = byteBufferArr[i].duplicate();
            if (byteBufferDuplicate.remaining() > byteBufferAllocate.remaining()) {
                byteBufferDuplicate.limit(byteBufferAllocate.remaining() + byteBufferDuplicate.position());
            }
            byteBufferAllocate.put(byteBufferDuplicate);
            if (!byteBufferAllocate.hasRemaining()) {
                byteBufferAllocate.flip();
                return getEncryptedPacketLength(byteBufferAllocate);
            }
            i = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int getEncryptedPacketLength(ByteBuffer byteBuffer) {
        boolean z;
        int iUnsignedShortBE;
        int iPosition = byteBuffer.position();
        boolean z2 = false;
        switch (unsignedByte(byteBuffer.get(iPosition))) {
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            int i = iPosition + 1;
            if (unsignedByte(byteBuffer.get(i)) == 3 || byteBuffer.getShort(i) == 257) {
                iUnsignedShortBE = unsignedShortBE(byteBuffer, iPosition + 3) + 5;
                if (iUnsignedShortBE > 5) {
                }
            } else {
                iUnsignedShortBE = 0;
            }
            if (!z2) {
                return iUnsignedShortBE;
            }
            int i2 = (unsignedByte(byteBuffer.get(iPosition)) & 128) != 0 ? 2 : 3;
            short sUnsignedByte = unsignedByte(byteBuffer.get(iPosition + i2 + 1));
            if (sUnsignedByte != 2 && sUnsignedByte != 3) {
                return -2;
            }
            int iShortBE = i2 == 2 ? (shortBE(byteBuffer, iPosition) & ShortCompanionObject.MAX_VALUE) + 2 : (shortBE(byteBuffer, iPosition) & 16383) + 3;
            if (iShortBE <= i2) {
                return -1;
            }
            return iShortBE;
        }
        iUnsignedShortBE = 0;
        z2 = z;
        if (!z2) {
        }
    }
}
