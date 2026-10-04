package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
@Deprecated
public class ObjectEncoder extends MessageToByteEncoder<Serializable> {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Serializable serializable, ByteBuf byteBuf) throws Throwable {
        int iWriterIndex = byteBuf.writerIndex();
        ByteBufOutputStream byteBufOutputStream = new ByteBufOutputStream(byteBuf);
        CompactObjectOutputStream compactObjectOutputStream = null;
        try {
            byteBufOutputStream.write(LENGTH_PLACEHOLDER);
            CompactObjectOutputStream compactObjectOutputStream2 = new CompactObjectOutputStream(byteBufOutputStream);
            try {
                compactObjectOutputStream2.writeObject(serializable);
                compactObjectOutputStream2.flush();
                compactObjectOutputStream2.close();
                byteBuf.setInt(iWriterIndex, (byteBuf.writerIndex() - iWriterIndex) - 4);
            } catch (Throwable th) {
                th = th;
                compactObjectOutputStream = compactObjectOutputStream2;
                if (compactObjectOutputStream != null) {
                    compactObjectOutputStream.close();
                } else {
                    byteBufOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
