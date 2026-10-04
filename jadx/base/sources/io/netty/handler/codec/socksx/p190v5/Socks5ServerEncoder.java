package io.netty.handler.codec.socksx.p190v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class Socks5ServerEncoder extends MessageToByteEncoder<Socks5Message> {
    public static final Socks5ServerEncoder DEFAULT = new Socks5ServerEncoder(Socks5AddressEncoder.DEFAULT);
    private final Socks5AddressEncoder addressEncoder;

    public Socks5ServerEncoder() {
        this(Socks5AddressEncoder.DEFAULT);
    }

    private static void encodeAuthMethodResponse(Socks5InitialResponse socks5InitialResponse, ByteBuf byteBuf) {
        byteBuf.writeByte(socks5InitialResponse.version().byteValue());
        byteBuf.writeByte(socks5InitialResponse.authMethod().byteValue());
    }

    private void encodeCommandResponse(Socks5CommandResponse socks5CommandResponse, ByteBuf byteBuf) {
        byteBuf.writeByte(socks5CommandResponse.version().byteValue());
        byteBuf.writeByte(socks5CommandResponse.status().byteValue());
        byteBuf.writeByte(0);
        Socks5AddressType socks5AddressTypeBndAddrType = socks5CommandResponse.bndAddrType();
        byteBuf.writeByte(socks5AddressTypeBndAddrType.byteValue());
        this.addressEncoder.encodeAddress(socks5AddressTypeBndAddrType, socks5CommandResponse.bndAddr(), byteBuf);
        byteBuf.writeShort(socks5CommandResponse.bndPort());
    }

    private static void encodePasswordAuthResponse(Socks5PasswordAuthResponse socks5PasswordAuthResponse, ByteBuf byteBuf) {
        byteBuf.writeByte(1);
        byteBuf.writeByte(socks5PasswordAuthResponse.status().byteValue());
    }

    public final Socks5AddressEncoder addressEncoder() {
        return this.addressEncoder;
    }

    public Socks5ServerEncoder(Socks5AddressEncoder socks5AddressEncoder) {
        this.addressEncoder = (Socks5AddressEncoder) ObjectUtil.checkNotNull(socks5AddressEncoder, "addressEncoder");
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Socks5Message socks5Message, ByteBuf byteBuf) {
        if (socks5Message instanceof Socks5InitialResponse) {
            encodeAuthMethodResponse((Socks5InitialResponse) socks5Message, byteBuf);
            return;
        }
        if (socks5Message instanceof Socks5PasswordAuthResponse) {
            encodePasswordAuthResponse((Socks5PasswordAuthResponse) socks5Message, byteBuf);
        } else if (socks5Message instanceof Socks5CommandResponse) {
            encodeCommandResponse((Socks5CommandResponse) socks5Message, byteBuf);
        } else {
            throw new EncoderException("unsupported message type: " + StringUtil.simpleClassName(socks5Message));
        }
    }
}
