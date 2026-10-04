package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.PlatformDependent;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class UnixChannelUtil {
    private UnixChannelUtil() {
    }

    public static InetSocketAddress computeRemoteAddr(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        if (inetSocketAddress2 == null) {
            return inetSocketAddress;
        }
        if (PlatformDependent.javaVersion() >= 7) {
            try {
                return new InetSocketAddress(InetAddress.getByAddress(inetSocketAddress.getHostString(), inetSocketAddress2.getAddress().getAddress()), inetSocketAddress2.getPort());
            } catch (UnknownHostException unused) {
            }
        }
        return inetSocketAddress2;
    }

    public static boolean isBufferCopyNeededForWrite(ByteBuf byteBuf) {
        return isBufferCopyNeededForWrite(byteBuf, Limits.IOV_MAX);
    }

    public static boolean isBufferCopyNeededForWrite(ByteBuf byteBuf, int i) {
        if (byteBuf.hasMemoryAddress()) {
            return false;
        }
        return !byteBuf.isDirect() || byteBuf.nioBufferCount() > i;
    }
}
