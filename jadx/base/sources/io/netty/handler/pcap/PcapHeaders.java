package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class PcapHeaders {
    private static final byte[] GLOBAL_HEADER = {-95, -78, -61, -44, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 1};

    private PcapHeaders() {
    }

    public static void writeGlobalHeader(OutputStream outputStream) throws IOException {
        outputStream.write(GLOBAL_HEADER);
    }

    public static void writePacketHeader(ByteBuf byteBuf, int i, int i2, int i4, int i5) {
        byteBuf.writeInt(i);
        byteBuf.writeInt(i2);
        byteBuf.writeInt(i4);
        byteBuf.writeInt(i5);
    }
}
