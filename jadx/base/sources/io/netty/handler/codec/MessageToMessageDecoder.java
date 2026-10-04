package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class MessageToMessageDecoder<I> extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    public MessageToMessageDecoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageDecoder.class, "I");
    }

    public boolean acceptInboundMessage(Object obj) {
        return this.matcher.match(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        CodecOutputList codecOutputListNewInstance = CodecOutputList.newInstance();
        int i = 0;
        try {
            try {
                try {
                    if (acceptInboundMessage(obj)) {
                        try {
                            decode(channelHandlerContext, obj, codecOutputListNewInstance);
                            ReferenceCountUtil.release(obj);
                        } catch (Throwable th) {
                            ReferenceCountUtil.release(obj);
                            throw th;
                        }
                    } else {
                        codecOutputListNewInstance.add(obj);
                    }
                    try {
                        int size = codecOutputListNewInstance.size();
                        while (i < size) {
                            channelHandlerContext.fireChannelRead(codecOutputListNewInstance.getUnsafe(i));
                            i++;
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    try {
                        int size2 = codecOutputListNewInstance.size();
                        while (i < size2) {
                            channelHandlerContext.fireChannelRead(codecOutputListNewInstance.getUnsafe(i));
                            i++;
                        }
                        throw th2;
                    } finally {
                    }
                }
            } catch (Exception e) {
                throw new DecoderException(e);
            }
        } catch (DecoderException e2) {
            throw e2;
        }
    }

    public abstract void decode(ChannelHandlerContext channelHandlerContext, I i, List<Object> list);

    public MessageToMessageDecoder(Class<? extends I> cls) {
        this.matcher = TypeParameterMatcher.get(cls);
    }
}
