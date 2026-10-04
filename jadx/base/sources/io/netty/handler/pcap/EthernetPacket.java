package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class EthernetPacket {

    /* JADX INFO: renamed from: V4 */
    private static final int f8936V4 = 2048;

    /* JADX INFO: renamed from: V6 */
    private static final int f8937V6 = 34525;
    private static final byte[] DUMMY_SOURCE_MAC_ADDRESS = {0, 0, 94, 0, 83, 0};
    private static final byte[] DUMMY_DESTINATION_MAC_ADDRESS = {0, 0, 94, 0, 83, -1};

    private EthernetPacket() {
    }

    public static void writeIPv4(ByteBuf byteBuf, ByteBuf byteBuf2) {
        writePacket(byteBuf, byteBuf2, DUMMY_SOURCE_MAC_ADDRESS, DUMMY_DESTINATION_MAC_ADDRESS, 2048);
    }

    public static void writeIPv6(ByteBuf byteBuf, ByteBuf byteBuf2) {
        writePacket(byteBuf, byteBuf2, DUMMY_SOURCE_MAC_ADDRESS, DUMMY_DESTINATION_MAC_ADDRESS, f8937V6);
    }

    private static void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2, byte[] bArr, byte[] bArr2, int i) {
        byteBuf.writeBytes(bArr2);
        byteBuf.writeBytes(bArr);
        byteBuf.writeShort(i);
        byteBuf.writeBytes(byteBuf2);
    }
}
