package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class UDPPacket {
    private static final short UDP_HEADER_SIZE = 8;

    private UDPPacket() {
    }

    public static void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2) {
        byteBuf.writeShort(i);
        byteBuf.writeShort(i2);
        byteBuf.writeShort(byteBuf2.readableBytes() + 8);
        byteBuf.writeShort(1);
        byteBuf.writeBytes(byteBuf2);
    }
}
