package io.netty.channel.socket;

import io.netty.util.NetUtil;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum InternetProtocolFamily {
    IPv4(Inet4Address.class, 1),
    IPv6(Inet6Address.class, 2);

    private final int addressNumber;
    private final Class<? extends InetAddress> addressType;

    /* JADX INFO: renamed from: io.netty.channel.socket.InternetProtocolFamily$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C124661 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$socket$InternetProtocolFamily;

        static {
            int[] iArr = new int[InternetProtocolFamily.values().length];
            $SwitchMap$io$netty$channel$socket$InternetProtocolFamily = iArr;
            try {
                iArr[InternetProtocolFamily.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$socket$InternetProtocolFamily[InternetProtocolFamily.IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    InternetProtocolFamily(Class cls, int i) {
        this.addressType = cls;
        this.addressNumber = i;
    }

    /* JADX INFO: renamed from: of */
    public static InternetProtocolFamily m13769of(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return IPv4;
        }
        if (inetAddress instanceof Inet6Address) {
            return IPv6;
        }
        throw new IllegalArgumentException("address " + inetAddress + " not supported");
    }

    public int addressNumber() {
        return this.addressNumber;
    }

    public Class<? extends InetAddress> addressType() {
        return this.addressType;
    }

    public InetAddress localhost() {
        int i = C124661.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[ordinal()];
        if (i == 1) {
            return NetUtil.LOCALHOST4;
        }
        if (i == 2) {
            return NetUtil.LOCALHOST6;
        }
        throw new IllegalStateException("Unsupported family " + this);
    }
}
