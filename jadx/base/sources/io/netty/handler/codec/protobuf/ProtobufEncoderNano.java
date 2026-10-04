package io.netty.handler.codec.protobuf;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class ProtobufEncoderNano extends MessageToMessageEncoder<MessageNano> {
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, MessageNano messageNano, List list) {
        encode2(channelHandlerContext, messageNano, (List<Object>) list);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, MessageNano messageNano, List<Object> list) {
        int serializedSize = messageNano.getSerializedSize();
        ByteBuf byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer(serializedSize, serializedSize);
        messageNano.writeTo(CodedOutputByteBufferNano.newInstance(byteBufHeapBuffer.array(), byteBufHeapBuffer.arrayOffset(), byteBufHeapBuffer.capacity()));
        byteBufHeapBuffer.writerIndex(serializedSize);
        list.add(byteBufHeapBuffer);
    }
}
