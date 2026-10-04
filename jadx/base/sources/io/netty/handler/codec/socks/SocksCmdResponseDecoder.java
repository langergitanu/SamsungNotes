package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.NetUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SocksCmdResponseDecoder extends ReplayingDecoder<State> {
    private SocksAddressType addressType;
    private SocksCmdStatus cmdStatus;

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksCmdResponseDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126371 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State */
        static final /* synthetic */ int[] f8916x5919eb68;

        static {
            int[] iArr = new int[State.values().length];
            f8916x5919eb68 = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8916x5919eb68[State.READ_CMD_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8916x5919eb68[State.READ_CMD_ADDRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr2;
            try {
                iArr2[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        CHECK_PROTOCOL_VERSION,
        READ_CMD_HEADER,
        READ_CMD_ADDRESS
    }

    public SocksCmdResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a6  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Throwable {
        int i;
        int i2 = C126371.f8916x5919eb68[state().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new Error();
                }
            }
            i = C126371.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
            if (i != 1) {
                list.add(new SocksCmdResponse(this.cmdStatus, this.addressType, NetUtil.intToIpAddress(byteBuf.readInt()), byteBuf.readUnsignedShort()));
            } else if (i == 2) {
                list.add(new SocksCmdResponse(this.cmdStatus, this.addressType, SocksCommonUtils.readUsAscii(byteBuf, byteBuf.readByte()), byteBuf.readUnsignedShort()));
            } else if (i == 3) {
                byte[] bArr = new byte[16];
                byteBuf.readBytes(bArr);
                list.add(new SocksCmdResponse(this.cmdStatus, this.addressType, SocksCommonUtils.ipv6toStr(bArr), byteBuf.readUnsignedShort()));
            } else {
                if (i != 4) {
                    throw new Error();
                }
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE);
            }
            channelHandlerContext.pipeline().remove(this);
        }
        if (byteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue()) {
            list.add(SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE);
            channelHandlerContext.pipeline().remove(this);
        }
        checkpoint(State.READ_CMD_HEADER);
        this.cmdStatus = SocksCmdStatus.valueOf(byteBuf.readByte());
        byteBuf.skipBytes(1);
        this.addressType = SocksAddressType.valueOf(byteBuf.readByte());
        checkpoint(State.READ_CMD_ADDRESS);
        i = C126371.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i != 1) {
        }
        channelHandlerContext.pipeline().remove(this);
    }
}
