package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class WebSocketUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final FastThreadLocal<MessageDigest> MD5 = new FastThreadLocal<MessageDigest>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketUtil.1
        @Override // io.netty.util.concurrent.FastThreadLocal
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
                throw new InternalError("MD5 not supported on this platform - Outdated?");
            }
        }
    };
    private static final FastThreadLocal<MessageDigest> SHA1 = new FastThreadLocal<MessageDigest>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketUtil.2
        @Override // io.netty.util.concurrent.FastThreadLocal
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("SHA1");
            } catch (NoSuchAlgorithmException unused) {
                throw new InternalError("SHA-1 not supported on this platform - Outdated?");
            }
        }
    };

    private WebSocketUtil() {
    }

    @SuppressJava6Requirement(reason = "Guarded with java version check")
    public static String base64(byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 8) {
            return Base64.getEncoder().encodeToString(bArr);
        }
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(bArr);
        try {
            ByteBuf byteBufEncode = io.netty.handler.codec.base64.Base64.encode(byteBufWrappedBuffer);
            try {
                return byteBufEncode.toString(CharsetUtil.UTF_8);
            } finally {
                byteBufEncode.release();
            }
        } finally {
            byteBufWrappedBuffer.release();
        }
    }

    public static int byteAtIndex(int i, int i2) {
        return (i >> ((3 - i2) * 8)) & 255;
    }

    private static byte[] digest(FastThreadLocal<MessageDigest> fastThreadLocal, byte[] bArr) {
        MessageDigest messageDigest = fastThreadLocal.get();
        messageDigest.reset();
        return messageDigest.digest(bArr);
    }

    public static byte[] md5(byte[] bArr) {
        return digest(MD5, bArr);
    }

    public static byte[] randomBytes(int i) {
        byte[] bArr = new byte[i];
        PlatformDependent.threadLocalRandom().nextBytes(bArr);
        return bArr;
    }

    public static int randomNumber(int i, int i2) {
        return (int) ((PlatformDependent.threadLocalRandom().nextDouble() * ((double) (i2 - i))) + ((double) i));
    }

    public static byte[] sha1(byte[] bArr) {
        return digest(SHA1, bArr);
    }
}
