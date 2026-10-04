package io.netty.handler.codec.socks;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.IDN;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class SocksCmdRequest extends SocksRequest {
    private final SocksAddressType addressType;
    private final SocksCmdType cmdType;
    private final String host;
    private final int port;

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksCmdRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126341 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;

        static {
            int[] iArr = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr;
            try {
                iArr[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SocksCmdRequest(SocksCmdType socksCmdType, SocksAddressType socksAddressType, String str, int i) {
        super(SocksRequestType.CMD);
        ObjectUtil.checkNotNull(socksCmdType, "cmdType");
        ObjectUtil.checkNotNull(socksAddressType, "addressType");
        ObjectUtil.checkNotNull(str, "host");
        int i2 = C126341.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[socksAddressType.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                String ascii = IDN.toASCII(str);
                if (ascii.length() > 255) {
                    throw new IllegalArgumentException(AbstractC2821a.m2221l(str, " IDN: ", ascii, " exceeds 255 char limit"));
                }
                str = ascii;
            } else if (i2 == 3 && !NetUtil.isValidIpV6Address(str)) {
                throw new IllegalArgumentException(AbstractC0541b.m756B(str, " is not a valid IPv6 address"));
            }
        } else if (!NetUtil.isValidIpV4Address(str)) {
            throw new IllegalArgumentException(AbstractC0541b.m756B(str, " is not a valid IPv4 address"));
        }
        if (i <= 0 || i >= 65536) {
            throw new IllegalArgumentException(AbstractC2322a.m1615e(i, " is not in bounds 0 < x < 65536"));
        }
        this.cmdType = socksCmdType;
        this.addressType = socksAddressType;
        this.host = str;
        this.port = i;
    }

    public SocksAddressType addressType() {
        return this.addressType;
    }

    public SocksCmdType cmdType() {
        return this.cmdType;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.cmdType.byteValue());
        byteBuf.writeByte(0);
        byteBuf.writeByte(this.addressType.byteValue());
        int i = C126341.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i == 1) {
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
            byteBuf.writeShort(this.port);
        } else if (i == 2) {
            byteBuf.writeByte(this.host.length());
            byteBuf.writeCharSequence(this.host, CharsetUtil.US_ASCII);
            byteBuf.writeShort(this.port);
        } else {
            if (i != 3) {
                return;
            }
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
            byteBuf.writeShort(this.port);
        }
    }

    public String host() {
        return this.addressType == SocksAddressType.DOMAIN ? IDN.toUnicode(this.host) : this.host;
    }

    public int port() {
        return this.port;
    }
}
