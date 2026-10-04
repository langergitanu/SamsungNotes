package io.netty.handler.codec.socksx.p189v4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.NetUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public final class Socks4ClientEncoder extends MessageToByteEncoder<Socks4CommandRequest> {
    public static final Socks4ClientEncoder INSTANCE = new Socks4ClientEncoder();
    private static final byte[] IPv4_DOMAIN_MARKER = {0, 0, 0, 1};

    private Socks4ClientEncoder() {
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Socks4CommandRequest socks4CommandRequest, ByteBuf byteBuf) {
        byteBuf.writeByte(socks4CommandRequest.version().byteValue());
        byteBuf.writeByte(socks4CommandRequest.type().byteValue());
        byteBuf.writeShort(socks4CommandRequest.dstPort());
        if (NetUtil.isValidIpV4Address(socks4CommandRequest.dstAddr())) {
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(socks4CommandRequest.dstAddr()));
            ByteBufUtil.writeAscii(byteBuf, socks4CommandRequest.userId());
            byteBuf.writeByte(0);
        } else {
            byteBuf.writeBytes(IPv4_DOMAIN_MARKER);
            ByteBufUtil.writeAscii(byteBuf, socks4CommandRequest.userId());
            byteBuf.writeByte(0);
            ByteBufUtil.writeAscii(byteBuf, socks4CommandRequest.dstAddr());
            byteBuf.writeByte(0);
        }
    }
}
