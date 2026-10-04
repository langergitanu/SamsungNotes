package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.jboss.marshalling.Unmarshaller;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class MarshallingDecoder extends LengthFieldBasedFrameDecoder {
    private final UnmarshallerProvider provider;

    public MarshallingDecoder(UnmarshallerProvider unmarshallerProvider) {
        this(unmarshallerProvider, 1048576);
    }

    @Override // io.netty.handler.codec.LengthFieldBasedFrameDecoder
    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        ByteBuf byteBuf2 = (ByteBuf) super.decode(channelHandlerContext, byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        Unmarshaller unmarshaller = this.provider.getUnmarshaller(channelHandlerContext);
        try {
            unmarshaller.start(new ChannelBufferByteInput(byteBuf2));
            Object object = unmarshaller.readObject();
            unmarshaller.finish();
            return object;
        } finally {
            unmarshaller.close();
        }
    }

    @Override // io.netty.handler.codec.LengthFieldBasedFrameDecoder
    public ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, int i2) {
        return byteBuf.slice(i, i2);
    }

    public MarshallingDecoder(UnmarshallerProvider unmarshallerProvider, int i) {
        super(i, 0, 4, 0, 4);
        this.provider = unmarshallerProvider;
    }
}
