package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.jboss.marshalling.Marshaller;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class MarshallingEncoder extends MessageToByteEncoder<Object> {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
    private final MarshallerProvider provider;

    public MarshallingEncoder(MarshallerProvider marshallerProvider) {
        this.provider = marshallerProvider;
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Object obj, ByteBuf byteBuf) {
        Marshaller marshaller = this.provider.getMarshaller(channelHandlerContext);
        int iWriterIndex = byteBuf.writerIndex();
        byteBuf.writeBytes(LENGTH_PLACEHOLDER);
        marshaller.start(new ChannelBufferByteOutput(byteBuf));
        marshaller.writeObject(obj);
        marshaller.finish();
        marshaller.close();
        byteBuf.setInt(iWriterIndex, (byteBuf.writerIndex() - iWriterIndex) - 4);
    }
}
