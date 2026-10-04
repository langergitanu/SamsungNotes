package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.TypeParameterMatcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class MessageToByteEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private final boolean preferDirect;

    public MessageToByteEncoder() {
        this(true);
    }

    public boolean acceptOutboundMessage(Object obj) {
        return this.matcher.match(obj);
    }

    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, I i, boolean z) {
        return z ? channelHandlerContext.alloc().ioBuffer() : channelHandlerContext.alloc().heapBuffer();
    }

    public abstract void encode(ChannelHandlerContext channelHandlerContext, I i, ByteBuf byteBuf);

    public boolean isPreferDirect() {
        return this.preferDirect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        ReferenceCounted referenceCounted = null;
        try {
            try {
                if (!acceptOutboundMessage(obj)) {
                    channelHandlerContext.write(obj, channelPromise);
                    return;
                }
                ByteBuf byteBufAllocateBuffer = allocateBuffer(channelHandlerContext, obj, this.preferDirect);
                try {
                    encode(channelHandlerContext, obj, byteBufAllocateBuffer);
                    ReferenceCountUtil.release(obj);
                    if (byteBufAllocateBuffer.isReadable()) {
                        channelHandlerContext.write(byteBufAllocateBuffer, channelPromise);
                    } else {
                        byteBufAllocateBuffer.release();
                        channelHandlerContext.write(Unpooled.EMPTY_BUFFER, channelPromise);
                    }
                } catch (Throwable th) {
                    ReferenceCountUtil.release(obj);
                    throw th;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    referenceCounted.release();
                }
                throw th2;
            }
        } catch (EncoderException e) {
            throw e;
        } catch (Throwable th3) {
            throw new EncoderException(th3);
        }
    }

    public MessageToByteEncoder(Class<? extends I> cls) {
        this(cls, true);
    }

    public MessageToByteEncoder(boolean z) {
        this.matcher = TypeParameterMatcher.find(this, MessageToByteEncoder.class, "I");
        this.preferDirect = z;
    }

    public MessageToByteEncoder(Class<? extends I> cls, boolean z) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.preferDirect = z;
    }
}
