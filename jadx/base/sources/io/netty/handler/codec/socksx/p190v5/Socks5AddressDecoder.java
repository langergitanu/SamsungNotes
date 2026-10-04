package io.netty.handler.codec.socksx.p190v5;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Socks5AddressDecoder {
    public static final Socks5AddressDecoder DEFAULT = new Socks5AddressDecoder() { // from class: io.netty.handler.codec.socksx.v5.Socks5AddressDecoder.1
        private static final int IPv6_LEN = 16;

        @Override // io.netty.handler.codec.socksx.p190v5.Socks5AddressDecoder
        public String decodeAddress(Socks5AddressType socks5AddressType, ByteBuf byteBuf) {
            if (socks5AddressType == Socks5AddressType.IPv4) {
                return NetUtil.intToIpAddress(byteBuf.readInt());
            }
            if (socks5AddressType == Socks5AddressType.DOMAIN) {
                short unsignedByte = byteBuf.readUnsignedByte();
                String string = byteBuf.toString(byteBuf.readerIndex(), unsignedByte, CharsetUtil.US_ASCII);
                byteBuf.skipBytes(unsignedByte);
                return string;
            }
            if (socks5AddressType != Socks5AddressType.IPv6) {
                throw new DecoderException("unsupported address type: " + (socks5AddressType.byteValue() & 255));
            }
            if (byteBuf.hasArray()) {
                int i = byteBuf.readerIndex();
                byteBuf.readerIndex(i + 16);
                return NetUtil.bytesToIpAddress(byteBuf.array(), byteBuf.arrayOffset() + i, 16);
            }
            byte[] bArr = new byte[16];
            byteBuf.readBytes(bArr);
            return NetUtil.bytesToIpAddress(bArr);
        }
    };

    String decodeAddress(Socks5AddressType socks5AddressType, ByteBuf byteBuf);
}
