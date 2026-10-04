package io.netty.handler.codec.protobuf;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class ProtobufDecoder extends MessageToMessageDecoder<ByteBuf> {
    private static final boolean HAS_PARSER;
    private final ExtensionRegistryLite extensionRegistry;
    private final MessageLite prototype;

    static {
        boolean z;
        try {
            MessageLite.class.getDeclaredMethod("getParserForType", null);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        HAS_PARSER = z;
    }

    public ProtobufDecoder(MessageLite messageLite) {
        this(messageLite, (ExtensionRegistry) null);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) {
        decode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public ProtobufDecoder(MessageLite messageLite, ExtensionRegistry extensionRegistry) {
        this(messageLite, (ExtensionRegistryLite) extensionRegistry);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public void decode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        byte[] bytes;
        int iArrayOffset;
        int i = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bytes = byteBuf.array();
            iArrayOffset = byteBuf.readerIndex() + byteBuf.arrayOffset();
        } else {
            bytes = ByteBufUtil.getBytes(byteBuf, byteBuf.readerIndex(), i, false);
            iArrayOffset = 0;
        }
        if (this.extensionRegistry == null) {
            if (HAS_PARSER) {
                list.add(this.prototype.getParserForType().parseFrom(bytes, iArrayOffset, i));
                return;
            } else {
                list.add(this.prototype.newBuilderForType().mergeFrom(bytes, iArrayOffset, i).build());
                return;
            }
        }
        if (HAS_PARSER) {
            list.add(this.prototype.getParserForType().parseFrom(bytes, iArrayOffset, i, this.extensionRegistry));
        } else {
            list.add(this.prototype.newBuilderForType().mergeFrom(bytes, iArrayOffset, i, this.extensionRegistry).build());
        }
    }

    public ProtobufDecoder(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite) {
        this.prototype = ((MessageLite) ObjectUtil.checkNotNull(messageLite, "prototype")).getDefaultInstanceForType();
        this.extensionRegistry = extensionRegistryLite;
    }
}
