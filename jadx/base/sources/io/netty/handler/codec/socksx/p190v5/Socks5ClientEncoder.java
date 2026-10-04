package io.netty.handler.codec.socksx.p190v5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class Socks5ClientEncoder extends MessageToByteEncoder<Socks5Message> {
    public static final Socks5ClientEncoder DEFAULT = new Socks5ClientEncoder();
    private final Socks5AddressEncoder addressEncoder;

    public Socks5ClientEncoder() {
        this(Socks5AddressEncoder.DEFAULT);
    }

    private static void encodeAuthMethodRequest(Socks5InitialRequest socks5InitialRequest, ByteBuf byteBuf) {
        byteBuf.writeByte(socks5InitialRequest.version().byteValue());
        List<Socks5AuthMethod> listAuthMethods = socks5InitialRequest.authMethods();
        int size = listAuthMethods.size();
        byteBuf.writeByte(size);
        if (!(listAuthMethods instanceof RandomAccess)) {
            Iterator<Socks5AuthMethod> it = listAuthMethods.iterator();
            while (it.hasNext()) {
                byteBuf.writeByte(it.next().byteValue());
            }
        } else {
            for (int i = 0; i < size; i++) {
                byteBuf.writeByte(listAuthMethods.get(i).byteValue());
            }
        }
    }

    private void encodeCommandRequest(Socks5CommandRequest socks5CommandRequest, ByteBuf byteBuf) {
        byteBuf.writeByte(socks5CommandRequest.version().byteValue());
        byteBuf.writeByte(socks5CommandRequest.type().byteValue());
        byteBuf.writeByte(0);
        Socks5AddressType socks5AddressTypeDstAddrType = socks5CommandRequest.dstAddrType();
        byteBuf.writeByte(socks5AddressTypeDstAddrType.byteValue());
        this.addressEncoder.encodeAddress(socks5AddressTypeDstAddrType, socks5CommandRequest.dstAddr(), byteBuf);
        byteBuf.writeShort(socks5CommandRequest.dstPort());
    }

    private static void encodePasswordAuthRequest(Socks5PasswordAuthRequest socks5PasswordAuthRequest, ByteBuf byteBuf) {
        byteBuf.writeByte(1);
        String strUsername = socks5PasswordAuthRequest.username();
        byteBuf.writeByte(strUsername.length());
        ByteBufUtil.writeAscii(byteBuf, strUsername);
        String strPassword = socks5PasswordAuthRequest.password();
        byteBuf.writeByte(strPassword.length());
        ByteBufUtil.writeAscii(byteBuf, strPassword);
    }

    public final Socks5AddressEncoder addressEncoder() {
        return this.addressEncoder;
    }

    public Socks5ClientEncoder(Socks5AddressEncoder socks5AddressEncoder) {
        this.addressEncoder = (Socks5AddressEncoder) ObjectUtil.checkNotNull(socks5AddressEncoder, "addressEncoder");
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Socks5Message socks5Message, ByteBuf byteBuf) {
        if (socks5Message instanceof Socks5InitialRequest) {
            encodeAuthMethodRequest((Socks5InitialRequest) socks5Message, byteBuf);
            return;
        }
        if (socks5Message instanceof Socks5PasswordAuthRequest) {
            encodePasswordAuthRequest((Socks5PasswordAuthRequest) socks5Message, byteBuf);
        } else if (socks5Message instanceof Socks5CommandRequest) {
            encodeCommandRequest((Socks5CommandRequest) socks5Message, byteBuf);
        } else {
            throw new EncoderException("unsupported message type: " + StringUtil.simpleClassName(socks5Message));
        }
    }
}
