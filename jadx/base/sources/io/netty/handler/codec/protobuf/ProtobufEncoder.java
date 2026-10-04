package io.netty.handler.codec.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class ProtobufEncoder extends MessageToMessageEncoder<MessageLiteOrBuilder> {
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, MessageLiteOrBuilder messageLiteOrBuilder, List list) {
        encode2(channelHandlerContext, messageLiteOrBuilder, (List<Object>) list);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, MessageLiteOrBuilder messageLiteOrBuilder, List<Object> list) {
        if (messageLiteOrBuilder instanceof MessageLite) {
            list.add(Unpooled.wrappedBuffer(((MessageLite) messageLiteOrBuilder).toByteArray()));
        } else if (messageLiteOrBuilder instanceof MessageLite.Builder) {
            list.add(Unpooled.wrappedBuffer(((MessageLite.Builder) messageLiteOrBuilder).build().toByteArray()));
        }
    }
}
